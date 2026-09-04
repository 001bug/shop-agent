package com.ohmygod.enums;

public enum VideoOperatorTypeEnum {
    SYSTEM(1,"系统"),
    USER(2,"用户"),
    ADMIN(3, "管理员");

    private final Integer code;

    private final String msg;

    VideoOperatorTypeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg == null ? "" : msg;
    }

    public static VideoOperatorTypeEnum getRc(Integer code) {
        for (VideoOperatorTypeEnum item : VideoOperatorTypeEnum.values()) {
            if (item.code.intValue() == code.intValue()) {
                return item;
            }
        }
        return null;
    }
}
