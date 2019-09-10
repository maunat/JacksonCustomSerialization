package com.jackson.serializer.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class User extends HidableObject {

    private String username;
    private List<EmailAddress> emailAddresses;

}
