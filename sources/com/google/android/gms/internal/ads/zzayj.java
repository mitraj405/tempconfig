package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzayj implements Application.ActivityLifecycleCallbacks {
    private final Application zza;
    private final WeakReference zzb;
    private boolean zzc = false;

    public zzayj(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzb = new WeakReference(activityLifecycleCallbacks);
        this.zza = application;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzayb(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        zza(new zzayh(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zza(new zzaye(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zza(new zzayd(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzayg(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        zza(new zzayc(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zza(new zzayf(this, activity));
    }

    public final void zza(zzayi zzayi) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) this.zzb.get();
            if (activityLifecycleCallbacks != null) {
                zzayi.zza(activityLifecycleCallbacks);
            } else if (!this.zzc) {
                this.zza.unregisterActivityLifecycleCallbacks(this);
                this.zzc = true;
            }
        } catch (Exception e) {
            zzm.zzh("Error while dispatching lifecycle callback.", e);
        }
    }
}
