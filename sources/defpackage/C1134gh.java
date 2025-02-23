package defpackage;

import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.lifecycle.RequestPermissionResult;

/* renamed from: gh  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1134gh implements RequestPermissionResult {
    public final /* synthetic */ JuspayServices a;

    public /* synthetic */ C1134gh(JuspayServices juspayServices) {
        this.a = juspayServices;
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.a.onRequestPermissionsResult(i, strArr, iArr);
    }
}
