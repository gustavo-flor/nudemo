package br.com.nudemo.account.usecase;

import br.com.nudemo.account.dto.AccountDTO;
import br.com.nudemo.account.dto.CreateAccountDTO;

public interface CreateAccountUseCase {
    AccountDTO execute(final CreateAccountDTO dto);
}
