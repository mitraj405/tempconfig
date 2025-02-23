package org.spongycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

public class BEROctetStringGenerator extends BERGenerator {

    public class BufferedBEROctetStream extends OutputStream {
        public int c;

        public final void close() throws IOException {
            int i = this.c;
            if (i != 0) {
                System.arraycopy((Object) null, 0, new byte[i], 0, i);
                throw null;
            }
            throw null;
        }

        public final void write(int i) throws IOException {
            this.c++;
            throw null;
        }

        public final void write(byte[] bArr, int i, int i2) throws IOException {
            if (i2 > 0) {
                throw null;
            }
        }
    }
}
