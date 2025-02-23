package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zztk implements zzuy {
    private final zzacp zza;
    private zzack zzb;
    private zzacl zzc;

    public zztk(zzacp zzacp) {
        this.zza = zzacp;
    }

    public final int zza(zzadf zzadf) throws IOException {
        zzack zzack = this.zzb;
        zzack.getClass();
        zzacl zzacl = this.zzc;
        zzacl.getClass();
        return zzack.zzb(zzacl, zzadf);
    }

    public final long zzb() {
        zzacl zzacl = this.zzc;
        if (zzacl != null) {
            return zzacl.zzf();
        }
        return -1;
    }

    public final void zzc() {
        zzack zzack = this.zzb;
        if (zzack != null) {
            zzack zzc2 = zzack.zzc();
            if (zzc2 instanceof zzahp) {
                ((zzahp) zzc2).zza();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0049, code lost:
        if (r0.zzf() != r11) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006b, code lost:
        if (r0.zzf() != r11) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x006e, code lost:
        r2 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(com.google.android.gms.internal.ads.zzp r8, android.net.Uri r9, java.util.Map r10, long r11, long r13, com.google.android.gms.internal.ads.zzacn r15) throws java.io.IOException {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzaby r6 = new com.google.android.gms.internal.ads.zzaby
            r0 = r6
            r1 = r8
            r2 = r11
            r4 = r13
            r0.<init>(r1, r2, r4)
            r7.zzc = r6
            com.google.android.gms.internal.ads.zzack r8 = r7.zzb
            if (r8 == 0) goto L_0x0010
            return
        L_0x0010:
            com.google.android.gms.internal.ads.zzacp r8 = r7.zza
            com.google.android.gms.internal.ads.zzack[] r8 = r8.zza(r9, r10)
            int r10 = r8.length
            com.google.android.gms.internal.ads.zzfxo r13 = com.google.android.gms.internal.ads.zzfxr.zzi(r10)
            r14 = 0
            r0 = 1
            if (r10 != r0) goto L_0x0024
            r8 = r8[r14]
            r7.zzb = r8
            goto L_0x007e
        L_0x0024:
            r1 = r14
        L_0x0025:
            if (r1 >= r10) goto L_0x007a
            r2 = r8[r1]
            boolean r3 = r2.zzj(r6)     // Catch:{ EOFException -> 0x0061, all -> 0x004c }
            if (r3 == 0) goto L_0x0038
            r7.zzb = r2     // Catch:{ EOFException -> 0x0061, all -> 0x004c }
            com.google.android.gms.internal.ads.zzdi.zzf(r0)
            r6.zzj()
            goto L_0x007a
        L_0x0038:
            java.util.List r2 = r2.zzd()     // Catch:{ EOFException -> 0x0061, all -> 0x004c }
            r13.zzh(r2)     // Catch:{ EOFException -> 0x0061, all -> 0x004c }
            com.google.android.gms.internal.ads.zzack r2 = r7.zzb
            if (r2 != 0) goto L_0x0070
            long r2 = r6.zzf()
            int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r2 != 0) goto L_0x006e
            goto L_0x0070
        L_0x004c:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzack r9 = r7.zzb
            if (r9 != 0) goto L_0x0059
            long r9 = r6.zzf()
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 != 0) goto L_0x005a
        L_0x0059:
            r14 = r0
        L_0x005a:
            com.google.android.gms.internal.ads.zzdi.zzf(r14)
            r6.zzj()
            throw r8
        L_0x0061:
            com.google.android.gms.internal.ads.zzack r2 = r7.zzb
            if (r2 != 0) goto L_0x0070
            long r2 = r6.zzf()
            int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r2 != 0) goto L_0x006e
            goto L_0x0070
        L_0x006e:
            r2 = r14
            goto L_0x0071
        L_0x0070:
            r2 = r0
        L_0x0071:
            com.google.android.gms.internal.ads.zzdi.zzf(r2)
            r6.zzj()
            int r1 = r1 + 1
            goto L_0x0025
        L_0x007a:
            com.google.android.gms.internal.ads.zzack r10 = r7.zzb
            if (r10 == 0) goto L_0x0084
        L_0x007e:
            com.google.android.gms.internal.ads.zzack r8 = r7.zzb
            r8.zze(r15)
            return
        L_0x0084:
            com.google.android.gms.internal.ads.zzwj r10 = new com.google.android.gms.internal.ads.zzwj
            com.google.android.gms.internal.ads.zzfxr r8 = com.google.android.gms.internal.ads.zzfxr.zzl(r8)
            com.google.android.gms.internal.ads.zztj r11 = new com.google.android.gms.internal.ads.zztj
            r11.<init>()
            java.util.List r8 = com.google.android.gms.internal.ads.zzfyh.zzb(r8, r11)
            java.util.Iterator r8 = r8.iterator()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = ", "
            com.google.android.gms.internal.ads.zzfum.zzc(r11, r8, r12)
            java.lang.String r8 = r11.toString()
            java.lang.String r11 = "None of the available extractors ("
            java.lang.String r12 = ") could read the stream."
            java.lang.String r8 = defpackage.lf.j(r11, r8, r12)
            com.google.android.gms.internal.ads.zzfxr r11 = r13.zzi()
            r10.<init>(r8, r9, r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztk.zzd(com.google.android.gms.internal.ads.zzp, android.net.Uri, java.util.Map, long, long, com.google.android.gms.internal.ads.zzacn):void");
    }

    public final void zze() {
        zzack zzack = this.zzb;
        if (zzack != null) {
            zzack.zzf();
            this.zzb = null;
        }
        this.zzc = null;
    }

    public final void zzf(long j, long j2) {
        zzack zzack = this.zzb;
        zzack.getClass();
        zzack.zzi(j, j2);
    }
}
