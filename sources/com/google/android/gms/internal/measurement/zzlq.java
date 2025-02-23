package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@22.0.2 */
final class zzlq extends zzlx {
    private final /* synthetic */ zzlm zza;

    public final Iterator iterator() {
        return new zzlo(this.zza);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzlq(zzlm zzlm) {
        super(zzlm);
        this.zza = zzlm;
    }
}
