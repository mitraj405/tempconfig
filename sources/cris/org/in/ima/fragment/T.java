package cris.org.in.ima.fragment;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import cris.org.in.prs.ima.R;

/* compiled from: MakeMppPaymentFragment */
public final class T implements TextWatcher {
    public final /* synthetic */ MakeMppPaymentFragment a;

    public T(MakeMppPaymentFragment makeMppPaymentFragment) {
        this.a = makeMppPaymentFragment;
    }

    public final void afterTextChanged(Editable editable) {
        String E = C1354qp.E(editable.toString().toString().replaceAll("[^0-9]", ""));
        MakeMppPaymentFragment makeMppPaymentFragment = this.a;
        makeMppPaymentFragment.e = E;
        int i = 3;
        if (makeMppPaymentFragment.e.equalsIgnoreCase("amex")) {
            if (editable.length() > 0 && ((editable.length() == 5 || editable.length() == 12) && makeMppPaymentFragment.a == editable.charAt(editable.length() - 1))) {
                editable.delete(editable.length() - 1, editable.length());
            }
            if (!(editable.length() != 1 && editable.length() == 5 && editable.length() == 12) && makeMppPaymentFragment.a == editable.charAt(editable.length() - 1)) {
                editable.delete(editable.length() - 1, editable.length());
            }
            if (editable.length() > 0 && ((editable.length() == 5 || editable.length() == 12) && Character.isDigit(editable.charAt(editable.length() - 1)) && TextUtils.split(editable.toString(), String.valueOf(makeMppPaymentFragment.a)).length <= 3)) {
                editable.insert(editable.length() - 1, String.valueOf(makeMppPaymentFragment.a));
            }
        } else {
            if (editable.length() > 0 && editable.length() % 5 == 0 && makeMppPaymentFragment.a == editable.charAt(editable.length() - 1)) {
                editable.delete(editable.length() - 1, editable.length());
            }
            if ((editable.length() == 1 || editable.length() % 5 != 0) && makeMppPaymentFragment.a == editable.charAt(editable.length() - 1)) {
                editable.delete(editable.length() - 1, editable.length());
            }
            if (editable.length() > 0 && editable.length() % 5 == 0 && Character.isDigit(editable.charAt(editable.length() - 1)) && TextUtils.split(editable.toString(), String.valueOf(makeMppPaymentFragment.a)).length <= 3) {
                editable.insert(editable.length() - 1, String.valueOf(makeMppPaymentFragment.a));
            }
        }
        String str = makeMppPaymentFragment.e;
        makeMppPaymentFragment.getClass();
        "maestro".equalsIgnoreCase(str);
        boolean equalsIgnoreCase = "amex".equalsIgnoreCase(str);
        makeMppPaymentFragment.cvvNo.setHint("CVV");
        if (equalsIgnoreCase) {
            i = 4;
        }
        makeMppPaymentFragment.cvvNo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        if (makeMppPaymentFragment.e.compareTo("visa") == 0) {
            makeMppPaymentFragment.cardNumber.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.visa, 0);
        } else if (makeMppPaymentFragment.e.compareTo("mastercard") == 0) {
            makeMppPaymentFragment.cardNumber.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.master, 0);
        } else if (makeMppPaymentFragment.e.compareTo("diners") == 0) {
            makeMppPaymentFragment.cardNumber.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.diners, 0);
        } else if (makeMppPaymentFragment.e.compareTo("discover") == 0) {
            makeMppPaymentFragment.cardNumber.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.discover, 0);
        } else if (makeMppPaymentFragment.e.compareTo("maestro") == 0) {
            makeMppPaymentFragment.cardNumber.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.maestro, 0);
        } else if (makeMppPaymentFragment.e.compareTo("amex") == 0) {
            makeMppPaymentFragment.cardNumber.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.amex, 0);
        } else if (makeMppPaymentFragment.e.compareTo("rupay") == 0) {
            makeMppPaymentFragment.cardNumber.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.rupay, 0);
        } else {
            makeMppPaymentFragment.cardNumber.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        if (!makeMppPaymentFragment.f.equals(makeMppPaymentFragment.e)) {
            makeMppPaymentFragment.getResources().getDimension(R.dimen.size16);
        }
        makeMppPaymentFragment.f = makeMppPaymentFragment.e;
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
