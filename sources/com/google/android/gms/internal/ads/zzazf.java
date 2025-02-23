package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.PriorityQueue;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzazf {
    public static long zza(long j, int i) {
        if (i == 1) {
            return j;
        }
        int i2 = i >> 1;
        long j2 = (j * j) % 1073807359;
        if ((i & 1) == 0) {
            return zza(j2, i2) % 1073807359;
        }
        return ((zza(j2, i2) % 1073807359) * j) % 1073807359;
    }

    public static String zzb(String[] strArr, int i, int i2) {
        int i3 = i2 + i;
        if (strArr.length < i3) {
            zzm.zzg("Unable to construct shingle");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i4 = i3 - 1;
            if (i < i4) {
                sb.append(strArr[i]);
                sb.append(' ');
                i++;
            } else {
                sb.append(strArr[i4]);
                return sb.toString();
            }
        }
    }

    public static void zzc(String[] strArr, int i, int i2, PriorityQueue priorityQueue) {
        String[] strArr2 = strArr;
        int length = strArr2.length;
        if (length < 6) {
            zzd(i, zze(strArr2, 0, length), zzb(strArr2, 0, length), length, priorityQueue);
            return;
        }
        long zze = zze(strArr2, 0, 6);
        zzd(i, zze, zzb(strArr2, 0, 6), 6, priorityQueue);
        int i3 = 1;
        while (true) {
            int length2 = strArr2.length;
            if (i3 < length2 - 5) {
                String zzb = zzb(strArr2, i3, 6);
                long zza = (((long) zzazb.zza(strArr2[i3 + 5])) + 2147483647L) % 1073807359;
                zze = (zza + (((((zze + 1073807359) - ((((((long) zzazb.zza(strArr2[i3 - 1])) + 2147483647L) % 1073807359) * zza(16785407, 5)) % 1073807359)) % 1073807359) * 16785407) % 1073807359)) % 1073807359;
                zzd(i, zze, zzb, length2, priorityQueue);
                i3++;
            } else {
                return;
            }
        }
    }

    public static void zzd(int i, long j, String str, int i2, PriorityQueue priorityQueue) {
        zzaze zzaze = new zzaze(j, str, i2);
        if ((priorityQueue.size() != i || (((zzaze) priorityQueue.peek()).zzc <= zzaze.zzc && ((zzaze) priorityQueue.peek()).zza <= zzaze.zza)) && !priorityQueue.contains(zzaze)) {
            priorityQueue.add(zzaze);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    private static long zze(String[] strArr, int i, int i2) {
        long zza = (((long) zzazb.zza(strArr[0])) + 2147483647L) % 1073807359;
        for (int i3 = 1; i3 < i2; i3++) {
            zza = (((((long) zzazb.zza(strArr[i3])) + 2147483647L) % 1073807359) + ((zza * 16785407) % 1073807359)) % 1073807359;
        }
        return zza;
    }
}
