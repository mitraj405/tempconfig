package org.spongycastle.jcajce.provider.asymmetric.rsa;

import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.HashMap;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.RSAESOAEPparams;
import org.spongycastle.asn1.pkcs.RSASSAPSSparams;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.jcajce.provider.util.DigestFactory;
import org.spongycastle.jcajce.util.MessageDigestUtils;

public abstract class AlgorithmParametersSpi extends java.security.AlgorithmParametersSpi {
    public abstract AlgorithmParameterSpec a(Class cls) throws InvalidParameterSpecException;

    public final AlgorithmParameterSpec engineGetParameterSpec(Class cls) throws InvalidParameterSpecException {
        if (cls != null) {
            return a(cls);
        }
        throw new NullPointerException("argument to getParameterSpec must not be null");
    }

    public static class OAEP extends AlgorithmParametersSpi {
        public OAEPParameterSpec a;

        public final AlgorithmParameterSpec a(Class cls) throws InvalidParameterSpecException {
            if (cls == OAEPParameterSpec.class || cls == AlgorithmParameterSpec.class) {
                return this.a;
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to OAEP parameters object.");
        }

        public final byte[] engineGetEncoded(String str) {
            if ((str == null || str.equals("ASN.1")) || str.equalsIgnoreCase("X.509")) {
                return engineGetEncoded();
            }
            return null;
        }

        public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof OAEPParameterSpec) {
                this.a = (OAEPParameterSpec) algorithmParameterSpec;
                return;
            }
            throw new InvalidParameterSpecException("OAEPParameterSpec required to initialise an OAEP algorithm parameters object");
        }

        public final String engineToString() {
            return "OAEP Parameters";
        }

        public final byte[] engineGetEncoded() {
            String digestAlgorithm = this.a.getDigestAlgorithm();
            HashMap hashMap = DigestFactory.a;
            DERNull dERNull = DERNull.a;
            try {
                return new RSAESOAEPparams(new AlgorithmIdentifier((ASN1ObjectIdentifier) hashMap.get(digestAlgorithm), dERNull), new AlgorithmIdentifier(PKCSObjectIdentifiers.g, new AlgorithmIdentifier((ASN1ObjectIdentifier) hashMap.get(((MGF1ParameterSpec) this.a.getMGFParameters()).getDigestAlgorithm()), dERNull)), new AlgorithmIdentifier(PKCSObjectIdentifiers.h, new DEROctetString(((PSource.PSpecified) this.a.getPSource()).getValue()))).f("DER");
            } catch (IOException unused) {
                throw new RuntimeException("Error encoding OAEPParameters");
            }
        }

        public final void engineInit(byte[] bArr) throws IOException {
            RSAESOAEPparams rSAESOAEPparams;
            try {
                AlgorithmIdentifier algorithmIdentifier = RSAESOAEPparams.d;
                if (bArr instanceof RSAESOAEPparams) {
                    rSAESOAEPparams = (RSAESOAEPparams) bArr;
                } else {
                    rSAESOAEPparams = bArr != null ? new RSAESOAEPparams(ASN1Sequence.q(bArr)) : null;
                }
                boolean equals = rSAESOAEPparams.b.Z0.equals(PKCSObjectIdentifiers.g);
                AlgorithmIdentifier algorithmIdentifier2 = rSAESOAEPparams.b;
                if (equals) {
                    this.a = new OAEPParameterSpec(MessageDigestUtils.a(rSAESOAEPparams.a.Z0), OAEPParameterSpec.DEFAULT.getMGFAlgorithm(), new MGF1ParameterSpec(MessageDigestUtils.a(AlgorithmIdentifier.g(algorithmIdentifier2.a).Z0)), new PSource.PSpecified(ASN1OctetString.q(rSAESOAEPparams.c.a).s()));
                    return;
                }
                throw new IOException("unknown mask generation function: " + algorithmIdentifier2.Z0);
            } catch (ClassCastException unused) {
                throw new IOException("Not a valid OAEP Parameter encoding.");
            } catch (ArrayIndexOutOfBoundsException unused2) {
                throw new IOException("Not a valid OAEP Parameter encoding.");
            }
        }

