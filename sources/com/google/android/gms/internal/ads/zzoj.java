package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzoj extends ContentObserver {
    final /* synthetic */ zzom zza;
    private final ContentResolver zzb;
    private final Uri zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzoj(zzom zzom, Handler handler, ContentResolver contentResolver, Uri uri) {
        super(handler);
        this.zza = zzom;
        this.zzb = contentResolver;
        this.zzc = uri;
    }

    public final void onChange(boolean z) {
        zzom zzom = this.zza;
        this.zza.zzj(zzof.zzc(zzom.zza, zzom.zzh, zzom.zzg));
    }

    public final void zza() {
        this.zzb.registerContentObserver(this.zzc, false, this);
    }

    public final void zzb() {
        this.zzb.unregisterContentObserver(this);
    }
}
