package com.car.marketplace.common.messaging.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.util.Map;

public class JsonEventDeserializer<T> implements Deserializer<T> {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private Class<T> targetType;

    public JsonEventDeserializer() {
    }

    public JsonEventDeserializer(Class<T> targetType) {
        this.targetType = targetType;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void configure(Map<String, ?> configs, boolean isKey) {
        if (targetType == null) {
            Object typeName = configs.get("value.deserializer.type");
            if (typeName instanceof String s) {
                try {
                    this.targetType = (Class<T>) Class.forName(s);
                } catch (ClassNotFoundException e) {
                    throw new SerializationException("Unknown class: " + s, e);
                }
            }
        }
    }

    @Override
    public T deserialize(String topic, byte[] data) {
        if (data == null) {
            return null;
        }
        try {
            return objectMapper.readValue(data, targetType);
        } catch (IOException e) {
            throw new SerializationException("Error deserializing event", e);
        }
    }
}
