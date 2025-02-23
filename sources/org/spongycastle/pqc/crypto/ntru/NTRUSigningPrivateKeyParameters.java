package org.spongycastle.pqc.crypto.ntru;

import org.spongycastle.crypto.params.AsymmetricKeyParameter;

public class NTRUSigningPrivateKeyParameters extends AsymmetricKeyParameter {

    public static class Basis {
        public Basis() {
            throw null;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof Basis)) {
                return false;
            }
            Basis basis = (Basis) obj;
            return true;
        }

        public final int hashCode() {
            return 923521;
        }
    }

    public NTRUSigningPrivateKeyParameters() {
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ((NTRUSigningPrivateKeyParameters) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return 31;
    }
}
