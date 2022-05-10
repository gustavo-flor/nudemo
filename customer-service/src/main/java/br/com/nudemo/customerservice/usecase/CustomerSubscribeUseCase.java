package br.com.nudemo.customerservice.usecase;

import br.com.nudemo.customerservice.dto.CustomerSubscribeDTO;

public interface CustomerSubscribeUseCase {
    void execute(final CustomerSubscribeDTO dto);
}
