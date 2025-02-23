package cris.org.in.ima.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import cris.org.in.prs.ima.R;

public class WebActivity extends Activity {
    public static final /* synthetic */ int c = 0;
    @BindView(2131364903)
    WebView tNcWebview;
    @BindView(2131364663)
    TextView titleName;

    static {
        C1354qp.R(WebActivity.class);
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(C0575LC.a(context));
    }

    @OnClick({2131362879})
    public void onBackArrowClick() {
        onBackPressed();
    }

    public final void onCreate(Bundle bundle) {
        C1223kn knVar;
        super.onCreate(bundle);
        setContentView(R.layout.activity_web);
        ButterKnife.bind((Activity) this);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("title");
        String stringExtra2 = intent.getStringExtra("url");
        C0486Dp dp = (C0486Dp) intent.getSerializableExtra("pledgeDTO");
        if (!(dp == null || !C0535I5.O((ConnectivityManager) getSystemService("connectivity"), this) || (knVar = C0793b1.a.f3912a) == null)) {
            String l = C0657Qt.l();
            ((Om) C0657Qt.c(knVar)).u(l + "addPledge", dp).c(C1181iv.a()).a(E0.a()).b(new C1346qD());
        }
        this.tNcWebview.setWebViewClient(new WebViewClient());
        this.titleName.setText(stringExtra);
        this.tNcWebview.loadUrl(stringExtra2);
        this.tNcWebview.getSettings().setJavaScriptEnabled(true);
        this.tNcWebview.requestFocusFromTouch();
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
