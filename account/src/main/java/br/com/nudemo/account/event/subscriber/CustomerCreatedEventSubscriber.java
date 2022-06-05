package br.com.nudemo.account.event.subscriber;

import br.com.nudemo.account.dto.CreateAccountDTO;
import br.com.nudemo.account.event.CustomerCreatedEvent;
import br.com.nudemo.account.usecase.CreateAccountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component(CustomerCreatedEvent.INPUT_BINDING_NAME)
@RequiredArgsConstructor
public class CustomerCreatedEventSubscriber implements Consumer<CustomerCreatedEvent> {
    private final CreateAccountUseCase createAccountUseCase;

    @Override
    public void accept(final CustomerCreatedEvent event) {
        final CreateAccountDTO dto = new CreateAccountDTO(event.id());
        createAccountUseCase.execute(dto);
    }
}
