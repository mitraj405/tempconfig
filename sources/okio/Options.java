package okio;

import com.google.common.primitives.UnsignedBytes;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.RandomAccess;

public final class Options extends AbstractList<ByteString> implements RandomAccess {
    public final int[] a;

    /* renamed from: a  reason: collision with other field name */
    public final ByteString[] f5632a;

    public Options(ByteString[] byteStringArr, int[] iArr) {
        this.f5632a = byteStringArr;
        this.a = iArr;
    }

    public static void a(long j, Buffer buffer, int i, ArrayList arrayList, int i2, int i3, ArrayList arrayList2) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Buffer buffer2;
        Buffer buffer3 = buffer;
        int i9 = i;
        ArrayList arrayList3 = arrayList;
        int i10 = i2;
        int i11 = i3;
        ArrayList arrayList4 = arrayList2;
        if (i10 < i11) {
            int i12 = i10;
            while (i12 < i11) {
                if (((ByteString) arrayList3.get(i12)).A() >= i9) {
                    i12++;
                } else {
                    throw new AssertionError();
                }
            }
            ByteString byteString = (ByteString) arrayList.get(i2);
            ByteString byteString2 = (ByteString) arrayList3.get(i11 - 1);
            if (i9 == byteString.A()) {
                int intValue = ((Integer) arrayList4.get(i10)).intValue();
                int i13 = i10 + 1;
                i4 = i13;
                i5 = intValue;
                byteString = (ByteString) arrayList3.get(i13);
            } else {
                i5 = -1;
                i4 = i10;
            }
            long j2 = 4;
            if (byteString.n(i9) != byteString2.n(i9)) {
                int i14 = 1;
                for (int i15 = i4 + 1; i15 < i11; i15++) {
                    if (((ByteString) arrayList3.get(i15 - 1)).n(i9) != ((ByteString) arrayList3.get(i15)).n(i9)) {
                        i14++;
                    }
                }
                long j3 = j + ((long) ((int) (buffer3.f5623a / 4))) + 2 + ((long) (i14 * 2));
                buffer3.G(i14);
                buffer3.G(i5);
                for (int i16 = i4; i16 < i11; i16++) {
                    byte n = ((ByteString) arrayList3.get(i16)).n(i9);
                    if (i16 == i4 || n != ((ByteString) arrayList3.get(i16 - 1)).n(i9)) {
                        buffer3.G(n & UnsignedBytes.MAX_VALUE);
                    }
                }
                Buffer buffer4 = new Buffer();
                int i17 = i4;
                while (i17 < i11) {
                    byte n2 = ((ByteString) arrayList3.get(i17)).n(i9);
                    int i18 = i17 + 1;
                    int i19 = i18;
                    while (true) {
                        if (i19 >= i11) {
                            i7 = i11;
                            break;
                        } else if (n2 != ((ByteString) arrayList3.get(i19)).n(i9)) {
                            i7 = i19;
                            break;
                        } else {
                            i19++;
                        }
                    }
                    if (i18 == i7 && i9 + 1 == ((ByteString) arrayList3.get(i17)).A()) {
                        buffer3.G(((Integer) arrayList4.get(i17)).intValue());
                        i8 = i7;
                        buffer2 = buffer4;
                    } else {
                        buffer3.G((int) ((((long) ((int) (buffer4.f5623a / j2))) + j3) * -1));
                        i8 = i7;
                        buffer2 = buffer4;
                        a(j3, buffer4, i9 + 1, arrayList, i17, i7, arrayList2);
                    }
                    buffer4 = buffer2;
                    i17 = i8;
                    j2 = 4;
                }
                Buffer buffer5 = buffer4;
                buffer3.write(buffer5, buffer5.f5623a);
                return;
            }
            int min = Math.min(byteString.A(), byteString2.A());
            int i20 = 0;
            int i21 = i9;
            while (i21 < min && byteString.n(i21) == byteString2.n(i21)) {
                i20++;
                i21++;
            }
            long j4 = 1 + j + ((long) ((int) (buffer3.f5623a / 4))) + 2 + ((long) i20);
            buffer3.G(-i20);
            buffer3.G(i5);
            int i22 = i9;
            while (true) {
                i6 = i9 + i20;
                if (i22 >= i6) {
                    break;
                }
                buffer3.G(byteString.n(i22) & UnsignedBytes.MAX_VALUE);
                i22++;
            }
            if (i4 + 1 != i11) {
                Buffer buffer6 = new Buffer();
                buffer3.G((int) ((((long) ((int) (buffer6.f5623a / 4))) + j4) * -1));
                a(j4, buffer6, i6, arrayList, i4, i3, arrayList2);
                buffer3.write(buffer6, buffer6.f5623a);
            } else if (i6 == ((ByteString) arrayList3.get(i4)).A()) {
                buffer3.G(((Integer) arrayList4.get(i4)).intValue());
            } else {
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
    }

    public static Options b(ByteString... byteStringArr) {
        if (byteStringArr.length == 0) {
            return new Options(new ByteString[0], new int[]{0, -1});
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(byteStringArr));
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(-1);
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.set(Collections.binarySearch(arrayList, byteStringArr[i2]), Integer.valueOf(i2));
        }
        if (((ByteString) arrayList.get(0)).A() != 0) {
            int i3 = 0;
            while (i3 < arrayList.size()) {
                ByteString byteString = (ByteString) arrayList.get(i3);
                int i4 = i3 + 1;
                int i5 = i4;
                while (i5 < arrayList.size()) {
                    ByteString byteString2 = (ByteString) arrayList.get(i5);
                    byteString2.getClass();
                    if (!byteString2.z(byteString, byteString.A())) {
                        continue;
                        break;
                    } else if (byteString2.A() == byteString.A()) {
                        throw new IllegalArgumentException("duplicate option: " + byteString2);
                    } else if (((Integer) arrayList2.get(i5)).intValue() > ((Integer) arrayList2.get(i3)).intValue()) {
                        arrayList.remove(i5);
                        arrayList2.remove(i5);
                    } else {
                        i5++;
                    }
                }
                i3 = i4;
            }
            Buffer buffer = new Buffer();
            a(0, buffer, 0, arrayList, 0, arrayList.size(), arrayList2);
            int i6 = (int) (buffer.f5623a / 4);
            int[] iArr = new int[i6];
            for (int i7 = 0; i7 < i6; i7++) {
                iArr[i7] = buffer.readInt();
            }
            if (buffer.h0()) {
                return new Options((ByteString[]) byteStringArr.clone(), iArr);
            }
            throw new AssertionError();
        }
        throw new IllegalArgumentException("the empty byte string is not a supported option");
    }

    public final Object get(int i) {
        return this.f5632a[i];
    }

    public final int size() {
        return this.f5632a.length;
    }
}
