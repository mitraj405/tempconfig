package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.util.Iterator;

public abstract class JsonNode extends JsonSerializable.Base implements Iterable<JsonNode> {
    public Iterator<JsonNode> elements() {
        return ClassUtil.emptyIterator();
    }

    public boolean isArray() {
        return false;
    }

    public final Iterator<JsonNode> iterator() {
        return elements();
    }
}
