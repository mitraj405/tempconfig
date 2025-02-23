package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import java.util.Collection;

public abstract class StaticListSerializerBase<T extends Collection<?>> extends StdSerializer<T> implements ContextualSerializer {
    protected final Boolean _unwrapSingle;

    public StaticListSerializerBase(Class<?> cls) {
        super(cls, false);
        this._unwrapSingle = null;
    }

    public abstract JsonSerializer<?> _withResolved(BeanProperty beanProperty, Boolean bool);

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fasterxml.jackson.databind.JsonSerializer<?> createContextual(com.fasterxml.jackson.databind.SerializerProvider r6, com.fasterxml.jackson.databind.BeanProperty r7) throws com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r5 = this;
            r0 = 0
            if (r7 == 0) goto L_0x0018
            com.fasterxml.jackson.databind.AnnotationIntrospector r1 = r6.getAnnotationIntrospector()
            com.fasterxml.jackson.databind.introspect.AnnotatedMember r2 = r7.getMember()
            if (r2 == 0) goto L_0x0018
            java.lang.Object r1 = r1.findContentSerializer(r2)
            if (r1 == 0) goto L_0x0018
            com.fasterxml.jackson.databind.JsonSerializer r1 = r6.serializerInstance(r2, r1)
            goto L_0x0019
        L_0x0018:
            r1 = r0
        L_0x0019:
            java.lang.Class r2 = r5.handledType()
            com.fasterxml.jackson.annotation.JsonFormat$Value r2 = r5.findFormatOverrides(r6, r7, r2)
            if (r2 == 0) goto L_0x002a
            com.fasterxml.jackson.annotation.JsonFormat$Feature r3 = com.fasterxml.jackson.annotation.JsonFormat.Feature.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED
            java.lang.Boolean r2 = r2.getFeature(r3)
            goto L_0x002b
        L_0x002a:
            r2 = r0
        L_0x002b:
            com.fasterxml.jackson.databind.JsonSerializer r1 = r5.findContextualConvertingSerializer(r6, r7, r1)
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            if (r1 != 0) goto L_0x0037
            com.fasterxml.jackson.databind.JsonSerializer r1 = r6.findContentValueSerializer((java.lang.Class<?>) r3, (com.fasterxml.jackson.databind.BeanProperty) r7)
        L_0x0037:
            boolean r4 = r5.isDefaultSerializer(r1)
            if (r4 == 0) goto L_0x004b
            java.lang.Boolean r6 = r5._unwrapSingle
            boolean r6 = java.util.Objects.equals(r2, r6)
            if (r6 == 0) goto L_0x0046
            return r5
        L_0x0046:
            com.fasterxml.jackson.databind.JsonSerializer r6 = r5._withResolved(r7, r2)
            return r6
        L_0x004b:
            com.fasterxml.jackson.databind.ser.std.CollectionSerializer r7 = new com.fasterxml.jackson.databind.ser.std.CollectionSerializer
            com.fasterxml.jackson.databind.JavaType r6 = r6.constructType(r3)
            r2 = 1
            r7.<init>(r6, r2, r0, r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase.createContextual(com.fasterxml.jackson.databind.SerializerProvider, com.fasterxml.jackson.databind.BeanProperty):com.fasterxml.jackson.databind.JsonSerializer");
    }

    public boolean isEmpty(SerializerProvider serializerProvider, T t) {
        return t == null || t.size() == 0;
    }

    public StaticListSerializerBase(StaticListSerializerBase<?> staticListSerializerBase, Boolean bool) {
        super((StdSerializer<?>) staticListSerializerBase);
        this._unwrapSingle = bool;
    }
}
