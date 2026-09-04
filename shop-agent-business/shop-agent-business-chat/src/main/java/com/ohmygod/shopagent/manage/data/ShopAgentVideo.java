package com.ohmygod.shopagent.manage.data;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ohmygod.database.data.BaseTableData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("shop_agent_video")
public class ShopAgentVideo extends BaseTableData {

    @TableId(value="id",type = IdType.INPUT)
    private Long id;

    private String videoName;

    private String originalFileName;

    private String mimeType;

    private Long fileSize;

    private Integer storageType;

    private String bucketName;

    private String objectName;

    private String objectUrl;

    private Integer parseStatus;

    private Integer indexStatus;

    private String parseErrorMsg;

    private Long knowledgeBaseId;

    private String knowledgeBaseName;

    private Long currentPlanId;

    private Long lastParseTaskId;

    private Long lastIndexTaskId;

    private Integer resourceType;

    private Integer textTokenCount;

    private Integer visionTokenCount;

    private Integer segmentCount;

    private Integer materialQualityLevel;

    private String transcriptPath;


}
