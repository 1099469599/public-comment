package com.cheng.dto;

import com.cheng.constant.ApiCodeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Api会员验证相关dto
 * Created by cheng on 2017/7/22.
 */
@JsonInclude(Include.NON_NULL)
public class ApiCodeDto {

    /**
     * 错误key值
     */
    private Integer errno;
    /**
     * 错误信息
     */
    private String msg;

    private String token;

    private String code;

    public ApiCodeDto() {

    }

    public ApiCodeDto(ApiCodeEnum apiCodeEnum) {
        this.errno = apiCodeEnum.getErrno();
        this.msg = apiCodeEnum.getMsg();
    }

    public ApiCodeDto(ApiCodeEnum apiCodeEnum, String code) {
        this.errno = apiCodeEnum.getErrno();
        this.msg = apiCodeEnum.getMsg();
        this.code = code;
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
