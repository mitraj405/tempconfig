package defpackage;

import android.app.AlertDialog;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.EditText;
import android.widget.TextView;
import cris.org.in.prs.ima.R;
import rx.Subscriber;

/* renamed from: Cl  reason: default package and case insensitive filesystem */
/* compiled from: MobilePayment */
public final class C0474Cl extends Subscriber<C1225kp> {
    public final /* synthetic */ EditText a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ TextView f3550a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1245lp f3551a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1480xl f3552a;
    public final /* synthetic */ EditText b;

    /* renamed from: b  reason: collision with other field name */
    public final /* synthetic */ TextView f3553b;

    public C0474Cl(C1480xl xlVar, EditText editText, TextView textView, C1245lp lpVar, EditText editText2, TextView textView2) {
        this.f3552a = xlVar;
        this.a = editText;
        this.f3550a = textView;
        this.f3551a = lpVar;
        this.b = editText2;
        this.f3553b = textView2;
    }

    public final void onCompleted() {
        Boolean bool = C1480xl.a;
        this.f3552a.f7040a.dismiss();
        AlertDialog alertDialog = C0535I5.f3619a;
    }

    public final void onError(Throwable th) {
        Boolean bool = C1480xl.a;
        th.getClass();
        th.getMessage();
        this.f3552a.f7040a.dismiss();
        Lt.a(true, th);
    }

    public final void onNext(Object obj) {
        C1225kp kpVar = (C1225kp) obj;
        int txnStatus = kpVar.getTxnStatus();
        C1480xl xlVar = this.f3552a;
        xlVar.f7039a = txnStatus;
        try {
            C1450w1.e = System.currentTimeMillis();
            xlVar.f7040a.dismiss();
            xlVar.f7042a.setWithoutOTP(kpVar.isWithoutOTP());
            int txnStatus2 = kpVar.getTxnStatus();
            int i = C1480xl.c;
            EditText editText = this.b;
            TextView textView = this.f3550a;
            EditText editText2 = this.a;
            C1245lp lpVar = this.f3551a;
            if (txnStatus2 == i) {
                if (xlVar.f7042a.getBankId() == 1000 || xlVar.f7042a.getBankId() == 91 || xlVar.f7042a.getBankId() == 74) {
                    if (editText2 != null) {
                        editText2.setEnabled(false);
                    }
                    if (textView != null) {
                        textView.setText(lpVar.a().getString(R.string.send_otp));
                    }
                    if (editText != null) {
                        editText.setEnabled(true);
                    }
                }
                C0535I5.m(lpVar.a().getContext(), false, kpVar.getErrorMsg(), lpVar.a().getContext().getString(R.string.error), "OK", new C1427ul(this, kpVar)).show();
            } else if (kpVar.getErrorMsg() == null) {
                if (xlVar.f7042a.getBankId() == 1000 || xlVar.f7042a.getBankId() == 91 || xlVar.f7042a.getBankId() == 74 || xlVar.f7042a.getBankId() == 101 || xlVar.f7042a.getBankId() == 103 || xlVar.f7042a.getBankId() == 102) {
                    if (editText2 != null) {
                        int bankId = xlVar.f7042a.getBankId();
                        TextView textView2 = this.f3553b;
                        if (bankId == 1000) {
                            if (xlVar.f7042a.isWithoutOTP()) {
                                editText2.setEnabled(false);
                                editText2.setVisibility(8);
                                textView.setVisibility(8);
                                textView2.setVisibility(0);
                            }
                        }
                        editText2.setEnabled(true);
                        editText2.setVisibility(0);
                        textView2.setVisibility(8);
                    }
                    if (textView != null && (xlVar.f7042a.getBankId() != 1000 || (xlVar.f7042a.getBankId() == 1000 && !xlVar.f7042a.isWithoutOTP()))) {
                        textView.setText(lpVar.a().getString(R.string.resend_otp));
                        if (xlVar.f7042a.getBankId() == 101) {
                            textView.setVisibility(8);
                        }
                    }
                    if (editText != null) {
                        editText.setEnabled(false);
                    }
                }
                xlVar.f7042a.setParamList(kpVar.getParamList());
                xlVar.f7042a.setJuspayLoadDTO(kpVar.getJuspayLoadDTO());
                xlVar.f7042a.setTransationId(kpVar.getTransationId());
                String b2 = C5.b(kpVar.getParamList());
                if (b2 != null && b2.equals(C0515Ga.AVLBLTY_ONLY)) {
                    C1450w1.f7032f = true;
                }
                lpVar.e();
            } else {
                String errorMsg = kpVar.getErrorMsg();
                lpVar.b();
                if (errorMsg.split("-")[0].contains("You have exhausted")) {
                    Html.fromHtml("");
                    Spanned fromHtml = Html.fromHtml(errorMsg);
                    TextView textView3 = new TextView(lpVar.a().getActivity());
                    textView3.setText(fromHtml);
                    textView3.setGravity(3);
                    textView3.setPadding(50, 10, 50, 20);
                    textView3.setTextSize(15.0f);
                    textView3.setMovementMethod(LinkMovementMethod.getInstance());
                    C0535I5.s(lpVar.a().getActivity(), textView3, lpVar.a().getContext().getString(R.string.error), lpVar.a().getString(R.string.OK), new C1444vl(this, errorMsg)).show();
                    return;
                }
                xlVar.f7040a.dismiss();
                if (xlVar.f7042a.getBankId() == 1000 || xlVar.f7042a.getBankId() == 91 || xlVar.f7042a.getBankId() == 74) {
                    if (editText2 != null) {
                        editText2.setEnabled(false);
                    }
                    if (textView != null) {
                        textView.setText(lpVar.a().getString(R.string.send_otp));
                    }
                    if (editText != null) {
                        editText.setEnabled(true);
                    }
                }
                C0535I5.m(lpVar.a().getContext(), false, errorMsg.split("-")[0], lpVar.a().getContext().getString(R.string.error), "OK", new C1462wl(this, errorMsg)).show();
            }
        } catch (Exception e) {
            xlVar.f7040a.dismiss();
            Boolean bool = C1480xl.a;
            e.getMessage();
        }
    }
}
