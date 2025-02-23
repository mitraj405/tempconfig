package com.google.android.gms.internal.consent_sdk;

import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
public final /* synthetic */ class zzbf implements UserMessagingPlatform.OnConsentFormLoadFailureListener {
    public final void onConsentFormLoadFailure(FormError formError) {
        "Failed to load and cache a form, error=".concat(String.valueOf(formError.getMessage()));
    }
}
