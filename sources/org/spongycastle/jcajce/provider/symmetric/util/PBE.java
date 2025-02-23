package org.spongycastle.jcajce.provider.symmetric.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.digests.GOST3411Digest;
import org.spongycastle.crypto.digests.MD2Digest;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.digests.RIPEMD160Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.digests.TigerDigest;
import org.spongycastle.crypto.generators.OpenSSLPBEParametersGenerator;
import org.spongycastle.crypto.generators.PKCS12ParametersGenerator;
import org.spongycastle.crypto.generators.PKCS5S1ParametersGenerator;
import org.spongycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.spongycastle.crypto.params.DESParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.util.DigestFactory;
import org.spongycastle.util.Strings;

public interface PBE {

    public static class Util {
        public static byte[] a(int i, PBEKeySpec pBEKeySpec) {
            if (i == 2) {
                return PBEParametersGenerator.a(pBEKeySpec.getPassword());
            }
            if (i != 5 && i != 4) {
                return PBEParametersGenerator.b(pBEKeySpec.getPassword());
            }
            char[] password = pBEKeySpec.getPassword();
            if (password == null) {
                return new byte[0];
            }
            String str = Strings.a;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                Strings.f(byteArrayOutputStream, password);
                return byteArrayOutputStream.toByteArray();
            } catch (IOException unused) {
                throw new IllegalStateException("cannot encode string to byte array!");
            }
        }

        public static PBEParametersGenerator b(int i, int i2) {
            if (i == 0 || i == 4) {
                if (i2 == 0) {
                    return new PKCS5S1ParametersGenerator(new MD5Digest());
                }
                if (i2 == 1) {
                    return new PKCS5S1ParametersGenerator(new SHA1Digest());
                }
                if (i2 == 5) {
                    return new PKCS5S1ParametersGenerator(new MD2Digest());
                }
                throw new IllegalStateException("PKCS5 scheme 1 only supports MD2, MD5 and SHA1.");
            } else if (i == 1 || i == 5) {
                switch (i2) {
                    case 0:
                        return new PKCS5S2ParametersGenerator(new MD5Digest());
                    case 1:
                        return new PKCS5S2ParametersGenerator(new SHA1Digest());
                    case 2:
                        return new PKCS5S2ParametersGenerator(new RIPEMD160Digest());
                    case 3:
                        return new PKCS5S2ParametersGenerator(new TigerDigest());
                    case 4:
                        return new PKCS5S2ParametersGenerator(new SHA256Digest());
                    case 5:
                        return new PKCS5S2ParametersGenerator(new MD2Digest());
                    case 6:
                        return new PKCS5S2ParametersGenerator(new GOST3411Digest());
                    case 7:
                        return new PKCS5S2ParametersGenerator(new SHA224Digest());
                    case 8:
                        return new PKCS5S2ParametersGenerator(new SHA384Digest());
                    case 9:
                        return new PKCS5S2ParametersGenerator(new SHA512Digest());
                    case 10:
                        return new PKCS5S2ParametersGenerator(DigestFactory.a());
                    case 11:
                        return new PKCS5S2ParametersGenerator(DigestFactory.b());
                    case 12:
                        return new PKCS5S2ParametersGenerator(DigestFactory.c());
                    case 13:
                        return new PKCS5S2ParametersGenerator(DigestFactory.d());
                    default:
                        throw new IllegalStateException("unknown digest scheme for PBE PKCS5S2 encryption.");
                }
            } else if (i != 2) {
                return new OpenSSLPBEParametersGenerator();
            } else {
                switch (i2) {
                    case 0:
                        return new PKCS12ParametersGenerator(new MD5Digest());
                    case 1:
                        return new PKCS12ParametersGenerator(new SHA1Digest());
                    case 2:
                        return new PKCS12ParametersGenerator(new RIPEMD160Digest());
                    case 3:
                        return new PKCS12ParametersGenerator(new TigerDigest());
                    case 4:
                        return new PKCS12ParametersGenerator(new SHA256Digest());
                    case 5:
                        return new PKCS12ParametersGenerator(new MD2Digest());
                    case 6:
                        return new PKCS12ParametersGenerator(new GOST3411Digest());
                    case 7:
                        return new PKCS12ParametersGenerator(new SHA224Digest());
                    case 8:
                        return new PKCS12ParametersGenerator(new SHA384Digest());
                    case 9:
                        return new PKCS12ParametersGenerator(new SHA512Digest());
                    default:
                        throw new IllegalStateException("unknown digest scheme for PBE encryption.");
                }
            }
        }

