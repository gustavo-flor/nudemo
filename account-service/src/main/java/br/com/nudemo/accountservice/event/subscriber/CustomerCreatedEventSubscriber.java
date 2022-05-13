package br.com.nudemo.accountservice.event.subscriber;

import br.com.nudemo.accountservice.dto.AccountCreateDTO;
import br.com.nudemo.accountservice.event.InputStream;
import br.com.nudemo.accountservice.event.message.CustomerCreatedMessage;
import br.com.nudemo.accountservice.usecase.CreateAccountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component(InputStream.CUSTOMER_CREATED_EVENT)
@RequiredArgsConstructor
public class CustomerCreatedEventSubscriber implements Consumer<CustomerCreatedMessage> {
    private final CreateAccountUseCase createAccountUseCase;

    @Override
    public void accept(CustomerCreatedMessage message) {
        createAccountUseCase.execute(new AccountCreateDTO(message.customerId()));
    }
}
