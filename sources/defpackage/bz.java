package defpackage;

import android.database.Cursor;

/* renamed from: bz  reason: default package */
/* compiled from: SystemIdInfoDao_Impl */
public final class bz implements az {
    public final Zt a;

    /* renamed from: a  reason: collision with other field name */
    public final a f2750a;

    /* renamed from: a  reason: collision with other field name */
    public final b f2751a;

    /* renamed from: bz$a */
    /* compiled from: SystemIdInfoDao_Impl */
    public class a extends C0094Ha<Zy> {
        public a(Zt zt) {
            super(zt);
        }

        public final String b() {
            return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
        }

        public final void d(C0085Cd cd, Object obj) {
            Zy zy = (Zy) obj;
            String str = zy.f785a;
            if (str == null) {
                cd.e(1);
            } else {
                cd.h(1, str);
            }
            cd.c(2, (long) zy.a);
        }
    }

    /* renamed from: bz$b */
    /* compiled from: SystemIdInfoDao_Impl */
    public class b extends Cw {
        public b(Zt zt) {
            super(zt);
        }

        public final String b() {
            return "DELETE FROM SystemIdInfo where work_spec_id=?";
        }
    }

    public bz(Zt zt) {
        this.a = zt;
        this.f2750a = new a(zt);
        this.f2751a = new b(zt);
    }

    public final Zy a(String str) {
        Zy zy;
        bu c = bu.c(1, "SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?");
        if (str == null) {
            c.h(1);
        } else {
            c.j(1, str);
        }
        Zt zt = this.a;
        zt.b();
        Cursor g = zt.g(c);
        try {
            int N = C1354qp.N(g, "work_spec_id");
            int N2 = C1354qp.N(g, "system_id");
            if (g.moveToFirst()) {
                zy = new Zy(g.getString(N), g.getInt(N2));
            } else {
                zy = null;
            }
            return zy;
        } finally {
            g.close();
            c.release();
        }
    }

    public final void b(String str) {
        Zt zt = this.a;
        zt.b();
        b bVar = this.f2751a;
        C0085Cd a2 = bVar.a();
        if (str == null) {
            a2.e(1);
        } else {
            a2.h(1, str);
        }
        zt.c();
        try {
            a2.j();
            zt.h();
        } finally {
            zt.f();
            bVar.c(a2);
        }
    }
}
