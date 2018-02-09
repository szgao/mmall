package com.gaochao.mmall.common;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * Created by gaochao on 2018/2/9.
 */
@JsonSerialize(include =  JsonSerialize.Inclusion.NON_NULL)
//保证序列化json的时候,如果是null的对象,key也会消失
public class ServerResponse<T> implements Serializable {

    private int status;
    private String message;
    private T data;

    private ServerResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    private ServerResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    private ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public ServerResponse(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static <T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(MessageCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String message){
        return new ServerResponse<T>(MessageCode.SUCCESS.getCode(),message);
    }

    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(MessageCode.SUCCESS.getCode(),data);
    }

    public static <T> ServerResponse<T> createBySuccess(String message,T data){
        return new ServerResponse<T>(MessageCode.SUCCESS.getCode(),message,data);
    }

    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(MessageCode.ERROR.getCode(),MessageCode.ERROR.getDesc());
    }

    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage){
        return new ServerResponse<T>(MessageCode.ERROR.getCode(),errorMessage);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode,String errorMessage){
        return new ServerResponse<T>(errorCode,errorMessage);
    }
}
