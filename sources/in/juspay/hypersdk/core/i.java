package in.juspay.hypersdk.core;

import android.animation.ObjectAnimator;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ AndroidInterface a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f5499a;
    public final /* synthetic */ int c = 0;

    /* renamed from: c  reason: collision with other field name */
    public final /* synthetic */ String f5500c;
    public final /* synthetic */ String d;

    public /* synthetic */ i(AndroidInterface androidInterface, ObjectAnimator objectAnimator, String str, String str2) {
        this.a = androidInterface;
        this.f5499a = objectAnimator;
        this.f5500c = str;
        this.d = str2;
    }

    public final void run() {
        int i = this.c;
        AndroidInterface androidInterface = this.a;
        String str = this.d;
        String str2 = this.f5500c;
        Object obj = this.f5499a;
        switch (i) {
            case 0:
                androidInterface.lambda$cancelAnim$18((ObjectAnimator) obj, str2, str);
                return;
            default:
                androidInterface.lambda$moveView$5(str2, str, (String) obj);
                return;
        }
    }

    public /* synthetic */ i(AndroidInterface androidInterface, String str, String str2, String str3) {
        this.a = androidInterface;
        this.f5500c = str;
        this.d = str2;
        this.f5499a = str3;
    }
}
