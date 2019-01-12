package com.linkingwin.education.studyonline.common.http;

import com.alibaba.fastjson.JSONObject;

import org.xutils.http.annotation.HttpResponse;

/**
* @描述 接口请求服务器返回对象
* @作者 gsh
* @时间 2017/4/2 10:12
*/
@HttpResponse(parser = JsonResponseParser.class)
public class JsonResponse {

    private String state;

    private String errCode;

    private String errMsg;

    private String exceptionDetails;

    private String exceptionStackTrace;

    private JSONObject resultMap;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getExceptionDetails() {
        return exceptionDetails;
    }

    public void setExceptionDetails(String exceptionDetails) {
        this.exceptionDetails = exceptionDetails;
    }

    public String getExceptionStackTrace() {
        return exceptionStackTrace;
    }

    public void setExceptionStackTrace(String exceptionStackTrace) {
        this.exceptionStackTrace = exceptionStackTrace;
    }

    public JSONObject getResultMap() {
        return resultMap;
    }

    public void setResultMap(JSONObject resultMap) {
        this.resultMap = resultMap;
    }

    @Override
    public String toString() {
        return "JsonResponse{" +
                "state='" + state + '\'' +
                ", errCode='" + errCode + '\'' +
                ", errMsg='" + errMsg + '\'' +
                ", exceptionDetails='" + exceptionDetails + '\'' +
                ", exceptionStackTrace='" + exceptionStackTrace + '\'' +
                ", resultMap=" + resultMap +
                '}';
    }
}
