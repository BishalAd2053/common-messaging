package com.car.marketplace.common.messaging.domain;

import java.math.BigDecimal;

public record Money(BigDecimal value, String currency) {}
