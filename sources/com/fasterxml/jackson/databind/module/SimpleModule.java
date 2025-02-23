package com.fasterxml.jackson.databind.module;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleModule extends Module implements Serializable {
    private static final AtomicInteger MODULE_ID_SEQ = new AtomicInteger(1);
    private static final long serialVersionUID = 1;
    protected BeanDeserializerModifier _deserializerModifier = null;
    protected final boolean _hasExplicitName;
    protected SimpleSerializers _keySerializers = null;
    protected HashMap<Class<?>, Class<?>> _mixins = null;
    protected final String _name;
    protected PropertyNamingStrategy _namingStrategy = null;
    protected BeanSerializerModifier _serializerModifier = null;
    protected SimpleSerializers _serializers = null;
    protected LinkedHashSet<NamedType> _subtypes = null;
    protected final Version _version;

    public SimpleModule() {
        String str;
        if (getClass() == SimpleModule.class) {
            str = "SimpleModule-" + MODULE_ID_SEQ.getAndIncrement();
        } else {
            str = getClass().getName();
        }
        this._name = str;
        this._version = Version.unknownVersion();
        this._hasExplicitName = false;
    }

    public void _checkNotNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(String.format("Cannot pass `null` as %s", new Object[]{str}));
        }
    }

    public <T> SimpleModule addSerializer(Class<? extends T> cls, JsonSerializer<T> jsonSerializer) {
        _checkNotNull(cls, "type to register serializer for");
        _checkNotNull(jsonSerializer, "serializer");
        if (this._serializers == null) {
            this._serializers = new SimpleSerializers();
        }
        this._serializers.addSerializer(cls, jsonSerializer);
        return this;
    }

    public String getModuleName() {
        return this._name;
    }

    public Object getTypeId() {
        if (this._hasExplicitName) {
            return this._name;
        }
        if (getClass() == SimpleModule.class) {
            return this._name;
        }
        return super.getTypeId();
    }

    public void setupModule(Module.SetupContext setupContext) {
        SimpleSerializers simpleSerializers = this._serializers;
        if (simpleSerializers != null) {
            setupContext.addSerializers(simpleSerializers);
        }
        SimpleSerializers simpleSerializers2 = this._keySerializers;
        if (simpleSerializers2 != null) {
            setupContext.addKeySerializers(simpleSerializers2);
        }
        BeanDeserializerModifier beanDeserializerModifier = this._deserializerModifier;
        if (beanDeserializerModifier != null) {
            setupContext.addBeanDeserializerModifier(beanDeserializerModifier);
        }
        BeanSerializerModifier beanSerializerModifier = this._serializerModifier;
        if (beanSerializerModifier != null) {
            setupContext.addBeanSerializerModifier(beanSerializerModifier);
        }
        LinkedHashSet<NamedType> linkedHashSet = this._subtypes;
        if (linkedHashSet != null && linkedHashSet.size() > 0) {
            LinkedHashSet<NamedType> linkedHashSet2 = this._subtypes;
            setupContext.registerSubtypes((NamedType[]) linkedHashSet2.toArray(new NamedType[linkedHashSet2.size()]));
        }
        PropertyNamingStrategy propertyNamingStrategy = this._namingStrategy;
        if (propertyNamingStrategy != null) {
            setupContext.setNamingStrategy(propertyNamingStrategy);
        }
        HashMap<Class<?>, Class<?>> hashMap = this._mixins;
        if (hashMap != null) {
            for (Map.Entry next : hashMap.entrySet()) {
                setupContext.setMixInAnnotations((Class) next.getKey(), (Class) next.getValue());
            }
        }
    }

    public Version version() {
        return this._version;
    }
}
