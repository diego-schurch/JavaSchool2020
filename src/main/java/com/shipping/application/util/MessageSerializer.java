package com.shipping.application.util;

public class MessageSerializer {

    static public String requestMessageToPlainTextJson(RequestMessage requestMessage){
            return String.format("{\"type\":\"%s\"}", requestMessage.type);
    }

}
