package com.car.marketplace.common.messaging.event.payment;

import com.car.marketplace.common.messaging.domain.Money;
import com.car.marketplace.common.messaging.event.DomainEvent;

import java.time.Instant;
import java.util.UUID;

public record PaymentIntentCreated(
        UUID eventId,
        Instant occurredAt,
        UUID aggregateId,
        Payload payload
) implements DomainEvent {

    public record Payload(
            UUID orderId,
            Money amount
    ) {}
}
