package defpackage;

import android.content.DialogInterface;
import androidx.fragment.app.Fragment;
import cris.org.in.prs.ima.R;
import rx.Subscriber;

/* renamed from: Gl  reason: default package and case insensitive filesystem */
/* compiled from: MobilePayment */
public final class C0522Gl extends Subscriber<C1225kp> {
    public final /* synthetic */ C1245lp a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1480xl f3602a;

    public C0522Gl(C1480xl xlVar, C1245lp lpVar) {
        this.f3602a = xlVar;
        this.a = lpVar;
    }

    public final void onCompleted() {
        Boolean bool = C1480xl.a;
        this.f3602a.f7040a.dismiss();
    }

    public final void onError(Throwable th) {
        Boolean bool = C1480xl.a;
        th.getClass();
        th.getMessage();
        this.f3602a.f7040a.dismiss();
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        C1225kp kpVar = (C1225kp) obj;
        Boolean bool = C1480xl.a;
        kpVar.getTxnStatus();
        int txnStatus = kpVar.getTxnStatus();
        C1480xl xlVar = this.f3602a;
        xlVar.f7039a = txnStatus;
        try {
            C0657Qt.h().writeValueAsString(kpVar);
            xlVar.f7040a.dismiss();
            int txnStatus2 = kpVar.getTxnStatus();
            int i = C1480xl.c;
            C1245lp lpVar = this.a;
            if (txnStatus2 == i) {
                Fragment a2 = lpVar.a();
                String errorMsg = kpVar.getErrorMsg();
                kpVar.getTxnStatus();
                C0535I5.m(a2.getContext(), false, errorMsg, a2.getContext().getString(R.string.error), "OK", (DialogInterface.OnClickListener) null).show();
            } else if (kpVar.getErrorMsg() == null) {
                xlVar.f7042a.setParamList(kpVar.getParamList());
                lpVar.e();
            }
        } catch (Exception e) {
            xlVar.f7040a.dismiss();
            Boolean bool2 = C1480xl.a;
            e.getMessage();
        }
    }
}
