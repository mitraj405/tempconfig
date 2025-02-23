package cris.org.in.ima.fragment;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* compiled from: TrainDashboardFragment */
public final class E0 extends WebViewClient {
    public final /* synthetic */ TrainDashboardFragment a;

    public E0(TrainDashboardFragment trainDashboardFragment) {
        this.a = trainDashboardFragment;
    }

    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        TrainDashboardFragment trainDashboardFragment = this.a;
        if (webResourceResponse == null) {
            trainDashboardFragment.webView_ll.setVisibility(0);
        } else {
            trainDashboardFragment.webView_ll.setVisibility(8);
        }
    }
}
