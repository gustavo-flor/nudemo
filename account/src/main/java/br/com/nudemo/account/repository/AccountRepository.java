package br.com.nudemo.account.repository;

import br.com.nudemo.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsByCustomerId(final String customerId);

    Optional<Account> findByCustomerId(final String customerId);
}
