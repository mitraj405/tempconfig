package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.exc.StreamWriteException;

public class JsonGenerationException extends StreamWriteException {
    private static final long serialVersionUID = 123;

    public JsonGenerationException(String str, JsonGenerator jsonGenerator) {
        super(str, jsonGenerator);
        this._processor = jsonGenerator;
    }

    public JsonGenerator getProcessor() {
        return this._processor;
    }
}
