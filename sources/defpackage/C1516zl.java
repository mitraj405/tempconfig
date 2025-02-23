package defpackage;

import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.TextView;
import cris.org.in.ima.fragment.MakePaymentNewFragment;
import cris.org.in.prs.ima.R;
import rx.Subscriber;

/* renamed from: zl  reason: default package and case insensitive filesystem */
/* compiled from: MobilePayment */
public final class C1516zl extends Subscriber<C1432ux> {
    public final /* synthetic */ EditText a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ TextView f7105a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1245lp f7106a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1480xl f7107a;
    public final /* synthetic */ EditText b;

    public C1516zl(C1480xl xlVar, EditText editText, TextView textView, C1245lp lpVar, EditText editText2) {
        this.f7107a = xlVar;
        this.a = editText;
        this.f7105a = textView;
        this.f7106a = lpVar;
        this.b = editText2;
    }

    public final void onCompleted() {
        Boolean bool = C1480xl.a;
        this.f7107a.f7040a.dismiss();
    }

    public final void onError(Throwable th) {
        Boolean bool = C1480xl.a;
        th.getClass();
        th.getMessage();
        this.f7107a.f7040a.dismiss();
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        C1432ux uxVar = (C1432ux) obj;
        Boolean bool = C1480xl.a;
        C1480xl xlVar = this.f7107a;
        xlVar.f7040a.dismiss();
        if (uxVar != null) {
            uxVar.toString();
            String errorMessage = uxVar.getSoftPointsPurchaseView().getErrorMessage();
            C1245lp lpVar = this.f7106a;
            if (errorMessage == null) {
                EditText editText = this.a;
                if (editText != null) {
                    editText.setEnabled(true);
                }
                TextView textView = this.f7105a;
                if (textView != null) {
                    textView.setText(lpVar.a().getString(R.string.resend_otp));
                }
                EditText editText2 = this.b;
                if (editText2 != null) {
                    editText2.setEnabled(false);
                }
                xlVar.f7042a = uxVar.getPaymentDetailDTO();
                lpVar.e();
                MakePaymentNewFragment.d = false;
                return;
            }
            C0535I5.m(lpVar.a().getContext(), true, uxVar.getSoftPointsPurchaseView().getErrorMessage(), lpVar.a().getContext().getString(R.string.error), lpVar.a().getString(R.string.OK), (DialogInterface.OnClickListener) null).show();
        }
    }
}
