package defpackage;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: I1  reason: default package and case insensitive filesystem */
/* compiled from: ArrayDeque.kt */
public final class C0534I1<E> extends C1314p<E> {
    public static final Object[] b = new Object[0];
    public Object[] a = b;
    public int c;
    public int d;

    public final void a(int i, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        int length = this.a.length;
        while (i < length && it.hasNext()) {
            this.a[i] = it.next();
            i++;
        }
        int i2 = this.c;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.a[i3] = it.next();
        }
        this.d = collection.size() + this.d;
    }

    public final void add(int i, E e) {
        int i2 = this.d;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(lf.i("index: ", i, ", size: ", i2));
        } else if (i == i2) {
            addLast(e);
        } else if (i == 0) {
            b(i2 + 1);
            int i3 = this.c;
            if (i3 == 0) {
                Object[] objArr = this.a;
                C1177ig.f(objArr, "<this>");
                i3 = objArr.length;
            }
            int i4 = i3 - 1;
            this.c = i4;
            this.a[i4] = e;
            this.d++;
        } else {
            b(i2 + 1);
            int d2 = d(this.c + i);
            int i5 = this.d;
            if (i < ((i5 + 1) >> 1)) {
                if (d2 == 0) {
                    Object[] objArr2 = this.a;
                    C1177ig.f(objArr2, "<this>");
                    d2 = objArr2.length;
                }
                int i6 = d2 - 1;
                int i7 = this.c;
                if (i7 == 0) {
                    Object[] objArr3 = this.a;
                    C1177ig.f(objArr3, "<this>");
                    i7 = objArr3.length;
                }
                int i8 = i7 - 1;
                int i9 = this.c;
                if (i6 >= i9) {
                    Object[] objArr4 = this.a;
                    objArr4[i8] = objArr4[i9];
                    C0601N1.W(objArr4, i9, objArr4, i9 + 1, i6 + 1);
                } else {
                    Object[] objArr5 = this.a;
                    C0601N1.W(objArr5, i9 - 1, objArr5, i9, objArr5.length);
                    Object[] objArr6 = this.a;
                    objArr6[objArr6.length - 1] = objArr6[0];
                    C0601N1.W(objArr6, 0, objArr6, 1, i6 + 1);
                }
                this.a[i6] = e;
                this.c = i8;
            } else {
                int d3 = d(this.c + i5);
                if (d2 < d3) {
                    Object[] objArr7 = this.a;
                    C0601N1.W(objArr7, d2 + 1, objArr7, d2, d3);
                } else {
                    Object[] objArr8 = this.a;
                    C0601N1.W(objArr8, 1, objArr8, 0, d3);
                    Object[] objArr9 = this.a;
                    objArr9[0] = objArr9[objArr9.length - 1];
                    C0601N1.W(objArr9, d2 + 1, objArr9, d2, objArr9.length - 1);
                }
                this.a[d2] = e;
            }
            this.d++;
        }
    }

    public final boolean addAll(int i, Collection<? extends E> collection) {
        C1177ig.f(collection, "elements");
        int i2 = this.d;
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(lf.i("index: ", i, ", size: ", i2));
        } else if (collection.isEmpty()) {
            return false;
        } else {
            int i3 = this.d;
            if (i == i3) {
                return addAll(collection);
            }
            b(collection.size() + i3);
            int d2 = d(this.c + this.d);
            int d3 = d(this.c + i);
            int size = collection.size();
            if (i < ((this.d + 1) >> 1)) {
                int i4 = this.c;
                int i5 = i4 - size;
                if (d3 < i4) {
                    Object[] objArr = this.a;
                    C0601N1.W(objArr, i5, objArr, i4, objArr.length);
                    if (size >= d3) {
                        Object[] objArr2 = this.a;
                        C0601N1.W(objArr2, objArr2.length - size, objArr2, 0, d3);
                    } else {
                        Object[] objArr3 = this.a;
                        C0601N1.W(objArr3, objArr3.length - size, objArr3, 0, size);
                        Object[] objArr4 = this.a;
                        C0601N1.W(objArr4, 0, objArr4, size, d3);
                    }
                } else if (i5 >= 0) {
                    Object[] objArr5 = this.a;
                    C0601N1.W(objArr5, i5, objArr5, i4, d3);
                } else {
                    Object[] objArr6 = this.a;
                    i5 += objArr6.length;
                    int i6 = d3 - i4;
                    int length = objArr6.length - i5;
                    if (length >= i6) {
                        C0601N1.W(objArr6, i5, objArr6, i4, d3);
                    } else {
                        C0601N1.W(objArr6, i5, objArr6, i4, i4 + length);
                        Object[] objArr7 = this.a;
                        C0601N1.W(objArr7, 0, objArr7, this.c + length, d3);
                    }
                }
                this.c = i5;
                int i7 = d3 - size;
                if (i7 < 0) {
                    i7 += this.a.length;
                }
                a(i7, collection);
            } else {
                int i8 = d3 + size;
                if (d3 < d2) {
                    int i9 = size + d2;
                    Object[] objArr8 = this.a;
                    if (i9 <= objArr8.length) {
                        C0601N1.W(objArr8, i8, objArr8, d3, d2);
                    } else if (i8 >= objArr8.length) {
                        C0601N1.W(objArr8, i8 - objArr8.length, objArr8, d3, d2);
                    } else {
                        int length2 = d2 - (i9 - objArr8.length);
                        C0601N1.W(objArr8, 0, objArr8, length2, d2);
                        Object[] objArr9 = this.a;
                        C0601N1.W(objArr9, i8, objArr9, d3, length2);
                    }
                } else {
                    Object[] objArr10 = this.a;
                    C0601N1.W(objArr10, size, objArr10, 0, d2);
                    Object[] objArr11 = this.a;
                    if (i8 >= objArr11.length) {
                        C0601N1.W(objArr11, i8 - objArr11.length, objArr11, d3, objArr11.length);
                    } else {
                        C0601N1.W(objArr11, 0, objArr11, objArr11.length - size, objArr11.length);
                        Object[] objArr12 = this.a;
                        C0601N1.W(objArr12, i8, objArr12, d3, objArr12.length - size);
                    }
                }
                a(d3, collection);
            }
            return true;
        }
    }

    public final void addLast(E e) {
        b(this.d + 1);
        this.a[d(this.c + this.d)] = e;
        this.d++;
    }

    public final void b(int i) {
        if (i >= 0) {
            Object[] objArr = this.a;
            if (i > objArr.length) {
                if (objArr == b) {
                    if (i < 10) {
                        i = 10;
                    }
                    this.a = new Object[i];
                    return;
                }
                int length = objArr.length;
                int i2 = length + (length >> 1);
                if (i2 - i < 0) {
                    i2 = i;
                }
                if (i2 - 2147483639 > 0) {
                    if (i > 2147483639) {
                        i2 = Integer.MAX_VALUE;
                    } else {
                        i2 = 2147483639;
                    }
                }
                Object[] objArr2 = new Object[i2];
                C0601N1.W(objArr, 0, objArr2, this.c, objArr.length);
                Object[] objArr3 = this.a;
                int length2 = objArr3.length;
                int i3 = this.c;
                C0601N1.W(objArr3, length2 - i3, objArr2, 0, i3);
                this.c = 0;
                this.a = objArr2;
                return;
            }
            return;
        }
        throw new IllegalStateException("Deque is too big.");
    }

    public final int c(int i) {
        Object[] objArr = this.a;
        C1177ig.f(objArr, "<this>");
        if (i == objArr.length - 1) {
            return 0;
        }
        return i + 1;
    }

    public final void clear() {
        int d2 = d(this.c + this.d);
        int i = this.c;
        if (i < d2) {
            Object[] objArr = this.a;
            C1177ig.f(objArr, "<this>");
            Arrays.fill(objArr, i, d2, (Object) null);
        } else if (!isEmpty()) {
            Object[] objArr2 = this.a;
            Arrays.fill(objArr2, this.c, objArr2.length, (Object) null);
            Object[] objArr3 = this.a;
            C1177ig.f(objArr3, "<this>");
            Arrays.fill(objArr3, 0, d2, (Object) null);
        }
        this.c = 0;
        this.d = 0;
    }

    public final boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    public final int d(int i) {
        Object[] objArr = this.a;
        if (i >= objArr.length) {
            return i - objArr.length;
        }
        return i;
    }

    public final E get(int i) {
        int i2 = this.d;
        if (i >= 0 && i < i2) {
            return this.a[d(this.c + i)];
        }
        throw new IndexOutOfBoundsException(lf.i("index: ", i, ", size: ", i2));
    }

    public final int indexOf(Object obj) {
        int i;
        int d2 = d(this.c + this.d);
        int i2 = this.c;
        if (i2 < d2) {
            while (i2 < d2) {
                if (C1177ig.a(obj, this.a[i2])) {
                    i = this.c;
                } else {
                    i2++;
                }
            }
            return -1;
        } else if (i2 < d2) {
            return -1;
        } else {
            int length = this.a.length;
            while (true) {
                if (i2 >= length) {
                    int i3 = 0;
                    while (i3 < d2) {
                        if (C1177ig.a(obj, this.a[i3])) {
                            i2 = i3 + this.a.length;
                            i = this.c;
                        } else {
                            i3++;
                        }
                    }
                    return -1;
                } else if (C1177ig.a(obj, this.a[i2])) {
                    i = this.c;
                    break;
                } else {
                    i2++;
                }
            }
        }
        return i2 - i;
    }

    public final boolean isEmpty() {
        if (this.d == 0) {
            return true;
        }
        return false;
    }

    public final int lastIndexOf(Object obj) {
        int i;
        int i2;
        int d2 = d(this.c + this.d);
        int i3 = this.c;
        if (i3 < d2) {
            i2 = d2 - 1;
            if (i3 <= i2) {
                while (!C1177ig.a(obj, this.a[i2])) {
                    if (i2 != i3) {
                        i2--;
                    }
                }
                i = this.c;
            }
            return -1;
        }
        if (i3 > d2) {
            int i4 = d2 - 1;
            while (true) {
                if (-1 >= i4) {
                    Object[] objArr = this.a;
                    C1177ig.f(objArr, "<this>");
                    int length = objArr.length - 1;
                    int i5 = this.c;
                    if (i5 <= length) {
                        while (!C1177ig.a(obj, this.a[i2])) {
                            if (i2 != i5) {
                                length = i2 - 1;
                            }
                        }
                        i = this.c;
                    }
                } else if (C1177ig.a(obj, this.a[i4])) {
                    i2 = i4 + this.a.length;
                    i = this.c;
                    break;
                } else {
                    i4--;
                }
            }
        }
        return -1;
        return i2 - i;
    }

    public final boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean removeAll(java.util.Collection<? extends java.lang.Object> r12) {
        /*
            r11 = this;
            java.lang.String r0 = "elements"
            defpackage.C1177ig.f(r12, r0)
            boolean r0 = r11.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x009b
            java.lang.Object[] r0 = r11.a
            int r0 = r0.length
            r2 = 1
            if (r0 != 0) goto L_0x0014
            r0 = r2
            goto L_0x0015
        L_0x0014:
            r0 = r1
        L_0x0015:
            if (r0 == 0) goto L_0x0019
            goto L_0x009b
        L_0x0019:
            int r0 = r11.c
            int r3 = r11.d
            int r0 = r0 + r3
            int r0 = r11.d(r0)
            int r3 = r11.c
            r4 = 0
            if (r3 >= r0) goto L_0x004c
            r5 = r3
        L_0x0028:
            if (r3 >= r0) goto L_0x0041
            java.lang.Object[] r6 = r11.a
            r6 = r6[r3]
            boolean r7 = r12.contains(r6)
            r7 = r7 ^ r2
            if (r7 == 0) goto L_0x003d
            java.lang.Object[] r7 = r11.a
            int r8 = r5 + 1
            r7[r5] = r6
            r5 = r8
            goto L_0x003e
        L_0x003d:
            r1 = r2
        L_0x003e:
            int r3 = r3 + 1
            goto L_0x0028
        L_0x0041:
            java.lang.Object[] r12 = r11.a
            java.lang.String r2 = "<this>"
            defpackage.C1177ig.f(r12, r2)
            java.util.Arrays.fill(r12, r5, r0, r4)
            goto L_0x008e
        L_0x004c:
            java.lang.Object[] r5 = r11.a
            int r5 = r5.length
            r7 = r1
            r6 = r3
        L_0x0051:
            if (r3 >= r5) goto L_0x006c
            java.lang.Object[] r8 = r11.a
            r9 = r8[r3]
            r8[r3] = r4
            boolean r8 = r12.contains(r9)
            r8 = r8 ^ r2
            if (r8 == 0) goto L_0x0068
            java.lang.Object[] r8 = r11.a
            int r10 = r6 + 1
            r8[r6] = r9
            r6 = r10
            goto L_0x0069
        L_0x0068:
            r7 = r2
        L_0x0069:
            int r3 = r3 + 1
            goto L_0x0051
        L_0x006c:
            int r3 = r11.d(r6)
            r5 = r3
        L_0x0071:
            if (r1 >= r0) goto L_0x008d
            java.lang.Object[] r3 = r11.a
            r6 = r3[r1]
            r3[r1] = r4
            boolean r3 = r12.contains(r6)
            r3 = r3 ^ r2
            if (r3 == 0) goto L_0x0089
            java.lang.Object[] r3 = r11.a
            r3[r5] = r6
            int r5 = r11.c(r5)
            goto L_0x008a
        L_0x0089:
            r7 = r2
        L_0x008a:
            int r1 = r1 + 1
            goto L_0x0071
        L_0x008d:
            r1 = r7
        L_0x008e:
            if (r1 == 0) goto L_0x009b
            int r12 = r11.c
            int r5 = r5 - r12
            if (r5 >= 0) goto L_0x0099
            java.lang.Object[] r12 = r11.a
            int r12 = r12.length
            int r5 = r5 + r12
        L_0x0099:
            r11.d = r5
        L_0x009b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0534I1.removeAll(java.util.Collection):boolean");
    }

    public final E removeFirst() {
        if (!isEmpty()) {
            E[] eArr = this.a;
            int i = this.c;
            E e = eArr[i];
            eArr[i] = null;
            this.c = c(i);
            this.d--;
            return e;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean retainAll(java.util.Collection<? extends java.lang.Object> r12) {
        /*
            r11 = this;
            java.lang.String r0 = "elements"
            defpackage.C1177ig.f(r12, r0)
            boolean r0 = r11.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x0098
            java.lang.Object[] r0 = r11.a
            int r0 = r0.length
            r2 = 1
            if (r0 != 0) goto L_0x0014
            r0 = r2
            goto L_0x0015
        L_0x0014:
            r0 = r1
        L_0x0015:
            if (r0 == 0) goto L_0x0019
            goto L_0x0098
        L_0x0019:
            int r0 = r11.c
            int r3 = r11.d
            int r0 = r0 + r3
            int r0 = r11.d(r0)
            int r3 = r11.c
            r4 = 0
            if (r3 >= r0) goto L_0x004b
            r5 = r3
        L_0x0028:
            if (r3 >= r0) goto L_0x0040
            java.lang.Object[] r6 = r11.a
            r6 = r6[r3]
            boolean r7 = r12.contains(r6)
            if (r7 == 0) goto L_0x003c
            java.lang.Object[] r7 = r11.a
            int r8 = r5 + 1
            r7[r5] = r6
            r5 = r8
            goto L_0x003d
        L_0x003c:
            r1 = r2
        L_0x003d:
            int r3 = r3 + 1
            goto L_0x0028
        L_0x0040:
            java.lang.Object[] r12 = r11.a
            java.lang.String r2 = "<this>"
            defpackage.C1177ig.f(r12, r2)
            java.util.Arrays.fill(r12, r5, r0, r4)
            goto L_0x008b
        L_0x004b:
            java.lang.Object[] r5 = r11.a
            int r5 = r5.length
            r7 = r1
            r6 = r3
        L_0x0050:
            if (r3 >= r5) goto L_0x006a
            java.lang.Object[] r8 = r11.a
            r9 = r8[r3]
            r8[r3] = r4
            boolean r8 = r12.contains(r9)
            if (r8 == 0) goto L_0x0066
            java.lang.Object[] r8 = r11.a
            int r10 = r6 + 1
            r8[r6] = r9
            r6 = r10
            goto L_0x0067
        L_0x0066:
            r7 = r2
        L_0x0067:
            int r3 = r3 + 1
            goto L_0x0050
        L_0x006a:
            int r3 = r11.d(r6)
            r5 = r3
        L_0x006f:
            if (r1 >= r0) goto L_0x008a
            java.lang.Object[] r3 = r11.a
            r6 = r3[r1]
            r3[r1] = r4
            boolean r3 = r12.contains(r6)
            if (r3 == 0) goto L_0x0086
            java.lang.Object[] r3 = r11.a
            r3[r5] = r6
            int r5 = r11.c(r5)
            goto L_0x0087
        L_0x0086:
            r7 = r2
        L_0x0087:
            int r1 = r1 + 1
            goto L_0x006f
        L_0x008a:
            r1 = r7
        L_0x008b:
            if (r1 == 0) goto L_0x0098
            int r12 = r11.c
            int r5 = r5 - r12
            if (r5 >= 0) goto L_0x0096
            java.lang.Object[] r12 = r11.a
            int r12 = r12.length
            int r5 = r5 + r12
        L_0x0096:
            r11.d = r5
        L_0x0098:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0534I1.retainAll(java.util.Collection):boolean");
    }

    public final E set(int i, E e) {
        int i2 = this.d;
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(lf.i("index: ", i, ", size: ", i2));
        }
        int d2 = d(this.c + i);
        E[] eArr = this.a;
        E e2 = eArr[d2];
        eArr[d2] = e;
        return e2;
    }

    public final Object[] toArray() {
        return toArray(new Object[this.d]);
    }

    public final <T> T[] toArray(T[] tArr) {
        C1177ig.f(tArr, "array");
        int length = tArr.length;
        int i = this.d;
        if (length < i) {
            Object newInstance = Array.newInstance(tArr.getClass().getComponentType(), i);
            C1177ig.d(newInstance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
            tArr = (Object[]) newInstance;
        }
        int d2 = d(this.c + this.d);
        int i2 = this.c;
        if (i2 < d2) {
            C0601N1.W(this.a, 0, tArr, i2, d2);
        } else if (!isEmpty()) {
            Object[] objArr = this.a;
            C0601N1.W(objArr, 0, tArr, this.c, objArr.length);
            Object[] objArr2 = this.a;
            C0601N1.W(objArr2, objArr2.length - this.c, tArr, 0, d2);
        }
        int length2 = tArr.length;
        int i3 = this.d;
        if (length2 > i3) {
            tArr[i3] = null;
        }
        return tArr;
    }

    public final boolean add(E e) {
        addLast(e);
        return true;
    }

    public final boolean addAll(Collection<? extends E> collection) {
        C1177ig.f(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        b(collection.size() + this.d);
        a(d(this.c + this.d), collection);
        return true;
    }
}
