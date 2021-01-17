package com.danny.LearnJava.domain.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import lombok.Data;


@Data
public class ApiBaseResponse<T> implements Serializable {

    private static final int SUCCESS_CODE = 0;

    private static final String SUCCESS_MSG = "SUCCESS";

    private int code = SUCCESS_CODE;

    private String msg = SUCCESS_MSG;

    private T data = null;


    @JsonIgnore
    public boolean isOK() {
        return code == SUCCESS_CODE;
    }

    public static ApiBaseResponse responseOk() {
        return new ApiBaseResponse();
    }

    public static <T> ApiBaseResponse<T>  responseOk(T data) {
        ApiBaseResponse<T> response = new ApiBaseResponse<>();
        response.setData(data);
        return response;
    }

    public static <T> ApiBaseResponse<T> responseFail(int code, String msg) {
        ApiBaseResponse<T> response = new ApiBaseResponse<>();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    public static <T> ApiBaseResponse<T> responseFail(int code, String msg, T data) {
        ApiBaseResponse<T> response = new ApiBaseResponse<>();
        response.setCode(code);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }

}
