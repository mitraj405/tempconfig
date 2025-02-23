package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzht implements zzkb {
    private final zzyk zza;
    private final long zzb = zzet.zzr(50000);
    private final long zzc = zzet.zzr(50000);
    private final long zzd = zzet.zzr(2500);
    private final long zze = zzet.zzr(5000);
    private final long zzf = zzet.zzr(0);
    private final HashMap zzg = new HashMap();
    private long zzh = -1;

    public zzht() {
        zzyk zzyk = new zzyk(true, 65536);
        zzk(2500, 0, "bufferForPlaybackMs", "0");
        zzk(5000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        zzk(50000, 2500, "minBufferMs", "bufferForPlaybackMs");
        zzk(50000, 5000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        zzk(50000, 50000, "maxBufferMs", "minBufferMs");
        zzk(0, 0, "backBufferDurationMs", "0");
        this.zza = zzyk;
    }

    private static void zzk(int i, int i2, String str, String str2) {
        boolean z;
        String D = xx.D(str, " cannot be less than ", str2);
        if (i >= i2) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zze(z, D);
    }

    private final void zzl(zznz zznz) {
        if (this.zzg.remove(zznz) != null) {
            zzm();
        }
    }

    private final void zzm() {
        if (this.zzg.isEmpty()) {
            this.zza.zze();
        } else {
            this.zza.zzf(zza());
        }
    }

    public final int zza() {
        int i = 0;
        for (zzhs zzhs : this.zzg.values()) {
            i += zzhs.zzb;
        }
        return i;
    }

    public final long zzb(zznz zznz) {
        return this.zzf;
    }

    public final void zzc(zznz zznz) {
        long id = Thread.currentThread().getId();
        long j = this.zzh;
        boolean z = true;
        if (!(j == -1 || j == id)) {
            z = false;
        }
        zzdi.zzg(z, "Players that share the same LoadControl must share the same playback thread. See ExoPlayer.Builder.setPlaybackLooper(Looper).");
        this.zzh = id;
        if (!this.zzg.containsKey(zznz)) {
            this.zzg.put(zznz, new zzhs((zzhr) null));
        }
        zzhs zzhs = (zzhs) this.zzg.get(zznz);
        zzhs.getClass();
        zzhs.zzb = 13107200;
        zzhs.zza = false;
    }

    public final void zzd(zznz zznz) {
        zzl(zznz);
        if (this.zzg.isEmpty()) {
            this.zzh = -1;
        }
    }

    public final void zze(zznz zznz) {
        zzl(zznz);
    }

    public final void zzf(zznz zznz, zzcc zzcc, zzui zzui, zzle[] zzleArr, zzwi zzwi, zzxv[] zzxvArr) {
        zzhs zzhs = (zzhs) this.zzg.get(zznz);
        zzhs.getClass();
        int i = 0;
        int i2 = 0;
        while (true) {
            int length = zzleArr.length;
            int i3 = 13107200;
            if (i < 2) {
                if (zzxvArr[i] != null) {
                    if (zzleArr[i].zzb() != 1) {
                        i3 = 131072000;
                    }
                    i2 += i3;
                }
                i++;
            } else {
                zzhs.zzb = Math.max(13107200, i2);
                zzm();
                return;
            }
        }
    }

    public final boolean zzg(zznz zznz) {
        return false;
    }

    public final boolean zzh(zzka zzka) {
        zzhs zzhs = (zzhs) this.zzg.get(zzka.zza);
        zzhs.getClass();
        int zza2 = this.zza.zza();
        int zza3 = zza();
        long j = this.zzb;
        float f = zzka.zzc;
        if (f > 1.0f) {
            j = Math.min(zzet.zzp(j, f), this.zzc);
        }
        long j2 = zzka.zzb;
        int i = (j2 > Math.max(j, 500000) ? 1 : (j2 == Math.max(j, 500000) ? 0 : -1));
        boolean z = false;
        if (i < 0) {
            if (zza2 < zza3) {
                z = true;
            }
            zzhs.zza = z;
            if (!z && j2 < 500000) {
                zzea.zzf("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j2 >= this.zzc || zza2 >= zza3) {
            zzhs.zza = false;
        }
        return zzhs.zza;
    }

    public final boolean zzi(zzka zzka) {
        long j;
        boolean z = zzka.zzd;
        long zzq = zzet.zzq(zzka.zzb, zzka.zzc);
        if (z) {
            j = this.zze;
        } else {
            j = this.zzd;
        }
        long j2 = zzka.zze;
        if (j2 != -9223372036854775807L) {
            j = Math.min(j2 / 2, j);
        }
        if (j <= 0 || zzq >= j || this.zza.zza() >= zza()) {
            return true;
        }
        return false;
    }

    public final zzyk zzj() {
        return this.zza;
    }
}
