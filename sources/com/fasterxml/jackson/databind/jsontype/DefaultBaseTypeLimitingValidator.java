package com.fasterxml.jackson.databind.jsontype;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import java.io.Closeable;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class DefaultBaseTypeLimitingValidator extends PolymorphicTypeValidator {
    private static final long serialVersionUID = 1;

    public static final class UnsafeBaseTypes {
        public static final UnsafeBaseTypes instance = new UnsafeBaseTypes();
        private final Set<String> UNSAFE;

        private UnsafeBaseTypes() {
            HashSet hashSet = new HashSet();
            this.UNSAFE = hashSet;
            hashSet.add(Object.class.getName());
            hashSet.add(Closeable.class.getName());
            hashSet.add(Serializable.class.getName());
            hashSet.add(AutoCloseable.class.getName());
            hashSet.add(Cloneable.class.getName());
            hashSet.add("java.util.logging.Handler");
            hashSet.add("javax.naming.Referenceable");
            hashSet.add("javax.sql.DataSource");
        }

        public boolean isUnsafeBaseType(Class<?> cls) {
            return this.UNSAFE.contains(cls.getName());
        }
    }

    public boolean isSafeSubType(MapperConfig<?> mapperConfig, JavaType javaType, JavaType javaType2) {
        return true;
    }

    public boolean isUnsafeBaseType(MapperConfig<?> mapperConfig, JavaType javaType) {
        return UnsafeBaseTypes.instance.isUnsafeBaseType(javaType.getRawClass());
    }

    public PolymorphicTypeValidator.Validity validateBaseType(MapperConfig<?> mapperConfig, JavaType javaType) {
        if (isUnsafeBaseType(mapperConfig, javaType)) {
            return PolymorphicTypeValidator.Validity.DENIED;
        }
        return PolymorphicTypeValidator.Validity.INDETERMINATE;
    }

    public PolymorphicTypeValidator.Validity validateSubClassName(MapperConfig<?> mapperConfig, JavaType javaType, String str) {
        return PolymorphicTypeValidator.Validity.INDETERMINATE;
    }

    public PolymorphicTypeValidator.Validity validateSubType(MapperConfig<?> mapperConfig, JavaType javaType, JavaType javaType2) {
        if (isSafeSubType(mapperConfig, javaType, javaType2)) {
            return PolymorphicTypeValidator.Validity.ALLOWED;
        }
        return PolymorphicTypeValidator.Validity.DENIED;
    }
}
