package br.com.nudemo.account.controller;

import br.com.nudemo.account.dto.AccountDTO;
import br.com.nudemo.account.usecase.FindAccountByCustomerIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final FindAccountByCustomerIdUseCase findAccountByCustomerIdUseCase;

    @GetMapping("/{customerId}")
    public AccountDTO findByCustomerId(@PathVariable final String customerId) {
        return findAccountByCustomerIdUseCase.execute(customerId);
    }
}
