package defpackage;

import android.database.Cursor;

/* renamed from: aq  reason: default package and case insensitive filesystem */
/* compiled from: PreferenceDao_Impl */
public final class C0137aq implements Zp {
    public final Zt a;

    /* renamed from: a  reason: collision with other field name */
    public final a f2707a;

    /* renamed from: aq$a */
    /* compiled from: PreferenceDao_Impl */
    public class a extends C0094Ha<Yp> {
        public a(Zt zt) {
            super(zt);
        }

        public final String b() {
            return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
        }

        public final void d(C0085Cd cd, Object obj) {
            Yp yp = (Yp) obj;
            String str = yp.f715a;
            if (str == null) {
                cd.e(1);
            } else {
                cd.h(1, str);
            }
            Long l = yp.a;
            if (l == null) {
                cd.e(2);
            } else {
                cd.c(2, l.longValue());
            }
        }
    }

    public C0137aq(Zt zt) {
        this.a = zt;
        this.f2707a = new a(zt);
    }

    public final Long a(String str) {
        Long l;
        bu c = bu.c(1, "SELECT long_value FROM Preference where `key`=?");
        c.j(1, str);
        Zt zt = this.a;
        zt.b();
        Cursor g = zt.g(c);
        try {
            if (g.moveToFirst()) {
                if (!g.isNull(0)) {
                    l = Long.valueOf(g.getLong(0));
                    return l;
                }
            }
            l = null;
            return l;
        } finally {
            g.close();
            c.release();
        }
    }

    public final void b(Yp yp) {
        Zt zt = this.a;
        zt.b();
        zt.c();
        try {
            this.f2707a.e(yp);
            zt.h();
        } finally {
            zt.f();
        }
    }
}
