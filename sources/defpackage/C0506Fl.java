package defpackage;

import android.content.DialogInterface;
import androidx.fragment.app.Fragment;
import com.fasterxml.jackson.databind.ObjectMapper;
import cris.org.in.prs.ima.R;
import rx.Subscriber;

/* renamed from: Fl  reason: default package and case insensitive filesystem */
/* compiled from: MobilePayment */
public final class C0506Fl extends Subscriber<C1225kp> {
    public final /* synthetic */ C1245lp a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1480xl f3588a;

    public C0506Fl(C1480xl xlVar, C1245lp lpVar) {
        this.f3588a = xlVar;
        this.a = lpVar;
    }

    public final void onCompleted() {
        Boolean bool = C1480xl.a;
        this.f3588a.f7040a.dismiss();
    }

    public final void onError(Throwable th) {
        Boolean bool = C1480xl.a;
        th.getClass();
        th.getMessage();
        this.f3588a.f7040a.dismiss();
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        C1225kp kpVar = (C1225kp) obj;
        Boolean bool = C1480xl.a;
        kpVar.getTxnStatus();
        int txnStatus = kpVar.getTxnStatus();
        C1480xl xlVar = this.f3588a;
        xlVar.f7039a = txnStatus;
        ObjectMapper h = C0657Qt.h();
        try {
            C1450w1.e = System.currentTimeMillis();
            h.writeValueAsString(kpVar);
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
                xlVar.f7042a.setTransationId(kpVar.getTransationId());
                lpVar.c(Long.toString(kpVar.getTransationId()));
            } else {
                String errorMsg2 = kpVar.getErrorMsg();
                xlVar.f7040a.dismiss();
                C0535I5.m(lpVar.a().getContext(), false, errorMsg2.split("-")[0], lpVar.a().getContext().getString(R.string.error), "OK", new C0498El(this, errorMsg2)).show();
            }
        } catch (Exception e) {
            xlVar.f7040a.dismiss();
            Boolean bool2 = C1480xl.a;
            e.getMessage();
        }
    }
}
