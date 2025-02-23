package defpackage;

import in.juspay.hypersdk.core.JuspayServices;

/* renamed from: E9  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0492E9 implements Runnable {
    public final /* synthetic */ JuspayServices a;
    public final /* synthetic */ int c;

    public /* synthetic */ C0492E9(JuspayServices juspayServices, int i) {
        this.c = i;
        this.a = juspayServices;
    }

    public final void run() {
        int i = this.c;
        JuspayServices juspayServices = this.a;
        switch (i) {
            case 0:
                juspayServices.terminate();
                return;
            case 1:
                juspayServices.lambda$reset$5();
                return;
            case 2:
                juspayServices.lambda$removeFragment$8();
                return;
            default:
                juspayServices.initiate(new C0251l0(1));
                return;
        }
    }
}
