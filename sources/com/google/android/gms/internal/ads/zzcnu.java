package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcnu implements zzcwq, zzcye, zzcxk, zza, zzcxg, zzdeh {
    /* access modifiers changed from: private */
    public final Context zza;
    private final Executor zzb;
    private final Executor zzc;
    private final ScheduledExecutorService zzd;
    /* access modifiers changed from: private */
    public final zzfex zze;
    /* access modifiers changed from: private */
    public final zzfel zzf;
    /* access modifiers changed from: private */
    public final zzflh zzg;
    /* access modifiers changed from: private */
    public final zzffs zzh;
    private final zzauo zzi;
    private final zzbcz zzj;
    private final WeakReference zzk;
    private final WeakReference zzl;
    private final zzcvs zzm;
    private boolean zzn;
    private final AtomicBoolean zzo = new AtomicBoolean();

    public zzcnu(Context context, Executor executor, Executor executor2, ScheduledExecutorService scheduledExecutorService, zzfex zzfex, zzfel zzfel, zzflh zzflh, zzffs zzffs, View view, zzcej zzcej, zzauo zzauo, zzbcz zzbcz, zzbdb zzbdb, zzfkf zzfkf, zzcvs zzcvs) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = executor2;
        this.zzd = scheduledExecutorService;
        this.zze = zzfex;
        this.zzf = zzfel;
        this.zzg = zzflh;
        this.zzh = zzffs;
        this.zzi = zzauo;
        this.zzk = new WeakReference(view);
        this.zzl = new WeakReference(zzcej);
        this.zzj = zzbcz;
        this.zzm = zzcvs;
    }

    /* access modifiers changed from: private */
    public final List zzu() {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzkx)).booleanValue()) {
            zzu.zzp();
            if (zzt.zzB(this.zza)) {
                zzu.zzp();
                Integer zzs = zzt.zzs(this.zza);
                if (zzs != null) {
                    Integer valueOf = Integer.valueOf(Math.min(zzs.intValue(), 20));
                    ArrayList arrayList = new ArrayList();
                    for (String parse : this.zzf.zzd) {
                        arrayList.add(Uri.parse(parse).buildUpon().appendQueryParameter("dspct", Integer.toString(valueOf.intValue())).toString());
                    }
                    return arrayList;
                }
            }
        }
        return this.zzf.zzd;
    }

    /* access modifiers changed from: private */
    public final void zzv() {
        String str;
        int i;
        List list = this.zzf.zzd;
        if (list != null && !list.isEmpty()) {
            if (((Boolean) zzba.zzc().zza(zzbbw.zzdf)).booleanValue()) {
                str = this.zzi.zzc().zzh(this.zza, (View) this.zzk.get(), (Activity) null);
            } else {
                str = null;
            }
            if ((!((Boolean) zzba.zzc().zza(zzbbw.zzai)).booleanValue() || !this.zze.zzb.zzb.zzh) && ((Boolean) zzbdr.zzh.zze()).booleanValue()) {
                if (((Boolean) zzbdr.zzg.zze()).booleanValue() && ((i = this.zzf.zzb) == 1 || i == 2 || i == 5)) {
                    zzcej zzcej = (zzcej) this.zzl.get();
                }
                zzgcj.zzr((zzgca) zzgcj.zzo(zzgca.zzu(zzgcj.zzh((Object) null)), ((Long) zzba.zzc().zza(zzbbw.zzaM)).longValue(), TimeUnit.MILLISECONDS, this.zzd), new zzcnt(this, str), this.zzb);
                return;
            }
            this.zzh.zza(this.zzg.zzd(this.zze, this.zzf, false, str, (String) null, zzu()));
        }
    }

    private final void zzw(int i, int i2) {
        View view;
        if (i <= 0 || !((view = (View) this.zzk.get()) == null || view.getHeight() == 0 || view.getWidth() == 0)) {
            zzv();
        } else {
            this.zzd.schedule(new zzcnr(this, i, i2), (long) i2, TimeUnit.MILLISECONDS);
        }
    }

    public final void onAdClicked() {
        if ((!((Boolean) zzba.zzc().zza(zzbbw.zzai)).booleanValue() || !this.zze.zzb.zzb.zzh) && ((Boolean) zzbdr.zzd.zze()).booleanValue()) {
            zzgcj.zzr(zzgcj.zze(zzgca.zzu(this.zzj.zza()), Throwable.class, new zzcno(), zzbzo.zzf), new zzcns(this), this.zzb);
            return;
        }
        zzffs zzffs = this.zzh;
        zzflh zzflh = this.zzg;
        zzfex zzfex = this.zze;
        zzfel zzfel = this.zzf;
        Context context = this.zza;
        List zzc2 = zzflh.zzc(zzfex, zzfel, zzfel.zzc);
        int i = 1;
        if (true == zzu.zzo().zzA(context)) {
            i = 2;
        }
        zzffs.zzc(zzc2, i);
    }

    public final void zzds(zzbvn zzbvn, String str, String str2) {
        zzflh zzflh = this.zzg;
        zzfel zzfel = this.zzf;
        this.zzh.zza(zzflh.zze(zzfel, zzfel.zzh, zzbvn));
    }

    public final void zze() {
        zzflh zzflh = this.zzg;
        zzfex zzfex = this.zze;
        zzfel zzfel = this.zzf;
        this.zzh.zza(zzflh.zzc(zzfex, zzfel, zzfel.zzi));
    }

    public final void zzf() {
        zzflh zzflh = this.zzg;
        zzfex zzfex = this.zze;
        zzfel zzfel = this.zzf;
        this.zzh.zza(zzflh.zzc(zzfex, zzfel, zzfel.zzg));
    }

    public final /* synthetic */ void zzn() {
        this.zzb.execute(new zzcnq(this));
    }

    public final /* synthetic */ void zzo(int i, int i2) {
        zzw(i - 1, i2);
    }

    public final /* synthetic */ void zzp(int i, int i2) {
        this.zzb.execute(new zzcnp(this, i, i2));
    }

    public final void zzq(zze zze2) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzbl)).booleanValue()) {
            this.zzh.zza(this.zzg.zzc(this.zze, this.zzf, zzflh.zzf(2, zze2.zza, this.zzf.zzo)));
        }
    }

    public final void zzr() {
        if (this.zzo.compareAndSet(false, true)) {
            int intValue = ((Integer) zzba.zzc().zza(zzbbw.zzdo)).intValue();
            if (intValue > 0) {
                zzw(intValue, ((Integer) zzba.zzc().zza(zzbbw.zzdp)).intValue());
                return;
            }
            if (((Boolean) zzba.zzc().zza(zzbbw.zzdn)).booleanValue()) {
                this.zzc.execute(new zzcnn(this));
            } else {
                zzv();
            }
        }
    }

    public final synchronized void zzs() {
        zzcvs zzcvs;
        if (this.zzn) {
            ArrayList arrayList = new ArrayList(zzu());
            arrayList.addAll(this.zzf.zzf);
            this.zzh.zza(this.zzg.zzd(this.zze, this.zzf, true, (String) null, (String) null, arrayList));
        } else {
            zzffs zzffs = this.zzh;
            zzflh zzflh = this.zzg;
            zzfex zzfex = this.zze;
            zzfel zzfel = this.zzf;
            zzffs.zza(zzflh.zzc(zzfex, zzfel, zzfel.zzm));
            if (((Boolean) zzba.zzc().zza(zzbbw.zzdk)).booleanValue() && (zzcvs = this.zzm) != null) {
                List zzh2 = zzflh.zzh(zzflh.zzg(zzcvs.zzb().zzm, zzcvs.zza().zzg()), this.zzm.zza().zza());
                zzffs zzffs2 = this.zzh;
                zzflh zzflh2 = this.zzg;
                zzcvs zzcvs2 = this.zzm;
                zzffs2.zza(zzflh2.zzc(zzcvs2.zzc(), zzcvs2.zzb(), zzh2));
            }
            zzffs zzffs3 = this.zzh;
            zzflh zzflh3 = this.zzg;
            zzfex zzfex2 = this.zze;
            zzfel zzfel2 = this.zzf;
            zzffs3.zza(zzflh3.zzc(zzfex2, zzfel2, zzfel2.zzf));
        }
        this.zzn = true;
    }

    public final void zzt() {
        zzflh zzflh = this.zzg;
        zzfex zzfex = this.zze;
        zzfel zzfel = this.zzf;
        this.zzh.zza(zzflh.zzc(zzfex, zzfel, zzfel.zzau));
    }

    public final void zza() {
    }

    public final void zzb() {
    }

    public final void zzc() {
    }
}
