package defpackage;

import android.content.DialogInterface;
import androidx.fragment.app.Fragment;
import cris.org.in.prs.ima.R;
import cris.prs.webservices.dto.StatusDTO;
import rx.Subscriber;

/* renamed from: Nl  reason: default package */
/* compiled from: MobilePayment */
public final class Nl implements Runnable {
    public final /* synthetic */ Fragment a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1480xl f3714a;

    /* renamed from: Nl$a */
    /* compiled from: MobilePayment */
    public class a extends Subscriber<StatusDTO> {
        public a() {
        }

        public final void onCompleted() {
            Boolean bool = C1480xl.a;
            Nl.this.f3714a.f7040a.dismiss();
        }

        public final void onError(Throwable th) {
            Boolean bool = C1480xl.a;
            th.getClass();
            th.getMessage();
            Nl.this.f3714a.f7040a.dismiss();
            Lt.a(true, th);
        }

        public final void onNext(Object obj) {
            StatusDTO statusDTO = (StatusDTO) obj;
            Nl nl = Nl.this;
            if (statusDTO != null) {
                C0657Qt.h();
                try {
                    if (statusDTO.getError() != null && statusDTO.getError().length() > 0) {
                        Fragment fragment = nl.a;
                        Fragment fragment2 = nl.a;
                        C0535I5.m(fragment.getContext(), false, statusDTO.getError(), fragment2.getContext().getString(R.string.error), fragment2.getContext().getString(R.string.ok), (DialogInterface.OnClickListener) null).show();
                    } else if (statusDTO.getStatus() != null && statusDTO.getStatus().indexOf("=") == -1) {
                        Fragment fragment3 = nl.a;
                        Fragment fragment4 = nl.a;
                        C0535I5.p(fragment3.getContext(), false, statusDTO.getStatus(), fragment4.getContext().getString(R.string.info), fragment4.getContext().getString(R.string.OK), new C0598Ml(this), (String) null, (DialogInterface.OnClickListener) null).show();
                    }
                    nl.f3714a.f7040a.dismiss();
                } catch (Exception e) {
                    nl.f3714a.f7040a.dismiss();
                    Boolean bool = C1480xl.a;
                    e.getMessage();
                }
                Boolean bool2 = C1480xl.a;
                statusDTO.toString();
            }
            nl.f3714a.f7040a.dismiss();
        }
    }

    public Nl(C1480xl xlVar, Fragment fragment) {
        this.f3714a = xlVar;
        this.a = fragment;
    }

    public final void run() {
        C1507z0.b();
        Om om = (Om) C0657Qt.c(C0793b1.a.f3912a);
        String f = C0657Qt.f();
        if (C1450w1.f7032f) {
            f = C0657Qt.k();
        }
        C1480xl xlVar = this.f3714a;
        om.P(xx.D(f, "verifyPayment", String.format("/%s", new Object[]{xlVar.f7041a})), xlVar.f7042a).c(C1181iv.a()).a(E0.a()).b(new a());
    }
}
