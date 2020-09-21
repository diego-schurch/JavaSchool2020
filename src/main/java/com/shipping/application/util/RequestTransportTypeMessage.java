package com.shipping.application.util;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class RequestTransportTypeMessage extends RequestMessage {

    @Getter
    @Setter
    public String transportType;

    @Builder
    public RequestTransportTypeMessage(String type, String transportType) {
        super(type);
        this.transportType = transportType;
    }

}
