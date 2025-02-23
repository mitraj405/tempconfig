package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import android.graphics.Color;
import cris.org.in.prs.ima.R;
import rx.Subscriber;

/* compiled from: UpdateProfileFragment */
public final class N0 extends Subscriber<C0812c0> {
    public final /* synthetic */ UpdateProfileFragment a;
    public final /* synthetic */ String c;

    public N0(UpdateProfileFragment updateProfileFragment, String str) {
        this.a = updateProfileFragment;
        this.c = str;
    }

    public final void onCompleted() {
        int i = UpdateProfileFragment.c;
        this.a.f5183a.dismiss();
    }

    public final void onError(Throwable th) {
        int i = UpdateProfileFragment.c;
        th.getClass();
        th.getMessage();
        this.a.f5183a.dismiss();
        Lt.a(false, th);
    }

    public final void onNext(Object obj) {
        C0812c0 c0Var = (C0812c0) obj;
        int i = UpdateProfileFragment.c;
        UpdateProfileFragment updateProfileFragment = this.a;
        if (c0Var != null) {
            c0Var.toString();
            String error = c0Var.getError();
            String str = this.c;
            if (error == null) {
                updateProfileFragment.f5187a.clear();
                updateProfileFragment.b.clear();
                for (int i2 = 0; i2 < c0Var.getCityList().size(); i2++) {
                    updateProfileFragment.f5187a.add(c0Var.getCityList().get(i2));
                }
                updateProfileFragment.state.setTextColor(Color.parseColor("#fea018"));
                updateProfileFragment.e = str;
            } else {
                updateProfileFragment.e = str;
                updateProfileFragment.f5187a.clear();
                updateProfileFragment.b.clear();
                updateProfileFragment.state.setText((CharSequence) null);
                updateProfileFragment.pincode.setError(c0Var.getError());
                updateProfileFragment.f5183a.dismiss();
                C0535I5.m(updateProfileFragment.f5185a, true, c0Var.getError(), updateProfileFragment.getString(R.string.error), updateProfileFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            }
        } else {
            updateProfileFragment.pincode.setError("");
        }
        updateProfileFragment.f5183a.dismiss();
    }
}
