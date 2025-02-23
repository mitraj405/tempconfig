package com.google.android.gms.internal.p000authapiphone;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.auth.api.phone.SmsRetrieverClient;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zzu  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.3.0 */
public final class zzu extends SmsRetrieverClient {
    public zzu(Context context) {
        super(context);
    }

    public final Task<Void> startSmsRetriever() {
        return doWrite(new zzw(this));
    }

    public final Task<Void> startSmsUserConsent(String str) {
        return doWrite(TaskApiCall.builder().run(new zzx(this, str)).setFeatures(zzaa.zzb).build());
    }

    public zzu(Activity activity) {
        super(activity);
    }
}
