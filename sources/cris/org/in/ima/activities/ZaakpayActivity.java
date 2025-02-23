package cris.org.in.ima.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import cris.org.in.prs.ima.R;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;

public class ZaakpayActivity extends AppCompatActivity implements C1245lp, Serializable {
    public static final ZaakpayActivity a = new ZaakpayActivity();

    /* renamed from: a  reason: collision with other field name */
    public Fragment f4373a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f4374a = false;
    @BindView(2131364918)
    WebView webView;

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent();
            intent.putExtra("bankresponse", "device_back_button");
            int bankId = C1480xl.f7038a.f7042a.getBankId();
            ZaakpayActivity zaakpayActivity = ZaakpayActivity.this;
            zaakpayActivity.setResult(bankId, intent);
            C0535I5.u0(zaakpayActivity);
            zaakpayActivity.finish();
        }
    }

    public interface c {
        @JavascriptInterface
        void onPaymentDone(String str);
    }

    static {
        C1354qp.R(ZaakpayActivity.class);
    }

    public final Fragment a() {
        return this.f4373a;
    }

    public final void e() {
        C1480xl.f7038a.f7042a.getParamList();
    }

    public final void l(Intent intent) {
        String str;
        String str2;
        C1480xl xlVar = C1480xl.f7038a;
        String str3 = null;
        if (xlVar.f7042a.getBankId() == 101) {
            if (intent.hasExtra("bankresponse")) {
                str3 = intent.getExtras().getString("bankresponse");
            }
            if (str3 == null || str3.isEmpty()) {
                C0535I5.m(getBaseContext(), false, getString(R.string.error_getting_response_from_bank), getString(R.string.error), "OK", (DialogInterface.OnClickListener) null).show();
            } else if (!str3.equalsIgnoreCase("device_back_button")) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Do("RESPONSE", intent.getExtras().get("bankresponse").toString()));
                xlVar.c(this.f4373a, arrayList);
            }
        } else if (xlVar.f7042a.getBankId() == 108) {
            try {
                if (intent.hasExtra("bankresponse")) {
                    str = intent.getExtras().getString("bankresponse");
                } else {
                    str = null;
                }
                if (str != null) {
                    if (!str.isEmpty()) {
                        HashMap hashMap = new HashMap();
                        if (!str.equalsIgnoreCase("device_back_button")) {
                            for (String split : str.split(",")) {
                                String[] split2 = split.split("=");
                                if (!(split2.length != 2 || (str2 = split2[0]) == null || split2[1] == null)) {
                                    hashMap.put(str2.trim(), split2[1].trim());
                                }
                            }
                            if (hashMap.get("encdata") != null) {
                                ArrayList arrayList2 = new ArrayList();
                                if (hashMap.get("encdata".toLowerCase()) != null) {
                                    arrayList2.add(new Do("encdata", ((String) hashMap.get("encdata".toLowerCase())).toString()));
                                }
                                C0535I5.W("PAYMENT_COMPLETED", false, new C0822cf(this.f4373a.getActivity()), (String) null, (String) null);
                                C1480xl.f7038a.c(this.f4373a, arrayList2);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                C0535I5.m(getBaseContext(), false, getString(R.string.error_getting_response_from_bank), getString(R.string.error), "OK", (DialogInterface.OnClickListener) null).show();
            } catch (Exception e) {
                C0535I5.m(this.f4373a.getActivity(), false, getString(R.string.error_getting_response_from_bank), getString(R.string.error), "OK", (DialogInterface.OnClickListener) null).show();
                e.getMessage();
            }
        }
    }

    public final void onBackPressed() {
        C0535I5.p(this, false, getString(R.string.cancel_txn_msg), getString(R.string.cancel_txn_head), getString(R.string.yes), new a(), getString(R.string.no), new b()).show();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_zaakpay);
        ButterKnife.bind((Activity) this);
        String string = getIntent().getExtras().getString("post_data");
        String string2 = getIntent().getExtras().getString("post_url");
        String string3 = getIntent().getExtras().getString("js_routine");
        try {
            this.webView = new WebView(this);
            C1480xl xlVar = C1480xl.f7038a;
            if (xlVar.f7042a.getBankId() == 108) {
                this.webView.getSettings().setJavaScriptEnabled(true);
                this.webView.getSettings().setDomStorageEnabled(true);
                this.webView.getSettings().setLoadWithOverviewMode(true);
                this.webView.getSettings().setUseWideViewPort(true);
                this.webView.getSettings().setCacheMode(2);
                this.webView.getSettings().setSupportMultipleWindows(true);
                this.webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            }
            this.webView.getSettings().setJavaScriptEnabled(true);
            this.webView.addJavascriptInterface(new Q(this), string3);
            this.webView.setWebViewClient(new C0460BE(this));
            if (xlVar.f7042a.getBankId() == 108) {
                this.webView.postUrl(string2, string.getBytes(Charset.forName("UTF-8")));
            } else {
                this.webView.postUrl(string2, string.getBytes());
            }
            setContentView((View) this.webView);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public final void onPause() {
        super.onPause();
        getWindow().setFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE, UserMetadata.MAX_INTERNAL_KEY_SIZE);
    }

    public final void onResume() {
        super.onResume();
        getWindow().clearFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
    }

    public final void b() {
    }

    public final void c(String str) {
    }

    public class b implements DialogInterface.OnClickListener {
        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }
}
