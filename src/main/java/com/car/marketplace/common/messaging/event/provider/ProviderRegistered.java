package com.car.marketplace.common.messaging.event.provider;

import com.car.marketplace.common.messaging.domain.GeoPoint;
import com.car.marketplace.common.messaging.domain.ServiceTag;
import com.car.marketplace.common.messaging.event.DomainEvent;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

public record ProviderRegistered(
        UUID eventId,
        Instant occurredAt,
        UUID aggregateId,
        Payload payload
) implements DomainEvent {

    public record Payload(
            String name,
            String phone,
            String address,
            GeoPoint location,
            Set<ServiceTag> serviceTags
    ) {}
}
