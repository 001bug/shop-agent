package com.ohmygod.shopagent.redis.config;

import com.ohmygod.shopagent.redis.RedisCacheImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

@AutoConfiguration
public class RedisCacheAutoConfig {
    
    @Bean
    public RedisCacheImpl redisCache(@Qualifier("redisToolStringRedisTemplate") StringRedisTemplate stringRedisTemplate){
        return new RedisCacheImpl(stringRedisTemplate);
    }
}
