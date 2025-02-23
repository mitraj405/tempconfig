package defpackage;

import defpackage.C0362vD;
import org.chromium.support_lib_boundary.WebMessageListenerBoundaryInterface;

/* renamed from: rD  reason: default package and case insensitive filesystem */
/* compiled from: WebMessageListenerAdapter */
public final class C0314rD implements WebMessageListenerBoundaryInterface {
    public final C0362vD.a a;

    public C0314rD(C0362vD.a aVar) {
        this.a = aVar;
    }

    public final String[] getSupportedFeatures() {
        return new String[]{"WEB_MESSAGE_LISTENER", "WEB_MESSAGE_ARRAY_BUFFER"};
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPostMessage(android.webkit.WebView r7, java.lang.reflect.InvocationHandler r8, android.net.Uri r9, boolean r10, java.lang.reflect.InvocationHandler r11) {
        /*
            r6 = this;
            java.lang.Class<org.chromium.support_lib_boundary.WebMessageBoundaryInterface> r0 = org.chromium.support_lib_boundary.WebMessageBoundaryInterface.class
            java.lang.Object r8 = defpackage.C1234l3.a(r0, r8)
            org.chromium.support_lib_boundary.WebMessageBoundaryInterface r8 = (org.chromium.support_lib_boundary.WebMessageBoundaryInterface) r8
            java.lang.reflect.InvocationHandler[] r0 = r8.getPorts()
            int r1 = r0.length
            v3[] r1 = new defpackage.v3[r1]
            r2 = 0
        L_0x0010:
            int r3 = r0.length
            if (r2 >= r3) goto L_0x001f
            sD r3 = new sD
            r4 = r0[r2]
            r3.<init>(r4)
            r1[r2] = r3
            int r2 = r2 + 1
            goto L_0x0010
        L_0x001f:
            Y0$d r0 = defpackage.C0376wD.a
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x0052
            java.lang.Class<org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface> r0 = org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface.class
            java.lang.reflect.InvocationHandler r8 = r8.getMessagePayload()
            java.lang.Object r8 = defpackage.C1234l3.a(r0, r8)
            org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface r8 = (org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface) r8
            int r0 = r8.getType()
            if (r0 == 0) goto L_0x0048
            r1 = 1
            if (r0 == r1) goto L_0x003e
            r8 = 0
            goto L_0x005c
        L_0x003e:
            androidx.webkit.WebMessageCompat r0 = new androidx.webkit.WebMessageCompat
            byte[] r8 = r8.getAsArrayBuffer()
            r0.<init>((byte[]) r8)
            goto L_0x005b
        L_0x0048:
            androidx.webkit.WebMessageCompat r0 = new androidx.webkit.WebMessageCompat
            java.lang.String r8 = r8.getAsString()
            r0.<init>((java.lang.String) r8)
            goto L_0x005b
        L_0x0052:
            androidx.webkit.WebMessageCompat r0 = new androidx.webkit.WebMessageCompat
            java.lang.String r8 = r8.getData()
            r0.<init>((java.lang.String) r8)
        L_0x005b:
            r8 = r0
        L_0x005c:
            r2 = r8
            if (r2 == 0) goto L_0x007b
            java.lang.Class<org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface> r8 = org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface.class
            java.lang.Object r8 = defpackage.C1234l3.a(r8, r11)
            org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface r8 = (org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface) r8
            Hg r11 = new Hg
            r11.<init>(r8)
            java.lang.Object r8 = r8.getOrCreatePeer(r11)
            r5 = r8
            Ig r5 = (defpackage.Ig) r5
            vD$a r0 = r6.a
            r1 = r7
            r3 = r9
            r4 = r10
            r0.onPostMessage(r1, r2, r3, r4, r5)
        L_0x007b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0314rD.onPostMessage(android.webkit.WebView, java.lang.reflect.InvocationHandler, android.net.Uri, boolean, java.lang.reflect.InvocationHandler):void");
    }
}
