package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeps implements zzevo {
    private final zzgcu zza;
    private final Context zzb;

    public zzeps(zzgcu zzgcu, Context context) {
        this.zza = zzgcu;
        this.zzb = context;
    }

    public final int zza() {
        return 13;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzepr(this));
    }

    public final /* synthetic */ zzept zzc() throws Exception {
        int i;
        int i2;
        AudioManager audioManager = (AudioManager) this.zzb.getSystemService("audio");
        int mode = audioManager.getMode();
        boolean isMusicActive = audioManager.isMusicActive();
        boolean isSpeakerphoneOn = audioManager.isSpeakerphoneOn();
        int streamVolume = audioManager.getStreamVolume(3);
        if (((Boolean) zzba.zzc().zza(zzbbw.zzka)).booleanValue()) {
            i2 = zzu.zzq().zzj(audioManager);
            i = audioManager.getStreamMaxVolume(3);
        } else {
            i2 = -1;
            i = -1;
        }
        return new zzept(mode, isMusicActive, isSpeakerphoneOn, streamVolume, i2, i, audioManager.getRingerMode(), audioManager.getStreamVolume(2), zzu.zzr().zza(), zzu.zzr().zze());
    }
}
