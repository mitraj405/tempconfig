package defpackage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

/* renamed from: C8  reason: default package and case insensitive filesystem */
/* compiled from: DeflateRFC1951CompressionAlgorithm */
public final class C0469C8 implements C1298o6 {
    public static final Bi a = C0473Ci.d(C0469C8.class);

    /* renamed from: a  reason: collision with other field name */
    public final int f3544a = 204800;

    public C0469C8() {
        Bi bi = a;
        try {
            this.f3544a = Integer.parseInt(System.getProperty("org.jose4j.zip.decompress-max-bytes", "204800"));
        } catch (NumberFormatException e) {
            bi.b("Using the default value of " + this.f3544a + " for the maximum allowed size of decompressed data because the system property org.jose4j.zip.decompress-max-bytes contains an invalid value: " + e);
        }
        bi.b("");
    }

    public final boolean b() {
        return true;
    }

    public final byte[] d(byte[] bArr) {
        DeflaterOutputStream deflaterOutputStream;
        Deflater deflater = new Deflater(8, true);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.finish();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                deflaterOutputStream.close();
                byteArrayOutputStream.close();
                deflater.end();
                return byteArray;
            } catch (Throwable th) {
                byteArrayOutputStream.close();
                throw th;
            }
            throw th;
        } catch (IOException e) {
            try {
                throw new V5("Problem compressing data.", e);
            } catch (Throwable th2) {
                deflater.end();
                throw th2;
            }
        } catch (Throwable th3) {
            th.addSuppressed(th3);
        }
    }

    public final String e() {
        return "DEF";
    }
}
