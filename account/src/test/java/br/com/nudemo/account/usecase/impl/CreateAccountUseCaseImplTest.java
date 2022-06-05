package br.com.nudemo.account.usecase.impl;

import br.com.nudemo.account.dto.CreateAccountDTO;
import br.com.nudemo.account.entity.Account;
import br.com.nudemo.account.exception.CPFAlreadyInUseException;
import br.com.nudemo.account.repository.AccountRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static java.math.BigDecimal.ZERO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateAccountUseCaseImplTest {
    @InjectMocks
    CreateAccountUseCaseImpl createAccountUseCase;

    @Mock
    AccountRepository accountRepository;

    @Test
    @DisplayName("Given a valid CPF when execute, then should create account")
    void givenAValidCPFWhenExecuteThenShouldCreateAccount() {
        final var customerId = UUID.randomUUID().toString();
        final var createAccountDTO = new CreateAccountDTO(customerId);
        doAnswer(answer -> answer.getArgument(0)).when(accountRepository).save(any());

        final var accountDTO = createAccountUseCase.execute(createAccountDTO);

        final var accountCaptor = ArgumentCaptor.forClass(Account.class);
        verify(accountRepository).save(accountCaptor.capture());
        final var account = accountCaptor.getValue();
        assertThat(account.getId()).isNull();
        assertThat(account.getCustomerId()).isEqualTo(customerId);
        assertThat(account.getBalance()).isEqualTo(ZERO);
        assertThat(accountDTO.id()).isEqualTo(account.getId());
        assertThat(accountDTO.customerId()).isEqualTo(account.getCustomerId());
        assertThat(accountDTO.balance()).isEqualTo(account.getBalance());
    }

    @Test
    @DisplayName("Given an in use CPF when execute, then should throw CPFAlreadyInUseException")
    void givenAnInUseCPFWhenExecuteThenShouldThrowCPFAlreadyInUseException() {
        final var customerId = UUID.randomUUID().toString();
        final var dto = new CreateAccountDTO(customerId);
        doReturn(true).when(accountRepository).existsByCustomerId(customerId);

        assertThatThrownBy(() -> createAccountUseCase.execute(dto)).isInstanceOf(CPFAlreadyInUseException.class);
    }
}