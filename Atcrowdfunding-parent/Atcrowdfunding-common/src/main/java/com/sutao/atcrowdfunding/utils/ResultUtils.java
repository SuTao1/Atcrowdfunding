package com.sutao.atcrowdfunding.utils;

public class ResultUtils {

    private String message;
    private Integer keyCode;
    private Object data;
    private Boolean state;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(Integer keyCode) {
        this.keyCode = keyCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public ResultUtils(String message, Integer keyCode, Object data, Boolean state) {
        this.message = message;
        this.keyCode = keyCode;
        this.data = data;
        this.state = state;
    }
    public ResultUtils(){
        super();
    }
}
