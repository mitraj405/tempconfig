package defpackage;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import java.util.HashMap;

/* renamed from: U  reason: default package */
/* compiled from: ActivityResultRegistry */
public final class U extends ActivityResultLauncher<Object> {
    public final /* synthetic */ ActivityResultRegistry a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ActivityResultContract f561a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f562a;

    public U(ActivityResultRegistry activityResultRegistry, String str, ActivityResultContract activityResultContract) {
        this.a = activityResultRegistry;
        this.f562a = str;
        this.f561a = activityResultContract;
    }

    public final void a(Object obj) {
        ActivityResultRegistry activityResultRegistry = this.a;
        HashMap hashMap = activityResultRegistry.b;
        String str = this.f562a;
        Integer num = (Integer) hashMap.get(str);
        ActivityResultContract activityResultContract = this.f561a;
        if (num != null) {
            activityResultRegistry.f824a.add(str);
            try {
                activityResultRegistry.b(num.intValue(), activityResultContract, obj);
            } catch (Exception e) {
                activityResultRegistry.f824a.remove(str);
                throw e;
            }
        } else {
            throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + activityResultContract + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }
    }

    public final void b() {
        this.a.f(this.f562a);
    }
}
