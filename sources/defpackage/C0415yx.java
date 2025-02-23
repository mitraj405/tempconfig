package defpackage;

import java.util.Arrays;

/* renamed from: yx  reason: default package and case insensitive filesystem */
/* compiled from: SolverVariable */
public final class C0415yx implements Comparable<C0415yx> {
    public float a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3441a;

    /* renamed from: a  reason: collision with other field name */
    public final float[] f3442a = new float[9];

    /* renamed from: a  reason: collision with other field name */
    public L1[] f3443a = new L1[16];
    public boolean b = false;

    /* renamed from: b  reason: collision with other field name */
    public final float[] f3444b = new float[9];
    public int c = -1;
    public int d = -1;
    public int e = 0;
    public int f;
    public int g = 0;
    public int h = 0;

    public C0415yx(int i) {
        this.f = i;
    }

    public final void a(L1 l1) {
        int i = 0;
        while (true) {
            int i2 = this.g;
            if (i >= i2) {
                L1[] l1Arr = this.f3443a;
                if (i2 >= l1Arr.length) {
                    this.f3443a = (L1[]) Arrays.copyOf(l1Arr, l1Arr.length * 2);
                }
                L1[] l1Arr2 = this.f3443a;
                int i3 = this.g;
                l1Arr2[i3] = l1;
                this.g = i3 + 1;
                return;
            } else if (this.f3443a[i] != l1) {
                i++;
            } else {
                return;
            }
        }
    }

    public final int compareTo(Object obj) {
        return this.c - ((C0415yx) obj).c;
    }

    public final void f(L1 l1) {
        int i = this.g;
        int i2 = 0;
        while (i2 < i) {
            if (this.f3443a[i2] == l1) {
                while (i2 < i - 1) {
                    L1[] l1Arr = this.f3443a;
                    int i3 = i2 + 1;
                    l1Arr[i2] = l1Arr[i3];
                    i2 = i3;
                }
                this.g--;
                return;
            }
            i2++;
        }
    }

    public final void h() {
        this.f = 5;
        this.e = 0;
        this.c = -1;
        this.d = -1;
        this.a = 0.0f;
        this.b = false;
        int i = this.g;
        for (int i2 = 0; i2 < i; i2++) {
            this.f3443a[i2] = null;
        }
        this.g = 0;
        this.h = 0;
        this.f3441a = false;
        Arrays.fill(this.f3444b, 0.0f);
    }

    public final void i(ei eiVar, float f2) {
        this.a = f2;
        this.b = true;
        int i = this.g;
        this.d = -1;
        for (int i2 = 0; i2 < i; i2++) {
            this.f3443a[i2].h(eiVar, this, false);
        }
        this.g = 0;
    }

    public final void j(ei eiVar, L1 l1) {
        int i = this.g;
        for (int i2 = 0; i2 < i; i2++) {
            this.f3443a[i2].i(eiVar, l1, false);
        }
        this.g = 0;
    }

    public final String toString() {
        return "" + this.c;
    }
}
