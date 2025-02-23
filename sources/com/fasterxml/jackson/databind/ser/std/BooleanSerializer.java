package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import java.io.IOException;

@JacksonStdImpl
public final class BooleanSerializer extends StdScalarSerializer<Object> implements ContextualSerializer {
    private static final long serialVersionUID = 1;
    protected final boolean _forPrimitive;

    public static final class AsNumber extends StdScalarSerializer<Object> implements ContextualSerializer {
        private static final long serialVersionUID = 1;
        protected final boolean _forPrimitive;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public AsNumber(boolean r3) {
            /*
                r2 = this;
                if (r3 == 0) goto L_0x0005
                java.lang.Class r0 = java.lang.Boolean.TYPE
                goto L_0x0007
            L_0x0005:
                java.lang.Class<java.lang.Boolean> r0 = java.lang.Boolean.class
            L_0x0007:
                r1 = 0
                r2.<init>(r0, r1)
                r2._forPrimitive = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.BooleanSerializer.AsNumber.<init>(boolean):void");
        }

        public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
            JsonFormat.Value findFormatOverrides = findFormatOverrides(serializerProvider, beanProperty, Boolean.class);
            if (findFormatOverrides == null || findFormatOverrides.getShape().isNumeric()) {
                return this;
            }
            return new BooleanSerializer(this._forPrimitive);
        }

        public void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeNumber(Boolean.FALSE.equals(obj) ^ true ? 1 : 0);
        }

        public final void serializeWithType(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
            jsonGenerator.writeBoolean(Boolean.TRUE.equals(obj));
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BooleanSerializer(boolean r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x0005
            java.lang.Class r0 = java.lang.Boolean.TYPE
            goto L_0x0007
        L_0x0005:
            java.lang.Class<java.lang.Boolean> r0 = java.lang.Boolean.class
        L_0x0007:
            r1 = 0
            r2.<init>(r0, r1)
            r2._forPrimitive = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.BooleanSerializer.<init>(boolean):void");
    }

    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        JsonFormat.Value findFormatOverrides = findFormatOverrides(serializerProvider, beanProperty, handledType());
        if (findFormatOverrides != null) {
            JsonFormat.Shape shape = findFormatOverrides.getShape();
            if (shape.isNumeric()) {
                return new AsNumber(this._forPrimitive);
            }
            if (shape == JsonFormat.Shape.STRING) {
                return new ToStringSerializer(this._handledType);
            }
        }
        return this;
    }

    public void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeBoolean(Boolean.TRUE.equals(obj));
    }

    public final void serializeWithType(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException {
        jsonGenerator.writeBoolean(Boolean.TRUE.equals(obj));
    }
}
