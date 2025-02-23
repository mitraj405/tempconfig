package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.api.Releasable;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzccv implements Releasable {
    protected final Context zza;
    protected final String zzb;
    protected final WeakReference zzc;

    public zzccv(zzcbk zzcbk) {
        Context context = zzcbk.getContext();
        this.zza = context;
        this.zzb = zzu.zzp().zzc(context, zzcbk.zzn().afmaVersion);
        this.zzc = new WeakReference(zzcbk);
    }

    public static /* bridge */ /* synthetic */ void zze(zzccv zzccv, String str, Map map) {
        zzcbk zzcbk = (zzcbk) zzccv.zzc.get();
        if (zzcbk != null) {
            zzcbk.zzd("onPrecacheEvent", map);
        }
    }

    public abstract void zzf();

    public final void zzg(String str, String str2, String str3, String str4) {
        zzf.zza.post(new zzccu(this, str, str2, str3, str4));
    }

    public final void zzh(String str, String str2, int i) {
        zzf.zza.post(new zzccs(this, str, str2, i));
    }

    public final void zzj(String str, String str2, long j) {
        zzf.zza.post(new zzcct(this, str, str2, j));
    }

    public final void zzn(String str, String str2, int i, int i2, long j, long j2, boolean z, int i3, int i4) {
        zzf.zza.post(new zzccr(this, str, str2, i, i2, j, j2, z, i3, i4));
    }

    public final void zzo(String str, String str2, long j, long j2, boolean z, long j3, long j4, long j5, int i, int i2) {
        Handler handler = zzf.zza;
        zzccq zzccq = r0;
        zzccq zzccq2 = new zzccq(this, str, str2, j, j2, j3, j4, j5, z, i, i2);
        handler.post(zzccq);
    }

    public abstract boolean zzt(String str);

    public boolean zzu(String str, String[] strArr) {
        return zzt(str);
    }

    public boolean zzw(String str, String[] strArr, zzccn zzccn) {
        return zzt(str);
    }

    public void release() {
    }

    public void zzp(int i) {
    }

    public void zzq(int i) {
    }

    public void zzr(int i) {
    }

    public void zzs(int i) {
    }
}
