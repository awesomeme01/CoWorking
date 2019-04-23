package com.example.demo.model;

public class Response {
    private Boolean isSuccess;
    private String message;
    private Object object;

    public Response() {
    }

    public Response(Boolean isSuccess, String message, Object object) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.object = object;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
