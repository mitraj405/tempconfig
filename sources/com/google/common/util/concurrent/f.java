package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Striped;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class f implements Supplier {
    public final Object get() {
        return new Striped.WeakSafeReadWriteLock();
    }
}
