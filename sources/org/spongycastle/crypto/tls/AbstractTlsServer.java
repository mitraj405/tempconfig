package org.spongycastle.crypto.tls;

public abstract class AbstractTlsServer extends AbstractTlsPeer implements TlsServer {
    public final TlsCipherFactory a = new DefaultTlsCipherFactory();
}
