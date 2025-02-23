package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.HashMap;
import java.util.Map;

/* renamed from: tf  reason: default package and case insensitive filesystem */
/* compiled from: ImageAssetManager */
public final class C0343tf {
    public static final Object a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public final Context f3299a;

    /* renamed from: a  reason: collision with other field name */
    public final String f3300a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<String, Gj> f3301a;

    public C0343tf(Drawable.Callback callback, String str, Map map) {
        if (TextUtils.isEmpty(str) || str.charAt(str.length() - 1) == '/') {
            this.f3300a = str;
        } else {
            this.f3300a = str.concat(RemoteSettings.FORWARD_SLASH_STRING);
        }
        if (!(callback instanceof View)) {
            Ai.b("LottieDrawable must be inside of a view for images to work.");
            this.f3301a = new HashMap();
            this.f3299a = null;
            return;
        }
        this.f3299a = ((View) callback).getContext();
        this.f3301a = map;
    }
}
