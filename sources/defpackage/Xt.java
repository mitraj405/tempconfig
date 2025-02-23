package defpackage;

import android.content.DialogInterface;
import com.fasterxml.jackson.databind.ObjectMapper;
import cris.org.in.ima.fragment.ReviewAndPayFragment;
import cris.org.in.prs.ima.R;
import rx.Subscriber;

/* renamed from: Xt  reason: default package */
/* compiled from: ReviewAndPayFragment */
public final class Xt extends Subscriber<E4> {
    public final /* synthetic */ ReviewAndPayFragment a;

    public Xt(ReviewAndPayFragment reviewAndPayFragment) {
        this.a = reviewAndPayFragment;
    }

    public final void onCompleted() {
        String str = ReviewAndPayFragment.x;
    }

    public final void onError(Throwable th) {
        String str = ReviewAndPayFragment.x;
        th.getClass();
        th.getMessage();
        this.a.a.dismiss();
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        E4 e4 = (E4) obj;
        ReviewAndPayFragment reviewAndPayFragment = this.a;
        if (e4 != null) {
            ObjectMapper h = C0657Qt.h();
            try {
                if (e4.getError() == null) {
                    C1450w1.f7025d = System.currentTimeMillis();
                    h.writeValueAsString(e4);
                    String str = ReviewAndPayFragment.x;
                    C0535I5.o(reviewAndPayFragment.getActivity(), e4.getStatus(), reviewAndPayFragment.getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
                    reviewAndPayFragment.a.dismiss();
                    return;
                }
                reviewAndPayFragment.a.dismiss();
                C0535I5.m(reviewAndPayFragment.getActivity(), false, e4.getError(), reviewAndPayFragment.getString(R.string.error), reviewAndPayFragment.getString(R.string.OK), reviewAndPayFragment.f5079a).show();
            } catch (Exception e) {
                reviewAndPayFragment.a.dismiss();
                String str2 = ReviewAndPayFragment.x;
                e.getMessage();
            }
        } else {
            reviewAndPayFragment.a.dismiss();
            C0535I5.m(reviewAndPayFragment.getActivity(), false, reviewAndPayFragment.getResources().getString(R.string.unable_process_message), reviewAndPayFragment.getString(R.string.error), reviewAndPayFragment.getString(R.string.OK), reviewAndPayFragment.f5078a).show();
        }
    }
}
