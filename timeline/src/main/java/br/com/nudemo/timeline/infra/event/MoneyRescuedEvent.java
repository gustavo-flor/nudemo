package br.com.nudemo.timeline.infra.event;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record MoneyRescuedEvent(String cpf, BigDecimal amount, LocalDateTime occurredAt) {
    public static final String INPUT_BINDING_NAME = "moneyRescued-event";
    public static final String INPUT_DLQ_BINDING_NAME = INPUT_BINDING_NAME + "-DLQ";
}
