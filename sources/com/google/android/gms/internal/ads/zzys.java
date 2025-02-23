package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

@SuppressLint({"HandlerLeak"})
/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzys extends Handler implements Runnable {
    final /* synthetic */ zzyx zza;
    private final zzyt zzb;
    private final long zzc;
    private zzyp zzd;
    private IOException zze;
    private int zzf;
    private Thread zzg;
    private boolean zzh;
    private volatile boolean zzi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzys(zzyx zzyx, Looper looper, zzyt zzyt, zzyp zzyp, int i, long j) {
        super(looper);
        this.zza = zzyx;
        this.zzb = zzyt;
        this.zzd = zzyp;
        this.zzc = j;
    }

    private final void zzd() {
        this.zze = null;
        zzyx zzyx = this.zza;
        ExecutorService zzd2 = zzyx.zzc;
        zzys zzc2 = zzyx.zzd;
        zzc2.getClass();
        zzd2.execute(zzc2);
    }

    public final void handleMessage(Message message) {
        long j;
        if (!this.zzi) {
            int i = message.what;
            if (i == 0) {
                zzd();
            } else if (i != 3) {
                this.zza.zzd = null;
                long j2 = this.zzc;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j3 = elapsedRealtime - j2;
                zzyp zzyp = this.zzd;
                zzyp.getClass();
                if (this.zzh) {
                    zzyp.zzJ(this.zzb, elapsedRealtime, j3, false);
                    return;
                }
                int i2 = message.what;
                if (i2 == 1) {
                    try {
                        zzyp.zzK(this.zzb, elapsedRealtime, j3);
                    } catch (RuntimeException e) {
                        zzea.zzd("LoadTask", "Unexpected exception handling load completed", e);
                        this.zza.zze = new zzyw(e);
                    }
                } else if (i2 == 2) {
                    IOException iOException = (IOException) message.obj;
                    this.zze = iOException;
                    int i3 = this.zzf + 1;
                    this.zzf = i3;
                    zzyr zzu = zzyp.zzu(this.zzb, elapsedRealtime, j3, iOException, i3);
                    if (zzu.zza == 3) {
                        this.zza.zze = this.zze;
                    } else if (zzu.zza != 2) {
                        if (zzu.zza == 1) {
                            this.zzf = 1;
                        }
                        if (zzu.zzb != -9223372036854775807L) {
                            j = zzu.zzb;
                        } else {
                            j = (long) Math.min((this.zzf - 1) * 1000, 5000);
                        }
                        zzc(j);
                    }
                }
            } else {
                throw ((Error) message.obj);
            }
        }
    }

    public final void run() {
        boolean z;
        try {
            synchronized (this) {
                z = !this.zzh;
                this.zzg = Thread.currentThread();
            }
            if (z) {
                Trace.beginSection("load:".concat(this.zzb.getClass().getSimpleName()));
                this.zzb.zzh();
                Trace.endSection();
            }
            synchronized (this) {
                this.zzg = null;
                Thread.interrupted();
            }
            if (!this.zzi) {
                sendEmptyMessage(1);
            }
        } catch (IOException e) {
            if (!this.zzi) {
                obtainMessage(2, e).sendToTarget();
            }
        } catch (Exception e2) {
            if (!this.zzi) {
                zzea.zzd("LoadTask", "Unexpected exception loading stream", e2);
                obtainMessage(2, new zzyw(e2)).sendToTarget();
            }
        } catch (OutOfMemoryError e3) {
            if (!this.zzi) {
                zzea.zzd("LoadTask", "OutOfMemory error loading stream", e3);
                obtainMessage(2, new zzyw(e3)).sendToTarget();
            }
        } catch (Error e4) {
            if (!this.zzi) {
                zzea.zzd("LoadTask", "Unexpected error loading stream", e4);
                obtainMessage(3, e4).sendToTarget();
            }
            throw e4;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public final void zza(boolean z) {
        this.zzi = z;
        this.zze = null;
        if (hasMessages(0)) {
            this.zzh = true;
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            synchronized (this) {
                this.zzh = true;
                this.zzb.zzg();
                Thread thread = this.zzg;
                if (thread != null) {
                    thread.interrupt();
                }
            }
        }
        if (z) {
            this.zza.zzd = null;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            zzyp zzyp = this.zzd;
            zzyp.getClass();
            zzyp.zzJ(this.zzb, elapsedRealtime, elapsedRealtime - this.zzc, true);
            this.zzd = null;
        }
    }

    public final void zzb(int i) throws IOException {
        IOException iOException = this.zze;
        if (iOException != null && this.zzf > i) {
            throw iOException;
        }
    }

    public final void zzc(long j) {
        boolean z;
        if (this.zza.zzd == null) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zzf(z);
        this.zza.zzd = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            zzd();
        }
    }
}
