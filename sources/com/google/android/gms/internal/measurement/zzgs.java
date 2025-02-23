package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
final class zzgs implements zzgn {
    private static zzgs zza;
    private final Context zzb;
    private final ContentObserver zzc;

    private zzgs() {
        this.zzb = null;
        this.zzc = null;
    }

    public static zzgs zza(Context context) {
        zzgs zzgs;
        synchronized (zzgs.class) {
            if (zza == null) {
                zza = r1.k(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzgs(context) : new zzgs();
            }
            zzgs = zza;
        }
        return zzgs;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzc */
    public final String zza(String str) {
        Context context = this.zzb;
        if (context != null && !zzgi.zza(context)) {
            try {
                return (String) zzgq.zza(new zzgr(this, str));
            } catch (IllegalStateException | NullPointerException | SecurityException unused) {
            }
        }
        return null;
    }

    public final /* synthetic */ String zzb(String str) {
        return zzfv.zza(this.zzb.getContentResolver(), str, (String) null);
    }

    private zzgs(Context context) {
        this.zzb = context;
        zzgu zzgu = new zzgu(this, (Handler) null);
        this.zzc = zzgu;
        context.getContentResolver().registerContentObserver(zzfy.zza, true, zzgu);
    }

    public static synchronized void zza() {
        Context context;
        synchronized (zzgs.class) {
            zzgs zzgs = zza;
            if (!(zzgs == null || (context = zzgs.zzb) == null || zzgs.zzc == null)) {
                context.getContentResolver().unregisterContentObserver(zza.zzc);
            }
            zza = null;
        }
    }
}
