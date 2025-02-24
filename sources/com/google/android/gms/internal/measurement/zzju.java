package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.0.2 */
public enum zzju {
    VOID(Void.class, Void.class, (Class<?>) null),
    INT(r13, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, Boolean.FALSE),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzia.class, zzia.class, zzia.zza),
    ENUM(r13, Integer.class, (Class<?>) null),
    MESSAGE(Object.class, Object.class, (Class<?>) null);
    
    private final Class<?> zzl;

    private zzju(Class<?> cls, Class<?> cls2, Object obj) {
        this.zzl = cls2;
    }

    public final Class<?> zza() {
        return this.zzl;
    }
}
