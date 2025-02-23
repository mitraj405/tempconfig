package androidx.collection;

public final class CircularIntArray {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public int[] f1323a;
    public int b;
    public int c;

    public CircularIntArray() {
        int highestOneBit = Integer.bitCount(8) != 1 ? Integer.highestOneBit(7) << 1 : 8;
        this.c = highestOneBit - 1;
        this.f1323a = new int[highestOneBit];
    }

    public final void a(int i) {
        int[] iArr = this.f1323a;
        int i2 = this.b;
        iArr[i2] = i;
        int i3 = this.c & (i2 + 1);
        this.b = i3;
        int i4 = this.a;
        if (i3 == i4) {
            int length = iArr.length;
            int i5 = length - i4;
            int i6 = length << 1;
            if (i6 >= 0) {
                int[] iArr2 = new int[i6];
                System.arraycopy(iArr, i4, iArr2, 0, i5);
                System.arraycopy(this.f1323a, 0, iArr2, i5, this.a);
                this.f1323a = iArr2;
                this.a = 0;
                this.b = length;
                this.c = i6 - 1;
                return;
            }
            throw new RuntimeException("Max array capacity exceeded");
        }
    }
}
