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
@TableName("shop_agent_video_task")
@EqualsAndHashCode(callSuper = true)
public class ShopAgentVideoTask extends BaseTableData {

    @TableId(value = "id",type= IdType.INPUT)
    private Long id;

    private Long videoId;

    private Long planId;

    private Long sourceParseTaskId;

    private Integer taskType;

    private Integer taskStatus;

    private Integer currentStage;

    private Integer triggerSource;

    private Integer retryCount;
}
