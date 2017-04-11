package com.wangl.weatherAPI.model;

import java.util.List;

/**
 * Created by Administrator on 2017/4/8.
 */
public class NowJosnBean {
    private List<Results> results;
    public List<Results> getResults() {
        return results;
    }
    public void setResults(List<Results> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "NowJosnBean{" +
                "results=" + results +
                '}';
    }
}
