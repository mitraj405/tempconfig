package com.google.android.gms.internal.p000authapiphone;

import com.google.android.gms.common.Feature;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzaa  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.3.0 */
public final class zzaa {
    public static final Feature zza;
    public static final Feature zzb;
    public static final Feature[] zzc;

    static {
        Feature feature = new Feature("sms_code_autofill", 1);
        zza = feature;
        Feature feature2 = new Feature("user_consent", 2);
        zzb = feature2;
        zzc = new Feature[]{feature, feature2};
    }
}
