package cris.org.in.ima.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import cris.org.in.prs.ima.R;

public class RefundOnCancellationActivity extends Activity {
    @BindView(2131364917)
    WebView mWebView;
    @BindView(2131364663)
    TextView titleName;

    public class a extends WebViewClient {
        public final /* synthetic */ ProgressDialog a;

        public a(ProgressDialog progressDialog) {
            this.a = progressDialog;
        }

        public final void onPageFinished(WebView webView, String str) {
            ProgressDialog progressDialog = this.a;
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(C0575LC.a(context));
    }

    @OnClick({2131362879})
    public void onBackArrowClick() {
        onBackPressed();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().requestFeature(2);
        setContentView(R.layout.activity_terms_and_conditions);
        ButterKnife.bind((Activity) this);
        String stringExtra = getIntent().getStringExtra("URL");
        this.titleName.setText("IRCTC Pay On Delivery");
        ProgressDialog show = ProgressDialog.show(this, "", getString(R.string.loading), true);
        getWindow().setFeatureInt(2, -1);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.requestFocusFromTouch();
        this.mWebView.setWebViewClient(new a(show));
        this.mWebView.setWebChromeClient(new WebChromeClient());
        this.mWebView.loadUrl(stringExtra);
    }

    public final void onPause() {
        super.onPause();
        getWindow().setFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE, UserMetadata.MAX_INTERNAL_KEY_SIZE);
    }

    public final void onResume() {
        super.onResume();
        getWindow().clearFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
    }
}
