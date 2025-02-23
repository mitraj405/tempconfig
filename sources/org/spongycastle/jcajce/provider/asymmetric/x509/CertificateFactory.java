package org.spongycastle.jcajce.provider.asymmetric.x509;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactorySpi;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.SignedData;
import org.spongycastle.asn1.x509.CertificateList;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.util.io.Streams;

public class CertificateFactory extends CertificateFactorySpi {
    public static final PEMUtil a = new PEMUtil("CERTIFICATE");
    public static final PEMUtil b = new PEMUtil("CRL");

    /* renamed from: a  reason: collision with other field name */
    public int f6483a = 0;

    /* renamed from: a  reason: collision with other field name */
    public InputStream f6484a = null;

    /* renamed from: a  reason: collision with other field name */
    public ASN1Set f6485a = null;

    /* renamed from: a  reason: collision with other field name */
    public final BCJcaJceHelper f6486a = new BCJcaJceHelper();

    /* renamed from: b  reason: collision with other field name */
    public int f6487b = 0;

    /* renamed from: b  reason: collision with other field name */
    public InputStream f6488b = null;

    /* renamed from: b  reason: collision with other field name */
    public ASN1Set f6489b = null;

    public class ExCertificateException extends CertificateException {
        public final Throwable a;

        public ExCertificateException(String str, Exception exc) {
            super(str);
            this.a = exc;
        }

        public final Throwable getCause() {
            return this.a;
        }
    }

    static {
        new PEMUtil("PKCS7");
    }

    public final CRL a() throws CRLException {
        ASN1Set aSN1Set = this.f6489b;
        if (aSN1Set == null || this.f6487b >= aSN1Set.size()) {
            return null;
        }
        ASN1Set aSN1Set2 = this.f6489b;
        int i = this.f6487b;
        this.f6487b = i + 1;
        return new X509CRLObject(this.f6486a, CertificateList.g(aSN1Set2.s(i)));
    }

    public final CRL b(ASN1Sequence aSN1Sequence) throws CRLException {
        SignedData signedData = null;
        if (aSN1Sequence == null) {
            return null;
        }
        if (aSN1Sequence.size() <= 1 || !(aSN1Sequence.s(0) instanceof ASN1ObjectIdentifier) || !aSN1Sequence.s(0).equals(PKCSObjectIdentifiers.K)) {
            return new X509CRLObject(this.f6486a, CertificateList.g(aSN1Sequence));
        }
        ASN1Sequence r = ASN1Sequence.r((ASN1TaggedObject) aSN1Sequence.s(1), true);
        if (r instanceof SignedData) {
            signedData = (SignedData) r;
        } else if (r != null) {
            signedData = new SignedData(ASN1Sequence.q(r));
        }
        this.f6489b = signedData.c;
        return a();
    }

    public final Certificate c() throws CertificateParsingException {
        if (this.f6485a == null) {
            return null;
        }
        while (this.f6483a < this.f6485a.size()) {
            ASN1Set aSN1Set = this.f6485a;
            int i = this.f6483a;
            this.f6483a = i + 1;
            ASN1Encodable s = aSN1Set.s(i);
            if (s instanceof ASN1Sequence) {
                return new X509CertificateObject(this.f6486a, org.spongycastle.asn1.x509.Certificate.g(s));
            }
        }
        return null;
    }

    public final Certificate d(ASN1Sequence aSN1Sequence) throws CertificateParsingException {
        SignedData signedData = null;
        if (aSN1Sequence == null) {
            return null;
        }
        if (aSN1Sequence.size() <= 1 || !(aSN1Sequence.s(0) instanceof ASN1ObjectIdentifier) || !aSN1Sequence.s(0).equals(PKCSObjectIdentifiers.K)) {
            return new X509CertificateObject(this.f6486a, org.spongycastle.asn1.x509.Certificate.g(aSN1Sequence));
        }
        ASN1Sequence r = ASN1Sequence.r((ASN1TaggedObject) aSN1Sequence.s(1), true);
        if (r instanceof SignedData) {
            signedData = (SignedData) r;
        } else if (r != null) {
            signedData = new SignedData(ASN1Sequence.q(r));
        }
        this.f6485a = signedData.b;
        return c();
    }

