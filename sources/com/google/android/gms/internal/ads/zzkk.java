package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzkk {
    private final zzca zza = new zzca();
    private final zzcb zzb = new zzcb();
    private final zzln zzc;
    private final zzdt zzd;
    private long zze;
    private int zzf;
    private boolean zzg;
    private zzkh zzh;
    private zzkh zzi;
    private zzkh zzj;
    private int zzk;
    private Object zzl;
    private long zzm;
    private zzig zzn;
    private List zzo = new ArrayList();
    private final zzjp zzp;

    public zzkk(zzln zzln, zzdt zzdt, zzjp zzjp, zzig zzig) {
        this.zzc = zzln;
        this.zzd = zzdt;
        this.zzp = zzjp;
        this.zzn = zzig;
    }

    private final zzki zzA(zzcc zzcc, Object obj, long j, long j2, long j3) {
        long j4;
        long j5;
        long j6;
        zzcc zzcc2 = zzcc;
        Object obj2 = obj;
        long j7 = j;
        zzcc2.zzn(obj2, this.zza);
        int zzc2 = this.zza.zzc(j7);
        if (zzc2 != -1) {
            this.zza.zzm(zzc2);
        }
        if (zzc2 == -1) {
            this.zza.zzb();
        } else {
            this.zza.zzn(zzc2);
        }
        zzui zzui = new zzui(obj2, j3, zzc2);
        boolean zzG = zzG(zzui);
        boolean zzE = zzE(zzcc2, zzui);
        boolean zzD = zzD(zzcc2, zzui, zzG);
        if (zzc2 != -1) {
            this.zza.zzn(zzc2);
        }
        if (zzc2 != -1) {
            this.zza.zzi(zzc2);
            j4 = 0;
        } else {
            j4 = -9223372036854775807L;
        }
        if (j4 != -9223372036854775807L) {
            j6 = 0;
            j5 = 0;
        } else {
            j6 = j4;
            j5 = this.zza.zzd;
        }
        if (j5 != -9223372036854775807L && j7 >= j5) {
            j7 = Math.max(0, j5 - 1);
        }
        return new zzki(zzui, j7, j2, j6, j5, false, zzG, zzE, zzD);
    }

    private static zzui zzB(zzcc zzcc, Object obj, long j, long j2, zzcb zzcb, zzca zzca) {
        zzcc zzcc2 = zzcc;
        Object obj2 = obj;
        long j3 = j;
        zzca zzca2 = zzca;
        zzcc.zzn(obj, zzca2);
        zzcb zzcb2 = zzcb;
        zzcc.zze(zzca2.zzc, zzcb, 0);
        zzcc.zza(obj);
        zzca.zzb();
        zzcc.zzn(obj, zzca2);
        int zzd2 = zzca2.zzd(j);
        if (zzd2 == -1) {
            long j4 = j2;
            return new zzui(obj, j2, zzca2.zzc(j));
        }
        long j5 = j2;
        return new zzui(obj, zzd2, zzca2.zze(zzd2), j2);
    }

    private final void zzC() {
        zzui zzui;
        zzfxo zzfxo = new zzfxo();
        for (zzkh zzkh = this.zzh; zzkh != null; zzkh = zzkh.zzg()) {
            zzfxo.zzf(zzkh.zzf.zza);
        }
        zzkh zzkh2 = this.zzi;
        if (zzkh2 == null) {
            zzui = null;
        } else {
            zzui = zzkh2.zzf.zza;
        }
        this.zzd.zzh(new zzkj(this, zzfxo, zzui));
    }

    private final boolean zzD(zzcc zzcc, zzui zzui, boolean z) {
        int zza2 = zzcc.zza(zzui.zza);
        if (!zzcc.zze(zzcc.zzd(zza2, this.zza, false).zzc, this.zzb, 0).zzi) {
            if (zzcc.zzi(zza2, this.zza, this.zzb, this.zzf, this.zzg) != -1 || !z) {
                return false;
            }
            return true;
        }
        return false;
    }

    private final boolean zzE(zzcc zzcc, zzui zzui) {
        if (!zzG(zzui)) {
            return false;
        }
        int i = zzcc.zzn(zzui.zza, this.zza).zzc;
        if (zzcc.zze(i, this.zzb, 0).zzo == zzcc.zza(zzui.zza)) {
            return true;
        }
        return false;
    }

    private final boolean zzF(zzcc zzcc) {
        zzkh zzkh = this.zzh;
        if (zzkh == null) {
            return true;
        }
        int zza2 = zzcc.zza(zzkh.zzb);
        while (true) {
            zza2 = zzcc.zzi(zza2, this.zza, this.zzb, this.zzf, this.zzg);
            while (true) {
                zzkh.getClass();
                if (zzkh.zzg() == null || zzkh.zzf.zzg) {
                    zzkh zzg2 = zzkh.zzg();
                } else {
                    zzkh = zzkh.zzg();
                }
            }
            zzkh zzg22 = zzkh.zzg();
            if (zza2 == -1 || zzg22 == null || zzcc.zza(zzg22.zzb) != zza2) {
                boolean zzq = zzq(zzkh);
                zzkh.zzf = zzh(zzcc, zzkh.zzf);
            } else {
                zzkh = zzg22;
            }
        }
        boolean zzq2 = zzq(zzkh);
        zzkh.zzf = zzh(zzcc, zzkh.zzf);
        if (!zzq2) {
            return true;
        }
        return false;
    }

    private static final boolean zzG(zzui zzui) {
        if (zzui.zzb() || zzui.zze != -1) {
            return false;
        }
        return true;
    }

    public static boolean zzo(long j, long j2) {
        if (j == -9223372036854775807L || j == j2) {
            return true;
        }
        return false;
    }

    private final long zzv(zzcc zzcc, Object obj, int i) {
        zzcc.zzn(obj, this.zza);
        this.zza.zzi(i);
        this.zza.zzk(i);
        return 0;
    }

    private final long zzw(Object obj) {
        for (int i = 0; i < this.zzo.size(); i++) {
            zzkh zzkh = (zzkh) this.zzo.get(i);
            if (zzkh.zzb.equals(obj)) {
                return zzkh.zzf.zza.zzd;
            }
        }
        return -1;
    }

    private final zzki zzx(zzcc zzcc, zzkh zzkh, long j) {
        long j2;
        zzcc zzcc2 = zzcc;
        zzki zzki = zzkh.zzf;
        long zze2 = (zzkh.zze() + zzki.zze) - j;
        if (zzki.zzg) {
            int zza2 = zzcc2.zza(zzki.zza.zza);
            int i = this.zzf;
            boolean z = this.zzg;
            long j3 = 0;
            int zzi2 = zzcc.zzi(zza2, this.zza, this.zzb, i, z);
            if (zzi2 != -1) {
                int i2 = zzcc2.zzd(zzi2, this.zza, true).zzc;
                Object obj = this.zza.zzb;
                obj.getClass();
                long j4 = zzki.zza.zzd;
                if (zzcc2.zze(i2, this.zzb, 0).zzn == zzi2) {
                    Pair zzm2 = zzcc.zzm(this.zzb, this.zza, i2, -9223372036854775807L, Math.max(0, zze2));
                    if (zzm2 != null) {
                        obj = zzm2.first;
                        long longValue = ((Long) zzm2.second).longValue();
                        zzkh zzg2 = zzkh.zzg();
                        if (zzg2 == null || !zzg2.zzb.equals(obj)) {
                            j4 = zzw(obj);
                            if (j4 == -1) {
                                j4 = this.zze;
                                this.zze = 1 + j4;
                            }
                        } else {
                            j4 = zzg2.zzf.zza.zzd;
                        }
                        j2 = longValue;
                        j3 = -9223372036854775807L;
                    }
                } else {
                    j2 = 0;
                }
                zzui zzB = zzB(zzcc, obj, j2, j4, this.zzb, this.zza);
                if (!(j3 == -9223372036854775807L || zzki.zzc == -9223372036854775807L)) {
                    zzcc2.zzn(zzki.zza.zza, this.zza).zzb();
                    this.zza.zzg();
                }
                return zzy(zzcc, zzB, j3, j2);
            }
        } else {
            zzui zzui = zzki.zza;
            zzcc2.zzn(zzui.zza, this.zza);
            if (zzui.zzb()) {
                int i3 = zzui.zzb;
                if (this.zza.zza(i3) != -1) {
                    int zzf2 = this.zza.zzf(i3, zzui.zzc);
                    if (zzf2 < 0) {
                        return zzz(zzcc, zzui.zza, i3, zzf2, zzki.zzc, zzui.zzd);
                    }
                    long j5 = zzki.zzc;
                    if (j5 == -9223372036854775807L) {
                        zzcb zzcb = this.zzb;
                        zzca zzca = this.zza;
                        Pair zzm3 = zzcc.zzm(zzcb, zzca, zzca.zzc, -9223372036854775807L, Math.max(0, zze2));
                        if (zzm3 != null) {
                            j5 = ((Long) zzm3.second).longValue();
                        }
                    }
                    zzv(zzcc2, zzui.zza, zzui.zzb);
                    return zzA(zzcc, zzui.zza, Math.max(0, j5), zzki.zzc, zzui.zzd);
                }
            } else {
                int i4 = zzui.zze;
                if (i4 != -1) {
                    this.zza.zzm(i4);
                }
                zzca zzca2 = this.zza;
                int i5 = zzui.zze;
                int zze3 = zzca2.zze(i5);
                zzca2.zzn(i5);
                if (zze3 != this.zza.zza(zzui.zze)) {
                    return zzz(zzcc, zzui.zza, zzui.zze, zze3, zzki.zze, zzui.zzd);
                }
                zzv(zzcc2, zzui.zza, zzui.zze);
                return zzA(zzcc, zzui.zza, 0, zzki.zze, zzui.zzd);
            }
        }
        return null;
    }

    private final zzki zzy(zzcc zzcc, zzui zzui, long j, long j2) {
        zzui zzui2 = zzui;
        zzcc zzcc2 = zzcc;
        zzcc.zzn(zzui2.zza, this.zza);
        if (zzui.zzb()) {
            return zzz(zzcc, zzui2.zza, zzui2.zzb, zzui2.zzc, j, zzui2.zzd);
        }
        return zzA(zzcc, zzui2.zza, j2, j, zzui2.zzd);
    }

    private final zzki zzz(zzcc zzcc, Object obj, int i, int i2, long j, long j2) {
        long j3;
        zzui zzui = new zzui(obj, i, i2, j2);
        long zzh2 = zzcc.zzn(zzui.zza, this.zza).zzh(zzui.zzb, zzui.zzc);
        if (i2 == this.zza.zze(i)) {
            this.zza.zzj();
        }
        this.zza.zzn(zzui.zzb);
        if (zzh2 == -9223372036854775807L || zzh2 > 0) {
            j3 = 0;
        } else {
            j3 = Math.max(0, -1 + zzh2);
        }
        return new zzki(zzui, j3, j, -9223372036854775807L, zzh2, false, false, false, false);
    }

    public final zzkh zza() {
        zzkh zzkh = this.zzh;
        if (zzkh == null) {
            return null;
        }
        if (zzkh == this.zzi) {
            this.zzi = zzkh.zzg();
        }
        zzkh.zzn();
        int i = this.zzk - 1;
        this.zzk = i;
        if (i == 0) {
            this.zzj = null;
            zzkh zzkh2 = this.zzh;
            this.zzl = zzkh2.zzb;
            this.zzm = zzkh2.zzf.zza.zzd;
        }
        this.zzh = this.zzh.zzg();
        zzC();
        return this.zzh;
    }

    public final zzkh zzb() {
        zzkh zzkh = this.zzi;
        zzdi.zzb(zzkh);
        this.zzi = zzkh.zzg();
        zzC();
        zzkh zzkh2 = this.zzi;
        zzdi.zzb(zzkh2);
        return zzkh2;
    }

    public final zzkh zzc(zzki zzki) {
        long j;
        zzkh zzkh;
        zzkh zzkh2 = this.zzj;
        if (zzkh2 == null) {
            j = 1000000000000L;
        } else {
            j = (zzkh2.zze() + zzkh2.zzf.zze) - zzki.zzb;
        }
        int i = 0;
        while (true) {
            if (i >= this.zzo.size()) {
                zzkh = null;
                break;
            }
            zzki zzki2 = ((zzkh) this.zzo.get(i)).zzf;
            if (zzo(zzki2.zze, zzki.zze) && zzki2.zzb == zzki.zzb && zzki2.zza.equals(zzki.zza)) {
                zzkh = (zzkh) this.zzo.remove(i);
                break;
            }
            i++;
        }
        if (zzkh == null) {
            zzkh = zzjx.zzd(this.zzp.zza, zzki, j);
        } else {
            zzkh.zzf = zzki;
            zzkh.zzp(j);
        }
        zzkh zzkh3 = this.zzj;
        if (zzkh3 != null) {
            zzkh3.zzo(zzkh);
        } else {
            this.zzh = zzkh;
            this.zzi = zzkh;
        }
        this.zzl = null;
        this.zzj = zzkh;
        this.zzk++;
        zzC();
        return zzkh;
    }

    public final zzkh zzd() {
        return this.zzj;
    }

    public final zzkh zze() {
        return this.zzh;
    }

    public final zzkh zzf() {
        return this.zzi;
    }

    public final zzki zzg(long j, zzkx zzkx) {
        zzkh zzkh = this.zzj;
        if (zzkh != null) {
            return zzx(zzkx.zza, zzkh, j);
        }
        return zzy(zzkx.zza, zzkx.zzb, zzkx.zzc, zzkx.zzr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzki zzh(com.google.android.gms.internal.ads.zzcc r19, com.google.android.gms.internal.ads.zzki r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            com.google.android.gms.internal.ads.zzui r3 = r2.zza
            boolean r12 = zzG(r3)
            boolean r13 = r0.zzE(r1, r3)
            boolean r14 = r0.zzD(r1, r3, r12)
            com.google.android.gms.internal.ads.zzui r4 = r2.zza
            java.lang.Object r4 = r4.zza
            com.google.android.gms.internal.ads.zzca r5 = r0.zza
            r1.zzn(r4, r5)
            boolean r1 = r3.zzb()
            r4 = -1
            r5 = 0
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 != 0) goto L_0x0037
            int r1 = r3.zze
            if (r1 != r4) goto L_0x0030
            goto L_0x0037
        L_0x0030:
            com.google.android.gms.internal.ads.zzca r9 = r0.zza
            r9.zzi(r1)
            r9 = r5
            goto L_0x0038
        L_0x0037:
            r9 = r7
        L_0x0038:
            boolean r1 = r3.zzb()
            if (r1 == 0) goto L_0x004b
            com.google.android.gms.internal.ads.zzca r1 = r0.zza
            int r5 = r3.zzb
            int r6 = r3.zzc
            long r5 = r1.zzh(r5, r6)
        L_0x0048:
            r7 = r9
            r9 = r5
            goto L_0x0057
        L_0x004b:
            int r1 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x0052
            r7 = r5
            r9 = r7
            goto L_0x0057
        L_0x0052:
            com.google.android.gms.internal.ads.zzca r1 = r0.zza
            long r5 = r1.zzd
            goto L_0x0048
        L_0x0057:
            boolean r1 = r3.zzb()
            if (r1 == 0) goto L_0x0065
            com.google.android.gms.internal.ads.zzca r1 = r0.zza
            int r4 = r3.zzb
            r1.zzn(r4)
            goto L_0x006e
        L_0x0065:
            int r1 = r3.zze
            if (r1 == r4) goto L_0x006e
            com.google.android.gms.internal.ads.zzca r4 = r0.zza
            r4.zzn(r1)
        L_0x006e:
            com.google.android.gms.internal.ads.zzki r15 = new com.google.android.gms.internal.ads.zzki
            long r4 = r2.zzb
            long r1 = r2.zzc
            r11 = 0
            r16 = r1
            r1 = r15
            r2 = r3
            r3 = r4
            r5 = r16
            r1.<init>(r2, r3, r5, r7, r9, r11, r12, r13, r14)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkk.zzh(com.google.android.gms.internal.ads.zzcc, com.google.android.gms.internal.ads.zzki):com.google.android.gms.internal.ads.zzki");
    }

    public final zzui zzi(zzcc zzcc, Object obj, long j) {
        long zzw;
        int zza2;
        int i = zzcc.zzn(obj, this.zza).zzc;
        Object obj2 = this.zzl;
        if (obj2 == null || (zza2 = zzcc.zza(obj2)) == -1 || zzcc.zzd(zza2, this.zza, false).zzc != i) {
            zzkh zzkh = this.zzh;
            while (true) {
                if (zzkh == null) {
                    zzkh zzkh2 = this.zzh;
                    while (true) {
                        if (zzkh2 != null) {
                            int zza3 = zzcc.zza(zzkh2.zzb);
                            if (zza3 != -1 && zzcc.zzd(zza3, this.zza, false).zzc == i) {
                                zzw = zzkh2.zzf.zza.zzd;
                                break;
                            }
                            zzkh2 = zzkh2.zzg();
                        } else {
                            zzw = zzw(obj);
                            if (zzw == -1) {
                                zzw = this.zze;
                                this.zze = 1 + zzw;
                                if (this.zzh == null) {
                                    this.zzl = obj;
                                    this.zzm = zzw;
                                }
                            }
                        }
                    }
                } else if (zzkh.zzb.equals(obj)) {
                    zzw = zzkh.zzf.zza.zzd;
                    break;
                } else {
                    zzkh = zzkh.zzg();
                }
            }
        } else {
            zzw = this.zzm;
        }
        long j2 = zzw;
        zzcc.zzn(obj, this.zza);
        zzcc.zze(this.zza.zzc, this.zzb, 0);
        int zza4 = zzcc.zza(obj);
        Object obj3 = obj;
        while (true) {
            zzcb zzcb = this.zzb;
            if (zza4 < zzcb.zzn) {
                return zzB(zzcc, obj3, j, j2, zzcb, this.zza);
            }
            zzcc.zzd(zza4, this.zza, true);
            this.zza.zzb();
            zzca zzca = this.zza;
            if (zzca.zzd(zzca.zzd) != -1) {
                obj3 = this.zza.zzb;
                obj3.getClass();
            }
            zza4--;
        }
    }

    public final void zzj() {
        if (this.zzk != 0) {
            zzkh zzkh = this.zzh;
            zzdi.zzb(zzkh);
            this.zzl = zzkh.zzb;
            this.zzm = zzkh.zzf.zza.zzd;
            while (zzkh != null) {
                zzkh.zzn();
                zzkh = zzkh.zzg();
            }
            this.zzh = null;
            this.zzj = null;
            this.zzi = null;
            this.zzk = 0;
            zzC();
        }
    }

    public final /* synthetic */ void zzk(zzfxo zzfxo, zzui zzui) {
        this.zzc.zzS(zzfxo.zzi(), zzui);
    }

    public final void zzl(long j) {
        zzkh zzkh = this.zzj;
        if (zzkh != null) {
            zzkh.zzm(j);
        }
    }

    public final void zzm() {
        if (!this.zzo.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.zzo.size(); i++) {
                ((zzkh) this.zzo.get(i)).zzn();
            }
            this.zzo = arrayList;
        }
    }

    public final void zzn(zzcc zzcc, zzig zzig) {
        this.zzn = zzig;
        long j = zzig.zzb;
        zzm();
    }

    public final boolean zzp(zzug zzug) {
        zzkh zzkh = this.zzj;
        if (zzkh == null || zzkh.zza != zzug) {
            return false;
        }
        return true;
    }

    public final boolean zzq(zzkh zzkh) {
        zzdi.zzb(zzkh);
        boolean z = false;
        if (zzkh.equals(this.zzj)) {
            return false;
        }
        this.zzj = zzkh;
        while (zzkh.zzg() != null) {
            zzkh = zzkh.zzg();
            zzkh.getClass();
            if (zzkh == this.zzi) {
                this.zzi = this.zzh;
                z = true;
            }
            zzkh.zzn();
            this.zzk--;
        }
        zzkh zzkh2 = this.zzj;
        zzkh2.getClass();
        zzkh2.zzo((zzkh) null);
        zzC();
        return z;
    }

    public final boolean zzr() {
        zzkh zzkh = this.zzj;
        if (zzkh == null) {
            return true;
        }
        if (zzkh.zzf.zzi || !zzkh.zzr() || this.zzj.zzf.zze == -9223372036854775807L) {
            return false;
        }
        if (this.zzk < 100) {
            return true;
        }
        return false;
    }

    public final boolean zzs(zzcc zzcc, long j, long j2) {
        zzki zzki;
        long j3;
        boolean z;
        zzcc zzcc2 = zzcc;
        zzkh zzkh = null;
        for (zzkh zzkh2 = this.zzh; zzkh2 != null; zzkh2 = zzkh2.zzg()) {
            zzki zzki2 = zzkh2.zzf;
            if (zzkh == null) {
                zzki = zzh(zzcc2, zzki2);
                long j4 = j;
            } else {
                zzki zzx = zzx(zzcc2, zzkh, j);
                if (zzx == null) {
                    if (!zzq(zzkh)) {
                        return true;
                    }
                    return false;
                } else if (zzki2.zzb == zzx.zzb && zzki2.zza.equals(zzx.zza)) {
                    zzki = zzx;
                } else if (!zzq(zzkh)) {
                    return true;
                } else {
                    return false;
                }
            }
            zzkh2.zzf = zzki.zza(zzki2.zzc);
            if (!zzo(zzki2.zze, zzki.zze)) {
                zzkh2.zzq();
                long j5 = zzki.zze;
                if (j5 == -9223372036854775807L) {
                    j3 = Long.MAX_VALUE;
                } else {
                    j3 = j5 + zzkh2.zze();
                }
                if (zzkh2 == this.zzi) {
                    boolean z2 = zzkh2.zzf.zzf;
                    if (j2 == Long.MIN_VALUE || j2 >= j3) {
                        z = true;
                        if (!zzq(zzkh2) || z) {
                            return false;
                        }
                        return true;
                    }
                }
                z = false;
                if (!zzq(zzkh2)) {
                }
                return false;
            }
            zzkh = zzkh2;
        }
        return true;
    }

    public final boolean zzt(zzcc zzcc, int i) {
        this.zzf = i;
        return zzF(zzcc);
    }

    public final boolean zzu(zzcc zzcc, boolean z) {
        this.zzg = z;
        return zzF(zzcc);
    }
}
