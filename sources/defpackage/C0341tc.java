package defpackage;

import com.google.firebase.installations.FirebaseInstallations;

/* renamed from: tc  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0341tc implements Runnable {
    public final /* synthetic */ FirebaseInstallations a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f3293a;

    public /* synthetic */ C0341tc(FirebaseInstallations firebaseInstallations, boolean z) {
        this.a = firebaseInstallations;
        this.f3293a = z;
    }

    public final void run() {
        this.a.lambda$doRegistrationOrRefresh$3(this.f3293a);
    }
}
