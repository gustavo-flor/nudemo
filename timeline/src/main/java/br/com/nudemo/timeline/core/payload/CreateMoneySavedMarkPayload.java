package br.com.nudemo.timeline.core.payload;

import lombok.Builder;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record CreateMoneySavedMarkPayload(@NotBlank @CPF String cpf,
                                          @NotNull @Positive BigDecimal amount,
                                          @NotNull @Past LocalDateTime occurredAt) {
}
