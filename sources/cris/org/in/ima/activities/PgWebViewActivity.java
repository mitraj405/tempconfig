package cris.org.in.ima.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
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
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

public class PgWebViewActivity extends AppCompatActivity implements C1245lp, Serializable {
    public static final PgWebViewActivity a = new PgWebViewActivity();

    /* renamed from: a  reason: collision with other field name */
    public ProgressDialog f4269a = null;

    /* renamed from: a  reason: collision with other field name */
    public Fragment f4270a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f4271a = false;
    public String c;
    @BindView(2131364916)
    WebView webView;

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent();
            intent.putExtra("bankresponse", "device_back_button");
            int bankId = C1480xl.f7038a.f7042a.getBankId();
            PgWebViewActivity pgWebViewActivity = PgWebViewActivity.this;
            pgWebViewActivity.setResult(bankId, intent);
            C0535I5.u0(pgWebViewActivity);
            pgWebViewActivity.finish();
            C0535I5.W("BACKPRESSED", true, new C0822cf(pgWebViewActivity), (String) null, (String) null);
        }
    }

    public interface c {
        @JavascriptInterface
        void onPaymentDone(String str);
    }

    static {
        C1354qp.R(PgWebViewActivity.class);
    }

    public final Fragment a() {
        return this.f4270a;
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(C0575LC.a(context));
    }

    public final void e() {
        ArrayList<Do> paramList = C1480xl.f7038a.f7042a.getParamList();
        if (paramList != null) {
            if (paramList.get(0) != null) {
                String str = null;
                String str2 = "";
                String str3 = null;
                for (int i = 0; i < paramList.size(); i++) {
                    try {
                        paramList.get(i).getKey();
                        paramList.get(i).getValue();
                        if (paramList.get(i).getKey().equalsIgnoreCase("bankUrl")) {
                            str3 = paramList.get(i).getValue();
                        } else if (paramList.get(i).getKey().equalsIgnoreCase("encdata")) {
                            str = paramList.get(i).getValue();
                        } else if (paramList.get(i).getKey().equalsIgnoreCase("token")) {
                            str = paramList.get(i).getValue();
                        } else if (paramList.get(i).getKey().equalsIgnoreCase("bdaesk3.msg")) {
                            str = paramList.get(i).getValue();
                        } else if (paramList.get(i).getKey().equalsIgnoreCase("ENC_DATA")) {
                            str = URLEncoder.encode(paramList.get(i).getValue(), "UTF-8");
                        } else if (paramList.get(i).getKey().equalsIgnoreCase("MID") || paramList.get(i).getKey().equalsIgnoreCase("CHECKSUMHASH")) {
                            str2 = str2 + "&" + paramList.get(i).getKey() + "=" + URLEncoder.encode(paramList.get(i).getValue(), "UTF-8");
                        }
                    } catch (UnsupportedEncodingException e) {
                        e.getMessage();
                    }
                }
                Intent intent = new Intent(this.f4270a.getActivity(), PgWebViewActivity.class);
                intent.putExtra("bill", str);
                intent.putExtra("url", str3);
                intent.putExtra("phone", Bw.e(this.f4270a.getContext()).k());
                intent.putExtra("extras", str2);
                C1480xl xlVar = C1480xl.f7038a;
                xlVar.f7042a.getBankId();
                this.f4270a.getActivity().startActivityForResult(intent, xlVar.f7042a.getBankId());
            }
        }
    }

    public final void finalize() throws Throwable {
        super.finalize();
        ProgressDialog progressDialog = this.f4269a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4269a.dismiss();
        }
        C0535I5.u();
    }

    public final void l(String str, String str2, String str3, String str4, String str5) {
        try {
            int bankId = C1480xl.f7038a.f7042a.getBankId();
            WebView webView2 = new WebView(this);
            this.webView = webView2;
            webView2.getSettings().setJavaScriptEnabled(true);
            if (bankId == 131 || bankId == 139) {
                this.webView.getSettings().setDomStorageEnabled(true);
            }
            this.webView.addJavascriptInterface(new B(this, bankId), str3);
            this.webView.setWebViewClient(new C1483xp(this));
            String str6 = str4 + "=" + str;
            if (!(str5 == null || str5 == "")) {
                str6 = str6 + str5;
            }
            this.webView.postUrl(str2, str6.getBytes());
            setContentView((View) this.webView);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public final void onBackPressed() {
        C0535I5.p(this, false, getString(R.string.cancel_txn_msg), getString(R.string.cancel_txn_head), getString(R.string.yes), new a(), getString(R.string.no), new b()).show();
    }

    public final void onCreate(Bundle bundle) {
        C1225kp kpVar;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_pg_web_view);
        ButterKnife.bind((Activity) this);
        String string = getIntent().getExtras().getString("bill");
        String string2 = getIntent().getExtras().getString("url");
        String string3 = getIntent().getExtras().getString("extras");
        C1480xl xlVar = C1480xl.f7038a;
        if (xlVar == null || (kpVar = xlVar.f7042a) == null) {
            Intent intent = new Intent();
            intent.putExtra("bankresponse", "device_back_button");
            setResult(-1, intent);
            C0535I5.t0(this, "Something went wrong! please try again...");
            finish();
            return;
        }
        int bankId = kpVar.getBankId();
        if (bankId == 106) {
            l(string, string2, "RZP_MOB_AG", "encdata", string3);
        } else if (bankId == 111) {
            l(string, string2, "PHPE_MOB_AG", "token", string3);
        } else if (bankId == 118) {
            l(string, string2, "IRCTC_MOB_AG", "encdata", string3);
        } else if (bankId == 77) {
            l(string, string2, "PAYTM_SDK", "ENC_DATA", string3);
        } else if (bankId == 101) {
            l(string, string2, "ZKPY_MOB_AG", "encdata", string3);
        } else if (bankId == 119) {
            l(string, string2, "PAYTM_MOB_UPI", "ENC_DATA", string3);
        } else if (bankId == 120) {
            l(string, string2, "ICICI_MOB_CR", "encdata", string3);
        } else if (bankId == 122) {
            l(string, string2, "HDFC_MOB_AG", "encdata", string3);
        } else if (bankId == 121) {
            l(string, string2, "AIRP_MOB_AG", "encdata", string3);
        } else if (bankId == 124) {
            l(string, string2, "AMEX_MOB_CR", "bdaesk3.msg", string3);
        } else if (bankId == 125) {
            l(string, string2, "INDS_MOB_AG", "encdata", string3);
        } else if (bankId == 140) {
            l(string, string2, "PAYGLOCAL_MOB_AG", "encdata", string3);
        } else if (bankId == 138) {
            l(string, string2, "SAFEXPAY_MOB_AG", "encdata", string3);
        } else if (bankId == 142) {
            l(string, string2, "SBIEPAY_MOB_AG", "encdata", string3);
        } else if (bankId == 147) {
            l(string, string2, "CASHFREE_MOB_AG", "encdata", string3);
        } else if (bankId == 152) {
            l(string, string2, "BHARI_MOB_AG", "encdata", string3);
        } else if (bankId == 144) {
            l(string, string2, "EASEBUZZ_MOB_AG", "encdata", string3);
        } else if (bankId == 127) {
            l(string, string2, "EPAY_MOB_COD", "encdata", string3);
        } else if (bankId == 131) {
            l(string, string2, "STSH_MOB_COD", "encdata", string3);
        } else if (bankId == 135) {
            l(string, string2, "PAYTM_MOBILE_COD", "encdata", string3);
        } else if (bankId == 133) {
            l(string, string2, "PINE_MOB_EMI", "encdata", string3);
        } else if (bankId == 139) {
            l(string, string2, "CASHE_MOB_EMI", "encdata", string3);
        } else if (bankId == 141) {
            l(string, string2, "RZP_MOB_UPI", "encdata", string3);
        } else if (bankId == 148) {
            l(string, string2, "BAJAJEM_MOB_AG", "encdata", string3);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        C0535I5.I(this);
        ProgressDialog progressDialog = this.f4269a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4269a.dismiss();
        }
        C0535I5.u();
    }

    public final void onPause() {
        super.onPause();
        getWindow().setFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE, UserMetadata.MAX_INTERNAL_KEY_SIZE);
        C0535I5.I(this);
        ProgressDialog progressDialog = this.f4269a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4269a.dismiss();
        }
        C0535I5.u();
    }

    public final void onResume() {
        super.onResume();
        getWindow().clearFlags(UserMetadata.MAX_INTERNAL_KEY_SIZE);
    }

    public final void onStop() {
        super.onStop();
        C0535I5.I(this);
        ProgressDialog progressDialog = this.f4269a;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f4269a.dismiss();
        }
        C0535I5.u();
    }

    public final void b() {
    }

    public final void c(String str) {
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }
}
