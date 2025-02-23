package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.internal.ads.zzauh;
import com.google.android.gms.internal.ads.zzauk;
import com.google.android.gms.internal.ads.zzaun;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzfoh;
import com.google.android.gms.internal.ads.zzfpj;
import com.google.android.gms.internal.ads.zzfqd;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzj implements Runnable, zzauk {
    protected boolean zza;
    final CountDownLatch zzb = new CountDownLatch(1);
    private final List zzc = new Vector();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final boolean zzf;
    private final boolean zzg;
    private final Executor zzh;
    /* access modifiers changed from: private */
    public final zzfoh zzi;
    private Context zzj;
    private final Context zzk;
    private VersionInfoParcel zzl;
    private final VersionInfoParcel zzm;
    private final boolean zzn;
    private int zzo;

    public zzj(Context context, VersionInfoParcel versionInfoParcel) {
        this.zzj = context;
        this.zzk = context;
        this.zzl = versionInfoParcel;
        this.zzm = versionInfoParcel;
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        this.zzh = newCachedThreadPool;
        boolean booleanValue = ((Boolean) zzba.zzc().zza(zzbbw.zzce)).booleanValue();
        this.zzn = booleanValue;
        this.zzi = zzfoh.zza(context, newCachedThreadPool, booleanValue);
        this.zzf = ((Boolean) zzba.zzc().zza(zzbbw.zzcb)).booleanValue();
        this.zzg = ((Boolean) zzba.zzc().zza(zzbbw.zzcf)).booleanValue();
        if (((Boolean) zzba.zzc().zza(zzbbw.zzcd)).booleanValue()) {
            this.zzo = 2;
        } else {
            this.zzo = 1;
        }
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzdc)).booleanValue()) {
            this.zza = zzc();
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zzcW)).booleanValue()) {
            zzbzo.zza.execute(this);
            return;
        }
        zzay.zzb();
        if (zzf.zzv()) {
            zzbzo.zza.execute(this);
        } else {
            run();
        }
    }

    private final zzauk zzm() {
        if (zzi() == 2) {
            return (zzauk) this.zze.get();
        }
        return (zzauk) this.zzd.get();
    }

    private final void zzp() {
        List list = this.zzc;
        zzauk zzm2 = zzm();
        if (!list.isEmpty() && zzm2 != null) {
            for (Object[] objArr : this.zzc) {
                int length = objArr.length;
                if (length == 1) {
                    zzm2.zzk((MotionEvent) objArr[0]);
                } else if (length == 3) {
                    zzm2.zzl(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                }
            }
            this.zzc.clear();
        }
    }

    private final void zzq(boolean z) {
        this.zzd.set(zzaun.zzu(this.zzl.afmaVersion, zzr(this.zzj), z, this.zzo));
    }

    private static final Context zzr(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            return context;
        }
        return applicationContext;
    }

    public final void run() {
        boolean z;
        long currentTimeMillis;
        try {
            if (((Boolean) zzba.zzc().zza(zzbbw.zzdc)).booleanValue()) {
                this.zza = zzc();
            }
            boolean z2 = this.zzl.isClientJar;
            z = false;
            if (!((Boolean) zzba.zzc().zza(zzbbw.zzaN)).booleanValue() && z2) {
                z = true;
            }
            if (zzi() == 1) {
                zzq(z);
                if (this.zzo == 2) {
                    this.zzh.execute(new zzh(this, z));
                }
            } else {
                currentTimeMillis = System.currentTimeMillis();
                zzauh zza2 = zzauh.zza(this.zzl.afmaVersion, zzr(this.zzj), z, this.zzn);
                this.zze.set(zza2);
                if (this.zzg && !zza2.zzr()) {
                    this.zzo = 1;
                    zzq(z);
                }
            }
        } catch (NullPointerException e) {
            this.zzo = 1;
            zzq(z);
            this.zzi.zzc(2031, System.currentTimeMillis() - currentTimeMillis, e);
        } catch (Throwable th) {
            this.zzb.countDown();
            this.zzj = null;
            this.zzl = null;
            throw th;
        }
        this.zzb.countDown();
        this.zzj = null;
        this.zzl = null;
    }

    public final /* synthetic */ void zzb(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            zzauh.zza(this.zzm.afmaVersion, zzr(this.zzk), z, this.zzn).zzp();
        } catch (NullPointerException e) {
            this.zzi.zzc(2027, System.currentTimeMillis() - currentTimeMillis, e);
        }
    }

    public final boolean zzc() {
        Context context = this.zzj;
        zzi zzi2 = new zzi(this);
        zzfoh zzfoh = this.zzi;
        return new zzfqd(this.zzj, zzfpj.zzb(context, zzfoh), zzi2, ((Boolean) zzba.zzc().zza(zzbbw.zzcc)).booleanValue()).zzd(1);
    }

    public final boolean zzd() {
        try {
            this.zzb.await();
            return true;
        } catch (InterruptedException e) {
            zzm.zzk("Interrupted during GADSignals creation.", e);
            return false;
        }
    }

    public final String zze(Context context, String str, View view) {
        return zzf(context, str, view, (Activity) null);
    }

    public final String zzf(Context context, String str, View view, Activity activity) {
        if (!zzd()) {
            return "";
        }
        zzauk zzm2 = zzm();
        if (((Boolean) zzba.zzc().zza(zzbbw.zzjM)).booleanValue()) {
            zzu.zzp();
            zzt.zzJ(view, 4, (MotionEvent) null);
        }
        if (zzm2 == null) {
            return "";
        }
        zzp();
        return zzm2.zzf(zzr(context), str, view, activity);
    }

    public final String zzg(Context context) {
        zzauk zzm2;
        if (!zzd() || (zzm2 = zzm()) == null) {
            return "";
        }
        zzp();
        return zzm2.zzg(zzr(context));
    }

    public final String zzh(Context context, View view, Activity activity) {
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzjL)).booleanValue()) {
            zzauk zzm2 = zzm();
            if (((Boolean) zzba.zzc().zza(zzbbw.zzjM)).booleanValue()) {
                zzu.zzp();
                zzt.zzJ(view, 2, (MotionEvent) null);
            }
            if (zzm2 != null) {
                return zzm2.zzh(context, view, activity);
            }
            return "";
        } else if (!zzd()) {
            return "";
        } else {
            zzauk zzm3 = zzm();
            if (((Boolean) zzba.zzc().zza(zzbbw.zzjM)).booleanValue()) {
                zzu.zzp();
                zzt.zzJ(view, 2, (MotionEvent) null);
            }
            if (zzm3 != null) {
                return zzm3.zzh(context, view, activity);
            }
            return "";
        }
    }

    public final int zzi() {
        if (!this.zzf || this.zza) {
            return this.zzo;
        }
        return 1;
    }

    public final int zzj() {
        return this.zzo;
    }

    public final void zzk(MotionEvent motionEvent) {
        zzauk zzm2 = zzm();
        if (zzm2 != null) {
            zzp();
            zzm2.zzk(motionEvent);
            return;
        }
        this.zzc.add(new Object[]{motionEvent});
    }

    public final void zzl(int i, int i2, int i3) {
        zzauk zzm2 = zzm();
        if (zzm2 != null) {
            zzp();
            zzm2.zzl(i, i2, i3);
            return;
        }
        this.zzc.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzauk zzm2;
        if (zzd() && (zzm2 = zzm()) != null) {
            zzm2.zzn(stackTraceElementArr);
        }
    }

    public final void zzo(View view) {
        zzauk zzm2 = zzm();
        if (zzm2 != null) {
            zzm2.zzo(view);
        }
    }
}
