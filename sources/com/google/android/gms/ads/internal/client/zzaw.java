package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzbfh;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbhd;
import com.google.android.gms.internal.ads.zzbjz;
import com.google.android.gms.internal.ads.zzbom;
import com.google.android.gms.internal.ads.zzbsg;
import com.google.android.gms.internal.ads.zzbsk;
import com.google.android.gms.internal.ads.zzbsn;
import com.google.android.gms.internal.ads.zzbts;
import com.google.android.gms.internal.ads.zzbwg;
import com.google.android.gms.internal.ads.zzbws;
import com.google.android.gms.internal.ads.zzbym;
import in.juspay.hyper.constants.LogCategory;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzaw {
    /* access modifiers changed from: private */
    public final zzk zza;
    /* access modifiers changed from: private */
    public final zzi zzb;
    /* access modifiers changed from: private */
    public final zzeq zzc;
    /* access modifiers changed from: private */
    public final zzbhc zzd;
    /* access modifiers changed from: private */
    public final zzbsk zze;
    /* access modifiers changed from: private */
    public final zzbhd zzf;
    /* access modifiers changed from: private */
    public zzbts zzg;

    public zzaw(zzk zzk, zzi zzi, zzeq zzeq, zzbhc zzbhc, zzbws zzbws, zzbsk zzbsk, zzbhd zzbhd) {
        this.zza = zzk;
        this.zzb = zzi;
        this.zzc = zzeq;
        this.zzd = zzbhc;
        this.zze = zzbsk;
        this.zzf = zzbhd;
    }

    public static /* bridge */ /* synthetic */ void zzt(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(LogCategory.ACTION, "no_ads_fallback");
        bundle.putString("flow", str);
        zzay.zzb().zzo(context, zzay.zzc().afmaVersion, "gmob-apps", bundle, true);
    }

    public final zzbq zzc(Context context, String str, zzbom zzbom) {
        return (zzbq) new zzao(this, context, str, zzbom).zzd(context, false);
    }

    public final zzbu zzd(Context context, zzq zzq, String str, zzbom zzbom) {
        return (zzbu) new zzak(this, context, zzq, str, zzbom).zzd(context, false);
    }

    public final zzbu zze(Context context, zzq zzq, String str, zzbom zzbom) {
        return (zzbu) new zzam(this, context, zzq, str, zzbom).zzd(context, false);
    }

    public final zzdj zzf(Context context, zzbom zzbom) {
        return (zzdj) new zzac(this, context, zzbom).zzd(context, false);
    }

    public final zzbfh zzh(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzbfh) new zzas(this, frameLayout, frameLayout2, context).zzd(context, false);
    }

    public final zzbfn zzi(View view, HashMap hashMap, HashMap hashMap2) {
        return (zzbfn) new zzau(this, view, hashMap, hashMap2).zzd(view.getContext(), false);
    }

    public final zzbjz zzl(Context context, zzbom zzbom, OnH5AdsEventListener onH5AdsEventListener) {
        return (zzbjz) new zzai(this, context, zzbom, onH5AdsEventListener).zzd(context, false);
    }

    public final zzbsg zzm(Context context, zzbom zzbom) {
        return (zzbsg) new zzag(this, context, zzbom).zzd(context, false);
    }

    public final zzbsn zzo(Activity activity) {
        zzaa zzaa = new zzaa(this, activity);
        Intent intent = activity.getIntent();
        boolean z = false;
        if (!intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            zzm.zzg("useClientJar flag not found in activity intent extras.");
        } else {
            z = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        return (zzbsn) zzaa.zzd(activity, z);
    }

    public final zzbwg zzq(Context context, String str, zzbom zzbom) {
        return (zzbwg) new zzav(this, context, str, zzbom).zzd(context, false);
    }

    public final zzbym zzr(Context context, zzbom zzbom) {
        return (zzbym) new zzae(this, context, zzbom).zzd(context, false);
    }
}
