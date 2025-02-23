package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaab extends HandlerThread implements Handler.Callback {
    private zzdp zza;
    private Handler zzb;
    private Error zzc;
    private RuntimeException zzd;
    private zzaad zze;

    public zzaab() {
        super("ExoPlayer:PlaceholderSurface");
    }

    public final boolean handleMessage(Message message) {
        boolean z;
        int i = message.what;
        if (i == 1) {
            try {
                int i2 = message.arg1;
                zzdp zzdp = this.zza;
                zzdp.getClass();
                zzdp.zzb(i2);
                SurfaceTexture zza2 = this.zza.zza();
                if (i2 != 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.zze = new zzaad(this, zza2, z, (zzaac) null);
                synchronized (this) {
                    notify();
                }
            } catch (RuntimeException e) {
                zzea.zzd("PlaceholderSurface", "Failed to initialize placeholder surface", e);
                this.zzd = e;
                synchronized (this) {
                    notify();
                }
            } catch (zzdq e2) {
                zzea.zzd("PlaceholderSurface", "Failed to initialize placeholder surface", e2);
                this.zzd = new IllegalStateException(e2);
                synchronized (this) {
                    notify();
                }
            } catch (Error e3) {
                try {
                    zzea.zzd("PlaceholderSurface", "Failed to initialize placeholder surface", e3);
                    this.zzc = e3;
                    synchronized (this) {
                        notify();
                    }
                } catch (Throwable th) {
                    synchronized (this) {
                        notify();
                        throw th;
                    }
                }
            }
        } else if (i == 2) {
            try {
                zzdp zzdp2 = this.zza;
                zzdp2.getClass();
                zzdp2.zzc();
            } catch (Throwable th2) {
                quit();
                throw th2;
            }
            quit();
            return true;
        }
        return true;
    }

    public final zzaad zza(int i) {
        boolean z;
        start();
        Handler handler = new Handler(getLooper(), this);
        this.zzb = handler;
        this.zza = new zzdp(handler, (zzdo) null);
        synchronized (this) {
            z = false;
            this.zzb.obtainMessage(1, i, 0).sendToTarget();
            while (this.zze == null && this.zzd == null && this.zzc == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = this.zzd;
        if (runtimeException == null) {
            Error error = this.zzc;
            if (error == null) {
                zzaad zzaad = this.zze;
                zzaad.getClass();
                return zzaad;
            }
            throw error;
        }
        throw runtimeException;
    }

    public final void zzb() {
        Handler handler = this.zzb;
        handler.getClass();
        handler.sendEmptyMessage(2);
    }
}
