package com.ohmygod.enums;

public enum VideoTaskTypeEnum {
    DOWNLOAD(1,  "下载"),
    UNDERSTAND(2,  "理解"),
    SEGMENT(3,  "切片"),
    INDEX(4,  "构建向量索引"),
    RENDER(5,  "渲染");

    /**
     * 数据库存储值
     */
    private final Integer code;
    /**
     * 中文描述
     */
    private final String msg;
    VideoTaskTypeEnum(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg == null ? "" : msg;
    }

    public static VideoTaskTypeEnum getRc(Integer code) {
        for (VideoTaskTypeEnum item : VideoTaskTypeEnum.values()) {
            if (item.code.intValue() == code.intValue()) {
                return item;
            }
        }
        return null;
    }
}
