package defpackage;

/* renamed from: ZD  reason: default package */
/* compiled from: WorkNameDao_Impl */
public final class ZD implements YD {
    public final a a;

    /* renamed from: a  reason: collision with other field name */
    public final Zt f761a;

    /* renamed from: ZD$a */
    /* compiled from: WorkNameDao_Impl */
    public class a extends C0094Ha<XD> {
        public a(Zt zt) {
            super(zt);
        }

        public final String b() {
            return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
        }

        public final void d(C0085Cd cd, Object obj) {
            XD xd = (XD) obj;
            String str = xd.a;
            if (str == null) {
                cd.e(1);
            } else {
                cd.h(1, str);
            }
            String str2 = xd.b;
            if (str2 == null) {
                cd.e(2);
            } else {
                cd.h(2, str2);
            }
        }
    }

    public ZD(Zt zt) {
        this.f761a = zt;
        this.a = new a(zt);
    }
}
