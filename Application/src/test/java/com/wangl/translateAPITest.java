package com.wangl;

import com.wangl.trabslateAPI.TransApi;
import com.wangl.trabslateAPI.TransConf;
import com.wangl.trabslateAPI.TransRespone;
import com.wangl.weatherAPI.WeatherApi;
import com.wangl.weatherAPI.WeatherConf;
import com.wangl.weatherAPI.model.NowJosnBean;
import com.wangl.weatherAPI.model.Results;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.util.List;

/**
 * Created by Administrator on 2017/4/7.
 */
public class translateAPITest {

    @Test
    public void test1(){
        TransApi api = new TransApi(TransConf.APP_ID, TransConf.SECURITY_KEY);

        String query = "高度600米";

        String result = api.getTransResult(query, "auto", "auto");


        TransRespone transResopne = (TransRespone) JSONObject.toBean(JSONObject.fromObject(result),TransRespone.class);

        System.out.println(transResopne.toString());

        System.out.println(api.getTransResult(query, "auto", "auto"));
    }

    @Test
    public void test2(){
        WeatherApi api = new WeatherApi(WeatherConf.USER_KEY);

//        NowJosnBean nowJosnBean = api.getWeatherBean("北京", "zh-Hans", "c");

        NowJosnBean nowJosnBean = api.getWeatherBean("beijing", "zh-Hans", "c");

        List<Results> beanList = nowJosnBean.getResults();

        System.out.println("天气: " + beanList.get(0).getNow().getText());
        System.out.println("温度: " + beanList.get(0).getNow().getTemperature());
    }


}
