package br.com.nudemo.account.entity;

import br.com.nudemo.account.dto.CreateAccountDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class AccountTest {
    @Test
    @DisplayName("Given a valid DTO when of, then instantiate object")
    void givenAValidDTOWhenOfThenInstantiateObject() {
        final var customerId = UUID.randomUUID().toString();
        final var dto = new CreateAccountDTO(customerId);

        final var account = Account.of(dto);

        assertThat(account.getId()).isNull();
        assertThat(account.getCustomerId()).isEqualTo(customerId);
        assertThat(account.getBalance()).isEqualTo(BigDecimal.ZERO);
    }
}