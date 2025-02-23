package defpackage;

import android.app.Person;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Icon;
import android.net.Uri;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Objects;

/* renamed from: vp  reason: default package and case insensitive filesystem */
/* compiled from: Person */
public final class C0370vp {
    public final IconCompat a;

    /* renamed from: a  reason: collision with other field name */
    public final CharSequence f3374a;

    /* renamed from: a  reason: collision with other field name */
    public final String f3375a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f3376a;
    public final String b;

    /* renamed from: b  reason: collision with other field name */
    public final boolean f3377b;

    /* renamed from: vp$a */
    /* compiled from: Person */
    public static class a {
        public static C0370vp a(Person person) {
            IconCompat iconCompat;
            b bVar = new b();
            bVar.f3378a = person.getName();
            IconCompat iconCompat2 = null;
            if (person.getIcon() != null) {
                Icon f = person.getIcon();
                PorterDuff.Mode mode = IconCompat.b;
                f.getClass();
                int c = IconCompat.a.c(f);
                if (c != 2) {
                    if (c == 4) {
                        Uri d = IconCompat.a.d(f);
                        d.getClass();
                        String uri = d.toString();
                        uri.getClass();
                        iconCompat = new IconCompat(4);
                        iconCompat.f1781a = uri;
                    } else if (c != 6) {
                        iconCompat2 = new IconCompat(-1);
                        iconCompat2.f1781a = f;
                    } else {
                        Uri d2 = IconCompat.a.d(f);
                        d2.getClass();
                        String uri2 = d2.toString();
                        uri2.getClass();
                        iconCompat = new IconCompat(6);
                        iconCompat.f1781a = uri2;
                    }
                    iconCompat2 = iconCompat;
                } else {
                    iconCompat2 = IconCompat.b((Resources) null, IconCompat.a.b(f), IconCompat.a.a(f));
                }
            }
            bVar.a = iconCompat2;
            bVar.f3379a = person.getUri();
            bVar.b = person.getKey();
            bVar.f3380a = person.isBot();
            bVar.f3381b = person.isImportant();
            return new C0370vp(bVar);
        }

        public static Person b(C0370vp vpVar) {
            Person.Builder name = new Person.Builder().setName(vpVar.f3374a);
            Icon icon = null;
            IconCompat iconCompat = vpVar.a;
            if (iconCompat != null) {
                iconCompat.getClass();
                icon = IconCompat.a.f(iconCompat, (Context) null);
            }
            return name.setIcon(icon).setUri(vpVar.f3375a).setKey(vpVar.b).setBot(vpVar.f3376a).setImportant(vpVar.f3377b).build();
        }
    }

    /* renamed from: vp$b */
    /* compiled from: Person */
    public static class b {
        public IconCompat a;

        /* renamed from: a  reason: collision with other field name */
        public CharSequence f3378a;

        /* renamed from: a  reason: collision with other field name */
        public String f3379a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f3380a;
        public String b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f3381b;
    }

    public C0370vp(b bVar) {
        this.f3374a = bVar.f3378a;
        this.a = bVar.a;
        this.f3375a = bVar.f3379a;
        this.b = bVar.b;
        this.f3376a = bVar.f3380a;
        this.f3377b = bVar.f3381b;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof C0370vp)) {
            return false;
        }
        C0370vp vpVar = (C0370vp) obj;
        String str = this.b;
        String str2 = vpVar.b;
        if (str != null || str2 != null) {
            return Objects.equals(str, str2);
        }
        if (!Objects.equals(Objects.toString(this.f3374a), Objects.toString(vpVar.f3374a)) || !Objects.equals(this.f3375a, vpVar.f3375a) || !Objects.equals(Boolean.valueOf(this.f3376a), Boolean.valueOf(vpVar.f3376a)) || !Objects.equals(Boolean.valueOf(this.f3377b), Boolean.valueOf(vpVar.f3377b))) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.b;
        if (str != null) {
            return str.hashCode();
        }
        return Objects.hash(new Object[]{this.f3374a, this.f3375a, Boolean.valueOf(this.f3376a), Boolean.valueOf(this.f3377b)});
    }
}
