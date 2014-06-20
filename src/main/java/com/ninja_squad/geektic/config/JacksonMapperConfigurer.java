package com.ninja_squad.geektic.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;

/**
 * Component used to configure the MappingJackson2HttpMessageConverter with the customized ObjectMapper
 * @author JB
 */
@Component
public class JacksonMapperConfigurer {

    /**
     * This autowired custom object mapper is created by the AppConfig
     */
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * This bean contains the default object mapper, that we replace with the custom one
     */
    @Autowired
    private RequestMappingHandlerAdapter handlerAdapter;

    public JacksonMapperConfigurer() {
    }

    /**
     * Constructor used by unit tests
     */
    public JacksonMapperConfigurer(ObjectMapper objectMapper, RequestMappingHandlerAdapter handlerAdapter) {
        this.objectMapper = objectMapper;
        this.handlerAdapter = handlerAdapter;
    }

    @PostConstruct
    public void configure() {
        for (HttpMessageConverter<?> converter : handlerAdapter.getMessageConverters()) {
            if (converter instanceof MappingJackson2HttpMessageConverter) {
                MappingJackson2HttpMessageConverter jacksonConverter = (MappingJackson2HttpMessageConverter) converter;
                jacksonConverter.setObjectMapper(objectMapper);
            }
        }
    }
}
