package com.fasterxml.jackson.core;

import java.io.IOException;

public abstract class ObjectCodec extends TreeCodec {
    public abstract void writeValue(JsonGenerator jsonGenerator, Object obj) throws IOException;
}