        public static CipherParameters c(PBEKeySpec pBEKeySpec, int i, int i2, int i3) {
            PBEParametersGenerator b = b(i, i2);
            byte[] a = a(i, pBEKeySpec);
            b.f(a, pBEKeySpec.getIterationCount(), pBEKeySpec.getSalt());
            KeyParameter c = b.c(i3);
            for (int i4 = 0; i4 != a.length; i4++) {
                a[i4] = 0;
            }
            return c;
        }

        public static CipherParameters d(PBEKeySpec pBEKeySpec, int i, int i2, int i3, int i4) {
            CipherParameters cipherParameters;
            PBEParametersGenerator b = b(i, i2);
            byte[] a = a(i, pBEKeySpec);
            b.f(a, pBEKeySpec.getIterationCount(), pBEKeySpec.getSalt());
            if (i4 != 0) {
                cipherParameters = b.e(i3, i4);
            } else {
                cipherParameters = b.d(i3);
            }
            for (int i5 = 0; i5 != a.length; i5++) {
                a[i5] = 0;
            }
            return cipherParameters;
        }

        public static CipherParameters e(BCPBEKey bCPBEKey, AlgorithmParameterSpec algorithmParameterSpec, String str) {
            CipherParameters cipherParameters;
            if (algorithmParameterSpec == null || !(algorithmParameterSpec instanceof PBEParameterSpec)) {
                throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
            }
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
            PBEParametersGenerator b = b(bCPBEKey.c, bCPBEKey.d);
            b.f(bCPBEKey.getEncoded(), pBEParameterSpec.getIterationCount(), pBEParameterSpec.getSalt());
            int i = bCPBEKey.e;
            int i2 = bCPBEKey.f;
            if (i2 != 0) {
                cipherParameters = b.e(i, i2);
            } else {
                cipherParameters = b.d(i);
            }
            if (str.startsWith("DES")) {
                if (cipherParameters instanceof ParametersWithIV) {
                    DESParameters.b(((KeyParameter) ((ParametersWithIV) cipherParameters).a).a);
                } else {
                    DESParameters.b(((KeyParameter) cipherParameters).a);
                }
            }
            return cipherParameters;
        }

        public static CipherParameters f(byte[] bArr, int i, int i2, int i3, int i4, PBEParameterSpec pBEParameterSpec, String str) throws InvalidAlgorithmParameterException {
            CipherParameters cipherParameters;
            if (pBEParameterSpec != null) {
                PBEParametersGenerator b = b(i, i2);
                b.f(bArr, pBEParameterSpec.getIterationCount(), pBEParameterSpec.getSalt());
                if (i4 != 0) {
                    cipherParameters = b.e(i3, i4);
                } else {
                    cipherParameters = b.d(i3);
                }
                if (str.startsWith("DES")) {
                    if (cipherParameters instanceof ParametersWithIV) {
                        DESParameters.b(((KeyParameter) ((ParametersWithIV) cipherParameters).a).a);
                    } else {
                        DESParameters.b(((KeyParameter) cipherParameters).a);
                    }
                }
                return cipherParameters;
            }
            throw new InvalidAlgorithmParameterException("Need a PBEParameter spec with a PBE key.");
        }
    }
}
