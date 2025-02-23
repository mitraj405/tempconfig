package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Key;

/* renamed from: Zg  reason: default package */
/* compiled from: JsonWebSignature */
public final class Zg extends C0803bh {
    public final String a = "UTF-8";
    public byte[] b;

    public Zg() {
        if (!Boolean.getBoolean("org.jose4j.jws.default-allow-none")) {
            this.f3917a = C1315p0.b;
        }
    }

    public final C0783ah b() throws C1240lg {
        String a2 = this.f3914a.a("alg");
        if (a2 != null) {
            this.f3917a.a(a2);
            return C1359r0.f6934a.f6935a.a(a2);
        }
        throw new C1240lg("Signature algorithm header (alg) not set.");
    }

    public final String c() throws C0626Og {
        byte[] bArr;
        String str;
        C0783ah b2 = b();
        Key key = this.f3915a;
        if (this.f3918a) {
            b2.f(key);
        }
        C0480D7 j = b2.j(key, this.a);
        boolean d = d();
        nh nhVar = this.f3916a;
        if (!d) {
            bArr = r1.u(C1354qp.w0(a(), nhVar.e(this.b)), "US-ASCII");
        } else {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayOutputStream.write(r1.u(a(), "US-ASCII"));
                byteArrayOutputStream.write(46);
                byteArrayOutputStream.write(this.b);
                bArr = byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                throw new C0626Og("This should never happen from a ByteArrayOutputStream", e);
            }
        }
        this.f3919a = b().i(j, bArr);
        if (d()) {
            byte[] bArr2 = this.b;
            String str2 = this.a;
            if (bArr2 == null) {
                str = null;
            } else {
                try {
                    str = new String(bArr2, str2);
                } catch (UnsupportedEncodingException unused) {
                    throw new IllegalStateException(C0709Uj.i("Unknown or unsupported character set name: ", str2));
                }
            }
            if (str.contains(".")) {
                throw new C0626Og("per https://tools.ietf.org/html/rfc7797#section-5.2 when using the JWS Compact Serialization, unencoded non-detached payloads using period ('.') characters would cause parsing errors; such payloads MUST NOT be used with the JWS Compact Serialization.");
            }
        } else {
            str = nhVar.e(this.b);
        }
        return C1354qp.w0(a(), str, nhVar.e(this.f3919a));
    }

    public final boolean d() {
        Object obj = this.f3914a.f3754a.get("b64");
        if (obj == null || !(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
            return false;
        }
        return true;
    }
}
