package defpackage;

import android.graphics.Path;
import android.webkit.WebView;
import defpackage.UB;
import java.util.ArrayList;
import java.util.List;
import org.chromium.support_lib_boundary.DropDataContentProviderBoundaryInterface;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

/* renamed from: zD  reason: default package and case insensitive filesystem */
/* compiled from: WebViewProviderFactoryAdapter */
public final class C0422zD implements C0405yD {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f3457a;

    public /* synthetic */ C0422zD(Object obj, int i) {
        this.a = i;
        this.f3457a = obj;
    }

    public final WebViewProviderBoundaryInterface a(WebView webView) {
        return (WebViewProviderBoundaryInterface) C1234l3.a(WebViewProviderBoundaryInterface.class, ((WebViewProviderFactoryBoundaryInterface) this.f3457a).createWebView(webView));
    }

    public final void b(Path path) {
        List list = (List) this.f3457a;
        int size = list.size();
        while (true) {
            size--;
            if (size >= 0) {
                MA ma = (MA) list.get(size);
                UB.a aVar = UB.f567a;
                if (ma != null && !ma.f403a) {
                    UB.a(path, ma.f401a.l() / 100.0f, ma.b.l() / 100.0f, ma.c.l() / 360.0f);
                }
            } else {
                return;
            }
        }
    }

    public final String[] c() {
        return ((WebViewProviderFactoryBoundaryInterface) this.f3457a).getSupportedFeatures();
    }

    public final StaticsBoundaryInterface e() {
        return (StaticsBoundaryInterface) C1234l3.a(StaticsBoundaryInterface.class, ((WebViewProviderFactoryBoundaryInterface) this.f3457a).getStatics());
    }

    public final DropDataContentProviderBoundaryInterface f() {
        return (DropDataContentProviderBoundaryInterface) C1234l3.a(DropDataContentProviderBoundaryInterface.class, ((WebViewProviderFactoryBoundaryInterface) this.f3457a).getDropDataProvider());
    }

    public final String toString() {
        switch (this.a) {
            case 2:
                return "<" + ((String) this.f3457a) + '>';
            default:
                return super.toString();
        }
    }

    public C0422zD() {
        this.a = 1;
        this.f3457a = new ArrayList();
    }
}
