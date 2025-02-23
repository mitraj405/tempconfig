package defpackage;

import android.os.Looper;
import java.util.List;

/* renamed from: B0  reason: default package */
/* compiled from: HandlerDispatcher.kt */
public final class B0 implements C0695Tj {
    public C0682Sj a(List<? extends C0695Tj> list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new C0580Le(C0609Ne.a(mainLooper));
        }
        throw new IllegalStateException("The main looper is not available");
    }

    public String b() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    public int c() {
        return 1073741823;
    }
}
