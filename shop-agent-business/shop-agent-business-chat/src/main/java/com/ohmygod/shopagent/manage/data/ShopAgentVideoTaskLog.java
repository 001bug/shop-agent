package com.ohmygod.shopagent.manage.data;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ohmygod.database.data.BaseTableData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("shop_agent_video_task_log")
@EqualsAndHashCode(callSuper = true)
public class ShopAgentVideoTaskLog extends BaseTableData {
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    private Long taskId;

    private Long videoId;

    private Integer stageType;

    private Integer eventType;

    private Integer logLevel;

    private Integer operatorType;

    private Long operatorId;

    private String content;

    private String detailJson;
}
