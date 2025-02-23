package org.spongycastle.jcajce;

import java.security.cert.CertPathParameters;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXParameters;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.spongycastle.jcajce.PKIXExtendedParameters;

public class PKIXExtendedBuilderParameters implements CertPathParameters {
    public final Set<X509Certificate> a;

    /* renamed from: a  reason: collision with other field name */
    public final PKIXExtendedParameters f6319a;
    public final int c;

    public PKIXExtendedBuilderParameters(Builder builder) {
        this.f6319a = builder.f6321a;
        this.a = Collections.unmodifiableSet(builder.f6320a);
        this.c = builder.a;
    }

    public static class Builder {
        public int a = 5;

        /* renamed from: a  reason: collision with other field name */
        public final HashSet f6320a = new HashSet();

        /* renamed from: a  reason: collision with other field name */
        public final PKIXExtendedParameters f6321a;

        public Builder(PKIXBuilderParameters pKIXBuilderParameters) {
            this.f6321a = new PKIXExtendedParameters(new PKIXExtendedParameters.Builder((PKIXParameters) pKIXBuilderParameters));
            this.a = pKIXBuilderParameters.getMaxPathLength();
        }

        public Builder(PKIXExtendedParameters pKIXExtendedParameters) {
            this.f6321a = pKIXExtendedParameters;
        }
    }

    public final Object clone() {
        return this;
    }
}
