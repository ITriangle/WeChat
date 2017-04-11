package com.wangl.trabslateAPI;

/**
 * Created by Administrator on 2017/4/7.
 */
public class Trans_result {
    private String src;

    private String dst;

    public void setSrc(String src){
        this.src = src;
    }
    public String getSrc(){
        return this.src;
    }
    public void setDst(String dst){
        this.dst = dst;
    }
    public String getDst(){
        return this.dst;
    }

    @Override
    public String toString() {
        return "Trans_result{" +
                "src='" + src + '\'' +
                ", dst='" + dst + '\'' +
                '}';
    }
}
