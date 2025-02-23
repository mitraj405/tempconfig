package com.google.android.gms.internal.ads;

import android.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zznt implements zznx {
    public static final zzfvk zza = new zznr();
    private static final Random zzb = new Random();
    /* access modifiers changed from: private */
    public final zzcb zzc;
    /* access modifiers changed from: private */
    public final zzca zzd;
    private final HashMap zze;
    private zznw zzf;
    private zzcc zzg;
    private String zzh;
    private long zzi;

    public zznt() {
        throw null;
    }

    /* access modifiers changed from: private */
    public final long zzl() {
        zzns zzns = (zzns) this.zze.get(this.zzh);
        if (zzns == null || zzns.zzd == -1) {
            return this.zzi + 1;
        }
        return zzns.zzd;
    }

    private final zzns zzm(int i, zzui zzui) {
        int i2;
        long j = Long.MAX_VALUE;
        zzns zzns = null;
        for (zzns zzns2 : this.zze.values()) {
            zzns2.zzg(i, zzui);
            if (zzns2.zzj(i, zzui)) {
                long zzb2 = zzns2.zzd;
                if (zzb2 == -1 || zzb2 < j) {
                    zzns = zzns2;
                    j = zzb2;
                } else if (i2 == 0) {
                    int i3 = zzet.zza;
                    if (!(zzns.zze == null || zzns2.zze == null)) {
                        zzns = zzns2;
                    }
                }
            }
        }
        if (zzns != null) {
            return zzns;
        }
        String zzn = zzn();
        zzns zzns3 = new zzns(this, zzn, i, zzui);
        this.zze.put(zzn, zzns3);
        return zzns3;
    }

    /* access modifiers changed from: private */
    public static String zzn() {
        byte[] bArr = new byte[12];
        zzb.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    private final void zzo(zzns zzns) {
        if (zzns.zzd != -1) {
            this.zzi = zzns.zzd;
        }
        this.zzh = null;
    }

    private final void zzp(zzlo zzlo) {
        if (zzlo.zzb.zzo()) {
            String str = this.zzh;
            if (str != null) {
                zzns zzns = (zzns) this.zze.get(str);
                zzns.getClass();
                zzo(zzns);
                return;
            }
            return;
        }
        zzns zzns2 = (zzns) this.zze.get(this.zzh);
        zzns zzm = zzm(zzlo.zzc, zzlo.zzd);
        this.zzh = zzm.zzb;
        zzi(zzlo);
        zzui zzui = zzlo.zzd;
        if (zzui != null && zzui.zzb()) {
            if (zzns2 != null) {
                if (zzns2.zzd == zzui.zzd && zzns2.zze != null && zzns2.zze.zzb == zzlo.zzd.zzb && zzns2.zze.zzc == zzlo.zzd.zzc) {
                    return;
                }
            }
            zzui zzui2 = zzlo.zzd;
            String unused = zzm(zzlo.zzc, new zzui(zzui2.zza, zzui2.zzd)).zzb;
            String unused2 = zzm.zzb;
        }
    }

    public final synchronized String zze() {
        return this.zzh;
    }

    public final synchronized String zzf(zzcc zzcc, zzui zzui) {
        return zzm(zzcc.zzn(zzui.zza, this.zzd).zzc, zzui).zzb;
    }

    public final synchronized void zzg(zzlo zzlo) {
        zznw zznw;
        String str = this.zzh;
        if (str != null) {
            zzns zzns = (zzns) this.zze.get(str);
            zzns.getClass();
            zzo(zzns);
        }
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzns zzns2 = (zzns) it.next();
            it.remove();
            if (zzns2.zzf && (zznw = this.zzf) != null) {
                zznw.zzd(zzlo, zzns2.zzb, false);
            }
        }
    }

    public final void zzh(zznw zznw) {
        this.zzf = zznw;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
        if (r0.zzc == r10.zzc) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c5, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzi(com.google.android.gms.internal.ads.zzlo r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            com.google.android.gms.internal.ads.zznw r0 = r9.zzf     // Catch:{ all -> 0x00c6 }
            r0.getClass()
            com.google.android.gms.internal.ads.zzcc r0 = r10.zzb     // Catch:{ all -> 0x00c6 }
            boolean r0 = r0.zzo()     // Catch:{ all -> 0x00c6 }
            if (r0 == 0) goto L_0x0010
            goto L_0x00c4
        L_0x0010:
            com.google.android.gms.internal.ads.zzui r0 = r10.zzd     // Catch:{ all -> 0x00c6 }
            if (r0 == 0) goto L_0x003c
            long r1 = r9.zzl()     // Catch:{ all -> 0x00c6 }
            long r3 = r0.zzd     // Catch:{ all -> 0x00c6 }
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x00c4
            java.util.HashMap r0 = r9.zze     // Catch:{ all -> 0x00c6 }
            java.lang.String r1 = r9.zzh     // Catch:{ all -> 0x00c6 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzns r0 = (com.google.android.gms.internal.ads.zzns) r0     // Catch:{ all -> 0x00c6 }
            if (r0 == 0) goto L_0x003c
            long r1 = r0.zzd     // Catch:{ all -> 0x00c6 }
            r3 = -1
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x003c
            int r0 = r0.zzc     // Catch:{ all -> 0x00c6 }
            int r1 = r10.zzc     // Catch:{ all -> 0x00c6 }
            if (r0 != r1) goto L_0x00c4
        L_0x003c:
            int r0 = r10.zzc     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzui r1 = r10.zzd     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzns r0 = r9.zzm(r0, r1)     // Catch:{ all -> 0x00c6 }
            java.lang.String r1 = r9.zzh     // Catch:{ all -> 0x00c6 }
            if (r1 != 0) goto L_0x004e
            java.lang.String r1 = r0.zzb     // Catch:{ all -> 0x00c6 }
            r9.zzh = r1     // Catch:{ all -> 0x00c6 }
        L_0x004e:
            com.google.android.gms.internal.ads.zzui r1 = r10.zzd     // Catch:{ all -> 0x00c6 }
            r2 = 1
            if (r1 == 0) goto L_0x0098
            boolean r3 = r1.zzb()     // Catch:{ all -> 0x00c6 }
            if (r3 == 0) goto L_0x0098
            java.lang.Object r3 = r1.zza     // Catch:{ all -> 0x00c6 }
            long r4 = r1.zzd     // Catch:{ all -> 0x00c6 }
            int r1 = r1.zzb     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzui r6 = new com.google.android.gms.internal.ads.zzui     // Catch:{ all -> 0x00c6 }
            r6.<init>(r3, r4, r1)     // Catch:{ all -> 0x00c6 }
            int r1 = r10.zzc     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzns r1 = r9.zzm(r1, r6)     // Catch:{ all -> 0x00c6 }
            boolean r3 = r1.zzf     // Catch:{ all -> 0x00c6 }
            if (r3 != 0) goto L_0x0098
            r1.zzf = true     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzcc r3 = r10.zzb     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzui r4 = r10.zzd     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzca r5 = r9.zzd     // Catch:{ all -> 0x00c6 }
            java.lang.Object r4 = r4.zza     // Catch:{ all -> 0x00c6 }
            r3.zzn(r4, r5)     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzca r3 = r9.zzd     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzui r4 = r10.zzd     // Catch:{ all -> 0x00c6 }
            int r4 = r4.zzb     // Catch:{ all -> 0x00c6 }
            r3.zzi(r4)     // Catch:{ all -> 0x00c6 }
            r3 = 0
            long r5 = com.google.android.gms.internal.ads.zzet.zzu(r3)     // Catch:{ all -> 0x00c6 }
            long r7 = com.google.android.gms.internal.ads.zzet.zzu(r3)     // Catch:{ all -> 0x00c6 }
            long r5 = r5 + r7
            java.lang.Math.max(r3, r5)     // Catch:{ all -> 0x00c6 }
            java.lang.String unused = r1.zzb     // Catch:{ all -> 0x00c6 }
        L_0x0098:
            boolean r1 = r0.zzf     // Catch:{ all -> 0x00c6 }
            if (r1 != 0) goto L_0x00a4
            r0.zzf = true     // Catch:{ all -> 0x00c6 }
            java.lang.String unused = r0.zzb     // Catch:{ all -> 0x00c6 }
        L_0x00a4:
            java.lang.String r1 = r0.zzb     // Catch:{ all -> 0x00c6 }
            java.lang.String r3 = r9.zzh     // Catch:{ all -> 0x00c6 }
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x00c6 }
            if (r1 == 0) goto L_0x00c4
            boolean r1 = r0.zzg     // Catch:{ all -> 0x00c6 }
            if (r1 != 0) goto L_0x00c4
            r0.zzg = true     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zznw r1 = r9.zzf     // Catch:{ all -> 0x00c6 }
            java.lang.String r0 = r0.zzb     // Catch:{ all -> 0x00c6 }
            r1.zzc(r10, r0)     // Catch:{ all -> 0x00c6 }
            monitor-exit(r9)
            return
        L_0x00c4:
            monitor-exit(r9)
            return
        L_0x00c6:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznt.zzi(com.google.android.gms.internal.ads.zzlo):void");
    }

    public final synchronized void zzj(zzlo zzlo, int i) {
        this.zzf.getClass();
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzns zzns = (zzns) it.next();
            if (zzns.zzk(zzlo)) {
                it.remove();
                if (zzns.zzf) {
                    boolean equals = zzns.zzb.equals(this.zzh);
                    boolean z = false;
                    if (i == 0 && equals && zzns.zzg) {
                        z = true;
                    }
                    if (equals) {
                        zzo(zzns);
                    }
                    this.zzf.zzd(zzlo, zzns.zzb, z);
                }
            }
        }
        zzp(zzlo);
    }

    public final synchronized void zzk(zzlo zzlo) {
        this.zzf.getClass();
        zzcc zzcc = this.zzg;
        this.zzg = zzlo.zzb;
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzns zzns = (zzns) it.next();
            if (!zzns.zzl(zzcc, this.zzg) || zzns.zzk(zzlo)) {
                it.remove();
                if (zzns.zzf) {
                    if (zzns.zzb.equals(this.zzh)) {
                        zzo(zzns);
                    }
                    this.zzf.zzd(zzlo, zzns.zzb, false);
                }
            }
        }
        zzp(zzlo);
    }

    public zznt(zzfvk zzfvk) {
        this.zzc = new zzcb();
        this.zzd = new zzca();
        this.zze = new HashMap();
        this.zzg = zzcc.zza;
        this.zzi = -1;
    }
}
