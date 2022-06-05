package br.com.nudemo.account.usecase.impl;

import br.com.nudemo.account.dto.AccountDTO;
import br.com.nudemo.account.dto.CreateAccountDTO;
import br.com.nudemo.account.entity.Account;
import br.com.nudemo.account.exception.CPFAlreadyInUseException;
import br.com.nudemo.account.repository.AccountRepository;
import br.com.nudemo.account.usecase.CreateAccountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateAccountUseCaseImpl implements CreateAccountUseCase {
    private final AccountRepository accountRepository;

    @Override
    public AccountDTO execute(final CreateAccountDTO dto) {
        if (accountRepository.existsByCustomerId(dto.customerId())) {
            throw new CPFAlreadyInUseException();
        }
        return AccountDTO.of(accountRepository.save(Account.of(dto)));
    }
}
