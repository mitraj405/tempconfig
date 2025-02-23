package defpackage;

import defpackage.Tg;
import java.io.IOException;

/* renamed from: r9  reason: default package */
/* compiled from: DocumentDataParser */
public final class r9 implements XB<q9> {
    public static final Tg.a a = Tg.a.a("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");

    /* renamed from: a  reason: collision with other field name */
    public static final r9 f3218a = new r9();

    public final Object d(Tg tg, float f) throws IOException {
        tg.b();
        int i = 3;
        String str = null;
        String str2 = null;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = true;
        while (tg.j()) {
            switch (tg.t(a)) {
                case 0:
                    str = tg.q();
                    break;
                case 1:
                    str2 = tg.q();
                    break;
                case 2:
                    f2 = (float) tg.m();
                    break;
                case 3:
                    int n = tg.n();
                    if (n <= 2 && n >= 0) {
                        i = xx.X(3)[n];
                        break;
                    } else {
                        i = 3;
                        break;
                    }
                case 4:
                    i2 = tg.n();
                    break;
                case 5:
                    f3 = (float) tg.m();
                    break;
                case 6:
                    f4 = (float) tg.m();
                    break;
                case 7:
                    i3 = Wg.a(tg);
                    break;
                case 8:
                    i4 = Wg.a(tg);
                    break;
                case 9:
                    f5 = (float) tg.m();
                    break;
                case 10:
                    z = tg.l();
                    break;
                default:
                    tg.u();
                    tg.v();
                    break;
            }
        }
        Tg tg2 = tg;
        tg.e();
        return new q9(str, str2, f2, i, i2, f3, f4, i3, i4, f5, z);
    }
}
