package org.spongycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public abstract class TlsProtocol {

    public class HandshakeMessage extends ByteArrayOutputStream {
        public HandshakeMessage() throws IOException {
            throw null;
        }
    }
}
