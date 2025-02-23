package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.StrictMode;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcew {
    /* JADX WARNING: type inference failed for: r0v3, types: [java.lang.Object, com.google.android.gms.internal.ads.zzcej] */
    public static final zzcej zza(Context context, zzcgd zzcgd, String str, boolean z, boolean z2, zzauo zzauo, zzbcz zzbcz, VersionInfoParcel versionInfoParcel, zzbcl zzbcl, zzm zzm, zza zza, zzbav zzbav, zzfel zzfel, zzfeo zzfeo, zzeds zzeds, zzffk zzffk) throws zzcev {
        StrictMode.ThreadPolicy threadPolicy;
        zzbbw.zza(context);
        try {
            zzces zzces = new zzces(context, zzcgd, str, z, z2, zzauo, zzbcz, versionInfoParcel, (zzbcl) null, zzm, zza, zzbav, zzfel, zzfeo, zzffk, zzeds);
            threadPolicy = StrictMode.getThreadPolicy();
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            ? zza2 = zzces.zza();
            StrictMode.setThreadPolicy(threadPolicy);
            return zza2;
        } catch (Throwable th) {
            throw new zzcev("Webview initialization failed.", th);
        }
    }
}
