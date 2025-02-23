package defpackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: Bq  reason: default package */
/* compiled from: ProfileTranscoder */
public final class Bq {
    public static final byte[] a = {112, 114, 111, 0};
    public static final byte[] b = {112, 114, 109, 0};

    public static byte[] a(S8[] s8Arr, byte[] bArr) throws IOException {
        int i = 0;
        int i2 = 0;
        for (S8 s8 : s8Arr) {
            i2 += (((((s8.c * 2) + 8) - 1) & -8) / 8) + (s8.a * 2) + b(s8.f507a, s8.f511b, bArr).getBytes(StandardCharsets.UTF_8).length + 16 + s8.b;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2);
        if (Arrays.equals(bArr, Cq.c)) {
            int length = s8Arr.length;
            while (i < length) {
                S8 s82 = s8Arr[i];
                l(byteArrayOutputStream, s82, b(s82.f507a, s82.f511b, bArr));
                n(byteArrayOutputStream, s82);
                k(byteArrayOutputStream, s82);
                m(byteArrayOutputStream, s82);
                i++;
            }
        } else {
            for (S8 s83 : s8Arr) {
                l(byteArrayOutputStream, s83, b(s83.f507a, s83.f511b, bArr));
            }
            int length2 = s8Arr.length;
            while (i < length2) {
                S8 s84 = s8Arr[i];
                n(byteArrayOutputStream, s84);
                k(byteArrayOutputStream, s84);
                m(byteArrayOutputStream, s84);
                i++;
            }
        }
        if (byteArrayOutputStream.size() == i2) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new IllegalStateException("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + i2);
    }

    public static String b(String str, String str2, byte[] bArr) {
        String str3;
        byte[] bArr2 = Cq.e;
        boolean equals = Arrays.equals(bArr, bArr2);
        byte[] bArr3 = Cq.d;
        String str4 = "!";
        if (!equals && !Arrays.equals(bArr, bArr3)) {
            str3 = str4;
        } else {
            str3 = ":";
        }
        if (str.length() <= 0) {
            if (str4.equals(str3)) {
                return str2.replace(":", str4);
            }
            if (":".equals(str3)) {
                str2 = str2.replace(str4, ":");
            }
            return str2;
        } else if (str2.equals("classes.dex")) {
            return str;
        } else {
            if (str2.contains(str4) || str2.contains(":")) {
                if (str4.equals(str3)) {
                    return str2.replace(":", str4);
                }
                if (":".equals(str3)) {
                    str2 = str2.replace(str4, ":");
                }
                return str2;
            } else if (str2.endsWith(".apk")) {
                return str2;
            } else {
                StringBuilder J = xx.J(str);
                if (Arrays.equals(bArr, bArr2) || Arrays.equals(bArr, bArr3)) {
                    str4 = ":";
                }
                return C0709Uj.j(J, str4, str2);
            }
        }
    }

    public static int c(int i, int i2, int i3) {
        if (i == 1) {
            throw new IllegalStateException("HOT methods are not stored in the bitmap");
        } else if (i == 2) {
            return i2;
        } else {
            if (i == 4) {
                return i2 + i3;
            }
            throw new IllegalStateException(lf.h("Unexpected flag: ", i));
        }
    }

    public static int[] d(int i, ByteArrayInputStream byteArrayInputStream) throws IOException {
        int[] iArr = new int[i];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += C1354qp.q0(byteArrayInputStream);
            iArr[i3] = i2;
        }
        return iArr;
    }

