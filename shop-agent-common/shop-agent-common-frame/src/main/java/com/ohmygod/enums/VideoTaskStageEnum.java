package com.ohmygod.enums;

public enum VideoTaskStageEnum {
    VIDEO_UPLOAD(1,"视频上传"),
    CONTENT_PARSE(2,"内容解析"),
    ASR(3,"语音识别"),
    OCR(4,"文字识别"),
    VISION_ANALYSIS(5,"视觉理解"),
    SEGMENT(6,"视频切片"),
    VECTORIZE(7,"向量化"),
    STORE_COMPLETE(8,"入库完成"),
    KEYWORD_INDEX(9,"关键词索引");

    private final Integer code;

    private final String msg;

    VideoTaskStageEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg == null ? "" : msg;
    }

    public static VideoTaskStageEnum getRc(Integer code) {
        for (VideoTaskStageEnum item : VideoTaskStageEnum.values()) {
            if (item.code.intValue() == code.intValue()) {
                return item;
            }
        }
        return null;
    }
}
