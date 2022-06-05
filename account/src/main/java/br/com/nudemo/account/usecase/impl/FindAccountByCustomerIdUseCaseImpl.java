package br.com.nudemo.account.usecase.impl;

import br.com.nudemo.account.dto.AccountDTO;
import br.com.nudemo.account.exception.NotFoundException;
import br.com.nudemo.account.repository.AccountRepository;
import br.com.nudemo.account.usecase.FindAccountByCustomerIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindAccountByCustomerIdUseCaseImpl implements FindAccountByCustomerIdUseCase {
    private final AccountRepository accountRepository;

    @Override
    public AccountDTO execute(final String customerId) {
        return accountRepository.findByCustomerId(customerId)
                .map(AccountDTO::of)
                .orElseThrow(NotFoundException::new);
    }
}
