package cris.org.in.ima.activities;

import android.widget.EditText;
import cris.org.in.prs.ima.R;
import defpackage.C1421u9;

/* compiled from: MasterPassengerNewActivity */
public final class y extends C1421u9.a {
    public final /* synthetic */ MasterPassengerNewActivity a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(MasterPassengerNewActivity masterPassengerNewActivity, EditText editText) {
        super(editText);
        this.a = masterPassengerNewActivity;
    }

    public final void a() {
        MasterPassengerNewActivity masterPassengerNewActivity = this.a;
        if (masterPassengerNewActivity.cardNumber.getInputType() == 18) {
            masterPassengerNewActivity.cardNumber.setInputType(2);
            masterPassengerNewActivity.cardNumber.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.visibility_off, 0);
        } else {
            masterPassengerNewActivity.cardNumber.setInputType(18);
            masterPassengerNewActivity.cardNumber.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.visibility, 0);
        }
        EditText editText = masterPassengerNewActivity.cardNumber;
        editText.setSelection(editText.getText().length());
    }
}
