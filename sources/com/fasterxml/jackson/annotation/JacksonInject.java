package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JacksonInject {

    public static class Value implements Serializable {
        protected static final Value EMPTY = new Value((Object) null, (Boolean) null);
        private static final long serialVersionUID = 1;
        protected final Object _id;
        protected final Boolean _useInput;

        public Value(Object obj, Boolean bool) {
            this._id = obj;
            this._useInput = bool;
        }

        private static boolean _empty(Object obj, Boolean bool) {
            if (obj == null && bool == null) {
                return true;
            }
            return false;
        }

        public static Value construct(Object obj, Boolean bool) {
            if ("".equals(obj)) {
                obj = null;
            }
            if (_empty(obj, bool)) {
                return EMPTY;
            }
            return new Value(obj, bool);
        }

        public static Value forId(Object obj) {
            return construct(obj, (Boolean) null);
        }

        public static Value from(JacksonInject jacksonInject) {
            if (jacksonInject == null) {
                return EMPTY;
            }
            return construct(jacksonInject.value(), jacksonInject.useInput().asBoolean());
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj != null && obj.getClass() == getClass()) {
                Value value = (Value) obj;
                if (OptBoolean.equals(this._useInput, value._useInput)) {
                    Object obj2 = this._id;
                    if (obj2 != null) {
                        return obj2.equals(value._id);
                    }
                    if (value._id == null) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        }

        public Object getId() {
            return this._id;
        }

        public boolean hasId() {
            if (this._id != null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            Object obj = this._id;
            int i = 1;
            if (obj != null) {
                i = 1 + obj.hashCode();
            }
            Boolean bool = this._useInput;
            if (bool != null) {
                return i + bool.hashCode();
            }
            return i;
        }

        public String toString() {
            return String.format("JacksonInject.Value(id=%s,useInput=%s)", new Object[]{this._id, this._useInput});
        }

        public boolean willUseInput(boolean z) {
            Boolean bool = this._useInput;
            if (bool == null) {
                return z;
            }
            return bool.booleanValue();
        }

        public Value withId(Object obj) {
            if (obj == null) {
                if (this._id == null) {
                    return this;
                }
            } else if (obj.equals(this._id)) {
                return this;
            }
            return new Value(obj, this._useInput);
        }
    }

    OptBoolean useInput() default OptBoolean.DEFAULT;

    String value() default "";
}
