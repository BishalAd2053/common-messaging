package com.car.marketplace.common.messaging.event;

import java.time.Instant;
import java.util.UUID;

public interface DomainEvent {
    UUID eventId();
    Instant occurredAt();
    UUID aggregateId();
}
