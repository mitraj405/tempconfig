package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import android.view.accessibility.CaptioningManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public class zzch {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;
    /* access modifiers changed from: private */
    public boolean zzg;
    /* access modifiers changed from: private */
    public final zzfxr zzh;
    /* access modifiers changed from: private */
    public final zzfxr zzi;
    private final int zzj;
    private final int zzk;
    /* access modifiers changed from: private */
    public final zzfxr zzl;
    /* access modifiers changed from: private */
    public final zzcg zzm;
    /* access modifiers changed from: private */
    public zzfxr zzn;
    /* access modifiers changed from: private */
    public int zzo;
    /* access modifiers changed from: private */
    public final HashMap zzp;
    /* access modifiers changed from: private */
    public final HashSet zzq;

    @Deprecated
    public zzch() {
        this.zza = Integer.MAX_VALUE;
        this.zzb = Integer.MAX_VALUE;
        this.zzc = Integer.MAX_VALUE;
        this.zzd = Integer.MAX_VALUE;
        this.zze = Integer.MAX_VALUE;
        this.zzf = Integer.MAX_VALUE;
        this.zzg = true;
        this.zzh = zzfxr.zzm();
        this.zzi = zzfxr.zzm();
        this.zzj = Integer.MAX_VALUE;
        this.zzk = Integer.MAX_VALUE;
        this.zzl = zzfxr.zzm();
        this.zzm = zzcg.zza;
        this.zzn = zzfxr.zzm();
        this.zzo = 0;
        this.zzp = new HashMap();
        this.zzq = new HashSet();
    }

    public final zzch zze(Context context) {
        CaptioningManager captioningManager;
        if ((zzet.zza >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
            this.zzo = 1088;
            Locale locale = captioningManager.getLocale();
            if (locale != null) {
                this.zzn = zzfxr.zzn(locale.toLanguageTag());
            }
        }
        return this;
    }

    public final zzch zzf(int i, int i2, boolean z) {
        this.zze = i;
        this.zzf = i2;
        this.zzg = true;
        return this;
    }

    public zzch(zzci zzci) {
        this.zza = Integer.MAX_VALUE;
        this.zzb = Integer.MAX_VALUE;
        this.zzc = Integer.MAX_VALUE;
        this.zzd = Integer.MAX_VALUE;
        this.zze = zzci.zzi;
        this.zzf = zzci.zzj;
        this.zzg = zzci.zzk;
        this.zzh = zzci.zzl;
        this.zzi = zzci.zzn;
        this.zzj = Integer.MAX_VALUE;
        this.zzk = Integer.MAX_VALUE;
        this.zzl = zzci.zzr;
        this.zzm = zzci.zzs;
        this.zzn = zzci.zzt;
        this.zzo = zzci.zzu;
        this.zzq = new HashSet(zzci.zzB);
        this.zzp = new HashMap(zzci.zzA);
    }
}
