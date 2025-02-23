package com.google.android.gms.ads.h5;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.ads.zzbjs;
import com.google.android.gms.internal.ads.zzbkf;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class H5AdsWebViewClient extends zzbjs {
    private final zzbkf zza;

    public H5AdsWebViewClient(Context context, WebView webView) {
        this.zza = new zzbkf(context, webView);
    }

    public void clearAdObjects() {
        this.zza.zza();
    }

    public WebViewClient getDelegate() {
        return this.zza;
    }

    public WebViewClient getDelegateWebViewClient() {
        return this.zza.getDelegate();
    }

    public void setDelegateWebViewClient(WebViewClient webViewClient) {
        this.zza.zzb(webViewClient);
    }
}
