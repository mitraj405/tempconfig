package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializer;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBase;
import com.fasterxml.jackson.databind.util.NameTransformer;

public class ThrowableDeserializer extends BeanDeserializer {
    private static final long serialVersionUID = 1;

    public ThrowableDeserializer(BeanDeserializer beanDeserializer) {
        super(beanDeserializer);
        this._vanillaProcessing = false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.Throwable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object deserializeFromObject(com.fasterxml.jackson.core.JsonParser r10, com.fasterxml.jackson.databind.DeserializationContext r11) throws java.io.IOException {
        /*
            r9 = this;
            com.fasterxml.jackson.databind.deser.impl.PropertyBasedCreator r0 = r9._propertyBasedCreator
            if (r0 == 0) goto L_0x0009
            java.lang.Object r10 = r9._deserializeUsingPropertyBased(r10, r11)
            return r10
        L_0x0009:
            com.fasterxml.jackson.databind.JsonDeserializer<java.lang.Object> r0 = r9._delegateDeserializer
            if (r0 == 0) goto L_0x0018
            com.fasterxml.jackson.databind.deser.ValueInstantiator r1 = r9._valueInstantiator
            java.lang.Object r10 = r0.deserialize(r10, r11)
            java.lang.Object r10 = r1.createUsingDelegate(r11, r10)
            return r10
        L_0x0018:
            com.fasterxml.jackson.databind.JavaType r0 = r9._beanType
            boolean r0 = r0.isAbstract()
            r1 = 0
            if (r0 == 0) goto L_0x0034
            java.lang.Class r3 = r9.handledType()
            com.fasterxml.jackson.databind.deser.ValueInstantiator r4 = r9.getValueInstantiator()
            java.lang.String r6 = "abstract type (need to add/enable type information?)"
            java.lang.Object[] r7 = new java.lang.Object[r1]
            r2 = r11
            r5 = r10
            java.lang.Object r10 = r2.handleMissingInstantiator(r3, r4, r5, r6, r7)
            return r10
        L_0x0034:
            com.fasterxml.jackson.databind.deser.ValueInstantiator r0 = r9._valueInstantiator
            boolean r0 = r0.canCreateFromString()
            com.fasterxml.jackson.databind.deser.ValueInstantiator r2 = r9._valueInstantiator
            boolean r2 = r2.canCreateUsingDefault()
            if (r0 != 0) goto L_0x0057
            if (r2 != 0) goto L_0x0057
            java.lang.Class r4 = r9.handledType()
            com.fasterxml.jackson.databind.deser.ValueInstantiator r5 = r9.getValueInstantiator()
            java.lang.String r7 = "Throwable needs a default constructor, a single-String-arg constructor; or explicit @JsonCreator"
            java.lang.Object[] r8 = new java.lang.Object[r1]
            r3 = r11
            r6 = r10
            java.lang.Object r10 = r3.handleMissingInstantiator(r4, r5, r6, r7, r8)
            return r10
        L_0x0057:
            r2 = 0
            r5 = r1
            r3 = r2
            r4 = r3
            r6 = r4
        L_0x005c:
            com.fasterxml.jackson.core.JsonToken r7 = com.fasterxml.jackson.core.JsonToken.END_OBJECT
            boolean r7 = r10.hasToken(r7)
            if (r7 != 0) goto L_0x00d6
            java.lang.String r7 = r10.currentName()
            com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap r8 = r9._beanProperties
            com.fasterxml.jackson.databind.deser.SettableBeanProperty r8 = r8.find(r7)
            r10.nextToken()
            if (r8 == 0) goto L_0x0091
            if (r3 == 0) goto L_0x0079
            r8.deserializeAndSet(r10, r11, r3)
            goto L_0x00d2
        L_0x0079:
            if (r4 != 0) goto L_0x0084
            com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap r4 = r9._beanProperties
            int r4 = r4.size()
            int r4 = r4 + r4
            java.lang.Object[] r4 = new java.lang.Object[r4]
        L_0x0084:
            int r7 = r5 + 1
            r4[r5] = r8
            int r5 = r7 + 1
            java.lang.Object r8 = r8.deserialize(r10, r11)
            r4[r7] = r8
            goto L_0x00d2
        L_0x0091:
            java.lang.String r8 = "message"
            boolean r8 = r8.equals(r7)
            if (r8 == 0) goto L_0x00a8
            if (r0 == 0) goto L_0x00b9
            com.fasterxml.jackson.databind.deser.ValueInstantiator r3 = r9._valueInstantiator
            java.lang.String r7 = r10.getValueAsString()
            java.lang.Object r3 = r3.createFromString(r11, r7)
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            goto L_0x00d2
        L_0x00a8:
            java.lang.String r8 = "suppressed"
            boolean r8 = r8.equals(r7)
            if (r8 == 0) goto L_0x00b9
            java.lang.Class<java.lang.Throwable[]> r6 = java.lang.Throwable[].class
            java.lang.Object r6 = r11.readValue((com.fasterxml.jackson.core.JsonParser) r10, r6)
            java.lang.Throwable[] r6 = (java.lang.Throwable[]) r6
            goto L_0x00d2
        L_0x00b9:
            java.util.Set<java.lang.String> r8 = r9._ignorableProps
            if (r8 == 0) goto L_0x00c7
            boolean r8 = r8.contains(r7)
            if (r8 == 0) goto L_0x00c7
            r10.skipChildren()
            goto L_0x00d2
        L_0x00c7:
            com.fasterxml.jackson.databind.deser.SettableAnyProperty r8 = r9._anySetter
            if (r8 == 0) goto L_0x00cf
            r8.deserializeAndSet(r10, r11, r3, r7)
            goto L_0x00d2
        L_0x00cf:
            r9.handleUnknownProperty(r10, r11, r3, r7)
        L_0x00d2:
            r10.nextToken()
            goto L_0x005c
        L_0x00d6:
            if (r3 != 0) goto L_0x00ed
            if (r0 == 0) goto L_0x00e4
            com.fasterxml.jackson.databind.deser.ValueInstantiator r10 = r9._valueInstantiator
            java.lang.Object r10 = r10.createFromString(r11, r2)
            r3 = r10
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            goto L_0x00ed
        L_0x00e4:
            com.fasterxml.jackson.databind.deser.ValueInstantiator r10 = r9._valueInstantiator
            java.lang.Object r10 = r10.createUsingDefault(r11)
            r3 = r10
            java.lang.Throwable r3 = (java.lang.Throwable) r3
        L_0x00ed:
            if (r4 == 0) goto L_0x0100
            r10 = r1
        L_0x00f0:
            if (r10 >= r5) goto L_0x0100
            r11 = r4[r10]
            com.fasterxml.jackson.databind.deser.SettableBeanProperty r11 = (com.fasterxml.jackson.databind.deser.SettableBeanProperty) r11
            int r0 = r10 + 1
            r0 = r4[r0]
            r11.set(r3, r0)
            int r10 = r10 + 2
            goto L_0x00f0
        L_0x0100:
            if (r6 == 0) goto L_0x010d
            int r10 = r6.length
        L_0x0103:
            if (r1 >= r10) goto L_0x010d
            r11 = r6[r1]
            r3.addSuppressed(r11)
            int r1 = r1 + 1
            goto L_0x0103
        L_0x010d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.ThrowableDeserializer.deserializeFromObject(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.lang.Object");
    }

    public JsonDeserializer<Object> unwrappingDeserializer(NameTransformer nameTransformer) {
        if (getClass() != ThrowableDeserializer.class) {
            return this;
        }
        return new ThrowableDeserializer(this, nameTransformer);
    }

    public ThrowableDeserializer(BeanDeserializer beanDeserializer, NameTransformer nameTransformer) {
        super((BeanDeserializerBase) beanDeserializer, nameTransformer);
    }
}
