package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.collection.CircularIntArray;
import java.util.ArrayDeque;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzrw extends MediaCodec.Callback {
    private final Object zza = new Object();
    private final HandlerThread zzb;
    private Handler zzc;
    private final CircularIntArray zzd;
    private final CircularIntArray zze;
    private final ArrayDeque zzf;
    private final ArrayDeque zzg;
    private MediaFormat zzh;
    private MediaFormat zzi;
    private MediaCodec.CodecException zzj;
    private MediaCodec.CryptoException zzk;
    private long zzl;
    private boolean zzm;
    private IllegalStateException zzn;
    private zzsb zzo;

    public zzrw(HandlerThread handlerThread) {
        this.zzb = handlerThread;
        this.zzd = new CircularIntArray();
        this.zze = new CircularIntArray();
        this.zzf = new ArrayDeque();
        this.zzg = new ArrayDeque();
    }

    public static /* synthetic */ void zzd(zzrw zzrw) {
        synchronized (zzrw.zza) {
            if (!zzrw.zzm) {
                long j = zzrw.zzl - 1;
                zzrw.zzl = j;
                int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i <= 0) {
                    if (i < 0) {
                        IllegalStateException illegalStateException = new IllegalStateException();
                        synchronized (zzrw.zza) {
                            zzrw.zzn = illegalStateException;
                        }
                        return;
                    }
                    zzrw.zzj();
                }
            }
        }
    }

    private final void zzi(MediaFormat mediaFormat) {
        this.zze.a(-2);
        this.zzg.add(mediaFormat);
    }

    private final void zzj() {
        if (!this.zzg.isEmpty()) {
            this.zzi = (MediaFormat) this.zzg.getLast();
        }
        CircularIntArray circularIntArray = this.zzd;
        circularIntArray.b = circularIntArray.a;
        CircularIntArray circularIntArray2 = this.zze;
        circularIntArray2.b = circularIntArray2.a;
        this.zzf.clear();
        this.zzg.clear();
    }

    private final void zzk() {
        IllegalStateException illegalStateException = this.zzn;
        if (illegalStateException == null) {
            MediaCodec.CodecException codecException = this.zzj;
            if (codecException == null) {
                MediaCodec.CryptoException cryptoException = this.zzk;
                if (cryptoException != null) {
                    this.zzk = null;
                    throw cryptoException;
                }
                return;
            }
            this.zzj = null;
            throw codecException;
        }
        this.zzn = null;
        throw illegalStateException;
    }

    private final boolean zzl() {
        if (this.zzl > 0 || this.zzm) {
            return true;
        }
        return false;
    }

    public final void onCryptoError(MediaCodec mediaCodec, MediaCodec.CryptoException cryptoException) {
        synchronized (this.zza) {
            this.zzk = cryptoException;
        }
    }

    public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.zza) {
            this.zzj = codecException;
        }
    }

    public final void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        synchronized (this.zza) {
            this.zzd.a(i);
            zzsb zzsb = this.zzo;
            if (zzsb != null) {
                zzso zzso = ((zzsm) zzsb).zza;
                if (zzso.zzo != null) {
                    zzso.zzo.zza();
                }
            }
        }
    }

    public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.zza) {
            MediaFormat mediaFormat = this.zzi;
            if (mediaFormat != null) {
                zzi(mediaFormat);
                this.zzi = null;
            }
            this.zze.a(i);
            this.zzf.add(bufferInfo);
            zzsb zzsb = this.zzo;
            if (zzsb != null) {
                zzso zzso = ((zzsm) zzsb).zza;
                if (zzso.zzo != null) {
                    zzso.zzo.zza();
                }
            }
        }
    }

    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.zza) {
            zzi(mediaFormat);
            this.zzi = null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.zza
            monitor-enter(r0)
            r7.zzk()     // Catch:{ all -> 0x0032 }
            boolean r1 = r7.zzl()     // Catch:{ all -> 0x0032 }
            r2 = -1
            if (r1 == 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return r2
        L_0x000f:
            androidx.collection.CircularIntArray r1 = r7.zzd     // Catch:{ all -> 0x0032 }
            int r3 = r1.a     // Catch:{ all -> 0x0032 }
            int r4 = r1.b     // Catch:{ all -> 0x0032 }
            r5 = 1
            if (r3 != r4) goto L_0x001a
            r6 = r5
            goto L_0x001b
        L_0x001a:
            r6 = 0
        L_0x001b:
            if (r6 == 0) goto L_0x001e
            goto L_0x002a
        L_0x001e:
            if (r3 == r4) goto L_0x002c
            int[] r2 = r1.f1323a     // Catch:{ all -> 0x0032 }
            r2 = r2[r3]     // Catch:{ all -> 0x0032 }
            int r3 = r3 + r5
            int r4 = r1.c     // Catch:{ all -> 0x0032 }
            r3 = r3 & r4
            r1.a = r3     // Catch:{ all -> 0x0032 }
        L_0x002a:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return r2
        L_0x002c:
            java.lang.ArrayIndexOutOfBoundsException r1 = new java.lang.ArrayIndexOutOfBoundsException     // Catch:{ all -> 0x0032 }
            r1.<init>()     // Catch:{ all -> 0x0032 }
            throw r1     // Catch:{ all -> 0x0032 }
        L_0x0032:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrw.zza():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(android.media.MediaCodec.BufferInfo r10) {
        /*
            r9 = this;
            java.lang.Object r0 = r9.zza
            monitor-enter(r0)
            r9.zzk()     // Catch:{ all -> 0x005d }
            boolean r1 = r9.zzl()     // Catch:{ all -> 0x005d }
            r2 = -1
            if (r1 == 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            return r2
        L_0x000f:
            androidx.collection.CircularIntArray r1 = r9.zze     // Catch:{ all -> 0x005d }
            int r3 = r1.a     // Catch:{ all -> 0x005d }
            int r4 = r1.b     // Catch:{ all -> 0x005d }
            r5 = 1
            if (r3 != r4) goto L_0x001a
            r6 = r5
            goto L_0x001b
        L_0x001a:
            r6 = 0
        L_0x001b:
            if (r6 == 0) goto L_0x001f
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            return r2
        L_0x001f:
            if (r3 == r4) goto L_0x0057
            int[] r2 = r1.f1323a     // Catch:{ all -> 0x005d }
            r2 = r2[r3]     // Catch:{ all -> 0x005d }
            int r3 = r3 + r5
            int r4 = r1.c     // Catch:{ all -> 0x005d }
            r3 = r3 & r4
            r1.a = r3     // Catch:{ all -> 0x005d }
            if (r2 < 0) goto L_0x0047
            android.media.MediaFormat r1 = r9.zzh     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzdi.zzb(r1)     // Catch:{ all -> 0x005d }
            java.util.ArrayDeque r1 = r9.zzf     // Catch:{ all -> 0x005d }
            java.lang.Object r1 = r1.remove()     // Catch:{ all -> 0x005d }
            android.media.MediaCodec$BufferInfo r1 = (android.media.MediaCodec.BufferInfo) r1     // Catch:{ all -> 0x005d }
            int r4 = r1.offset     // Catch:{ all -> 0x005d }
            int r5 = r1.size     // Catch:{ all -> 0x005d }
            long r6 = r1.presentationTimeUs     // Catch:{ all -> 0x005d }
            int r8 = r1.flags     // Catch:{ all -> 0x005d }
            r3 = r10
            r3.set(r4, r5, r6, r8)     // Catch:{ all -> 0x005d }
            goto L_0x0055
        L_0x0047:
            r10 = -2
            if (r2 != r10) goto L_0x0055
            java.util.ArrayDeque r1 = r9.zzg     // Catch:{ all -> 0x005d }
            java.lang.Object r1 = r1.remove()     // Catch:{ all -> 0x005d }
            android.media.MediaFormat r1 = (android.media.MediaFormat) r1     // Catch:{ all -> 0x005d }
            r9.zzh = r1     // Catch:{ all -> 0x005d }
            r2 = r10
        L_0x0055:
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            return r2
        L_0x0057:
            java.lang.ArrayIndexOutOfBoundsException r10 = new java.lang.ArrayIndexOutOfBoundsException     // Catch:{ all -> 0x005d }
            r10.<init>()     // Catch:{ all -> 0x005d }
            throw r10     // Catch:{ all -> 0x005d }
        L_0x005d:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrw.zzb(android.media.MediaCodec$BufferInfo):int");
    }

    public final MediaFormat zzc() {
        MediaFormat mediaFormat;
        synchronized (this.zza) {
            mediaFormat = this.zzh;
            if (mediaFormat == null) {
                throw new IllegalStateException();
            }
        }
        return mediaFormat;
    }

    public final void zze() {
        synchronized (this.zza) {
            this.zzl++;
            Handler handler = this.zzc;
            int i = zzet.zza;
            handler.post(new zzrv(this));
        }
    }

    public final void zzf(MediaCodec mediaCodec) {
        boolean z;
        if (this.zzc == null) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zzf(z);
        this.zzb.start();
        Handler handler = new Handler(this.zzb.getLooper());
        mediaCodec.setCallback(this, handler);
        this.zzc = handler;
    }

    public final void zzg(zzsb zzsb) {
        synchronized (this.zza) {
            this.zzo = zzsb;
        }
    }

    public final void zzh() {
        synchronized (this.zza) {
            this.zzm = true;
            this.zzb.quit();
            zzj();
        }
    }
}
