package br.com.nudemo.timeline.core.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "events")
@Getter
@Setter
public abstract class Mark<S> {
    @Id
    private String id;

    private S source;

    private LocalDateTime occurredAt;

    @Indexed
    private String cpf;

    @AccessType(AccessType.Type.PROPERTY)
    public abstract MarkType getEventType();
}
