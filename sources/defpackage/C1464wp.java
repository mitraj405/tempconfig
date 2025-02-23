package defpackage;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.ima.fragment.MakeMppPaymentFragment;
import java.util.ArrayList;

/* renamed from: wp  reason: default package and case insensitive filesystem */
/* compiled from: PgApiMppService */
public final class C1464wp implements C1245lp {
    public Fragment a;

    static {
        C1354qp.R(C1464wp.class);
    }

    public final Fragment a() {
        return this.a;
    }

    public final void e() {
        String str;
        ArrayList<Do> paramList = C1480xl.f7038a.f7042a.getParamList();
        try {
            Bundle bundle = new Bundle();
            int i = 0;
            while (paramList != null && i < paramList.size()) {
                paramList.get(i).getKey();
                paramList.get(i).getValue();
                if (paramList.get(i).getKey() != null) {
                    if (paramList.get(i).getKey().equalsIgnoreCase("SAVED_CARDS")) {
                        bundle.putString("saved_cards", paramList.get(i).getValue());
                    } else if (paramList.get(i).getKey().equalsIgnoreCase("NETBANKING")) {
                        bundle.putString("netbanking", paramList.get(i).getValue());
                    } else if (paramList.get(i).getKey().equalsIgnoreCase("ENABLED_CARDS")) {
                        bundle.putString("enabled_cards", paramList.get(i).getValue());
                    } else if (paramList.get(i).getKey().equalsIgnoreCase("NETBANK_ENABLE")) {
                        bundle.putString("netbanking_flag", paramList.get(i).getValue());
                    } else if (paramList.get(i).getKey().equalsIgnoreCase("CARD_PAYMENT_ENABLE")) {
                        bundle.putString("card_flag", paramList.get(i).getValue());
                    } else if (paramList.get(i).getKey().equalsIgnoreCase("WALLET_ENABLE")) {
                        bundle.putString("wallet_flag", paramList.get(i).getValue());
                    }
                }
                i++;
            }
            MakeMppPaymentFragment makeMppPaymentFragment = new MakeMppPaymentFragment();
            C1480xl xlVar = C1480xl.f7038a;
            boolean z = xlVar.f7044a;
            makeMppPaymentFragment.setArguments(bundle);
            if (xlVar.f7042a.getBankId() == 101) {
                str = "MobiKwik";
            } else if (xlVar.f7042a.getBankId() == 108) {
                str = "PayU";
            } else {
                str = null;
            }
            HomeActivity.n(this.a.getActivity(), makeMppPaymentFragment, str, Boolean.TRUE, Boolean.FALSE);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public final void b() {
    }

    public final void c(String str) {
    }
}
