package com.sutao.atcrowdfunding.utils;

public class AjaxResult {

    private Boolean success;
    private String message;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AjaxResult(Boolean success, String message){
        super();
        this.success = success;
        this.message = message;
    }

    public AjaxResult(){
        super();
    }
}
