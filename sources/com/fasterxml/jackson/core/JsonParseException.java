package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.util.RequestPayload;

public class JsonParseException extends StreamReadException {
    private static final long serialVersionUID = 2;

    public JsonParseException(JsonParser jsonParser, String str) {
        super(jsonParser, str);
    }

    public String getMessage() {
        return super.getMessage();
    }

    public JsonParseException(JsonParser jsonParser, String str, Throwable th) {
        super(jsonParser, str, th);
    }

    public JsonParser getProcessor() {
        return super.getProcessor();
    }

    public JsonParseException withRequestPayload(RequestPayload requestPayload) {
        return this;
    }
}
