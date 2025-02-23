package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbku implements zzapa {
    /* access modifiers changed from: private */
    public volatile zzbkh zza;
    private final Context zzb;

    public zzbku(Context context) {
        this.zzb = context;
    }

    public static /* bridge */ /* synthetic */ void zzc(zzbku zzbku) {
        if (zzbku.zza != null) {
            zzbku.zza.disconnect();
            Binder.flushPendingCommands();
        }
    }

    public final zzapd zza(zzaph zzaph) throws zzapq {
        Parcelable.Creator<zzbki> creator = zzbki.CREATOR;
        Map zzl = zzaph.zzl();
        int size = zzl.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        int i2 = 0;
        for (Map.Entry entry : zzl.entrySet()) {
            strArr[i2] = (String) entry.getKey();
            strArr2[i2] = (String) entry.getValue();
            i2++;
        }
        zzbki zzbki = new zzbki(zzaph.zzk(), strArr, strArr2);
        long elapsedRealtime = zzu.zzB().elapsedRealtime();
        try {
            zzbzt zzbzt = new zzbzt();
            this.zza = new zzbkh(this.zzb, zzu.zzt().zzb(), new zzbks(this, zzbzt), new zzbkt(this, zzbzt));
            this.zza.checkAvailabilityAndConnect();
            zzbkq zzbkq = new zzbkq(this, zzbki);
            zzgcu zzgcu = zzbzo.zza;
            ListenableFuture zzo = zzgcj.zzo(zzgcj.zzn(zzbzt, zzbkq, zzgcu), (long) ((Integer) zzba.zzc().zza(zzbbw.zzdY)).intValue(), TimeUnit.MILLISECONDS, zzbzo.zzd);
            zzo.addListener(new zzbkr(this), zzgcu);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzo.get();
            zze.zza("Http assets remote cache took " + (zzu.zzB().elapsedRealtime() - elapsedRealtime) + "ms");
            zzbkk zzbkk = (zzbkk) new zzbuz(parcelFileDescriptor).zza(zzbkk.CREATOR);
            if (zzbkk == null) {
                return null;
            }
            if (!zzbkk.zza) {
                if (zzbkk.zze.length != zzbkk.zzf.length) {
                    return null;
                }
                HashMap hashMap = new HashMap();
                while (true) {
                    String[] strArr3 = zzbkk.zze;
                    if (i >= strArr3.length) {
                        return new zzapd(zzbkk.zzc, zzbkk.zzd, (Map) hashMap, zzbkk.zzg, zzbkk.zzh);
                    }
                    hashMap.put(strArr3[i], zzbkk.zzf[i]);
                    i++;
                }
            } else {
                throw new zzapq(zzbkk.zzb);
            }
        } catch (InterruptedException | ExecutionException unused) {
            zze.zza("Http assets remote cache took " + (zzu.zzB().elapsedRealtime() - elapsedRealtime) + "ms");
            return null;
        } catch (Throwable th) {
            zze.zza("Http assets remote cache took " + (zzu.zzB().elapsedRealtime() - elapsedRealtime) + "ms");
            throw th;
        }
    }
}
