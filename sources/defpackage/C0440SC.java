package defpackage;

import android.view.View;
import com.google.android.material.internal.ViewUtils;
import com.google.firebase.installations.FirebaseInstallations;

/* renamed from: SC  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0440SC implements Runnable {
    public final /* synthetic */ Object a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f3505a;
    public final /* synthetic */ int c;

    public /* synthetic */ C0440SC(int i, Object obj, boolean z) {
        this.c = i;
        this.a = obj;
        this.f3505a = z;
    }

    public final void run() {
        int i = this.c;
        boolean z = this.f3505a;
        Object obj = this.a;
        switch (i) {
            case 0:
                ViewUtils.showKeyboard((View) obj, z);
                return;
            default:
                ((FirebaseInstallations) obj).lambda$getToken$2(z);
                return;
        }
    }
}
