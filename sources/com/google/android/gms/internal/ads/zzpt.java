package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzpt {
    private final Context zza;
    private Boolean zzb;

    public zzpt() {
        this.zza = null;
    }

    public final zzoq zza(zzaf zzaf, zzh zzh) {
        boolean z;
        zzaf.getClass();
        zzh.getClass();
        int i = zzet.zza;
        if (i < 29 || zzaf.zzA == -1) {
            return zzoq.zza;
        }
        Context context = this.zza;
        Boolean bool = this.zzb;
        if (bool != null) {
            z = bool.booleanValue();
        } else {
            if (context != null) {
                AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                if (audioManager != null) {
                    String parameters = audioManager.getParameters("offloadVariableRateSupported");
                    boolean z2 = false;
                    if (parameters != null && parameters.equals("offloadVariableRateSupported=1")) {
                        z2 = true;
                    }
                    this.zzb = Boolean.valueOf(z2);
                } else {
                    this.zzb = Boolean.FALSE;
                }
            } else {
                this.zzb = Boolean.FALSE;
            }
            z = this.zzb.booleanValue();
        }
        String str = zzaf.zzm;
        str.getClass();
        int zza2 = zzbn.zza(str, zzaf.zzj);
        if (zza2 == 0 || i < zzet.zzg(zza2)) {
            return zzoq.zza;
        }
        int zzh2 = zzet.zzh(zzaf.zzz);
        if (zzh2 == 0) {
            return zzoq.zza;
        }
        try {
            AudioFormat zzw = zzet.zzw(zzaf.zzA, zzh2, zza2);
            if (i >= 31) {
                return zzps.zza(zzw, zzh.zza().zza, z);
            }
            return zzpr.zza(zzw, zzh.zza().zza, z);
        } catch (IllegalArgumentException unused) {
            return zzoq.zza;
        }
    }

    public zzpt(Context context) {
        this.zza = context;
    }
}
