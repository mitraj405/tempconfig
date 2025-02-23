package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzf;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcdb extends zzccv implements zzgu {
    private String zzd;
    private final zzcbj zze;
    private boolean zzf;
    private final zzcda zzg = new zzcda();
    private final zzccg zzh = new zzccg();
    private ByteBuffer zzi;
    private boolean zzj;
    private final Object zzk = new Object();
    private final String zzl;
    private final int zzm;
    private boolean zzn;

    public zzcdb(zzcbk zzcbk, zzcbj zzcbj) {
        super(zzcbk);
        String str;
        int i;
        this.zze = zzcbj;
        if (zzcbk != null) {
            str = zzcbk.zzr();
        } else {
            str = null;
        }
        this.zzl = (String) zzfus.zzd(str).zzb("");
        if (zzcbk != null) {
            i = zzcbk.zzf();
        } else {
            i = 0;
        }
        this.zzm = i;
    }

    public static final String zzm(String str) {
        return "cache:".concat(String.valueOf(zzf.zzf(str)));
    }

    private final void zzv() {
        boolean z;
        int zza = (int) this.zzg.zza();
        int zza2 = (int) this.zzh.zza(this.zzi);
        int position = this.zzi.position();
        int round = Math.round((((float) position) / ((float) zza)) * ((float) zza2));
        int zzs = zzcbb.zzs();
        int zzu = zzcbb.zzu();
        String str = this.zzd;
        String zzm2 = zzm(str);
        long j = (long) round;
        if (round > 0) {
            z = true;
        } else {
            z = false;
        }
        zzn(str, zzm2, position, zza, j, (long) zza2, z, zzs, zzu);
    }

    public final void zzd(zzfs zzfs, zzfy zzfy, boolean z) {
        if (zzfs instanceof zzgg) {
            this.zzg.zzb((zzgg) zzfs);
        }
    }

    public final void zzf() {
        this.zzf = true;
    }

    public final String zzi() {
        return this.zzd;
    }

    public final ByteBuffer zzk() {
        synchronized (this.zzk) {
            ByteBuffer byteBuffer = this.zzi;
            if (byteBuffer != null && !this.zzj) {
                byteBuffer.flip();
                this.zzj = true;
            }
            this.zzf = true;
        }
        return this.zzi;
    }

    public final boolean zzl() {
        return this.zzn;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: com.google.android.gms.internal.ads.zzgg} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: com.google.android.gms.internal.ads.zzgg} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: com.google.android.gms.internal.ads.zzcce} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: com.google.android.gms.internal.ads.zzgg} */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0153, code lost:
        r0 = th;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzt(java.lang.String r21) {
        /*
            r20 = this;
            r1 = r20
            r2 = r21
            r1.zzd = r2
            java.lang.String r3 = "error"
            java.lang.String r4 = zzm(r21)
            r0 = 0
            com.google.android.gms.internal.ads.zzgb r5 = new com.google.android.gms.internal.ads.zzgb     // Catch:{ Exception -> 0x0155 }
            r5.<init>()     // Catch:{ Exception -> 0x0155 }
            java.lang.String r6 = r1.zzb     // Catch:{ Exception -> 0x0155 }
            r5.zzf(r6)     // Catch:{ Exception -> 0x0155 }
            com.google.android.gms.internal.ads.zzcbj r6 = r1.zze     // Catch:{ Exception -> 0x0155 }
            int r6 = r6.zzd     // Catch:{ Exception -> 0x0155 }
            r5.zzc(r6)     // Catch:{ Exception -> 0x0155 }
            com.google.android.gms.internal.ads.zzcbj r6 = r1.zze     // Catch:{ Exception -> 0x0155 }
            int r6 = r6.zze     // Catch:{ Exception -> 0x0155 }
            r5.zzd(r6)     // Catch:{ Exception -> 0x0155 }
            r6 = 1
            r5.zzb(r6)     // Catch:{ Exception -> 0x0155 }
            r5.zze(r1)     // Catch:{ Exception -> 0x0155 }
            com.google.android.gms.internal.ads.zzgg r9 = r5.zza()     // Catch:{ Exception -> 0x0155 }
            com.google.android.gms.internal.ads.zzcbj r5 = r1.zze     // Catch:{ Exception -> 0x0155 }
            boolean r5 = r5.zzi     // Catch:{ Exception -> 0x0155 }
            if (r5 == 0) goto L_0x0045
            com.google.android.gms.internal.ads.zzcce r5 = new com.google.android.gms.internal.ads.zzcce     // Catch:{ Exception -> 0x0155 }
            android.content.Context r8 = r1.zza     // Catch:{ Exception -> 0x0155 }
            java.lang.String r10 = r1.zzl     // Catch:{ Exception -> 0x0155 }
            int r11 = r1.zzm     // Catch:{ Exception -> 0x0155 }
            r12 = 0
            r13 = 0
            r7 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x0155 }
            r9 = r5
        L_0x0045:
            android.net.Uri r11 = android.net.Uri.parse(r21)     // Catch:{ Exception -> 0x0155 }
            com.google.android.gms.internal.ads.zzfy r5 = new com.google.android.gms.internal.ads.zzfy     // Catch:{ Exception -> 0x0155 }
            r12 = 0
            r14 = -1
            r16 = 0
            r10 = r5
            r10.<init>(r11, r12, r14, r16)     // Catch:{ Exception -> 0x0155 }
            r9.zzb(r5)     // Catch:{ Exception -> 0x0155 }
            java.lang.ref.WeakReference r5 = r1.zzc     // Catch:{ Exception -> 0x0155 }
            java.lang.Object r5 = r5.get()     // Catch:{ Exception -> 0x0155 }
            com.google.android.gms.internal.ads.zzcbk r5 = (com.google.android.gms.internal.ads.zzcbk) r5     // Catch:{ Exception -> 0x0155 }
            if (r5 == 0) goto L_0x0065
            r5.zzt(r4, r1)     // Catch:{ Exception -> 0x0155 }
        L_0x0065:
            com.google.android.gms.common.util.Clock r5 = com.google.android.gms.ads.internal.zzu.zzB()     // Catch:{ Exception -> 0x0155 }
            long r6 = r5.currentTimeMillis()     // Catch:{ Exception -> 0x0155 }
            com.google.android.gms.internal.ads.zzbbn r8 = com.google.android.gms.internal.ads.zzbbw.zzs     // Catch:{ Exception -> 0x0155 }
            com.google.android.gms.internal.ads.zzbbu r10 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ Exception -> 0x0155 }
            java.lang.Object r8 = r10.zza(r8)     // Catch:{ Exception -> 0x0155 }
            java.lang.Long r8 = (java.lang.Long) r8     // Catch:{ Exception -> 0x0155 }
            long r10 = r8.longValue()     // Catch:{ Exception -> 0x0155 }
            com.google.android.gms.internal.ads.zzbbn r8 = com.google.android.gms.internal.ads.zzbbw.zzr     // Catch:{ Exception -> 0x0155 }
            com.google.android.gms.internal.ads.zzbbu r12 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ Exception -> 0x0155 }
            java.lang.Object r8 = r12.zza(r8)     // Catch:{ Exception -> 0x0155 }
            java.lang.Long r8 = (java.lang.Long) r8     // Catch:{ Exception -> 0x0155 }
            long r12 = r8.longValue()     // Catch:{ Exception -> 0x0155 }
            com.google.android.gms.internal.ads.zzcbj r8 = r1.zze     // Catch:{ Exception -> 0x0155 }
            int r8 = r8.zzc     // Catch:{ Exception -> 0x0155 }
            java.nio.ByteBuffer r8 = java.nio.ByteBuffer.allocate(r8)     // Catch:{ Exception -> 0x0155 }
            r1.zzi = r8     // Catch:{ Exception -> 0x0155 }
            r8 = 8192(0x2000, float:1.14794E-41)
            byte[] r14 = new byte[r8]     // Catch:{ Exception -> 0x0155 }
            r17 = r3
            r15 = r6
        L_0x009e:
            java.nio.ByteBuffer r3 = r1.zzi     // Catch:{ Exception -> 0x0144 }
            int r3 = r3.remaining()     // Catch:{ Exception -> 0x0144 }
            int r3 = java.lang.Math.min(r3, r8)     // Catch:{ Exception -> 0x0144 }
            int r0 = r9.zza(r14, r0, r3)     // Catch:{ Exception -> 0x0144 }
            r3 = -1
            if (r0 != r3) goto L_0x00c0
            r0 = 1
            r1.zzn = r0     // Catch:{ Exception -> 0x0144 }
            com.google.android.gms.internal.ads.zzccg r0 = r1.zzh     // Catch:{ Exception -> 0x0144 }
            java.nio.ByteBuffer r3 = r1.zzi     // Catch:{ Exception -> 0x0144 }
            long r5 = r0.zza(r3)     // Catch:{ Exception -> 0x0144 }
            int r0 = (int) r5     // Catch:{ Exception -> 0x0144 }
            long r5 = (long) r0     // Catch:{ Exception -> 0x0144 }
            r1.zzj(r2, r4, r5)     // Catch:{ Exception -> 0x0144 }
            goto L_0x00d9
        L_0x00c0:
            java.lang.Object r3 = r1.zzk     // Catch:{ Exception -> 0x0144 }
            monitor-enter(r3)     // Catch:{ Exception -> 0x0144 }
            boolean r8 = r1.zzf     // Catch:{ all -> 0x0149 }
            if (r8 != 0) goto L_0x00cd
            java.nio.ByteBuffer r8 = r1.zzi     // Catch:{ all -> 0x0149 }
            r2 = 0
            r8.put(r14, r2, r0)     // Catch:{ all -> 0x0149 }
        L_0x00cd:
            monitor-exit(r3)     // Catch:{ all -> 0x0149 }
            java.nio.ByteBuffer r0 = r1.zzi     // Catch:{ Exception -> 0x0144 }
            int r0 = r0.remaining()     // Catch:{ Exception -> 0x0144 }
            if (r0 > 0) goto L_0x00db
            r20.zzv()     // Catch:{ Exception -> 0x0144 }
        L_0x00d9:
            r0 = 1
            return r0
        L_0x00db:
            boolean r0 = r1.zzf     // Catch:{ Exception -> 0x0144 }
            if (r0 != 0) goto L_0x011a
            long r2 = r5.currentTimeMillis()     // Catch:{ Exception -> 0x0144 }
            long r18 = r2 - r15
            int r0 = (r18 > r10 ? 1 : (r18 == r10 ? 0 : -1))
            if (r0 < 0) goto L_0x00ed
            r20.zzv()     // Catch:{ Exception -> 0x0144 }
            r15 = r2
        L_0x00ed:
            long r2 = r2 - r6
            r18 = 1000(0x3e8, double:4.94E-321)
            long r18 = r18 * r12
            int r0 = (r2 > r18 ? 1 : (r2 == r18 ? 0 : -1))
            if (r0 > 0) goto L_0x00fc
            r0 = 0
            r8 = 8192(0x2000, float:1.14794E-41)
            r2 = r21
            goto L_0x009e
        L_0x00fc:
            java.lang.String r2 = "downloadTimeout"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013e }
            r0.<init>()     // Catch:{ Exception -> 0x013e }
            java.lang.String r3 = "Timeout exceeded. Limit: "
            r0.append(r3)     // Catch:{ Exception -> 0x013e }
            r0.append(r12)     // Catch:{ Exception -> 0x013e }
            java.lang.String r3 = " sec"
            r0.append(r3)     // Catch:{ Exception -> 0x013e }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x013e }
            java.io.IOException r3 = new java.io.IOException     // Catch:{ Exception -> 0x013e }
            r3.<init>(r0)     // Catch:{ Exception -> 0x013e }
            throw r3     // Catch:{ Exception -> 0x013e }
        L_0x011a:
            java.lang.String r2 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x013e }
            java.nio.ByteBuffer r3 = r1.zzi     // Catch:{ Exception -> 0x013e }
            int r3 = r3.limit()     // Catch:{ Exception -> 0x013e }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013e }
            r5.<init>()     // Catch:{ Exception -> 0x013e }
            java.lang.String r6 = "Precache abort at "
            r5.append(r6)     // Catch:{ Exception -> 0x013e }
            r5.append(r3)     // Catch:{ Exception -> 0x013e }
            java.lang.String r3 = " bytes"
            r5.append(r3)     // Catch:{ Exception -> 0x013e }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x013e }
            r0.<init>(r3)     // Catch:{ Exception -> 0x013e }
            throw r0     // Catch:{ Exception -> 0x013e }
        L_0x013e:
            r0 = move-exception
            r5 = r1
            r3 = r2
            r2 = r21
            goto L_0x0159
        L_0x0144:
            r0 = move-exception
        L_0x0145:
            r2 = r21
            r5 = r1
            goto L_0x0150
        L_0x0149:
            r0 = move-exception
            r2 = r21
            r5 = r1
        L_0x014d:
            monitor-exit(r3)     // Catch:{ all -> 0x0153 }
            throw r0     // Catch:{ Exception -> 0x014f }
        L_0x014f:
            r0 = move-exception
        L_0x0150:
            r3 = r17
            goto L_0x0159
        L_0x0153:
            r0 = move-exception
            goto L_0x014d
        L_0x0155:
            r0 = move-exception
            r17 = r3
            goto L_0x0145
        L_0x0159:
            java.lang.Class r6 = r0.getClass()
            java.lang.String r6 = r6.getCanonicalName()
            java.lang.String r0 = r0.getMessage()
            java.lang.String r7 = ":"
            java.lang.String r0 = defpackage.xx.D(r6, r7, r0)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Failed to preload url "
            r6.<init>(r7)
            r6.append(r2)
            java.lang.String r7 = " Exception: "
            r6.append(r7)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r6)
            r5.zzg(r2, r4, r3, r0)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcdb.zzt(java.lang.String):boolean");
    }

    public final void zzb(zzfs zzfs, zzfy zzfy, boolean z) {
    }

    public final void zzc(zzfs zzfs, zzfy zzfy, boolean z) {
    }

    public final void zza(zzfs zzfs, zzfy zzfy, boolean z, int i) {
    }
}
