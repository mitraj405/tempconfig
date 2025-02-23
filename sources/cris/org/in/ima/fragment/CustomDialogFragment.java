package cris.org.in.ima.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.a;
import cris.org.in.prs.ima.R;

public class CustomDialogFragment extends DialogFragment {
    public Dialog a;

    public final RecyclerView f() {
        return (RecyclerView) this.a.findViewById(R.id.list);
    }

    public final TextView g() {
        return (TextView) this.a.findViewById(R.id.title);
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(getActivity());
        this.a = dialog;
        dialog.getWindow().requestFeature(1);
        this.a.setContentView(R.layout.custom_dialog);
        f().setHasFixedSize(false);
        f().setItemAnimator(new a());
        f().setLayoutManager(new LinearLayoutManager(getActivity()));
        return this.a;
    }
}
