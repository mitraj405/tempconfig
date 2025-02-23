package in.juspay.hypersdk.ui;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewClient;
import in.juspay.hypersdk.core.MerchantViewType;

public abstract class HyperPaymentsCallbackAdapter implements HyperPaymentsCallback {
    public WebViewClient createJuspaySafeWebViewClient() {
        return null;
    }

    public View getMerchantView(ViewGroup viewGroup, MerchantViewType merchantViewType) {
        return null;
    }

    public void onStartWaitingDialogCreated(View view) {
    }
}
