package com.fasterxml.jackson.databind.module;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.ClassKey;
import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.MapLikeType;
import com.fasterxml.jackson.databind.type.MapType;
import java.io.Serializable;
import java.util.HashMap;

public class SimpleSerializers extends Serializers.Base implements Serializable {
    private static final long serialVersionUID = 3;
    protected HashMap<ClassKey, JsonSerializer<?>> _classMappings = null;
    protected boolean _hasEnumSerializer = false;
    protected HashMap<ClassKey, JsonSerializer<?>> _interfaceMappings = null;

    public void _addSerializer(Class<?> cls, JsonSerializer<?> jsonSerializer) {
        ClassKey classKey = new ClassKey(cls);
        if (cls.isInterface()) {
            if (this._interfaceMappings == null) {
                this._interfaceMappings = new HashMap<>();
            }
            this._interfaceMappings.put(classKey, jsonSerializer);
            return;
        }
        if (this._classMappings == null) {
            this._classMappings = new HashMap<>();
        }
        this._classMappings.put(classKey, jsonSerializer);
        if (cls == Enum.class) {
            this._hasEnumSerializer = true;
        }
    }

    public JsonSerializer<?> _findInterfaceMapping(Class<?> cls, ClassKey classKey) {
        for (Class cls2 : cls.getInterfaces()) {
            classKey.reset(cls2);
            JsonSerializer<?> jsonSerializer = this._interfaceMappings.get(classKey);
            if (jsonSerializer != null) {
                return jsonSerializer;
            }
            JsonSerializer<?> _findInterfaceMapping = _findInterfaceMapping(cls2, classKey);
            if (_findInterfaceMapping != null) {
                return _findInterfaceMapping;
            }
        }
        return null;
    }

    public <T> void addSerializer(Class<? extends T> cls, JsonSerializer<T> jsonSerializer) {
        _addSerializer(cls, jsonSerializer);
    }

    public JsonSerializer<?> findArraySerializer(SerializationConfig serializationConfig, ArrayType arrayType, BeanDescription beanDescription, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        return findSerializer(serializationConfig, arrayType, beanDescription);
    }

    public JsonSerializer<?> findCollectionLikeSerializer(SerializationConfig serializationConfig, CollectionLikeType collectionLikeType, BeanDescription beanDescription, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        return findSerializer(serializationConfig, collectionLikeType, beanDescription);
    }

    public JsonSerializer<?> findCollectionSerializer(SerializationConfig serializationConfig, CollectionType collectionType, BeanDescription beanDescription, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer) {
        return findSerializer(serializationConfig, collectionType, beanDescription);
    }

    public JsonSerializer<?> findMapLikeSerializer(SerializationConfig serializationConfig, MapLikeType mapLikeType, BeanDescription beanDescription, JsonSerializer<Object> jsonSerializer, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer2) {
        return findSerializer(serializationConfig, mapLikeType, beanDescription);
    }

    public JsonSerializer<?> findMapSerializer(SerializationConfig serializationConfig, MapType mapType, BeanDescription beanDescription, JsonSerializer<Object> jsonSerializer, TypeSerializer typeSerializer, JsonSerializer<Object> jsonSerializer2) {
        return findSerializer(serializationConfig, mapType, beanDescription);
    }

    public JsonSerializer<?> findSerializer(SerializationConfig serializationConfig, JavaType javaType, BeanDescription beanDescription) {
        JsonSerializer<?> _findInterfaceMapping;
        JsonSerializer<?> jsonSerializer;
        Class rawClass = javaType.getRawClass();
        ClassKey classKey = new ClassKey(rawClass);
        if (rawClass.isInterface()) {
            HashMap<ClassKey, JsonSerializer<?>> hashMap = this._interfaceMappings;
            if (!(hashMap == null || (jsonSerializer = hashMap.get(classKey)) == null)) {
                return jsonSerializer;
            }
        } else {
            HashMap<ClassKey, JsonSerializer<?>> hashMap2 = this._classMappings;
            if (hashMap2 != null) {
                JsonSerializer<?> jsonSerializer2 = hashMap2.get(classKey);
                if (jsonSerializer2 != null) {
                    return jsonSerializer2;
                }
                if (this._hasEnumSerializer && javaType.isEnumType()) {
                    classKey.reset(Enum.class);
                    JsonSerializer<?> jsonSerializer3 = this._classMappings.get(classKey);
                    if (jsonSerializer3 != null) {
                        return jsonSerializer3;
                    }
                }
                for (Class cls = rawClass; cls != null; cls = cls.getSuperclass()) {
                    classKey.reset(cls);
                    JsonSerializer<?> jsonSerializer4 = this._classMappings.get(classKey);
                    if (jsonSerializer4 != null) {
                        return jsonSerializer4;
                    }
                }
            }
        }
        if (this._interfaceMappings == null) {
            return null;
        }
        JsonSerializer<?> _findInterfaceMapping2 = _findInterfaceMapping(rawClass, classKey);
        if (_findInterfaceMapping2 != null) {
            return _findInterfaceMapping2;
        }
        if (rawClass.isInterface()) {
            return null;
        }
        do {
            rawClass = rawClass.getSuperclass();
            if (rawClass == null) {
                return null;
            }
            _findInterfaceMapping = _findInterfaceMapping(rawClass, classKey);
        } while (_findInterfaceMapping == null);
        return _findInterfaceMapping;
    }
}
