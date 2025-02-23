package androidx.core.view;

import android.view.View;
import android.view.ViewParent;
import java.util.Objects;

public final class NestedScrollingChildHelper {
    public final View a;

    /* renamed from: a  reason: collision with other field name */
    public ViewParent f1799a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1800a;

    /* renamed from: a  reason: collision with other field name */
    public int[] f1801a;
    public ViewParent b;

    public NestedScrollingChildHelper(View view) {
        this.a = view;
    }

    public final boolean a(float f, float f2, boolean z) {
        ViewParent f3;
        if (!this.f1800a || (f3 = f(0)) == null) {
            return false;
        }
        try {
            return DC.a(f3, this.a, f, f2, z);
        } catch (AbstractMethodError unused) {
            Objects.toString(f3);
            return false;
        }
    }

    public final boolean b(float f, float f2) {
        ViewParent f3;
        if (!this.f1800a || (f3 = f(0)) == null) {
            return false;
        }
        try {
            return DC.b(f3, this.a, f, f2);
        } catch (AbstractMethodError unused) {
            Objects.toString(f3);
            return false;
        }
    }

    public final boolean c(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent f;
        int i4;
        int i5;
        int[] iArr3;
        int i6 = i;
        int i7 = i2;
        int[] iArr4 = iArr2;
        int i8 = i3;
        if (!this.f1800a || (f = f(i8)) == null) {
            return false;
        }
        if (i6 != 0 || i7 != 0) {
            View view = this.a;
            if (iArr4 != null) {
                view.getLocationInWindow(iArr4);
                i5 = iArr4[0];
                i4 = iArr4[1];
            } else {
                i5 = 0;
                i4 = 0;
            }
            if (iArr == null) {
                if (this.f1801a == null) {
                    this.f1801a = new int[2];
                }
                iArr3 = this.f1801a;
            } else {
                iArr3 = iArr;
            }
            iArr3[0] = 0;
            iArr3[1] = 0;
            View view2 = this.a;
            if (f instanceof C0369vm) {
                ((C0369vm) f).onNestedPreScroll(view2, i, i2, iArr3, i3);
            } else if (i8 == 0) {
                try {
                    DC.c(f, view2, i, i7, iArr3);
                } catch (AbstractMethodError unused) {
                    Objects.toString(f);
                }
            }
            if (iArr4 != null) {
                view.getLocationInWindow(iArr4);
                iArr4[0] = iArr4[0] - i5;
                iArr4[1] = iArr4[1] - i4;
            }
            if (iArr3[0] == 0 && iArr3[1] == 0) {
                return false;
            }
            return true;
        } else if (iArr4 == null) {
            return false;
        } else {
            iArr4[0] = 0;
            iArr4[1] = 0;
            return false;
        }
    }

    public final void d(int i, int i2, int i3, int[] iArr) {
        e(0, i, 0, i2, (int[]) null, i3, iArr);
    }

    public final boolean e(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        ViewParent f;
        int i6;
        int i7;
        int[] iArr3;
        int[] iArr4 = iArr;
        int i8 = i5;
        if (!this.f1800a || (f = f(i8)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr4 != null) {
                iArr4[0] = 0;
                iArr4[1] = 0;
            }
            return false;
        }
        View view = this.a;
        if (iArr4 != null) {
            view.getLocationInWindow(iArr4);
            i7 = iArr4[0];
            i6 = iArr4[1];
        } else {
            i7 = 0;
            i6 = 0;
        }
        if (iArr2 == null) {
            if (this.f1801a == null) {
                this.f1801a = new int[2];
            }
            int[] iArr5 = this.f1801a;
            iArr5[0] = 0;
            iArr5[1] = 0;
            iArr3 = iArr5;
        } else {
            iArr3 = iArr2;
        }
        View view2 = this.a;
        if (f instanceof C0382wm) {
            ((C0382wm) f).onNestedScroll(view2, i, i2, i3, i4, i5, iArr3);
        } else {
            iArr3[0] = iArr3[0] + i3;
            iArr3[1] = iArr3[1] + i4;
            if (f instanceof C0369vm) {
                ((C0369vm) f).onNestedScroll(view2, i, i2, i3, i4, i5);
            } else if (i8 == 0) {
                try {
                    DC.d(f, view2, i, i2, i3, i4);
                } catch (AbstractMethodError unused) {
                    Objects.toString(f);
                }
            }
        }
        if (iArr4 != null) {
            view.getLocationInWindow(iArr4);
            iArr4[0] = iArr4[0] - i7;
            iArr4[1] = iArr4[1] - i6;
        }
        return true;
    }

    public final ViewParent f(int i) {
        if (i == 0) {
            return this.f1799a;
        }
        if (i != 1) {
            return null;
        }
        return this.b;
    }

    public final boolean g(int i) {
        if (f(i) != null) {
            return true;
        }
        return false;
    }

    public final boolean h(int i, int i2) {
        boolean z;
        if (g(i2)) {
            return true;
        }
        if (this.f1800a) {
            View view = this.a;
            View view2 = view;
            for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                boolean z2 = parent instanceof C0369vm;
                if (z2) {
                    z = ((C0369vm) parent).onStartNestedScroll(view2, view, i, i2);
                } else {
                    if (i2 == 0) {
                        try {
                            z = DC.f(parent, view2, view, i);
                        } catch (AbstractMethodError unused) {
                            Objects.toString(parent);
                        }
                    }
                    z = false;
                }
                if (z) {
                    if (i2 == 0) {
                        this.f1799a = parent;
                    } else if (i2 == 1) {
                        this.b = parent;
                    }
                    if (z2) {
                        ((C0369vm) parent).onNestedScrollAccepted(view2, view, i, i2);
                    } else if (i2 == 0) {
                        try {
                            DC.e(parent, view2, view, i);
                        } catch (AbstractMethodError unused2) {
                            Objects.toString(parent);
                        }
                    }
                    return true;
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
        }
        return false;
    }

    public final void i(int i) {
        ViewParent f = f(i);
        if (f != null) {
            boolean z = f instanceof C0369vm;
            View view = this.a;
            if (z) {
                ((C0369vm) f).onStopNestedScroll(view, i);
            } else if (i == 0) {
                try {
                    DC.g(f, view);
                } catch (AbstractMethodError unused) {
                    Objects.toString(f);
                }
            }
            if (i == 0) {
                this.f1799a = null;
            } else if (i == 1) {
                this.b = null;
            }
        }
    }
}
