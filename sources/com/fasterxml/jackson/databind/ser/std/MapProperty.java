package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.PropertyWriter;

public class MapProperty extends PropertyWriter {
    private static final BeanProperty BOGUS_PROP = new BeanProperty.Bogus();
    private static final long serialVersionUID = 1;
    protected Object _key;
    protected JsonSerializer<Object> _keySerializer;
    protected final BeanProperty _property;
    protected final TypeSerializer _typeSerializer;
    protected Object _value;
    protected JsonSerializer<Object> _valueSerializer;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MapProperty(com.fasterxml.jackson.databind.jsontype.TypeSerializer r2, com.fasterxml.jackson.databind.BeanProperty r3) {
        /*
            r1 = this;
            if (r3 != 0) goto L_0x0005
            com.fasterxml.jackson.databind.PropertyMetadata r0 = com.fasterxml.jackson.databind.PropertyMetadata.STD_REQUIRED_OR_OPTIONAL
            goto L_0x0009
        L_0x0005:
            com.fasterxml.jackson.databind.PropertyMetadata r0 = r3.getMetadata()
        L_0x0009:
            r1.<init>((com.fasterxml.jackson.databind.PropertyMetadata) r0)
            r1._typeSerializer = r2
            if (r3 != 0) goto L_0x0012
            com.fasterxml.jackson.databind.BeanProperty r3 = BOGUS_PROP
        L_0x0012:
            r1._property = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.MapProperty.<init>(com.fasterxml.jackson.databind.jsontype.TypeSerializer, com.fasterxml.jackson.databind.BeanProperty):void");
    }

    public PropertyName getFullName() {
        return new PropertyName(getName());
    }

    public AnnotatedMember getMember() {
        return this._property.getMember();
    }

    public String getName() {
        Object obj = this._key;
        if (obj instanceof String) {
            return (String) obj;
        }
        return String.valueOf(obj);
    }

    public JavaType getType() {
        return this._property.getType();
    }

    public void reset(Object obj, Object obj2, JsonSerializer<Object> jsonSerializer, JsonSerializer<Object> jsonSerializer2) {
        this._key = obj;
        this._value = obj2;
        this._keySerializer = jsonSerializer;
        this._valueSerializer = jsonSerializer2;
    }
}
