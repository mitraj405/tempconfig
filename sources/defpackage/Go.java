package defpackage;

/* renamed from: Go  reason: default package */
/* compiled from: ParseException */
public final class Go extends Exception {
    private static final long serialVersionUID = -7880698968187728547L;
    public final Object a;
    public final int c;
    public final int d;

    public Go(int i, int i2, Object obj) {
        this.d = i;
        this.c = i2;
        this.a = obj;
    }

    public final String getMessage() {
        StringBuilder sb = new StringBuilder();
        Object obj = this.a;
        int i = this.d;
        int i2 = this.c;
        if (i2 == 0) {
            sb.append("Unexpected character (");
            sb.append(obj);
            sb.append(") at position ");
            sb.append(i);
            sb.append(".");
        } else if (i2 == 1) {
            sb.append("Unexpected token ");
            sb.append(obj);
            sb.append(" at position ");
            sb.append(i);
            sb.append(".");
        } else if (i2 != 2) {
            sb.append("Unknown error at position ");
            sb.append(i);
            sb.append(".");
        } else {
            sb.append("Unexpected exception at position ");
            sb.append(i);
            sb.append(": ");
            sb.append(obj);
        }
        return sb.toString();
    }
}
