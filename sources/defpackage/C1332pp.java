package defpackage;

import android.content.DialogInterface;
import androidx.fragment.app.Fragment;
import com.paytm.pgsdk.PaymentSdkMainClass;
import com.paytm.pgsdk.PaytmClientCertificate;
import com.paytm.pgsdk.PaytmMerchant;
import cris.org.in.prs.ima.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* renamed from: pp  reason: default package and case insensitive filesystem */
/* compiled from: PaytmService */
public final class C1332pp implements C1245lp {
    public static final /* synthetic */ int c = 0;
    public Fragment a;

    static {
        C1354qp.R(C1332pp.class);
    }

    public final Fragment a() {
        return this.a;
    }

    public final void e() {
        String str;
        ArrayList<Do> paramList = C1480xl.f7038a.f7042a.getParamList();
        String str2 = "THEME";
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String str3 = "";
            int i = 0;
            boolean z = true;
            boolean z2 = true;
            boolean z3 = true;
            boolean z4 = true;
            boolean z5 = true;
            String str4 = str3;
            boolean z6 = false;
            boolean z7 = false;
            while (paramList != null) {
                if (i >= paramList.size()) {
                    break;
                }
                paramList.get(i).getKey();
                paramList.get(i).getValue();
                if (paramList.get(i).getKey().equalsIgnoreCase("ORDER_ID")) {
                    linkedHashMap.put("ORDER_ID", paramList.get(i).getValue());
                } else if (paramList.get(i).getKey().equalsIgnoreCase("MID")) {
                    linkedHashMap.put("MID", paramList.get(i).getValue());
                } else if (paramList.get(i).getKey().equalsIgnoreCase("CUST_ID")) {
                    linkedHashMap.put("CUST_ID", paramList.get(i).getValue());
                } else if (paramList.get(i).getKey().equalsIgnoreCase("CHANNEL_ID")) {
                    linkedHashMap.put("CHANNEL_ID", paramList.get(i).getValue());
                } else if (paramList.get(i).getKey().equalsIgnoreCase("INDUSTRY_TYPE_ID")) {
                    linkedHashMap.put("INDUSTRY_TYPE_ID", paramList.get(i).getValue());
                } else if (paramList.get(i).getKey().equalsIgnoreCase("WEBSITE")) {
                    linkedHashMap.put("WEBSITE", paramList.get(i).getValue());
                } else if (paramList.get(i).getKey().equalsIgnoreCase("TXN_AMOUNT")) {
                    linkedHashMap.put("TXN_AMOUNT", paramList.get(i).getValue());
                } else if (paramList.get(i).getKey().equalsIgnoreCase(str2)) {
                    linkedHashMap.put(str2, paramList.get(i).getValue());
                } else {
                    str = str2;
                    if (paramList.get(i).getKey().equalsIgnoreCase("GEN_URL")) {
                        str3 = paramList.get(i).getValue();
                    } else if (paramList.get(i).getKey().equalsIgnoreCase("VERIFY_URL")) {
                        str4 = paramList.get(i).getValue();
                    } else if (paramList.get(i).getKey().equalsIgnoreCase("STAGING")) {
                        z5 = Boolean.valueOf(paramList.get(i).getValue()).booleanValue();
                    } else if (paramList.get(i).getKey().equalsIgnoreCase("HIDE_ARROW")) {
                        z4 = Boolean.valueOf(paramList.get(i).getValue()).booleanValue();
                    } else if (paramList.get(i).getKey().equalsIgnoreCase("ALLOW_EASY_PAY")) {
                        z7 = Boolean.valueOf(paramList.get(i).getValue()).booleanValue();
                    } else if (paramList.get(i).getKey().equalsIgnoreCase("ENABLE_WALLET_ONLY")) {
                        z6 = Boolean.valueOf(paramList.get(i).getValue()).booleanValue();
                    } else if (paramList.get(i).getKey().equalsIgnoreCase("CCENABLE")) {
                        z = Boolean.valueOf(paramList.get(i).getValue()).booleanValue();
                    } else if (paramList.get(i).getKey().equalsIgnoreCase("NBENABLE")) {
                        z2 = Boolean.valueOf(paramList.get(i).getValue()).booleanValue();
                    } else if (paramList.get(i).getKey().equalsIgnoreCase("WALLETENABLE")) {
                        z3 = Boolean.valueOf(paramList.get(i).getValue()).booleanValue();
                    }
                    i++;
                    str2 = str;
                }
                str = str2;
                i++;
                str2 = str;
            }
            linkedHashMap.put("EMAIL", Bw.e(this.a.getContext()).j());
            linkedHashMap.put("MSISDN", Bw.e(this.a.getContext()).k());
            PaymentSdkMainClass paymentSdkMainClass = new PaymentSdkMainClass(this.a.getContext());
            PaytmClientCertificate paytmClientCertificate = new PaytmClientCertificate("admin", "client");
            PaytmMerchant paytmMerchant = new PaytmMerchant(str3, str4);
            paymentSdkMainClass.setResIdAppIcon(R.drawable.ic_launcher);
            paymentSdkMainClass.setDyanamicValues(z, z2, z3, z6, "#0096b1");
            paymentSdkMainClass.pay(linkedHashMap, paytmMerchant, z4, paytmClientCertificate, z5, z7, new C1307op(this));
        } catch (Exception e) {
            e.getMessage();
            C0535I5.m(this.a.getContext(), false, "Unable to process payment, please try again.", this.a.getContext().getString(R.string.error), "OK", (DialogInterface.OnClickListener) null).show();
        }
    }

    public final void finalize() throws Throwable {
        super.finalize();
        C0535I5.u();
    }

    public final void b() {
    }

    public final void c(String str) {
    }
}
