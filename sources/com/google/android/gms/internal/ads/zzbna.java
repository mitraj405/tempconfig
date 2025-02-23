package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbd;
import com.google.android.gms.ads.internal.util.zzby;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzu;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbna {
    /* access modifiers changed from: private */
    public final Object zza = new Object();
    private final Context zzb;
    private final String zzc;
    private final VersionInfoParcel zzd;
    /* access modifiers changed from: private */
    public final zzfki zze;
    private final zzbd zzf;
    private final zzbd zzg;
    /* access modifiers changed from: private */
    public zzbmz zzh;
    /* access modifiers changed from: private */
    public int zzi = 1;

    public zzbna(Context context, VersionInfoParcel versionInfoParcel, String str, zzbd zzbd, zzbd zzbd2, zzfki zzfki) {
        this.zzc = str;
        this.zzb = context.getApplicationContext();
        this.zzd = versionInfoParcel;
        this.zze = zzfki;
        this.zzf = zzbd;
        this.zzg = zzbd2;
    }

    public final zzbmu zzb(zzauo zzauo) {
        zze.zza("getEngine: Trying to acquire lock");
        synchronized (this.zza) {
            zze.zza("getEngine: Lock acquired");
            zze.zza("refreshIfDestroyed: Trying to acquire lock");
            synchronized (this.zza) {
                zze.zza("refreshIfDestroyed: Lock acquired");
                zzbmz zzbmz = this.zzh;
                if (zzbmz != null && this.zzi == 0) {
                    zzbmz.zzj(new zzbmg(this), new zzbmh());
                }
            }
            zze.zza("refreshIfDestroyed: Lock released");
            zzbmz zzbmz2 = this.zzh;
            if (zzbmz2 != null) {
                if (zzbmz2.zze() != -1) {
                    int i = this.zzi;
                    if (i == 0) {
                        zze.zza("getEngine (NO_UPDATE): Lock released");
                        zzbmu zza2 = this.zzh.zza();
                        return zza2;
                    } else if (i == 1) {
                        this.zzi = 2;
                        zzd((zzauo) null);
                        zze.zza("getEngine (PENDING_UPDATE): Lock released");
                        zzbmu zza3 = this.zzh.zza();
                        return zza3;
                    } else {
                        zze.zza("getEngine (UPDATING): Lock released");
                        zzbmu zza4 = this.zzh.zza();
                        return zza4;
                    }
                }
            }
            this.zzi = 2;
            this.zzh = zzd((zzauo) null);
            zze.zza("getEngine (NULL or REJECTED): Lock released");
            zzbmu zza5 = this.zzh.zza();
            return zza5;
        }
    }

    public final zzbmz zzd(zzauo zzauo) {
        zzfju zza2 = zzfjt.zza(this.zzb, 6);
        zza2.zzi();
        zzbmz zzbmz = new zzbmz(this.zzg);
        zze.zza("loadJavascriptEngine > Before UI_THREAD_EXECUTOR");
        zzbzo.zze.execute(new zzbmk(this, (zzauo) null, zzbmz));
        zze.zza("loadNewJavascriptEngine: Promise created");
        zzbmz.zzj(new zzbmp(this, zzbmz, zza2), new zzbmq(this, zzbmz, zza2));
        return zzbmz;
    }

    public final /* synthetic */ void zzi(zzbmz zzbmz, zzblv zzblv, ArrayList arrayList, long j) {
        zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Trying to acquire lock");
        synchronized (this.zza) {
            zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock acquired");
            if (zzbmz.zze() != -1) {
                if (zzbmz.zze() != 1) {
                    if (((Boolean) zzba.zzc().zza(zzbbw.zzgS)).booleanValue()) {
                        zzbmz.zzh(new TimeoutException("Unable to receive /jsLoaded GMSG."), "SdkJavascriptFactory.loadJavascriptEngine.setLoadedListener");
                    } else {
                        zzbmz.zzg();
                    }
                    zzgcu zzgcu = zzbzo.zze;
                    Objects.requireNonNull(zzblv);
                    zzgcu.execute(new zzbmi(zzblv));
                    String valueOf = String.valueOf(zzba.zzc().zza(zzbbw.zzb));
                    int zze2 = zzbmz.zze();
                    int i = this.zzi;
                    String valueOf2 = String.valueOf(arrayList.get(0));
                    long currentTimeMillis = zzu.zzB().currentTimeMillis() - j;
                    zze.zza("Could not receive /jsLoaded in " + valueOf + " ms. JS engine session reference status(onEngLoadedTimeout) is " + zze2 + ". Update status(onEngLoadedTimeout) is " + i + ". LoadNewJavascriptEngine(onEngLoadedTimeout) latency is " + valueOf2 + " ms. Total latency(onEngLoadedTimeout) is " + currentTimeMillis + " ms. Rejecting.");
                    zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock released");
                    return;
                }
            }
            zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock released, the promise is already settled");
        }
    }

    public final /* synthetic */ void zzj(zzauo zzauo, zzbmz zzbmz) {
        long currentTimeMillis = zzu.zzB().currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        try {
            zze.zza("loadJavascriptEngine > Before createJavascriptEngine");
            zzbmd zzbmd = new zzbmd(this.zzb, this.zzd, (zzauo) null, (zza) null);
            zze.zza("loadJavascriptEngine > After createJavascriptEngine");
            zze.zza("loadJavascriptEngine > Before setting new engine loaded listener");
            zzbmd.zzk(new zzbmj(this, arrayList, currentTimeMillis, zzbmz, zzbmd));
            zze.zza("loadJavascriptEngine > Before registering GmsgHandler for /jsLoaded");
            zzbmd.zzq("/jsLoaded", new zzbml(this, currentTimeMillis, zzbmz, zzbmd));
            zzby zzby = new zzby();
            zzbmm zzbmm = new zzbmm(this, (zzauo) null, zzbmd, zzby);
            zzby.zzb(zzbmm);
            zze.zza("loadJavascriptEngine > Before registering GmsgHandler for /requestReload");
            zzbmd.zzq("/requestReload", zzbmm);
            zze.zza("loadJavascriptEngine > javascriptPath: ".concat(String.valueOf(this.zzc)));
            if (this.zzc.endsWith(".js")) {
                zze.zza("loadJavascriptEngine > Before newEngine.loadJavascript");
                zzbmd.zzh(this.zzc);
                zze.zza("loadJavascriptEngine > After newEngine.loadJavascript");
            } else if (this.zzc.startsWith("<html>")) {
                zze.zza("loadJavascriptEngine > Before newEngine.loadHtml");
                zzbmd.zzf(this.zzc);
                zze.zza("loadJavascriptEngine > After newEngine.loadHtml");
            } else {
                zze.zza("loadJavascriptEngine > Before newEngine.loadHtmlWrapper");
                zzbmd.zzg(this.zzc);
                zze.zza("loadJavascriptEngine > After newEngine.loadHtmlWrapper");
            }
            zze.zza("loadJavascriptEngine > Before calling ADMOB_UI_HANDLER.postDelayed");
            zzt.zza.postDelayed(new zzbmo(this, zzbmz, zzbmd, arrayList, currentTimeMillis), (long) ((Integer) zzba.zzc().zza(zzbbw.zzc)).intValue());
        } catch (Throwable th) {
            zzm.zzh("Error creating webview.", th);
            if (((Boolean) zzba.zzc().zza(zzbbw.zzgS)).booleanValue()) {
                zzbmz.zzh(th, "SdkJavascriptFactory.loadJavascriptEngine.createJavascriptEngine");
                return;
            }
            if (((Boolean) zzba.zzc().zza(zzbbw.zzgU)).booleanValue()) {
                zzu.zzo().zzv(th, "SdkJavascriptFactory.loadJavascriptEngine");
                zzbmz.zzg();
                return;
            }
            zzu.zzo().zzw(th, "SdkJavascriptFactory.loadJavascriptEngine");
            zzbmz.zzg();
        }
    }

    public final /* synthetic */ void zzk(zzblv zzblv) {
        if (zzblv.zzi()) {
            this.zzi = 1;
        }
    }
}
