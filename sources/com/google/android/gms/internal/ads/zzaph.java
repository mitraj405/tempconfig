package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzaph implements Comparable {
    /* access modifiers changed from: private */
    public final zzaps zza;
    private final int zzb;
    private final String zzc;
    private final int zzd;
    private final Object zze;
    private final zzapl zzf;
    private Integer zzg;
    private zzapk zzh;
    private boolean zzi;
    private zzaoq zzj;
    private zzapg zzk;
    private final zzaov zzl;

    public zzaph(int i, String str, zzapl zzapl) {
        zzaps zzaps;
        Uri parse;
        String host;
        if (zzaps.zza) {
            zzaps = new zzaps();
        } else {
            zzaps = null;
        }
        this.zza = zzaps;
        this.zze = new Object();
        int i2 = 0;
        this.zzi = false;
        this.zzj = null;
        this.zzb = i;
        this.zzc = str;
        this.zzf = zzapl;
        this.zzl = new zzaov();
        if (!(TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null)) {
            i2 = host.hashCode();
        }
        this.zzd = i2;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zzg.intValue() - ((zzaph) obj).zzg.intValue();
    }

    public final String toString() {
        String valueOf = String.valueOf(Integer.toHexString(this.zzd));
        zzw();
        Integer num = this.zzg;
        return "[ ] " + this.zzc + " " + "0x".concat(valueOf) + " NORMAL " + num;
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzl.zzb();
    }

    public final int zzc() {
        return this.zzd;
    }

    public final zzaoq zzd() {
        return this.zzj;
    }

    public final zzaph zze(zzaoq zzaoq) {
        this.zzj = zzaoq;
        return this;
    }

    public final zzaph zzf(zzapk zzapk) {
        this.zzh = zzapk;
        return this;
    }

    public final zzaph zzg(int i) {
        this.zzg = Integer.valueOf(i);
        return this;
    }

    public abstract zzapn zzh(zzapd zzapd);

    public final String zzj() {
        int i = this.zzb;
        String str = this.zzc;
        if (i != 0) {
            return xx.D(Integer.toString(1), "-", str);
        }
        return str;
    }

    public final String zzk() {
        return this.zzc;
    }

    public Map zzl() throws zzaop {
        return Collections.emptyMap();
    }

    public final void zzm(String str) {
        if (zzaps.zza) {
            this.zza.zza(str, Thread.currentThread().getId());
        }
    }

    public final void zzn(zzapq zzapq) {
        zzapl zzapl;
        synchronized (this.zze) {
            zzapl = this.zzf;
        }
        zzapl.zza(zzapq);
    }

    public abstract void zzo(Object obj);

    public final void zzp(String str) {
        zzapk zzapk = this.zzh;
        if (zzapk != null) {
            zzapk.zzb(this);
        }
        if (zzaps.zza) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzapf(this, str, id));
                return;
            }
            this.zza.zza(str, id);
            this.zza.zzb(toString());
        }
    }

    public final void zzq() {
        synchronized (this.zze) {
            this.zzi = true;
        }
    }

    public final void zzr() {
        zzapg zzapg;
        synchronized (this.zze) {
            zzapg = this.zzk;
        }
        if (zzapg != null) {
            zzapg.zza(this);
        }
    }

    public final void zzs(zzapn zzapn) {
        zzapg zzapg;
        synchronized (this.zze) {
            zzapg = this.zzk;
        }
        if (zzapg != null) {
            zzapg.zzb(this, zzapn);
        }
    }

    public final void zzt(int i) {
        zzapk zzapk = this.zzh;
        if (zzapk != null) {
            zzapk.zzc(this, i);
        }
    }

    public final void zzu(zzapg zzapg) {
        synchronized (this.zze) {
            this.zzk = zzapg;
        }
    }

    public final boolean zzv() {
        boolean z;
        synchronized (this.zze) {
            z = this.zzi;
        }
        return z;
    }

    public final boolean zzw() {
        synchronized (this.zze) {
        }
        return false;
    }

    public byte[] zzx() throws zzaop {
        return null;
    }

    public final zzaov zzy() {
        return this.zzl;
    }
}
