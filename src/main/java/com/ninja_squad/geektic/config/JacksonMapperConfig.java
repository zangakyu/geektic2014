package com.ninja_squad.geektic.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * A config class for the Jackson ObjectMapper
 * @author JB
 */
@Configuration
public class JacksonMapperConfig {
    /**
     * Creates a custom Jackson ObjectMapper, that can be injected in controllers, and that is set
     * in the default MappingJackson2HttpMessageConverter by {@link JacksonMapperConfigurer}
     */
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return mapper;
    }
}
