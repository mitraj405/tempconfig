package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzns {
    final /* synthetic */ zznt zza;
    /* access modifiers changed from: private */
    public final String zzb;
    /* access modifiers changed from: private */
    public int zzc;
    /* access modifiers changed from: private */
    public long zzd;
    /* access modifiers changed from: private */
    public zzui zze;
    /* access modifiers changed from: private */
    public boolean zzf;
    /* access modifiers changed from: private */
    public boolean zzg;

    public zzns(zznt zznt, String str, int i, zzui zzui) {
        long j;
        this.zza = zznt;
        this.zzb = str;
        this.zzc = i;
        if (zzui == null) {
            j = -1;
        } else {
            j = zzui.zzd;
        }
        this.zzd = j;
        if (zzui != null && zzui.zzb()) {
            this.zze = zzui;
        }
    }

    public final void zzg(int i, zzui zzui) {
        if (this.zzd == -1 && i == this.zzc && zzui != null) {
            zznt zznt = this.zza;
            long j = zzui.zzd;
            if (j >= zznt.zzl()) {
                this.zzd = j;
            }
        }
    }

    public final boolean zzj(int i, zzui zzui) {
        if (zzui != null) {
            zzui zzui2 = this.zze;
            if (zzui2 == null) {
                if (zzui.zzb() || zzui.zzd != this.zzd) {
                    return false;
                }
                return true;
            } else if (zzui.zzd == zzui2.zzd && zzui.zzb == zzui2.zzb && zzui.zzc == zzui2.zzc) {
                return true;
            } else {
                return false;
            }
        } else if (i == this.zzc) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean zzk(zzlo zzlo) {
        zzui zzui = zzlo.zzd;
        if (zzui != null) {
            long j = this.zzd;
            if (j == -1) {
                return false;
            }
            if (zzui.zzd > j) {
                return true;
            }
            if (this.zze == null) {
                return false;
            }
            zzcc zzcc = zzlo.zzb;
            int zza2 = zzcc.zza(zzui.zza);
            int zza3 = zzcc.zza(this.zze.zza);
            zzui zzui2 = zzlo.zzd;
            if (zzui2.zzd < this.zze.zzd || zza2 < zza3) {
                return false;
            }
            if (zza2 > zza3) {
                return true;
            }
            if (zzui2.zzb()) {
                zzui zzui3 = zzlo.zzd;
                int i = zzui3.zzb;
                int i2 = zzui3.zzc;
                zzui zzui4 = this.zze;
                int i3 = zzui4.zzb;
                if (i > i3) {
                    return true;
                }
                if (i != i3) {
                    return false;
                }
                if (i2 > zzui4.zzc) {
                    return true;
                }
                return false;
            }
            int i4 = zzlo.zzd.zze;
            if (i4 == -1 || i4 > this.zze.zzb) {
                return true;
            }
            return false;
        } else if (this.zzc != zzlo.zzc) {
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        if (r0 < r8.zzc()) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzl(com.google.android.gms.internal.ads.zzcc r7, com.google.android.gms.internal.ads.zzcc r8) {
        /*
            r6 = this;
            int r0 = r6.zzc
            int r1 = r7.zzc()
            r2 = 0
            r3 = -1
            if (r0 < r1) goto L_0x0013
            int r7 = r8.zzc()
            if (r0 >= r7) goto L_0x0011
            goto L_0x004a
        L_0x0011:
            r0 = r3
            goto L_0x004a
        L_0x0013:
            com.google.android.gms.internal.ads.zznt r1 = r6.zza
            com.google.android.gms.internal.ads.zzcb r1 = r1.zzc
            r4 = 0
            r7.zze(r0, r1, r4)
            com.google.android.gms.internal.ads.zznt r0 = r6.zza
            com.google.android.gms.internal.ads.zzcb r0 = r0.zzc
            int r0 = r0.zzn
        L_0x0026:
            com.google.android.gms.internal.ads.zznt r1 = r6.zza
            com.google.android.gms.internal.ads.zzcb r1 = r1.zzc
            int r1 = r1.zzo
            if (r0 > r1) goto L_0x0011
            java.lang.Object r1 = r7.zzf(r0)
            int r1 = r8.zza(r1)
            if (r1 == r3) goto L_0x0047
            com.google.android.gms.internal.ads.zznt r7 = r6.zza
            com.google.android.gms.internal.ads.zzca r7 = r7.zzd
            com.google.android.gms.internal.ads.zzca r7 = r8.zzd(r1, r7, r2)
            int r0 = r7.zzc
            goto L_0x004a
        L_0x0047:
            int r0 = r0 + 1
            goto L_0x0026
        L_0x004a:
            r6.zzc = r0
            if (r0 != r3) goto L_0x004f
            return r2
        L_0x004f:
            com.google.android.gms.internal.ads.zzui r7 = r6.zze
            r0 = 1
            if (r7 != 0) goto L_0x0055
            return r0
        L_0x0055:
            java.lang.Object r7 = r7.zza
            int r7 = r8.zza(r7)
            if (r7 == r3) goto L_0x005e
            return r0
        L_0x005e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzns.zzl(com.google.android.gms.internal.ads.zzcc, com.google.android.gms.internal.ads.zzcc):boolean");
    }
}