        public final void engineInit(byte[] bArr, String str) throws IOException {
            if (str.equalsIgnoreCase("X.509") || str.equalsIgnoreCase("ASN.1")) {
                engineInit(bArr);
                return;
            }
            throw new IOException("Unknown parameter format ".concat(str));
        }
    }

    public static class PSS extends AlgorithmParametersSpi {
        public PSSParameterSpec a;

        public final AlgorithmParameterSpec a(Class cls) throws InvalidParameterSpecException {
            PSSParameterSpec pSSParameterSpec;
            if (cls == PSSParameterSpec.class && (pSSParameterSpec = this.a) != null) {
                return pSSParameterSpec;
            }
            throw new InvalidParameterSpecException("unknown parameter spec passed to PSS parameters object.");
        }

        public final byte[] engineGetEncoded() throws IOException {
            PSSParameterSpec pSSParameterSpec = this.a;
            String digestAlgorithm = pSSParameterSpec.getDigestAlgorithm();
            HashMap hashMap = DigestFactory.a;
            DERNull dERNull = DERNull.a;
            return new RSASSAPSSparams(new AlgorithmIdentifier((ASN1ObjectIdentifier) hashMap.get(digestAlgorithm), dERNull), new AlgorithmIdentifier(PKCSObjectIdentifiers.g, new AlgorithmIdentifier((ASN1ObjectIdentifier) hashMap.get(((MGF1ParameterSpec) pSSParameterSpec.getMGFParameters()).getDigestAlgorithm()), dERNull)), new ASN1Integer((long) pSSParameterSpec.getSaltLength()), new ASN1Integer((long) pSSParameterSpec.getTrailerField())).f("DER");
        }

        public final void engineInit(byte[] bArr, String str) throws IOException {
            if ((str == null || str.equals("ASN.1")) || str.equalsIgnoreCase("X.509")) {
                engineInit(bArr);
                return;
            }
            throw new IOException("Unknown parameter format ".concat(str));
        }

        public final String engineToString() {
            return "PSS Parameters";
        }

        public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof PSSParameterSpec) {
                this.a = (PSSParameterSpec) algorithmParameterSpec;
                return;
            }
            throw new InvalidParameterSpecException("PSSParameterSpec required to initialise an PSS algorithm parameters object");
        }

        public final void engineInit(byte[] bArr) throws IOException {
            try {
                RSASSAPSSparams g = RSASSAPSSparams.g(bArr);
                boolean equals = g.f5708b.Z0.equals(PKCSObjectIdentifiers.g);
                AlgorithmIdentifier algorithmIdentifier = g.f5708b;
                if (equals) {
                    this.a = new PSSParameterSpec(MessageDigestUtils.a(g.f5707a.Z0), PSSParameterSpec.DEFAULT.getMGFAlgorithm(), new MGF1ParameterSpec(MessageDigestUtils.a(AlgorithmIdentifier.g(algorithmIdentifier.a).Z0)), g.a.t().intValue(), g.b.t().intValue());
                    return;
                }
                throw new IOException("unknown mask generation function: " + algorithmIdentifier.Z0);
            } catch (ClassCastException unused) {
                throw new IOException("Not a valid PSS Parameter encoding.");
            } catch (ArrayIndexOutOfBoundsException unused2) {
                throw new IOException("Not a valid PSS Parameter encoding.");
            }
        }

        public final byte[] engineGetEncoded(String str) throws IOException {
            if (str.equalsIgnoreCase("X.509") || str.equalsIgnoreCase("ASN.1")) {
                return engineGetEncoded();
            }
            return null;
        }
    }
}
