package com.cutanddry.qa.utils.aio.core.rest;

import io.restassured.http.Method;

public class RestAPIDetail {
    private Method method;
    private String path;
    private String body;

    RestAPIDetail(String path) {
        this.method = Method.GET;
        this.path = path;
    }

    RestAPIDetail(Method method, String path) {
        this.method = method;
        this.path = path;
    }

    RestAPIDetail(String path, String body) {
        this.method = Method.POST;
        this.path = path;
        this.body = body;
    }

    RestAPIDetail(Method method, String path, String body) {
        this.method = method;
        this.path = path;
        this.body = body;
    }

    Method getMethod() {
        return method;
    }

    String getPath() {
        return path;
    }

    String getBody() {
        return body;
    }
}
