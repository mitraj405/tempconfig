package org.spongycastle.pqc.crypto.ntru;

public class NTRUEncryptionPublicKeyParameters extends NTRUEncryptionKeyParameters {
    public NTRUEncryptionPublicKeyParameters() {
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NTRUEncryptionPublicKeyParameters)) {
            return false;
        }
        NTRUEncryptionPublicKeyParameters nTRUEncryptionPublicKeyParameters = (NTRUEncryptionPublicKeyParameters) obj;
        return true;
    }

    public final int hashCode() {
        return 961;
    }
}
