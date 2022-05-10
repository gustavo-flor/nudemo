package br.com.nudemo.customerservice.entity;

import br.com.nudemo.customerservice.dto.CustomerSubscribeDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("customers")
@Getter
@Setter
public class Customer {
    @Id
    private String id;

    @Indexed(unique = true)
    private String cpf;

    private String name;

    @Indexed(unique = true)
    private String email;

    public static Customer of(final CustomerSubscribeDTO dto) {
        final Customer customer = new Customer();
        customer.setCpf(dto.cpf());
        customer.setName(dto.name());
        customer.setEmail(dto.email());
        return customer;
    }
}
