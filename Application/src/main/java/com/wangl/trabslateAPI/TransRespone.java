package com.wangl.trabslateAPI;

import java.util.List;

/**
 * Created by Administrator on 2017/4/7.
 */
public class TransRespone {
    private String from;

    private String to;

    private List<Trans_result> trans_result ;

    public void setFrom(String from){
        this.from = from;
    }
    public String getFrom(){
        return this.from;
    }
    public void setTo(String to){
        this.to = to;
    }
    public String getTo(){
        return this.to;
    }
    public void setTrans_result(List<Trans_result> trans_result){
        this.trans_result = trans_result;
    }
    public List<Trans_result> getTrans_result(){
        return this.trans_result;
    }

    @Override
    public String toString() {
        return "TransRespone{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", trans_result=" + trans_result +
                '}';
    }
}
