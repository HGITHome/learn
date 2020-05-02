package com.learn.api.rest;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回前端的封装dto
 * @param <T>
 */
public class RestResponse<T> implements Serializable {

    public static final String SUCC_CODE = "0";
    public static final String SUCC_MSG = "success";
    public static final String DEFAULT_ERR_CODE = "500";
    public static final String DEFAULT_ERR_MSG = "fail";
    private String resultCode;
    private String resultMsg;
    private T data;
    public static final RestResponse<String> SUCCEED = new RestResponse("0", "success");

    public static final RestResponse<String> FAILED = new RestResponse("500", "fail");
    public static final RestResponse<Void> VOID = new RestResponse((Object)null);
    public static final RestResponse<Boolean> TRUE;
    public static final RestResponse<Boolean> FALSE;

    public RestResponse() {
        this((T)null);
    }

    public RestResponse(T data) {
        this.resultCode = "0";
        this.resultMsg = "success";
        this.data = data;
    }

    public RestResponse(String resultCode, String resutMessage) {
        this.resultCode = resultCode;
        this.resultMsg = resutMessage;
    }

    public RestResponse(String resultCode, String resutMsg, T data) {
        this.resultCode = resultCode;
        this.resultMsg = resutMsg;
        this.data = data;
    }

    public static RestResponse<Long> createLong(Long value) {
        return new RestResponse(value);
    }

    public static RestResponse<Short> createShort(Short value) {
        return new RestResponse(value);
    }

    public static RestResponse<Integer> createInteger(Integer value) {
        return new RestResponse(value);
    }

    public static RestResponse<Float> createFloat(Float value) {
        return new RestResponse(value);
    }

    public static RestResponse<Double> createDouble(Double value) {
        return new RestResponse(value);
    }

    public static RestResponse<BigDecimal> createBigDecimal(BigDecimal value) {
        return new RestResponse(value);
    }

    public static RestResponse<Object> createObject(Object obj) {
        return new RestResponse(obj);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return this.resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap();
        map.put("resultCode", this.resultCode);
        map.put("resultMsg", this.resultMsg);
        map.put("data", this.data);
        return map;
    }

    public String toString() {
        return "RestResponse [resultCode=" + this.resultCode + ", resultMsg=" + this.resultMsg + ", data=" + this.data + "]";
    }

    static {
        TRUE = new RestResponse("0", "success", Boolean.TRUE);
        FALSE = new RestResponse("500", "fail", Boolean.FALSE);
    }
}
