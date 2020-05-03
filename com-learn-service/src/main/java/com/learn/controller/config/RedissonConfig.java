package com.learn.controller.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class RedissonConfig {

    @Value("${redisson.address}")
    private String addressUrl;

    @Bean
    public RedissonClient getRedisson() throws Exception{
        Config config = new Config();
        config.useSingleServer().setAddress(addressUrl);
        RedissonClient redisson = Redisson.create(config);
        System.out.println(redisson.getConfig().toJSON());
        return redisson;
    }
}
