package com.wangl.util;

import com.wangl.trabslateAPI.TransConf;
import com.wangl.trabslateAPI.TransApi;
import com.wangl.weatherAPI.WeatherApi;
import com.wangl.weatherAPI.WeatherConf;
import com.wangl.weatherAPI.model.NowJosnBean;
import com.wangl.weatherAPI.model.Results;

import java.util.List;

/**
 * Created by Administrator on 2017/4/7.
 */
public class WeixinUtil {
    private static final String APPID = "你的ID";
    private static final String APPSECRET = "你的secret";

    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    private static final String UPLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";

    private static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    private static final String QUERY_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";

    private static final String DELETE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";

    public static String translate(String source){
        TransApi api = new TransApi(TransConf.APP_ID, TransConf.SECURITY_KEY);
        String jsonReslut = api.getTransResult(source, "auto", "en");

        int index_start = jsonReslut.indexOf("dst") + 6;

        int index_end = jsonReslut.lastIndexOf("\"}]}");

        return jsonReslut.substring(index_start, index_end);
    }

    public static String weather(String source){
        WeatherApi api = new WeatherApi(WeatherConf.USER_KEY);

        NowJosnBean nowJosnBean = api.getWeatherBean(source, "zh-Hans", "c");

        List<Results> beanList = nowJosnBean.getResults();

        StringBuffer result = new StringBuffer();

        String str1 = "天气: " + beanList.get(0).getNow().getText() + "\n";
        result.append( str1 );
        String str2 = "温度: " + beanList.get(0).getNow().getTemperature() + "°C";
        result.append( str2 );


        System.out.println("天气: " + beanList.get(0).getNow().getText());
        System.out.println("温度: " + beanList.get(0).getNow().getTemperature());

        return result.toString();
//        WeatherApi api = new WeatherApi(WeatherConf.USER_KEY);
//
//        NowJosnBean nowJosnBean = api.getWeatherBean(source, "zh-Hans", "c");
//
//        List<Results> beanList = nowJosnBean.getResults();
//
//        System.out.println("天气: " + beanList.get(0).getNow().getText());
//        System.out.println("温度: " + beanList.get(0).getNow().getTemperature());
//
//        return "天气: " + beanList.get(0).getNow().getText() + "\n温度: " + beanList.get(0).getNow().getTemperature();
    }

}
