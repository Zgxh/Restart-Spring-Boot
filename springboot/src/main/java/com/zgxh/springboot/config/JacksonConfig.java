package com.zgxh.springboot.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * @author Yu Yang
 * @create 2020-02-29 10:31
 */
@Configuration
public class JacksonConfig {

    @Bean // 不能没有，@Bean用于方法上，表示返回对象是Spring管理的bean
    public ObjectMapper getObjectMapper() { // 更改Jackson序列化日期的格式
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        return objectMapper;
    }
}
