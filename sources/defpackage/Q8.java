package defpackage;

import androidx.profileinstaller.b;
import in.juspay.hypersdk.core.DuiInterface;

/* renamed from: Q8  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Q8 implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public /* synthetic */ Q8(Object obj, int i, int i2, Object obj2) {
        this.c = i2;
        this.a = obj;
        this.d = i;
        this.b = obj2;
    }

    public final void run() {
        int i = this.c;
        Object obj = this.b;
        int i2 = this.d;
        Object obj2 = this.a;
        switch (i) {
            case 0:
                ((b) obj2).a.b(i2, obj);
                return;
            default:
                ((DuiInterface) obj2).lambda$attachMerchantView$1(i2, (String) obj);
                return;
        }
    }
}
