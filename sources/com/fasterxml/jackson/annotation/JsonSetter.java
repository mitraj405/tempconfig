package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonSetter {

    public static class Value implements Serializable {
        protected static final Value EMPTY;
        private static final long serialVersionUID = 1;
        private final Nulls _contentNulls;
        private final Nulls _nulls;

        static {
            Nulls nulls = Nulls.DEFAULT;
            EMPTY = new Value(nulls, nulls);
        }

        public Value(Nulls nulls, Nulls nulls2) {
            this._nulls = nulls;
            this._contentNulls = nulls2;
        }

        private static boolean _empty(Nulls nulls, Nulls nulls2) {
            Nulls nulls3 = Nulls.DEFAULT;
            if (nulls == nulls3 && nulls2 == nulls3) {
                return true;
            }
            return false;
        }

        public static Value construct(Nulls nulls, Nulls nulls2) {
            if (nulls == null) {
                nulls = Nulls.DEFAULT;
            }
            if (nulls2 == null) {
                nulls2 = Nulls.DEFAULT;
            }
            if (_empty(nulls, nulls2)) {
                return EMPTY;
            }
            return new Value(nulls, nulls2);
        }

        public static Value empty() {
            return EMPTY;
        }

        public static Value from(JsonSetter jsonSetter) {
            if (jsonSetter == null) {
                return EMPTY;
            }
            return construct(jsonSetter.nulls(), jsonSetter.contentNulls());
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            Value value = (Value) obj;
            if (value._nulls == this._nulls && value._contentNulls == this._contentNulls) {
                return true;
            }
            return false;
        }

        public Nulls getContentNulls() {
            return this._contentNulls;
        }

        public int hashCode() {
            return this._nulls.ordinal() + (this._contentNulls.ordinal() << 2);
        }

        public Nulls nonDefaultContentNulls() {
            Nulls nulls = this._contentNulls;
            if (nulls == Nulls.DEFAULT) {
                return null;
            }
            return nulls;
        }

        public Nulls nonDefaultValueNulls() {
            Nulls nulls = this._nulls;
            if (nulls == Nulls.DEFAULT) {
                return null;
            }
            return nulls;
        }

        public Object readResolve() {
            if (_empty(this._nulls, this._contentNulls)) {
                return EMPTY;
            }
            return this;
        }

        public String toString() {
            return String.format("JsonSetter.Value(valueNulls=%s,contentNulls=%s)", new Object[]{this._nulls, this._contentNulls});
        }
    }

    Nulls contentNulls() default Nulls.DEFAULT;

    Nulls nulls() default Nulls.DEFAULT;

    String value() default "";
}
