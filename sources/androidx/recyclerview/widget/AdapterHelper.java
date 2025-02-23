package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;
import java.util.ArrayList;

public final class AdapterHelper implements i.a {
    public int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public final Pp f2270a = new Pp(30);

    /* renamed from: a  reason: collision with other field name */
    public final a f2271a;

    /* renamed from: a  reason: collision with other field name */
    public final i f2272a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<b> f2273a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public final boolean f2274a;
    public final ArrayList<b> b = new ArrayList<>();

    public interface a {
    }

    public static final class b {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public Object f2275a;
        public int b;
        public int c;

        public b(int i, Object obj, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.f2275a = obj;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            int i = this.a;
            if (i != bVar.a) {
                return false;
            }
            if (i == 8 && Math.abs(this.c - this.b) == 1 && this.c == bVar.b && this.b == bVar.c) {
                return true;
            }
            if (this.c != bVar.c || this.b != bVar.b) {
                return false;
            }
            Object obj2 = this.f2275a;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f2275a)) {
                    return false;
                }
            } else if (bVar.f2275a != null) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.c;
        }

        public final String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append("[");
            int i = this.a;
            if (i == 1) {
                str = "add";
            } else if (i == 2) {
                str = "rm";
            } else if (i == 4) {
                str = "up";
            } else if (i != 8) {
                str = "??";
            } else {
                str = "mv";
            }
            sb.append(str);
            sb.append(",s:");
            sb.append(this.b);
            sb.append("c:");
            sb.append(this.c);
            sb.append(",p:");
            sb.append(this.f2275a);
            sb.append("]");
            return sb.toString();
        }
    }

    public AdapterHelper(RecyclerView.f fVar) {
        this.f2271a = fVar;
        this.f2274a = false;
        this.f2272a = new i(this);
    }

    public final boolean a(int i) {
        ArrayList<b> arrayList = this.b;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = arrayList.get(i2);
            int i3 = bVar.a;
            if (i3 == 8) {
                if (f(bVar.c, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = bVar.b;
                int i5 = bVar.c + i4;
                while (i4 < i5) {
                    if (f(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    public final void b() {
        ArrayList<b> arrayList = this.b;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((RecyclerView.f) this.f2271a).a(arrayList.get(i));
        }
        l(arrayList);
        this.a = 0;
    }

    public final void c() {
        b();
        ArrayList<b> arrayList = this.f2273a;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            b bVar = arrayList.get(i);
            int i2 = bVar.a;
            a aVar = this.f2271a;
            if (i2 == 1) {
                RecyclerView.f fVar = (RecyclerView.f) aVar;
                fVar.a(bVar);
                int i3 = bVar.b;
                int i4 = bVar.c;
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.offsetPositionRecordsForInsert(i3, i4);
                recyclerView.mItemsAddedOrRemoved = true;
            } else if (i2 == 2) {
                RecyclerView.f fVar2 = (RecyclerView.f) aVar;
                fVar2.a(bVar);
                int i5 = bVar.b;
                int i6 = bVar.c;
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.offsetPositionRecordsForRemove(i5, i6, true);
                recyclerView2.mItemsAddedOrRemoved = true;
                recyclerView2.mState.c += i6;
            } else if (i2 == 4) {
                RecyclerView.f fVar3 = (RecyclerView.f) aVar;
                fVar3.a(bVar);
                int i7 = bVar.b;
                int i8 = bVar.c;
                Object obj = bVar.f2275a;
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.viewRangeUpdate(i7, i8, obj);
                recyclerView3.mItemsChanged = true;
            } else if (i2 == 8) {
                RecyclerView.f fVar4 = (RecyclerView.f) aVar;
                fVar4.a(bVar);
                int i9 = bVar.b;
                int i10 = bVar.c;
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.offsetPositionRecordsForMove(i9, i10);
                recyclerView4.mItemsAddedOrRemoved = true;
            }
        }
        l(arrayList);
        this.a = 0;
    }

    public final void d(b bVar) {
        int i;
        boolean z;
        int i2 = bVar.a;
        if (i2 == 1 || i2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int m = m(bVar.b, i2);
        int i3 = bVar.b;
        int i4 = bVar.a;
        if (i4 == 2) {
            i = 0;
        } else if (i4 == 4) {
            i = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update." + bVar);
        }
        int i5 = 1;
        for (int i6 = 1; i6 < bVar.c; i6++) {
            int m2 = m((i * i6) + bVar.b, bVar.a);
            int i7 = bVar.a;
            if (i7 == 2 ? m2 != m : !(i7 == 4 && m2 == m + 1)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                i5++;
            } else {
                b h = h(i7, bVar.f2275a, m, i5);
                e(h, i3);
                k(h);
                if (bVar.a == 4) {
                    i3 += i5;
                }
                i5 = 1;
                m = m2;
            }
        }
        Object obj = bVar.f2275a;
        k(bVar);
        if (i5 > 0) {
            b h2 = h(bVar.a, obj, m, i5);
            e(h2, i3);
            k(h2);
        }
    }

    public final void e(b bVar, int i) {
        RecyclerView.f fVar = (RecyclerView.f) this.f2271a;
        fVar.a(bVar);
        int i2 = bVar.a;
        if (i2 == 2) {
            int i3 = bVar.c;
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.offsetPositionRecordsForRemove(i, i3, true);
            recyclerView.mItemsAddedOrRemoved = true;
            recyclerView.mState.c += i3;
        } else if (i2 == 4) {
            int i4 = bVar.c;
            Object obj = bVar.f2275a;
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.viewRangeUpdate(i, i4, obj);
            recyclerView2.mItemsChanged = true;
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    public final int f(int i, int i2) {
        ArrayList<b> arrayList = this.b;
        int size = arrayList.size();
        while (i2 < size) {
            b bVar = arrayList.get(i2);
            int i3 = bVar.a;
            if (i3 == 8) {
                int i4 = bVar.b;
                if (i4 == i) {
                    i = bVar.c;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (bVar.c <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = bVar.b;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = bVar.c;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += bVar.c;
                }
            }
            i2++;
        }
        return i;
    }

    public final boolean g() {
        if (this.f2273a.size() > 0) {
            return true;
        }
        return false;
    }

    public final b h(int i, Object obj, int i2, int i3) {
        b bVar = (b) this.f2270a.b();
        if (bVar == null) {
            return new b(i, obj, i2, i3);
        }
        bVar.a = i;
        bVar.b = i2;
        bVar.c = i3;
        bVar.f2275a = obj;
        return bVar;
    }

    public final void i(b bVar) {
        this.b.add(bVar);
        int i = bVar.a;
        a aVar = this.f2271a;
        if (i == 1) {
            int i2 = bVar.b;
            int i3 = bVar.c;
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.offsetPositionRecordsForInsert(i2, i3);
            recyclerView.mItemsAddedOrRemoved = true;
        } else if (i == 2) {
            int i4 = bVar.b;
            int i5 = bVar.c;
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.offsetPositionRecordsForRemove(i4, i5, false);
            recyclerView2.mItemsAddedOrRemoved = true;
        } else if (i == 4) {
            int i6 = bVar.b;
            int i7 = bVar.c;
            Object obj = bVar.f2275a;
            RecyclerView recyclerView3 = RecyclerView.this;
            recyclerView3.viewRangeUpdate(i6, i7, obj);
            recyclerView3.mItemsChanged = true;
        } else if (i == 8) {
            int i8 = bVar.b;
            int i9 = bVar.c;
            RecyclerView recyclerView4 = RecyclerView.this;
            recyclerView4.offsetPositionRecordsForMove(i8, i9);
            recyclerView4.mItemsAddedOrRemoved = true;
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:136:0x020c  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0289  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x029e  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0009 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x011f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void j() {
        /*
            r16 = this;
            r0 = r16
            java.util.ArrayList<androidx.recyclerview.widget.AdapterHelper$b> r1 = r0.f2273a
            androidx.recyclerview.widget.i r2 = r0.f2272a
            r2.getClass()
        L_0x0009:
            int r3 = r1.size()
            r4 = 1
            int r3 = r3 - r4
            r6 = 0
        L_0x0010:
            r7 = 8
            r8 = -1
            if (r3 < 0) goto L_0x0026
            java.lang.Object r9 = r1.get(r3)
            androidx.recyclerview.widget.AdapterHelper$b r9 = (androidx.recyclerview.widget.AdapterHelper.b) r9
            int r9 = r9.a
            if (r9 != r7) goto L_0x0022
            if (r6 == 0) goto L_0x0023
            goto L_0x0027
        L_0x0022:
            r6 = r4
        L_0x0023:
            int r3 = r3 + -1
            goto L_0x0010
        L_0x0026:
            r3 = r8
        L_0x0027:
            r6 = 0
            r9 = 4
            r10 = 2
            if (r3 == r8) goto L_0x01bf
            int r7 = r3 + 1
            java.lang.Object r11 = r1.get(r3)
            androidx.recyclerview.widget.AdapterHelper$b r11 = (androidx.recyclerview.widget.AdapterHelper.b) r11
            java.lang.Object r12 = r1.get(r7)
            androidx.recyclerview.widget.AdapterHelper$b r12 = (androidx.recyclerview.widget.AdapterHelper.b) r12
            int r13 = r12.a
            if (r13 == r4) goto L_0x0195
            androidx.recyclerview.widget.i$a r8 = r2.a
            if (r13 == r10) goto L_0x00a6
            if (r13 == r9) goto L_0x0045
            goto L_0x0009
        L_0x0045:
            int r5 = r11.c
            int r10 = r12.b
            if (r5 >= r10) goto L_0x0050
            int r10 = r10 + -1
            r12.b = r10
            goto L_0x0065
        L_0x0050:
            int r13 = r12.c
            int r10 = r10 + r13
            if (r5 >= r10) goto L_0x0065
            int r13 = r13 + -1
            r12.c = r13
            int r5 = r11.b
            java.lang.Object r10 = r12.f2275a
            r13 = r8
            androidx.recyclerview.widget.AdapterHelper r13 = (androidx.recyclerview.widget.AdapterHelper) r13
            androidx.recyclerview.widget.AdapterHelper$b r4 = r13.h(r9, r10, r5, r4)
            goto L_0x0066
        L_0x0065:
            r4 = r6
        L_0x0066:
            int r5 = r11.b
            int r10 = r12.b
            if (r5 > r10) goto L_0x0071
            int r10 = r10 + 1
            r12.b = r10
            goto L_0x0087
        L_0x0071:
            int r13 = r12.c
            int r10 = r10 + r13
            if (r5 >= r10) goto L_0x0087
            int r10 = r10 - r5
            int r5 = r5 + 1
            java.lang.Object r6 = r12.f2275a
            r13 = r8
            androidx.recyclerview.widget.AdapterHelper r13 = (androidx.recyclerview.widget.AdapterHelper) r13
            androidx.recyclerview.widget.AdapterHelper$b r6 = r13.h(r9, r6, r5, r10)
            int r5 = r12.c
            int r5 = r5 - r10
            r12.c = r5
        L_0x0087:
            r1.set(r7, r11)
            int r5 = r12.c
            if (r5 <= 0) goto L_0x0092
            r1.set(r3, r12)
            goto L_0x009a
        L_0x0092:
            r1.remove(r3)
            androidx.recyclerview.widget.AdapterHelper r8 = (androidx.recyclerview.widget.AdapterHelper) r8
            r8.k(r12)
        L_0x009a:
            if (r4 == 0) goto L_0x009f
            r1.add(r3, r4)
        L_0x009f:
            if (r6 == 0) goto L_0x0009
            r1.add(r3, r6)
            goto L_0x0009
        L_0x00a6:
            int r9 = r11.b
            int r13 = r11.c
            if (r9 >= r13) goto L_0x00bb
            int r14 = r12.b
            if (r14 != r9) goto L_0x00b9
            int r14 = r12.c
            int r9 = r13 - r9
            if (r14 != r9) goto L_0x00b9
            r5 = r4
            r9 = 0
            goto L_0x00cb
        L_0x00b9:
            r5 = 0
            goto L_0x00c7
        L_0x00bb:
            int r14 = r12.b
            int r15 = r13 + 1
            if (r14 != r15) goto L_0x00c9
            int r14 = r12.c
            int r9 = r9 - r13
            if (r14 != r9) goto L_0x00c9
            r5 = r4
        L_0x00c7:
            r9 = r5
            goto L_0x00cb
        L_0x00c9:
            r9 = r4
            r5 = 0
        L_0x00cb:
            int r14 = r12.b
            if (r13 >= r14) goto L_0x00d4
            int r14 = r14 + -1
            r12.b = r14
            goto L_0x00ef
        L_0x00d4:
            int r15 = r12.c
            int r14 = r14 + r15
            if (r13 >= r14) goto L_0x00ef
            int r15 = r15 + -1
            r12.c = r15
            r11.a = r10
            r11.c = r4
            int r3 = r12.c
            if (r3 != 0) goto L_0x0009
            r1.remove(r7)
            androidx.recyclerview.widget.AdapterHelper r8 = (androidx.recyclerview.widget.AdapterHelper) r8
            r8.k(r12)
            goto L_0x0009
        L_0x00ef:
            int r4 = r11.b
            int r13 = r12.b
            if (r4 > r13) goto L_0x00fa
            int r13 = r13 + 1
            r12.b = r13
            goto L_0x0110
        L_0x00fa:
            int r14 = r12.c
            int r13 = r13 + r14
            if (r4 >= r13) goto L_0x0110
            int r13 = r13 - r4
            int r4 = r4 + 1
            r14 = r8
            androidx.recyclerview.widget.AdapterHelper r14 = (androidx.recyclerview.widget.AdapterHelper) r14
            androidx.recyclerview.widget.AdapterHelper$b r6 = r14.h(r10, r6, r4, r13)
            int r4 = r11.b
            int r10 = r12.b
            int r4 = r4 - r10
            r12.c = r4
        L_0x0110:
            if (r5 == 0) goto L_0x011f
            r1.set(r3, r12)
            r1.remove(r7)
            androidx.recyclerview.widget.AdapterHelper r8 = (androidx.recyclerview.widget.AdapterHelper) r8
            r8.k(r11)
            goto L_0x0009
        L_0x011f:
            if (r9 == 0) goto L_0x0150
            if (r6 == 0) goto L_0x0139
            int r4 = r11.b
            int r5 = r6.b
            if (r4 <= r5) goto L_0x012e
            int r5 = r6.c
            int r4 = r4 - r5
            r11.b = r4
        L_0x012e:
            int r4 = r11.c
            int r5 = r6.b
            if (r4 <= r5) goto L_0x0139
            int r5 = r6.c
            int r4 = r4 - r5
            r11.c = r4
        L_0x0139:
            int r4 = r11.b
            int r5 = r12.b
            if (r4 <= r5) goto L_0x0144
            int r5 = r12.c
            int r4 = r4 - r5
            r11.b = r4
        L_0x0144:
            int r4 = r11.c
            int r5 = r12.b
            if (r4 <= r5) goto L_0x017e
            int r5 = r12.c
            int r4 = r4 - r5
            r11.c = r4
            goto L_0x017e
        L_0x0150:
            if (r6 == 0) goto L_0x0168
            int r4 = r11.b
            int r5 = r6.b
            if (r4 < r5) goto L_0x015d
            int r5 = r6.c
            int r4 = r4 - r5
            r11.b = r4
        L_0x015d:
            int r4 = r11.c
            int r5 = r6.b
            if (r4 < r5) goto L_0x0168
            int r5 = r6.c
            int r4 = r4 - r5
            r11.c = r4
        L_0x0168:
            int r4 = r11.b
            int r5 = r12.b
            if (r4 < r5) goto L_0x0173
            int r5 = r12.c
            int r4 = r4 - r5
            r11.b = r4
        L_0x0173:
            int r4 = r11.c
            int r5 = r12.b
            if (r4 < r5) goto L_0x017e
            int r5 = r12.c
            int r4 = r4 - r5
            r11.c = r4
        L_0x017e:
            r1.set(r3, r12)
            int r4 = r11.b
            int r5 = r11.c
            if (r4 == r5) goto L_0x018b
            r1.set(r7, r11)
            goto L_0x018e
        L_0x018b:
            r1.remove(r7)
        L_0x018e:
            if (r6 == 0) goto L_0x0009
            r1.add(r3, r6)
            goto L_0x0009
        L_0x0195:
            int r4 = r11.c
            int r6 = r12.b
            if (r4 >= r6) goto L_0x019d
            r5 = r8
            goto L_0x019e
        L_0x019d:
            r5 = 0
        L_0x019e:
            int r8 = r11.b
            if (r8 >= r6) goto L_0x01a4
            int r5 = r5 + 1
        L_0x01a4:
            if (r6 > r8) goto L_0x01ab
            int r6 = r12.c
            int r8 = r8 + r6
            r11.b = r8
        L_0x01ab:
            int r6 = r12.b
            if (r6 > r4) goto L_0x01b4
            int r8 = r12.c
            int r4 = r4 + r8
            r11.c = r4
        L_0x01b4:
            int r6 = r6 + r5
            r12.b = r6
            r1.set(r3, r12)
            r1.set(r7, r11)
            goto L_0x0009
        L_0x01bf:
            int r2 = r1.size()
            r3 = 0
        L_0x01c4:
            if (r3 >= r2) goto L_0x02c9
            java.lang.Object r11 = r1.get(r3)
            androidx.recyclerview.widget.AdapterHelper$b r11 = (androidx.recyclerview.widget.AdapterHelper.b) r11
            int r12 = r11.a
            if (r12 == r4) goto L_0x02bd
            androidx.recyclerview.widget.AdapterHelper$a r13 = r0.f2271a
            if (r12 == r10) goto L_0x024a
            if (r12 == r9) goto L_0x01df
            if (r12 == r7) goto L_0x01d9
            goto L_0x01dc
        L_0x01d9:
            r0.i(r11)
        L_0x01dc:
            r7 = r10
            goto L_0x02c1
        L_0x01df:
            int r12 = r11.b
            int r14 = r11.c
            int r14 = r14 + r12
            r7 = r8
            r15 = r12
            r5 = 0
        L_0x01e7:
            if (r12 >= r14) goto L_0x0230
            r8 = r13
            androidx.recyclerview.widget.RecyclerView$f r8 = (androidx.recyclerview.widget.RecyclerView.f) r8
            androidx.recyclerview.widget.RecyclerView r8 = androidx.recyclerview.widget.RecyclerView.this
            androidx.recyclerview.widget.RecyclerView$ViewHolder r6 = r8.findViewHolderForPosition(r12, r4)
            if (r6 != 0) goto L_0x01f6
        L_0x01f4:
            r6 = 0
            goto L_0x0203
        L_0x01f6:
            androidx.recyclerview.widget.ChildHelper r8 = r8.mChildHelper
            android.view.View r10 = r6.itemView
            boolean r8 = r8.k(r10)
            if (r8 == 0) goto L_0x0203
            int r6 = androidx.recyclerview.widget.RecyclerView.HORIZONTAL
            goto L_0x01f4
        L_0x0203:
            if (r6 != 0) goto L_0x021b
            boolean r6 = r0.a(r12)
            if (r6 == 0) goto L_0x020c
            goto L_0x021b
        L_0x020c:
            if (r7 != r4) goto L_0x0219
            java.lang.Object r6 = r11.f2275a
            androidx.recyclerview.widget.AdapterHelper$b r5 = r0.h(r9, r6, r15, r5)
            r0.i(r5)
            r15 = r12
            r5 = 0
        L_0x0219:
            r7 = 0
            goto L_0x0229
        L_0x021b:
            if (r7 != 0) goto L_0x0228
            java.lang.Object r6 = r11.f2275a
            androidx.recyclerview.widget.AdapterHelper$b r5 = r0.h(r9, r6, r15, r5)
            r0.d(r5)
            r15 = r12
            r5 = 0
        L_0x0228:
            r7 = r4
        L_0x0229:
            int r5 = r5 + r4
            int r12 = r12 + 1
            r6 = 0
            r8 = -1
            r10 = 2
            goto L_0x01e7
        L_0x0230:
            int r6 = r11.c
            if (r5 == r6) goto L_0x023d
            java.lang.Object r6 = r11.f2275a
            r0.k(r11)
            androidx.recyclerview.widget.AdapterHelper$b r11 = r0.h(r9, r6, r15, r5)
        L_0x023d:
            if (r7 != 0) goto L_0x0243
            r0.d(r11)
            goto L_0x0246
        L_0x0243:
            r0.i(r11)
        L_0x0246:
            r6 = 0
            r7 = 2
            goto L_0x02c1
        L_0x024a:
            int r5 = r11.b
            int r6 = r11.c
            int r6 = r6 + r5
            r7 = r5
            r8 = 0
            r10 = -1
        L_0x0252:
            if (r7 >= r6) goto L_0x02a3
            r12 = r13
            androidx.recyclerview.widget.RecyclerView$f r12 = (androidx.recyclerview.widget.RecyclerView.f) r12
            androidx.recyclerview.widget.RecyclerView r12 = androidx.recyclerview.widget.RecyclerView.this
            androidx.recyclerview.widget.RecyclerView$ViewHolder r14 = r12.findViewHolderForPosition(r7, r4)
            if (r14 != 0) goto L_0x0261
        L_0x025f:
            r14 = 0
            goto L_0x026e
        L_0x0261:
            androidx.recyclerview.widget.ChildHelper r12 = r12.mChildHelper
            android.view.View r15 = r14.itemView
            boolean r12 = r12.k(r15)
            if (r12 == 0) goto L_0x026e
            int r12 = androidx.recyclerview.widget.RecyclerView.HORIZONTAL
            goto L_0x025f
        L_0x026e:
            if (r14 != 0) goto L_0x0289
            boolean r12 = r0.a(r7)
            if (r12 == 0) goto L_0x0277
            goto L_0x0289
        L_0x0277:
            if (r10 != r4) goto L_0x0284
            r12 = 0
            r14 = 2
            androidx.recyclerview.widget.AdapterHelper$b r10 = r0.h(r14, r12, r5, r8)
            r0.i(r10)
            r10 = r4
            goto L_0x0287
        L_0x0284:
            r12 = 0
            r14 = 2
            r10 = 0
        L_0x0287:
            r12 = 0
            goto L_0x0298
        L_0x0289:
            r12 = 0
            r14 = 2
            if (r10 != 0) goto L_0x0296
            androidx.recyclerview.widget.AdapterHelper$b r10 = r0.h(r14, r12, r5, r8)
            r0.d(r10)
            r10 = r4
            goto L_0x0297
        L_0x0296:
            r10 = 0
        L_0x0297:
            r12 = r4
        L_0x0298:
            if (r10 == 0) goto L_0x029e
            int r7 = r7 - r8
            int r6 = r6 - r8
            r8 = r4
            goto L_0x02a0
        L_0x029e:
            int r8 = r8 + 1
        L_0x02a0:
            int r7 = r7 + r4
            r10 = r12
            goto L_0x0252
        L_0x02a3:
            int r6 = r11.c
            if (r8 == r6) goto L_0x02b1
            r0.k(r11)
            r6 = 0
            r7 = 2
            androidx.recyclerview.widget.AdapterHelper$b r11 = r0.h(r7, r6, r5, r8)
            goto L_0x02b3
        L_0x02b1:
            r6 = 0
            r7 = 2
        L_0x02b3:
            if (r10 != 0) goto L_0x02b9
            r0.d(r11)
            goto L_0x02c1
        L_0x02b9:
            r0.i(r11)
            goto L_0x02c1
        L_0x02bd:
            r7 = r10
            r0.i(r11)
        L_0x02c1:
            int r3 = r3 + 1
            r10 = r7
            r7 = 8
            r8 = -1
            goto L_0x01c4
        L_0x02c9:
            r1.clear()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.AdapterHelper.j():void");
    }

    public final void k(b bVar) {
        if (!this.f2274a) {
            bVar.f2275a = null;
            this.f2270a.a(bVar);
        }
    }

    public final void l(ArrayList arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            k((b) arrayList.get(i));
        }
        arrayList.clear();
    }

    public final int m(int i, int i2) {
        int i3;
        int i4;
        ArrayList<b> arrayList = this.b;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            b bVar = arrayList.get(size);
            int i5 = bVar.a;
            if (i5 == 8) {
                int i6 = bVar.b;
                int i7 = bVar.c;
                if (i6 < i7) {
                    i4 = i6;
                    i3 = i7;
                } else {
                    i3 = i6;
                    i4 = i7;
                }
                if (i < i4 || i > i3) {
                    if (i < i6) {
                        if (i2 == 1) {
                            bVar.b = i6 + 1;
                            bVar.c = i7 + 1;
                        } else if (i2 == 2) {
                            bVar.b = i6 - 1;
                            bVar.c = i7 - 1;
                        }
                    }
                } else if (i4 == i6) {
                    if (i2 == 1) {
                        bVar.c = i7 + 1;
                    } else if (i2 == 2) {
                        bVar.c = i7 - 1;
                    }
                    i++;
                } else {
                    if (i2 == 1) {
                        bVar.b = i6 + 1;
                    } else if (i2 == 2) {
                        bVar.b = i6 - 1;
                    }
                    i--;
                }
            } else {
                int i8 = bVar.b;
                if (i8 <= i) {
                    if (i5 == 1) {
                        i -= bVar.c;
                    } else if (i5 == 2) {
                        i += bVar.c;
                    }
                } else if (i2 == 1) {
                    bVar.b = i8 + 1;
                } else if (i2 == 2) {
                    bVar.b = i8 - 1;
                }
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            b bVar2 = arrayList.get(size2);
            if (bVar2.a == 8) {
                int i9 = bVar2.c;
                if (i9 == bVar2.b || i9 < 0) {
                    arrayList.remove(size2);
                    k(bVar2);
                }
            } else if (bVar2.c <= 0) {
                arrayList.remove(size2);
                k(bVar2);
            }
        }
        return i;
    }
}
