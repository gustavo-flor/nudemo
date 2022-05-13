package br.com.nudemo.accountservice.usecase;

import br.com.nudemo.accountservice.dto.AccountCreateDTO;

public interface CreateAccountUseCase {
    void execute(final AccountCreateDTO dto);
}
