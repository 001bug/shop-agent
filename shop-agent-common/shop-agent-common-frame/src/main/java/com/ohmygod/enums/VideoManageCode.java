package com.ohmygod.enums;

public enum VideoManageCode {
    EMPTY_VIDEO_CONTENT(20003,"视频内容不能为空"),
    VIDEO_STORAGE_FAILED(200010,"视频存储失败"),
    UNSUPPORTED_VIDEO_TYPE(20002,"视频类型不能为空");

    private final Integer code;
    private final String msg;
    VideoManageCode(Integer code , String msg){
        this.code=code;
        this.msg=msg;
    }
    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg == null ? "" : msg;
    }

    public static String getMsg(Integer code) {
        for (VideoManageCode item : VideoManageCode.values()) {
            if (item.code.intValue() == code.intValue()) {
                return item.msg;
            }
        }
        return "";
    }

    public static VideoManageCode getRc(Integer code) {
        for (VideoManageCode item : VideoManageCode.values()) {
            if (item.code.intValue() == code.intValue()) {
                return item;
            }
        }
        return null;
    }
}
