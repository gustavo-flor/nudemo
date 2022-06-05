package br.com.nudemo.account.entity;

import br.com.nudemo.account.dto.CreateAccountDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id")
    private String customerId;

    private BigDecimal balance;

    public static Account of(final CreateAccountDTO dto) {
        final Account account = new Account();
        account.setCustomerId(dto.customerId());
        account.setBalance(BigDecimal.ZERO);
        return account;
    }
}
