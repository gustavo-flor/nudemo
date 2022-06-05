package br.com.nudemo.customer.usecase;

import br.com.nudemo.customer.dto.CustomerDTO;

public interface FindCustomerByIdUseCase {
    CustomerDTO execute(final String id);
}
