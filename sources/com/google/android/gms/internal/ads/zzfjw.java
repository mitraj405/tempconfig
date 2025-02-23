package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.zzu;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfjw implements zzfju {
    private final Context zza;
    /* access modifiers changed from: private */
    public long zzb = 0;
    /* access modifiers changed from: private */
    public long zzc = -1;
    /* access modifiers changed from: private */
    public boolean zzd = false;
    /* access modifiers changed from: private */
    public int zze = 0;
    /* access modifiers changed from: private */
    public String zzf = "";
    /* access modifiers changed from: private */
    public String zzg = "";
    /* access modifiers changed from: private */
    public String zzh = "";
    /* access modifiers changed from: private */
    public String zzi = "";
    /* access modifiers changed from: private */
    public zzfkl zzj = zzfkl.SCAR_REQUEST_TYPE_UNSPECIFIED;
    /* access modifiers changed from: private */
    public String zzk = "";
    /* access modifiers changed from: private */
    public String zzl = "";
    /* access modifiers changed from: private */
    public String zzm = "";
    private boolean zzn = false;
    private boolean zzo = false;
    /* access modifiers changed from: private */
    public final int zzp;
    /* access modifiers changed from: private */
    public int zzq = 2;
    /* access modifiers changed from: private */
    public int zzr = 2;

    public zzfjw(Context context, int i) {
        this.zza = context;
        this.zzp = i;
    }

    public final synchronized zzfjw zzA() {
        this.zzc = zzu.zzB().elapsedRealtime();
        return this;
    }

    public final synchronized zzfjw zzK(int i) {
        this.zzq = i;
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfju zza(zze zze2) {
        zzr(zze2);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfju zzb(zzfew zzfew) {
        zzs(zzfew);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfju zzc(String str) {
        zzt(str);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfju zzd(String str) {
        zzu(str);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfju zze(String str) {
        zzv(str);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfju zzf(zzfkl zzfkl) {
        zzw(zzfkl);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfju zzg(boolean z) {
        zzx(z);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfju zzh(Throwable th) {
        zzy(th);
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfju zzi() {
        zzz();
        return this;
    }

    public final /* bridge */ /* synthetic */ zzfju zzj() {
        zzA();
        return this;
    }

    public final synchronized boolean zzk() {
        return this.zzo;
    }

    public final boolean zzl() {
        if (!TextUtils.isEmpty(this.zzh)) {
            return true;
        }
        return false;
    }

    public final synchronized zzfjy zzm() {
        if (this.zzn) {
            return null;
        }
        this.zzn = true;
        if (!this.zzo) {
            zzz();
        }
        if (this.zzc < 0) {
            zzA();
        }
        return new zzfjy(this, (zzfjx) null);
    }

    public final /* bridge */ /* synthetic */ zzfju zzn(int i) {
        zzK(i);
        return this;
    }

    public final synchronized zzfjw zzr(zze zze2) {
        IBinder iBinder = zze2.zze;
        if (iBinder != null) {
            zzcwj zzcwj = (zzcwj) iBinder;
            String zzk2 = zzcwj.zzk();
            if (!TextUtils.isEmpty(zzk2)) {
                this.zzf = zzk2;
            }
            String zzi2 = zzcwj.zzi();
            if (!TextUtils.isEmpty(zzi2)) {
                this.zzg = zzi2;
            }
        }
        return this;
    }

    public final synchronized zzfjw zzs(zzfew zzfew) {
        if (!TextUtils.isEmpty(zzfew.zzb.zzb)) {
            this.zzf = zzfew.zzb.zzb;
        }
        Iterator it = zzfew.zza.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            zzfel zzfel = (zzfel) it.next();
            if (!TextUtils.isEmpty(zzfel.zzab)) {
                this.zzg = zzfel.zzab;
                break;
            }
        }
        return this;
    }

    public final synchronized zzfjw zzt(String str) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzhV)).booleanValue()) {
            this.zzm = str;
        }
        return this;
    }

    public final synchronized zzfjw zzu(String str) {
        this.zzh = str;
        return this;
    }

    public final synchronized zzfjw zzv(String str) {
        this.zzi = str;
        return this;
    }

    public final synchronized zzfjw zzw(zzfkl zzfkl) {
        this.zzj = zzfkl;
        return this;
    }

    public final synchronized zzfjw zzx(boolean z) {
        this.zzd = z;
        return this;
    }

    public final synchronized zzfjw zzy(Throwable th) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzhV)).booleanValue()) {
            this.zzl = zzbtq.zzf(th);
            this.zzk = (String) zzfvh.zzb(zzfui.zzc(10)).zzc(zzbtq.zze(th)).iterator().next();
        }
        return this;
    }

    public final synchronized zzfjw zzz() {
        this.zze = zzu.zzq().zzm(this.zza);
        Resources resources = this.zza.getResources();
        int i = 2;
        if (resources != null) {
            Configuration configuration = resources.getConfiguration();
            if (configuration != null) {
                i = configuration.orientation == 2 ? 4 : 3;
            }
        }
        this.zzr = i;
        this.zzb = zzu.zzB().elapsedRealtime();
        this.zzo = true;
        return this;
    }
}
