package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.collection.LruCache;
import defpackage.C0180ed;
import java.io.IOException;
import java.util.Objects;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: Et  reason: default package */
/* compiled from: ResourcesCompat */
public final class Et {
    public static final Object a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public static final ThreadLocal<TypedValue> f161a = new ThreadLocal<>();

    /* renamed from: a  reason: collision with other field name */
    public static final WeakHashMap<d, SparseArray<c>> f162a = new WeakHashMap<>(0);

    /* renamed from: Et$a */
    /* compiled from: ResourcesCompat */
    public static class a {
        public static Drawable a(Resources resources, int i, Resources.Theme theme) {
            return resources.getDrawable(i, theme);
        }

        public static Drawable b(Resources resources, int i, int i2, Resources.Theme theme) {
            return resources.getDrawableForDensity(i, i2, theme);
        }
    }

    /* renamed from: Et$b */
    /* compiled from: ResourcesCompat */
    public static class b {
        public static int a(Resources resources, int i, Resources.Theme theme) {
            return resources.getColor(i, theme);
        }

        public static ColorStateList b(Resources resources, int i, Resources.Theme theme) {
            return resources.getColorStateList(i, theme);
        }
    }

    /* renamed from: Et$c */
    /* compiled from: ResourcesCompat */
    public static class c {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final ColorStateList f163a;

        /* renamed from: a  reason: collision with other field name */
        public final Configuration f164a;

        public c(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            int i;
            this.f163a = colorStateList;
            this.f164a = configuration;
            if (theme == null) {
                i = 0;
            } else {
                i = theme.hashCode();
            }
            this.a = i;
        }
    }

    /* renamed from: Et$d */
    /* compiled from: ResourcesCompat */
    public static final class d {
        public final Resources.Theme a;

        /* renamed from: a  reason: collision with other field name */
        public final Resources f165a;

        public d(Resources resources, Resources.Theme theme) {
            this.f165a = resources;
            this.a = theme;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            if (!this.f165a.equals(dVar.f165a) || !Objects.equals(this.a, dVar.a)) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return Objects.hash(new Object[]{this.f165a, this.a});
        }
    }

    /* renamed from: Et$e */
    /* compiled from: ResourcesCompat */
    public static abstract class e {
        public static Handler getHandler(Handler handler) {
            if (handler == null) {
                return new Handler(Looper.getMainLooper());
            }
            return handler;
        }

        public final void callbackFailAsync(int i, Handler handler) {
            getHandler(handler).post(new Gt(i, 0, this));
        }

        public final void callbackSuccessAsync(Typeface typeface, Handler handler) {
            getHandler(handler).post(new Ft(0, this, typeface));
        }

        /* renamed from: onFontRetrievalFailed */
        public abstract void lambda$callbackFailAsync$1(int i);

        /* renamed from: onFontRetrieved */
        public abstract void lambda$callbackSuccessAsync$0(Typeface typeface);
    }

    public static Typeface a(Context context, int i, TypedValue typedValue, int i2, e eVar, boolean z, boolean z2) {
        int i3 = i;
        TypedValue typedValue2 = typedValue;
        int i4 = i2;
        e eVar2 = eVar;
        Resources resources = context.getResources();
        resources.getValue(i3, typedValue2, true);
        CharSequence charSequence = typedValue2.string;
        if (charSequence != null) {
            String charSequence2 = charSequence.toString();
            Typeface typeface = null;
            if (charSequence2.startsWith("res/")) {
                int i5 = typedValue2.assetCookie;
                LruCache<String, Typeface> lruCache = TA.f546a;
                Typeface typeface2 = lruCache.get(TA.b(resources, i3, charSequence2, i5, i4));
                if (typeface2 != null) {
                    if (eVar2 != null) {
                        eVar2.callbackSuccessAsync(typeface2, (Handler) null);
                    }
                    typeface = typeface2;
                } else if (!z2) {
                    try {
                        if (charSequence2.toLowerCase().endsWith(".xml")) {
                            C0180ed.b a2 = C0180ed.a(resources.getXml(i3), resources);
                            if (a2 != null) {
                                typeface = TA.a(context, a2, resources, i, charSequence2, typedValue2.assetCookie, i2, eVar, z);
                            } else if (eVar2 != null) {
                                eVar2.callbackFailAsync(-3, (Handler) null);
                            }
                        } else {
                            int i6 = typedValue2.assetCookie;
                            Typeface c2 = TA.a.c(context, resources, i, charSequence2, i2);
                            if (c2 != null) {
                                lruCache.put(TA.b(resources, i3, charSequence2, i6, i4), c2);
                            }
                            if (eVar2 != null) {
                                if (c2 != null) {
                                    eVar2.callbackSuccessAsync(c2, (Handler) null);
                                } else {
                                    eVar2.callbackFailAsync(-3, (Handler) null);
                                }
                            }
                            typeface = c2;
                        }
                    } catch (IOException | XmlPullParserException unused) {
                        if (eVar2 != null) {
                            eVar2.callbackFailAsync(-3, (Handler) null);
                        }
                    }
                }
            } else if (eVar2 != null) {
                eVar2.callbackFailAsync(-3, (Handler) null);
            }
            if (typeface != null || eVar2 != null || z2) {
                return typeface;
            }
            throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
        }
        throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i3) + "\" (" + Integer.toHexString(i) + ") is not a Font: " + typedValue2);
    }
}
