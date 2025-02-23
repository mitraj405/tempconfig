package defpackage;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.a;
import cris.org.in.prs.ima.R;

/* renamed from: I7  reason: default package */
/* compiled from: CustomAlertDialogFragment */
public class I7 extends DialogFragment {
    public Dialog a;

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(getActivity());
        this.a = dialog;
        dialog.getWindow().requestFeature(1);
        this.a.setContentView(R.layout.custom_alert_dialog);
        ((RecyclerView) this.a.findViewById(R.id.list)).setHasFixedSize(false);
        ((RecyclerView) this.a.findViewById(R.id.list)).setItemAnimator(new a());
        ((RecyclerView) this.a.findViewById(R.id.list)).setLayoutManager(new LinearLayoutManager(getActivity()));
        return this.a;
    }
}
