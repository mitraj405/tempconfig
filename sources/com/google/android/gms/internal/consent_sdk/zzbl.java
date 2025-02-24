package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.UserMessagingPlatform;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
public final /* synthetic */ class zzbl implements UserMessagingPlatform.OnConsentFormLoadSuccessListener {
    public final /* synthetic */ Activity zza;
    public final /* synthetic */ ConsentForm.OnConsentFormDismissedListener zzb;

    public /* synthetic */ zzbl(Activity activity, ConsentForm.OnConsentFormDismissedListener onConsentFormDismissedListener) {
        this.zza = activity;
        this.zzb = onConsentFormDismissedListener;
    }

    public final void onConsentFormLoadSuccess(ConsentForm consentForm) {
        consentForm.show(this.zza, this.zzb);
    }
}
