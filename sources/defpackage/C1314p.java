package defpackage;

import java.util.AbstractList;
import java.util.List;
import java.util.NoSuchElementException;

/* renamed from: p  reason: default package and case insensitive filesystem */
/* compiled from: AbstractMutableList.kt */
public abstract class C1314p<E> extends AbstractList<E> implements List<E> {
    public final E remove(int i) {
        C0534I1 i1 = (C0534I1) this;
        int i2 = i1.d;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(lf.i("index: ", i, ", size: ", i2));
        } else if (i == r1.y(i1)) {
            if (!i1.isEmpty()) {
                int d = i1.d(r1.y(i1) + i1.c);
                E[] eArr = i1.a;
                E e = eArr[d];
                eArr[d] = null;
                i1.d--;
                return e;
            }
            throw new NoSuchElementException("ArrayDeque is empty.");
        } else if (i == 0) {
            return i1.removeFirst();
        } else {
            int d2 = i1.d(i1.c + i);
            E[] eArr2 = i1.a;
            E e2 = eArr2[d2];
            if (i < (i1.d >> 1)) {
                int i3 = i1.c;
                if (d2 >= i3) {
                    C0601N1.W(eArr2, i3 + 1, eArr2, i3, d2);
                } else {
                    C0601N1.W(eArr2, 1, eArr2, 0, d2);
                    Object[] objArr = i1.a;
                    objArr[0] = objArr[objArr.length - 1];
                    int i4 = i1.c;
                    C0601N1.W(objArr, i4 + 1, objArr, i4, objArr.length - 1);
                }
                Object[] objArr2 = i1.a;
                int i5 = i1.c;
                objArr2[i5] = null;
                i1.c = i1.c(i5);
            } else {
                int d3 = i1.d(r1.y(i1) + i1.c);
                if (d2 <= d3) {
                    Object[] objArr3 = i1.a;
                    C0601N1.W(objArr3, d2, objArr3, d2 + 1, d3 + 1);
                } else {
                    Object[] objArr4 = i1.a;
                    C0601N1.W(objArr4, d2, objArr4, d2 + 1, objArr4.length);
                    Object[] objArr5 = i1.a;
                    objArr5[objArr5.length - 1] = objArr5[0];
                    C0601N1.W(objArr5, 0, objArr5, 1, d3 + 1);
                }
                i1.a[d3] = null;
            }
            i1.d--;
            return e2;
        }
    }

    public final int size() {
        return ((C0534I1) this).d;
    }
}
