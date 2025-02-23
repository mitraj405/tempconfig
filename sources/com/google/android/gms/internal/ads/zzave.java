package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzave implements Application.ActivityLifecycleCallbacks {
    private final Application zza;
    private final WeakReference zzb;
    private boolean zzc = false;

    public zzave(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzb = new WeakReference(activityLifecycleCallbacks);
        this.zza = application;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzauw(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        zza(new zzavc(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zza(new zzauz(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zza(new zzauy(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzavb(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        zza(new zzaux(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zza(new zzava(this, activity));
    }

    public final void zza(zzavd zzavd) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks) this.zzb.get();
            if (activityLifecycleCallbacks != null) {
                zzavd.zza(activityLifecycleCallbacks);
            } else if (!this.zzc) {
                this.zza.unregisterActivityLifecycleCallbacks(this);
                this.zzc = true;
            }
        } catch (Exception unused) {
        }
    }
}
