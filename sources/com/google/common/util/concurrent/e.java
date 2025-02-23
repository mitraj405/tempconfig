package com.google.common.util.concurrent;

import com.google.common.util.concurrent.SimpleTimeLimiter;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class e implements Callable {
    public final /* synthetic */ Object a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Method f2817a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object[] f2818a;

    public /* synthetic */ e(Method method, Object obj, Object[] objArr) {
        this.f2817a = method;
        this.a = obj;
        this.f2818a = objArr;
    }

    public final Object call() {
        return SimpleTimeLimiter.AnonymousClass1.lambda$invoke$0(this.f2817a, this.a, this.f2818a);
    }
}
