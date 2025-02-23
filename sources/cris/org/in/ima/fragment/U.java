package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import android.view.View;
import cris.org.in.prs.ima.R;

/* compiled from: MakeMppPaymentFragment */
public final class U implements View.OnFocusChangeListener {
    public final /* synthetic */ MakeMppPaymentFragment a;

    public U(MakeMppPaymentFragment makeMppPaymentFragment) {
        this.a = makeMppPaymentFragment;
    }

    public final void onFocusChange(View view, boolean z) {
        if (!z) {
            MakeMppPaymentFragment makeMppPaymentFragment = this.a;
            String obj = makeMppPaymentFragment.cvvNo.getText().toString();
            boolean equalsIgnoreCase = "amex".equalsIgnoreCase(makeMppPaymentFragment.e);
            boolean equalsIgnoreCase2 = "maestro".equalsIgnoreCase(makeMppPaymentFragment.e);
            if (obj.length() == 0) {
                if (!equalsIgnoreCase2) {
                    C0535I5.m(makeMppPaymentFragment.getActivity(), false, "Enter valid CVV", makeMppPaymentFragment.getString(R.string.error), "OK", (DialogInterface.OnClickListener) null).show();
                    makeMppPaymentFragment.c++;
                }
            } else if ((!equalsIgnoreCase && obj.length() != 3) || (equalsIgnoreCase && obj.length() != 4)) {
                C0535I5.m(makeMppPaymentFragment.getActivity(), false, "Enter valid CVV", makeMppPaymentFragment.getString(R.string.error), "OK", (DialogInterface.OnClickListener) null).show();
                makeMppPaymentFragment.c++;
            }
        }
    }
}
