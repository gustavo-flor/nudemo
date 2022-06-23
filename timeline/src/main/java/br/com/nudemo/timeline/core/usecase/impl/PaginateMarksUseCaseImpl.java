package br.com.nudemo.timeline.core.usecase.impl;

import br.com.nudemo.timeline.core.entity.Mark;
import br.com.nudemo.timeline.core.repository.MarkRepository;
import br.com.nudemo.timeline.core.usecase.PaginateMarksUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class PaginateMarksUseCaseImpl implements PaginateMarksUseCase {
    private final MarkRepository markRepository;

    @Override
    public Flux<Mark<?>> execute(String cpf, Pageable pageable) {
        return markRepository.findAllByCpfOrderByOccurredAt(cpf, pageable);
    }
}
