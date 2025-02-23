package defpackage;

import java.io.File;
import java.util.LinkedHashSet;
import kotlin.jvm.functions.Function0;

/* renamed from: cx  reason: default package and case insensitive filesystem */
/* compiled from: SingleProcessDataStore.kt */
public final class C0163cx extends C0595Mh implements Function0<File> {
    public final /* synthetic */ Ww<Object> a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0163cx(Ww<Object> ww) {
        super(0);
        this.a = ww;
    }

    public final Object invoke() {
        File invoke = this.a.f646a.invoke();
        String absolutePath = invoke.getAbsolutePath();
        synchronized (Ww.a) {
            LinkedHashSet linkedHashSet = Ww.f638a;
            if (!linkedHashSet.contains(absolutePath)) {
                C1177ig.e(absolutePath, "it");
                linkedHashSet.add(absolutePath);
            } else {
                throw new IllegalStateException(("There are multiple DataStores active for the same file: " + invoke + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
            }
        }
        return invoke;
    }
}
