package com.google.android.gms.internal.ads;

import android.graphics.Color;
import android.text.TextUtils;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaku {
    public final String zza;
    public final int zzb;
    public final Integer zzc;
    public final Integer zzd;
    public final float zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final int zzj;

    private zzaku(String str, int i, Integer num, Integer num2, float f, boolean z, boolean z2, boolean z3, boolean z4, int i2) {
        this.zza = str;
        this.zzb = i;
        this.zzc = num;
        this.zzd = num2;
        this.zze = f;
        this.zzf = z;
        this.zzg = z2;
        this.zzh = z3;
        this.zzi = z4;
        this.zzj = i2;
    }

    public static zzaku zzb(String str, zzaks zzaks) {
        int i;
        Integer num;
        Integer num2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i2;
        String str2 = str;
        zzaks zzaks2 = zzaks;
        zzdi.zzd(str2.startsWith("Style:"));
        String[] split = TextUtils.split(str2.substring(6), ",");
        int length = split.length;
        int i3 = zzaks2.zzk;
        if (length != i3) {
            zzea.zzf("SsaStyle", String.format(Locale.US, "Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", new Object[]{Integer.valueOf(i3), Integer.valueOf(length), str2}));
            return null;
        }
        try {
            String trim = split[zzaks2.zza].trim();
            int i4 = zzaks2.zzb;
            if (i4 != -1) {
                i = zzd(split[i4].trim());
            } else {
                i = -1;
            }
            int i5 = zzaks2.zzc;
            if (i5 != -1) {
                num = zzc(split[i5].trim());
            } else {
                num = null;
            }
            int i6 = zzaks2.zzd;
            if (i6 != -1) {
                num2 = zzc(split[i6].trim());
            } else {
                num2 = null;
            }
            int i7 = zzaks2.zze;
            float f = -3.4028235E38f;
            if (i7 != -1) {
                String trim2 = split[i7].trim();
                try {
                    f = Float.parseFloat(trim2);
                } catch (NumberFormatException e) {
                    zzea.zzg("SsaStyle", "Failed to parse font size: '" + trim2 + "'", e);
                }
            }
            int i8 = zzaks2.zzf;
            if (i8 == -1 || !zze(split[i8].trim())) {
                z = false;
            } else {
                z = true;
            }
            int i9 = zzaks2.zzg;
            if (i9 == -1 || !zze(split[i9].trim())) {
                z2 = false;
            } else {
                z2 = true;
            }
            int i10 = zzaks2.zzh;
            if (i10 == -1 || !zze(split[i10].trim())) {
                z3 = false;
            } else {
                z3 = true;
            }
            int i11 = zzaks2.zzi;
            if (i11 == -1 || !zze(split[i11].trim())) {
                z4 = false;
            } else {
                z4 = true;
            }
            int i12 = zzaks2.zzj;
            if (i12 != -1) {
                String trim3 = split[i12].trim();
                try {
                    int parseInt = Integer.parseInt(trim3.trim());
                    if (parseInt == 1 || parseInt == 3) {
                        i2 = parseInt;
                        return new zzaku(trim, i, num, num2, f, z, z2, z3, z4, i2);
                    }
                } catch (NumberFormatException unused) {
                }
                zzea.zzf("SsaStyle", "Ignoring unknown BorderStyle: ".concat(String.valueOf(trim3)));
            }
            i2 = -1;
            return new zzaku(trim, i, num, num2, f, z, z2, z3, z4, i2);
        } catch (RuntimeException e2) {
            zzea.zzg("SsaStyle", "Skipping malformed 'Style:' line: '" + str2 + "'", e2);
            return null;
        }
    }

    public static Integer zzc(String str) {
        long j;
        boolean z;
        try {
            if (str.startsWith("&H")) {
                j = Long.parseLong(str.substring(2), 16);
            } else {
                j = Long.parseLong(str);
            }
            if (j <= 4294967295L) {
                z = true;
            } else {
                z = false;
            }
            zzdi.zzd(z);
            int zzb2 = zzgap.zzb(((j >> 24) & 255) ^ 255);
            int zzb3 = zzgap.zzb((j >> 16) & 255);
            return Integer.valueOf(Color.argb(zzb2, zzgap.zzb(j & 255), zzgap.zzb((j >> 8) & 255), zzb3));
        } catch (IllegalArgumentException e) {
            zzea.zzg("SsaStyle", "Failed to parse color expression: '" + str + "'", e);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static int zzd(String str) {
        try {
            int parseInt = Integer.parseInt(str.trim());
            switch (parseInt) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    return parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        lf.w(str, "Ignoring unknown alignment: ", "SsaStyle");
        return -1;
    }

    private static boolean zze(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt == 1 || parseInt == -1) {
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            zzea.zzg("SsaStyle", "Failed to parse boolean value: '" + str + "'", e);
            return false;
        }
    }
}
