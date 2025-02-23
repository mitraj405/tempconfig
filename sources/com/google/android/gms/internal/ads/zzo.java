package com.google.android.gms.internal.ads;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzo {
    public static final zzo zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final byte[] zze;
    public final int zzf;
    public final int zzg;
    private int zzh;

    static {
        zzm zzm = new zzm();
        zzm.zzc(1);
        zzm.zzb(2);
        zzm.zzd(3);
        zza = zzm.zzg();
        zzm zzm2 = new zzm();
        zzm2.zzc(1);
        zzm2.zzb(1);
        zzm2.zzd(2);
        zzm2.zzg();
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
    }

    public /* synthetic */ zzo(int i, int i2, int i3, byte[] bArr, int i4, int i5, zzn zzn) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = bArr;
        this.zzf = i4;
        this.zzg = i5;
    }

    public static int zza(int i) {
        if (i == 1) {
            return 1;
        }
        if (i == 9) {
            return 6;
        }
        if (i == 4 || i == 5 || i == 6 || i == 7) {
            return 2;
        }
        return -1;
    }

    public static int zzb(int i) {
        if (i == 1) {
            return 3;
        }
        if (i == 4) {
            return 10;
        }
        if (i == 13) {
            return 2;
        }
        if (i == 16) {
            return 6;
        }
        if (i == 18) {
            return 7;
        }
        if (i == 6 || i == 7) {
            return 3;
        }
        return -1;
    }

    public static boolean zzg(zzo zzo) {
        int i;
        int i2;
        int i3;
        int i4;
        if (zzo == null) {
            return true;
        }
        int i5 = zzo.zzb;
        if ((i5 == -1 || i5 == 1 || i5 == 2) && (((i = zzo.zzc) == -1 || i == 2) && (((i2 = zzo.zzd) == -1 || i2 == 3) && zzo.zze == null && (((i3 = zzo.zzg) == -1 || i3 == 8) && ((i4 = zzo.zzf) == -1 || i4 == 8))))) {
            return true;
        }
        return false;
    }

    private static String zzh(int i) {
        if (i == -1) {
            return "Unset color range";
        }
        if (i == 1) {
            return "Full range";
        }
        if (i != 2) {
            return lf.h("Undefined color range ", i);
        }
        return "Limited range";
    }

    private static String zzi(int i) {
        if (i == -1) {
            return "Unset color space";
        }
        if (i == 6) {
            return "BT2020";
        }
        if (i == 1) {
            return "BT709";
        }
        if (i != 2) {
            return lf.h("Undefined color space ", i);
        }
        return "BT601";
    }

    private static String zzj(int i) {
        if (i == -1) {
            return "Unset color transfer";
        }
        if (i == 10) {
            return "Gamma 2.2";
        }
        if (i == 1) {
            return "Linear";
        }
        if (i == 2) {
            return "sRGB";
        }
        if (i == 3) {
            return "SDR SMPTE 170M";
        }
        if (i == 6) {
            return "ST2084 PQ";
        }
        if (i != 7) {
            return lf.h("Undefined color transfer ", i);
        }
        return "HLG";
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzo.class == obj.getClass()) {
            zzo zzo = (zzo) obj;
            if (this.zzb == zzo.zzb && this.zzc == zzo.zzc && this.zzd == zzo.zzd && Arrays.equals(this.zze, zzo.zze) && this.zzf == zzo.zzf && this.zzg == zzo.zzg) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzh;
        if (i != 0) {
            return i;
        }
        int i2 = this.zzd;
        int hashCode = ((((Arrays.hashCode(this.zze) + ((((((this.zzb + 527) * 31) + this.zzc) * 31) + i2) * 31)) * 31) + this.zzf) * 31) + this.zzg;
        this.zzh = hashCode;
        return hashCode;
    }

    public final String toString() {
        String str;
        boolean z;
        int i = this.zzf;
        int i2 = this.zzd;
        int i3 = this.zzc;
        String zzi = zzi(this.zzb);
        String zzh2 = zzh(i3);
        String zzj = zzj(i2);
        String str2 = "NA";
        if (i != -1) {
            str = i + "bit Luma";
        } else {
            str = str2;
        }
        int i4 = this.zzg;
        if (i4 != -1) {
            str2 = i4 + "bit Chroma";
        }
        if (this.zze != null) {
            z = true;
        } else {
            z = false;
        }
        StringBuilder b = C0437ME.b("ColorInfo(", zzi, ", ", zzh2, ", ");
        b.append(zzj);
        b.append(", ");
        b.append(z);
        b.append(", ");
        b.append(str);
        b.append(", ");
        b.append(str2);
        b.append(")");
        return b.toString();
    }

    public final zzm zzc() {
        return new zzm(this, (zzl) null);
    }

    public final String zzd() {
        String str;
        String str2;
        if (zzf()) {
            str = String.format(Locale.US, "%s/%s/%s", new Object[]{zzi(this.zzb), zzh(this.zzc), zzj(this.zzd)});
        } else {
            str = "NA/NA/NA";
        }
        if (zze()) {
            str2 = this.zzf + RemoteSettings.FORWARD_SLASH_STRING + this.zzg;
        } else {
            str2 = "NA/NA";
        }
        return xx.D(str, RemoteSettings.FORWARD_SLASH_STRING, str2);
    }

    public final boolean zze() {
        if (this.zzf == -1 || this.zzg == -1) {
            return false;
        }
        return true;
    }

    public final boolean zzf() {
        if (this.zzb == -1 || this.zzc == -1 || this.zzd == -1) {
            return false;
        }
        return true;
    }
}
