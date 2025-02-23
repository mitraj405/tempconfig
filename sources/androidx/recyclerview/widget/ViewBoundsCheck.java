package androidx.recyclerview.widget;

import android.view.View;

public final class ViewBoundsCheck {
    public final Callback a;

    /* renamed from: a  reason: collision with other field name */
    public final a f2361a = new a();

    public interface Callback {
        int a(View view);

        int b();

        View c(int i);

        int d();

        int e(View view);
    }

    public static class a {
        public int a = 0;
        public int b;
        public int c;
        public int d;
        public int e;

        public final boolean a() {
            int i;
            int i2;
            int i3;
            int i4 = this.a;
            int i5 = 2;
            if ((i4 & 7) != 0) {
                int i6 = this.d;
                int i7 = this.b;
                if (i6 > i7) {
                    i3 = 1;
                } else if (i6 == i7) {
                    i3 = 2;
                } else {
                    i3 = 4;
                }
                if (((i3 << 0) & i4) == 0) {
                    return false;
                }
            }
            if ((i4 & 112) != 0) {
                int i8 = this.d;
                int i9 = this.c;
                if (i8 > i9) {
                    i2 = 1;
                } else if (i8 == i9) {
                    i2 = 2;
                } else {
                    i2 = 4;
                }
                if (((i2 << 4) & i4) == 0) {
                    return false;
                }
            }
            if ((i4 & 1792) != 0) {
                int i10 = this.e;
                int i11 = this.b;
                if (i10 > i11) {
                    i = 1;
                } else if (i10 == i11) {
                    i = 2;
                } else {
                    i = 4;
                }
                if (((i << 8) & i4) == 0) {
                    return false;
                }
            }
            if ((i4 & 28672) != 0) {
                int i12 = this.e;
                int i13 = this.c;
                if (i12 > i13) {
                    i5 = 1;
                } else if (i12 != i13) {
                    i5 = 4;
                }
                if ((i4 & (i5 << 12)) == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public ViewBoundsCheck(Callback callback) {
        this.a = callback;
    }

    public final View a(int i, int i2, int i3, int i4) {
        int i5;
        Callback callback = this.a;
        int b = callback.b();
        int d = callback.d();
        if (i2 > i) {
            i5 = 1;
        } else {
            i5 = -1;
        }
        View view = null;
        while (i != i2) {
            View c = callback.c(i);
            int a2 = callback.a(c);
            int e = callback.e(c);
            a aVar = this.f2361a;
            aVar.b = b;
            aVar.c = d;
            aVar.d = a2;
            aVar.e = e;
            if (i3 != 0) {
                aVar.a = i3 | 0;
                if (aVar.a()) {
                    return c;
                }
            }
            if (i4 != 0) {
                aVar.a = i4 | 0;
                if (aVar.a()) {
                    view = c;
                }
            }
            i += i5;
        }
        return view;
    }

    public final boolean b(View view) {
        Callback callback = this.a;
        int b = callback.b();
        int d = callback.d();
        int a2 = callback.a(view);
        int e = callback.e(view);
        a aVar = this.f2361a;
        aVar.b = b;
        aVar.c = d;
        aVar.d = a2;
        aVar.e = e;
        aVar.a = 24579 | 0;
        return aVar.a();
    }
}
