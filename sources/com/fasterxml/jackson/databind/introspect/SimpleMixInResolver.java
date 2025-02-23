package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.type.ClassKey;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class SimpleMixInResolver implements ClassIntrospector.MixInResolver, Serializable {
    private static final long serialVersionUID = 1;
    protected Map<ClassKey, Class<?>> _localMixIns;
    protected final ClassIntrospector.MixInResolver _overrides;

    public SimpleMixInResolver(ClassIntrospector.MixInResolver mixInResolver) {
        this._overrides = mixInResolver;
    }

    public void addLocalDefinition(Class<?> cls, Class<?> cls2) {
        if (this._localMixIns == null) {
            this._localMixIns = new HashMap();
        }
        this._localMixIns.put(new ClassKey(cls), cls2);
    }

    public Class<?> findMixInClassFor(Class<?> cls) {
        Class<?> cls2;
        Map<ClassKey, Class<?>> map;
        ClassIntrospector.MixInResolver mixInResolver = this._overrides;
        if (mixInResolver == null) {
            cls2 = null;
        } else {
            cls2 = mixInResolver.findMixInClassFor(cls);
        }
        if (cls2 != null || (map = this._localMixIns) == null) {
            return cls2;
        }
        return map.get(new ClassKey(cls));
    }

    public boolean hasMixIns() {
        if (this._localMixIns != null) {
            return true;
        }
        ClassIntrospector.MixInResolver mixInResolver = this._overrides;
        if (mixInResolver == null) {
            return false;
        }
        if (mixInResolver instanceof SimpleMixInResolver) {
            return ((SimpleMixInResolver) mixInResolver).hasMixIns();
        }
        return true;
    }
}
