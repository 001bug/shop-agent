package com.ohmygod.shopagent.uid.config;

import com.ohmygod.shopagent.uid.worker.WorkerIdAssigner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration(proxyBeanMethods = false)
@ConditionalOnProperty(prefix = "shop.framework.id-generator", name = "enabled", havingValue = "true")
public class IdGeneratorRedisConfig {

    @Bean("idGeneratorRedisTemplate")
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setDefaultSerializer(new StringRedisSerializer());
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    @Bean("disposableWorkerIdAssigner")
    public WorkerIdAssigner redisDisposableWorkerIdAssigner(@Qualifier("idGeneratorRedisTemplate") RedisTemplate redisTemplate){
        RedisDisposableWorkerIdAssigner redisDisposableWorkerIdAssigner = new RedisDisposableWorkerIdAssigner(redisTemplate);
        return redisDisposableWorkerIdAssigner;
    }
}
