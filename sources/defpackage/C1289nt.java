package defpackage;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;
import cris.org.in.ima.fragment.C1028i0;
import cris.org.in.ima.fragment.ReleasePanAadhaarFragment;
import cris.org.in.prs.ima.R;
import rx.Subscriber;

/* renamed from: nt  reason: default package and case insensitive filesystem */
/* compiled from: ReleasePanAadhaarFragment */
public final class C1289nt extends Subscriber<C1215kb> {
    public final /* synthetic */ ReleasePanAadhaarFragment a;

    public C1289nt(ReleasePanAadhaarFragment releasePanAadhaarFragment) {
        this.a = releasePanAadhaarFragment;
    }

    public final void onCompleted() {
        int i = ReleasePanAadhaarFragment.c;
    }

    public final void onError(Throwable th) {
        this.a.a.dismiss();
        int i = ReleasePanAadhaarFragment.c;
        xx.S(th, true, th);
    }

    public final void onNext(Object obj) {
        C1215kb kbVar = (C1215kb) obj;
        int i = ReleasePanAadhaarFragment.c;
        ReleasePanAadhaarFragment releasePanAadhaarFragment = this.a;
        if (kbVar != null) {
            try {
                releasePanAadhaarFragment.f5071a = kbVar;
                if (kbVar.isFlag()) {
                    C1246lt ltVar = new C1246lt(this);
                    FragmentActivity activity = releasePanAadhaarFragment.getActivity();
                    C0535I5.p(activity, false, releasePanAadhaarFragment.getString(R.string.eWallet_Deactivate_Account) + "\n\n" + releasePanAadhaarFragment.getString(R.string.ewallet_deactivated_succesfully1), releasePanAadhaarFragment.getString(R.string.eWallet_Deactivate_Account), releasePanAadhaarFragment.getString(R.string.OK), ltVar, (String) null, (DialogInterface.OnClickListener) null).show();
                } else {
                    C0535I5.m(releasePanAadhaarFragment.getActivity(), false, kbVar.getStatus(), releasePanAadhaarFragment.getString(R.string.error), releasePanAadhaarFragment.getString(R.string.OK), new C1028i0(this)).show();
                }
            } catch (Exception e) {
                int i2 = ReleasePanAadhaarFragment.c;
                e.getMessage();
            } catch (Throwable th) {
                releasePanAadhaarFragment.a.dismiss();
                throw th;
            }
            releasePanAadhaarFragment.a.dismiss();
            return;
        }
        releasePanAadhaarFragment.a.dismiss();
        C0535I5.m(releasePanAadhaarFragment.getActivity(), false, releasePanAadhaarFragment.getString(R.string.unble_to_request_try_sometime), releasePanAadhaarFragment.getString(R.string.error), releasePanAadhaarFragment.getString(R.string.OK), new C1264mt()).show();
    }
}
