package com.wangl.Controller.model;

/**
 * Created by Administrator on 2017/4/7.
 */
public class TextMessage extends BaseMessage{

    private String Content;
    private String MsgId;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }
}
