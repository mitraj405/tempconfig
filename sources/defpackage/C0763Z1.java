package defpackage;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.paytm.easypay.EasypayBrowserFragment;
import java.util.Map;

/* renamed from: Z1  reason: default package and case insensitive filesystem */
/* compiled from: AutoFiller */
public final class C0763Z1 implements Runnable {
    public final /* synthetic */ Y1 a;
    public final /* synthetic */ String c;

    public C0763Z1(Y1 y1, String str) {
        this.a = y1;
        this.c = str;
    }

    public final void run() {
        Y1 y1 = this.a;
        InputMethodManager inputMethodManager = (InputMethodManager) y1.f3843a.getSystemService("input_method");
        String str = this.c;
        Boolean valueOf = Boolean.valueOf(str.equals("true"));
        int i = C0501Er.autoFillerHelperHeader;
        EasypayBrowserFragment easypayBrowserFragment = y1.f3846a;
        easypayBrowserFragment.e(i, valueOf);
        boolean equals = str.equals("true");
        EditText editText = y1.f3845a;
        Map<String, String> map = y1.f3848a;
        if (equals) {
            String string = easypayBrowserFragment.f4070a.getString(C0709Uj.j(new StringBuilder(), y1.f3847a, "_flag"), "true");
            y1.f3843a.findViewById(C0501Er.auto_fill_head).setVisibility(8);
            string.equals("true");
            editText.requestFocus();
            inputMethodManager.showSoftInput(editText, 1);
            easypayBrowserFragment.logEvent("enabled", map.get(FacebookMediationAdapter.KEY_ID));
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
        String str2 = map.get("autoProceed");
        if (str2 != null && str2.equals("true")) {
            StringBuilder J = xx.J(C1058d.z("javascript:" + map.get("functionStart"), "autoSubmitForm();"));
            J.append(map.get("functionEnd"));
            y1.f3844a.loadUrl(J.toString());
        }
        easypayBrowserFragment.logEvent("disabled", map.get(FacebookMediationAdapter.KEY_ID));
    }
}
