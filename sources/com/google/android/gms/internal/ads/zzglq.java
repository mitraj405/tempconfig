package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzglq {
    private ArrayList zza = new ArrayList();
    private zzgln zzb = zzgln.zza;
    private Integer zzc = null;

    public final zzglq zza(zzgea zzgea, int i, String str, String str2) {
        ArrayList arrayList = this.zza;
        if (arrayList != null) {
            arrayList.add(new zzgls(zzgea, i, str, str2, (zzglr) null));
            return this;
        }
        throw new IllegalStateException("addEntry cannot be called after build()");
    }

    public final zzglq zzb(zzgln zzgln) {
        if (this.zza != null) {
            this.zzb = zzgln;
            return this;
        }
        throw new IllegalStateException("setAnnotations cannot be called after build()");
    }

    public final zzglq zzc(int i) {
        if (this.zza != null) {
            this.zzc = Integer.valueOf(i);
            return this;
        }
        throw new IllegalStateException("setPrimaryKeyId cannot be called after build()");
    }

    public final zzglu zzd() throws GeneralSecurityException {
        if (this.zza != null) {
            Integer num = this.zzc;
            if (num != null) {
                int intValue = num.intValue();
                ArrayList arrayList = this.zza;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    int zza2 = ((zzgls) arrayList.get(i)).zza();
                    i++;
                    if (zza2 == intValue) {
                    }
                }
                throw new GeneralSecurityException("primary key ID is not present in entries");
            }
            zzglu zzglu = new zzglu(this.zzb, Collections.unmodifiableList(this.zza), this.zzc, (zzglt) null);
            this.zza = null;
            return zzglu;
        }
        throw new IllegalStateException("cannot call build() twice");
    }
}
