package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonInclude {

    public enum Include {
        ALWAYS,
        NON_NULL,
        NON_ABSENT,
        NON_EMPTY,
        NON_DEFAULT,
        CUSTOM,
        USE_DEFAULTS
    }

    Include content() default Include.ALWAYS;

    Class<?> contentFilter() default Void.class;

    Include value() default Include.ALWAYS;

    Class<?> valueFilter() default Void.class;

    public static class Value implements Serializable {
        protected static final Value EMPTY;
        private static final long serialVersionUID = 1;
        protected final Class<?> _contentFilter;
        protected final Include _contentInclusion;
        protected final Class<?> _valueFilter;
        protected final Include _valueInclusion;

        static {
            Include include = Include.USE_DEFAULTS;
            EMPTY = new Value(include, include, (Class<?>) null, (Class<?>) null);
        }

        public Value(Include include, Include include2, Class<?> cls, Class<?> cls2) {
            this._valueInclusion = include == null ? Include.USE_DEFAULTS : include;
            this._contentInclusion = include2 == null ? Include.USE_DEFAULTS : include2;
            Class<Void> cls3 = Void.class;
            this._valueFilter = cls == cls3 ? null : cls;
            this._contentFilter = cls2 == cls3 ? null : cls2;
        }

        public static Value construct(Include include, Include include2) {
            Include include3 = Include.USE_DEFAULTS;
            if ((include == include3 || include == null) && (include2 == include3 || include2 == null)) {
                return EMPTY;
            }
            return new Value(include, include2, (Class<?>) null, (Class<?>) null);
        }

        public static Value empty() {
            return EMPTY;
        }

        public static Value from(JsonInclude jsonInclude) {
            if (jsonInclude == null) {
                return EMPTY;
            }
            Include value = jsonInclude.value();
            Include content = jsonInclude.content();
            Include include = Include.USE_DEFAULTS;
            if (value == include && content == include) {
                return EMPTY;
            }
            Class<?> valueFilter = jsonInclude.valueFilter();
            Class<?> cls = null;
            Class<Void> cls2 = Void.class;
            if (valueFilter == cls2) {
                valueFilter = null;
            }
            Class<?> contentFilter = jsonInclude.contentFilter();
            if (contentFilter != cls2) {
                cls = contentFilter;
            }
            return new Value(value, content, valueFilter, cls);
        }

        public static Value merge(Value value, Value value2) {
            if (value == null) {
                return value2;
            }
            return value.withOverrides(value2);
        }

        public static Value mergeAll(Value... valueArr) {
            Value value = null;
            for (Value value2 : valueArr) {
                if (value2 != null) {
                    if (value != null) {
                        value2 = value.withOverrides(value2);
                    }
                    value = value2;
                }
            }
            return value;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            Value value = (Value) obj;
            if (value._valueInclusion == this._valueInclusion && value._contentInclusion == this._contentInclusion && value._valueFilter == this._valueFilter && value._contentFilter == this._contentFilter) {
                return true;
            }
            return false;
        }

        public Class<?> getContentFilter() {
            return this._contentFilter;
        }

        public Include getContentInclusion() {
            return this._contentInclusion;
        }

        public Class<?> getValueFilter() {
            return this._valueFilter;
        }

        public Include getValueInclusion() {
            return this._valueInclusion;
        }

        public int hashCode() {
            return this._contentInclusion.hashCode() + (this._valueInclusion.hashCode() << 2);
        }

        public Object readResolve() {
            Include include = this._valueInclusion;
            Include include2 = Include.USE_DEFAULTS;
            if (include == include2 && this._contentInclusion == include2 && this._valueFilter == null && this._contentFilter == null) {
                return EMPTY;
            }
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(80);
            sb.append("JsonInclude.Value(value=");
            sb.append(this._valueInclusion);
            sb.append(",content=");
            sb.append(this._contentInclusion);
            if (this._valueFilter != null) {
                sb.append(",valueFilter=");
                sb.append(this._valueFilter.getName());
                sb.append(".class");
            }
            if (this._contentFilter != null) {
                sb.append(",contentFilter=");
                sb.append(this._contentFilter.getName());
                sb.append(".class");
            }
            sb.append(')');
            return sb.toString();
        }

        public Value withContentFilter(Class<?> cls) {
            Include include;
            if (cls == null || cls == Void.class) {
                include = Include.USE_DEFAULTS;
                cls = null;
            } else {
                include = Include.CUSTOM;
            }
            return construct(this._valueInclusion, include, this._valueFilter, cls);
        }

        public Value withContentInclusion(Include include) {
            if (include == this._contentInclusion) {
                return this;
            }
            return new Value(this._valueInclusion, include, this._valueFilter, this._contentFilter);
        }

        public Value withOverrides(Value value) {
            boolean z;
            boolean z2;
            if (!(value == null || value == EMPTY)) {
                Include include = value._valueInclusion;
                Include include2 = value._contentInclusion;
                Class<?> cls = value._valueFilter;
                Class<?> cls2 = value._contentFilter;
                Include include3 = this._valueInclusion;
                boolean z3 = true;
                if (include == include3 || include == Include.USE_DEFAULTS) {
                    z = false;
                } else {
                    z = true;
                }
                Include include4 = this._contentInclusion;
                if (include2 == include4 || include2 == Include.USE_DEFAULTS) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                Class<?> cls3 = this._valueFilter;
                if (cls == cls3 && cls2 == cls3) {
                    z3 = false;
                }
                if (z) {
                    if (z2) {
                        return new Value(include, include2, cls, cls2);
                    }
                    return new Value(include, include4, cls, cls2);
                } else if (z2) {
                    return new Value(include3, include2, cls, cls2);
                } else {
                    if (z3) {
                        return new Value(include3, include4, cls, cls2);
                    }
                }
            }
            return this;
        }

        public Value withValueInclusion(Include include) {
            if (include == this._valueInclusion) {
                return this;
            }
            return new Value(include, this._contentInclusion, this._valueFilter, this._contentFilter);
        }

        public static Value construct(Include include, Include include2, Class<?> cls, Class<?> cls2) {
            Class<Void> cls3 = Void.class;
            if (cls == cls3) {
                cls = null;
            }
            if (cls2 == cls3) {
                cls2 = null;
            }
            Include include3 = Include.USE_DEFAULTS;
            if ((include == include3 || include == null) && ((include2 == include3 || include2 == null) && cls == null && cls2 == null)) {
                return EMPTY;
            }
            return new Value(include, include2, cls, cls2);
        }
    }
}
