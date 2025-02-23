package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzfva extends zzfvf {
    final /* synthetic */ zzfvb zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfva(zzfvb zzfvb, zzfvh zzfvh, CharSequence charSequence) {
        super(zzfvh, charSequence);
        this.zza = zzfvb;
    }

    public final int zzc(int i) {
        return i + 1;
    }

    public final int zzd(int i) {
        CharSequence charSequence = this.zzb;
        int length = charSequence.length();
        zzfuu.zzb(i, length, FirebaseAnalytics.Param.INDEX);
        while (i < length) {
            zzfvb zzfvb = this.zza;
            if (zzfvb.zza.zzb(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
