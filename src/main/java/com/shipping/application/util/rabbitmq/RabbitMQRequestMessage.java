package com.shipping.application.util.rabbitmq;

public class RabbitMQRequestMessage {

    public String type;

    public RabbitMQRequestMessage(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String setType() {
        return type;
    }

    @Override
    public String toString(){
        return String.format("{\"type\":\"%s\"}", type);
    }

}
