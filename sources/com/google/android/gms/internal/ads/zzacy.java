package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzacy {
    private static final Pattern zzc = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int zza = -1;
    public int zzb = -1;

    private final boolean zzc(String str) {
        Matcher matcher = zzc.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            String group = matcher.group(1);
            int i = zzet.zza;
            int parseInt = Integer.parseInt(group, 16);
            int parseInt2 = Integer.parseInt(matcher.group(2), 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.zza = parseInt;
            this.zzb = parseInt2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public final boolean zza() {
        if (this.zza == -1 || this.zzb == -1) {
            return false;
        }
        return true;
    }

    public final boolean zzb(zzbk zzbk) {
        for (int i = 0; i < zzbk.zza(); i++) {
            zzbj zzb2 = zzbk.zzb(i);
            if (zzb2 instanceof zzafx) {
                zzafx zzafx = (zzafx) zzb2;
                if ("iTunSMPB".equals(zzafx.zzb) && zzc(zzafx.zzc)) {
                    return true;
                }
            } else if (zzb2 instanceof zzagg) {
                zzagg zzagg = (zzagg) zzb2;
                if ("com.apple.iTunes".equals(zzagg.zza) && "iTunSMPB".equals(zzagg.zzb) && zzc(zzagg.zzc)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }
}
