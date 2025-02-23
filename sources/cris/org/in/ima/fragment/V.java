package cris.org.in.ima.fragment;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import cris.org.in.prs.ima.R;
import defpackage.C1421u9;

/* compiled from: MakePaymentNewFragment */
public final class V extends C1421u9.a {
    public final /* synthetic */ MakePaymentNewFragment a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public V(MakePaymentNewFragment makePaymentNewFragment, EditText editText) {
        super(editText);
        this.a = makePaymentNewFragment;
    }

    public final void a() {
        MakePaymentNewFragment makePaymentNewFragment = this.a;
        if (makePaymentNewFragment.ewalletTxnPassword.getInputType() == 145) {
            makePaymentNewFragment.ewalletTxnPassword.setInputType(129);
            EditText editText = makePaymentNewFragment.ewalletTxnPassword;
            editText.setSelection(editText.getText().length());
            makePaymentNewFragment.ewalletTxnPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.visibility_off, 0);
            return;
        }
        makePaymentNewFragment.ewalletTxnPassword.setInputType(145);
        EditText editText2 = makePaymentNewFragment.ewalletTxnPassword;
        editText2.setSelection(editText2.getText().length());
        makePaymentNewFragment.ewalletTxnPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.visibility, 0);
        for (Drawable drawable : makePaymentNewFragment.ewalletTxnPassword.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(makePaymentNewFragment.getContext().getResources().getColor(R.color.black_90_opa), PorterDuff.Mode.SRC_IN));
            }
        }
    }
}
