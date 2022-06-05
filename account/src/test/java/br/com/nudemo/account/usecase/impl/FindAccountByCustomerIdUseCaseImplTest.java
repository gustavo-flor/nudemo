package br.com.nudemo.account.usecase.impl;

import br.com.nudemo.account.dto.CreateAccountDTO;
import br.com.nudemo.account.entity.Account;
import br.com.nudemo.account.exception.NotFoundException;
import br.com.nudemo.account.repository.AccountRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class FindAccountByCustomerIdUseCaseImplTest {
    static final Faker FAKER = new Faker();

    @InjectMocks
    FindAccountByCustomerIdUseCaseImpl findAccountByCPFUseCase;

    @Mock
    AccountRepository accountRepository;

    @Test
    @DisplayName("Given a customer id without account when find by customer id, then throw NotFoundException")
    void givenACustomerIdWithoutAccountWhenFindByCustomerIdThenThrowNotFoundException() {
        final var customerId = UUID.randomUUID().toString();

        assertThatThrownBy(() -> findAccountByCPFUseCase.execute(customerId)).isInstanceOf(NotFoundException.class);

        verify(accountRepository).findByCustomerId(customerId);
    }

    @Test
    @DisplayName("Given a customer id with account when find by customer id, then return AccountDTO")
    void givenACustomerIdWithAccountWhenFindByCustomerIdThenReturnAccountDTO() {
        final var customerId = UUID.randomUUID().toString();
        final var account = Account.of(new CreateAccountDTO(customerId));
        account.setId(FAKER.number().randomNumber());
        doReturn(Optional.of(account)).when(accountRepository).findByCustomerId(customerId);

        final var accountDTO = findAccountByCPFUseCase.execute(customerId);
        assertThat(accountDTO.id()).isEqualTo(account.getId());
        assertThat(accountDTO.customerId()).isEqualTo(account.getCustomerId());
        assertThat(accountDTO.balance()).isEqualTo(account.getBalance());
    }
}