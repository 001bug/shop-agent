package com.ohmygod.shopagent.manage.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohmygod.enums.BusinessStatus;
import com.ohmygod.shopagent.manage.data.ShopAgentVideoTaskLog;
import com.ohmygod.shopagent.manage.service.VideoTaskLogService;
import com.ohmygod.shopagent.uid.UidGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class VideoTaskLogServiceImpl implements VideoTaskLogService {
    private final UidGenerator uidGenerator;
    private final ObjectMapper objectMapper;
    @Override
    public ShopAgentVideoTaskLog saveLog(Long taskId,
                                         Long VideoId,
                                         Integer stageType,
                                         Integer eventType,
                                         Integer logLevel,
                                         Integer operatorType, Long operatorId, String content, Object detail) {
        ShopAgentVideoTaskLog log = new ShopAgentVideoTaskLog();
        log.setId(uidGenerator.getUid());
        log.setTaskId(taskId);
        log.setVideoId(VideoId);
        log.setStageType(stageType);
        log.setEventType(eventType);
        log.setLogLevel(logLevel);
        log.setOperatorType(operatorType);
        log.setOperatorId(operatorId);
        log.setContent(content);
        log.setDetailJson(toJson(detail));
        log.setStatus(BusinessStatus.YES.getCode());
        return null;
    }
    private String toJson(Object detail){
        if(detail==null){
            return null;
        }
        try{
            return objectMapper.writeValueAsString(detail);
        } catch (JsonProcessingException exception){
            return String.valueOf(detail);
        }
    }
}
