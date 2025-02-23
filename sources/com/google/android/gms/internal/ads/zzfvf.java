package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
abstract class zzfvf extends zzfue {
    final CharSequence zzb;
    int zzc = 0;
    int zzd = Integer.MAX_VALUE;

    public zzfvf(zzfvh zzfvh, CharSequence charSequence) {
        this.zzb = charSequence;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        int i;
        int i2 = this.zzc;
        while (true) {
            int i3 = this.zzc;
            if (i3 != -1) {
                int zzd2 = zzd(i3);
                if (zzd2 == -1) {
                    zzd2 = this.zzb.length();
                    this.zzc = -1;
                    i = -1;
                } else {
                    i = zzc(zzd2);
                    this.zzc = i;
                }
                if (i == i2) {
                    int i4 = i + 1;
                    this.zzc = i4;
                    if (i4 > this.zzb.length()) {
                        this.zzc = -1;
                    }
                } else {
                    if (i2 < zzd2) {
                        this.zzb.charAt(i2);
                    }
                    if (i2 < zzd2) {
                        this.zzb.charAt(zzd2 - 1);
                    }
                    int i5 = this.zzd;
                    if (i5 == 1) {
                        zzd2 = this.zzb.length();
                        this.zzc = -1;
                        if (zzd2 > i2) {
                            this.zzb.charAt(zzd2 - 1);
                        }
                    } else {
                        this.zzd = i5 - 1;
                    }
                    return this.zzb.subSequence(i2, zzd2).toString();
                }
            } else {
                zzb();
                return null;
            }
        }
    }

    public abstract int zzc(int i);

    public abstract int zzd(int i);
}
