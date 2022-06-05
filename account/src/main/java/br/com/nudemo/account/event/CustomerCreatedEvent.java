package br.com.nudemo.account.event;

public record CustomerCreatedEvent(String id, String cpf, String name, String email) {
    public static final String INPUT_BINDING_NAME = "customerCreated-event";
}
