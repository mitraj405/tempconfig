package defpackage;

import androidx.work.Data;

/* renamed from: cE  reason: default package and case insensitive filesystem */
/* compiled from: WorkProgressDao_Impl */
public final class C0157cE implements C0146bE {
    public final Zt a;

    /* renamed from: a  reason: collision with other field name */
    public final a f2753a;

    /* renamed from: a  reason: collision with other field name */
    public final b f2754a;

    /* renamed from: a  reason: collision with other field name */
    public final c f2755a;

    /* renamed from: cE$a */
    /* compiled from: WorkProgressDao_Impl */
    public class a extends C0094Ha<C0119aE> {
        public a(Zt zt) {
            super(zt);
        }

        public final String b() {
            return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
        }

        public final void d(C0085Cd cd, Object obj) {
            C0119aE aEVar = (C0119aE) obj;
            String str = aEVar.f798a;
            if (str == null) {
                cd.e(1);
            } else {
                cd.h(1, str);
            }
            byte[] c = Data.c(aEVar.a);
            if (c == null) {
                cd.e(2);
            } else {
                cd.a(2, c);
            }
        }
    }

    /* renamed from: cE$b */
    /* compiled from: WorkProgressDao_Impl */
    public class b extends Cw {
        public b(Zt zt) {
            super(zt);
        }

        public final String b() {
            return "DELETE from WorkProgress where work_spec_id=?";
        }
    }

    /* renamed from: cE$c */
    /* compiled from: WorkProgressDao_Impl */
    public class c extends Cw {
        public c(Zt zt) {
            super(zt);
        }

        public final String b() {
            return "DELETE FROM WorkProgress";
        }
    }

    public C0157cE(Zt zt) {
        this.a = zt;
        this.f2753a = new a(zt);
        this.f2754a = new b(zt);
        this.f2755a = new c(zt);
    }
}
