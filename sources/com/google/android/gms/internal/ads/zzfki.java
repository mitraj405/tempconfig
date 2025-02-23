package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfki implements Runnable {
    public static final Object zza = new Object();
    public static Boolean zzb;
    private static final Object zzc = new Object();
    private static final Object zzd = new Object();
    private final Context zze;
    private final VersionInfoParcel zzf;
    private final zzfko zzg = zzfkr.zzc();
    private String zzh = "";
    private int zzi;
    private final zzdpy zzj;
    private final List zzk;
    private boolean zzl = false;
    private final zzbvj zzm;

    public zzfki(Context context, VersionInfoParcel versionInfoParcel, zzdpy zzdpy, zzebn zzebn, zzbvj zzbvj) {
        this.zze = context;
        this.zzf = versionInfoParcel;
        this.zzj = zzdpy;
        this.zzm = zzbvj;
        if (((Boolean) zzba.zzc().zza(zzbbw.zzhW)).booleanValue()) {
            this.zzk = zzt.zzd();
        } else {
            this.zzk = zzfxr.zzm();
        }
    }

    public static boolean zza() {
        boolean booleanValue;
        boolean z;
        synchronized (zza) {
            if (zzb == null) {
                if (!((Boolean) zzbdl.zzb.zze()).booleanValue()) {
                    zzb = Boolean.FALSE;
                } else {
                    if (Math.random() < ((Double) zzbdl.zza.zze()).doubleValue()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zzb = Boolean.valueOf(z);
                }
            }
            booleanValue = zzb.booleanValue();
        }
        return booleanValue;
    }

    public final void run() {
        byte[] zzaV;
        if (zza()) {
            Object obj = zzc;
            synchronized (obj) {
                if (this.zzg.zza() != 0) {
                    try {
                        synchronized (obj) {
                            zzaV = ((zzfkr) this.zzg.zzbr()).zzaV();
                            this.zzg.zzc();
                        }
                        new zzebm(this.zze, this.zzf.afmaVersion, this.zzm, Binder.getCallingUid()).zza(new zzebk((String) zzba.zzc().zza(zzbbw.zzhQ), 60000, new HashMap(), zzaV, "application/x-protobuf", false));
                    } catch (Exception e) {
                        if (!(e instanceof zzdwl) || ((zzdwl) e).zza() != 3) {
                            zzu.zzo().zzv(e, "CuiMonitor.sendCuiPing");
                        }
                    }
                }
            }
        }
    }

    public final void zzb(zzfjy zzfjy) {
        zzbzo.zza.zza(new zzfkh(this, zzfjy));
    }

    public final /* synthetic */ void zzc(zzfjy zzfjy) {
        synchronized (zzd) {
            if (!this.zzl) {
                this.zzl = true;
                if (zza()) {
                    try {
                        zzu.zzp();
                        this.zzh = zzt.zzp(this.zze);
                    } catch (RemoteException | RuntimeException e) {
                        zzu.zzo().zzw(e, "CuiMonitor.gettingAppIdFromManifest");
                    }
                    this.zzi = GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zze);
                    int intValue = ((Integer) zzba.zzc().zza(zzbbw.zzhR)).intValue();
                    if (((Boolean) zzba.zzc().zza(zzbbw.zzkT)).booleanValue()) {
                        long j = (long) intValue;
                        zzbzo.zzd.scheduleWithFixedDelay(this, j, j, TimeUnit.MILLISECONDS);
                    } else {
                        long j2 = (long) intValue;
                        zzbzo.zzd.scheduleAtFixedRate(this, j2, j2, TimeUnit.MILLISECONDS);
                    }
                }
            }
        }
        if (zza() && zzfjy != null) {
            synchronized (zzc) {
                if (this.zzg.zza() < ((Integer) zzba.zzc().zza(zzbbw.zzhS)).intValue()) {
                    zzfkk zza2 = zzfkm.zza();
                    zza2.zzu(zzfjy.zzm());
                    zza2.zzq(zzfjy.zzl());
                    zza2.zzg(zzfjy.zzb());
                    zza2.zzw(3);
                    zza2.zzn(this.zzf.afmaVersion);
                    zza2.zzb(this.zzh);
                    zza2.zzk(Build.VERSION.RELEASE);
                    zza2.zzr(Build.VERSION.SDK_INT);
                    zza2.zzv(zzfjy.zzo());
                    zza2.zzj(zzfjy.zza());
                    zza2.zze((long) this.zzi);
                    zza2.zzt(zzfjy.zzn());
                    zza2.zzc(zzfjy.zze());
                    zza2.zzf(zzfjy.zzg());
                    zza2.zzh(zzfjy.zzh());
                    zza2.zzi(this.zzj.zzb(zzfjy.zzh()));
                    zza2.zzl(zzfjy.zzi());
                    zza2.zzm(zzfjy.zzd());
                    zza2.zzd(zzfjy.zzf());
                    zza2.zzs(zzfjy.zzk());
                    zza2.zzo(zzfjy.zzj());
                    zza2.zzp(zzfjy.zzc());
                    if (((Boolean) zzba.zzc().zza(zzbbw.zzhW)).booleanValue()) {
                        zza2.zza(this.zzk);
                    }
                    zzfko zzfko = this.zzg;
                    zzfkp zza3 = zzfkq.zza();
                    zza3.zza(zza2);
                    zzfko.zzb(zza3);
                }
            }
        }
    }
}
