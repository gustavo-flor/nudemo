package br.com.nudemo.timeline.infra.web.controller;

import br.com.nudemo.timeline.core.entity.Mark;
import br.com.nudemo.timeline.core.usecase.PaginateMarksUseCase;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Validated
@RestController
@RequestMapping("/timelines/{cpf}/marks")
@RequiredArgsConstructor
public class TimelineController {
    private static final int DEFAULT_PAGE_SIZE = 24;

    private final PaginateMarksUseCase paginateMarksUseCase;

    @GetMapping
    public Flux<Mark<?>> paginate(@NotBlank @CPF @PathVariable final String cpf,
                                  @PositiveOrZero @RequestParam(required = false, defaultValue = "0") final Integer page) {
        return paginateMarksUseCase.execute(cpf, PageRequest.of(page, DEFAULT_PAGE_SIZE));
    }
}
