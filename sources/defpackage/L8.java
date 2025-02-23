package defpackage;

import android.database.Cursor;
import java.util.ArrayList;

/* renamed from: L8  reason: default package */
/* compiled from: DependencyDao_Impl */
public final class L8 implements K8 {
    public final a a;

    /* renamed from: a  reason: collision with other field name */
    public final Zt f383a;

    /* renamed from: L8$a */
    /* compiled from: DependencyDao_Impl */
    public class a extends C0094Ha<I8> {
        public a(Zt zt) {
            super(zt);
        }

        public final String b() {
            return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
        }

        public final void d(C0085Cd cd, Object obj) {
            I8 i8 = (I8) obj;
            String str = i8.a;
            if (str == null) {
                cd.e(1);
            } else {
                cd.h(1, str);
            }
            String str2 = i8.b;
            if (str2 == null) {
                cd.e(2);
            } else {
                cd.h(2, str2);
            }
        }
    }

    public L8(Zt zt) {
        this.f383a = zt;
        this.a = new a(zt);
    }

    public final ArrayList a(String str) {
        bu c = bu.c(1, "SELECT work_spec_id FROM dependency WHERE prerequisite_id=?");
        if (str == null) {
            c.h(1);
        } else {
            c.j(1, str);
        }
        Zt zt = this.f383a;
        zt.b();
        Cursor g = zt.g(c);
        try {
            ArrayList arrayList = new ArrayList(g.getCount());
            while (g.moveToNext()) {
                arrayList.add(g.getString(0));
            }
            return arrayList;
        } finally {
            g.close();
            c.release();
        }
    }

    public final boolean b(String str) {
        boolean z = true;
        bu c = bu.c(1, "SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)");
        if (str == null) {
            c.h(1);
        } else {
            c.j(1, str);
        }
        Zt zt = this.f383a;
        zt.b();
        Cursor g = zt.g(c);
        try {
            boolean z2 = false;
            if (g.moveToFirst()) {
                if (g.getInt(0) == 0) {
                    z = false;
                }
                z2 = z;
            }
            return z2;
        } finally {
            g.close();
            c.release();
        }
    }
}
