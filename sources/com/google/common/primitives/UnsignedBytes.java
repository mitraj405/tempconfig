package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import sun.misc.Unsafe;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class UnsignedBytes {
    public static final byte MAX_POWER_OF_TWO = Byte.MIN_VALUE;
    public static final byte MAX_VALUE = -1;
    private static final int UNSIGNED_MASK = 255;

    @VisibleForTesting
    public static class LexicographicalComparatorHolder {
        static final Comparator<byte[]> BEST_COMPARATOR = getBestComparator();
        static final String UNSAFE_COMPARATOR_NAME = LexicographicalComparatorHolder.class.getName().concat("$UnsafeComparator");

        public enum PureJavaComparator implements Comparator<byte[]> {
            INSTANCE;

            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (pure Java version)";
            }

            public int compare(byte[] bArr, byte[] bArr2) {
                int min = Math.min(bArr.length, bArr2.length);
                for (int i = 0; i < min; i++) {
                    int compare = UnsignedBytes.compare(bArr[i], bArr2[i]);
                    if (compare != 0) {
                        return compare;
                    }
                }
                return bArr.length - bArr2.length;
            }
        }

        @VisibleForTesting
        public enum UnsafeComparator implements Comparator<byte[]> {
            INSTANCE;
            
            static final boolean BIG_ENDIAN = false;
            static final int BYTE_ARRAY_BASE_OFFSET = 0;
            static final Unsafe theUnsafe = null;

            /* access modifiers changed from: public */
            static {
                BIG_ENDIAN = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
                Unsafe unsafe = getUnsafe();
                theUnsafe = unsafe;
                Class<byte[]> cls = byte[].class;
                int arrayBaseOffset = unsafe.arrayBaseOffset(cls);
                BYTE_ARRAY_BASE_OFFSET = arrayBaseOffset;
                if (!"64".equals(System.getProperty("sun.arch.data.model")) || arrayBaseOffset % 8 != 0 || unsafe.arrayIndexScale(cls) != 1) {
                    throw new Error();
                }
            }

            /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
                return (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.common.primitives.UnsignedBytes.LexicographicalComparatorHolder.UnsafeComparator.AnonymousClass1());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
                throw new java.lang.RuntimeException("Could not initialize intrinsics", r0.getCause());
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0005 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            private static sun.misc.Unsafe getUnsafe() {
                /*
                    sun.misc.Unsafe r0 = sun.misc.Unsafe.getUnsafe()     // Catch:{ SecurityException -> 0x0005 }
                    return r0
                L_0x0005:
                    com.google.common.primitives.UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator$1 r0 = new com.google.common.primitives.UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator$1     // Catch:{ PrivilegedActionException -> 0x0011 }
                    r0.<init>()     // Catch:{ PrivilegedActionException -> 0x0011 }
                    java.lang.Object r0 = java.security.AccessController.doPrivileged(r0)     // Catch:{ PrivilegedActionException -> 0x0011 }
                    sun.misc.Unsafe r0 = (sun.misc.Unsafe) r0     // Catch:{ PrivilegedActionException -> 0x0011 }
                    return r0
                L_0x0011:
                    r0 = move-exception
                    java.lang.RuntimeException r1 = new java.lang.RuntimeException
                    java.lang.String r2 = "Could not initialize intrinsics"
                    java.lang.Throwable r0 = r0.getCause()
                    r1.<init>(r2, r0)
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.UnsignedBytes.LexicographicalComparatorHolder.UnsafeComparator.getUnsafe():sun.misc.Unsafe");
            }

            public String toString() {
                return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
            }

            public int compare(byte[] bArr, byte[] bArr2) {
                int min = Math.min(bArr.length, bArr2.length);
                int i = min & -8;
                int i2 = 0;
                while (i2 < i) {
                    Unsafe unsafe = theUnsafe;
                    int i3 = BYTE_ARRAY_BASE_OFFSET;
                    long j = (long) i2;
                    long j2 = unsafe.getLong(bArr, ((long) i3) + j);
                    long j3 = unsafe.getLong(bArr2, ((long) i3) + j);
                    if (j2 == j3) {
                        i2 += 8;
                    } else if (BIG_ENDIAN) {
                        return UnsignedLongs.compare(j2, j3);
                    } else {
                        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j2 ^ j3) & -8;
                        return ((int) ((j2 >>> numberOfTrailingZeros) & 255)) - ((int) ((j3 >>> numberOfTrailingZeros) & 255));
                    }
                }
                while (i2 < min) {
                    int compare = UnsignedBytes.compare(bArr[i2], bArr2[i2]);
                    if (compare != 0) {
                        return compare;
                    }
                    i2++;
                }
                return bArr.length - bArr2.length;
            }
        }

        public static Comparator<byte[]> getBestComparator() {
            try {
                Object[] enumConstants = Class.forName(UNSAFE_COMPARATOR_NAME).getEnumConstants();
                Objects.requireNonNull(enumConstants);
                return (Comparator) enumConstants[0];
            } catch (Throwable unused) {
                return UnsignedBytes.lexicographicalComparatorJavaImpl();
            }
        }
    }

    private UnsignedBytes() {
    }

    @CanIgnoreReturnValue
    public static byte checkedCast(long j) {
        boolean z;
        if ((j >> 8) == 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "out of range: %s", j);
        return (byte) ((int) j);
    }

    public static int compare(byte b, byte b2) {
        return toInt(b) - toInt(b2);
    }

    private static byte flip(byte b) {
        return (byte) (b ^ MAX_POWER_OF_TWO);
    }

    public static String join(String str, byte... bArr) {
        Preconditions.checkNotNull(str);
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder((str.length() + 3) * bArr.length);
        sb.append(toInt(bArr[0]));
        for (int i = 1; i < bArr.length; i++) {
            sb.append(str);
            sb.append(toString(bArr[i]));
        }
        return sb.toString();
    }

    public static Comparator<byte[]> lexicographicalComparator() {
        return LexicographicalComparatorHolder.BEST_COMPARATOR;
    }

    @VisibleForTesting
    public static Comparator<byte[]> lexicographicalComparatorJavaImpl() {
        return LexicographicalComparatorHolder.PureJavaComparator.INSTANCE;
    }

    public static byte max(byte... bArr) {
        boolean z;
        if (bArr.length > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        int i = toInt(bArr[0]);
        for (int i2 = 1; i2 < bArr.length; i2++) {
            int i3 = toInt(bArr[i2]);
            if (i3 > i) {
                i = i3;
            }
        }
        return (byte) i;
    }

    public static byte min(byte... bArr) {
        boolean z;
        if (bArr.length > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        int i = toInt(bArr[0]);
        for (int i2 = 1; i2 < bArr.length; i2++) {
            int i3 = toInt(bArr[i2]);
            if (i3 < i) {
                i = i3;
            }
        }
        return (byte) i;
    }

    @CanIgnoreReturnValue
    @Beta
    public static byte parseUnsignedByte(String str) {
        return parseUnsignedByte(str, 10);
    }

    public static byte saturatedCast(long j) {
        if (j > ((long) toInt((byte) -1))) {
            return -1;
        }
        if (j < 0) {
            return 0;
        }
        return (byte) ((int) j);
    }

    public static void sort(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        sort(bArr, 0, bArr.length);
    }

    public static void sortDescending(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        sortDescending(bArr, 0, bArr.length);
    }

    public static int toInt(byte b) {
        return b & MAX_VALUE;
    }

    @Beta
    public static String toString(byte b) {
        return toString(b, 10);
    }

    @CanIgnoreReturnValue
    @Beta
    public static byte parseUnsignedByte(String str, int i) {
        int parseInt = Integer.parseInt((String) Preconditions.checkNotNull(str), i);
        if ((parseInt >> 8) == 0) {
            return (byte) parseInt;
        }
        throw new NumberFormatException(C1058d.u(25, "out of range: ", parseInt));
    }

    @Beta
    public static String toString(byte b, int i) {
        Preconditions.checkArgument(i >= 2 && i <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i);
        return Integer.toString(toInt(b), i);
    }

    public static void sort(byte[] bArr, int i, int i2) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkPositionIndexes(i, i2, bArr.length);
        for (int i3 = i; i3 < i2; i3++) {
            bArr[i3] = flip(bArr[i3]);
        }
        Arrays.sort(bArr, i, i2);
        while (i < i2) {
            bArr[i] = flip(bArr[i]);
            i++;
        }
    }

    public static void sortDescending(byte[] bArr, int i, int i2) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkPositionIndexes(i, i2, bArr.length);
        for (int i3 = i; i3 < i2; i3++) {
            bArr[i3] = (byte) (bArr[i3] ^ Ascii.DEL);
        }
        Arrays.sort(bArr, i, i2);
        while (i < i2) {
            bArr[i] = (byte) (bArr[i] ^ Ascii.DEL);
            i++;
        }
    }
}
