package org.spongycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

public class ASN1StreamParser {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final InputStream f5662a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[][] f5663a;

    public ASN1StreamParser(InputStream inputStream) {
        this(inputStream, StreamUtil.c(inputStream));
    }

    public final ASN1Encodable a() throws IOException {
        InputStream inputStream = this.f5662a;
        int read = inputStream.read();
        if (read == -1) {
            return null;
        }
        boolean z = false;
        if (inputStream instanceof IndefiniteLengthInputStream) {
            IndefiniteLengthInputStream indefiniteLengthInputStream = (IndefiniteLengthInputStream) inputStream;
            indefiniteLengthInputStream.b = false;
            indefiniteLengthInputStream.c();
        }
        int l = ASN1InputStream.l(read, inputStream);
        if ((read & 32) != 0) {
            z = true;
        }
        int i = this.a;
        int h = ASN1InputStream.h(i, inputStream);
        if (h >= 0) {
            DefiniteLengthInputStream definiteLengthInputStream = new DefiniteLengthInputStream(inputStream, h);
            if ((read & 64) != 0) {
                return new DERApplicationSpecific(definiteLengthInputStream.c(), l, z);
            }
            if ((read & 128) != 0) {
                return new BERTaggedObjectParser(z, l, new ASN1StreamParser(definiteLengthInputStream));
            }
            if (z) {
                if (l == 4) {
                    return new BEROctetStringParser(new ASN1StreamParser(definiteLengthInputStream));
                }
                if (l == 8) {
                    return new DERExternalParser(new ASN1StreamParser(definiteLengthInputStream));
                }
                if (l == 16) {
                    return new DERSequenceParser(new ASN1StreamParser(definiteLengthInputStream));
                }
                if (l == 17) {
                    return new DERSetParser(new ASN1StreamParser(definiteLengthInputStream));
                }
                throw new IOException(C1058d.y("unknown tag ", l, " encountered"));
            } else if (l == 4) {
                return new DEROctetStringParser(definiteLengthInputStream);
            } else {
                try {
                    return ASN1InputStream.c(l, definiteLengthInputStream, this.f5663a);
                } catch (IllegalArgumentException e) {
                    throw new ASN1Exception("corrupted stream detected", e);
                }
            }
        } else if (z) {
            ASN1StreamParser aSN1StreamParser = new ASN1StreamParser(new IndefiniteLengthInputStream(inputStream, i), i);
            if ((read & 64) != 0) {
                return new BERApplicationSpecificParser(l, aSN1StreamParser);
            }
            if ((read & 128) != 0) {
                return new BERTaggedObjectParser(true, l, aSN1StreamParser);
            }
            if (l == 4) {
                return new BEROctetStringParser(aSN1StreamParser);
            }
            if (l == 8) {
                return new DERExternalParser(aSN1StreamParser);
            }
            if (l == 16) {
                return new BERSequenceParser(aSN1StreamParser);
            }
            if (l == 17) {
                return new BERSetParser(aSN1StreamParser);
            }
            throw new ASN1Exception("unknown BER object encountered: 0x" + Integer.toHexString(l));
        } else {
            throw new IOException("indefinite-length primitive encoding encountered");
        }
    }

    public final ASN1TaggedObject b(int i, boolean z) throws IOException {
        ASN1Encodable aSN1Encodable;
        BERSequence bERSequence;
        InputStream inputStream = this.f5662a;
        if (!z) {
            return new DERTaggedObject(false, i, new DEROctetString(((DefiniteLengthInputStream) inputStream).c()));
        }
        ASN1EncodableVector c = c();
        if (inputStream instanceof IndefiniteLengthInputStream) {
            if (c.c() == 1) {
                return new BERTaggedObject(true, i, c.b(0));
            }
            BERSequence bERSequence2 = BERFactory.a;
            if (c.c() < 1) {
                bERSequence = BERFactory.a;
            } else {
                bERSequence = new BERSequence(c);
            }
            return new BERTaggedObject(false, i, bERSequence);
        } else if (c.c() == 1) {
            return new DERTaggedObject(true, i, c.b(0));
        } else {
            DERSequence dERSequence = DERFactory.a;
            if (c.c() < 1) {
                aSN1Encodable = DERFactory.a;
            } else {
                aSN1Encodable = new DLSequence(c);
            }
            return new DERTaggedObject(false, i, aSN1Encodable);
        }
    }

    public final ASN1EncodableVector c() throws IOException {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        while (true) {
            ASN1Encodable a2 = a();
            if (a2 == null) {
                return aSN1EncodableVector;
            }
            if (a2 instanceof InMemoryRepresentable) {
                aSN1EncodableVector.a(((InMemoryRepresentable) a2).a());
            } else {
                aSN1EncodableVector.a(a2.b());
            }
        }
    }

    public ASN1StreamParser(InputStream inputStream, int i) {
        this.f5662a = inputStream;
        this.a = i;
        this.f5663a = new byte[11][];
    }
}
