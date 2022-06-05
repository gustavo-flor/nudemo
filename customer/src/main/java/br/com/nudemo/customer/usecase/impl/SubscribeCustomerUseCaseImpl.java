package br.com.nudemo.customer.usecase.impl;

import br.com.nudemo.customer.dto.SubscribeCustomerDTO;
import br.com.nudemo.customer.event.CustomerSubscribedEvent;
import br.com.nudemo.customer.event.publisher.EventPublisher;
import br.com.nudemo.customer.usecase.SubscribeCustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubscribeCustomerUseCaseImpl implements SubscribeCustomerUseCase {
    private final EventPublisher eventPublisher;

    @Override
    public void execute(final SubscribeCustomerDTO dto) {
        eventPublisher.send(CustomerSubscribedEvent.of(dto));
    }
}
