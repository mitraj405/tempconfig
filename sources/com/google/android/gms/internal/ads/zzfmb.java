package com.google.android.gms.internal.ads;

import android.view.View;
import android.webkit.WebView;
import defpackage.C0390xD;
import defpackage.C1234l3;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Timer;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfmb {
    private final zzfmd zza;
    private final WebView zzb;
    private final HashMap zzc = new HashMap();
    private final zzfmp zzd = new zzfmp();

    private zzfmb(zzfmd zzfmd, WebView webView, boolean z) {
        zzfnj.zza();
        this.zza = zzfmd;
        this.zzb = webView;
        if (r1.C("WEB_MESSAGE_LISTENER")) {
            zzg();
            zzfma zzfma = new zzfma(this);
            HashSet hashSet = new HashSet(Arrays.asList(new String[]{"*"}));
            int i = C0362vD.a;
            if (C0376wD.c.c()) {
                C0390xD.a.a.a(webView).addWebMessageListener("omidJsSessionService", (String[]) hashSet.toArray(new String[0]), new C1234l3.a(new C0314rD(zzfma)));
                return;
            }
            throw new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
        }
        throw new UnsupportedOperationException("The JavaScriptSessionService cannot be supported in this WebView version.");
    }

    public static zzfmb zza(zzfmd zzfmd, WebView webView, boolean z) {
        return new zzfmb(zzfmd, webView, true);
    }

    public static /* bridge */ /* synthetic */ void zzb(zzfmb zzfmb, String str) {
        zzflq zzflq = (zzflq) zzfmb.zzc.get(str);
        if (zzflq != null) {
            zzflq.zzc();
            zzfmb.zzc.remove(str);
        }
    }

    public static /* bridge */ /* synthetic */ void zzd(zzfmb zzfmb, String str) {
        zzflv zzflv = zzflv.DEFINED_BY_JAVASCRIPT;
        zzfly zzfly = zzfly.DEFINED_BY_JAVASCRIPT;
        zzfmc zzfmc = zzfmc.JAVASCRIPT;
        zzflu zzflu = new zzflu(zzflr.zza(zzflv, zzfly, zzfmc, zzfmc, false), zzfls.zzb(zzfmb.zza, zzfmb.zzb, (String) null, (String) null), str);
        zzfmb.zzc.put(str, zzflu);
        zzflu.zzd(zzfmb.zzb);
        for (zzfmo zzfmo : zzfmb.zzd.zza()) {
            zzflu.zzb((View) zzfmo.zzb().get(), zzfmo.zza(), zzfmo.zzc());
        }
        zzflu.zze();
    }

    /* access modifiers changed from: private */
    public final void zzg() {
        WebView webView = this.zzb;
        int i = C0362vD.a;
        if (C0376wD.c.c()) {
            C0390xD.a.a.a(webView).removeWebMessageListener("omidJsSessionService");
            return;
        }
        throw new UnsupportedOperationException("This method is not supported by the current version of the framework and the current WebView APK");
    }

    public final void zze(View view, zzflx zzflx, String str) {
        for (zzflq zzb2 : this.zzc.values()) {
            zzb2.zzb(view, zzflx, "Ad overlay");
        }
        this.zzd.zzb(view, zzflx, "Ad overlay");
    }

    public final void zzf(zzcey zzcey) {
        for (zzflq zzc2 : this.zzc.values()) {
            zzc2.zzc();
        }
        Timer timer = new Timer();
        timer.schedule(new zzflz(this, zzcey, timer), 1000);
    }
}
