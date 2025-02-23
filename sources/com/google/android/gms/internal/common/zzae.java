package com.google.android.gms.internal.common;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
final class zzae extends zzz {
    private final zzag zza;

    public zzae(zzag zzag, int i) {
        super(zzag.size(), i);
        this.zza = zzag;
    }

    public final Object zza(int i) {
        return this.zza.get(i);
    }
}
