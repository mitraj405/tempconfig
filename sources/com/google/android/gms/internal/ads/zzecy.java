package com.google.android.gms.internal.ads;

import android.app.Activity;
import com.google.android.gms.ads.internal.overlay.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzecy extends zzedu {
    private final Activity zza;
    private final zzm zzb;
    private final String zzc;
    private final String zzd;

    public /* synthetic */ zzecy(Activity activity, zzm zzm, String str, String str2, zzecx zzecx) {
        this.zza = activity;
        this.zzb = zzm;
        this.zzc = str;
        this.zzd = str2;
    }

    public final boolean equals(Object obj) {
        zzm zzm;
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzedu) {
            zzedu zzedu = (zzedu) obj;
            if (!this.zza.equals(zzedu.zza()) || ((zzm = this.zzb) != null ? !zzm.equals(zzedu.zzb()) : zzedu.zzb() != null) || ((str = this.zzc) != null ? !str.equals(zzedu.zzc()) : zzedu.zzc() != null) || ((str2 = this.zzd) != null ? !str2.equals(zzedu.zzd()) : zzedu.zzd() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int i2;
        int hashCode = this.zza.hashCode() ^ 1000003;
        zzm zzm = this.zzb;
        int i3 = 0;
        if (zzm == null) {
            i = 0;
        } else {
            i = zzm.hashCode();
        }
        int i4 = ((hashCode * 1000003) ^ i) * 1000003;
        String str = this.zzc;
        if (str == null) {
            i2 = 0;
        } else {
            i2 = str.hashCode();
        }
        int i5 = (i4 ^ i2) * 1000003;
        String str2 = this.zzd;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return i5 ^ i3;
    }

    public final String toString() {
        StringBuilder b = C0437ME.b("OfflineUtilsParams{activity=", this.zza.toString(), ", adOverlay=", String.valueOf(this.zzb), ", gwsQueryId=");
        b.append(this.zzc);
        b.append(", uri=");
        return C0709Uj.j(b, this.zzd, "}");
    }

    public final Activity zza() {
        return this.zza;
    }

    public final zzm zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzd;
    }
}
