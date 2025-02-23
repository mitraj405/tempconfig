package org.spongycastle.asn1;

import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.perf.util.Constants;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.io.Streams;

public class ASN1InputStream extends FilterInputStream implements BERTags {
    public final boolean a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[][] f5658a;
    public final int c;

    public ASN1InputStream() {
        throw null;
    }

    public ASN1InputStream(InputStream inputStream) {
        this(inputStream, StreamUtil.c(inputStream), false);
    }

    public static ASN1EncodableVector a(DefiniteLengthInputStream definiteLengthInputStream) throws IOException {
        ASN1InputStream aSN1InputStream = new ASN1InputStream((InputStream) definiteLengthInputStream);
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        while (true) {
            ASN1Primitive j = aSN1InputStream.j();
            if (j == null) {
                return aSN1EncodableVector;
            }
            aSN1EncodableVector.a(j);
        }
    }

    public static ASN1Primitive c(int i, DefiniteLengthInputStream definiteLengthInputStream, byte[][] bArr) throws IOException {
        int read;
        if (i == 10) {
            byte[] e = e(definiteLengthInputStream, bArr);
            if (e.length > 1) {
                return new ASN1Enumerated(e);
            }
            if (e.length != 0) {
                byte b = e[0] & UnsignedBytes.MAX_VALUE;
                if (b >= 12) {
                    return new ASN1Enumerated(Arrays.c(e));
                }
                ASN1Enumerated[] aSN1EnumeratedArr = ASN1Enumerated.a;
                ASN1Enumerated aSN1Enumerated = aSN1EnumeratedArr[b];
                if (aSN1Enumerated == null) {
                    aSN1Enumerated = new ASN1Enumerated(Arrays.c(e));
                    aSN1EnumeratedArr[b] = aSN1Enumerated;
                }
                return aSN1Enumerated;
            }
            throw new IllegalArgumentException("ENUMERATED has zero length");
        } else if (i == 12) {
            return new DERUTF8String(definiteLengthInputStream.c());
        } else {
            if (i != 30) {
                switch (i) {
                    case 1:
                        return ASN1Boolean.q(e(definiteLengthInputStream, bArr));
                    case 2:
                        return new ASN1Integer(definiteLengthInputStream.c(), false);
                    case 3:
                        int i2 = definiteLengthInputStream.e;
                        if (i2 >= 1) {
                            int read2 = definiteLengthInputStream.read();
                            int i3 = i2 - 1;
                            byte[] bArr2 = new byte[i3];
                            if (i3 != 0) {
                                if (Streams.b(definiteLengthInputStream, bArr2, 0, i3) != i3) {
                                    throw new EOFException("EOF encountered in middle of BIT STRING");
                                } else if (read2 > 0 && read2 < 8) {
                                    byte b2 = bArr2[i3 - 1];
                                    if (b2 != ((byte) ((Constants.MAX_HOST_LENGTH << read2) & b2))) {
                                        return new DLBitString(bArr2, read2);
                                    }
                                }
                            }
                            return new DERBitString(bArr2, read2);
                        }
                        throw new IllegalArgumentException("truncated BIT STRING detected");
                    case 4:
                        return new DEROctetString(definiteLengthInputStream.c());
                    case 5:
                        return DERNull.a;
                    case 6:
                        return ASN1ObjectIdentifier.s(e(definiteLengthInputStream, bArr));
                    default:
                        switch (i) {
                            case 18:
                                return new DERNumericString(definiteLengthInputStream.c());
                            case 19:
                                return new DERPrintableString(definiteLengthInputStream.c());
                            case 20:
                                return new DERT61String(definiteLengthInputStream.c());
                            case 21:
                                return new DERVideotexString(definiteLengthInputStream.c());
                            case 22:
                                return new DERIA5String(definiteLengthInputStream.c());
                            case 23:
                                return new ASN1UTCTime(definiteLengthInputStream.c());
                            case 24:
                                return new ASN1GeneralizedTime(definiteLengthInputStream.c());
                            case 25:
                                return new DERGraphicString(definiteLengthInputStream.c());
                            case 26:
                                return new DERVisibleString(definiteLengthInputStream.c());
                            case 27:
                                return new DERGeneralString(definiteLengthInputStream.c());
                            case 28:
                                return new DERUniversalString(definiteLengthInputStream.c());
                            default:
                                throw new IOException(C1058d.y("unknown tag ", i, " encountered"));
                        }
                }
            } else {
                int i4 = definiteLengthInputStream.e / 2;
                char[] cArr = new char[i4];
                for (int i5 = 0; i5 < i4; i5++) {
                    int read3 = definiteLengthInputStream.read();
                    if (read3 < 0 || (read = definiteLengthInputStream.read()) < 0) {
                        break;
                    }
                    cArr[i5] = (char) ((read3 << 8) | (read & Constants.MAX_HOST_LENGTH));
                }
                return new DERBMPString(cArr);
            }
        }
    }

    public static byte[] e(DefiniteLengthInputStream definiteLengthInputStream, byte[][] bArr) throws IOException {
        int i = definiteLengthInputStream.e;
        if (i >= bArr.length) {
            return definiteLengthInputStream.c();
        }
        byte[] bArr2 = bArr[i];
        if (bArr2 == null) {
            bArr2 = new byte[i];
            bArr[i] = bArr2;
        }
        Streams.b(definiteLengthInputStream, bArr2, 0, bArr2.length);
        return bArr2;
    }

