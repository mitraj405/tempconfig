package com.google.common.reflect;

import com.google.common.base.Function;
import com.google.common.reflect.Types;
import java.lang.reflect.Type;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class b implements Function {
    public final /* synthetic */ Types.JavaVersion a;

    public /* synthetic */ b(Types.JavaVersion javaVersion) {
        this.a = javaVersion;
    }

    public final Object apply(Object obj) {
        return this.a.typeName((Type) obj);
    }
}
