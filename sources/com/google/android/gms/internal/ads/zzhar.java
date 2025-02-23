package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzhar extends RuntimeException {
    public zzhar(zzgzj zzgzj) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzgyn zza() {
        return new zzgyn(getMessage());
    }
}
