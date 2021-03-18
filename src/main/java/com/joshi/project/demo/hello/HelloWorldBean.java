package com.joshi.project.demo.hello;

public class HelloWorldBean {

    String message;

    public HelloWorldBean(String message){
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("HelloWorldBean[message=%s]",message);
    }
}
