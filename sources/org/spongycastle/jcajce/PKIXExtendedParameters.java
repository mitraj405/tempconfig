package org.spongycastle.jcajce;

import java.security.cert.CertPathParameters;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.jcajce.PKIXCertStoreSelector;

public class PKIXExtendedParameters implements CertPathParameters {
    public final PKIXParameters a;

    /* renamed from: a  reason: collision with other field name */
    public final Date f6322a;

    /* renamed from: a  reason: collision with other field name */
    public final List<PKIXCertStore> f6323a;

    /* renamed from: a  reason: collision with other field name */
    public final Map<GeneralName, PKIXCertStore> f6324a;

    /* renamed from: a  reason: collision with other field name */
    public final Set<TrustAnchor> f6325a;

    /* renamed from: a  reason: collision with other field name */
    public final PKIXCertStoreSelector f6326a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f6327a;
    public final List<PKIXCRLStore> b;

    /* renamed from: b  reason: collision with other field name */
    public final Map<GeneralName, PKIXCRLStore> f6328b;

    /* renamed from: b  reason: collision with other field name */
    public final boolean f6329b;
    public final int c;

    public PKIXExtendedParameters(Builder builder) {
        this.a = builder.f6330a;
        this.f6322a = builder.f6332a;
        this.f6323a = Collections.unmodifiableList(builder.f6331a);
        this.f6324a = Collections.unmodifiableMap(new HashMap(builder.f6333a));
        this.b = Collections.unmodifiableList(builder.b);
        this.f6328b = Collections.unmodifiableMap(new HashMap(builder.f6337b));
        this.f6326a = builder.f6335a;
        this.f6327a = builder.f6336a;
        this.f6329b = builder.f6338b;
        this.c = builder.a;
        this.f6325a = Collections.unmodifiableSet(builder.f6334a);
    }

    public final List<CertStore> a() {
        return this.a.getCertStores();
    }

    public final Date b() {
        return new Date(this.f6322a.getTime());
    }

    public static class Builder {
        public int a = 0;

        /* renamed from: a  reason: collision with other field name */
        public final PKIXParameters f6330a;

        /* renamed from: a  reason: collision with other field name */
        public final ArrayList f6331a = new ArrayList();

        /* renamed from: a  reason: collision with other field name */
        public final Date f6332a;

        /* renamed from: a  reason: collision with other field name */
        public final HashMap f6333a = new HashMap();

        /* renamed from: a  reason: collision with other field name */
        public Set<TrustAnchor> f6334a;

        /* renamed from: a  reason: collision with other field name */
        public PKIXCertStoreSelector f6335a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f6336a;
        public final ArrayList b = new ArrayList();

        /* renamed from: b  reason: collision with other field name */
        public final HashMap f6337b = new HashMap();

        /* renamed from: b  reason: collision with other field name */
        public boolean f6338b = false;

        public Builder(PKIXParameters pKIXParameters) {
            this.f6330a = (PKIXParameters) pKIXParameters.clone();
            CertSelector targetCertConstraints = pKIXParameters.getTargetCertConstraints();
            if (targetCertConstraints != null) {
                this.f6335a = new PKIXCertStoreSelector.Builder(targetCertConstraints).a();
            }
            Date date = pKIXParameters.getDate();
            this.f6332a = date == null ? new Date() : date;
            this.f6336a = pKIXParameters.isRevocationEnabled();
            this.f6334a = pKIXParameters.getTrustAnchors();
        }

        public final PKIXExtendedParameters a() {
            return new PKIXExtendedParameters(this);
        }

        public Builder(PKIXExtendedParameters pKIXExtendedParameters) {
            this.f6330a = pKIXExtendedParameters.a;
            this.f6332a = pKIXExtendedParameters.f6322a;
            this.f6335a = pKIXExtendedParameters.f6326a;
            this.f6331a = new ArrayList(pKIXExtendedParameters.f6323a);
            this.f6333a = new HashMap(pKIXExtendedParameters.f6324a);
            this.b = new ArrayList(pKIXExtendedParameters.b);
            this.f6337b = new HashMap(pKIXExtendedParameters.f6328b);
            this.f6338b = pKIXExtendedParameters.f6329b;
            this.a = pKIXExtendedParameters.c;
            this.f6336a = pKIXExtendedParameters.f6327a;
            this.f6334a = pKIXExtendedParameters.f6325a;
        }
    }

    public final Object clone() {
        return this;
    }
}
