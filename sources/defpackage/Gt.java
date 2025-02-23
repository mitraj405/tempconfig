package defpackage;

import com.google.android.material.sidesheet.SideSheetBehavior;
import defpackage.Et;

/* renamed from: Gt  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Gt implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public /* synthetic */ Gt(int i, int i2, Object obj) {
        this.c = i2;
        this.a = obj;
        this.d = i;
    }

    public final void run() {
        int i = this.c;
        int i2 = this.d;
        Object obj = this.a;
        switch (i) {
            case 0:
                ((Et.e) obj).lambda$callbackFailAsync$1(i2);
                return;
            default:
                ((SideSheetBehavior) obj).lambda$setState$0(i2);
                return;
        }
    }
}
