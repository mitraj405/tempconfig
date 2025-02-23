package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.h;

/* compiled from: ProcessLifecycleOwner.kt */
public final class i extends C0352ua {
    final /* synthetic */ h this$0;

    /* compiled from: ProcessLifecycleOwner.kt */
    public static final class a extends C0352ua {
        final /* synthetic */ h this$0;

        public a(h hVar) {
            this.this$0 = hVar;
        }

        public void onActivityPostResumed(Activity activity) {
            C1177ig.f(activity, "activity");
            this.this$0.a();
        }

        public void onActivityPostStarted(Activity activity) {
            C1177ig.f(activity, "activity");
            h hVar = this.this$0;
            int i = hVar.c + 1;
            hVar.c = i;
            if (i == 1 && hVar.b) {
                hVar.f2204a.f(Lifecycle.a.ON_START);
                hVar.b = false;
            }
        }
    }

    public i(h hVar) {
        this.this$0 = hVar;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        C1177ig.f(activity, "activity");
        if (Build.VERSION.SDK_INT < 29) {
            int i = j.c;
            Fragment findFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            C1177ig.d(findFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            ((j) findFragmentByTag).a = this.this$0.f2205a;
        }
    }

    public void onActivityPaused(Activity activity) {
        C1177ig.f(activity, "activity");
        h hVar = this.this$0;
        int i = hVar.d - 1;
        hVar.d = i;
        if (i == 0) {
            Handler handler = hVar.f2203a;
            C1177ig.c(handler);
            handler.postDelayed(hVar.f2206a, 700);
        }
    }

    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        C1177ig.f(activity, "activity");
        h.a.a(activity, new a(this.this$0));
    }

    public void onActivityStopped(Activity activity) {
        C1177ig.f(activity, "activity");
        h hVar = this.this$0;
        int i = hVar.c - 1;
        hVar.c = i;
        if (i == 0 && hVar.f2207a) {
            hVar.f2204a.f(Lifecycle.a.ON_STOP);
            hVar.b = true;
        }
    }
}
