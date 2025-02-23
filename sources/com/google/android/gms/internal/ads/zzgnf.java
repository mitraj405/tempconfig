package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzgnf {
    private final Class zza;
    private Map zzb = new HashMap();
    private final List zzc = new ArrayList();
    private zzgnh zzd;
    private zzgln zze;

    public /* synthetic */ zzgnf(Class cls, zzgne zzgne) {
        this.zza = cls;
        this.zze = zzgln.zza;
    }

    private final zzgnf zze(Object obj, zzgdy zzgdy, zzgtg zzgtg, boolean z) throws GeneralSecurityException {
        byte[] bArr;
        if (this.zzb == null) {
            throw new IllegalStateException("addEntry cannot be called after build");
        } else if (zzgtg.zzk() == 3) {
            int ordinal = zzgtg.zzf().ordinal();
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal == 3) {
                        bArr = zzgdt.zza;
                    } else if (ordinal != 4) {
                        throw new GeneralSecurityException("unknown output prefix type");
                    }
                }
                bArr = zzgml.zza(zzgtg.zza()).zzc();
            } else {
                bArr = zzgml.zzb(zzgtg.zza()).zzc();
            }
            zzgnh zzgnh = new zzgnh(obj, zzgvr.zzb(bArr), zzgtg.zzk(), zzgtg.zzf(), zzgtg.zza(), zzgtg.zzc().zzg(), zzgdy, (zzgng) null);
            Map map = this.zzb;
            List list = this.zzc;
            ArrayList arrayList = new ArrayList();
            arrayList.add(zzgnh);
            List list2 = (List) map.put(zzgnh.zzb, Collections.unmodifiableList(arrayList));
            if (list2 != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(list2);
                arrayList2.add(zzgnh);
                map.put(zzgnh.zzb, Collections.unmodifiableList(arrayList2));
            }
            list.add(zzgnh);
            if (z) {
                if (this.zzd == null) {
                    this.zzd = zzgnh;
                } else {
                    throw new IllegalStateException("you cannot set two primary primitives");
                }
            }
            return this;
        } else {
            throw new GeneralSecurityException("only ENABLED key is allowed");
        }
    }

    public final zzgnf zza(Object obj, zzgdy zzgdy, zzgtg zzgtg) throws GeneralSecurityException {
        zze(obj, zzgdy, zzgtg, false);
        return this;
    }

    public final zzgnf zzb(Object obj, zzgdy zzgdy, zzgtg zzgtg) throws GeneralSecurityException {
        zze(obj, zzgdy, zzgtg, true);
        return this;
    }

    public final zzgnf zzc(zzgln zzgln) {
        if (this.zzb != null) {
            this.zze = zzgln;
            return this;
        }
        throw new IllegalStateException("setAnnotations cannot be called after build");
    }

    public final zzgnj zzd() throws GeneralSecurityException {
        Map map = this.zzb;
        if (map != null) {
            zzgnj zzgnj = new zzgnj(map, this.zzc, this.zzd, this.zze, this.zza, (zzgni) null);
            this.zzb = null;
            return zzgnj;
        }
        throw new IllegalStateException("build cannot be called twice");
    }
}
