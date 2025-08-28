# Common Messaging Library

A shared library for event definitions, schemas, and serialization utilities used across the Car Services Marketplace microservices.

## Purpose

This library provides:
- Canonical event schemas
- Typed event classes for Java services
- Serialization/deserialization utilities for Kafka
- Integration with common-domain primitives

## Key Components

### Event Schemas
Located in `schemas/`:
- `provider-registered.json`
- `order-created.json`
- `payment-intent-created.json`

### Event Classes
- Base `DomainEvent` class
- Provider events: `ProviderRegistered`
- Order events: `OrderCreated`
- Payment events: `PaymentIntentCreated`

### Serialization
- `JsonEventSerializer`
- `JsonEventDeserializer`

## Usage

Add the dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>com.car.marketplace</groupId>
    <artifactId>common-messaging</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Publishing Events

```java
// Configure Kafka producer
Properties props = new Properties();
props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
props.put("value.serializer", "com.car.marketplace.common.messaging.serialization.JsonEventSerializer");

// Create and send event
ProviderRegistered event = new ProviderRegistered(
    UUID.randomUUID(),
    Instant.now(),
    providerId,
    new ProviderRegistered.Payload(
        "Auto Service Pro",
        "+12025550123",
        "123 Main St",
        new GeoPoint(40.7128, -74.0060),
        Set.of(ServiceTag.OIL_CHANGE)
    )
);

ProducerRecord<String, ProviderRegistered> record = 
    new ProducerRecord<>("providers", event.getAggregateId().toString(), event);
producer.send(record);
```

### Consuming Events

```java
// Configure Kafka consumer
Properties props = new Properties();
props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
props.put("value.deserializer", "com.car.marketplace.common.messaging.serialization.JsonEventDeserializer");
props.put("value.deserializer.type", "com.car.marketplace.common.messaging.event.provider.ProviderRegistered");

// Consume events
ConsumerRecords<String, ProviderRegistered> records = consumer.poll(Duration.ofMillis(100));
for (ConsumerRecord<String, ProviderRegistered> record : records) {
    ProviderRegistered event = record.value();
    // Process event...
}
```

## Build

Requirements:
- Java 21
- Maven 3.8+

```bash
mvn clean install
```

## Contributing

- Schema-first development
- Backward compatible changes only
- Include unit tests
- Follow semantic versioning
