package br.com.nudemo.timeline.core.entity;

import br.com.nudemo.timeline.core.payload.CreateMoneySavedMarkPayload;

import java.math.BigDecimal;

public class MoneySavedMark extends Mark<MoneySavedMark.Source> {
    @Override
    public MarkType getEventType() {
        return MarkType.MONEY_SAVED;
    }

    public record Source(BigDecimal value) {
    }

    public static MoneySavedMark of(final CreateMoneySavedMarkPayload payload) {
        final MoneySavedMark mark = new MoneySavedMark();
        mark.setCpf(payload.cpf());
        mark.setOccurredAt(payload.occurredAt());
        mark.setSource(new Source(payload.amount()));
        return mark;
    }
}
