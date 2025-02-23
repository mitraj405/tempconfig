package cris.org.in.ima.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import cris.org.in.ima.activities.HomeActivity;
import cris.org.in.prs.ima.R;
import rx.Subscriber;

/* compiled from: VikalpSystemFragment */
public final class O0 extends Subscriber<C0716V1> {
    public final /* synthetic */ VikalpSystemFragment a;

    public O0(VikalpSystemFragment vikalpSystemFragment) {
        this.a = vikalpSystemFragment;
    }

    public final void onCompleted() {
        int i = VikalpSystemFragment.c;
    }

    public final void onError(Throwable th) {
        int i = VikalpSystemFragment.c;
        th.getClass();
        th.getMessage();
        this.a.f5198a.dismiss();
        Mt.a(th);
    }

    public final void onNext(Object obj) {
        C0716V1 v1 = (C0716V1) obj;
        boolean isErrorFlag = v1.isErrorFlag();
        VikalpSystemFragment vikalpSystemFragment = this.a;
        if (!isErrorFlag) {
            try {
                vikalpSystemFragment.f5198a.dismiss();
                if (!v1.isErrorFlag()) {
                    C0535I5.I(vikalpSystemFragment.getActivity());
                    vikalpSystemFragment.verifyOtp.setClickable(false);
                    vikalpSystemFragment.verifyOtp.setTextColor(vikalpSystemFragment.f5199a.getResources().getColor(R.color.black_50_opa));
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("AtasDTO", v1);
                    VikalpTrainListFragment1 vikalpTrainListFragment1 = new VikalpTrainListFragment1();
                    vikalpTrainListFragment1.setArguments(bundle);
                    FragmentActivity activity = vikalpSystemFragment.getActivity();
                    String d = xx.d(5);
                    Boolean bool = Boolean.TRUE;
                    HomeActivity.n(activity, vikalpTrainListFragment1, d, bool, bool);
                    return;
                }
                C0535I5.m(vikalpSystemFragment.f5199a, false, v1.getErrorMsg(), vikalpSystemFragment.getString(R.string.error), vikalpSystemFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                vikalpSystemFragment.vikalpOtp.setText("");
            } catch (Exception e) {
                vikalpSystemFragment.f5198a.dismiss();
                int i = VikalpSystemFragment.c;
                e.getMessage();
            }
        } else {
            vikalpSystemFragment.f5198a.dismiss();
            C0535I5.m(vikalpSystemFragment.f5199a, false, v1.getErrorMsg(), vikalpSystemFragment.getString(R.string.error), vikalpSystemFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
            vikalpSystemFragment.vikalpOtp.setText("");
        }
    }
}
