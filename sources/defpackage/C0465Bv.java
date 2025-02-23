package defpackage;

import android.view.View;
import cris.org.in.ima.fragment.MakeMppPaymentFragment;
import java.util.ArrayList;

/* renamed from: Bv  reason: default package and case insensitive filesystem */
/* compiled from: SearchDialogAdapter */
public final class C0465Bv implements View.OnClickListener {
    public final /* synthetic */ C0476Cv a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Mv f3533a;

    public C0465Bv(C0476Cv cv, Mv mv, int i) {
        this.a = cv;
        this.f3533a = mv;
    }

    public final void onClick(View view) {
        C0476Cv cv = this.a;
        Ev ev = cv.f3557a;
        C1508z2 z2Var = cv.f3562a;
        MakeMppPaymentFragment.a aVar = (MakeMppPaymentFragment.a) ev;
        aVar.getClass();
        z2Var.dismiss();
        Mv mv = this.f3533a;
        C0489Dv dv = (C0489Dv) mv;
        C1480xl xlVar = C1480xl.f7038a;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Do("PAYMENT_MODE", "netbanking"));
        arrayList.add(new Do("BANK_ID", dv.b));
        arrayList.add(new Do("BANK_NAME", dv.a));
        arrayList.add(new Do("MOBILE", "9999999999"));
        arrayList.add(new Do("EMAIL", "abc@xyz.com"));
        xlVar.g(MakeMppPaymentFragment.this, arrayList);
        int i = MakeMppPaymentFragment.d;
        mv.getTitle().getClass();
    }
}
