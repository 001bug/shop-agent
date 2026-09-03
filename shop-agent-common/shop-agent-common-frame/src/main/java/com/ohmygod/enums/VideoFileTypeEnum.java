package com.ohmygod.enums;

import static cn.hutool.core.io.FileMagicNumber.MP4;

public enum VideoFileTypeEnum {
    MP4(1,"MP4");
    private final Integer code;
    private final String msg;



    VideoFileTypeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg == null ? "" : msg;
    }

    public static VideoFileTypeEnum getRc(Integer code) {
        for (VideoFileTypeEnum item : VideoFileTypeEnum.values()) {
            if (item.code.intValue() == code.intValue()) {
                return item;
            }
        }
        return null;
    }

    public static VideoFileTypeEnum fromFileName(String fileName) {
        if (fileName == null || !fileName.contains(".")) {
            return null;
        }
        String suffix = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
        return switch (suffix) {
            case "MP4" -> MP4;
            default -> null;
        };
    }
}
