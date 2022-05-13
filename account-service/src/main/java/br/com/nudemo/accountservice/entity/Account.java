package br.com.nudemo.accountservice.entity;

import br.com.nudemo.accountservice.dto.AccountCreateDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.math.BigDecimal;

@Document("accounts")
@Getter
@Setter
public class Account {
    @Id
    private String id;

    private BigDecimal balance;

    @Field(targetType = FieldType.OBJECT_ID)
    private String customerId;

    public static Account of(final AccountCreateDTO dto) {
        final Account account = new Account();
        account.setBalance(BigDecimal.ZERO);
        account.setCustomerId(dto.customerId());
        return account;
    }
}
