package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

public class BasicClassIntrospector extends ClassIntrospector implements Serializable {
    protected static final BasicBeanDescription BOOLEAN_DESC;
    private static final Class<?> CLS_JSON_NODE = JsonNode.class;
    private static final Class<?> CLS_OBJECT;
    private static final Class<?> CLS_STRING;
    protected static final BasicBeanDescription INT_DESC;
    protected static final BasicBeanDescription LONG_DESC;
    protected static final BasicBeanDescription OBJECT_DESC;
    protected static final BasicBeanDescription STRING_DESC;
    private static final long serialVersionUID = 2;

    static {
        Class<Object> cls = Object.class;
        CLS_OBJECT = cls;
        Class<String> cls2 = String.class;
        CLS_STRING = cls2;
        STRING_DESC = BasicBeanDescription.forOtherUse((MapperConfig<?>) null, SimpleType.constructUnsafe(cls2), AnnotatedClassResolver.createPrimordial(cls2));
        Class cls3 = Boolean.TYPE;
        BOOLEAN_DESC = BasicBeanDescription.forOtherUse((MapperConfig<?>) null, SimpleType.constructUnsafe(cls3), AnnotatedClassResolver.createPrimordial(cls3));
        Class cls4 = Integer.TYPE;
        INT_DESC = BasicBeanDescription.forOtherUse((MapperConfig<?>) null, SimpleType.constructUnsafe(cls4), AnnotatedClassResolver.createPrimordial(cls4));
        Class cls5 = Long.TYPE;
        LONG_DESC = BasicBeanDescription.forOtherUse((MapperConfig<?>) null, SimpleType.constructUnsafe(cls5), AnnotatedClassResolver.createPrimordial(cls5));
        OBJECT_DESC = BasicBeanDescription.forOtherUse((MapperConfig<?>) null, SimpleType.constructUnsafe(cls), AnnotatedClassResolver.createPrimordial(cls));
    }

    public BasicBeanDescription _findStdJdkCollectionDesc(MapperConfig<?> mapperConfig, JavaType javaType) {
        if (_isStdJDKCollection(javaType)) {
            return BasicBeanDescription.forOtherUse(mapperConfig, javaType, _resolveAnnotatedClass(mapperConfig, javaType, mapperConfig));
        }
        return null;
    }

    public BasicBeanDescription _findStdTypeDesc(MapperConfig<?> mapperConfig, JavaType javaType) {
        Class<?> rawClass = javaType.getRawClass();
        if (rawClass.isPrimitive()) {
            if (rawClass == Integer.TYPE) {
                return INT_DESC;
            }
            if (rawClass == Long.TYPE) {
                return LONG_DESC;
            }
            if (rawClass == Boolean.TYPE) {
                return BOOLEAN_DESC;
            }
            return null;
        } else if (ClassUtil.isJDKClass(rawClass)) {
            if (rawClass == CLS_OBJECT) {
                return OBJECT_DESC;
            }
            if (rawClass == CLS_STRING) {
                return STRING_DESC;
            }
            if (rawClass == Integer.class) {
                return INT_DESC;
            }
            if (rawClass == Long.class) {
                return LONG_DESC;
            }
            if (rawClass == Boolean.class) {
                return BOOLEAN_DESC;
            }
            return null;
        } else if (CLS_JSON_NODE.isAssignableFrom(rawClass)) {
            return BasicBeanDescription.forOtherUse(mapperConfig, javaType, AnnotatedClassResolver.createPrimordial(rawClass));
        } else {
            return null;
        }
    }

