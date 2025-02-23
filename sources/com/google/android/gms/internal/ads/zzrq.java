package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Trace;
import android.view.Surface;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzrq implements zzsc {
    private final MediaCodec zza;
    private final zzrw zzb;
    private final zzsd zzc;
    private boolean zzd;
    private int zze = 0;

    public /* synthetic */ zzrq(MediaCodec mediaCodec, HandlerThread handlerThread, zzsd zzsd, zzrp zzrp) {
        this.zza = mediaCodec;
        this.zzb = new zzrw(handlerThread);
        this.zzc = zzsd;
    }

    public static /* bridge */ /* synthetic */ void zzh(zzrq zzrq, MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i) {
        zzrq.zzb.zzf(zzrq.zza);
        Trace.beginSection("configureCodec");
        zzrq.zza.configure(mediaFormat, surface, (MediaCrypto) null, i);
        Trace.endSection();
        zzrq.zzc.zzh();
        Trace.beginSection("startCodec");
        zzrq.zza.start();
        Trace.endSection();
        zzrq.zze = 1;
    }

    /* access modifiers changed from: private */
    public static String zzs(int i, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i == 1) {
            sb.append("Audio");
        } else if (i == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i);
            sb.append(")");
        }
        return sb.toString();
    }

    public final int zza() {
        this.zzc.zzc();
        return this.zzb.zza();
    }

    public final int zzb(MediaCodec.BufferInfo bufferInfo) {
        this.zzc.zzc();
        return this.zzb.zzb(bufferInfo);
    }

    public final MediaFormat zzc() {
        return this.zzb.zzc();
    }

    public final ByteBuffer zzf(int i) {
        return this.zza.getInputBuffer(i);
    }

    public final ByteBuffer zzg(int i) {
        return this.zza.getOutputBuffer(i);
    }

    public final void zzi() {
        this.zzc.zzb();
        this.zza.flush();
        this.zzb.zze();
        this.zza.start();
    }

    public final void zzj(int i, int i2, int i3, long j, int i4) {
        this.zzc.zzd(i, 0, i3, j, i4);
    }

    public final void zzk(int i, int i2, zzha zzha, long j, int i3) {
        this.zzc.zze(i, 0, zzha, j, 0);
    }

    public final void zzl() {
        try {
            if (this.zze == 1) {
                this.zzc.zzg();
                this.zzb.zzh();
            }
            this.zze = 2;
            if (!this.zzd) {
                this.zza.release();
                this.zzd = true;
            }
        } catch (Throwable th) {
            if (!this.zzd) {
                this.zza.release();
                this.zzd = true;
            }
            throw th;
        }
    }

    public final void zzm(int i, long j) {
        this.zza.releaseOutputBuffer(i, j);
    }

    public final void zzn(int i, boolean z) {
        this.zza.releaseOutputBuffer(i, false);
    }

    public final void zzo(Surface surface) {
        this.zza.setOutputSurface(surface);
    }

    public final void zzp(Bundle bundle) {
        this.zzc.zzf(bundle);
    }

    public final void zzq(int i) {
        this.zza.setVideoScalingMode(i);
    }

    public final boolean zzr(zzsb zzsb) {
        this.zzb.zzg(zzsb);
        return true;
    }
}
