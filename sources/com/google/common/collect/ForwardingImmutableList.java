package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
abstract class ForwardingImmutableList<E> {
    private ForwardingImmutableList() {
    }
}
