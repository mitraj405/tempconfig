package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzqc {
    public final zzaf zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final zzcq zzi;
    public final boolean zzj = false;
    public final boolean zzk = false;
    public final boolean zzl = false;

    public zzqc(zzaf zzaf, int i, int i2, int i3, int i4, int i5, int i6, int i7, zzcq zzcq, boolean z, boolean z2, boolean z3) {
        this.zza = zzaf;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = i5;
        this.zzg = i6;
        this.zzh = i7;
        this.zzi = zzcq;
    }

    public final AudioTrack zza(zzh zzh2, int i) throws zzph {
        AudioTrack audioTrack;
        boolean z;
        try {
            if (zzet.zza >= 29) {
                AudioTrack.Builder sessionId = new AudioTrack.Builder().setAudioAttributes(zzh2.zza().zza).setAudioFormat(zzet.zzw(this.zze, this.zzf, this.zzg)).setTransferMode(1).setBufferSizeInBytes(this.zzh).setSessionId(i);
                if (this.zzc == 1) {
                    z = true;
                } else {
                    z = false;
                }
                audioTrack = sessionId.setOffloadedPlayback(z).build();
            } else {
                audioTrack = new AudioTrack(zzh2.zza().zza, zzet.zzw(this.zze, this.zzf, this.zzg), this.zzh, 1, i);
            }
            int state = audioTrack.getState();
            if (state == 1) {
                return audioTrack;
            }
            try {
                audioTrack.release();
            } catch (Exception unused) {
            }
            throw new zzph(state, this.zze, this.zzf, this.zzh, this.zza, zzc(), (Exception) null);
        } catch (IllegalArgumentException | UnsupportedOperationException e) {
            throw new zzph(0, this.zze, this.zzf, this.zzh, this.zza, zzc(), e);
        }
    }

    public final zzpf zzb() {
        boolean z;
        if (this.zzc == 1) {
            z = true;
        } else {
            z = false;
        }
        return new zzpf(this.zzg, this.zze, this.zzf, false, z, this.zzh);
    }

    public final boolean zzc() {
        if (this.zzc == 1) {
            return true;
        }
        return false;
    }
}
