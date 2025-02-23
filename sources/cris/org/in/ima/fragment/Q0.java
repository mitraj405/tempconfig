package cris.org.in.ima.fragment;

import cris.org.in.prs.ima.R;

/* compiled from: VikalpSystemFragment */
public final class Q0 implements Runnable {
    public final /* synthetic */ VikalpSystemFragment a;

    /* compiled from: VikalpSystemFragment */
    public class a implements Runnable {
        public a() {
        }

        public final void run() {
            Q0 q0 = Q0.this;
            q0.a.resendOtp.setEnabled(true);
            VikalpSystemFragment vikalpSystemFragment = q0.a;
            C1058d.H(vikalpSystemFragment.f5199a, R.color.PrimaryColor, vikalpSystemFragment.resendOtp);
        }
    }

    public Q0(VikalpSystemFragment vikalpSystemFragment) {
        this.a = vikalpSystemFragment;
    }

    public final void run() {
        this.a.f5200a.runOnUiThread(new a());
    }
}
