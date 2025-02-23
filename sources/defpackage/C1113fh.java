package defpackage;

import android.content.Intent;
import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.lifecycle.ActivityResultHolder;

/* renamed from: fh  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1113fh implements ActivityResultHolder {
    public final /* synthetic */ JuspayServices a;

    public /* synthetic */ C1113fh(JuspayServices juspayServices) {
        this.a = juspayServices;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        this.a.onActivityResult(i, i2, intent);
    }
}
