package in.juspay.hypersdk.safe;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class JuspayWebChromeClient extends WebChromeClient {
    private final Godel godelManager;

    public JuspayWebChromeClient(Godel godel) {
        this.godelManager = godel;
    }

    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        this.godelManager.getDuiInterface().invokeFnInDUIWebview("onProgressChanged", String.valueOf(i));
    }
}
