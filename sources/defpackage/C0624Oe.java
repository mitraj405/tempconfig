package defpackage;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

/* renamed from: Oe  reason: default package and case insensitive filesystem */
/* compiled from: HashMapSerializer */
public final class C0624Oe extends JsonSerializer<HashMap<?, ?>> {
    public final void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        HashMap hashMap = (HashMap) obj;
        jsonGenerator.writeStartObject();
        Set keySet = hashMap.keySet();
        jsonGenerator.writeObjectFieldStart("entry");
        for (Object next : keySet) {
            jsonGenerator.writeStringField("key", next.toString());
            jsonGenerator.writeStringField("value", hashMap.get(next).toString());
        }
        jsonGenerator.writeEndObject();
        jsonGenerator.writeEndObject();
    }
}
