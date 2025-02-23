package defpackage;

import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;

/* renamed from: ro  reason: default package and case insensitive filesystem */
/* compiled from: OtpHelper */
public final class C1371ro implements TextWatcher {
    public final /* synthetic */ C1306oo a;

    public C1371ro(C1306oo ooVar) {
        this.a = ooVar;
    }

    public final void afterTextChanged(Editable editable) {
        boolean z;
        C1306oo ooVar = this.a;
        Button button = (Button) ooVar.a.findViewById(C0501Er.buttonApproveOtp);
        String obj = editable.toString();
        if (obj.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        Boolean valueOf = Boolean.valueOf(z);
        button.setEnabled(valueOf.booleanValue());
        if (valueOf.booleanValue()) {
            button.setActivated(true);
            ooVar.f5640a.setTypeface((Typeface) null, 1);
        } else {
            button.setActivated(false);
            ooVar.f5640a.setTypeface((Typeface) null, 0);
        }
        StringBuilder J = xx.J(C1058d.z("javascript:" + ooVar.f5645a.get("functionStart"), ooVar.f5644a + "if(fields.length){fields[0].value='" + obj + "';};"));
        J.append(ooVar.f5645a.get("functionEnd"));
        ooVar.f5639a.loadUrl(J.toString());
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
