package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zznp {
    private final zzca zza;
    /* access modifiers changed from: private */
    public zzfxr zzb = zzfxr.zzm();
    private zzfxu zzc = zzfxu.zzd();
    private zzui zzd;
    private zzui zze;
    private zzui zzf;

    public zznp(zzca zzca) {
        this.zza = zzca;
    }

    private static zzui zzj(zzbw zzbw, zzfxr zzfxr, zzui zzui, zzca zzca) {
        Object obj;
        int i;
        zzcc zzn = zzbw.zzn();
        int zze2 = zzbw.zze();
        if (zzn.zzo()) {
            obj = null;
        } else {
            obj = zzn.zzf(zze2);
        }
        if (zzbw.zzw() || zzn.zzo()) {
            i = -1;
        } else {
            i = zzn.zzd(zze2, zzca, false).zzc(zzet.zzr(zzbw.zzk()));
        }
        for (int i2 = 0; i2 < zzfxr.size(); i2++) {
            zzui zzui2 = (zzui) zzfxr.get(i2);
            if (zzm(zzui2, obj, zzbw.zzw(), zzbw.zzb(), zzbw.zzc(), i)) {
                return zzui2;
            }
        }
        if (zzfxr.isEmpty() && zzui != null) {
            if (zzm(zzui, obj, zzbw.zzw(), zzbw.zzb(), zzbw.zzc(), i)) {
                return zzui;
            }
        }
        return null;
    }

    private final void zzk(zzfxt zzfxt, zzui zzui, zzcc zzcc) {
        if (zzui != null) {
            if (zzcc.zza(zzui.zza) != -1) {
                zzfxt.zza(zzui, zzcc);
                return;
            }
            zzcc zzcc2 = (zzcc) this.zzc.get(zzui);
            if (zzcc2 != null) {
                zzfxt.zza(zzui, zzcc2);
            }
        }
    }

    private final void zzl(zzcc zzcc) {
        zzfxt zzfxt = new zzfxt();
        if (this.zzb.isEmpty()) {
            zzk(zzfxt, this.zze, zzcc);
            if (!zzfur.zza(this.zzf, this.zze)) {
                zzk(zzfxt, this.zzf, zzcc);
            }
            if (!zzfur.zza(this.zzd, this.zze) && !zzfur.zza(this.zzd, this.zzf)) {
                zzk(zzfxt, this.zzd, zzcc);
            }
        } else {
            for (int i = 0; i < this.zzb.size(); i++) {
                zzk(zzfxt, (zzui) this.zzb.get(i), zzcc);
            }
            if (!this.zzb.contains(this.zzd)) {
                zzk(zzfxt, this.zzd, zzcc);
            }
        }
        this.zzc = zzfxt.zzc();
    }

    private static boolean zzm(zzui zzui, Object obj, boolean z, int i, int i2, int i3) {
        if (!zzui.zza.equals(obj)) {
            return false;
        }
        if (z) {
            if (!(zzui.zzb == i && zzui.zzc == i2)) {
                return false;
            }
        } else if (!(zzui.zzb == -1 && zzui.zze == i3)) {
            return false;
        }
        return true;
    }

    public final zzcc zza(zzui zzui) {
        return (zzcc) this.zzc.get(zzui);
    }

    public final zzui zzb() {
        return this.zzd;
    }

    public final zzui zzc() {
        Object obj;
        Object next;
        if (this.zzb.isEmpty()) {
            return null;
        }
        zzfxr zzfxr = this.zzb;
        if (!(zzfxr instanceof List)) {
            Iterator it = zzfxr.iterator();
            do {
                next = it.next();
            } while (it.hasNext());
            obj = next;
        } else if (!zzfxr.isEmpty()) {
            obj = zzfxr.get(zzfxr.size() - 1);
        } else {
            throw new NoSuchElementException();
        }
        return (zzui) obj;
    }

    public final zzui zzd() {
        return this.zze;
    }

    public final zzui zze() {
        return this.zzf;
    }

    public final void zzg(zzbw zzbw) {
        this.zzd = zzj(zzbw, this.zzb, this.zze, this.zza);
    }

    public final void zzh(List list, zzui zzui, zzbw zzbw) {
        this.zzb = zzfxr.zzk(list);
        if (!list.isEmpty()) {
            this.zze = (zzui) list.get(0);
            zzui.getClass();
            this.zzf = zzui;
        }
        if (this.zzd == null) {
            this.zzd = zzj(zzbw, this.zzb, this.zze, this.zza);
        }
        zzl(zzbw.zzn());
    }

    public final void zzi(zzbw zzbw) {
        this.zzd = zzj(zzbw, this.zzb, this.zze, this.zza);
        zzl(zzbw.zzn());
    }
}
