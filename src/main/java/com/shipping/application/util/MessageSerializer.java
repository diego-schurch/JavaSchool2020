package com.shipping.application.util;

public class MessageSerializer {

    static public String requestMessageToPlainTextJson(RequestMessage requestMessage){
            return String.format("{\"type\":\"%s\"}", requestMessage.type);
    }

    static public String requestPackageSizeMessageToPlainTextJson(RequestPackageSizeMessage requestMessage){
        return String.format("{\"type\":\"%s\", \"packageType\":\"%s\"}", requestMessage.type, requestMessage.packageType);
    }

}
