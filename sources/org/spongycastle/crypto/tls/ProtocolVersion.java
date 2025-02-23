package org.spongycastle.crypto.tls;

import com.google.android.material.internal.ViewUtils;
import com.google.firebase.perf.util.Constants;

public final class ProtocolVersion {
    public static final ProtocolVersion a = new ProtocolVersion(ViewUtils.EDGE_TO_EDGE_FLAGS, "SSL 3.0");
    public static final ProtocolVersion b = new ProtocolVersion(770, "TLS 1.1");
    public static final ProtocolVersion c = new ProtocolVersion(771, "TLS 1.2");
    public static final ProtocolVersion d = new ProtocolVersion(65279, "DTLS 1.0");

    /* renamed from: a  reason: collision with other field name */
    public final int f6306a;

    /* renamed from: a  reason: collision with other field name */
    public final String f6307a;

    public ProtocolVersion(int i, String str) {
        this.f6306a = i & 65535;
        this.f6307a = str;
    }

    public final ProtocolVersion a() {
        boolean z;
        if ((this.f6306a >> 8) == 254) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return this;
        }
        if (this == d) {
            return b;
        }
        return c;
    }

    public final boolean b(ProtocolVersion protocolVersion) {
        boolean z;
        int i = this.f6306a;
        int i2 = i >> 8;
        int i3 = protocolVersion.f6306a;
        if (i2 != (i3 >> 8)) {
            return false;
        }
        int i4 = (i3 & Constants.MAX_HOST_LENGTH) - (i & Constants.MAX_HOST_LENGTH);
        if ((i >> 8) == 254) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (i4 > 0) {
                return false;
            }
        } else if (i4 < 0) {
            return false;
        }
        return true;
    }

    public final boolean c() {
        if (this == a) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (obj instanceof ProtocolVersion) {
            ProtocolVersion protocolVersion = (ProtocolVersion) obj;
            if (protocolVersion == null || this.f6306a != protocolVersion.f6306a) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f6306a;
    }

    public final String toString() {
        return this.f6307a;
    }
}
