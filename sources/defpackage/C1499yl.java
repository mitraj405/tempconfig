package defpackage;

import android.os.CountDownTimer;
import defpackage.C1480xl;

/* renamed from: yl  reason: default package and case insensitive filesystem */
/* compiled from: MobilePayment */
public final class C1499yl extends CountDownTimer {
    public final /* synthetic */ C1480xl.e a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1499yl(C1480xl.e eVar) {
        super(30000, 1000);
        this.a = eVar;
    }

    public final void onFinish() {
        this.a.f7052a.setClickable(true);
    }

    public final void onTick(long j) {
    }
}
