package br.com.nudemo.timeline.core.repository;

import br.com.nudemo.timeline.core.entity.Mark;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface MarkRepository extends ReactiveMongoRepository<Mark<?>, String> {
    Flux<Mark<?>> findAllByCpfOrderByOccurredAt(String cpf, Pageable pageable);
}
