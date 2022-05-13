package br.com.nudemo.accountservice.event.message;

import br.com.nudemo.accountservice.entity.Account;
import br.com.nudemo.accountservice.event.OutputStream;

public record AccountCreatedMessage(String accountId) implements OutMessage {
    public static AccountCreatedMessage of(final Account account) {
        return new AccountCreatedMessage(account.getId());
    }

    @Override
    public String outBindingName() {
        return OutputStream.ACCOUNT_CREATED_EVENT;
    }
}
