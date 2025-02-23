package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcw implements zzct {
    private int zzb;
    private float zzc = 1.0f;
    private float zzd = 1.0f;
    private zzcr zze;
    private zzcr zzf;
    private zzcr zzg;
    private zzcr zzh;
    private boolean zzi;
    private zzcv zzj;
    private ByteBuffer zzk;
    private ShortBuffer zzl;
    private ByteBuffer zzm;
    private long zzn;
    private long zzo;
    private boolean zzp;

    public zzcw() {
        zzcr zzcr = zzcr.zza;
        this.zze = zzcr;
        this.zzf = zzcr;
        this.zzg = zzcr;
        this.zzh = zzcr;
        ByteBuffer byteBuffer = zzct.zza;
        this.zzk = byteBuffer;
        this.zzl = byteBuffer.asShortBuffer();
        this.zzm = byteBuffer;
        this.zzb = -1;
    }

    public final zzcr zza(zzcr zzcr) throws zzcs {
        if (zzcr.zzd == 2) {
            int i = this.zzb;
            if (i == -1) {
                i = zzcr.zzb;
            }
            this.zze = zzcr;
            zzcr zzcr2 = new zzcr(i, zzcr.zzc, 2);
            this.zzf = zzcr2;
            this.zzi = true;
            return zzcr2;
        }
        throw new zzcs("Unhandled input format:", zzcr);
    }

    public final ByteBuffer zzb() {
        int zza;
        zzcv zzcv = this.zzj;
        if (zzcv != null && (zza = zzcv.zza()) > 0) {
            if (this.zzk.capacity() < zza) {
                ByteBuffer order = ByteBuffer.allocateDirect(zza).order(ByteOrder.nativeOrder());
                this.zzk = order;
                this.zzl = order.asShortBuffer();
            } else {
                this.zzk.clear();
                this.zzl.clear();
            }
            zzcv.zzd(this.zzl);
            this.zzo += (long) zza;
            this.zzk.limit(zza);
            this.zzm = this.zzk;
        }
        ByteBuffer byteBuffer = this.zzm;
        this.zzm = zzct.zza;
        return byteBuffer;
    }

    public final void zzc() {
        if (zzg()) {
            zzcr zzcr = this.zze;
            this.zzg = zzcr;
            zzcr zzcr2 = this.zzf;
            this.zzh = zzcr2;
            if (this.zzi) {
                this.zzj = new zzcv(zzcr.zzb, zzcr.zzc, this.zzc, this.zzd, zzcr2.zzb);
            } else {
                zzcv zzcv = this.zzj;
                if (zzcv != null) {
                    zzcv.zzc();
                }
            }
        }
        this.zzm = zzct.zza;
        this.zzn = 0;
        this.zzo = 0;
        this.zzp = false;
    }

    public final void zzd() {
        zzcv zzcv = this.zzj;
        if (zzcv != null) {
            zzcv.zze();
        }
        this.zzp = true;
    }

    public final void zze(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            zzcv zzcv = this.zzj;
            zzcv.getClass();
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.zzn += (long) remaining;
            zzcv.zzf(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
    }

    public final void zzf() {
        this.zzc = 1.0f;
        this.zzd = 1.0f;
        zzcr zzcr = zzcr.zza;
        this.zze = zzcr;
        this.zzf = zzcr;
        this.zzg = zzcr;
        this.zzh = zzcr;
        ByteBuffer byteBuffer = zzct.zza;
        this.zzk = byteBuffer;
        this.zzl = byteBuffer.asShortBuffer();
        this.zzm = byteBuffer;
        this.zzb = -1;
        this.zzi = false;
        this.zzj = null;
        this.zzn = 0;
        this.zzo = 0;
        this.zzp = false;
    }

    public final boolean zzg() {
        if (this.zzf.zzb == -1) {
            return false;
        }
        if (Math.abs(this.zzc - 4.0f) >= 1.0E-4f || Math.abs(this.zzd - 4.0f) >= 1.0E-4f) {
            return true;
        }
        if (this.zzf.zzb == this.zze.zzb) {
            return false;
        }
        return true;
    }

    public final boolean zzh() {
        if (!this.zzp) {
            return false;
        }
        zzcv zzcv = this.zzj;
        if (zzcv == null) {
            return true;
        }
        if (zzcv.zza() != 0) {
            return false;
        }
        return true;
    }

    public final long zzi(long j) {
        long j2 = this.zzo;
        if (j2 < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            return (long) (((double) this.zzc) * ((double) j));
        }
        long j3 = this.zzn;
        zzcv zzcv = this.zzj;
        zzcv.getClass();
        long zzb2 = j3 - ((long) zzcv.zzb());
        int i = this.zzh.zzb;
        int i2 = this.zzg.zzb;
        if (i == i2) {
            return zzet.zzt(j, zzb2, j2, RoundingMode.FLOOR);
        }
        return zzet.zzt(j, zzb2 * ((long) i), j2 * ((long) i2), RoundingMode.FLOOR);
    }

    public final void zzj(float f) {
        if (this.zzd != f) {
            this.zzd = f;
            this.zzi = true;
        }
    }

    public final void zzk(float f) {
        if (this.zzc != f) {
            this.zzc = f;
            this.zzi = true;
        }
    }
}
