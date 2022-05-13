package br.com.nudemo.accountservice.repository;

import br.com.nudemo.accountservice.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
    boolean existsByCustomerId(final String customerId);
}
