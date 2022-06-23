package br.com.nudemo.timeline.core.usecase;

import br.com.nudemo.timeline.core.entity.Mark;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;

public interface PaginateMarksUseCase {
    Flux<Mark<?>> execute(String cpf, Pageable pageable);
}
