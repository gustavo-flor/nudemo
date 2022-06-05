package br.com.nudemo.account.usecase;

import br.com.nudemo.account.dto.AccountDTO;

public interface FindAccountByCustomerIdUseCase {
    AccountDTO execute(final String customerId);
}
