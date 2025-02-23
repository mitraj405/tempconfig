package org.spongycastle.x509;

import java.security.InvalidAlgorithmParameterException;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.spongycastle.util.Selector;

public class ExtendedPKIXBuilderParameters extends ExtendedPKIXParameters {
    public Set a = Collections.EMPTY_SET;
    public int d = 5;

    public ExtendedPKIXBuilderParameters(Set set, Selector selector) throws InvalidAlgorithmParameterException {
        super(set);
        if (selector != null) {
            this.f6863a = (Selector) selector.clone();
        } else {
            this.f6863a = null;
        }
    }

    public final void a(PKIXParameters pKIXParameters) {
        super.a(pKIXParameters);
        if (pKIXParameters instanceof ExtendedPKIXBuilderParameters) {
            ExtendedPKIXBuilderParameters extendedPKIXBuilderParameters = (ExtendedPKIXBuilderParameters) pKIXParameters;
            this.d = extendedPKIXBuilderParameters.d;
            this.a = new HashSet(extendedPKIXBuilderParameters.a);
        }
        if (pKIXParameters instanceof PKIXBuilderParameters) {
            this.d = ((PKIXBuilderParameters) pKIXParameters).getMaxPathLength();
        }
    }

    public final Object clone() {
        Selector selector;
        try {
            Set<TrustAnchor> trustAnchors = getTrustAnchors();
            Selector selector2 = this.f6863a;
            if (selector2 != null) {
                selector = (Selector) selector2.clone();
            } else {
                selector = null;
            }
            ExtendedPKIXBuilderParameters extendedPKIXBuilderParameters = new ExtendedPKIXBuilderParameters(trustAnchors, selector);
            extendedPKIXBuilderParameters.a(this);
            return extendedPKIXBuilderParameters;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
