package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzth implements zzuk {
    private final ArrayList zza = new ArrayList(1);
    private final HashSet zzb = new HashSet(1);
    private final zzur zzc = new zzur();
    private final zzrd zzd = new zzrd();
    private Looper zze;
    private zzcc zzf;
    private zznz zzg;

    public /* synthetic */ zzcc zzM() {
        return null;
    }

    public final zznz zzb() {
        zznz zznz = this.zzg;
        zzdi.zzb(zznz);
        return zznz;
    }

    public final zzrd zzc(zzui zzui) {
        return this.zzd.zza(0, zzui);
    }

    public final zzrd zzd(int i, zzui zzui) {
        return this.zzd.zza(0, zzui);
    }

    public final zzur zze(zzui zzui) {
        return this.zzc.zza(0, zzui);
    }

    public final zzur zzf(int i, zzui zzui) {
        return this.zzc.zza(0, zzui);
    }

    public final void zzg(Handler handler, zzre zzre) {
        this.zzd.zzb(handler, zzre);
    }

    public final void zzh(Handler handler, zzus zzus) {
        this.zzc.zzb(handler, zzus);
    }

    public final void zzi(zzuj zzuj) {
        boolean z = !this.zzb.isEmpty();
        this.zzb.remove(zzuj);
        if (z && this.zzb.isEmpty()) {
            zzj();
        }
    }

    public final void zzk(zzuj zzuj) {
        this.zze.getClass();
        HashSet hashSet = this.zzb;
        boolean isEmpty = hashSet.isEmpty();
        hashSet.add(zzuj);
        if (isEmpty) {
            zzl();
        }
    }

    public final void zzm(zzuj zzuj, zzgu zzgu, zznz zznz) {
        Looper myLooper = Looper.myLooper();
        Looper looper = this.zze;
        boolean z = true;
        if (!(looper == null || looper == myLooper)) {
            z = false;
        }
        zzdi.zzd(z);
        this.zzg = zznz;
        zzcc zzcc = this.zzf;
        this.zza.add(zzuj);
        if (this.zze == null) {
            this.zze = myLooper;
            this.zzb.add(zzuj);
            zzn(zzgu);
        } else if (zzcc != null) {
            zzk(zzuj);
            zzuj.zza(this, zzcc);
        }
    }

    public abstract void zzn(zzgu zzgu);

    public final void zzo(zzcc zzcc) {
        this.zzf = zzcc;
        ArrayList arrayList = this.zza;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((zzuj) arrayList.get(i)).zza(this, zzcc);
        }
    }

    public final void zzp(zzuj zzuj) {
        this.zza.remove(zzuj);
        if (this.zza.isEmpty()) {
            this.zze = null;
            this.zzf = null;
            this.zzg = null;
            this.zzb.clear();
            zzq();
            return;
        }
        zzi(zzuj);
    }

    public abstract void zzq();

    public final void zzr(zzre zzre) {
        this.zzd.zzc(zzre);
    }

    public final void zzs(zzus zzus) {
        this.zzc.zzh(zzus);
    }

    public /* synthetic */ void zzt(zzbc zzbc) {
        throw null;
    }

    public final boolean zzu() {
        if (!this.zzb.isEmpty()) {
            return true;
        }
        return false;
    }

    public /* synthetic */ boolean zzv() {
        return true;
    }

    public void zzj() {
    }

    public void zzl() {
    }
}
