package org.spongycastle.asn1;

import java.io.IOException;
import java.io.InputStream;

class ConstructedOctetStream extends InputStream {
    public InputStream a;

    /* renamed from: a  reason: collision with other field name */
    public final ASN1StreamParser f5667a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5668a = true;

    public ConstructedOctetStream(ASN1StreamParser aSN1StreamParser) {
        this.f5667a = aSN1StreamParser;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        ASN1OctetStringParser aSN1OctetStringParser;
        InputStream inputStream = this.a;
        ASN1StreamParser aSN1StreamParser = this.f5667a;
        int i3 = 0;
        if (inputStream == null) {
            if (!this.f5668a || (aSN1OctetStringParser = (ASN1OctetStringParser) aSN1StreamParser.a()) == null) {
                return -1;
            }
            this.f5668a = false;
            this.a = aSN1OctetStringParser.d();
        }
        while (true) {
            int read = this.a.read(bArr, i + i3, i2 - i3);
            if (read >= 0) {
                i3 += read;
                if (i3 == i2) {
                    return i3;
                }
            } else {
                ASN1OctetStringParser aSN1OctetStringParser2 = (ASN1OctetStringParser) aSN1StreamParser.a();
                if (aSN1OctetStringParser2 == null) {
                    this.a = null;
                    if (i3 < 1) {
                        return -1;
                    }
                    return i3;
                }
                this.a = aSN1OctetStringParser2.d();
            }
        }
    }

    public final int read() throws IOException {
        ASN1OctetStringParser aSN1OctetStringParser;
        InputStream inputStream = this.a;
        ASN1StreamParser aSN1StreamParser = this.f5667a;
        if (inputStream == null) {
            if (!this.f5668a || (aSN1OctetStringParser = (ASN1OctetStringParser) aSN1StreamParser.a()) == null) {
                return -1;
            }
            this.f5668a = false;
            this.a = aSN1OctetStringParser.d();
        }
        while (true) {
            int read = this.a.read();
            if (read >= 0) {
                return read;
            }
            ASN1OctetStringParser aSN1OctetStringParser2 = (ASN1OctetStringParser) aSN1StreamParser.a();
            if (aSN1OctetStringParser2 == null) {
                this.a = null;
                return -1;
            }
            this.a = aSN1OctetStringParser2.d();
        }
    }
}
