package com.shipping.application.util;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


public class RequestPackageSizeMessage extends RequestMessage {

    @Getter
    @Setter
    public String packageType;

    @Builder
    public RequestPackageSizeMessage(String type, String packageType) {
        super(type);
        this.packageType = packageType;
    }

}
