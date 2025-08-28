package com.car.marketplace.common.messaging.event.order;

import com.car.marketplace.common.messaging.domain.ServiceTag;
import com.car.marketplace.common.messaging.event.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record OrderCreated(
        UUID eventId,
        Instant occurredAt,
        UUID aggregateId,
        Payload payload
) implements DomainEvent {

    public record Payload(
            UUID customerId,
            UUID providerId,
            ServiceTag serviceTag,
            Instant scheduledAt
    ) {}
}
