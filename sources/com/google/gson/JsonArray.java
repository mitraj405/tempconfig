package com.google.gson;

import com.google.gson.internal.NonNullElementWrapperList;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class JsonArray extends JsonElement implements Iterable<JsonElement> {
    private final ArrayList<JsonElement> elements;

    public JsonArray() {
        this.elements = new ArrayList<>();
    }

    private JsonElement getAsSingleElement() {
        int size = this.elements.size();
        if (size == 1) {
            return this.elements.get(0);
        }
        throw new IllegalStateException(lf.h("Array must have size 1, but has size ", size));
    }

    public void add(Boolean bool) {
        this.elements.add(bool == null ? JsonNull.INSTANCE : new JsonPrimitive(bool));
    }

    public void addAll(JsonArray jsonArray) {
        this.elements.addAll(jsonArray.elements);
    }

    public List<JsonElement> asList() {
        return new NonNullElementWrapperList(this.elements);
    }

    public boolean contains(JsonElement jsonElement) {
        return this.elements.contains(jsonElement);
    }

    public boolean equals(Object obj) {
        if (obj == this || ((obj instanceof JsonArray) && ((JsonArray) obj).elements.equals(this.elements))) {
            return true;
        }
        return false;
    }

    public JsonElement get(int i) {
        return this.elements.get(i);
    }

    public BigDecimal getAsBigDecimal() {
        return getAsSingleElement().getAsBigDecimal();
    }

    public BigInteger getAsBigInteger() {
        return getAsSingleElement().getAsBigInteger();
    }

    public boolean getAsBoolean() {
        return getAsSingleElement().getAsBoolean();
    }

    public byte getAsByte() {
        return getAsSingleElement().getAsByte();
    }

    @Deprecated
    public char getAsCharacter() {
        return getAsSingleElement().getAsCharacter();
    }

    public double getAsDouble() {
        return getAsSingleElement().getAsDouble();
    }

    public float getAsFloat() {
        return getAsSingleElement().getAsFloat();
    }

    public int getAsInt() {
        return getAsSingleElement().getAsInt();
    }

    public long getAsLong() {
        return getAsSingleElement().getAsLong();
    }

    public Number getAsNumber() {
        return getAsSingleElement().getAsNumber();
    }

    public short getAsShort() {
        return getAsSingleElement().getAsShort();
    }

    public String getAsString() {
        return getAsSingleElement().getAsString();
    }

    public int hashCode() {
        return this.elements.hashCode();
    }

    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    public Iterator<JsonElement> iterator() {
        return this.elements.iterator();
    }

    public boolean remove(JsonElement jsonElement) {
        return this.elements.remove(jsonElement);
    }

    public JsonElement set(int i, JsonElement jsonElement) {
        ArrayList<JsonElement> arrayList = this.elements;
        if (jsonElement == null) {
            jsonElement = JsonNull.INSTANCE;
        }
        return arrayList.set(i, jsonElement);
    }

    public int size() {
        return this.elements.size();
    }

    public void add(Character ch) {
        this.elements.add(ch == null ? JsonNull.INSTANCE : new JsonPrimitive(ch));
    }

    public JsonArray deepCopy() {
        if (this.elements.isEmpty()) {
            return new JsonArray();
        }
        JsonArray jsonArray = new JsonArray(this.elements.size());
        Iterator<JsonElement> it = this.elements.iterator();
        while (it.hasNext()) {
            jsonArray.add(it.next().deepCopy());
        }
        return jsonArray;
    }

    public JsonElement remove(int i) {
        return this.elements.remove(i);
    }

    public JsonArray(int i) {
        this.elements = new ArrayList<>(i);
    }

    public void add(Number number) {
        this.elements.add(number == null ? JsonNull.INSTANCE : new JsonPrimitive(number));
    }

    public void add(String str) {
        this.elements.add(str == null ? JsonNull.INSTANCE : new JsonPrimitive(str));
    }

    public void add(JsonElement jsonElement) {
        if (jsonElement == null) {
            jsonElement = JsonNull.INSTANCE;
        }
        this.elements.add(jsonElement);
    }
}
