package cris.org.in.ima.payment;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import cris.org.in.prs.ima.R;
import java.util.ArrayList;

public class CashOnDeliveryActivity extends AppCompatActivity implements C1245lp {
    public static final CashOnDeliveryActivity a = new CashOnDeliveryActivity();

    /* renamed from: a  reason: collision with other field name */
    public Fragment f5355a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5356a = false;
    @BindView(2131364915)
    WebView webView;

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            Intent intent = new Intent();
            intent.putExtra("codresponse", "device_back_button");
            int bankId = C1480xl.f7038a.f7042a.getBankId();
            CashOnDeliveryActivity cashOnDeliveryActivity = CashOnDeliveryActivity.this;
            cashOnDeliveryActivity.setResult(bankId, intent);
            C0535I5.u0(cashOnDeliveryActivity);
            cashOnDeliveryActivity.finish();
        }
    }

    public interface c {
        @JavascriptInterface
        void onPaymentDone(String str);
    }

    static {
        C1354qp.R(CashOnDeliveryActivity.class);
    }

    public final Fragment a() {
        return this.f5355a;
    }

    public final void e() {
        ArrayList<Do> paramList = C1480xl.f7038a.f7042a.getParamList();
        if (paramList != null) {
            if (paramList.get(0) != null) {
                String str = null;
                String str2 = null;
                for (int i = 0; i < paramList.size(); i++) {
                    if (paramList.get(i).getKey().equalsIgnoreCase("ENC_DATA")) {
                        str = paramList.get(i).getValue();
                    } else if (paramList.get(i).getKey().equalsIgnoreCase("COD_URL")) {
                        str2 = paramList.get(i).getValue();
                    }
                }
                C1480xl xlVar = C1480xl.f7038a;
                xlVar.f7042a.getBankId();
                Intent intent = new Intent(this.f5355a.getActivity(), CashOnDeliveryActivity.class);
                intent.putExtra("enc_data", str);
                intent.putExtra("url", str2);
                this.f5355a.getActivity().startActivityForResult(intent, xlVar.f7042a.getBankId());
            }
        }
    }

    public final void onBackPressed() {
        C0535I5.p(this, false, getString(R.string.cancel_txn_msg), getString(R.string.cancel_txn_head), getString(R.string.yes), new a(), getString(R.string.no), new b()).show();
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_cash_on_delivery);
        ButterKnife.bind((Activity) this);
        String string = getIntent().getExtras().getString("enc_data");
        String string2 = getIntent().getExtras().getString("url");
        try {
            new StringBuffer(string2);
            this.webView = new WebView(this);
            Base64.encodeToString(string.getBytes(), 0);
            this.webView.getSettings().setJavaScriptEnabled(true);
            this.webView.addJavascriptInterface(new a(this), "CashOnDelivery");
            this.webView.setWebViewClient(new K4(this));
            this.webView.postUrl(string2, ("encdata=" + string).getBytes());
            setContentView((View) this.webView);
        } catch (Exception e) {
            e.getMessage();
        }
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
