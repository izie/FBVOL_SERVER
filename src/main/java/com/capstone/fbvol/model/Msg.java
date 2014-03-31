package com.capstone.fbvol.model;

/**
 * Created by changmatthew on 2014. 3. 31..
 */
public class Msg {
    private String code;
    private String msg;

    public Msg(){

    }

    public Msg(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
