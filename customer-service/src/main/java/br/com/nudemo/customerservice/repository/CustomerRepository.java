package br.com.nudemo.customerservice.repository;

import br.com.nudemo.customerservice.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    boolean existsByCpf(final String cpf);

    boolean existsByEmail(final String email);
}
