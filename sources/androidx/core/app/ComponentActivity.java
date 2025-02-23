package androidx.core.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.KeyEventDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.j;

/* compiled from: ComponentActivity.kt */
public class ComponentActivity extends Activity implements LifecycleOwner, KeyEventDispatcher.Component {
    private final SimpleArrayMap<Class<? extends a>, a> extraDataMap = new SimpleArrayMap<>();
    private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    /* compiled from: ComponentActivity.kt */
    public static class a {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003e, code lost:
        if (r4.equals("--list-dumpables") == false) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0047, code lost:
        if (r4.equals("--dump-dumpable") == false) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004e, code lost:
        if (android.os.Build.VERSION.SDK_INT < 33) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0012  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean shouldSkipDump(java.lang.String[] r4) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            if (r4 == 0) goto L_0x000f
            int r2 = r4.length
            if (r2 != 0) goto L_0x0009
            r2 = r0
            goto L_0x000a
        L_0x0009:
            r2 = r1
        L_0x000a:
            if (r2 == 0) goto L_0x000d
            goto L_0x000f
        L_0x000d:
            r2 = r1
            goto L_0x0010
        L_0x000f:
            r2 = r0
        L_0x0010:
            if (r2 != 0) goto L_0x0065
            r4 = r4[r1]
            int r2 = r4.hashCode()
            switch(r2) {
                case -645125871: goto L_0x0053;
                case 100470631: goto L_0x0041;
                case 472614934: goto L_0x0038;
                case 1159329357: goto L_0x0026;
                case 1455016274: goto L_0x001c;
                default: goto L_0x001b;
            }
        L_0x001b:
            goto L_0x0065
        L_0x001c:
            java.lang.String r2 = "--autofill"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L_0x0025
            goto L_0x0065
        L_0x0025:
            return r0
        L_0x0026:
            java.lang.String r2 = "--contentcapture"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L_0x002f
            goto L_0x0065
        L_0x002f:
            int r4 = android.os.Build.VERSION.SDK_INT
            r2 = 29
            if (r4 < r2) goto L_0x0036
            goto L_0x0037
        L_0x0036:
            r0 = r1
        L_0x0037:
            return r0
        L_0x0038:
            java.lang.String r2 = "--list-dumpables"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L_0x004a
            goto L_0x0065
        L_0x0041:
            java.lang.String r2 = "--dump-dumpable"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L_0x004a
            goto L_0x0065
        L_0x004a:
            int r4 = android.os.Build.VERSION.SDK_INT
            r2 = 33
            if (r4 < r2) goto L_0x0051
            goto L_0x0052
        L_0x0051:
            r0 = r1
        L_0x0052:
            return r0
        L_0x0053:
            java.lang.String r2 = "--translation"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L_0x005c
            goto L_0x0065
        L_0x005c:
            int r4 = android.os.Build.VERSION.SDK_INT
            r2 = 31
            if (r4 < r2) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            r0 = r1
        L_0x0064:
            return r0
        L_0x0065:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.ComponentActivity.shouldSkipDump(java.lang.String[]):boolean");
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        C1177ig.f(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        C1177ig.e(decorView, "window.decorView");
        if (KeyEventDispatcher.a(decorView, keyEvent)) {
            return true;
        }
        return KeyEventDispatcher.b(this, decorView, this, keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        C1177ig.f(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        C1177ig.e(decorView, "window.decorView");
        if (KeyEventDispatcher.a(decorView, keyEvent)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    public <T extends a> T getExtraData(Class<T> cls) {
        C1177ig.f(cls, "extraDataClass");
        return (a) this.extraDataMap.get(cls);
    }

    public Lifecycle getLifecycle() {
        return this.lifecycleRegistry;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i = j.c;
        j.b.b(this);
    }

    public void onSaveInstanceState(Bundle bundle) {
        C1177ig.f(bundle, "outState");
        this.lifecycleRegistry.h(Lifecycle.State.CREATED);
        super.onSaveInstanceState(bundle);
    }

    public void putExtraData(a aVar) {
        C1177ig.f(aVar, "extraData");
        this.extraDataMap.put(a.class, aVar);
    }

    public final boolean shouldDumpInternalState(String[] strArr) {
        return !shouldSkipDump(strArr);
    }

    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        C1177ig.f(keyEvent, "event");
        return super.dispatchKeyEvent(keyEvent);
    }

    private static /* synthetic */ void getExtraDataMap$annotations() {
    }

    private static /* synthetic */ void getLifecycleRegistry$annotations() {
    }
}
