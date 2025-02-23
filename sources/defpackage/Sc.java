package defpackage;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.HashMap;

/* renamed from: Sc  reason: default package */
/* compiled from: FontAssetManager */
public final class Sc {
    public final AssetManager a;

    /* renamed from: a  reason: collision with other field name */
    public final C0182em<String> f516a = new C0182em<>();

    /* renamed from: a  reason: collision with other field name */
    public final String f517a = ".ttf";

    /* renamed from: a  reason: collision with other field name */
    public final HashMap f518a = new HashMap();
    public final HashMap b = new HashMap();

    public Sc(Drawable.Callback callback) {
        if (!(callback instanceof View)) {
            Ai.b("LottieDrawable must be inside of a view for images to work.");
            this.a = null;
            return;
        }
        this.a = ((View) callback).getContext().getAssets();
    }
}
