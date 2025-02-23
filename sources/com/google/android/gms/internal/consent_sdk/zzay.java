package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
final class zzay implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ zzbb zza;
    private final Activity zzb;

    public zzay(zzbb zzbb, Activity activity) {
        this.zza = zzbb;
        this.zzb = activity;
    }

    /* access modifiers changed from: private */
    public final void zzb() {
        this.zza.zzb.unregisterActivityLifecycleCallbacks(this);
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zzbb zzbb = this.zza;
        if (zzbb.zzg != null && zzbb.zza) {
            zzbb.zzg.setOwnerActivity(activity);
            zzbb zzbb2 = this.zza;
            if (zzbb2.zzc != null) {
                zzbb2.zzc.zza(activity);
            }
            zzay zzay = (zzay) this.zza.zzl.getAndSet((Object) null);
            if (zzay != null) {
                zzay.zzb();
                zzbb zzbb3 = this.zza;
                zzay zzay2 = new zzay(zzbb3, activity);
                zzbb3.zzb.registerActivityLifecycleCallbacks(zzay2);
                this.zza.zzl.set(zzay2);
            }
            zzbb zzbb4 = this.zza;
            if (zzbb4.zzg != null) {
                zzbb4.zzg.show();
            }
        }
    }

    public final void onActivityDestroyed(Activity activity) {
        if (activity == this.zzb) {
            if (activity.isChangingConfigurations()) {
                zzbb zzbb = this.zza;
                if (zzbb.zza && zzbb.zzg != null) {
                    zzbb.zzg.dismiss();
                    return;
                }
            }
            this.zza.zzh(new zzg(3, "Activity is destroyed."));
        }
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
