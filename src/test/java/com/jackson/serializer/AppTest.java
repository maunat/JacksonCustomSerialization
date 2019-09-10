package com.jackson.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jackson.serializer.configurations.modules.HidableModule;
import com.jackson.serializer.models.EmailAddress;
import com.jackson.serializer.models.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.ArrayList;

public class AppTest {

    private MappingJackson2HttpMessageConverter converter;

    private ObjectMapper mapper;

    @Before
    public void setup() {
        converter = mappingJackson2HttpMessageConverter();
        mapper = converter.getObjectMapper();
    }

    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModule(new HidableModule());

        converter.setObjectMapper(objectMapper);

        return converter;
    }

    @Test
    public void whenEmailAddressIsHidden_ThenDoNotSerialize() throws JsonProcessingException {

        EmailAddress e1 = EmailAddress.builder()
                .address("e1@mail.com")
                .build();
        e1.setHidden(false);

        EmailAddress e2 = EmailAddress.builder()
                .address("e2@mail.com")
                .build();
        e2.setHidden(true);

        EmailAddress e3 = EmailAddress.builder()
                .address("e3@mail.com")
                .build();
        e3.setHidden(false);

        ArrayList<EmailAddress> emailAddresses = new ArrayList<>();
        emailAddresses.add(e1);
        emailAddresses.add(e2);
        emailAddresses.add(e3);

        User u1 = User.builder()
                .username("User 1")
                .emailAddresses(emailAddresses)
                .build();
        u1.setHidden(false);

        System.out.println(mapper.writeValueAsString(u1));
    }

}
