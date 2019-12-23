package com.fuke.domain;

import lombok.Data;

@Data
public class JsonResult {

    private Boolean success;
    private String msg;

    public JsonResult(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }
}
