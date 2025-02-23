package defpackage;

import android.content.DialogInterface;
import in.juspay.hypersdk.core.JBridge;

/* renamed from: xg  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1478xg implements DialogInterface.OnCancelListener {
    public final /* synthetic */ JBridge a;
    public final /* synthetic */ String c;

    public /* synthetic */ C1478xg(JBridge jBridge, String str) {
        this.a = jBridge;
        this.c = str;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.a.lambda$newDialogWithoutDateField$4(this.c, dialogInterface);
    }
}
