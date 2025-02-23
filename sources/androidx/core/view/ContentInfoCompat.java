package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
import java.util.Locale;

public final class ContentInfoCompat {
    public final e a;

    public static final class a implements b {
        public final ContentInfo.Builder a;

        public a(ClipData clipData, int i) {
            this.a = new ContentInfo.Builder(clipData, i);
        }

        public final ContentInfoCompat a() {
            return new ContentInfoCompat(new d(this.a.build()));
        }

        public final void b(Uri uri) {
            this.a.setLinkUri(uri);
        }

        public final void setExtras(Bundle bundle) {
            this.a.setExtras(bundle);
        }

        public final void setFlags(int i) {
            this.a.setFlags(i);
        }
    }

    public interface b {
        ContentInfoCompat a();

        void b(Uri uri);

        void setExtras(Bundle bundle);

        void setFlags(int i);
    }

    public static final class c implements b {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final ClipData f1788a;

        /* renamed from: a  reason: collision with other field name */
        public Uri f1789a;

        /* renamed from: a  reason: collision with other field name */
        public Bundle f1790a;
        public int b;

        public c(ClipData clipData, int i) {
            this.f1788a = clipData;
            this.a = i;
        }

        public final ContentInfoCompat a() {
            return new ContentInfoCompat(new f(this));
        }

        public final void b(Uri uri) {
            this.f1789a = uri;
        }

        public final void setExtras(Bundle bundle) {
            this.f1790a = bundle;
        }

        public final void setFlags(int i) {
            this.b = i;
        }
    }

    public static final class d implements e {
        public final ContentInfo a;

        public d(ContentInfo contentInfo) {
            contentInfo.getClass();
            this.a = contentInfo;
        }

        public final ClipData a() {
            return this.a.getClip();
        }

        public final ContentInfo b() {
            return this.a;
        }

        public final int c() {
            return this.a.getFlags();
        }

        public final int getSource() {
            return this.a.getSource();
        }

        public final String toString() {
            return "ContentInfoCompat{" + this.a + "}";
        }
    }

    public interface e {
        ClipData a();

        ContentInfo b();

        int c();

        int getSource();
    }

    public static final class f implements e {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final ClipData f1791a;

        /* renamed from: a  reason: collision with other field name */
        public final Uri f1792a;

        /* renamed from: a  reason: collision with other field name */
        public final Bundle f1793a;
        public final int b;

        public f(c cVar) {
            ClipData clipData = cVar.f1788a;
            clipData.getClass();
            this.f1791a = clipData;
            int i = cVar.a;
            if (i < 0) {
                throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[]{"source", 0, 5}));
            } else if (i <= 5) {
                this.a = i;
                int i2 = cVar.b;
                if ((i2 & 1) == i2) {
                    this.b = i2;
                    this.f1792a = cVar.f1789a;
                    this.f1793a = cVar.f1790a;
                    return;
                }
                throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i2) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
            } else {
                throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[]{"source", 0, 5}));
            }
        }

        public final ClipData a() {
            return this.f1791a;
        }

        public final ContentInfo b() {
            return null;
        }

        public final int c() {
            return this.b;
        }

        public final int getSource() {
            return this.a;
        }

        public final String toString() {
            String str;
            String str2;
            String str3;
            StringBuilder sb = new StringBuilder("ContentInfoCompat{clip=");
            sb.append(this.f1791a.getDescription());
            sb.append(", source=");
            int i = this.a;
            if (i == 0) {
                str = "SOURCE_APP";
            } else if (i == 1) {
                str = "SOURCE_CLIPBOARD";
            } else if (i == 2) {
                str = "SOURCE_INPUT_METHOD";
            } else if (i == 3) {
                str = "SOURCE_DRAG_AND_DROP";
            } else if (i == 4) {
                str = "SOURCE_AUTOFILL";
            } else if (i != 5) {
                str = String.valueOf(i);
            } else {
                str = "SOURCE_PROCESS_TEXT";
            }
            sb.append(str);
            sb.append(", flags=");
            int i2 = this.b;
            if ((i2 & 1) != 0) {
                str2 = "FLAG_CONVERT_TO_PLAIN_TEXT";
            } else {
                str2 = String.valueOf(i2);
            }
            sb.append(str2);
            String str4 = "";
            Uri uri = this.f1792a;
            if (uri == null) {
                str3 = str4;
            } else {
                str3 = ", hasLinkUri(" + uri.toString().length() + ")";
            }
            sb.append(str3);
            if (this.f1793a != null) {
                str4 = ", hasExtras";
            }
            return C0709Uj.j(sb, str4, "}");
        }
    }

    public ContentInfoCompat(e eVar) {
        this.a = eVar;
    }

    public final String toString() {
        return this.a.toString();
    }
}
