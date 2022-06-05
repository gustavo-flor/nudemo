package br.com.nudemo.customer.event.subscriber;

import br.com.nudemo.customer.dto.CreateCustomerDTO;
import br.com.nudemo.customer.event.CustomerSubscribedEvent;
import br.com.nudemo.customer.usecase.CreateCustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component(CustomerSubscribedEvent.INPUT_BINDING_NAME)
@RequiredArgsConstructor
public class CustomerSubscribedEventSubscriber implements Consumer<CustomerSubscribedEvent> {
    private final CreateCustomerUseCase createCustomerUseCase;

    @Override
    public void accept(final CustomerSubscribedEvent event) {
        final CreateCustomerDTO dto = CreateCustomerDTO.builder()
                .cpf(event.cpf())
                .name(event.name())
                .email(event.email())
                .build();
        createCustomerUseCase.execute(dto);
    }
}
