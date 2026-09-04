package com.ohmygod.enums;

public enum VideoTriggerSourceEnum {

    SYSTEM(1, "系统自动"),
    USER(2, "用户手动");

    private final Integer code;
    private final String msg;

    VideoTriggerSourceEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg == null ? "" : msg;
    }

    public static VideoTriggerSourceEnum getRc(Integer code) {
        for (VideoTriggerSourceEnum item : VideoTriggerSourceEnum.values()) {
            if (item.code.intValue() == code.intValue()) {
                return item;
            }
        }
        return null;
    }
}
