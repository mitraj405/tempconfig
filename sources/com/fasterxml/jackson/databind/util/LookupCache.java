package com.fasterxml.jackson.databind.util;

public interface LookupCache<K, V> {
    V get(Object obj);

    V putIfAbsent(K k, V v);
}
