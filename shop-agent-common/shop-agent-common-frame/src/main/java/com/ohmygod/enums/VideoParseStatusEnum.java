package com.ohmygod.enums;

public enum VideoParseStatusEnum {
    WAIT_PARSE(1,"待解析"),
    PARSING(2,"解析中"),
    PARSE_SUCCESS(3,"解析成功"),
    PARSE_FAILED(4,"解析失败");

    private final Integer code;
    private final String msg;

    VideoParseStatusEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
    public Integer getCode() {
        return code;
    }
    public String getMsg() {
        return msg == null ? "" : msg;
    }

    public static VideoParseStatusEnum getRc(Integer code) {
        for (VideoParseStatusEnum item : VideoParseStatusEnum.values()) {
            if (item.code.intValue() == code.intValue()) {
                return item;
            }
        }
        return null;
    }
}
