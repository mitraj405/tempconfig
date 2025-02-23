package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzhak implements Iterator {
    final /* synthetic */ zzhao zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator zzd;

    public /* synthetic */ zzhak(zzhao zzhao, zzhaj zzhaj) {
        this.zza = zzhao;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzb.entrySet().iterator();
        }
        return this.zzd;
    }

    public final boolean hasNext() {
        if (this.zzb + 1 < this.zza.zza.size()) {
            return true;
        }
        if (this.zza.zzb.isEmpty()) {
            return false;
        }
        if (zza().hasNext()) {
            return true;
        }
        return false;
    }

    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        if (i < this.zza.zza.size()) {
            return (Map.Entry) this.zza.zza.get(this.zzb);
        }
        return (Map.Entry) zza().next();
    }

    public final void remove() {
        if (this.zzc) {
            this.zzc = false;
            this.zza.zzn();
            if (this.zzb < this.zza.zza.size()) {
                zzhao zzhao = this.zza;
                int i = this.zzb;
                this.zzb = i - 1;
                Object unused = zzhao.zzl(i);
                return;
            }
            zza().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
