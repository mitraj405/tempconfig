package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.webkit.WebView;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfnd extends zzfmz {
    /* access modifiers changed from: private */
    public WebView zza;
    private Long zzb = null;
    private final Map zzc;

    public zzfnd(String str, Map map, String str2) {
        super(str);
        this.zzc = map;
    }

    public final void zzc() {
        long j;
        super.zzc();
        if (this.zzb == null) {
            j = 4000;
        } else {
            j = TimeUnit.MILLISECONDS.convert(System.nanoTime() - this.zzb.longValue(), TimeUnit.NANOSECONDS);
        }
        new Handler().postDelayed(new zzfnc(this), Math.max(4000 - j, 2000));
        this.zza = null;
    }

    public final void zzi(zzflu zzflu, zzfls zzfls) {
        JSONObject jSONObject = new JSONObject();
        Map zzi = zzfls.zzi();
        Iterator it = zzi.keySet().iterator();
        if (!it.hasNext()) {
            zzj(zzflu, zzfls, jSONObject);
        } else {
            zzfme zzfme = (zzfme) zzi.get((String) it.next());
            throw null;
        }
    }

    public final void zzn() {
        WebView webView = new WebView(zzfmq.zzb().zza());
        this.zza = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.zza.getSettings().setAllowContentAccess(false);
        this.zza.getSettings().setAllowFileAccess(false);
        this.zza.setWebViewClient(new zzfnb(this));
        zzm(this.zza);
        zzfms.zzj(this.zza, (String) null);
        Iterator it = this.zzc.keySet().iterator();
        if (!it.hasNext()) {
            this.zzb = Long.valueOf(System.nanoTime());
            return;
        }
        zzfme zzfme = (zzfme) this.zzc.get((String) it.next());
        throw null;
    }
}
