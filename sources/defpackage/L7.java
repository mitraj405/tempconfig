package defpackage;

import android.os.IBinder;
import android.support.customtabs.ICustomTabsCallback;
import androidx.browser.customtabs.CustomTabsService;
import java.util.NoSuchElementException;

/* renamed from: L7  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class L7 implements IBinder.DeathRecipient {
    public final /* synthetic */ M7 a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ CustomTabsService.a f382a;

    public /* synthetic */ L7(CustomTabsService.a aVar, M7 m7) {
        this.f382a = aVar;
        this.a = m7;
    }

    public final void binderDied() {
        IBinder iBinder;
        CustomTabsService.a aVar = this.f382a;
        M7 m7 = this.a;
        CustomTabsService customTabsService = CustomTabsService.this;
        customTabsService.getClass();
        try {
            synchronized (customTabsService.f1311a) {
                ICustomTabsCallback iCustomTabsCallback = m7.f394a;
                if (iCustomTabsCallback == null) {
                    iBinder = null;
                } else {
                    iBinder = iCustomTabsCallback.asBinder();
                }
                if (iBinder != null) {
                    iBinder.unlinkToDeath(customTabsService.f1311a.getOrDefault(iBinder, null), 0);
                    customTabsService.f1311a.remove(iBinder);
                }
            }
        } catch (NoSuchElementException unused) {
        }
    }
}
