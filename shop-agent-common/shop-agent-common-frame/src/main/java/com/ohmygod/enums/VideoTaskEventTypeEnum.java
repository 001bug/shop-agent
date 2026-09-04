package com.ohmygod.enums;

public enum VideoTaskEventTypeEnum {
    //通用任务生命周期
    START(1,"开始"),
    COMPLETE(2,"完成"),
    FAILED(3,"失败"),
    RETRY(4,"重试"),
    CANCELED(5,"已取消"),

    MATERIAL_GRADED(10, "素材评级完成"),
    SEGMENTS_GENERATED(11, "视频片段生成完成"),
    INDEX_PUBLISHED(12, "片段索引生成完成"),
    INDEX_ROLLBACK(13, "片段索引已回滚"),

    // 剪辑规划与人工工作台：20 ~ 29
    EDIT_PLAN_GENERATED(20, "剪辑方案生成完成"),
    USER_ADJUSTED(21, "用户调整剪辑方案"),
    USER_CONFIRMED(22, "用户确认剪辑方案"),

    // 渲染与审核：30 ~ 39
    RENDER_BATCH_CREATED(30, "批量渲染任务已创建"),
    RENDER_OUTPUT_GENERATED(31, "渲染成片已生成"),
    SUBMITTED_FOR_REVIEW(32, "已提交人工审核"),
    REVIEW_APPROVED(33, "人工审核通过"),
    REVIEW_REJECTED(34, "人工审核驳回");

    private final Integer code;
    private final String msg;
    VideoTaskEventTypeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static VideoTaskEventTypeEnum getRc(Integer code) {
        if (code == null) {
            return null;
        }
        for (VideoTaskEventTypeEnum item : values()) {
            if (item.code.equals(code)) {
                return item;
            }
        }
        return null;
    }
}
