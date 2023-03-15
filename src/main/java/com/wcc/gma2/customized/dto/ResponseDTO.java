package com.wcc.gma2.customized.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wcc.gma2.customized.type.BasicStatusCode;
import com.wcc.gma2.customized.type.StatusCode;
import java.io.Serializable;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDTO<T> implements Serializable {

    private String code;

    private String msg;

    T content;

    public ResponseDTO() {
        this.setStatusCode(StatusCode.FAIL);
    }

    public ResponseDTO(BasicStatusCode statusCode) {
        this.setStatusCode(statusCode);
    }

    public ResponseDTO(T content) {
        this.content = content;
        this.setStatusCode(StatusCode.SUCCESS);
    }

    public ResponseDTO(T content, BasicStatusCode statusCode) {
        this.content = content;
        this.setStatusCode(statusCode);
    }

    public ResponseDTO(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    public void setStatusCode(BasicStatusCode statusCode) {
        if (statusCode != null) {
            this.msg = statusCode.getMsg();
            this.code = statusCode.getCode();
        }
    }
}
