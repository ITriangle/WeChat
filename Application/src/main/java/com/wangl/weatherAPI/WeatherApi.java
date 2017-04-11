package com.wangl.weatherAPI;

import com.google.gson.Gson;
import com.wangl.weatherAPI.model.NowJosnBean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/7.
 */
public class WeatherApi {
    private String key;

    public WeatherApi(String key){
        this.key = key;
    }

    public String getWeatherResult(String location,String language, String unit){
        Map<String, String> params = buildParams(location, language, unit);
        return com.wangl.weatherAPI.HttpGet.get(WeatherConf.WEATHER_API_NOW, params);
    }

    public NowJosnBean getWeatherBean(String location, String language, String unit){
        String result = getWeatherResult( location, language,  unit);
        NowJosnBean nowJosnBean = null;

        nowJosnBean = new Gson().fromJson(result, NowJosnBean.class);

        return nowJosnBean;
    }

    private Map<String, String> buildParams(String location,String language, String unit) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("location", location);
        params.put("language", language);
        params.put("unit", unit);

        params.put("key", key);

        return params;
    }

}
