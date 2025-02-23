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

public class EcateringActivity extends Activity {
    public String c;
    @BindView(2131362465)
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

    static {
        C1354qp.R(EcateringActivity.class);
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
        setContentView(R.layout.e_catering_web);
        ButterKnife.bind((Activity) this);
        if (getIntent().getExtras() != null) {
            this.c = getIntent().getExtras().getString("pnr");
        }
        this.titleName.setText(getResources().getString(R.string.e_catering));
        ProgressDialog show = ProgressDialog.show(this, "", getString(R.string.loading), true);
        getWindow().setFeatureInt(2, -1);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.requestFocusFromTouch();
        this.mWebView.setWebViewClient(new a(show));
        getWindow().setSoftInputMode(16);
        this.mWebView.setWebChromeClient(new WebChromeClient());
        if (this.c != null) {
            this.mWebView.loadUrl(String.format(getResources().getString(R.string.ecatering_url_withpnr), new Object[]{this.c}));
            return;
        }
        this.mWebView.loadUrl(getResources().getString(R.string.ecatering_url));
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
