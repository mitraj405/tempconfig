package com.google.common.reflect;

import com.google.common.base.Function;
import com.google.common.reflect.MutableTypeToInstanceMap;
import java.util.Map;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class a implements Function {
    public final Object apply(Object obj) {
        return MutableTypeToInstanceMap.UnmodifiableEntry.a((Map.Entry) obj);
    }
}
