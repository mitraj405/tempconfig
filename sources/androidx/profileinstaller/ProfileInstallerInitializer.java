package androidx.profileinstaller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.util.Collections;
import java.util.List;

public class ProfileInstallerInitializer implements Sf<c> {

    public static class a {
        public static void a(Runnable runnable) {
            Choreographer.getInstance().postFrameCallback(new Aq(runnable));
        }
    }

    public static class b {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    public static class c {
    }

    public final Object a(Context context) {
        a.a(new C0428zq(0, this, context.getApplicationContext()));
        return new c();
    }

    public final List<Class<? extends Sf<?>>> b() {
        return Collections.emptyList();
    }
}
