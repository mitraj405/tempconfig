package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.support.customtabs.ICustomTabsService;

public class CustomTabsClient {
    public final ComponentName a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f1309a;

    /* renamed from: a  reason: collision with other field name */
    public final ICustomTabsService f1310a;

    public CustomTabsClient(ICustomTabsService iCustomTabsService, ComponentName componentName, Context context) {
        this.f1310a = iCustomTabsService;
        this.a = componentName;
        this.f1309a = context;
    }
}
