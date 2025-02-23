package defpackage;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;

/* renamed from: ml  reason: default package */
/* compiled from: MetadataListReader */
public final class ml {

    /* renamed from: ml$a */
    /* compiled from: MetadataListReader */
    public static class a {
        public final ByteBuffer a;

        public a(ByteBuffer byteBuffer) {
            this.a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public final long a() throws IOException {
            return ((long) this.a.getInt()) & 4294967295L;
        }

        public final void b(int i) throws IOException {
            ByteBuffer byteBuffer = this.a;
            byteBuffer.position(byteBuffer.position() + i);
        }
    }

    public static ll a(MappedByteBuffer mappedByteBuffer) throws IOException {
        ByteBuffer byteBuffer;
        long j;
        ByteBuffer duplicate = mappedByteBuffer.duplicate();
        a aVar = new a(duplicate);
        aVar.b(4);
        short s = duplicate.getShort() & 65535;
        if (s <= 100) {
            aVar.b(6);
            int i = 0;
            while (true) {
                byteBuffer = aVar.a;
                if (i >= s) {
                    j = -1;
                    break;
                }
                int i2 = byteBuffer.getInt();
                aVar.b(4);
                j = aVar.a();
                aVar.b(4);
                if (1835365473 == i2) {
                    break;
                }
                i++;
            }
            if (j != -1) {
                aVar.b((int) (j - ((long) duplicate.position())));
                aVar.b(12);
                long a2 = aVar.a();
                for (int i3 = 0; ((long) i3) < a2; i3++) {
                    int i4 = byteBuffer.getInt();
                    long a3 = aVar.a();
                    aVar.a();
                    if (1164798569 == i4 || 1701669481 == i4) {
                        duplicate.position((int) (a3 + j));
                        ll llVar = new ll();
                        duplicate.order(ByteOrder.LITTLE_ENDIAN);
                        llVar.b(duplicate.position() + duplicate.getInt(duplicate.position()), duplicate);
                        return llVar;
                    }
                }
            }
            throw new IOException("Cannot read metadata.");
        }
        throw new IOException("Cannot read metadata.");
    }
}
