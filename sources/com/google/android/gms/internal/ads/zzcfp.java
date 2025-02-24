package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcfp {
    private final zzcfq zza;
    private final zzcfo zzb;

    public zzcfp(zzcfq zzcfq, zzcfo zzcfo) {
        this.zzb = zzcfo;
        this.zza = zzcfq;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.internal.ads.zzcfw, com.google.android.gms.internal.ads.zzcfq] */
    @JavascriptInterface
    public String getClickSignals(String str) {
        if (TextUtils.isEmpty(str)) {
            zze.zza("Click string is empty, not proceeding.");
            return "";
        }
        ? r0 = this.zza;
        zzauo zzI = r0.zzI();
        if (zzI == null) {
            zze.zza("Signal utils is empty, ignoring.");
            return "";
        }
        zzauk zzc = zzI.zzc();
        if (zzc == null) {
            zze.zza("Signals object is empty, ignoring.");
            return "";
        } else if (r0.getContext() == null) {
            zze.zza("Context is null, ignoring.");
            return "";
        } else {
            zzcfq zzcfq = this.zza;
            return zzc.zzf(zzcfq.getContext(), str, (View) zzcfq, zzcfq.zzi());
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.google.android.gms.internal.ads.zzcfw, com.google.android.gms.internal.ads.zzcfq] */
    @JavascriptInterface
    public String getViewSignals() {
        ? r0 = this.zza;
        zzauo zzI = r0.zzI();
        if (zzI == null) {
            zze.zza("Signal utils is empty, ignoring.");
            return "";
        }
        zzauk zzc = zzI.zzc();
        if (zzc == null) {
            zze.zza("Signals object is empty, ignoring.");
            return "";
        } else if (r0.getContext() == null) {
            zze.zza("Context is null, ignoring.");
            return "";
        } else {
            zzcfq zzcfq = this.zza;
            return zzc.zzh(zzcfq.getContext(), (View) zzcfq, zzcfq.zzi());
        }
    }

    @JavascriptInterface
    public void notify(String str) {
        if (TextUtils.isEmpty(str)) {
            zzm.zzj("URL is empty, ignoring message");
        } else {
            zzt.zza.post(new zzcfn(this, str));
        }
    }

    public final /* synthetic */ void zza(String str) {
        Uri parse = Uri.parse(str);
        zzcer zzaO = ((zzcfi) this.zzb.zza).zzaO();
        if (zzaO == null) {
            zzm.zzg("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
        } else {
            zzaO.zzj(parse);
        }
    }
}
