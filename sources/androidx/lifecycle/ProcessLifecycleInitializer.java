package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.e;
import in.juspay.hyper.constants.LogCategory;
import java.util.List;

/* compiled from: ProcessLifecycleInitializer.kt */
public final class ProcessLifecycleInitializer implements Sf<LifecycleOwner> {
    public final Object a(Context context) {
        C1177ig.f(context, LogCategory.CONTEXT);
        z1 c = z1.c(context);
        C1177ig.e(c, "getInstance(context)");
        if (c.f3448a.contains(ProcessLifecycleInitializer.class)) {
            if (!e.a.getAndSet(true)) {
                Context applicationContext = context.getApplicationContext();
                C1177ig.d(applicationContext, "null cannot be cast to non-null type android.app.Application");
                ((Application) applicationContext).registerActivityLifecycleCallbacks(new e.a());
            }
            h hVar = h.a;
            hVar.getClass();
            hVar.f2203a = new Handler();
            hVar.f2204a.f(Lifecycle.a.ON_CREATE);
            Context applicationContext2 = context.getApplicationContext();
            C1177ig.d(applicationContext2, "null cannot be cast to non-null type android.app.Application");
            ((Application) applicationContext2).registerActivityLifecycleCallbacks(new i(hVar));
            return hVar;
        }
        throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml".toString());
    }

    public final List<Class<? extends Sf<?>>> b() {
        return C1477xa.a;
    }
}
