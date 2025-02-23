package com.google.firebase.installations;

import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;

/* compiled from: Installations.kt */
public final class InstallationsKt {
    public static final FirebaseInstallations getInstallations(Firebase firebase) {
        C1177ig.f(firebase, "<this>");
        FirebaseInstallations instance = FirebaseInstallations.getInstance();
        C1177ig.e(instance, "getInstance()");
        return instance;
    }

    public static final FirebaseInstallations installations(Firebase firebase, FirebaseApp firebaseApp) {
        C1177ig.f(firebase, "<this>");
        C1177ig.f(firebaseApp, "app");
        FirebaseInstallations instance = FirebaseInstallations.getInstance(firebaseApp);
        C1177ig.e(instance, "getInstance(app)");
        return instance;
    }
}
