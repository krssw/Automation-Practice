package model.enums;

import lombok.Getter;

@Getter
public enum StatusCode {
    CODE_200(200, ""),
    CODE_201(202, "");

    public final int code;
    public final String msg;

    StatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
