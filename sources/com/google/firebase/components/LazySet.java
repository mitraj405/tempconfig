package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class LazySet<T> implements Provider<Set<T>> {
    private volatile Set<T> actualSet = null;
    private volatile Set<Provider<T>> providers = Collections.newSetFromMap(new ConcurrentHashMap());

    public LazySet(Collection<Provider<T>> collection) {
        this.providers.addAll(collection);
    }

    public static LazySet<?> fromCollection(Collection<Provider<?>> collection) {
        return new LazySet<>((Set) collection);
    }

    private synchronized void updateSet() {
        for (Provider<T> provider : this.providers) {
            this.actualSet.add(provider.get());
        }
        this.providers = null;
    }

    public synchronized void add(Provider<T> provider) {
        if (this.actualSet == null) {
            this.providers.add(provider);
        } else {
            this.actualSet.add(provider.get());
        }
    }

    public Set<T> get() {
        if (this.actualSet == null) {
            synchronized (this) {
                if (this.actualSet == null) {
                    this.actualSet = Collections.newSetFromMap(new ConcurrentHashMap());
                    updateSet();
                }
            }
        }
        return Collections.unmodifiableSet(this.actualSet);
    }
}
