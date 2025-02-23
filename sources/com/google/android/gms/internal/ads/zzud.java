package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzud extends zzwk {
    private final boolean zzb;
    private final zzcb zzc;
    private final zzca zzd;
    private zzub zze;
    private zzua zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    public zzud(zzuk zzuk, boolean z) {
        super(zzuk);
        boolean z2;
        if (z) {
            zzuk.zzv();
            z2 = true;
        } else {
            z2 = false;
        }
        this.zzb = z2;
        this.zzc = new zzcb();
        this.zzd = new zzca();
        zzuk.zzM();
        this.zze = zzub.zzq(zzuk.zzJ());
    }

    private final Object zzK(Object obj) {
        if (this.zze.zze == null || !obj.equals(zzub.zzc)) {
            return obj;
        }
        return this.zze.zze;
    }

    private final boolean zzL(long j) {
        zzua zzua = this.zzf;
        int zza = this.zze.zza(zzua.zza.zza);
        if (zza == -1) {
            return false;
        }
        zzub zzub = this.zze;
        zzca zzca = this.zzd;
        zzub.zzd(zza, zzca, false);
        long j2 = zzca.zzd;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0, j2 - 1);
        }
        zzua.zzs(j);
        return true;
    }

    public final zzcc zzC() {
        return this.zze;
    }

    public final zzui zzD(zzui zzui) {
        Object zzs = this.zze.zze;
        Object obj = zzui.zza;
        if (zzs != null && this.zze.zze.equals(obj)) {
            obj = zzub.zzc;
        }
        return zzui.zza(obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzE(com.google.android.gms.internal.ads.zzcc r15) {
        /*
            r14 = this;
            boolean r0 = r14.zzh
            r1 = 0
            if (r0 == 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzub r0 = r14.zze
            com.google.android.gms.internal.ads.zzub r15 = r0.zzp(r15)
            r14.zze = r15
            com.google.android.gms.internal.ads.zzua r15 = r14.zzf
            if (r15 == 0) goto L_0x009e
            long r2 = r15.zzn()
            r14.zzL(r2)
            goto L_0x009e
        L_0x001a:
            boolean r0 = r15.zzo()
            if (r0 == 0) goto L_0x0036
            boolean r0 = r14.zzi
            if (r0 == 0) goto L_0x002b
            com.google.android.gms.internal.ads.zzub r0 = r14.zze
            com.google.android.gms.internal.ads.zzub r15 = r0.zzp(r15)
            goto L_0x0033
        L_0x002b:
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzcb.zza
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzub.zzc
            com.google.android.gms.internal.ads.zzub r15 = com.google.android.gms.internal.ads.zzub.zzr(r15, r0, r2)
        L_0x0033:
            r14.zze = r15
            goto L_0x009e
        L_0x0036:
            com.google.android.gms.internal.ads.zzcb r0 = r14.zzc
            r2 = 0
            r3 = 0
            r15.zze(r2, r0, r3)
            com.google.android.gms.internal.ads.zzcb r0 = r14.zzc
            java.lang.Object r0 = r0.zzb
            com.google.android.gms.internal.ads.zzua r5 = r14.zzf
            if (r5 == 0) goto L_0x0062
            long r6 = r5.zzq()
            com.google.android.gms.internal.ads.zzub r8 = r14.zze
            com.google.android.gms.internal.ads.zzca r9 = r14.zzd
            com.google.android.gms.internal.ads.zzui r5 = r5.zza
            java.lang.Object r5 = r5.zza
            r8.zzn(r5, r9)
            com.google.android.gms.internal.ads.zzub r5 = r14.zze
            com.google.android.gms.internal.ads.zzcb r8 = r14.zzc
            r5.zze(r2, r8, r3)
            int r2 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0062
            r12 = r6
            goto L_0x0063
        L_0x0062:
            r12 = r3
        L_0x0063:
            com.google.android.gms.internal.ads.zzcb r9 = r14.zzc
            com.google.android.gms.internal.ads.zzca r10 = r14.zzd
            r11 = 0
            r8 = r15
            android.util.Pair r2 = r8.zzl(r9, r10, r11, r12)
            java.lang.Object r3 = r2.first
            java.lang.Object r2 = r2.second
            java.lang.Long r2 = (java.lang.Long) r2
            long r4 = r2.longValue()
            boolean r2 = r14.zzi
            if (r2 == 0) goto L_0x0082
            com.google.android.gms.internal.ads.zzub r0 = r14.zze
            com.google.android.gms.internal.ads.zzub r15 = r0.zzp(r15)
            goto L_0x0086
        L_0x0082:
            com.google.android.gms.internal.ads.zzub r15 = com.google.android.gms.internal.ads.zzub.zzr(r15, r0, r3)
        L_0x0086:
            r14.zze = r15
            com.google.android.gms.internal.ads.zzua r15 = r14.zzf
            if (r15 == 0) goto L_0x009e
            boolean r0 = r14.zzL(r4)
            if (r0 == 0) goto L_0x009e
            com.google.android.gms.internal.ads.zzui r15 = r15.zza
            java.lang.Object r0 = r15.zza
            java.lang.Object r0 = r14.zzK(r0)
            com.google.android.gms.internal.ads.zzui r1 = r15.zza(r0)
        L_0x009e:
            r15 = 1
            r14.zzi = r15
            r14.zzh = r15
            com.google.android.gms.internal.ads.zzub r15 = r14.zze
            r14.zzo(r15)
            if (r1 == 0) goto L_0x00b2
            com.google.android.gms.internal.ads.zzua r15 = r14.zzf
            r15.getClass()
            r15.zzr(r1)
        L_0x00b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzud.zzE(com.google.android.gms.internal.ads.zzcc):void");
    }

    public final void zzF() {
        if (!this.zzb) {
            this.zzg = true;
            zzB((Object) null, this.zza);
        }
    }

    public final void zzG(zzug zzug) {
        ((zzua) zzug).zzt();
        if (zzug == this.zzf) {
            this.zzf = null;
        }
    }

    /* renamed from: zzH */
    public final zzua zzI(zzui zzui, zzyk zzyk, long j) {
        zzua zzua = new zzua(zzui, zzyk, j);
        zzua.zzu(this.zza);
        if (this.zzh) {
            zzua.zzr(zzui.zza(zzK(zzui.zza)));
        } else {
            this.zzf = zzua;
            if (!this.zzg) {
                this.zzg = true;
                zzB((Object) null, this.zza);
            }
        }
        return zzua;
    }

    public final void zzq() {
        this.zzh = false;
        this.zzg = false;
        super.zzq();
    }

    public final void zzt(zzbc zzbc) {
        if (this.zzi) {
            this.zze = this.zze.zzp(new zzwg(this.zze.zzb, zzbc));
        } else {
            this.zze = zzub.zzq(zzbc);
        }
        this.zza.zzt(zzbc);
    }

    public final void zzz() {
    }
}
