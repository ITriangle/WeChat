package com.wangl.Controller;

import com.wangl.util.CheckUtil;
import com.wangl.util.MessageUtil;
import com.wangl.util.WeixinUtil;
import org.dom4j.DocumentException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/7.
 */
@WebServlet(urlPatterns="/myServlet/*", description="Servlet的说明:微信认证接口")
public class WeChatServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String signature = req.getParameter("signature");
        String timestamp = req.getParameter("timestamp");
        String nonce = req.getParameter("nonce");
        String echostr = req.getParameter("echostr");

        System.out.println("signature : " + signature);
        System.out.println("timestamp : " + timestamp);
        System.out.println("nonce : " + nonce);
        System.out.println("echostr : " + echostr);

        PrintWriter out = resp.getWriter();
        if(CheckUtil.checkSignature(signature, timestamp, nonce)){
            out.print(echostr);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        try {
            Map<String, String> map = MessageUtil.xmlToMap(req);
            String fromUserName = map.get("FromUserName");
            String toUserName = map.get("ToUserName");
            String msgType = map.get("MsgType");
            String content = map.get("Content");

            String message = null;

            if(MessageUtil.MESSAGE_TEXT.equals(msgType)){
                if("?".equals(content) || "？".equals(content)){
                    message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
                }else if("1".equals(content)){
                    message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.firstMenu());
                }else if("2".equals(content)){
                    message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.secondMenu());
                }else if("3".equals(content)){
                    message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.threeMenu());
                }else if(content.startsWith("翻译")){
                    String word = content.replaceAll("^翻译", "").trim();
                    if("".equals(word)){
                        message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.threeMenu());
                    }else{
                        message = MessageUtil.initText(toUserName, fromUserName, WeixinUtil.translate(word));
                    }
                }else if(content.startsWith("天气")){
                    String word = content.replaceAll("^天气", "").trim();
                    if("".equals(word)){
                        message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.secondMenu());
                    }else{
                        message = MessageUtil.initText(toUserName, fromUserName, WeixinUtil.weather(word));
                    }
                }else {
                    message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
                }
            }else{

                message = MessageUtil.initText(toUserName, fromUserName, MessageUtil.menuText());
            }

            System.out.println(message);

            out.print(message);

        } catch (DocumentException e) {
            e.printStackTrace();
        }finally{
            out.close();
        }
    }
}
