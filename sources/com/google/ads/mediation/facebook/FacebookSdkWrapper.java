package com.google.ads.mediation.facebook;

import com.facebook.ads.BuildConfig;

/* compiled from: FacebookSdkWrapper.kt */
public final class FacebookSdkWrapper {
    public static final FacebookSdkWrapper INSTANCE = new FacebookSdkWrapper();

    private FacebookSdkWrapper() {
    }

    public static final String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static /* synthetic */ void getSdkVersion$annotations() {
    }
}
