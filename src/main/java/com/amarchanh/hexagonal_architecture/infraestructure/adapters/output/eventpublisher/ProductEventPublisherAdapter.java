package com.amarchanh.hexagonal_architecture.infraestructure.adapters.output.eventpublisher;

import com.amarchanh.hexagonal_architecture.application.ports.output.ProductEventPublisher;
import com.amarchanh.hexagonal_architecture.domain.event.ProductCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@RequiredArgsConstructor
public class ProductEventPublisherAdapter implements ProductEventPublisher {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void publishProductCreatedEvent(final ProductCreatedEvent event) {
        this.applicationEventPublisher.publishEvent(event);
    }

}
