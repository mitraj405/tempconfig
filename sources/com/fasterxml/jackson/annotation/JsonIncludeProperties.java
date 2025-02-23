package com.fasterxml.jackson.annotation;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonIncludeProperties {

    public static class Value implements Serializable {
        protected static final Value ALL = new Value((Set<String>) null);
        private static final long serialVersionUID = 1;
        protected final Set<String> _included;

        public Value(Set<String> set) {
            this._included = set;
        }

        private static Set<String> _asSet(String[] strArr) {
            if (strArr == null || strArr.length == 0) {
                return Collections.emptySet();
            }
            HashSet hashSet = new HashSet(strArr.length);
            for (String add : strArr) {
                hashSet.add(add);
            }
            return hashSet;
        }

        private static boolean _equals(Set<String> set, Set<String> set2) {
            if (set != null) {
                return set.equals(set2);
            }
            if (set2 == null) {
                return true;
            }
            return false;
        }

        public static Value all() {
            return ALL;
        }

        public static Value from(JsonIncludeProperties jsonIncludeProperties) {
            if (jsonIncludeProperties == null) {
                return ALL;
            }
            return new Value(_asSet(jsonIncludeProperties.value()));
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (obj.getClass() != getClass() || !_equals(this._included, ((Value) obj)._included)) {
                return false;
            }
            return true;
        }

        public Set<String> getIncluded() {
            return this._included;
        }

        public int hashCode() {
            Set<String> set = this._included;
            if (set == null) {
                return 0;
            }
            return set.size();
        }

        public String toString() {
            return String.format("JsonIncludeProperties.Value(included=%s)", new Object[]{this._included});
        }
    }

    String[] value() default {};
}
