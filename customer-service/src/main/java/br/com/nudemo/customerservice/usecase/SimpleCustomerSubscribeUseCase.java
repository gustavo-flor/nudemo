package br.com.nudemo.customerservice.usecase;

import br.com.nudemo.customerservice.dto.CustomerSubscribeDTO;
import br.com.nudemo.customerservice.entity.Customer;
import br.com.nudemo.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SimpleCustomerSubscribeUseCase implements CustomerSubscribeUseCase {
    private final CustomerRepository customerRepository;

    @Override
    public void execute(CustomerSubscribeDTO dto) {
        customerRepository.save(Customer.of(dto));
    }
}
