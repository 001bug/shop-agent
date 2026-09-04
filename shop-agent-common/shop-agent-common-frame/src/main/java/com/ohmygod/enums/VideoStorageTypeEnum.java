package com.ohmygod.enums;

public enum VideoStorageTypeEnum {
    MINIO(1,"MinIO");

    private final Integer code;

    private final String msg;

    VideoStorageTypeEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg == null ? "" : msg;
    }

    public static VideoStorageTypeEnum getRc(Integer code) {
        for (VideoStorageTypeEnum item : VideoStorageTypeEnum.values()) {
            if (item.code.intValue() == code.intValue()) {
                return item;
            }
        }
        return null;
    }
}
