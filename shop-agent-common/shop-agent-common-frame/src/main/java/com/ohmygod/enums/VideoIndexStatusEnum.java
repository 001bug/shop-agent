package com.ohmygod.enums;

public enum VideoIndexStatusEnum {
    WAIT_BUILD(1,"待处理"),
    BUILDING(2,"构建中"),
    BUILD_SUCCESS(3,"构建成功"),
    BUILD_FAILED(4,"构建失败");

    private final Integer code;
    private final String msg;

    VideoIndexStatusEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode(){
        return code;
    }

    public String getMsg(){return msg == null ? "" : msg;}

    public static VideoIndexStatusEnum getRc(Integer code) {
        for (VideoIndexStatusEnum item : VideoIndexStatusEnum.values()) {
            if (item.code.intValue() == code.intValue()) {
                return item;
            }
        }
        return null;
    }
}
