package com.jackson.serializer.configurations.modules;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.jackson.serializer.interfaces.Hidable;

import java.io.IOException;

public class HidableSerializer extends JsonSerializer<Hidable> {

    private JsonSerializer<Object> jsonSerializer;

    public HidableSerializer(JsonSerializer<Object> jsonSerializer) {
        this.jsonSerializer = jsonSerializer;
    }

    @Override
    public void serialize(Hidable value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if (value.isHidden())
            return;
        jsonSerializer.serialize(value, gen, serializers);

    }

    @Override
    public boolean isEmpty(SerializerProvider provider, Hidable value) {
        return super.isEmpty(provider, value);
    }

}