    public boolean _isStdJDKCollection(JavaType javaType) {
        if (javaType.isContainerType() && !javaType.isArrayType()) {
            Class<?> rawClass = javaType.getRawClass();
            if (!ClassUtil.isJDKClass(rawClass) || (!Collection.class.isAssignableFrom(rawClass) && !Map.class.isAssignableFrom(rawClass))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public AnnotatedClass _resolveAnnotatedClass(MapperConfig<?> mapperConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver) {
        return AnnotatedClassResolver.resolve(mapperConfig, javaType, mixInResolver);
    }

    public POJOPropertiesCollector collectProperties(MapperConfig<?> mapperConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver, boolean z) {
        AccessorNamingStrategy accessorNamingStrategy;
        AnnotatedClass _resolveAnnotatedClass = _resolveAnnotatedClass(mapperConfig, javaType, mixInResolver);
        if (javaType.isRecordType()) {
            accessorNamingStrategy = mapperConfig.getAccessorNaming().forRecord(mapperConfig, _resolveAnnotatedClass);
        } else {
            accessorNamingStrategy = mapperConfig.getAccessorNaming().forPOJO(mapperConfig, _resolveAnnotatedClass);
        }
        return constructPropertyCollector(mapperConfig, _resolveAnnotatedClass, javaType, z, accessorNamingStrategy);
    }

    public POJOPropertiesCollector collectPropertiesWithBuilder(MapperConfig<?> mapperConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver, BeanDescription beanDescription, boolean z) {
        AnnotatedClass _resolveAnnotatedClass = _resolveAnnotatedClass(mapperConfig, javaType, mixInResolver);
        return constructPropertyCollector(mapperConfig, _resolveAnnotatedClass, javaType, z, mapperConfig.getAccessorNaming().forBuilder(mapperConfig, _resolveAnnotatedClass, beanDescription));
    }

    public POJOPropertiesCollector constructPropertyCollector(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, JavaType javaType, boolean z, AccessorNamingStrategy accessorNamingStrategy) {
        return new POJOPropertiesCollector(mapperConfig, z, javaType, annotatedClass, accessorNamingStrategy);
    }

    public BasicBeanDescription forClassAnnotations(MapperConfig<?> mapperConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver) {
        BasicBeanDescription _findStdTypeDesc = _findStdTypeDesc(mapperConfig, javaType);
        return _findStdTypeDesc == null ? BasicBeanDescription.forOtherUse(mapperConfig, javaType, _resolveAnnotatedClass(mapperConfig, javaType, mixInResolver)) : _findStdTypeDesc;
    }

    public BasicBeanDescription forCreation(DeserializationConfig deserializationConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver) {
        BasicBeanDescription _findStdTypeDesc = _findStdTypeDesc(deserializationConfig, javaType);
        if (_findStdTypeDesc != null) {
            return _findStdTypeDesc;
        }
        BasicBeanDescription _findStdJdkCollectionDesc = _findStdJdkCollectionDesc(deserializationConfig, javaType);
        return _findStdJdkCollectionDesc == null ? BasicBeanDescription.forDeserialization(collectProperties(deserializationConfig, javaType, mixInResolver, false)) : _findStdJdkCollectionDesc;
    }

    public BasicBeanDescription forDeserialization(DeserializationConfig deserializationConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver) {
        BasicBeanDescription _findStdTypeDesc = _findStdTypeDesc(deserializationConfig, javaType);
        if (_findStdTypeDesc != null) {
            return _findStdTypeDesc;
        }
        BasicBeanDescription _findStdJdkCollectionDesc = _findStdJdkCollectionDesc(deserializationConfig, javaType);
        return _findStdJdkCollectionDesc == null ? BasicBeanDescription.forDeserialization(collectProperties(deserializationConfig, javaType, mixInResolver, false)) : _findStdJdkCollectionDesc;
    }

    public BasicBeanDescription forDeserializationWithBuilder(DeserializationConfig deserializationConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver, BeanDescription beanDescription) {
        return BasicBeanDescription.forDeserialization(collectPropertiesWithBuilder(deserializationConfig, javaType, mixInResolver, beanDescription, false));
    }

    public BasicBeanDescription forSerialization(SerializationConfig serializationConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver) {
        BasicBeanDescription _findStdTypeDesc = _findStdTypeDesc(serializationConfig, javaType);
        if (_findStdTypeDesc != null) {
            return _findStdTypeDesc;
        }
        BasicBeanDescription _findStdJdkCollectionDesc = _findStdJdkCollectionDesc(serializationConfig, javaType);
        return _findStdJdkCollectionDesc == null ? BasicBeanDescription.forSerialization(collectProperties(serializationConfig, javaType, mixInResolver, true)) : _findStdJdkCollectionDesc;
    }
}
