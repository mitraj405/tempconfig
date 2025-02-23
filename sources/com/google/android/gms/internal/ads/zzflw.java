package com.google.android.gms.internal.ads;

import com.paytm.pgsdk.sdknative.LoginActivity;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public enum zzflw {
    CTV("ctv"),
    MOBILE(LoginActivity.MOBILE_KEY),
    OTHER("other");
    
    private final String zze;

    private zzflw(String str) {
        this.zze = str;
    }

    public final String toString() {
        return this.zze;
    }
}
