package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzflu extends zzflq {
    private final zzfls zza;
    private final zzfmp zzb = new zzfmp();
    private zzfoa zzc;
    private zzfmz zzd;
    private boolean zze = false;
    private boolean zzf = false;
    private final String zzg;

    public zzflu(zzflr zzflr, zzfls zzfls, String str) {
        this.zza = zzfls;
        this.zzg = str;
        zzk((View) null);
        if (zzfls.zzd() == zzflt.HTML || zzfls.zzd() == zzflt.JAVASCRIPT) {
            this.zzd = new zzfna(str, zzfls.zza());
        } else {
            this.zzd = new zzfnd(str, zzfls.zzi(), (String) null);
        }
        this.zzd.zzn();
        zzfml.zza().zzd(this);
        this.zzd.zzf(zzflr);
    }

    private final void zzk(View view) {
        this.zzc = new zzfoa(view);
    }

    public final void zzb(View view, zzflx zzflx, String str) {
        if (!this.zzf) {
            this.zzb.zzb(view, zzflx, "Ad overlay");
        }
    }

    public final void zzc() {
        if (!this.zzf) {
            this.zzc.clear();
            if (!this.zzf) {
                this.zzb.zzc();
            }
            this.zzf = true;
            this.zzd.zze();
            zzfml.zza().zze(this);
            this.zzd.zzc();
            this.zzd = null;
        }
    }

    public final void zzd(View view) {
        if (!this.zzf && zzf() != view) {
            zzk(view);
            this.zzd.zzb();
            Collection<zzflu> zzc2 = zzfml.zza().zzc();
            if (zzc2 != null && !zzc2.isEmpty()) {
                for (zzflu zzflu : zzc2) {
                    if (zzflu != this && zzflu.zzf() == view) {
                        zzflu.zzc.clear();
                    }
                }
            }
        }
    }

    public final void zze() {
        if (!this.zze) {
            this.zze = true;
            zzfml.zza().zzf(this);
            this.zzd.zzl(zzfmt.zzb().zza());
            this.zzd.zzg(zzfmj.zza().zzb());
            this.zzd.zzi(this, this.zza);
        }
    }

    public final View zzf() {
        return (View) this.zzc.get();
    }

    public final zzfmz zzg() {
        return this.zzd;
    }

    public final String zzh() {
        return this.zzg;
    }

    public final List zzi() {
        return this.zzb.zza();
    }

    public final boolean zzj() {
        if (!this.zze || this.zzf) {
            return false;
        }
        return true;
    }
}
