package defpackage;

/* renamed from: Qp  reason: default package */
/* compiled from: Pools */
public final class Qp {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f491a;
    public int b;

    public /* synthetic */ Qp(int i, int i2, Object obj) {
        this.a = i2;
        this.b = i;
        this.f491a = obj;
    }

    public final void a(Object obj) {
        int i = this.b;
        Object[] objArr = (Object[]) this.f491a;
        if (i < objArr.length) {
            objArr[i] = obj;
            this.b = i + 1;
        }
    }

    public final String toString() {
        switch (this.a) {
            case 1:
                StringBuilder sb = new StringBuilder();
                switch (this.b) {
                    case -1:
                        sb.append("END OF FILE");
                        break;
                    case 0:
                        sb.append("VALUE(");
                        sb.append(this.f491a);
                        sb.append(")");
                        break;
                    case 1:
                        sb.append("LEFT BRACE({)");
                        break;
                    case 2:
                        sb.append("RIGHT BRACE(})");
                        break;
                    case 3:
                        sb.append("LEFT SQUARE([)");
                        break;
                    case 4:
                        sb.append("RIGHT SQUARE(])");
                        break;
                    case 5:
                        sb.append("COMMA(,)");
                        break;
                    case 6:
                        sb.append("COLON(:)");
                        break;
                }
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public Qp() {
        this.a = 0;
        this.f491a = new Object[256];
    }
}
