package defpackage;

import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface;

/* renamed from: Hg  reason: default package */
/* compiled from: JavaScriptReplyProxyImpl */
public final class Hg implements Callable<Object> {
    public final /* synthetic */ JsReplyProxyBoundaryInterface a;

    public Hg(JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface) {
        this.a = jsReplyProxyBoundaryInterface;
    }

    public final Object call() {
        return new Ig(this.a);
    }
}
