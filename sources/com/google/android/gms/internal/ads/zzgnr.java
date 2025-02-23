package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgnr {
    /* access modifiers changed from: private */
    public final Map zza;
    /* access modifiers changed from: private */
    public final Map zzb;
    /* access modifiers changed from: private */
    public final Map zzc;
    /* access modifiers changed from: private */
    public final Map zzd;

    public zzgnr() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
        this.zzc = new HashMap();
        this.zzd = new HashMap();
    }

    public final zzgnr zza(zzglc zzglc) throws GeneralSecurityException {
        zzgnt zzgnt = new zzgnt(zzglc.zzd(), zzglc.zzc(), (zzgns) null);
        if (this.zzb.containsKey(zzgnt)) {
            zzglc zzglc2 = (zzglc) this.zzb.get(zzgnt);
            if (!zzglc2.equals(zzglc) || !zzglc.equals(zzglc2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzgnt.toString()));
            }
        } else {
            this.zzb.put(zzgnt, zzglc);
        }
        return this;
    }

    public final zzgnr zzb(zzglg zzglg) throws GeneralSecurityException {
        zzgnv zzgnv = new zzgnv(zzglg.zzc(), zzglg.zzd(), (zzgnu) null);
        if (this.zza.containsKey(zzgnv)) {
            zzglg zzglg2 = (zzglg) this.zza.get(zzgnv);
            if (!zzglg2.equals(zzglg) || !zzglg.equals(zzglg2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzgnv.toString()));
            }
        } else {
            this.zza.put(zzgnv, zzglg);
        }
        return this;
    }

    public final zzgnr zzc(zzgmp zzgmp) throws GeneralSecurityException {
        zzgnt zzgnt = new zzgnt(zzgmp.zzd(), zzgmp.zzc(), (zzgns) null);
        if (this.zzd.containsKey(zzgnt)) {
            zzgmp zzgmp2 = (zzgmp) this.zzd.get(zzgnt);
            if (!zzgmp2.equals(zzgmp) || !zzgmp.equals(zzgmp2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzgnt.toString()));
            }
        } else {
            this.zzd.put(zzgnt, zzgmp);
        }
        return this;
    }

    public final zzgnr zzd(zzgmt zzgmt) throws GeneralSecurityException {
        zzgnv zzgnv = new zzgnv(zzgmt.zzc(), zzgmt.zzd(), (zzgnu) null);
        if (this.zzc.containsKey(zzgnv)) {
            zzgmt zzgmt2 = (zzgmt) this.zzc.get(zzgnv);
            if (!zzgmt2.equals(zzgmt) || !zzgmt.equals(zzgmt2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzgnv.toString()));
            }
        } else {
            this.zzc.put(zzgnv, zzgmt);
        }
        return this;
    }

    public zzgnr(zzgnx zzgnx) {
        this.zza = new HashMap(zzgnx.zza);
        this.zzb = new HashMap(zzgnx.zzb);
        this.zzc = new HashMap(zzgnx.zzc);
        this.zzd = new HashMap(zzgnx.zzd);
    }
}
