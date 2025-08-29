package com.car.marketplace.common.messaging.serialization;

import com.car.marketplace.common.messaging.domain.GeoPoint;
import com.car.marketplace.common.messaging.domain.ServiceTag;
import com.car.marketplace.common.messaging.event.provider.ProviderRegistered;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonEventSerdeTest {

//    @Test
//    void roundTripProviderRegistered() {
//        ProviderRegistered event = new ProviderRegistered(
//                UUID.randomUUID(),
//                Instant.now(),
//                UUID.randomUUID(),
//                new ProviderRegistered.Payload(
//                        "Auto Service Pro",
//                        "+12025550123",
//                        "123 Main St",
//                        new GeoPoint(40.7128, -74.0060),
//                        Set.of(ServiceTag.OIL_CHANGE)
//                )
//        );
//
//        JsonEventSerializer serializer = new JsonEventSerializer();
//        JsonEventDeserializer<ProviderRegistered> deserializer = new JsonEventDeserializer<>(ProviderRegistered.class);
//
//        byte[] bytes = serializer.serialize("providers", event);
//        ProviderRegistered result = deserializer.deserialize("providers", bytes);
//
//        assertEquals(event, result);
//    }
}
