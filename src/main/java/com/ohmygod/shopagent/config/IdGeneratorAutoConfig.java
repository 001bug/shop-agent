package com.ohmygod.shopagent.config;

import com.ohmygod.shopagent.toolkit.SnowflakeIdGenerator;
import com.ohmygod.shopagent.toolkit.WorkAndDataCenterIdHandler;
import com.ohmygod.shopagent.toolkit.WorkDataCenterId;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

@AutoConfiguration
@ConditionalOnProperty(prefix = "shop.framework.id-generator", name = "enabled", havingValue = "true")
public class IdGeneratorAutoConfig {

    @Bean
    public WorkAndDataCenterIdHandler workAndDataCenterIdHandler(StringRedisTemplate stringRedisTemplate){
        return new WorkAndDataCenterIdHandler(stringRedisTemplate);
    }

    @Bean
    public WorkDataCenterId workDataCenterId(WorkAndDataCenterIdHandler workAndDataCenterIdHandler){
        return workAndDataCenterIdHandler.getWorkAndDataCenterId();
    }

    @Bean
    public SnowflakeIdGenerator snowflakeIdGenerator(WorkDataCenterId workDataCenterId){
        return new SnowflakeIdGenerator(workDataCenterId);
    }
}
