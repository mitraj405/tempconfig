package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzkw {
    private final zznz zza;
    private final List zzb = new ArrayList();
    private final IdentityHashMap zzc = new IdentityHashMap();
    private final Map zzd = new HashMap();
    private final zzkv zze;
    private final HashMap zzf;
    private final Set zzg;
    /* access modifiers changed from: private */
    public final zzln zzh;
    /* access modifiers changed from: private */
    public final zzdt zzi;
    private boolean zzj;
    private zzgu zzk;
    private zzwa zzl = new zzwa(0);

    public zzkw(zzkv zzkv, zzln zzln, zzdt zzdt, zznz zznz) {
        this.zza = zznz;
        this.zze = zzkv;
        this.zzh = zzln;
        this.zzi = zzdt;
        this.zzf = new HashMap();
        this.zzg = new HashSet();
    }

    private final void zzr(int i, int i2) {
        while (i < this.zzb.size()) {
            ((zzku) this.zzb.get(i)).zzd += i2;
            i++;
        }
    }

    private final void zzs(zzku zzku) {
        zzkt zzkt = (zzkt) this.zzf.get(zzku);
        if (zzkt != null) {
            zzkt.zza.zzi(zzkt.zzb);
        }
    }

    private final void zzt() {
        Iterator it = this.zzg.iterator();
        while (it.hasNext()) {
            zzku zzku = (zzku) it.next();
            if (zzku.zzc.isEmpty()) {
                zzs(zzku);
                it.remove();
            }
        }
    }

    private final void zzu(zzku zzku) {
        if (zzku.zze && zzku.zzc.isEmpty()) {
            zzkt zzkt = (zzkt) this.zzf.remove(zzku);
            zzkt.getClass();
            zzkt.zza.zzp(zzkt.zzb);
            zzkt.zza.zzs(zzkt.zzc);
            zzkt.zza.zzr(zzkt.zzc);
            this.zzg.remove(zzku);
        }
    }

    private final void zzv(zzku zzku) {
        zzud zzud = zzku.zza;
        zzkm zzkm = new zzkm(this);
        zzks zzks = new zzks(this, zzku);
        this.zzf.put(zzku, new zzkt(zzud, zzkm, zzks));
        zzud.zzh(new Handler(zzet.zzy(), (Handler.Callback) null), zzks);
        zzud.zzg(new Handler(zzet.zzy(), (Handler.Callback) null), zzks);
        zzud.zzm(zzkm, this.zzk, this.zza);
    }

    private final void zzw(int i, int i2) {
        while (true) {
            i2--;
            if (i2 >= i) {
                zzku zzku = (zzku) this.zzb.remove(i2);
                this.zzd.remove(zzku.zzb);
                zzr(i2, -zzku.zza.zzC().zzc());
                zzku.zze = true;
                if (this.zzj) {
                    zzu(zzku);
                }
            } else {
                return;
            }
        }
    }

    public final int zza() {
        return this.zzb.size();
    }

    public final zzcc zzb() {
        if (this.zzb.isEmpty()) {
            return zzcc.zza;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.zzb.size(); i2++) {
            zzku zzku = (zzku) this.zzb.get(i2);
            zzku.zzd = i;
            i += zzku.zza.zzC().zzc();
        }
        return new zzlc(this.zzb, this.zzl);
    }

    public final zzcc zzc(int i, int i2, List list) {
        boolean z;
        boolean z2 = true;
        if (i < 0 || i > i2 || i2 > zza()) {
            z = false;
        } else {
            z = true;
        }
        zzdi.zzd(z);
        if (list.size() != i2 - i) {
            z2 = false;
        }
        zzdi.zzd(z2);
        for (int i3 = i; i3 < i2; i3++) {
            ((zzku) this.zzb.get(i3)).zza.zzt((zzbc) list.get(i3 - i));
        }
        return zzb();
    }

    public final /* synthetic */ void zzf(zzuk zzuk, zzcc zzcc) {
        this.zze.zzg();
    }

    public final void zzg(zzgu zzgu) {
        zzdi.zzf(!this.zzj);
        this.zzk = zzgu;
        for (int i = 0; i < this.zzb.size(); i++) {
            zzku zzku = (zzku) this.zzb.get(i);
            zzv(zzku);
            this.zzg.add(zzku);
        }
        this.zzj = true;
    }

    public final void zzh() {
        for (zzkt zzkt : this.zzf.values()) {
            try {
                zzkt.zza.zzp(zzkt.zzb);
            } catch (RuntimeException e) {
                zzea.zzd("MediaSourceList", "Failed to release child source.", e);
            }
            zzkt.zza.zzs(zzkt.zzc);
            zzkt.zza.zzr(zzkt.zzc);
        }
        this.zzf.clear();
        this.zzg.clear();
        this.zzj = false;
    }

    public final void zzi(zzug zzug) {
        zzku zzku = (zzku) this.zzc.remove(zzug);
        zzku.getClass();
        zzku.zza.zzG(zzug);
        zzku.zzc.remove(((zzua) zzug).zza);
        if (!this.zzc.isEmpty()) {
            zzt();
        }
        zzu(zzku);
    }

    public final boolean zzj() {
        return this.zzj;
    }

    public final zzcc zzk(int i, List list, zzwa zzwa) {
        if (!list.isEmpty()) {
            this.zzl = zzwa;
            for (int i2 = i; i2 < list.size() + i; i2++) {
                zzku zzku = (zzku) list.get(i2 - i);
                if (i2 > 0) {
                    zzku zzku2 = (zzku) this.zzb.get(i2 - 1);
                    zzcc zzC = zzku2.zza.zzC();
                    zzku.zzc(zzC.zzc() + zzku2.zzd);
                } else {
                    zzku.zzc(0);
                }
                zzr(i2, zzku.zza.zzC().zzc());
                this.zzb.add(i2, zzku);
                this.zzd.put(zzku.zzb, zzku);
                if (this.zzj) {
                    zzv(zzku);
                    if (this.zzc.isEmpty()) {
                        this.zzg.add(zzku);
                    } else {
                        zzs(zzku);
                    }
                }
            }
        }
        return zzb();
    }

    public final zzcc zzl(int i, int i2, int i3, zzwa zzwa) {
        boolean z;
        if (zza() >= 0) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zzd(z);
        this.zzl = null;
        return zzb();
    }

    public final zzcc zzm(int i, int i2, zzwa zzwa) {
        boolean z = false;
        if (i >= 0 && i <= i2 && i2 <= zza()) {
            z = true;
        }
        zzdi.zzd(z);
        this.zzl = zzwa;
        zzw(i, i2);
        return zzb();
    }

    public final zzcc zzn(List list, zzwa zzwa) {
        zzw(0, this.zzb.size());
        return zzk(this.zzb.size(), list, zzwa);
    }

    public final zzcc zzo(zzwa zzwa) {
        int zza2 = zza();
        if (zzwa.zzc() != zza2) {
            zzwa = zzwa.zzf().zzg(0, zza2);
        }
        this.zzl = zzwa;
        return zzb();
    }

    public final zzug zzp(zzui zzui, zzyk zzyk, long j) {
        int i = zzlc.zzb;
        Object obj = zzui.zza;
        Object obj2 = ((Pair) obj).first;
        zzui zza2 = zzui.zza(((Pair) obj).second);
        zzku zzku = (zzku) this.zzd.get(obj2);
        zzku.getClass();
        this.zzg.add(zzku);
        zzkt zzkt = (zzkt) this.zzf.get(zzku);
        if (zzkt != null) {
            zzkt.zza.zzk(zzkt.zzb);
        }
        zzku.zzc.add(zza2);
        zzua zzH = zzku.zza.zzI(zza2, zzyk, j);
        this.zzc.put(zzH, zzku);
        zzt();
        return zzH;
    }

    public final zzwa zzq() {
        return this.zzl;
    }
}