    public static int h(int i, InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read < 0) {
            throw new EOFException("EOF found when length expected");
        } else if (read == 128) {
            return -1;
        } else {
            if (read <= 127) {
                return read;
            }
            int i2 = read & 127;
            if (i2 <= 4) {
                int i3 = 0;
                int i4 = 0;
                while (i4 < i2) {
                    int read2 = inputStream.read();
                    if (read2 >= 0) {
                        i3 = (i3 << 8) + read2;
                        i4++;
                    } else {
                        throw new EOFException("EOF found reading length");
                    }
                }
                if (i3 < 0) {
                    throw new IOException("corrupted stream - negative length found");
                } else if (i3 < i) {
                    return i3;
                } else {
                    throw new IOException("corrupted stream - out of bounds length found");
                }
            } else {
                throw new IOException(lf.h("DER length more than 4 bytes: ", i2));
            }
        }
    }

    public static int l(int i, InputStream inputStream) throws IOException {
        int i2 = i & 31;
        if (i2 != 31) {
            return i2;
        }
        int read = inputStream.read();
        if ((read & 127) != 0) {
            int i3 = 0;
            while (read >= 0 && (read & 128) != 0) {
                i3 = ((read & 127) | i3) << 7;
                read = inputStream.read();
            }
            if (read >= 0) {
                return (read & 127) | i3;
            }
            throw new EOFException("EOF found inside tag value.");
        }
        throw new IOException("corrupted stream - invalid high tag number found");
    }

    public final ASN1Primitive b(int i, int i2, int i3) throws IOException {
        boolean z;
        if ((i & 32) != 0) {
            z = true;
        } else {
            z = false;
        }
        DefiniteLengthInputStream definiteLengthInputStream = new DefiniteLengthInputStream(this, i3);
        if ((i & 64) != 0) {
            return new DERApplicationSpecific(definiteLengthInputStream.c(), i2, z);
        }
        if ((i & 128) != 0) {
            return new ASN1StreamParser(definiteLengthInputStream).b(i2, z);
        }
        if (!z) {
            return c(i2, definiteLengthInputStream, this.f5658a);
        }
        if (i2 == 4) {
            ASN1EncodableVector a2 = a(definiteLengthInputStream);
            int c2 = a2.c();
            ASN1OctetString[] aSN1OctetStringArr = new ASN1OctetString[c2];
            for (int i4 = 0; i4 != c2; i4++) {
                aSN1OctetStringArr[i4] = (ASN1OctetString) a2.b(i4);
            }
            return new BEROctetString(aSN1OctetStringArr);
        } else if (i2 == 8) {
            return new DERExternal(a(definiteLengthInputStream));
        } else {
            if (i2 != 16) {
                if (i2 == 17) {
                    ASN1EncodableVector a3 = a(definiteLengthInputStream);
                    DERSequence dERSequence = DERFactory.a;
                    if (a3.c() < 1) {
                        return DERFactory.f5670a;
                    }
                    return new DLSet(a3);
                }
                throw new IOException(C1058d.y("unknown tag ", i2, " encountered"));
            } else if (this.a) {
                return new LazyEncodedSequence(definiteLengthInputStream.c());
            } else {
                ASN1EncodableVector a4 = a(definiteLengthInputStream);
                DERSequence dERSequence2 = DERFactory.a;
                if (a4.c() < 1) {
                    return DERFactory.a;
                }
                return new DLSequence(a4);
            }
        }
    }

    public final ASN1Primitive j() throws IOException {
        boolean z;
        int read = read();
        if (read > 0) {
            int l = l(read, this);
            if ((read & 32) != 0) {
                z = true;
            } else {
                z = false;
            }
            int i = this.c;
            int h = h(i, this);
            if (h >= 0) {
                try {
                    return b(read, l, h);
                } catch (IllegalArgumentException e) {
                    throw new ASN1Exception("corrupted stream detected", e);
                }
            } else if (z) {
                ASN1StreamParser aSN1StreamParser = new ASN1StreamParser(new IndefiniteLengthInputStream(this, i), i);
                if ((read & 64) != 0) {
                    return new BERApplicationSpecificParser(l, aSN1StreamParser).a();
                }
                if ((read & 128) != 0) {
                    return new BERTaggedObjectParser(true, l, aSN1StreamParser).a();
                }
                if (l == 4) {
                    return new BEROctetStringParser(aSN1StreamParser).a();
                }
                if (l == 8) {
                    return new DERExternalParser(aSN1StreamParser).a();
                }
                if (l == 16) {
                    return new BERSequenceParser(aSN1StreamParser).a();
                }
                if (l == 17) {
                    return new BERSetParser(aSN1StreamParser).a();
                }
                throw new IOException("unknown BER object encountered");
            } else {
                throw new IOException("indefinite-length primitive encoding encountered");
            }
        } else if (read != 0) {
            return null;
        } else {
            throw new IOException("unexpected end-of-contents marker");
        }
    }

    public ASN1InputStream(byte[] bArr) {
        this(new ByteArrayInputStream(bArr), bArr.length, false);
    }

    public ASN1InputStream(InputStream inputStream, int i) {
        this(inputStream, StreamUtil.c(inputStream), true);
    }

    public ASN1InputStream(InputStream inputStream, int i, boolean z) {
        super(inputStream);
        this.c = i;
        this.a = z;
        this.f5658a = new byte[11][];
    }
}
