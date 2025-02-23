package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@ElementTypesAreNonnullByDefault
interface LongAddable {
    void add(long j);

    void increment();

    long sum();
}
