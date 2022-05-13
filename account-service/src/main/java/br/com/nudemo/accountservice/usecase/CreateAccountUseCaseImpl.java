package br.com.nudemo.accountservice.usecase;

import br.com.nudemo.accountservice.dto.AccountCreateDTO;
import br.com.nudemo.accountservice.entity.Account;
import br.com.nudemo.accountservice.event.message.AccountCreatedMessage;
import br.com.nudemo.accountservice.event.publisher.EventPublisher;
import br.com.nudemo.accountservice.exception.CustomerAlreadyHasAnAccountException;
import br.com.nudemo.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateAccountUseCaseImpl implements CreateAccountUseCase {
    private final AccountRepository accountRepository;
    private final EventPublisher eventPublisher;

    @Override
    public void execute(final AccountCreateDTO dto) {
        if (accountRepository.existsByCustomerId(dto.customerId())) {
            throw new CustomerAlreadyHasAnAccountException();
        }
        final Account account = accountRepository.save(Account.of(dto));
        eventPublisher.send(AccountCreatedMessage.of(account));
    }
}
