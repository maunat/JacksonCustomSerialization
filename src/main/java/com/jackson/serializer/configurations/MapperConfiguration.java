package com.jackson.serializer.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jackson.serializer.configurations.modules.HidableModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
public class MapperConfiguration {

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModule(new HidableModule());

        converter.setObjectMapper(objectMapper);

        return converter;
    }


}
