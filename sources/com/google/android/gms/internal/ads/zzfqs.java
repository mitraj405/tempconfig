package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfqs extends zzfqy {
    private final String zzb;
    private final int zzc;

    public /* synthetic */ zzfqs(String str, boolean z, boolean z2, zzfqo zzfqo, zzfqp zzfqp, int i, zzfqr zzfqr) {
        this.zzb = str;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfqy) {
            zzfqy zzfqy = (zzfqy) obj;
            if (this.zzb.equals(zzfqy.zzc())) {
                zzfqy.zzd();
                zzfqy.zze();
                zzfqy.zza();
                zzfqy.zzb();
                int i = this.zzc;
                int zzf = zzfqy.zzf();
                if (i == 0) {
                    throw null;
                } else if (zzf == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.zzb.hashCode() ^ 1000003;
        if (this.zzc != 0) {
            return (((((hashCode * 1000003) ^ 1237) * 1000003) ^ 1237) * 583896283) ^ 1;
        }
        throw null;
    }

    public final String toString() {
        String str;
        if (this.zzc != 1) {
            str = "null";
        } else {
            str = "READ_AND_WRITE";
        }
        return C1058d.A("FileComplianceOptions{fileOwner=", this.zzb, ", hasDifferentDmaOwner=false, skipChecks=false, dataForwardingNotAllowedResolver=null, multipleProductIdGroupsResolver=null, filePurpose=", str, "}");
    }

    public final zzfqo zza() {
        return null;
    }

    public final zzfqp zzb() {
        return null;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final boolean zzd() {
        return false;
    }

    public final boolean zze() {
        return false;
    }

    public final int zzf() {
        return this.zzc;
    }
}
