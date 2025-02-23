package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AccessorNamingStrategy;
import com.fasterxml.jackson.databind.jdk14.JDK14Util;
import java.util.HashSet;
import java.util.Set;

public class DefaultAccessorNamingStrategy extends AccessorNamingStrategy {
    protected final MapperConfig<?> _config;
    protected final AnnotatedClass _forClass;
    protected final String _getterPrefix;
    protected final String _isGetterPrefix;
    protected final String _mutatorPrefix;
    protected final boolean _stdBeanNaming;

    public interface BaseNameValidator {
    }

    public static class Provider extends AccessorNamingStrategy.Provider {
        private static final long serialVersionUID = 1;
        protected final String _getterPrefix;
        protected final String _isGetterPrefix;
        protected final String _setterPrefix;
        protected final String _withPrefix;

        public Provider() {
            this("set", "with", "get", "is", (BaseNameValidator) null);
        }

        public AccessorNamingStrategy forBuilder(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, BeanDescription beanDescription) {
            AnnotationIntrospector annotationIntrospector;
            String str;
            JsonPOJOBuilder.Value value = null;
            if (mapperConfig.isAnnotationProcessingEnabled()) {
                annotationIntrospector = mapperConfig.getAnnotationIntrospector();
            } else {
                annotationIntrospector = null;
            }
            if (annotationIntrospector != null) {
                value = annotationIntrospector.findPOJOBuilderConfig(annotatedClass);
            }
            if (value == null) {
                str = this._withPrefix;
            } else {
                str = value.withPrefix;
            }
            return new DefaultAccessorNamingStrategy(mapperConfig, annotatedClass, str, this._getterPrefix, this._isGetterPrefix, (BaseNameValidator) null);
        }

        public AccessorNamingStrategy forPOJO(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass) {
            return new DefaultAccessorNamingStrategy(mapperConfig, annotatedClass, this._setterPrefix, this._getterPrefix, this._isGetterPrefix, (BaseNameValidator) null);
        }

        public AccessorNamingStrategy forRecord(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass) {
            return new RecordNaming(mapperConfig, annotatedClass);
        }

        public Provider(String str, String str2, String str3, String str4, BaseNameValidator baseNameValidator) {
            this._setterPrefix = str;
            this._withPrefix = str2;
            this._getterPrefix = str3;
            this._isGetterPrefix = str4;
        }
    }

    public static class RecordNaming extends DefaultAccessorNamingStrategy {
        protected final Set<String> _fieldNames = new HashSet();

        public RecordNaming(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass) {
            super(mapperConfig, annotatedClass, (String) null, "get", "is", (BaseNameValidator) null);
            for (String add : JDK14Util.getRecordFieldNames(annotatedClass.getRawType())) {
                this._fieldNames.add(add);
            }
        }

        public String findNameForRegularGetter(AnnotatedMethod annotatedMethod, String str) {
            if (this._fieldNames.contains(str)) {
                return str;
            }
            return DefaultAccessorNamingStrategy.super.findNameForRegularGetter(annotatedMethod, str);
        }
    }

    public DefaultAccessorNamingStrategy(MapperConfig<?> mapperConfig, AnnotatedClass annotatedClass, String str, String str2, String str3, BaseNameValidator baseNameValidator) {
        this._config = mapperConfig;
        this._forClass = annotatedClass;
        this._stdBeanNaming = mapperConfig.isEnabled(MapperFeature.USE_STD_BEAN_NAMING);
        this._mutatorPrefix = str;
        this._getterPrefix = str2;
        this._isGetterPrefix = str3;
    }

    public boolean _isCglibGetCallbacks(AnnotatedMethod annotatedMethod) {
        Class<?> rawType = annotatedMethod.getRawType();
        if (!rawType.isArray()) {
            return false;
        }
        String name = rawType.getComponentType().getName();
        if (!name.contains(".cglib")) {
            return false;
        }
        if (name.startsWith("net.sf.cglib") || name.startsWith("org.hibernate.repackage.cglib") || name.startsWith("org.springframework.cglib")) {
            return true;
        }
        return false;
    }

    public boolean _isGroovyMetaClassGetter(AnnotatedMethod annotatedMethod) {
        return annotatedMethod.getRawType().getName().startsWith("groovy.lang");
    }

    public String findNameForIsGetter(AnnotatedMethod annotatedMethod, String str) {
        if (this._isGetterPrefix == null) {
            return null;
        }
        Class<?> rawType = annotatedMethod.getRawType();
        if ((rawType != Boolean.class && rawType != Boolean.TYPE) || !str.startsWith(this._isGetterPrefix)) {
            return null;
        }
        if (this._stdBeanNaming) {
            return stdManglePropertyName(str, 2);
        }
        return legacyManglePropertyName(str, 2);
    }

    public String findNameForMutator(AnnotatedMethod annotatedMethod, String str) {
        String str2 = this._mutatorPrefix;
        if (str2 == null || !str.startsWith(str2)) {
            return null;
        }
        if (this._stdBeanNaming) {
            return stdManglePropertyName(str, this._mutatorPrefix.length());
        }
        return legacyManglePropertyName(str, this._mutatorPrefix.length());
    }

    public String findNameForRegularGetter(AnnotatedMethod annotatedMethod, String str) {
        String str2 = this._getterPrefix;
        if (str2 == null || !str.startsWith(str2)) {
            return null;
        }
        if ("getCallbacks".equals(str)) {
            if (_isCglibGetCallbacks(annotatedMethod)) {
                return null;
            }
        } else if ("getMetaClass".equals(str) && _isGroovyMetaClassGetter(annotatedMethod)) {
            return null;
        }
        if (this._stdBeanNaming) {
            return stdManglePropertyName(str, this._getterPrefix.length());
        }
        return legacyManglePropertyName(str, this._getterPrefix.length());
    }

    public String legacyManglePropertyName(String str, int i) {
        int length = str.length();
        if (length == i) {
            return null;
        }
        char charAt = str.charAt(i);
        char lowerCase = Character.toLowerCase(charAt);
        if (charAt == lowerCase) {
            return str.substring(i);
        }
        StringBuilder sb = new StringBuilder(length - i);
        sb.append(lowerCase);
        while (true) {
            i++;
            if (i >= length) {
                break;
            }
            char charAt2 = str.charAt(i);
            char lowerCase2 = Character.toLowerCase(charAt2);
            if (charAt2 == lowerCase2) {
                sb.append(str, i, length);
                break;
            }
            sb.append(lowerCase2);
        }
        return sb.toString();
    }

    public String stdManglePropertyName(String str, int i) {
        int length = str.length();
        if (length == i) {
            return null;
        }
        char charAt = str.charAt(i);
        char lowerCase = Character.toLowerCase(charAt);
        if (charAt == lowerCase) {
            return str.substring(i);
        }
        int i2 = i + 1;
        if (i2 < length && Character.isUpperCase(str.charAt(i2))) {
            return str.substring(i);
        }
        StringBuilder sb = new StringBuilder(length - i);
        sb.append(lowerCase);
        sb.append(str, i2, length);
        return sb.toString();
    }

    public String modifyFieldName(AnnotatedField annotatedField, String str) {
        return str;
    }
}