    public static S8[] e(FileInputStream fileInputStream, byte[] bArr, byte[] bArr2, S8[] s8Arr) throws IOException {
        byte[] bArr3 = Cq.f;
        if (Arrays.equals(bArr, bArr3)) {
            if (Arrays.equals(Cq.a, bArr2)) {
                throw new IllegalStateException("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            } else if (Arrays.equals(bArr, bArr3)) {
                int p0 = (int) C1354qp.p0(1, fileInputStream);
                byte[] m0 = C1354qp.m0(fileInputStream, (int) C1354qp.p0(4, fileInputStream), (int) C1354qp.p0(4, fileInputStream));
                if (fileInputStream.read() <= 0) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(m0);
                    try {
                        S8[] f = f(byteArrayInputStream, p0, s8Arr);
                        byteArrayInputStream.close();
                        return f;
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                } else {
                    throw new IllegalStateException("Content found after the end of file");
                }
            } else {
                throw new IllegalStateException("Unsupported meta version");
            }
        } else if (Arrays.equals(bArr, Cq.g)) {
            int q0 = C1354qp.q0(fileInputStream);
            byte[] m02 = C1354qp.m0(fileInputStream, (int) C1354qp.p0(4, fileInputStream), (int) C1354qp.p0(4, fileInputStream));
            if (fileInputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(m02);
                try {
                    S8[] g = g(byteArrayInputStream2, bArr2, q0, s8Arr);
                    byteArrayInputStream2.close();
                    return g;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            } else {
                throw new IllegalStateException("Content found after the end of file");
            }
        } else {
            throw new IllegalStateException("Unsupported meta version");
        }
        throw th;
        throw th;
    }

    public static S8[] f(ByteArrayInputStream byteArrayInputStream, int i, S8[] s8Arr) throws IOException {
        int i2 = 0;
        if (byteArrayInputStream.available() == 0) {
            return new S8[0];
        }
        if (i == s8Arr.length) {
            String[] strArr = new String[i];
            int[] iArr = new int[i];
            for (int i3 = 0; i3 < i; i3++) {
                int q0 = C1354qp.q0(byteArrayInputStream);
                iArr[i3] = C1354qp.q0(byteArrayInputStream);
                strArr[i3] = new String(C1354qp.l0(q0, byteArrayInputStream), StandardCharsets.UTF_8);
            }
            while (i2 < i) {
                S8 s8 = s8Arr[i2];
                if (s8.f511b.equals(strArr[i2])) {
                    int i4 = iArr[i2];
                    s8.a = i4;
                    s8.f509a = d(i4, byteArrayInputStream);
                    i2++;
                } else {
                    throw new IllegalStateException("Order of dexfiles in metadata did not match baseline");
                }
            }
            return s8Arr;
        }
        throw new IllegalStateException("Mismatched number of dex files found in metadata");
    }

    public static S8[] g(ByteArrayInputStream byteArrayInputStream, byte[] bArr, int i, S8[] s8Arr) throws IOException {
        S8 s8;
        String str;
        if (byteArrayInputStream.available() == 0) {
            return new S8[0];
        }
        if (i == s8Arr.length) {
            int i2 = 0;
            while (i2 < i) {
                C1354qp.q0(byteArrayInputStream);
                String str2 = new String(C1354qp.l0(C1354qp.q0(byteArrayInputStream), byteArrayInputStream), StandardCharsets.UTF_8);
                long p0 = C1354qp.p0(4, byteArrayInputStream);
                int q0 = C1354qp.q0(byteArrayInputStream);
                if (s8Arr.length > 0) {
                    int indexOf = str2.indexOf("!");
                    if (indexOf < 0) {
                        indexOf = str2.indexOf(":");
                    }
                    if (indexOf > 0) {
                        str = str2.substring(indexOf + 1);
                    } else {
                        str = str2;
                    }
                    int i3 = 0;
                    while (true) {
                        if (i3 >= s8Arr.length) {
                            break;
                        } else if (s8Arr[i3].f511b.equals(str)) {
                            s8 = s8Arr[i3];
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                s8 = null;
                if (s8 != null) {
                    s8.f510b = p0;
                    int[] d = d(q0, byteArrayInputStream);
                    if (Arrays.equals(bArr, Cq.e)) {
                        s8.a = q0;
                        s8.f509a = d;
                    }
                    i2++;
                } else {
                    throw new IllegalStateException("Missing profile key: ".concat(str2));
                }
            }
            return s8Arr;
        }
        throw new IllegalStateException("Mismatched number of dex files found in metadata");
    }

    public static S8[] h(FileInputStream fileInputStream, byte[] bArr, String str) throws IOException {
        if (Arrays.equals(bArr, Cq.b)) {
            int p0 = (int) C1354qp.p0(1, fileInputStream);
            byte[] m0 = C1354qp.m0(fileInputStream, (int) C1354qp.p0(4, fileInputStream), (int) C1354qp.p0(4, fileInputStream));
            if (fileInputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(m0);
                try {
                    S8[] i = i(byteArrayInputStream, str, p0);
                    byteArrayInputStream.close();
                    return i;
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            } else {
                throw new IllegalStateException("Content found after the end of file");
            }
        } else {
            throw new IllegalStateException("Unsupported version");
        }
        throw th;
    }

    public static S8[] i(ByteArrayInputStream byteArrayInputStream, String str, int i) throws IOException {
        TreeMap<Integer, Integer> treeMap;
        ByteArrayInputStream byteArrayInputStream2 = byteArrayInputStream;
        int i2 = i;
        if (byteArrayInputStream.available() == 0) {
            return new S8[0];
        }
        S8[] s8Arr = new S8[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int q0 = C1354qp.q0(byteArrayInputStream);
            int q02 = C1354qp.q0(byteArrayInputStream);
            long p0 = C1354qp.p0(4, byteArrayInputStream2);
            String str2 = str;
            s8Arr[i3] = new S8(str2, new String(C1354qp.l0(q0, byteArrayInputStream2), StandardCharsets.UTF_8), C1354qp.p0(4, byteArrayInputStream2), q02, (int) p0, (int) C1354qp.p0(4, byteArrayInputStream2), new int[q02], new TreeMap());
        }
        int i4 = 0;
        while (i4 < i2) {
            S8 s8 = s8Arr[i4];
            int available = byteArrayInputStream.available() - s8.b;
            int i5 = 0;
            while (true) {
                int available2 = byteArrayInputStream.available();
                treeMap = s8.f508a;
                if (available2 <= available) {
                    break;
                }
                i5 += C1354qp.q0(byteArrayInputStream);
                treeMap.put(Integer.valueOf(i5), 1);
                for (int q03 = C1354qp.q0(byteArrayInputStream); q03 > 0; q03--) {
                    C1354qp.q0(byteArrayInputStream);
                    int p02 = (int) C1354qp.p0(1, byteArrayInputStream2);
                    if (!(p02 == 6 || p02 == 7)) {
                        while (p02 > 0) {
                            C1354qp.p0(1, byteArrayInputStream2);
                            for (int p03 = (int) C1354qp.p0(1, byteArrayInputStream2); p03 > 0; p03--) {
                                C1354qp.q0(byteArrayInputStream);
                            }
                            p02--;
                        }
                    }
                }
            }
            if (byteArrayInputStream.available() == available) {
                s8.f509a = d(s8.a, byteArrayInputStream2);
                int i6 = s8.c;
                BitSet valueOf = BitSet.valueOf(C1354qp.l0(((((i6 * 2) + 8) - 1) & -8) / 8, byteArrayInputStream2));
                for (int i7 = 0; i7 < i6; i7++) {
                    int i8 = 2;
                    if (!valueOf.get(c(2, i7, i6))) {
                        i8 = 0;
                    }
                    if (valueOf.get(c(4, i7, i6))) {
                        i8 |= 4;
                    }
                    if (i8 != 0) {
                        Integer num = treeMap.get(Integer.valueOf(i7));
                        if (num == null) {
                            num = 0;
                        }
                        treeMap.put(Integer.valueOf(i7), Integer.valueOf(i8 | num.intValue()));
                    }
                }
                i4++;
            } else {
                throw new IllegalStateException("Read too much data during profile line parse");
            }
        }
        return s8Arr;
    }

    /* JADX INFO: finally extract failed */
    public static boolean j(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, S8[] s8Arr) throws IOException {
        Throwable th;
        Throwable th2;
        ArrayList arrayList;
        int i;
        ByteArrayOutputStream byteArrayOutputStream2;
        Throwable th3;
        ByteArrayOutputStream byteArrayOutputStream3;
        Throwable th4;
        ByteArrayOutputStream byteArrayOutputStream4 = byteArrayOutputStream;
        byte[] bArr2 = bArr;
        S8[] s8Arr2 = s8Arr;
        byte[] bArr3 = Cq.a;
        int i2 = 0;
        if (Arrays.equals(bArr2, bArr3)) {
            ArrayList arrayList2 = new ArrayList(3);
            ArrayList arrayList3 = new ArrayList(3);
            ByteArrayOutputStream byteArrayOutputStream5 = new ByteArrayOutputStream();
            try {
                C1354qp.Q0(byteArrayOutputStream5, s8Arr2.length);
                int i3 = 2;
                int i4 = 2;
                for (S8 s8 : s8Arr2) {
                    C1354qp.P0(byteArrayOutputStream5, s8.f506a, 4);
                    C1354qp.P0(byteArrayOutputStream5, s8.f510b, 4);
                    C1354qp.P0(byteArrayOutputStream5, (long) s8.c, 4);
                    String b2 = b(s8.f507a, s8.f511b, bArr3);
                    int length = b2.getBytes(StandardCharsets.UTF_8).length;
                    C1354qp.Q0(byteArrayOutputStream5, length);
                    i4 = i4 + 4 + 4 + 4 + 2 + (length * 1);
                    byteArrayOutputStream5.write(b2.getBytes(StandardCharsets.UTF_8));
                }
                byte[] byteArray = byteArrayOutputStream5.toByteArray();
                if (i4 == byteArray.length) {
                    vE vEVar = new vE(1, byteArray, false);
                    byteArrayOutputStream5.close();
                    arrayList2.add(vEVar);
                    ByteArrayOutputStream byteArrayOutputStream6 = new ByteArrayOutputStream();
                    int i5 = 0;
                    int i6 = 0;
                    while (i5 < s8Arr2.length) {
                        try {
                            S8 s82 = s8Arr2[i5];
                            C1354qp.Q0(byteArrayOutputStream6, i5);
                            C1354qp.Q0(byteArrayOutputStream6, s82.a);
                            i6 = i6 + 2 + 2 + (s82.a * 2);
                            k(byteArrayOutputStream6, s82);
                            i5++;
                        } catch (Throwable th5) {
                            th2.addSuppressed(th5);
                        }
                    }
                    byte[] byteArray2 = byteArrayOutputStream6.toByteArray();
                    if (i6 == byteArray2.length) {
                        vE vEVar2 = new vE(3, byteArray2, true);
                        byteArrayOutputStream6.close();
                        arrayList2.add(vEVar2);
                        ByteArrayOutputStream byteArrayOutputStream7 = new ByteArrayOutputStream();
                        int i7 = 0;
                        int i8 = 0;
                        while (i7 < s8Arr2.length) {
                            try {
                                S8 s83 = s8Arr2[i7];
                                int i9 = i2;
                                for (Map.Entry<Integer, Integer> value : s83.f508a.entrySet()) {
                                    i9 |= ((Integer) value.getValue()).intValue();
                                }
                                byteArrayOutputStream2 = new ByteArrayOutputStream();
                                m(byteArrayOutputStream2, s83);
                                byte[] byteArray3 = byteArrayOutputStream2.toByteArray();
                                byteArrayOutputStream2.close();
                                byteArrayOutputStream3 = new ByteArrayOutputStream();
                                n(byteArrayOutputStream3, s83);
                                byte[] byteArray4 = byteArrayOutputStream3.toByteArray();
                                byteArrayOutputStream3.close();
                                C1354qp.Q0(byteArrayOutputStream7, i7);
                                int length2 = byteArray3.length + i3 + byteArray4.length;
                                int i10 = i8 + 2 + 4;
                                ArrayList arrayList4 = arrayList3;
                                C1354qp.P0(byteArrayOutputStream7, (long) length2, 4);
                                C1354qp.Q0(byteArrayOutputStream7, i9);
                                byteArrayOutputStream7.write(byteArray3);
                                byteArrayOutputStream7.write(byteArray4);
                                i8 = i10 + length2;
                                i7++;
                                arrayList3 = arrayList4;
                                i2 = 0;
                                i3 = 2;
                            } catch (Throwable th6) {
                                Throwable th7 = th6;
                                try {
                                    byteArrayOutputStream7.close();
                                } catch (Throwable th8) {
                                    th7.addSuppressed(th8);
                                }
                                throw th7;
                            }
                        }
                        ArrayList arrayList5 = arrayList3;
                        byte[] byteArray5 = byteArrayOutputStream7.toByteArray();
                        if (i8 == byteArray5.length) {
                            vE vEVar3 = new vE(4, byteArray5, true);
                            byteArrayOutputStream7.close();
                            arrayList2.add(vEVar3);
                            long j = (long) 4;
                            long size = j + j + 4 + ((long) (arrayList2.size() * 16));
                            C1354qp.P0(byteArrayOutputStream4, (long) arrayList2.size(), 4);
                            int i11 = 0;
                            while (i11 < arrayList2.size()) {
                                vE vEVar4 = (vE) arrayList2.get(i11);
                                C1354qp.P0(byteArrayOutputStream4, xx.s(vEVar4.a), 4);
                                C1354qp.P0(byteArrayOutputStream4, size, 4);
                                boolean z = vEVar4.f3368a;
                                byte[] bArr4 = vEVar4.f3369a;
                                if (z) {
                                    byte[] z2 = C1354qp.z(bArr4);
                                    arrayList = arrayList5;
                                    arrayList.add(z2);
                                    C1354qp.P0(byteArrayOutputStream4, (long) z2.length, 4);
                                    C1354qp.P0(byteArrayOutputStream4, (long) bArr4.length, 4);
                                    i = z2.length;
                                } else {
                                    arrayList = arrayList5;
                                    arrayList.add(bArr4);
                                    C1354qp.P0(byteArrayOutputStream4, (long) bArr4.length, 4);
                                    C1354qp.P0(byteArrayOutputStream4, 0, 4);
                                    i = bArr4.length;
                                }
                                size += (long) i;
                                i11++;
                                arrayList5 = arrayList;
                            }
                            ArrayList arrayList6 = arrayList5;
                            for (int i12 = 0; i12 < arrayList6.size(); i12++) {
                                byteArrayOutputStream4.write((byte[]) arrayList6.get(i12));
                            }
                            return true;
                        }
                        throw new IllegalStateException("Expected size " + i8 + ", does not match actual size " + byteArray5.length);
                    }
                    throw new IllegalStateException("Expected size " + i6 + ", does not match actual size " + byteArray2.length);
                }
                throw new IllegalStateException("Expected size " + i4 + ", does not match actual size " + byteArray.length);
            } catch (Throwable th9) {
                th.addSuppressed(th9);
            }
        } else {
            byte[] bArr5 = Cq.b;
            if (Arrays.equals(bArr2, bArr5)) {
                byte[] a2 = a(s8Arr2, bArr5);
                C1354qp.P0(byteArrayOutputStream4, (long) s8Arr2.length, 1);
                C1354qp.P0(byteArrayOutputStream4, (long) a2.length, 4);
                byte[] z3 = C1354qp.z(a2);
                C1354qp.P0(byteArrayOutputStream4, (long) z3.length, 4);
                byteArrayOutputStream4.write(z3);
                return true;
            }
            byte[] bArr6 = Cq.d;
            if (Arrays.equals(bArr2, bArr6)) {
                C1354qp.P0(byteArrayOutputStream4, (long) s8Arr2.length, 1);
                for (S8 s84 : s8Arr2) {
                    String b3 = b(s84.f507a, s84.f511b, bArr6);
                    C1354qp.Q0(byteArrayOutputStream4, b3.getBytes(StandardCharsets.UTF_8).length);
                    C1354qp.Q0(byteArrayOutputStream4, s84.f509a.length);
                    C1354qp.P0(byteArrayOutputStream4, (long) (s84.f508a.size() * 4), 4);
                    C1354qp.P0(byteArrayOutputStream4, s84.f506a, 4);
                    byteArrayOutputStream4.write(b3.getBytes(StandardCharsets.UTF_8));
                    for (Integer intValue : s84.f508a.keySet()) {
                        C1354qp.Q0(byteArrayOutputStream4, intValue.intValue());
                        C1354qp.Q0(byteArrayOutputStream4, 0);
                    }
                    for (int Q0 : s84.f509a) {
                        C1354qp.Q0(byteArrayOutputStream4, Q0);
                    }
                }
                return true;
            }
            byte[] bArr7 = Cq.c;
            if (Arrays.equals(bArr2, bArr7)) {
                byte[] a3 = a(s8Arr2, bArr7);
                C1354qp.P0(byteArrayOutputStream4, (long) s8Arr2.length, 1);
                C1354qp.P0(byteArrayOutputStream4, (long) a3.length, 4);
                byte[] z4 = C1354qp.z(a3);
                C1354qp.P0(byteArrayOutputStream4, (long) z4.length, 4);
                byteArrayOutputStream4.write(z4);
                return true;
            }
            byte[] bArr8 = Cq.e;
            if (!Arrays.equals(bArr2, bArr8)) {
                return false;
            }
            C1354qp.Q0(byteArrayOutputStream4, s8Arr2.length);
            for (S8 s85 : s8Arr2) {
                String b4 = b(s85.f507a, s85.f511b, bArr8);
                C1354qp.Q0(byteArrayOutputStream4, b4.getBytes(StandardCharsets.UTF_8).length);
                TreeMap<Integer, Integer> treeMap = s85.f508a;
                C1354qp.Q0(byteArrayOutputStream4, treeMap.size());
                C1354qp.Q0(byteArrayOutputStream4, s85.f509a.length);
                C1354qp.P0(byteArrayOutputStream4, s85.f506a, 4);
                byteArrayOutputStream4.write(b4.getBytes(StandardCharsets.UTF_8));
                for (Integer intValue2 : treeMap.keySet()) {
                    C1354qp.Q0(byteArrayOutputStream4, intValue2.intValue());
                }
                for (int Q02 : s85.f509a) {
                    C1354qp.Q0(byteArrayOutputStream4, Q02);
                }
            }
            return true;
        }
        throw th3;
        throw th;
        throw th4;
        throw th2;
    }

    public static void k(ByteArrayOutputStream byteArrayOutputStream, S8 s8) throws IOException {
        int i = 0;
        for (int valueOf : s8.f509a) {
            Integer valueOf2 = Integer.valueOf(valueOf);
            C1354qp.Q0(byteArrayOutputStream, valueOf2.intValue() - i);
            i = valueOf2.intValue();
        }
    }

    public static void l(ByteArrayOutputStream byteArrayOutputStream, S8 s8, String str) throws IOException {
        C1354qp.Q0(byteArrayOutputStream, str.getBytes(StandardCharsets.UTF_8).length);
        C1354qp.Q0(byteArrayOutputStream, s8.a);
        C1354qp.P0(byteArrayOutputStream, (long) s8.b, 4);
        C1354qp.P0(byteArrayOutputStream, s8.f506a, 4);
        C1354qp.P0(byteArrayOutputStream, (long) s8.c, 4);
        byteArrayOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
    }

    public static void m(ByteArrayOutputStream byteArrayOutputStream, S8 s8) throws IOException {
        byte[] bArr = new byte[(((((s8.c * 2) + 8) - 1) & -8) / 8)];
        for (Map.Entry next : s8.f508a.entrySet()) {
            int intValue = ((Integer) next.getKey()).intValue();
            int intValue2 = ((Integer) next.getValue()).intValue();
            int i = intValue2 & 2;
            int i2 = s8.c;
            if (i != 0) {
                int c = c(2, intValue, i2);
                int i3 = c / 8;
                bArr[i3] = (byte) ((1 << (c % 8)) | bArr[i3]);
            }
            if ((intValue2 & 4) != 0) {
                int c2 = c(4, intValue, i2);
                int i4 = c2 / 8;
                bArr[i4] = (byte) ((1 << (c2 % 8)) | bArr[i4]);
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void n(ByteArrayOutputStream byteArrayOutputStream, S8 s8) throws IOException {
        int i = 0;
        for (Map.Entry next : s8.f508a.entrySet()) {
            int intValue = ((Integer) next.getKey()).intValue();
            if ((((Integer) next.getValue()).intValue() & 1) != 0) {
                C1354qp.Q0(byteArrayOutputStream, intValue - i);
                C1354qp.Q0(byteArrayOutputStream, 0);
                i = intValue;
            }
        }
    }
}
