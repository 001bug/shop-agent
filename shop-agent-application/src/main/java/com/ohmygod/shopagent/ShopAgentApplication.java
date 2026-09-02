package com.ohmygod.shopagent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.redisson.spring.starter.RedissonAutoConfigurationV2;

@SpringBootApplication(exclude = RedissonAutoConfigurationV2.class)
public class ShopAgentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopAgentApplication.class, args);
    }

}
