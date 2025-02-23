package org.spongycastle.crypto.tls;

import java.util.Vector;
import org.spongycastle.crypto.agreement.srp.SRP6StandardGroups;

public class DefaultTlsSRPGroupVerifier implements TlsSRPGroupVerifier {
    public static final Vector a;

    static {
        Vector vector = new Vector();
        a = vector;
        vector.addElement(SRP6StandardGroups.a);
        vector.addElement(SRP6StandardGroups.b);
        vector.addElement(SRP6StandardGroups.c);
        vector.addElement(SRP6StandardGroups.d);
        vector.addElement(SRP6StandardGroups.e);
        vector.addElement(SRP6StandardGroups.f);
        vector.addElement(SRP6StandardGroups.g);
    }
}
