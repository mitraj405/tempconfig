package org.spongycastle.crypto.tls;

import org.spongycastle.util.Strings;

public class SimulatedTlsSRPIdentityManager implements TlsSRPIdentityManager {
    static {
        Strings.d("password");
        Strings.d("salt");
    }
}
