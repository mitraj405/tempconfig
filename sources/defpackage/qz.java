package defpackage;

import java.nio.ByteBuffer;

/* renamed from: qz  reason: default package */
/* compiled from: Table */
public class qz {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f3207a;
    public int b;
    public int c;

    public qz() {
        if (C1149h8.a == null) {
            C1149h8.a = new C1149h8();
        }
    }

    public final int a(int i) {
        if (i < this.c) {
            return this.f3207a.getShort(this.b + i);
        }
        return 0;
    }

    public final void b(int i, ByteBuffer byteBuffer) {
        this.f3207a = byteBuffer;
        if (byteBuffer != null) {
            this.a = i;
            int i2 = i - byteBuffer.getInt(i);
            this.b = i2;
            this.c = this.f3207a.getShort(i2);
            return;
        }
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }
}
