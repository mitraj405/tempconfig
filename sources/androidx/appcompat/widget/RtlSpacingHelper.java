package androidx.appcompat.widget;

public final class RtlSpacingHelper {
    public int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1216a = false;
    public int b = 0;

    /* renamed from: b  reason: collision with other field name */
    public boolean f1217b = false;
    public int c = Integer.MIN_VALUE;
    public int d = Integer.MIN_VALUE;
    public int e = 0;
    public int f = 0;

    public final void a(int i, int i2) {
        this.c = i;
        this.d = i2;
        this.f1217b = true;
        if (this.f1216a) {
            if (i2 != Integer.MIN_VALUE) {
                this.a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.b = i2;
        }
    }
}
