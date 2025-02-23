package defpackage;

import cris.org.in.prs.ima.R;

/* renamed from: bD  reason: default package and case insensitive filesystem */
/* compiled from: VikalpSystemFragment */
public final class C0797bD implements Runnable {
    public final /* synthetic */ C1065dD a;

    /* renamed from: bD$a */
    /* compiled from: VikalpSystemFragment */
    public class a implements Runnable {
        public a() {
        }

        public final void run() {
            C0797bD bDVar = C0797bD.this;
            bDVar.a.f5434a.setClickable(true);
            C1065dD dDVar = bDVar.a;
            C1058d.H(dDVar.f5435a.f5199a, R.color.PrimaryColor, dDVar.f5434a);
        }
    }

    public C0797bD(C1065dD dDVar) {
        this.a = dDVar;
    }

    public final void run() {
        this.a.f5435a.getActivity().runOnUiThread(new a());
    }
}
