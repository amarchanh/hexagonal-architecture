package com.amarchanh.hexagonal_architecture.application.ports.output;

import com.amarchanh.hexagonal_architecture.domain.event.ProductCreatedEvent;

public interface ProductEventPublisher {
    void publishProductCreatedEvent(ProductCreatedEvent event);
}
