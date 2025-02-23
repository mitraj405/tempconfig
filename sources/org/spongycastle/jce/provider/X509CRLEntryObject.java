package org.spongycastle.jce.provider;

import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.CRLException;
import java.security.cert.X509CRLEntry;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.util.ASN1Dump;
import org.spongycastle.asn1.x500.X500Name;
import org.spongycastle.asn1.x509.CRLReason;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.TBSCertList;
import org.spongycastle.asn1.x509.Time;
import org.spongycastle.asn1.x509.X509Extension;
import org.spongycastle.util.Strings;

public class X509CRLEntryObject extends X509CRLEntry {
    public final X500Name a;

    /* renamed from: a  reason: collision with other field name */
    public final TBSCertList.CRLEntry f6600a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6601a;
    public int c;

    public X509CRLEntryObject(TBSCertList.CRLEntry cRLEntry, boolean z, X500Name x500Name) {
        Extension extension;
        this.f6600a = cRLEntry;
        if (z) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = Extension.i1;
            Extensions g = cRLEntry.g();
            if (g != null) {
                extension = g.g(aSN1ObjectIdentifier);
            } else {
                extension = null;
            }
            if (extension != null) {
                try {
                    GeneralName[] h = GeneralNames.g(extension.g()).h();
                    int i = 0;
                    while (true) {
                        if (i >= h.length) {
                            break;
                        }
                        GeneralName generalName = h[i];
                        if (generalName.c == 4) {
                            x500Name = X500Name.g(generalName.a);
                            break;
                        }
                        i++;
                    }
                } catch (Exception unused) {
                }
            }
            this.a = x500Name;
        }
        x500Name = null;
        this.a = x500Name;
    }

    public final HashSet d(boolean z) {
        Extensions g = this.f6600a.g();
        if (g == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Enumeration i = g.i();
        while (i.hasMoreElements()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) i.nextElement();
            if (z == g.g(aSN1ObjectIdentifier).f5740a) {
                hashSet.add(aSN1ObjectIdentifier.c);
            }
        }
        return hashSet;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof X509CRLEntryObject) {
            return this.f6600a.equals(((X509CRLEntryObject) obj).f6600a);
        }
        return super.equals(this);
    }

    public final X500Principal getCertificateIssuer() {
        X500Name x500Name = this.a;
        if (x500Name == null) {
            return null;
        }
        try {
            return new X500Principal(x500Name.e());
        } catch (IOException unused) {
            return null;
        }
    }

    public final Set getCriticalExtensionOIDs() {
        return d(true);
    }

    public final byte[] getEncoded() throws CRLException {
        try {
            return this.f6600a.f("DER");
        } catch (IOException e) {
            throw new CRLException(e.toString());
        }
    }

    public final byte[] getExtensionValue(String str) {
        Extension extension;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier(str);
        Extensions g = this.f6600a.g();
        if (g != null) {
            extension = g.g(aSN1ObjectIdentifier);
        } else {
            extension = null;
        }
        if (extension == null) {
            return null;
        }
        try {
            return extension.a.e();
        } catch (Exception e) {
            throw new RuntimeException(C1058d.x(e, new StringBuilder("error encoding ")));
        }
    }

    public final Set getNonCriticalExtensionOIDs() {
        return d(false);
    }

    public final Date getRevocationDate() {
        return Time.h(this.f6600a.a.s(1)).g();
    }

    public final BigInteger getSerialNumber() {
        return this.f6600a.i().t();
    }

    public final boolean hasExtensions() {
        if (this.f6600a.g() != null) {
            return true;
        }
        return false;
    }

    public final boolean hasUnsupportedCriticalExtension() {
        Set criticalExtensionOIDs = getCriticalExtensionOIDs();
        if (criticalExtensionOIDs == null || criticalExtensionOIDs.isEmpty()) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        if (!this.f6601a) {
            this.c = super.hashCode();
            this.f6601a = true;
        }
        return this.c;
    }

    public final String toString() {
        CRLReason cRLReason;
        StringBuffer stringBuffer = new StringBuffer("      userCertificate: ");
        String str = Strings.a;
        stringBuffer.append(getSerialNumber());
        stringBuffer.append(str);
        stringBuffer.append("       revocationDate: ");
        stringBuffer.append(getRevocationDate());
        stringBuffer.append(str);
        stringBuffer.append("       certificateIssuer: ");
        stringBuffer.append(getCertificateIssuer());
        stringBuffer.append(str);
        Extensions g = this.f6600a.g();
        if (g != null) {
            Enumeration i = g.i();
            if (i.hasMoreElements()) {
                stringBuffer.append("   crlEntryExtensions:");
                stringBuffer.append(str);
                while (i.hasMoreElements()) {
                    ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) i.nextElement();
                    Extension g2 = g.g(aSN1ObjectIdentifier);
                    ASN1OctetString aSN1OctetString = g2.a;
                    if (aSN1OctetString != null) {
                        ASN1InputStream aSN1InputStream = new ASN1InputStream(aSN1OctetString.s());
                        stringBuffer.append("                       critical(");
                        stringBuffer.append(g2.f5740a);
                        stringBuffer.append(") ");
                        try {
                            if (aSN1ObjectIdentifier.equals(X509Extension.a)) {
                                ASN1Enumerated q = ASN1Enumerated.q(aSN1InputStream.j());
                                String[] strArr = CRLReason.f5729a;
                                if (q instanceof CRLReason) {
                                    cRLReason = (CRLReason) q;
                                } else if (q != null) {
                                    int intValue = ASN1Enumerated.q(q).r().intValue();
                                    Integer valueOf = Integer.valueOf(intValue);
                                    Hashtable hashtable = CRLReason.a;
                                    if (!hashtable.containsKey(valueOf)) {
                                        hashtable.put(valueOf, new CRLReason(intValue));
                                    }
                                    cRLReason = (CRLReason) hashtable.get(valueOf);
                                } else {
                                    cRLReason = null;
                                }
                                stringBuffer.append(cRLReason);
                                stringBuffer.append(str);
                            } else if (aSN1ObjectIdentifier.equals(X509Extension.b)) {
                                stringBuffer.append("Certificate issuer: ");
                                stringBuffer.append(GeneralNames.g(aSN1InputStream.j()));
                                stringBuffer.append(str);
                            } else {
                                stringBuffer.append(aSN1ObjectIdentifier.c);
                                stringBuffer.append(" value = ");
                                stringBuffer.append(ASN1Dump.b(aSN1InputStream.j()));
                                stringBuffer.append(str);
                            }
                        } catch (Exception unused) {
                            stringBuffer.append(aSN1ObjectIdentifier.c);
                            stringBuffer.append(" value = *****");
                            stringBuffer.append(str);
                        }
                    } else {
                        stringBuffer.append(str);
                    }
                }
            }
        }
        return stringBuffer.toString();
    }
}
