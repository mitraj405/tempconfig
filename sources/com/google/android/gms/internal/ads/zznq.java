package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.facebook.ads.AdError;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zznq implements zzln {
    private final zzdj zza;
    private final zzca zzb;
    private final zzcb zzc = new zzcb();
    private final zznp zzd;
    private final SparseArray zze;
    private zzdz zzf;
    private zzbw zzg;
    private zzdt zzh;
    private boolean zzi;

    public zznq(zzdj zzdj) {
        zzdj.getClass();
        this.zza = zzdj;
        this.zzf = new zzdz(zzet.zzy(), zzdj, new zzmr());
        zzca zzca = new zzca();
        this.zzb = zzca;
        this.zzd = new zznp(zzca);
        this.zze = new SparseArray();
    }

    public static /* synthetic */ void zzV(zznq zznq) {
        zzlo zzT = zznq.zzT();
        zznq.zzY(zzT, 1028, new zzls(zzT));
        zznq.zzf.zze();
    }

    private final zzlo zzZ(zzui zzui) {
        zzcc zzcc;
        this.zzg.getClass();
        if (zzui == null) {
            zzcc = null;
        } else {
            zzcc = this.zzd.zza(zzui);
        }
        if (zzui == null || zzcc == null) {
            int zzd2 = this.zzg.zzd();
            zzcc zzn = this.zzg.zzn();
            if (zzd2 >= zzn.zzc()) {
                zzn = zzcc.zza;
            }
            return zzU(zzn, zzd2, (zzui) null);
        }
        return zzU(zzcc, zzcc.zzn(zzui.zza, this.zzb).zzc, zzui);
    }

    private final zzlo zzaa(int i, zzui zzui) {
        zzbw zzbw = this.zzg;
        zzbw.getClass();
        if (zzui == null) {
            zzcc zzn = zzbw.zzn();
            if (i >= zzn.zzc()) {
                zzn = zzcc.zza;
            }
            return zzU(zzn, i, (zzui) null);
        } else if (this.zzd.zza(zzui) != null) {
            return zzZ(zzui);
        } else {
            return zzU(zzcc.zza, i, zzui);
        }
    }

    private final zzlo zzab() {
        return zzZ(this.zzd.zzd());
    }

    private final zzlo zzac() {
        return zzZ(this.zzd.zze());
    }

    private final zzlo zzad(zzbp zzbp) {
        zzui zzui;
        if (!(zzbp instanceof zzhw) || (zzui = ((zzhw) zzbp).zzh) == null) {
            return zzT();
        }
        return zzZ(zzui);
    }

    public final void zzA(zzaf zzaf, zzho zzho) {
        zzlo zzac = zzac();
        zzY(zzac, 1009, new zzne(zzac, zzaf, zzho));
    }

    public final void zzB(long j) {
        zzlo zzac = zzac();
        zzY(zzac, 1010, new zzmi(zzac, j));
    }

    public final void zzC(Exception exc) {
        zzlo zzac = zzac();
        zzY(zzac, 1014, new zznm(zzac, exc));
    }

    public final void zzD(zzpf zzpf) {
        zzlo zzac = zzac();
        zzY(zzac, 1031, new zznb(zzac, zzpf));
    }

    public final void zzE(zzpf zzpf) {
        zzlo zzac = zzac();
        zzY(zzac, 1032, new zznl(zzac, zzpf));
    }

    public final void zzF(int i, long j, long j2) {
        zzlo zzac = zzac();
        zzY(zzac, 1011, new zzme(zzac, i, j, j2));
    }

    public final void zzG(int i, long j) {
        zzlo zzab = zzab();
        zzY(zzab, 1018, new zzmo(zzab, i, j));
    }

    public final void zzH(Object obj, long j) {
        zzlo zzac = zzac();
        zzY(zzac, 26, new zzni(zzac, obj, j));
    }

    public final void zzI(Exception exc) {
        zzlo zzac = zzac();
        zzY(zzac, 1030, new zzmd(zzac, exc));
    }

    public final void zzJ(String str, long j, long j2) {
        zzlo zzac = zzac();
        zzY(zzac, 1016, new zznk(zzac, str, j2, j));
    }

    public final void zzK(String str) {
        zzlo zzac = zzac();
        zzY(zzac, 1019, new zzmn(zzac, str));
    }

    public final void zzL(zzhn zzhn) {
        zzlo zzab = zzab();
        zzY(zzab, 1020, new zzna(zzab, zzhn));
    }

    public final void zzM(zzhn zzhn) {
        zzlo zzac = zzac();
        zzY(zzac, 1015, new zzng(zzac, zzhn));
    }

    public final void zzN(long j, int i) {
        zzlo zzab = zzab();
        zzY(zzab, 1021, new zzms(zzab, j, i));
    }

    public final void zzO(zzaf zzaf, zzho zzho) {
        zzlo zzac = zzac();
        zzY(zzac, 1017, new zzmz(zzac, zzaf, zzho));
    }

    public final void zzP() {
        zzdt zzdt = this.zzh;
        zzdi.zzb(zzdt);
        zzdt.zzh(new zznh(this));
    }

    public final void zzQ(zzlq zzlq) {
        this.zzf.zzf(zzlq);
    }

    public final void zzR(zzbw zzbw, Looper looper) {
        boolean z = true;
        if (this.zzg != null && !this.zzd.zzb.isEmpty()) {
            z = false;
        }
        zzdi.zzf(z);
        zzbw.getClass();
        this.zzg = zzbw;
        this.zzh = this.zza.zzb(looper, (Handler.Callback) null);
        this.zzf = this.zzf.zza(looper, new zzmg(this, zzbw));
    }

    public final void zzS(List list, zzui zzui) {
        zzbw zzbw = this.zzg;
        zzbw.getClass();
        this.zzd.zzh(list, zzui, zzbw);
    }

    public final zzlo zzT() {
        return zzZ(this.zzd.zzb());
    }

    public final zzlo zzU(zzcc zzcc, int i, zzui zzui) {
        zzui zzui2;
        zzcc zzcc2 = zzcc;
        int i2 = i;
        boolean z = true;
        if (true == zzcc.zzo()) {
            zzui2 = null;
        } else {
            zzui2 = zzui;
        }
        long zza2 = this.zza.zza();
        if (!zzcc2.equals(this.zzg.zzn()) || i2 != this.zzg.zzd()) {
            z = false;
        }
        long j = 0;
        if (zzui2 == null || !zzui2.zzb()) {
            if (z) {
                j = this.zzg.zzj();
            } else if (!zzcc.zzo()) {
                long j2 = zzcc2.zze(i2, this.zzc, 0).zzl;
                j = zzet.zzu(0);
            }
        } else if (z && this.zzg.zzb() == zzui2.zzb && this.zzg.zzc() == zzui2.zzc) {
            j = this.zzg.zzk();
        }
        return new zzlo(zza2, zzcc, i, zzui2, j, this.zzg.zzn(), this.zzg.zzd(), this.zzd.zzb(), this.zzg.zzk(), this.zzg.zzm());
    }

    public final /* synthetic */ void zzW(zzbw zzbw, zzlq zzlq, zzab zzab) {
        zzlq.zzi(zzbw, new zzlp(zzab, this.zze));
    }

    public final void zzX(int i, long j, long j2) {
        zzlo zzZ = zzZ(this.zzd.zzc());
        zzY(zzZ, 1006, new zzmb(zzZ, i, j, j2));
    }

    public final void zzY(zzlo zzlo, int i, zzdw zzdw) {
        this.zze.put(i, zzlo);
        zzdz zzdz = this.zzf;
        zzdz.zzd(i, zzdw);
        zzdz.zzc();
    }

    public final void zza(zzbt zzbt) {
        zzlo zzT = zzT();
        zzY(zzT, 13, new zzlx(zzT, zzbt));
    }

    public final void zzae(int i, zzui zzui, zzue zzue) {
        zzlo zzaa = zzaa(i, zzui);
        zzY(zzaa, 1004, new zzmt(zzaa, zzue));
    }

    public final void zzaf(int i, zzui zzui, zztz zztz, zzue zzue) {
        zzlo zzaa = zzaa(i, zzui);
        zzY(zzaa, AdError.LOAD_TOO_FREQUENTLY_ERROR_CODE, new zzmu(zzaa, zztz, zzue));
    }

    public final void zzag(int i, zzui zzui, zztz zztz, zzue zzue) {
        zzlo zzaa = zzaa(i, zzui);
        zzY(zzaa, AdError.NO_FILL_ERROR_CODE, new zzmy(zzaa, zztz, zzue));
    }

    public final void zzah(int i, zzui zzui, zztz zztz, zzue zzue, IOException iOException, boolean z) {
        zzlo zzaa = zzaa(i, zzui);
        zzY(zzaa, 1003, new zzmf(zzaa, zztz, zzue, iOException, z));
    }

    public final void zzai(int i, zzui zzui, zztz zztz, zzue zzue) {
        zzlo zzaa = zzaa(i, zzui);
        zzY(zzaa, 1000, new zzlw(zzaa, zztz, zzue));
    }

    public final void zzb(boolean z) {
        zzlo zzT = zzT();
        zzY(zzT, 3, new zzlu(zzT, z));
    }

    public final void zzc(boolean z) {
        zzlo zzT = zzT();
        zzY(zzT, 7, new zzmj(zzT, z));
    }

    public final void zzd(zzbc zzbc, int i) {
        zzlo zzT = zzT();
        zzY(zzT, 1, new zzlz(zzT, zzbc, i));
    }

    public final void zze(zzbh zzbh) {
        zzlo zzT = zzT();
        zzY(zzT, 14, new zznn(zzT, zzbh));
    }

    public final void zzf(boolean z, int i) {
        zzlo zzT = zzT();
        zzY(zzT, 5, new zzmq(zzT, z, i));
    }

    public final void zzg(zzbq zzbq) {
        zzlo zzT = zzT();
        zzY(zzT, 12, new zzlr(zzT, zzbq));
    }

    public final void zzh(int i) {
        zzlo zzT = zzT();
        zzY(zzT, 4, new zzmx(zzT, i));
    }

    public final void zzi(int i) {
        zzlo zzT = zzT();
        zzY(zzT, 6, new zzmm(zzT, i));
    }

    public final void zzj(zzbp zzbp) {
        zzlo zzad = zzad(zzbp);
        zzY(zzad, 10, new zzmv(zzad, zzbp));
    }

    public final void zzk(zzbp zzbp) {
        zzlo zzad = zzad(zzbp);
        zzY(zzad, 10, new zzmp(zzad, zzbp));
    }

    public final void zzl(boolean z, int i) {
        zzlo zzT = zzT();
        zzY(zzT, -1, new zzmh(zzT, z, i));
    }

    public final void zzm(zzbv zzbv, zzbv zzbv2, int i) {
        if (i == 1) {
            this.zzi = false;
            i = 1;
        }
        zznp zznp = this.zzd;
        zzbw zzbw = this.zzg;
        zzbw.getClass();
        zznp.zzg(zzbw);
        zzlo zzT = zzT();
        zzY(zzT, 11, new zznf(zzT, i, zzbv, zzbv2));
    }

    public final void zzn(boolean z) {
        zzlo zzac = zzac();
        zzY(zzac, 23, new zzma(zzac, z));
    }

    public final void zzo(int i, int i2) {
        zzlo zzac = zzac();
        zzY(zzac, 24, new zzno(zzac, i, i2));
    }

    public final void zzp(zzcc zzcc, int i) {
        zzbw zzbw = this.zzg;
        zzbw.getClass();
        this.zzd.zzi(zzbw);
        zzlo zzT = zzT();
        zzY(zzT, 0, new zzly(zzT, i));
    }

    public final void zzq(zzck zzck) {
        zzlo zzT = zzT();
        zzY(zzT, 2, new zzmk(zzT, zzck));
    }

    public final void zzr(zzcp zzcp) {
        zzlo zzac = zzac();
        zzY(zzac, 25, new zznc(zzac, zzcp));
    }

    public final void zzs(float f) {
        zzlo zzac = zzac();
        zzY(zzac, 22, new zzmc(zzac, f));
    }

    public final void zzt(zzlq zzlq) {
        this.zzf.zzb(zzlq);
    }

    public final void zzu() {
        if (!this.zzi) {
            zzlo zzT = zzT();
            this.zzi = true;
            zzY(zzT, -1, new zznd(zzT));
        }
    }

    public final void zzv(Exception exc) {
        zzlo zzac = zzac();
        zzY(zzac, 1029, new zznj(zzac, exc));
    }

    public final void zzw(String str, long j, long j2) {
        zzlo zzac = zzac();
        zzY(zzac, 1008, new zzml(zzac, str, j2, j));
    }

    public final void zzx(String str) {
        zzlo zzac = zzac();
        zzY(zzac, 1012, new zzlv(zzac, str));
    }

    public final void zzy(zzhn zzhn) {
        zzlo zzab = zzab();
        zzY(zzab, 1013, new zzmw(zzab, zzhn));
    }

    public final void zzz(zzhn zzhn) {
        zzlo zzac = zzac();
        zzY(zzac, 1007, new zzlt(zzac, zzhn));
    }
}
