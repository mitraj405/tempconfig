package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.nonagon.signalgeneration.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeup implements zzevo {
    final String zza;
    private final zzgcu zzb;
    private final ScheduledExecutorService zzc;
    private final zzelg zzd;
    private final Context zze;
    private final zzffg zzf;
    private final zzelc zzg;
    private final zzdqb zzh;
    private final zzdup zzi;

    public zzeup(zzgcu zzgcu, ScheduledExecutorService scheduledExecutorService, String str, zzelg zzelg, Context context, zzffg zzffg, zzelc zzelc, zzdqb zzdqb, zzdup zzdup) {
        this.zzb = zzgcu;
        this.zzc = scheduledExecutorService;
        this.zza = str;
        this.zzd = zzelg;
        this.zze = context;
        this.zzf = zzffg;
        this.zzg = zzelc;
        this.zzh = zzdqb;
        this.zzi = zzdup;
    }

    public static /* synthetic */ ListenableFuture zzc(zzeup zzeup) {
        String str;
        Bundle bundle;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzjW)).booleanValue()) {
            str = zzeup.zzf.zzf.toLowerCase(Locale.ROOT);
        } else {
            str = zzeup.zzf.zzf;
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zzbt)).booleanValue()) {
            bundle = zzeup.zzi.zzg();
        } else {
            bundle = new Bundle();
        }
        ArrayList arrayList = new ArrayList();
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzbC)).booleanValue()) {
            for (Map.Entry entry : ((zzfxu) zzeup.zzd.zzb(zzeup.zza, str)).entrySet()) {
                String str2 = (String) entry.getKey();
                arrayList.add(zzeup.zzg(str2, (List) entry.getValue(), zzeup.zzf(str2), true, true));
            }
            zzeup.zzi(arrayList, zzeup.zzd.zzc());
        } else {
            zzeup.zzi(arrayList, zzeup.zzd.zza(zzeup.zza, str));
        }
        return zzgcj.zzb(arrayList).zza(new zzeuk(arrayList, bundle), zzeup.zzb);
    }

    private final Bundle zzf(String str) {
        Bundle bundle = this.zzf.zzd.zzm;
        if (bundle != null) {
            return bundle.getBundle(str);
        }
        return null;
    }

    private final zzgca zzg(String str, List list, Bundle bundle, boolean z, boolean z2) {
        zzgca zzu = zzgca.zzu(zzgcj.zzk(new zzeum(this, str, list, bundle, z, z2), this.zzb));
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzbp)).booleanValue()) {
            zzu = (zzgca) zzgcj.zzo(zzu, ((Long) zzba.zzc().zza(zzbbw.zzbi)).longValue(), TimeUnit.MILLISECONDS, this.zzc);
        }
        return (zzgca) zzgcj.zze(zzu, Throwable.class, new zzeun(str), this.zzb);
    }

    private final void zzh(zzbql zzbql, Bundle bundle, List list, zzelj zzelj) throws RemoteException {
        zzbql zzbql2 = zzbql;
        zzbql2.zzh(ObjectWrapper.wrap(this.zze), this.zza, bundle, (Bundle) list.get(0), this.zzf.zze, zzelj);
    }

    private final void zzi(List list, Map map) {
        for (Map.Entry value : map.entrySet()) {
            zzelk zzelk = (zzelk) value.getValue();
            String str = zzelk.zza;
            list.add(zzg(str, Collections.singletonList(zzelk.zze), zzf(str), zzelk.zzb, zzelk.zzc));
        }
    }

    public final int zza() {
        return 32;
    }

    public final ListenableFuture zzb() {
        zzffg zzffg = this.zzf;
        if (zzffg.zzr) {
            if (!Arrays.asList(((String) zzba.zzc().zza(zzbbw.zzbv)).split(",")).contains(zzq.zzb(zzq.zzc(zzffg.zzd)))) {
                return zzgcj.zzh(new zzeuq(new JSONArray().toString(), new Bundle()));
            }
        }
        return zzgcj.zzk(new zzeuj(this), this.zzb);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.common.util.concurrent.ListenableFuture zzd(java.lang.String r9, java.util.List r10, android.os.Bundle r11, boolean r12, boolean r13) throws java.lang.Exception {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzbzt r7 = new com.google.android.gms.internal.ads.zzbzt
            r7.<init>()
            r0 = 0
            if (r13 == 0) goto L_0x0026
            com.google.android.gms.internal.ads.zzbbn r13 = com.google.android.gms.internal.ads.zzbbw.zzbu
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r13 = r1.zza(r13)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 != 0) goto L_0x0026
            com.google.android.gms.internal.ads.zzelc r13 = r8.zzg
            r13.zzb(r9)
            com.google.android.gms.internal.ads.zzelc r13 = r8.zzg
            com.google.android.gms.internal.ads.zzbql r13 = r13.zza(r9)
            goto L_0x0034
        L_0x0026:
            com.google.android.gms.internal.ads.zzdqb r13 = r8.zzh     // Catch:{ RemoteException -> 0x002d }
            com.google.android.gms.internal.ads.zzbql r13 = r13.zzb(r9)     // Catch:{ RemoteException -> 0x002d }
            goto L_0x0034
        L_0x002d:
            r13 = move-exception
            java.lang.String r1 = "Couldn't create RTB adapter : "
            com.google.android.gms.ads.internal.util.zze.zzb(r1, r13)
            r13 = r0
        L_0x0034:
            if (r13 != 0) goto L_0x004e
            com.google.android.gms.internal.ads.zzbbn r10 = com.google.android.gms.internal.ads.zzbbw.zzbk
            com.google.android.gms.internal.ads.zzbbu r11 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r10 = r11.zza(r10)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x004d
            com.google.android.gms.internal.ads.zzelj.zzb(r9, r7)
            goto L_0x00ba
        L_0x004d:
            throw r0
        L_0x004e:
            com.google.android.gms.internal.ads.zzelj r6 = new com.google.android.gms.internal.ads.zzelj
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzu.zzB()
            long r4 = r0.elapsedRealtime()
            r0 = r6
            r1 = r9
            r2 = r13
            r3 = r7
            r0.<init>(r1, r2, r3, r4)
            com.google.android.gms.internal.ads.zzbbn r9 = com.google.android.gms.internal.ads.zzbbw.zzbp
            com.google.android.gms.internal.ads.zzbbu r0 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r9 = r0.zza(r9)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x008d
            java.util.concurrent.ScheduledExecutorService r9 = r8.zzc
            com.google.android.gms.internal.ads.zzeuo r0 = new com.google.android.gms.internal.ads.zzeuo
            r0.<init>(r6)
            com.google.android.gms.internal.ads.zzbbn r1 = com.google.android.gms.internal.ads.zzbbw.zzbi
            com.google.android.gms.internal.ads.zzbbu r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS
            r9.schedule(r0, r1, r3)
        L_0x008d:
            if (r12 == 0) goto L_0x00b7
            com.google.android.gms.internal.ads.zzbbn r9 = com.google.android.gms.internal.ads.zzbbw.zzbw
            com.google.android.gms.internal.ads.zzbbu r12 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r9 = r12.zza(r9)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x00b3
            com.google.android.gms.internal.ads.zzgcu r9 = r8.zzb
            com.google.android.gms.internal.ads.zzeul r12 = new com.google.android.gms.internal.ads.zzeul
            r0 = r12
            r1 = r8
            r2 = r13
            r3 = r11
            r4 = r10
            r5 = r6
            r6 = r7
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r9.zza(r12)
            goto L_0x00ba
        L_0x00b3:
            r8.zzh(r13, r11, r10, r6)
            goto L_0x00ba
        L_0x00b7:
            r6.zzd()
        L_0x00ba:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeup.zzd(java.lang.String, java.util.List, android.os.Bundle, boolean, boolean):com.google.common.util.concurrent.ListenableFuture");
    }

    public final /* synthetic */ void zze(zzbql zzbql, Bundle bundle, List list, zzelj zzelj, zzbzt zzbzt) {
        try {
            zzh(zzbql, bundle, list, zzelj);
        } catch (RemoteException e) {
            zzbzt.zzd(e);
        }
    }
}
