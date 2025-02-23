package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzhm implements zzle, zzlh {
    private final Object zza = new Object();
    private final int zzb;
    private final zzjz zzc;
    private zzli zzd;
    private int zze;
    private zznz zzf;
    private zzdj zzg;
    private int zzh;
    private zzvx zzi;
    private zzaf[] zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private boolean zzn;
    private boolean zzo;
    private zzcc zzp;
    private zzlg zzq;

    public zzhm(int i) {
        this.zzb = i;
        this.zzc = new zzjz();
        this.zzm = Long.MIN_VALUE;
        this.zzp = zzcc.zza;
    }

    private final void zzZ(long j, boolean z) throws zzhw {
        this.zzn = false;
        this.zzl = j;
        this.zzm = j;
        zzz(j, z);
    }

    public final void zzB() {
        zzlg zzlg;
        synchronized (this.zza) {
            zzlg = this.zzq;
        }
        if (zzlg != null) {
            zzlg.zza(this);
        }
    }

    public void zzF(zzaf[] zzafArr, long j, long j2, zzui zzui) throws zzhw {
        throw null;
    }

    public final void zzG() {
        boolean z;
        if (this.zzh == 0) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zzf(z);
        zzA();
    }

    public final void zzH(zzaf[] zzafArr, zzvx zzvx, long j, long j2, zzui zzui) throws zzhw {
        zzdi.zzf(!this.zzn);
        this.zzi = zzvx;
        if (this.zzm == Long.MIN_VALUE) {
            this.zzm = j;
        }
        this.zzj = zzafArr;
        this.zzk = j2;
        zzF(zzafArr, j, j2, zzui);
    }

    public final void zzI() {
        boolean z;
        if (this.zzh == 0) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zzf(z);
        zzjz zzjz = this.zzc;
        zzjz.zzb = null;
        zzjz.zza = null;
        zzC();
    }

    public final void zzJ(long j) throws zzhw {
        zzZ(j, false);
    }

    public final void zzK() {
        this.zzn = true;
    }

    public final void zzL(zzlg zzlg) {
        synchronized (this.zza) {
            this.zzq = zzlg;
        }
    }

    public final void zzN(zzcc zzcc) {
        if (!zzet.zzG(this.zzp, zzcc)) {
            this.zzp = zzcc;
        }
    }

    public final void zzO() throws zzhw {
        boolean z = true;
        if (this.zzh != 1) {
            z = false;
        }
        zzdi.zzf(z);
        this.zzh = 2;
        zzD();
    }

    public final void zzP() {
        boolean z;
        if (this.zzh == 2) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zzf(z);
        this.zzh = 1;
        zzE();
    }

    public final boolean zzQ() {
        if (this.zzm == Long.MIN_VALUE) {
            return true;
        }
        return false;
    }

    public final boolean zzR() {
        return this.zzn;
    }

    public final boolean zzS() {
        if (zzQ()) {
            return this.zzn;
        }
        zzvx zzvx = this.zzi;
        zzvx.getClass();
        return zzvx.zze();
    }

    public final zzaf[] zzT() {
        zzaf[] zzafArr = this.zzj;
        zzafArr.getClass();
        return zzafArr;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzcV() {
        return this.zzh;
    }

    public final int zzcW(zzjz zzjz, zzhd zzhd, int i) {
        zzvx zzvx = this.zzi;
        zzvx.getClass();
        int zza2 = zzvx.zza(zzjz, zzhd, i);
        if (zza2 == -4) {
            if (zzhd.zzf()) {
                this.zzm = Long.MIN_VALUE;
                if (this.zzn) {
                    return -4;
                }
                return -3;
            }
            long j = zzhd.zze + this.zzk;
            zzhd.zze = j;
            this.zzm = Math.max(this.zzm, j);
        } else if (zza2 == -5) {
            zzaf zzaf = zzjz.zza;
            zzaf.getClass();
            long j2 = zzaf.zzq;
            if (j2 != Long.MAX_VALUE) {
                zzad zzb2 = zzaf.zzb();
                zzb2.zzab(j2 + this.zzk);
                zzjz.zza = zzb2.zzad();
                return -5;
            }
        }
        return zza2;
    }

    public final long zzcX() {
        return this.zzm;
    }

    public final zzjz zzcY() {
        zzjz zzjz = this.zzc;
        zzjz.zzb = null;
        zzjz.zza = null;
        return zzjz;
    }

    public final int zzd(long j) {
        zzvx zzvx = this.zzi;
        zzvx.getClass();
        return zzvx.zzb(j - this.zzk);
    }

    public int zze() throws zzhw {
        return 0;
    }

    public final long zzf() {
        return this.zzl;
    }

    public final zzdj zzh() {
        zzdj zzdj = this.zzg;
        zzdj.getClass();
        return zzdj;
    }

    public final zzhw zzi(Throwable th, zzaf zzaf, boolean z, int i) {
        int i2 = 4;
        if (zzaf != null && !this.zzo) {
            this.zzo = true;
            try {
                i2 = zzY(zzaf) & 7;
            } catch (zzhw unused) {
            } finally {
                this.zzo = false;
            }
        }
        return zzhw.zzb(th, zzU(), this.zze, zzaf, i2, z, i);
    }

    public zzkg zzk() {
        return null;
    }

    public final zzli zzm() {
        zzli zzli = this.zzd;
        zzli.getClass();
        return zzli;
    }

    public final zznz zzn() {
        zznz zznz = this.zzf;
        zznz.getClass();
        return zznz;
    }

    public final zzvx zzo() {
        return this.zzi;
    }

    public final void zzp() {
        synchronized (this.zza) {
            this.zzq = null;
        }
    }

    public final void zzq() {
        boolean z = true;
        if (this.zzh != 1) {
            z = false;
        }
        zzdi.zzf(z);
        zzjz zzjz = this.zzc;
        zzjz.zzb = null;
        zzjz.zza = null;
        this.zzh = 0;
        this.zzi = null;
        this.zzj = null;
        this.zzn = false;
        zzw();
    }

    public final void zzr(zzli zzli, zzaf[] zzafArr, zzvx zzvx, long j, boolean z, boolean z2, long j2, long j3, zzui zzui) throws zzhw {
        boolean z3;
        boolean z4 = z;
        if (this.zzh == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdi.zzf(z3);
        this.zzd = zzli;
        this.zzh = 1;
        zzx(z4, z2);
        zzH(zzafArr, zzvx, j2, j3, zzui);
        zzZ(j2, z4);
    }

    public final void zzu(int i, zznz zznz, zzdj zzdj) {
        this.zze = i;
        this.zzf = zznz;
        this.zzg = zzdj;
        zzy();
    }

    public final void zzv() throws IOException {
        zzvx zzvx = this.zzi;
        zzvx.getClass();
        zzvx.zzd();
    }

    public void zzw() {
        throw null;
    }

    public void zzz(long j, boolean z) throws zzhw {
        throw null;
    }

    public void zzA() {
    }

    public void zzC() {
    }

    public void zzD() throws zzhw {
    }

    public void zzE() {
    }

    public final zzlh zzl() {
        return this;
    }

    public /* synthetic */ void zzs() {
    }

    public void zzy() {
    }

    public /* synthetic */ void zzM(float f, float f2) {
    }

    public void zzt(int i, Object obj) throws zzhw {
    }

    public void zzx(boolean z, boolean z2) throws zzhw {
    }
}
