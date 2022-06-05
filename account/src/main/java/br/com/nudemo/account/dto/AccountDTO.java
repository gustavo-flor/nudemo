package br.com.nudemo.account.dto;

import br.com.nudemo.account.entity.Account;

import java.math.BigDecimal;

public record AccountDTO(Long id,
                         String customerId,
                         BigDecimal balance) {
    public static AccountDTO of(final Account account) {
        return new AccountDTO(account.getId(), account.getCustomerId(), account.getBalance());
    }
}
