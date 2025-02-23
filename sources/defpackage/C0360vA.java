package defpackage;

import android.app.Activity;
import android.content.Context;
import android.webkit.WebView;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.paytm.easypay.EasypayBrowserFragment;
import java.util.Map;

/* renamed from: vA  reason: default package and case insensitive filesystem */
/* compiled from: Trackers */
public final class C0360vA {
    public static C0360vA a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f3365a;
    public final Object b;
    public final Object c;
    public final Object d;

    public /* synthetic */ C0360vA(Activity activity, WebView webView, EasypayBrowserFragment easypayBrowserFragment, Map map) {
        this.f3365a = activity;
        this.c = easypayBrowserFragment;
        this.d = map;
        this.b = webView;
        StringBuilder sb = new StringBuilder("javascript:");
        Map map2 = map;
        sb.append((String) map2.get("functionStart"));
        sb.append((String) map2.get("functionEnd"));
        webView.loadUrl(sb.toString());
    }

    public static synchronized C0360vA a(Context context, TaskExecutor taskExecutor) {
        C0360vA vAVar;
        synchronized (C0360vA.class) {
            if (a == null) {
                a = new C0360vA(context, taskExecutor);
            }
            vAVar = a;
        }
        return vAVar;
    }

    public /* synthetic */ C0360vA(Context context, TaskExecutor taskExecutor) {
        Context applicationContext = context.getApplicationContext();
        this.f3365a = new F2(applicationContext, taskExecutor);
        this.b = new H2(applicationContext, taskExecutor);
        this.c = new Dm(applicationContext, taskExecutor);
        this.d = new gy(applicationContext, taskExecutor);
    }
}
