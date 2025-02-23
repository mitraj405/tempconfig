package com.google.firebase;

import android.content.Context;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.components.Component;
import in.juspay.hyper.constants.LogCategory;
import java.lang.annotation.Annotation;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: Firebase.kt */
public final class FirebaseKt {
    public static final FirebaseApp app(Firebase firebase, String str) {
        C1177ig.f(firebase, "<this>");
        C1177ig.f(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        FirebaseApp instance = FirebaseApp.getInstance(str);
        C1177ig.e(instance, "getInstance(name)");
        return instance;
    }

    private static final <T extends Annotation> Component<CoroutineDispatcher> coroutineDispatcher() {
        C1177ig.k();
        throw null;
    }

    public static final FirebaseApp getApp(Firebase firebase) {
        C1177ig.f(firebase, "<this>");
        FirebaseApp instance = FirebaseApp.getInstance();
        C1177ig.e(instance, "getInstance()");
        return instance;
    }

    public static final FirebaseOptions getOptions(Firebase firebase) {
        C1177ig.f(firebase, "<this>");
        FirebaseOptions options = getApp(Firebase.INSTANCE).getOptions();
        C1177ig.e(options, "Firebase.app.options");
        return options;
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context) {
        C1177ig.f(firebase, "<this>");
        C1177ig.f(context, LogCategory.CONTEXT);
        return FirebaseApp.initializeApp(context);
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context, FirebaseOptions firebaseOptions) {
        C1177ig.f(firebase, "<this>");
        C1177ig.f(context, LogCategory.CONTEXT);
        C1177ig.f(firebaseOptions, "options");
        FirebaseApp initializeApp = FirebaseApp.initializeApp(context, firebaseOptions);
        C1177ig.e(initializeApp, "initializeApp(context, options)");
        return initializeApp;
    }

    public static final FirebaseApp initialize(Firebase firebase, Context context, FirebaseOptions firebaseOptions, String str) {
        C1177ig.f(firebase, "<this>");
        C1177ig.f(context, LogCategory.CONTEXT);
        C1177ig.f(firebaseOptions, "options");
        C1177ig.f(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        FirebaseApp initializeApp = FirebaseApp.initializeApp(context, firebaseOptions, str);
        C1177ig.e(initializeApp, "initializeApp(context, options, name)");
        return initializeApp;
    }
}
