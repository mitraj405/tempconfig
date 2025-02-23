package defpackage;

import android.content.DialogInterface;
import in.juspay.hypersdk.core.JBridge;

/* renamed from: yg  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1498yg implements DialogInterface.OnDismissListener {
    public final /* synthetic */ JBridge a;
    public final /* synthetic */ String c;

    public /* synthetic */ C1498yg(JBridge jBridge, String str) {
        this.a = jBridge;
        this.c = str;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.a.lambda$newDialogWithoutDateField$5(this.c, dialogInterface);
    }
}
