package br.com.nudemo.timeline.core.entity;

import br.com.nudemo.timeline.core.payload.CreateMoneyRescuedMarkPayload;

import java.math.BigDecimal;

public class MoneyRescuedMark extends Mark<MoneyRescuedMark.Source> {
    @Override
    public MarkType getEventType() {
        return MarkType.MONEY_RESCUED;
    }

    public record Source(BigDecimal value) {
    }

    public static MoneyRescuedMark of(final CreateMoneyRescuedMarkPayload payload) {
        final MoneyRescuedMark mark = new MoneyRescuedMark();
        mark.setCpf(payload.cpf());
        mark.setOccurredAt(payload.occurredAt());
        mark.setSource(new MoneyRescuedMark.Source(payload.amount()));
        return mark;
    }
}
