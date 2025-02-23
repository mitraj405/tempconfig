package org.spongycastle.crypto.tls;

public abstract class AbstractTlsClient extends AbstractTlsPeer implements TlsClient {
    public final TlsCipherFactory a = new DefaultTlsCipherFactory();
}
