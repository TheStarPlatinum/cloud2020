package com.ydx.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FeignConfig {
    @Bean
    Logger.Level fenLoggerLevel(){
        return Logger.Level.FULL;
    }
}
