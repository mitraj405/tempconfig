package defpackage;

import android.net.Uri;
import java.util.HashSet;

/* renamed from: b7  reason: default package and case insensitive filesystem */
/* compiled from: ContentUriTriggers */
public final class C0141b7 {
    public final HashSet a = new HashSet();

    /* renamed from: b7$a */
    /* compiled from: ContentUriTriggers */
    public static final class a {
        public final Uri a;

        /* renamed from: a  reason: collision with other field name */
        public final boolean f2730a;

        public a(Uri uri, boolean z) {
            this.a = uri;
            this.f2730a = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f2730a != aVar.f2730a || !this.a.equals(aVar.a)) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + (this.f2730a ? 1 : 0);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0141b7.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((C0141b7) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
