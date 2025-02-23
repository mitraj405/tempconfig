package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.net.Uri;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzom {
    /* access modifiers changed from: private */
    public final Context zza;
    private final Handler zzb;
    private final zzoi zzc;
    private final BroadcastReceiver zzd;
    private final zzoj zze;
    private zzof zzf;
    /* access modifiers changed from: private */
    public zzon zzg;
    /* access modifiers changed from: private */
    public zzh zzh;
    private boolean zzi;
    private final zzpx zzj;

    public zzom(Context context, zzpx zzpx, zzh zzh2, zzon zzon) {
        zzoi zzoi;
        Context applicationContext = context.getApplicationContext();
        this.zza = applicationContext;
        this.zzj = zzpx;
        this.zzh = zzh2;
        this.zzg = zzon;
        zzoj zzoj = null;
        Handler handler = new Handler(zzet.zzy(), (Handler.Callback) null);
        this.zzb = handler;
        if (zzet.zza >= 23) {
            zzoi = new zzoi(this, (zzoh) null);
        } else {
            zzoi = null;
        }
        this.zzc = zzoi;
        this.zzd = new zzol(this, (zzok) null);
        Uri zza2 = zzof.zza();
        this.zze = zza2 != null ? new zzoj(this, handler, applicationContext.getContentResolver(), zza2) : zzoj;
    }

    /* access modifiers changed from: private */
    public final void zzj(zzof zzof) {
        if (this.zzi && !zzof.equals(this.zzf)) {
            this.zzf = zzof;
            this.zzj.zza.zzI(zzof);
        }
    }

    public final zzof zzc() {
        zzoi zzoi;
        if (this.zzi) {
            zzof zzof = this.zzf;
            zzof.getClass();
            return zzof;
        }
        this.zzi = true;
        zzoj zzoj = this.zze;
        if (zzoj != null) {
            zzoj.zza();
        }
        if (zzet.zza >= 23 && (zzoi = this.zzc) != null) {
            zzog.zza(this.zza, zzoi, this.zzb);
        }
        Intent intent = null;
        if (this.zzd != null) {
            intent = this.zza.registerReceiver(this.zzd, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"), (String) null, this.zzb);
        }
        zzof zzd2 = zzof.zzd(this.zza, intent, this.zzh, this.zzg);
        this.zzf = zzd2;
        return zzd2;
    }

    public final void zzg(zzh zzh2) {
        this.zzh = zzh2;
        zzj(zzof.zzc(this.zza, zzh2, this.zzg));
    }

    public final void zzh(AudioDeviceInfo audioDeviceInfo) {
        AudioDeviceInfo audioDeviceInfo2;
        zzon zzon = this.zzg;
        zzon zzon2 = null;
        if (zzon == null) {
            audioDeviceInfo2 = null;
        } else {
            audioDeviceInfo2 = zzon.zza;
        }
        if (!zzet.zzG(audioDeviceInfo, audioDeviceInfo2)) {
            if (audioDeviceInfo != null) {
                zzon2 = new zzon(audioDeviceInfo);
            }
            this.zzg = zzon2;
            zzj(zzof.zzc(this.zza, this.zzh, zzon2));
        }
    }

    public final void zzi() {
        zzoi zzoi;
        if (this.zzi) {
            this.zzf = null;
            if (zzet.zza >= 23 && (zzoi = this.zzc) != null) {
                zzog.zzb(this.zza, zzoi);
            }
            BroadcastReceiver broadcastReceiver = this.zzd;
            if (broadcastReceiver != null) {
                this.zza.unregisterReceiver(broadcastReceiver);
            }
            zzoj zzoj = this.zze;
            if (zzoj != null) {
                zzoj.zzb();
            }
            this.zzi = false;
        }
    }
}
