package com.jackson.serializer.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class EmailAddress extends HidableObject {

    private String address;

}