    public final CRL engineGenerateCRL(InputStream inputStream) throws CRLException {
        InputStream inputStream2 = this.f6488b;
        if (inputStream2 == null) {
            this.f6488b = inputStream;
            this.f6489b = null;
            this.f6487b = 0;
        } else if (inputStream2 != inputStream) {
            this.f6488b = inputStream;
            this.f6489b = null;
            this.f6487b = 0;
        }
        try {
            ASN1Set aSN1Set = this.f6489b;
            if (aSN1Set == null) {
                if (!inputStream.markSupported()) {
                    inputStream = new ByteArrayInputStream(Streams.a(inputStream));
                }
                inputStream.mark(1);
                int read = inputStream.read();
                if (read == -1) {
                    return null;
                }
                inputStream.reset();
                if (read != 48) {
                    return b(b.b(inputStream));
                }
                return b(ASN1Sequence.q(new ASN1InputStream(inputStream, 0).j()));
            } else if (this.f6487b != aSN1Set.size()) {
                return a();
            } else {
                this.f6489b = null;
                this.f6487b = 0;
                return null;
            }
        } catch (CRLException e) {
            throw e;
        } catch (Exception e2) {
            throw new CRLException(e2.toString());
        }
    }

    public final Collection engineGenerateCRLs(InputStream inputStream) throws CRLException {
        ArrayList arrayList = new ArrayList();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        while (true) {
            CRL engineGenerateCRL = engineGenerateCRL(bufferedInputStream);
            if (engineGenerateCRL == null) {
                return arrayList;
            }
            arrayList.add(engineGenerateCRL);
        }
    }

    public final CertPath engineGenerateCertPath(InputStream inputStream) throws CertificateException {
        return engineGenerateCertPath(inputStream, "PkiPath");
    }

    public final Certificate engineGenerateCertificate(InputStream inputStream) throws CertificateException {
        InputStream inputStream2 = this.f6484a;
        if (inputStream2 == null) {
            this.f6484a = inputStream;
            this.f6485a = null;
            this.f6483a = 0;
        } else if (inputStream2 != inputStream) {
            this.f6484a = inputStream;
            this.f6485a = null;
            this.f6483a = 0;
        }
        try {
            ASN1Set aSN1Set = this.f6485a;
            if (aSN1Set == null) {
                if (!inputStream.markSupported()) {
                    inputStream = new ByteArrayInputStream(Streams.a(inputStream));
                }
                inputStream.mark(1);
                int read = inputStream.read();
                if (read == -1) {
                    return null;
                }
                inputStream.reset();
                if (read != 48) {
                    return d(a.b(inputStream));
                }
                return d(ASN1Sequence.q(new ASN1InputStream(inputStream).j()));
            } else if (this.f6483a != aSN1Set.size()) {
                return c();
            } else {
                this.f6485a = null;
                this.f6483a = 0;
                return null;
            }
        } catch (Exception e) {
            throw new ExCertificateException(C1058d.M(e, new StringBuilder("parsing issue: ")), e);
        }
    }

    public final Collection engineGenerateCertificates(InputStream inputStream) throws CertificateException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ArrayList arrayList = new ArrayList();
        while (true) {
            Certificate engineGenerateCertificate = engineGenerateCertificate(bufferedInputStream);
            if (engineGenerateCertificate == null) {
                return arrayList;
            }
            arrayList.add(engineGenerateCertificate);
        }
    }

    public final Iterator engineGetCertPathEncodings() {
        return PKIXCertPath.b.iterator();
    }

    public final CertPath engineGenerateCertPath(InputStream inputStream, String str) throws CertificateException {
        return new PKIXCertPath(inputStream, str);
    }

    public final CertPath engineGenerateCertPath(List list) throws CertificateException {
        for (Object next : list) {
            if (next != null && !(next instanceof X509Certificate)) {
                throw new CertificateException("list contains non X509Certificate object while creating CertPath\n" + next.toString());
            }
        }
        return new PKIXCertPath(list);
    }
}
