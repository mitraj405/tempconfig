package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgnx {
    /* access modifiers changed from: private */
    public final Map zza;
    /* access modifiers changed from: private */
    public final Map zzb;
    /* access modifiers changed from: private */
    public final Map zzc;
    /* access modifiers changed from: private */
    public final Map zzd;

    public /* synthetic */ zzgnx(zzgnr zzgnr, zzgnw zzgnw) {
        this.zza = new HashMap(zzgnr.zza);
        this.zzb = new HashMap(zzgnr.zzb);
        this.zzc = new HashMap(zzgnr.zzc);
        this.zzd = new HashMap(zzgnr.zzd);
    }

    public final zzgdy zza(zzgnq zzgnq, zzger zzger) throws GeneralSecurityException {
        zzgnt zzgnt = new zzgnt(zzgnq.getClass(), zzgnq.zzd(), (zzgns) null);
        if (this.zzb.containsKey(zzgnt)) {
            return ((zzglc) this.zzb.get(zzgnt)).zza(zzgnq, zzger);
        }
        throw new GeneralSecurityException(lf.j("No Key Parser for requested key type ", zzgnt.toString(), " available"));
    }

    public final zzgen zzb(zzgnq zzgnq) throws GeneralSecurityException {
        zzgnt zzgnt = new zzgnt(zzgnq.getClass(), zzgnq.zzd(), (zzgns) null);
        if (this.zzd.containsKey(zzgnt)) {
            return ((zzgmp) this.zzd.get(zzgnt)).zza(zzgnq);
        }
        throw new GeneralSecurityException(lf.j("No Parameters Parser for requested key type ", zzgnt.toString(), " available"));
    }

    public final zzgnq zzc(zzgdy zzgdy, Class cls, zzger zzger) throws GeneralSecurityException {
        zzgnv zzgnv = new zzgnv(zzgdy.getClass(), cls, (zzgnu) null);
        if (this.zza.containsKey(zzgnv)) {
            return ((zzglg) this.zza.get(zzgnv)).zza(zzgdy, zzger);
        }
        throw new GeneralSecurityException(lf.j("No Key serializer for ", zzgnv.toString(), " available"));
    }

    public final zzgnq zzd(zzgen zzgen, Class cls) throws GeneralSecurityException {
        zzgnv zzgnv = new zzgnv(zzgen.getClass(), cls, (zzgnu) null);
        if (this.zzc.containsKey(zzgnv)) {
            return ((zzgmt) this.zzc.get(zzgnv)).zza(zzgen);
        }
        throw new GeneralSecurityException(lf.j("No Key Format serializer for ", zzgnv.toString(), " available"));
    }

    public final boolean zzi(zzgnq zzgnq) {
        return this.zzb.containsKey(new zzgnt(zzgnq.getClass(), zzgnq.zzd(), (zzgns) null));
    }

    public final boolean zzj(zzgnq zzgnq) {
        return this.zzd.containsKey(new zzgnt(zzgnq.getClass(), zzgnq.zzd(), (zzgns) null));
    }
}
