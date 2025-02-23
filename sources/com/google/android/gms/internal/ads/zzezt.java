package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzezt implements zzena {
    protected final zzcgj zza;
    private final Context zzb;
    /* access modifiers changed from: private */
    public final Executor zzc;
    /* access modifiers changed from: private */
    public final zzfaj zzd;
    /* access modifiers changed from: private */
    public final zzfcc zze;
    private final VersionInfoParcel zzf;
    private final ViewGroup zzg;
    /* access modifiers changed from: private */
    public final zzfki zzh;
    private final zzffe zzi;
    /* access modifiers changed from: private */
    public ListenableFuture zzj;

    public zzezt(Context context, Executor executor, zzcgj zzcgj, zzfcc zzfcc, zzfaj zzfaj, zzffe zzffe, VersionInfoParcel versionInfoParcel) {
        this.zzb = context;
        this.zzc = executor;
        this.zza = zzcgj;
        this.zze = zzfcc;
        this.zzd = zzfaj;
        this.zzi = zzffe;
        this.zzf = versionInfoParcel;
        this.zzg = new FrameLayout(context);
        this.zzh = zzcgj.zzz();
    }

    /* access modifiers changed from: private */
    public final synchronized zzcvw zzm(zzfca zzfca) {
        zzezs zzezs = (zzezs) zzfca;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzhq)).booleanValue()) {
            zzcph zzcph = new zzcph(this.zzg);
            zzcvy zzcvy = new zzcvy();
            zzcvy.zze(this.zzb);
            zzcvy.zzi(zzezs.zza);
            zzcwa zzj2 = zzcvy.zzj();
            zzdci zzdci = new zzdci();
            zzdci.zzc(this.zzd, this.zzc);
            zzdci.zzl(this.zzd, this.zzc);
            return zze(zzcph, zzj2, zzdci.zzn());
        }
        zzfaj zzi2 = zzfaj.zzi(this.zzd);
        zzdci zzdci2 = new zzdci();
        zzdci2.zzb(zzi2, this.zzc);
        zzdci2.zzg(zzi2, this.zzc);
        zzdci2.zzh(zzi2, this.zzc);
        zzdci2.zzi(zzi2, this.zzc);
        zzdci2.zzc(zzi2, this.zzc);
        zzdci2.zzl(zzi2, this.zzc);
        zzdci2.zzm(zzi2);
        zzcph zzcph2 = new zzcph(this.zzg);
        zzcvy zzcvy2 = new zzcvy();
        zzcvy2.zze(this.zzb);
        zzcvy2.zzi(zzezs.zza);
        return zze(zzcph2, zzcvy2.zzj(), zzdci2.zzn());
    }

    public final boolean zza() {
        ListenableFuture listenableFuture = this.zzj;
        if (listenableFuture == null || listenableFuture.isDone()) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0056 A[SYNTHETIC, Splitter:B:16:0x0056] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzb(com.google.android.gms.ads.internal.client.zzl r10, java.lang.String r11, com.google.android.gms.internal.ads.zzemy r12, com.google.android.gms.internal.ads.zzemz r13) throws android.os.RemoteException {
        /*
            r9 = this;
            monitor-enter(r9)
            com.google.android.gms.internal.ads.zzbdc r12 = com.google.android.gms.internal.ads.zzbdq.zzd     // Catch:{ all -> 0x012f }
            java.lang.Object r12 = r12.zze()     // Catch:{ all -> 0x012f }
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch:{ all -> 0x012f }
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x012f }
            r0 = 1
            r1 = 0
            if (r12 == 0) goto L_0x0025
            com.google.android.gms.internal.ads.zzbbn r12 = com.google.android.gms.internal.ads.zzbbw.zzkl     // Catch:{ all -> 0x012f }
            com.google.android.gms.internal.ads.zzbbu r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x012f }
            java.lang.Object r12 = r2.zza(r12)     // Catch:{ all -> 0x012f }
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch:{ all -> 0x012f }
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x012f }
            if (r12 == 0) goto L_0x0025
            r12 = r0
            goto L_0x0026
        L_0x0025:
            r12 = r1
        L_0x0026:
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r2 = r9.zzf     // Catch:{ all -> 0x012f }
            int r2 = r2.clientJarVersion     // Catch:{ all -> 0x012f }
            com.google.android.gms.internal.ads.zzbbn r3 = com.google.android.gms.internal.ads.zzbbw.zzkm     // Catch:{ all -> 0x012f }
            com.google.android.gms.internal.ads.zzbbu r4 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x012f }
            java.lang.Object r3 = r4.zza(r3)     // Catch:{ all -> 0x012f }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x012f }
            int r3 = r3.intValue()     // Catch:{ all -> 0x012f }
            if (r2 < r3) goto L_0x003e
            if (r12 != 0) goto L_0x0043
        L_0x003e:
            java.lang.String r12 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r12)     // Catch:{ all -> 0x012f }
        L_0x0043:
            if (r11 != 0) goto L_0x0056
            java.lang.String r10 = "Ad unit ID should not be null for app open ad."
            com.google.android.gms.ads.internal.util.client.zzm.zzg(r10)     // Catch:{ all -> 0x012f }
            java.util.concurrent.Executor r10 = r9.zzc     // Catch:{ all -> 0x012f }
            com.google.android.gms.internal.ads.zzezn r11 = new com.google.android.gms.internal.ads.zzezn     // Catch:{ all -> 0x012f }
            r11.<init>(r9)     // Catch:{ all -> 0x012f }
            r10.execute(r11)     // Catch:{ all -> 0x012f }
            monitor-exit(r9)
            return r1
        L_0x0056:
            com.google.common.util.concurrent.ListenableFuture r12 = r9.zzj     // Catch:{ all -> 0x012f }
            if (r12 == 0) goto L_0x005c
            monitor-exit(r9)
            return r1
        L_0x005c:
            com.google.android.gms.internal.ads.zzbdc r12 = com.google.android.gms.internal.ads.zzbdl.zzc     // Catch:{ all -> 0x012f }
            java.lang.Object r12 = r12.zze()     // Catch:{ all -> 0x012f }
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch:{ all -> 0x012f }
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x012f }
            r2 = 7
            r3 = 0
            if (r12 == 0) goto L_0x008d
            com.google.android.gms.internal.ads.zzfcc r12 = r9.zze     // Catch:{ all -> 0x012f }
            java.lang.Object r4 = r12.zzd()     // Catch:{ all -> 0x012f }
            if (r4 == 0) goto L_0x008d
            java.lang.Object r12 = r12.zzd()     // Catch:{ all -> 0x012f }
            com.google.android.gms.internal.ads.zzcou r12 = (com.google.android.gms.internal.ads.zzcou) r12     // Catch:{ all -> 0x012f }
            com.google.android.gms.internal.ads.zzfkf r12 = r12.zzh()     // Catch:{ all -> 0x012f }
            r12.zzi(r2)     // Catch:{ all -> 0x012f }
            java.lang.String r4 = r10.zzp     // Catch:{ all -> 0x012f }
            r12.zzb(r4)     // Catch:{ all -> 0x012f }
            android.os.Bundle r4 = r10.zzm     // Catch:{ all -> 0x012f }
            r12.zzf(r4)     // Catch:{ all -> 0x012f }
            r4 = r12
            goto L_0x008e
        L_0x008d:
            r4 = r3
        L_0x008e:
            android.content.Context r12 = r9.zzb     // Catch:{ all -> 0x012f }
            boolean r5 = r10.zzf     // Catch:{ all -> 0x012f }
            com.google.android.gms.internal.ads.zzfgd.zza(r12, r5)     // Catch:{ all -> 0x012f }
            com.google.android.gms.internal.ads.zzbbn r12 = com.google.android.gms.internal.ads.zzbbw.zzia     // Catch:{ all -> 0x012f }
            com.google.android.gms.internal.ads.zzbbu r5 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x012f }
            java.lang.Object r12 = r5.zza(r12)     // Catch:{ all -> 0x012f }
            java.lang.Boolean r12 = (java.lang.Boolean) r12     // Catch:{ all -> 0x012f }
            boolean r12 = r12.booleanValue()     // Catch:{ all -> 0x012f }
            if (r12 == 0) goto L_0x00b4
            boolean r12 = r10.zzf     // Catch:{ all -> 0x012f }
            if (r12 == 0) goto L_0x00b4
            com.google.android.gms.internal.ads.zzcgj r12 = r9.zza     // Catch:{ all -> 0x012f }
            com.google.android.gms.internal.ads.zzdvi r12 = r12.zzl()     // Catch:{ all -> 0x012f }
            r12.zzo(r0)     // Catch:{ all -> 0x012f }
        L_0x00b4:
            r12 = 2
            android.util.Pair[] r12 = new android.util.Pair[r12]     // Catch:{ all -> 0x012f }
            android.util.Pair r5 = new android.util.Pair     // Catch:{ all -> 0x012f }
            com.google.android.gms.internal.ads.zzdrt r6 = com.google.android.gms.internal.ads.zzdrt.PUBLIC_API_CALL     // Catch:{ all -> 0x012f }
            java.lang.String r6 = r6.zza()     // Catch:{ all -> 0x012f }
            long r7 = r10.zzz     // Catch:{ all -> 0x012f }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x012f }
            r5.<init>(r6, r7)     // Catch:{ all -> 0x012f }
            r12[r1] = r5     // Catch:{ all -> 0x012f }
            android.util.Pair r1 = new android.util.Pair     // Catch:{ all -> 0x012f }
            com.google.android.gms.internal.ads.zzdrt r5 = com.google.android.gms.internal.ads.zzdrt.DYNAMITE_ENTER     // Catch:{ all -> 0x012f }
            java.lang.String r5 = r5.zza()     // Catch:{ all -> 0x012f }
            com.google.android.gms.common.util.Clock r6 = com.google.android.gms.ads.internal.zzu.zzB()     // Catch:{ all -> 0x012f }
            long r6 = r6.currentTimeMillis()     // Catch:{ all -> 0x012f }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x012f }
            r1.<init>(r5, r6)     // Catch:{ all -> 0x012f }
            r12[r0] = r1     // Catch:{ all -> 0x012f }
            android.os.Bundle r12 = com.google.android.gms.internal.ads.zzdrv.zza(r12)     // Catch:{ all -> 0x012f }
            com.google.android.gms.internal.ads.zzffe r1 = r9.zzi     // Catch:{ all -> 0x012f }
            r1.zzt(r11)     // Catch:{ all -> 0x012f }
            com.google.android.gms.ads.internal.client.zzq r11 = com.google.android.gms.ads.internal.client.zzq.zzb()     // Catch:{ all -> 0x012f }
            r1.zzs(r11)     // Catch:{ all -> 0x012f }
            r1.zzH(r10)     // Catch:{ all -> 0x012f }
            r1.zzA(r12)     // Catch:{ all -> 0x012f }
            android.content.Context r11 = r9.zzb     // Catch:{ all -> 0x012f }
            com.google.android.gms.internal.ads.zzffg r12 = r1.zzJ()     // Catch:{ all -> 0x012f }
            int r1 = com.google.android.gms.internal.ads.zzfke.zzf(r12)     // Catch:{ all -> 0x012f }
            com.google.android.gms.internal.ads.zzfju r5 = com.google.android.gms.internal.ads.zzfjt.zzb(r11, r1, r2, r10)     // Catch:{ all -> 0x012f }
            com.google.android.gms.internal.ads.zzezs r6 = new com.google.android.gms.internal.ads.zzezs     // Catch:{ all -> 0x012f }
            r6.<init>(r3)     // Catch:{ all -> 0x012f }
            r6.zza = r12     // Catch:{ all -> 0x012f }
            com.google.android.gms.internal.ads.zzfcc r10 = r9.zze     // Catch:{ all -> 0x012f }
            com.google.android.gms.internal.ads.zzfcd r11 = new com.google.android.gms.internal.ads.zzfcd     // Catch:{ all -> 0x012f }
            r11.<init>(r6, r3)     // Catch:{ all -> 0x012f }
            com.google.android.gms.internal.ads.zzezo r12 = new com.google.android.gms.internal.ads.zzezo     // Catch:{ all -> 0x012f }
            r12.<init>(r9)     // Catch:{ all -> 0x012f }
            com.google.common.util.concurrent.ListenableFuture r10 = r10.zzc(r11, r12, r3)     // Catch:{ all -> 0x012f }
            r9.zzj = r10     // Catch:{ all -> 0x012f }
            com.google.android.gms.internal.ads.zzezq r11 = new com.google.android.gms.internal.ads.zzezq     // Catch:{ all -> 0x012f }
            r1 = r11
            r2 = r9
            r3 = r13
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x012f }
            java.util.concurrent.Executor r12 = r9.zzc     // Catch:{ all -> 0x012f }
            com.google.android.gms.internal.ads.zzgcj.zzr(r10, r11, r12)     // Catch:{ all -> 0x012f }
            monitor-exit(r9)
            return r0
        L_0x012f:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzezt.zzb(com.google.android.gms.ads.internal.client.zzl, java.lang.String, com.google.android.gms.internal.ads.zzemy, com.google.android.gms.internal.ads.zzemz):boolean");
    }

    public abstract zzcvw zze(zzcph zzcph, zzcwa zzcwa, zzdck zzdck);

    public final /* synthetic */ void zzk() {
        this.zzd.zzdB(zzfgi.zzd(6, (String) null, (zze) null));
    }

    public final void zzl(zzw zzw) {
        this.zzi.zzu(zzw);
    }
}
