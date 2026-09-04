package com.ohmygod.shopagent.manage.service;

import com.ohmygod.shopagent.manage.data.ShopAgentVideoTaskLog;

public interface VideoTaskLogService {

    ShopAgentVideoTaskLog saveLog(Long taskId,
                                  Long documentId,
                                  Integer stageType,
                                  Integer eventType,
                                  Integer LogLevel,
                                  Integer operatorType,
                                  Long operatorId,
                                  String content,
                                  Object detail);
}
