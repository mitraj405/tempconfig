package defpackage;

import android.app.Dialog;
import android.os.Bundle;
import androidx.appcompat.app.f;
import androidx.fragment.app.DialogFragment;

/* renamed from: n1  reason: default package */
/* compiled from: AppCompatDialogFragment */
public class n1 extends DialogFragment {
    public n1() {
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return new f(getContext(), getTheme());
    }

    public void setupDialog(Dialog dialog, int i) {
        if (dialog instanceof f) {
            f fVar = (f) dialog;
            if (!(i == 1 || i == 2)) {
                if (i == 3) {
                    dialog.getWindow().addFlags(24);
                } else {
                    return;
                }
            }
            fVar.supportRequestWindowFeature(1);
            return;
        }
        super.setupDialog(dialog, i);
    }

    public n1(int i) {
        super(i);
    }
}
