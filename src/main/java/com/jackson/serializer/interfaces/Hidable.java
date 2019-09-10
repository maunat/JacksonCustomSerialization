package com.jackson.serializer.interfaces;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("hidden")
public interface Hidable {

    boolean isHidden();

}
