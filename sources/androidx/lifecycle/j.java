package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;

/* compiled from: ReportFragment.kt */
public final class j extends Fragment {
    public static final /* synthetic */ int c = 0;
    public a a;

    /* compiled from: ReportFragment.kt */
    public interface a {
        void onCreate();

        void onResume();

        void onStart();
    }

    /* compiled from: ReportFragment.kt */
    public static final class b {
        public static void a(Activity activity, Lifecycle.a aVar) {
            C1177ig.f(activity, "activity");
            C1177ig.f(aVar, "event");
            if (activity instanceof Zh) {
                ((Zh) activity).d().f(aVar);
            } else if (activity instanceof LifecycleOwner) {
                Lifecycle lifecycle = ((LifecycleOwner) activity).getLifecycle();
                if (lifecycle instanceof LifecycleRegistry) {
                    ((LifecycleRegistry) lifecycle).f(aVar);
                }
            }
        }

        public static void b(Activity activity) {
            C1177ig.f(activity, "activity");
            if (Build.VERSION.SDK_INT >= 29) {
                c.Companion.getClass();
                activity.registerActivityLifecycleCallbacks(new c());
            }
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
                fragmentManager.beginTransaction().add(new j(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
                fragmentManager.executePendingTransactions();
            }
        }
    }

    /* compiled from: ReportFragment.kt */
    public static final class c implements Application.ActivityLifecycleCallbacks {
        public static final a Companion = new a();

        /* compiled from: ReportFragment.kt */
        public static final class a {
        }

        public static final void registerIn(Activity activity) {
            Companion.getClass();
            C1177ig.f(activity, "activity");
            activity.registerActivityLifecycleCallbacks(new c());
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            C1177ig.f(activity, "activity");
        }

        public void onActivityDestroyed(Activity activity) {
            C1177ig.f(activity, "activity");
        }

        public void onActivityPaused(Activity activity) {
            C1177ig.f(activity, "activity");
        }

        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            C1177ig.f(activity, "activity");
            int i = j.c;
            b.a(activity, Lifecycle.a.ON_CREATE);
        }

        public void onActivityPostResumed(Activity activity) {
            C1177ig.f(activity, "activity");
            int i = j.c;
            b.a(activity, Lifecycle.a.ON_RESUME);
        }

        public void onActivityPostStarted(Activity activity) {
            C1177ig.f(activity, "activity");
            int i = j.c;
            b.a(activity, Lifecycle.a.ON_START);
        }

        public void onActivityPreDestroyed(Activity activity) {
            C1177ig.f(activity, "activity");
            int i = j.c;
            b.a(activity, Lifecycle.a.ON_DESTROY);
        }

        public void onActivityPrePaused(Activity activity) {
            C1177ig.f(activity, "activity");
            int i = j.c;
            b.a(activity, Lifecycle.a.ON_PAUSE);
        }

        public void onActivityPreStopped(Activity activity) {
            C1177ig.f(activity, "activity");
            int i = j.c;
            b.a(activity, Lifecycle.a.ON_STOP);
        }

        public void onActivityResumed(Activity activity) {
            C1177ig.f(activity, "activity");
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            C1177ig.f(activity, "activity");
            C1177ig.f(bundle, "bundle");
        }

        public void onActivityStarted(Activity activity) {
            C1177ig.f(activity, "activity");
        }

        public void onActivityStopped(Activity activity) {
            C1177ig.f(activity, "activity");
        }
    }

    public final void a(Lifecycle.a aVar) {
        if (Build.VERSION.SDK_INT < 29) {
            Activity activity = getActivity();
            C1177ig.e(activity, "activity");
            b.a(activity, aVar);
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a aVar = this.a;
        if (aVar != null) {
            aVar.onCreate();
        }
        a(Lifecycle.a.ON_CREATE);
    }

    public final void onDestroy() {
        super.onDestroy();
        a(Lifecycle.a.ON_DESTROY);
        this.a = null;
    }

    public final void onPause() {
        super.onPause();
        a(Lifecycle.a.ON_PAUSE);
    }

    public final void onResume() {
        super.onResume();
        a aVar = this.a;
        if (aVar != null) {
            aVar.onResume();
        }
        a(Lifecycle.a.ON_RESUME);
    }

    public final void onStart() {
        super.onStart();
        a aVar = this.a;
        if (aVar != null) {
            aVar.onStart();
        }
        a(Lifecycle.a.ON_START);
    }

    public final void onStop() {
        super.onStop();
        a(Lifecycle.a.ON_STOP);
    }
}
