package com.ohmygod.shopagent.uid.config;

import com.ohmygod.shopagent.uid.worker.WorkerIdAssigner;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Optional;

public class RedisDisposableWorkerIdAssigner implements WorkerIdAssigner {

    private RedisTemplate redisTemplate;

    public RedisDisposableWorkerIdAssigner (RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @Override
    public long assignWorkerId() {
        String key = "uid_work_id";
        Long increment = redisTemplate.opsForValue().increment(key);
        return Optional.ofNullable(increment)
                .orElseThrow(() -> new IllegalStateException("Unable to allocate a Redis worker ID"));
    }
}
