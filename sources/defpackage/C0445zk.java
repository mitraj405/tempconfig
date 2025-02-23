package defpackage;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.google.android.material.datepicker.MaterialDatePicker;
import cris.org.in.ima.fragment.NewBookingFragment;

/* renamed from: zk  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0445zk implements View.OnClickListener {
    public final /* synthetic */ Fragment a;
    public final /* synthetic */ int c;

    public /* synthetic */ C0445zk(Fragment fragment, int i) {
        this.c = i;
        this.a = fragment;
    }

    public final void onClick(View view) {
        int i = this.c;
        Fragment fragment = this.a;
        switch (i) {
            case 0:
                ((MaterialDatePicker) fragment).lambda$initHeaderToggle$0(view);
                return;
            default:
                NewBookingFragment.f((NewBookingFragment) fragment);
                return;
        }
    }
}
