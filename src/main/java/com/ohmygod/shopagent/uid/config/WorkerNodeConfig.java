package com.ohmygod.shopagent.uid.config;

import com.ohmygod.shopagent.uid.UidGenerator;
import com.ohmygod.shopagent.uid.impl.CachedUidGenerator;
import com.ohmygod.shopagent.uid.worker.WorkerIdAssigner;
import com.ohmygod.shopagent.toolkit.SnowflakeIdGenerator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnBean(WorkerIdAssigner.class)
@ConditionalOnProperty(prefix = "shop.framework.id-generator", name = "enabled", havingValue = "true")
public class WorkerNodeConfig {

    @Bean("cachedUidGenerator")
    public UidGenerator uidGenerator(WorkerIdAssigner disposableWorkerIdAssigner, SnowflakeIdGenerator snowflakeIdGenerator){
        CachedUidGenerator cachedUidGenerator = new CachedUidGenerator();
        cachedUidGenerator.setWorkerIdAssigner(disposableWorkerIdAssigner);
        cachedUidGenerator.setSnowflakeIdGenerator(snowflakeIdGenerator);
        return cachedUidGenerator;
    }
}
