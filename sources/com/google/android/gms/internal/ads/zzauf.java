package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzauf implements zzfqc {
    final /* synthetic */ zzfoc zza;

    public zzauf(zzauh zzauh, zzfoc zzfoc) {
        this.zza = zzfoc;
    }

    public final boolean zza(File file) {
        try {
            return this.zza.zza(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
