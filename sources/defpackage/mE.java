package defpackage;

import android.database.Cursor;
import java.util.ArrayList;

/* renamed from: mE  reason: default package */
/* compiled from: WorkTagDao_Impl */
public final class mE implements C0256lE {
    public final Zt a;

    /* renamed from: a  reason: collision with other field name */
    public final a f3099a;

    /* renamed from: mE$a */
    /* compiled from: WorkTagDao_Impl */
    public class a extends C0094Ha<C0246kE> {
        public a(Zt zt) {
            super(zt);
        }

        public final String b() {
            return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }

        public final void d(C0085Cd cd, Object obj) {
            C0246kE kEVar = (C0246kE) obj;
            String str = kEVar.a;
            if (str == null) {
                cd.e(1);
            } else {
                cd.h(1, str);
            }
            String str2 = kEVar.b;
            if (str2 == null) {
                cd.e(2);
            } else {
                cd.h(2, str2);
            }
        }
    }

    public mE(Zt zt) {
        this.a = zt;
        this.f3099a = new a(zt);
    }

    public final ArrayList a(String str) {
        bu c = bu.c(1, "SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?");
        if (str == null) {
            c.h(1);
        } else {
            c.j(1, str);
        }
        Zt zt = this.a;
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
}
