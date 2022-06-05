package br.com.nudemo.customer.event;

import org.springframework.messaging.Message;

public interface OutputEvent {
    String PARTITION_KEY_HEADER_NAME = "X-Partition-Key";

    String outputBindingName();

    Message<? extends OutputEvent> message();
}
