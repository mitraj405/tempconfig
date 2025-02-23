package org.spongycastle.x509;

import java.util.Collection;

public class X509CollectionStoreParameters implements X509StoreParameters {
    public final Collection a;

    public X509CollectionStoreParameters(Collection collection) {
        if (collection != null) {
            this.a = collection;
            return;
        }
        throw new NullPointerException("collection cannot be null");
    }

    public final Object clone() {
        return new X509CollectionStoreParameters(this.a);
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("X509CollectionStoreParameters: [\n");
        stringBuffer.append("  collection: " + this.a + "\n");
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
