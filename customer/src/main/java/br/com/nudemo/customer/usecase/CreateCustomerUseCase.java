package br.com.nudemo.customer.usecase;

import br.com.nudemo.customer.dto.CreateCustomerDTO;
import br.com.nudemo.customer.dto.CustomerDTO;

public interface CreateCustomerUseCase {
    CustomerDTO execute(final CreateCustomerDTO dto);
}
