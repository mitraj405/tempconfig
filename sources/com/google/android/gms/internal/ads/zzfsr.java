package com.google.android.gms.internal.ads;

import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfsr extends zzftk {
    private final IBinder zza;
    private final String zzb;
    private final int zzc;
    private final float zzd;
    private final int zze;
    private final String zzf;

    public /* synthetic */ zzfsr(IBinder iBinder, String str, int i, float f, int i2, int i3, String str2, int i4, String str3, String str4, String str5, zzfsq zzfsq) {
        this.zza = iBinder;
        this.zzb = str;
        this.zzc = i;
        this.zzd = f;
        this.zze = i4;
        this.zzf = str4;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzftk) {
            zzftk zzftk = (zzftk) obj;
            if (this.zza.equals(zzftk.zzf()) && ((str = this.zzb) != null ? str.equals(zzftk.zzh()) : zzftk.zzh() == null) && this.zzc == zzftk.zzc() && Float.floatToIntBits(this.zzd) == Float.floatToIntBits(zzftk.zza())) {
                zzftk.zzb();
                zzftk.zzd();
                zzftk.zzj();
                if (this.zze == zzftk.zze()) {
                    zzftk.zzi();
                    String str2 = this.zzf;
                    if (str2 != null ? str2.equals(zzftk.zzg()) : zzftk.zzg() == null) {
                        zzftk.zzk();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = this.zza.hashCode() ^ 1000003;
        String str = this.zzb;
        int i2 = 0;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        int floatToIntBits = (((((hashCode * 1000003) ^ i) * 1000003) ^ this.zzc) * 1000003) ^ Float.floatToIntBits(this.zzd);
        int i3 = this.zze;
        String str2 = this.zzf;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((((floatToIntBits * 1525764945) ^ i3) * -721379959) ^ i2) * 1000003;
    }

    public final String toString() {
        StringBuilder K = xx.K("OverlayDisplayShowRequest{windowToken=", this.zza.toString(), ", appId=");
        K.append(this.zzb);
        K.append(", layoutGravity=");
        K.append(this.zzc);
        K.append(", layoutVerticalMargin=");
        K.append(this.zzd);
        K.append(", displayMode=0, triggerMode=0, sessionToken=null, windowWidthPx=");
        K.append(this.zze);
        K.append(", deeplinkUrl=null, adFieldEnifd=");
        return C0709Uj.j(K, this.zzf, ", thirdPartyAuthCallerId=null}");
    }

    public final float zza() {
        return this.zzd;
    }

    public final int zzb() {
        return 0;
    }

    public final int zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return 0;
    }

    public final int zze() {
        return this.zze;
    }

    public final IBinder zzf() {
        return this.zza;
    }

    public final String zzg() {
        return this.zzf;
    }

    public final String zzh() {
        return this.zzb;
    }

    public final String zzi() {
        return null;
    }

    public final String zzj() {
        return null;
    }

    public final String zzk() {
        return null;
    }
}
