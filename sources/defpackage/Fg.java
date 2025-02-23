package defpackage;

import defpackage.Vg;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: Fg  reason: default package */
/* compiled from: JSONParser */
public final class Fg {
    public int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public Qp f3586a = null;

    /* renamed from: a  reason: collision with other field name */
    public final C1512zE f3587a = new C1512zE();

    public static int d(LinkedList linkedList) {
        if (linkedList.size() == 0) {
            return -1;
        }
        return ((Integer) linkedList.getFirst()).intValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x00a0 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() throws defpackage.Go, java.io.IOException {
        /*
            r17 = this;
            r1 = r17
            zE r2 = r1.f3587a
            int r0 = r2.f
            char[] r3 = r2.f7098a
        L_0x0008:
            int r4 = r2.f7100c
            int r5 = r2.g
            int r6 = r2.f7102e
            int r6 = r4 - r6
            int r6 = r6 + r5
            r2.g = r6
            r2.f7102e = r4
            r2.f7101d = r4
            int[] r5 = defpackage.C1512zE.a
            int r6 = r2.f7099b
            r5 = r5[r6]
            r2.f7094a = r5
            r5 = -1
            r6 = r4
            r7 = r5
        L_0x0022:
            r8 = 8
            r9 = 1
            r10 = 0
            if (r4 >= r0) goto L_0x002e
            int r11 = r4 + 1
            char r4 = r3[r4]
            goto L_0x00b0
        L_0x002e:
            boolean r11 = r2.f7097a
            if (r11 == 0) goto L_0x0035
            r4 = r5
            goto L_0x00d2
        L_0x0035:
            r2.f7101d = r4
            r2.f7100c = r6
            int r0 = r2.f7102e
            if (r0 <= 0) goto L_0x0058
            char[] r3 = r2.f7098a
            int r4 = r2.f
            int r4 = r4 - r0
            java.lang.System.arraycopy(r3, r0, r3, r10, r4)
            int r0 = r2.f
            int r3 = r2.f7102e
            int r0 = r0 - r3
            r2.f = r0
            int r0 = r2.f7101d
            int r0 = r0 - r3
            r2.f7101d = r0
            int r0 = r2.f7100c
            int r0 = r0 - r3
            r2.f7100c = r0
            r2.f7102e = r10
        L_0x0058:
            int r0 = r2.f7101d
            char[] r3 = r2.f7098a
            int r4 = r3.length
            if (r0 < r4) goto L_0x0069
            int r0 = r0 * 2
            char[] r0 = new char[r0]
            int r4 = r3.length
            java.lang.System.arraycopy(r3, r10, r0, r10, r4)
            r2.f7098a = r0
        L_0x0069:
            java.io.Reader r0 = r2.f7095a
            char[] r3 = r2.f7098a
            int r4 = r2.f
            int r6 = r3.length
            int r6 = r6 - r4
            int r0 = r0.read(r3, r4, r6)
            if (r0 <= 0) goto L_0x007d
            int r3 = r2.f
            int r3 = r3 + r0
            r2.f = r3
            goto L_0x0093
        L_0x007d:
            if (r0 != 0) goto L_0x0095
            java.io.Reader r0 = r2.f7095a
            int r0 = r0.read()
            if (r0 != r5) goto L_0x0088
            goto L_0x0095
        L_0x0088:
            char[] r3 = r2.f7098a
            int r4 = r2.f
            int r6 = r4 + 1
            r2.f = r6
            char r0 = (char) r0
            r3[r4] = r0
        L_0x0093:
            r0 = r10
            goto L_0x0096
        L_0x0095:
            r0 = r9
        L_0x0096:
            int r3 = r2.f7101d
            int r6 = r2.f7100c
            char[] r4 = r2.f7098a
            int r11 = r2.f
            if (r0 == 0) goto L_0x00a4
            r3 = r4
            r4 = r5
            r0 = r11
            goto L_0x00d2
        L_0x00a4:
            int r0 = r3 + 1
            char r3 = r4[r3]
            r15 = r11
            r11 = r0
            r0 = r15
            r16 = r4
            r4 = r3
            r3 = r16
        L_0x00b0:
            int r12 = r2.f7094a
            int[] r13 = defpackage.C1512zE.c
            r12 = r13[r12]
            char[] r13 = defpackage.C1512zE.b
            char r13 = r13[r4]
            int r12 = r12 + r13
            int[] r13 = defpackage.C1512zE.d
            r12 = r13[r12]
            if (r12 != r5) goto L_0x00c2
            goto L_0x00d2
        L_0x00c2:
            r2.f7094a = r12
            int[] r13 = defpackage.C1512zE.e
            r13 = r13[r12]
            r14 = r13 & 1
            if (r14 != r9) goto L_0x020f
            r6 = r13 & 8
            if (r6 != r8) goto L_0x020d
            r6 = r11
            r7 = r12
        L_0x00d2:
            r2.f7100c = r6
            if (r7 >= 0) goto L_0x00d7
            goto L_0x00db
        L_0x00d7:
            int[] r6 = defpackage.C1512zE.f7093b
            r7 = r6[r7]
        L_0x00db:
            r6 = 0
            r11 = 2
            switch(r7) {
                case 1: goto L_0x01e1;
                case 2: goto L_0x01c7;
                case 3: goto L_0x0008;
                case 4: goto L_0x01ba;
                case 5: goto L_0x01b4;
                case 6: goto L_0x01ae;
                case 7: goto L_0x01a7;
                case 8: goto L_0x01a0;
                case 9: goto L_0x0199;
                case 10: goto L_0x0192;
                case 11: goto L_0x0187;
                case 12: goto L_0x017e;
                case 13: goto L_0x016e;
                case 14: goto L_0x0165;
                case 15: goto L_0x015c;
                case 16: goto L_0x0155;
                case 17: goto L_0x014c;
                case 18: goto L_0x0143;
                case 19: goto L_0x013a;
                case 20: goto L_0x0131;
                case 21: goto L_0x0122;
                case 22: goto L_0x011b;
                case 23: goto L_0x010c;
                case 24: goto L_0x00ed;
                case 25: goto L_0x0008;
                case 26: goto L_0x0008;
                case 27: goto L_0x0008;
                case 28: goto L_0x0008;
                case 29: goto L_0x0008;
                case 30: goto L_0x0008;
                case 31: goto L_0x0008;
                case 32: goto L_0x0008;
                case 33: goto L_0x0008;
                case 34: goto L_0x0008;
                case 35: goto L_0x0008;
                case 36: goto L_0x0008;
                case 37: goto L_0x0008;
                case 38: goto L_0x0008;
                case 39: goto L_0x0008;
                case 40: goto L_0x0008;
                case 41: goto L_0x0008;
                case 42: goto L_0x0008;
                case 43: goto L_0x0008;
                case 44: goto L_0x0008;
                case 45: goto L_0x0008;
                case 46: goto L_0x0008;
                case 47: goto L_0x0008;
                case 48: goto L_0x0008;
                default: goto L_0x00e0;
            }
        L_0x00e0:
            if (r4 != r5) goto L_0x0200
            int r0 = r2.f7102e
            int r3 = r2.f7101d
            if (r0 != r3) goto L_0x0200
            r2.f7097a = r9
            r2 = r6
            goto L_0x01f4
        L_0x00ed:
            java.lang.String r4 = r2.a()     // Catch:{ Exception -> 0x0103 }
            java.lang.String r4 = r4.substring(r11)     // Catch:{ Exception -> 0x0103 }
            r5 = 16
            int r4 = java.lang.Integer.parseInt(r4, r5)     // Catch:{ Exception -> 0x0103 }
            java.lang.StringBuilder r5 = r2.f7096a     // Catch:{ Exception -> 0x0103 }
            char r4 = (char) r4     // Catch:{ Exception -> 0x0103 }
            r5.append(r4)     // Catch:{ Exception -> 0x0103 }
            goto L_0x0008
        L_0x0103:
            r0 = move-exception
            Go r3 = new Go
            int r2 = r2.g
            r3.<init>(r2, r11, r0)
            throw r3
        L_0x010c:
            java.lang.String r0 = r2.a()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            Qp r2 = new Qp
            r2.<init>(r10, r9, r0)
            goto L_0x01f4
        L_0x011b:
            Qp r2 = new Qp
            r2.<init>(r10, r9, r6)
            goto L_0x01f4
        L_0x0122:
            java.lang.String r0 = r2.a()
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            Qp r2 = new Qp
            r2.<init>(r10, r9, r0)
            goto L_0x01f4
        L_0x0131:
            java.lang.StringBuilder r4 = r2.f7096a
            r5 = 9
            r4.append(r5)
            goto L_0x0008
        L_0x013a:
            java.lang.StringBuilder r4 = r2.f7096a
            r5 = 13
            r4.append(r5)
            goto L_0x0008
        L_0x0143:
            java.lang.StringBuilder r4 = r2.f7096a
            r5 = 10
            r4.append(r5)
            goto L_0x0008
        L_0x014c:
            java.lang.StringBuilder r4 = r2.f7096a
            r5 = 12
            r4.append(r5)
            goto L_0x0008
        L_0x0155:
            java.lang.StringBuilder r4 = r2.f7096a
            r4.append(r8)
            goto L_0x0008
        L_0x015c:
            java.lang.StringBuilder r4 = r2.f7096a
            r5 = 47
            r4.append(r5)
            goto L_0x0008
        L_0x0165:
            java.lang.StringBuilder r4 = r2.f7096a
            r5 = 34
            r4.append(r5)
            goto L_0x0008
        L_0x016e:
            r2.f7099b = r10
            Qp r0 = new Qp
            java.lang.StringBuilder r2 = r2.f7096a
            java.lang.String r2 = r2.toString()
            r0.<init>(r10, r9, r2)
        L_0x017b:
            r2 = r0
            goto L_0x01f4
        L_0x017e:
            java.lang.StringBuilder r4 = r2.f7096a
            r5 = 92
            r4.append(r5)
            goto L_0x0008
        L_0x0187:
            java.lang.StringBuilder r4 = r2.f7096a
            java.lang.String r5 = r2.a()
            r4.append(r5)
            goto L_0x0008
        L_0x0192:
            Qp r2 = new Qp
            r0 = 6
            r2.<init>(r0, r9, r6)
            goto L_0x01f4
        L_0x0199:
            Qp r2 = new Qp
            r0 = 5
            r2.<init>(r0, r9, r6)
            goto L_0x01f4
        L_0x01a0:
            Qp r2 = new Qp
            r0 = 4
            r2.<init>(r0, r9, r6)
            goto L_0x01f4
        L_0x01a7:
            Qp r2 = new Qp
            r0 = 3
            r2.<init>(r0, r9, r6)
            goto L_0x01f4
        L_0x01ae:
            Qp r2 = new Qp
            r2.<init>(r11, r9, r6)
            goto L_0x01f4
        L_0x01b4:
            Qp r2 = new Qp
            r2.<init>(r9, r9, r6)
            goto L_0x01f4
        L_0x01ba:
            r2.f7096a = r6
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r2.f7096a = r4
            r2.f7099b = r11
            goto L_0x0008
        L_0x01c7:
            java.lang.String r0 = r2.a()
            java.lang.Long r2 = java.lang.Long.valueOf(r0)     // Catch:{ NumberFormatException -> 0x01d6 }
            Qp r3 = new Qp     // Catch:{ NumberFormatException -> 0x01d6 }
            r3.<init>(r10, r9, r2)     // Catch:{ NumberFormatException -> 0x01d6 }
            r2 = r3
            goto L_0x01f4
        L_0x01d6:
            java.math.BigInteger r2 = new java.math.BigInteger
            r2.<init>(r0)
            Qp r0 = new Qp
            r0.<init>(r10, r9, r2)
            goto L_0x017b
        L_0x01e1:
            Go r0 = new Go
            int r3 = r2.g
            char[] r4 = r2.f7098a
            int r2 = r2.f7102e
            int r2 = r2 + r10
            char r2 = r4[r2]
            java.lang.Character r2 = java.lang.Character.valueOf(r2)
            r0.<init>(r3, r10, r2)
            throw r0
        L_0x01f4:
            r1.f3586a = r2
            if (r2 != 0) goto L_0x01ff
            Qp r0 = new Qp
            r0.<init>(r5, r9, r6)
            r1.f3586a = r0
        L_0x01ff:
            return
        L_0x0200:
            java.lang.String[] r0 = defpackage.C1512zE.f7092a
            r0 = r0[r9]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0205 }
            goto L_0x0207
        L_0x0205:
            r0 = r0[r10]
        L_0x0207:
            java.lang.Error r2 = new java.lang.Error
            r2.<init>(r0)
            throw r2
        L_0x020d:
            r6 = r11
            r7 = r12
        L_0x020f:
            r4 = r11
            goto L_0x0022
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Fg.a():void");
    }

    public final Object b(StringReader stringReader) throws IOException, Go {
        C1512zE zEVar = this.f3587a;
        zEVar.f7095a = stringReader;
        zEVar.f7097a = false;
        zEVar.f7102e = 0;
        zEVar.f = 0;
        zEVar.f7100c = 0;
        zEVar.f7101d = 0;
        zEVar.g = 0;
        zEVar.f7099b = 0;
        this.f3586a = null;
        this.a = 0;
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        do {
            try {
                a();
                int i = this.a;
                if (i != -1) {
                    if (i == 0) {
                        int i2 = this.f3586a.b;
                        if (i2 == 0) {
                            this.a = 1;
                            linkedList.addFirst(1);
                            linkedList2.addFirst(this.f3586a.f491a);
                        } else if (i2 == 1) {
                            this.a = 2;
                            linkedList.addFirst(2);
                            linkedList2.addFirst(new Vg.b());
                        } else if (i2 != 3) {
                            this.a = -1;
                        } else {
                            this.a = 3;
                            linkedList.addFirst(3);
                            linkedList2.addFirst(new ArrayList());
                        }
                    } else if (i != 1) {
                        if (i == 2) {
                            Qp qp = this.f3586a;
                            int i3 = qp.b;
                            if (i3 == 0) {
                                Object obj = qp.f491a;
                                if (obj instanceof String) {
                                    linkedList2.addFirst((String) obj);
                                    this.a = 4;
                                    linkedList.addFirst(4);
                                } else {
                                    this.a = -1;
                                }
                            } else if (i3 != 2) {
                                if (i3 != 5) {
                                    this.a = -1;
                                }
                            } else if (linkedList2.size() > 1) {
                                linkedList.removeFirst();
                                linkedList2.removeFirst();
                                this.a = d(linkedList);
                            } else {
                                this.a = 1;
                            }
                        } else if (i == 3) {
                            int i4 = this.f3586a.b;
                            if (i4 == 0) {
                                ((List) linkedList2.getFirst()).add(this.f3586a.f491a);
                            } else if (i4 == 1) {
                                Vg.b bVar = new Vg.b();
                                ((List) linkedList2.getFirst()).add(bVar);
                                this.a = 2;
                                linkedList.addFirst(2);
                                linkedList2.addFirst(bVar);
                            } else if (i4 == 3) {
                                ArrayList arrayList = new ArrayList();
                                ((List) linkedList2.getFirst()).add(arrayList);
                                this.a = 3;
                                linkedList.addFirst(3);
                                linkedList2.addFirst(arrayList);
                            } else if (i4 != 4) {
                                if (i4 != 5) {
                                    this.a = -1;
                                }
                            } else if (linkedList2.size() > 1) {
                                linkedList.removeFirst();
                                linkedList2.removeFirst();
                                this.a = d(linkedList);
                            } else {
                                this.a = 1;
                            }
                        } else if (i == 4) {
                            int i5 = this.f3586a.b;
                            if (i5 == 0) {
                                linkedList.removeFirst();
                                ((Map) linkedList2.getFirst()).put((String) linkedList2.removeFirst(), this.f3586a.f491a);
                                this.a = d(linkedList);
                            } else if (i5 == 1) {
                                linkedList.removeFirst();
                                Map map = (Map) linkedList2.getFirst();
                                Vg.b bVar2 = new Vg.b();
                                map.put((String) linkedList2.removeFirst(), bVar2);
                                this.a = 2;
                                linkedList.addFirst(2);
                                linkedList2.addFirst(bVar2);
                            } else if (i5 == 3) {
                                linkedList.removeFirst();
                                Map map2 = (Map) linkedList2.getFirst();
                                ArrayList arrayList2 = new ArrayList();
                                map2.put((String) linkedList2.removeFirst(), arrayList2);
                                this.a = 3;
                                linkedList.addFirst(3);
                                linkedList2.addFirst(arrayList2);
                            } else if (i5 != 6) {
                                this.a = -1;
                            }
                        }
                    } else if (this.f3586a.b == -1) {
                        return linkedList2.removeFirst();
                    } else {
                        throw new Go(zEVar.g, 1, this.f3586a);
                    }
                    if (this.a == -1) {
                        throw new Go(zEVar.g, 1, this.f3586a);
                    }
                } else {
                    throw new Go(zEVar.g, 1, this.f3586a);
                }
            } catch (IOException e) {
                throw e;
            }
        } while (this.f3586a.b != -1);
        throw new Go(zEVar.g, 1, this.f3586a);
    }

    public final Object c(String str) throws Go {
        try {
            return b(new StringReader(str));
        } catch (IOException e) {
            throw new Go(-1, 2, e);
        }
    }
}
