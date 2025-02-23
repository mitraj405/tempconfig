package com.google.android.gms.internal.ads;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfnb extends WebViewClient {
    final /* synthetic */ zzfnd zza;

    public zzfnb(zzfnd zzfnd) {
        this.zza = zzfnd;
    }

    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        renderProcessGoneDetail.toString();
        String.valueOf(webView);
        if (this.zza.zza() == webView) {
            this.zza.zzm((WebView) null);
        }
        webView.destroy();
        return true;
    }
}
