package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzhl {
    private final AudioManager zza;
    private final zzhj zzb;
    private zzhk zzc;
    private int zzd;
    private float zze = 1.0f;

    public zzhl(Context context, Handler handler, zzhk zzhk) {
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
        audioManager.getClass();
        this.zza = audioManager;
        this.zzc = zzhk;
        this.zzb = new zzhj(this, handler);
        this.zzd = 0;
    }

    public static /* bridge */ /* synthetic */ void zzc(zzhl zzhl, int i) {
        if (i == -3 || i == -2) {
            if (i != -2) {
                zzhl.zzg(3);
                return;
            }
            zzhl.zzf(0);
            zzhl.zzg(2);
        } else if (i == -1) {
            zzhl.zzf(-1);
            zzhl.zze();
        } else if (i != 1) {
            C0709Uj.t("Unknown focus change type: ", i, "AudioFocusManager");
        } else {
            zzhl.zzg(1);
            zzhl.zzf(1);
        }
    }

    private final void zze() {
        if (this.zzd != 0) {
            if (zzet.zza < 26) {
                this.zza.abandonAudioFocus(this.zzb);
            }
            zzg(0);
        }
    }

    private final void zzf(int i) {
        zzhk zzhk = this.zzc;
        if (zzhk != null) {
            zzji zzji = (zzji) zzhk;
            boolean zzu = zzji.zza.zzu();
            zzji.zza.zzaf(zzu, i, zzjm.zzS(zzu, i));
        }
    }

    private final void zzg(int i) {
        float f;
        if (this.zzd != i) {
            this.zzd = i;
            if (i == 3) {
                f = 0.2f;
            } else {
                f = 1.0f;
            }
            if (this.zze != f) {
                this.zze = f;
                zzhk zzhk = this.zzc;
                if (zzhk != null) {
                    ((zzji) zzhk).zza.zzac();
                }
            }
        }
    }

    public final float zza() {
        return this.zze;
    }

    public final int zzb(boolean z, int i) {
        zze();
        if (z) {
            return 1;
        }
        return -1;
    }

    public final void zzd() {
        this.zzc = null;
        zze();
    }
}
