package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzck;
import com.google.android.gms.ads.internal.client.zzcl;
import com.google.android.gms.ads.internal.client.zzen;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfgc {
    private static zzfgc zza;
    private final Context zzb;
    private final zzcl zzc;
    private final AtomicReference zzd = new AtomicReference();

    public zzfgc(Context context, zzcl zzcl) {
        this.zzb = context;
        this.zzc = zzcl;
    }

    public static zzcl zza(Context context) {
        try {
            return zzck.asInterface((IBinder) context.getClassLoader().loadClass("com.google.android.gms.ads.internal.client.LiteSdkInfo").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context}));
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            zzm.zzh("Failed to retrieve lite SDK info.", e);
            return null;
        }
    }

    public static zzfgc zzd(Context context) {
        synchronized (zzfgc.class) {
            zzfgc zzfgc = zza;
            if (zzfgc != null) {
                return zzfgc;
            }
            Context applicationContext = context.getApplicationContext();
            long longValue = ((Long) zzbdt.zzb.zze()).longValue();
            zzcl zzcl = null;
            if (longValue > 0 && longValue <= 242402501) {
                zzcl = zza(applicationContext);
            }
            zzfgc zzfgc2 = new zzfgc(applicationContext, zzcl);
            zza = zzfgc2;
            return zzfgc2;
        }
    }

    private final zzen zzg() {
        zzcl zzcl = this.zzc;
        if (zzcl != null) {
            try {
                return zzcl.getLiteSdkVersion();
            } catch (RemoteException unused) {
            }
        }
        return null;
    }

    public final zzbom zzb() {
        return (zzbom) this.zzd.get();
    }

    public final VersionInfoParcel zzc(int i, boolean z, int i2) {
        zzen zzg;
        zzu.zzp();
        boolean zzE = zzt.zzE(this.zzb);
        VersionInfoParcel versionInfoParcel = new VersionInfoParcel(242402000, i2, true, zzE);
        if (((Boolean) zzbdt.zzc.zze()).booleanValue() && (zzg = zzg()) != null) {
            return new VersionInfoParcel(242402000, zzg.zza(), true, zzE);
        }
        return versionInfoParcel;
    }

    public final String zze() {
        zzen zzg = zzg();
        if (zzg != null) {
            return zzg.zzb();
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzf(com.google.android.gms.internal.ads.zzbom r4) {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzbdc r0 = com.google.android.gms.internal.ads.zzbdt.zza
            java.lang.Object r0 = r0.zze()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 0
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.ads.internal.client.zzcl r0 = r3.zzc
            if (r0 != 0) goto L_0x0015
        L_0x0013:
            r0 = r1
            goto L_0x0019
        L_0x0015:
            com.google.android.gms.internal.ads.zzbom r0 = r0.getAdapterCreator()     // Catch:{ RemoteException -> 0x0013 }
        L_0x0019:
            java.util.concurrent.atomic.AtomicReference r2 = r3.zzd
            if (r0 == 0) goto L_0x001e
            r4 = r0
        L_0x001e:
            com.google.android.gms.internal.ads.zzfgb.zza(r2, r1, r4)
            return
        L_0x0022:
            java.util.concurrent.atomic.AtomicReference r0 = r3.zzd
            com.google.android.gms.internal.ads.zzfgb.zza(r0, r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfgc.zzf(com.google.android.gms.internal.ads.zzbom):void");
    }
}
