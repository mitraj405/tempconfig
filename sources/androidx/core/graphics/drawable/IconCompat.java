package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public class IconCompat extends CustomVersionedParcelable {
    public static final PorterDuff.Mode b = PorterDuff.Mode.SRC_IN;
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public ColorStateList f1778a;

    /* renamed from: a  reason: collision with other field name */
    public PorterDuff.Mode f1779a;

    /* renamed from: a  reason: collision with other field name */
    public Parcelable f1780a;

    /* renamed from: a  reason: collision with other field name */
    public Object f1781a;

    /* renamed from: a  reason: collision with other field name */
    public String f1782a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f1783a;

    /* renamed from: b  reason: collision with other field name */
    public int f1784b;

    /* renamed from: b  reason: collision with other field name */
    public String f1785b;
    public int c;

    public static class a {
        public static int a(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return 0;
            }
        }

        public static String b(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }

        public static int c(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.c(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException unused) {
                Objects.toString(obj);
                return -1;
            } catch (InvocationTargetException unused2) {
                Objects.toString(obj);
                return -1;
            } catch (NoSuchMethodException unused3) {
                Objects.toString(obj);
                return -1;
            }
        }

        public static Uri d(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }

        public static Drawable e(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x005a  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0063  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static android.graphics.drawable.Icon f(androidx.core.graphics.drawable.IconCompat r3, android.content.Context r4) {
            /*
                int r0 = r3.a
                switch(r0) {
                    case -1: goto L_0x00d6;
                    case 0: goto L_0x0005;
                    case 1: goto L_0x00bd;
                    case 2: goto L_0x00b2;
                    case 3: goto L_0x00a5;
                    case 4: goto L_0x009c;
                    case 5: goto L_0x0093;
                    case 6: goto L_0x000d;
                    default: goto L_0x0005;
                }
            L_0x0005:
                java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
                java.lang.String r4 = "Unknown type"
                r3.<init>(r4)
                throw r3
            L_0x000d:
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 30
                if (r0 < r1) goto L_0x001d
                android.net.Uri r4 = r3.e()
                android.graphics.drawable.Icon r4 = androidx.core.graphics.drawable.IconCompat.d.a(r4)
                goto L_0x00c5
            L_0x001d:
                if (r4 == 0) goto L_0x007b
                android.net.Uri r0 = r3.e()
                java.lang.String r1 = r0.getScheme()
                java.lang.String r2 = "content"
                boolean r2 = r2.equals(r1)
                if (r2 != 0) goto L_0x004b
                java.lang.String r2 = "file"
                boolean r1 = r2.equals(r1)
                if (r1 == 0) goto L_0x0038
                goto L_0x004b
            L_0x0038:
                java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0047 }
                java.io.File r1 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0047 }
                java.lang.Object r2 = r3.f1781a     // Catch:{ FileNotFoundException -> 0x0047 }
                java.lang.String r2 = (java.lang.String) r2     // Catch:{ FileNotFoundException -> 0x0047 }
                r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0047 }
                r4.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0047 }
                goto L_0x0058
            L_0x0047:
                r0.toString()
                goto L_0x0057
            L_0x004b:
                android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ Exception -> 0x0054 }
                java.io.InputStream r4 = r4.openInputStream(r0)     // Catch:{ Exception -> 0x0054 }
                goto L_0x0058
            L_0x0054:
                r0.toString()
            L_0x0057:
                r4 = 0
            L_0x0058:
                if (r4 == 0) goto L_0x0063
                android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeStream(r4)
                android.graphics.drawable.Icon r4 = androidx.core.graphics.drawable.IconCompat.b.b(r4)
                goto L_0x00c5
            L_0x0063:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "Cannot load adaptive icon from uri: "
                r0.<init>(r1)
                android.net.Uri r3 = r3.e()
                r0.append(r3)
                java.lang.String r3 = r0.toString()
                r4.<init>(r3)
                throw r4
            L_0x007b:
                java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "Context is required to resolve the file uri of the icon: "
                r0.<init>(r1)
                android.net.Uri r3 = r3.e()
                r0.append(r3)
                java.lang.String r3 = r0.toString()
                r4.<init>(r3)
                throw r4
            L_0x0093:
                java.lang.Object r4 = r3.f1781a
                android.graphics.Bitmap r4 = (android.graphics.Bitmap) r4
                android.graphics.drawable.Icon r4 = androidx.core.graphics.drawable.IconCompat.b.b(r4)
                goto L_0x00c5
            L_0x009c:
                java.lang.Object r4 = r3.f1781a
                java.lang.String r4 = (java.lang.String) r4
                android.graphics.drawable.Icon r4 = android.graphics.drawable.Icon.createWithContentUri(r4)
                goto L_0x00c5
            L_0x00a5:
                java.lang.Object r4 = r3.f1781a
                byte[] r4 = (byte[]) r4
                int r0 = r3.f1784b
                int r1 = r3.c
                android.graphics.drawable.Icon r4 = android.graphics.drawable.Icon.createWithData(r4, r0, r1)
                goto L_0x00c5
            L_0x00b2:
                java.lang.String r4 = r3.d()
                int r0 = r3.f1784b
                android.graphics.drawable.Icon r4 = android.graphics.drawable.Icon.createWithResource(r4, r0)
                goto L_0x00c5
            L_0x00bd:
                java.lang.Object r4 = r3.f1781a
                android.graphics.Bitmap r4 = (android.graphics.Bitmap) r4
                android.graphics.drawable.Icon r4 = android.graphics.drawable.Icon.createWithBitmap(r4)
            L_0x00c5:
                android.content.res.ColorStateList r0 = r3.f1778a
                if (r0 == 0) goto L_0x00cc
                r4.setTintList(r0)
            L_0x00cc:
                android.graphics.PorterDuff$Mode r3 = r3.f1779a
                android.graphics.PorterDuff$Mode r0 = androidx.core.graphics.drawable.IconCompat.b
                if (r3 == r0) goto L_0x00d5
                r4.setTintMode(r3)
            L_0x00d5:
                return r4
            L_0x00d6:
                java.lang.Object r3 = r3.f1781a
                android.graphics.drawable.Icon r3 = (android.graphics.drawable.Icon) r3
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.a.f(androidx.core.graphics.drawable.IconCompat, android.content.Context):android.graphics.drawable.Icon");
        }
    }

    public static class b {
        public static Drawable a(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        public static Icon b(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    public static class c {
        public static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        public static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        public static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        public static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    public static class d {
        public static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    public IconCompat() {
        this.a = -1;
        this.f1783a = null;
        this.f1780a = null;
        this.f1784b = 0;
        this.c = 0;
        this.f1778a = null;
        this.f1779a = b;
        this.f1782a = null;
    }

    public static IconCompat b(Resources resources, String str, int i) {
        str.getClass();
        if (i != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.f1784b = i;
            if (resources != null) {
                try {
                    iconCompat.f1781a = resources.getResourceName(i);
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else {
                iconCompat.f1781a = str;
            }
            iconCompat.f1785b = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    public final int c() {
        int i = this.a;
        if (i == -1) {
            return a.a(this.f1781a);
        }
        if (i == 2) {
            return this.f1784b;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public final String d() {
        int i = this.a;
        if (i == -1) {
            return a.b(this.f1781a);
        }
        if (i == 2) {
            String str = this.f1785b;
            if (str == null || TextUtils.isEmpty(str)) {
                return ((String) this.f1781a).split(":", -1)[0];
            }
            return this.f1785b;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public final Uri e() {
        int i = this.a;
        if (i == -1) {
            return a.d(this.f1781a);
        }
        if (i == 4 || i == 6) {
            return Uri.parse((String) this.f1781a);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public final String toString() {
        String str;
        if (this.a == -1) {
            return String.valueOf(this.f1781a);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.a) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case 4:
                str = "URI";
                break;
            case 5:
                str = "BITMAP_MASKABLE";
                break;
            case 6:
                str = "URI_MASKABLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        sb.append(str);
        switch (this.a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f1781a).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f1781a).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f1785b);
                sb.append(" id=");
                sb.append(String.format("0x%08x", new Object[]{Integer.valueOf(c())}));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f1784b);
                if (this.c != 0) {
                    sb.append(" off=");
                    sb.append(this.c);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f1781a);
                break;
        }
        if (this.f1778a != null) {
            sb.append(" tint=");
            sb.append(this.f1778a);
        }
        if (this.f1779a != b) {
            sb.append(" mode=");
            sb.append(this.f1779a);
        }
        sb.append(")");
        return sb.toString();
    }

    public IconCompat(int i) {
        this.f1783a = null;
        this.f1780a = null;
        this.f1784b = 0;
        this.c = 0;
        this.f1778a = null;
        this.f1779a = b;
        this.f1782a = null;
        this.a = i;
    }
}
