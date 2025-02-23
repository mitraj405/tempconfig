package com.google.android.gms.internal.ads;

import android.util.Base64;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzadv {
    public static int zza(int i) {
        int i2 = 0;
        while (i > 0) {
            i >>>= 1;
            i2++;
        }
        return i2;
    }

    public static zzbk zzb(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str = (String) list.get(i);
            int i2 = zzet.zza;
            String[] split = str.split("=", 2);
            if (split.length != 2) {
                zzea.zzf("VorbisUtil", "Failed to parse Vorbis comment: ".concat(str));
            } else if (split[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(zzafj.zzb(new zzek(Base64.decode(split[1], 0))));
                } catch (RuntimeException e) {
                    zzea.zzg("VorbisUtil", "Failed to parse vorbis picture", e);
                }
            } else {
                arrayList.add(new zzaha(split[0], split[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzbk((List) arrayList);
    }

    public static zzads zzc(zzek zzek, boolean z, boolean z2) throws zzbo {
        if (z) {
            zzd(3, zzek, false);
        }
        String zzA = zzek.zzA((int) zzek.zzs(), zzfuj.zzc);
        int length = zzA.length();
        long zzs = zzek.zzs();
        String[] strArr = new String[((int) zzs)];
        int i = length + 15;
        for (int i2 = 0; ((long) i2) < zzs; i2++) {
            String zzA2 = zzek.zzA((int) zzek.zzs(), zzfuj.zzc);
            strArr[i2] = zzA2;
            i = i + 4 + zzA2.length();
        }
        if (!z2 || (zzek.zzm() & 1) != 0) {
            return new zzads(zzA, strArr, i + 1);
        }
        throw zzbo.zza("framing bit expected to be set", (Throwable) null);
    }

    public static boolean zzd(int i, zzek zzek, boolean z) throws zzbo {
        if (zzek.zzb() < 7) {
            if (z) {
                return false;
            }
            int zzb = zzek.zzb();
            throw zzbo.zza("too short header: " + zzb, (Throwable) null);
        } else if (zzek.zzm() != i) {
            if (z) {
                return false;
            }
            throw zzbo.zza("expected header type ".concat(String.valueOf(Integer.toHexString(i))), (Throwable) null);
        } else if (zzek.zzm() == 118 && zzek.zzm() == 111 && zzek.zzm() == 114 && zzek.zzm() == 98 && zzek.zzm() == 105 && zzek.zzm() == 115) {
            return true;
        } else {
            if (z) {
                return false;
            }
            throw zzbo.zza("expected characters 'vorbis'", (Throwable) null);
        }
    }
}
