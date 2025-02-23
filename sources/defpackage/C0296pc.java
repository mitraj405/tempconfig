package defpackage;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.os.Handler;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

@Deprecated
/* renamed from: pc  reason: default package and case insensitive filesystem */
/* compiled from: FingerprintManagerCompat */
public final class C0296pc {
    public final Context a;

    /* renamed from: pc$a */
    /* compiled from: FingerprintManagerCompat */
    public static class a {
        public static void a(Object obj, Object obj2, CancellationSignal cancellationSignal, int i, Object obj3, Handler handler) {
            ((FingerprintManager) obj).authenticate((FingerprintManager.CryptoObject) obj2, cancellationSignal, i, (FingerprintManager.AuthenticationCallback) obj3, handler);
        }

        public static FingerprintManager.CryptoObject b(Object obj) {
            return ((FingerprintManager.AuthenticationResult) obj).getCryptoObject();
        }

        public static FingerprintManager c(Context context) {
            if (context.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
                return (FingerprintManager) context.getSystemService(FingerprintManager.class);
            }
            return null;
        }

        public static boolean d(Object obj) {
            return ((FingerprintManager) obj).hasEnrolledFingerprints();
        }

        public static boolean e(Object obj) {
            return ((FingerprintManager) obj).isHardwareDetected();
        }

        public static c f(Object obj) {
            FingerprintManager.CryptoObject cryptoObject = (FingerprintManager.CryptoObject) obj;
            if (cryptoObject == null) {
                return null;
            }
            if (cryptoObject.getCipher() != null) {
                return new c(cryptoObject.getCipher());
            }
            if (cryptoObject.getSignature() != null) {
                return new c(cryptoObject.getSignature());
            }
            if (cryptoObject.getMac() != null) {
                return new c(cryptoObject.getMac());
            }
            return null;
        }

        public static FingerprintManager.CryptoObject g(c cVar) {
            if (cVar == null) {
                return null;
            }
            Cipher cipher = cVar.f3172a;
            if (cipher != null) {
                return new FingerprintManager.CryptoObject(cipher);
            }
            Signature signature = cVar.a;
            if (signature != null) {
                return new FingerprintManager.CryptoObject(signature);
            }
            Mac mac = cVar.f3173a;
            if (mac != null) {
                return new FingerprintManager.CryptoObject(mac);
            }
            return null;
        }
    }

    /* renamed from: pc$b */
    /* compiled from: FingerprintManagerCompat */
    public static abstract class b {
    }

    public C0296pc(Context context) {
        this.a = context;
    }

    /* renamed from: pc$c */
    /* compiled from: FingerprintManagerCompat */
    public static class c {
        public final Signature a;

        /* renamed from: a  reason: collision with other field name */
        public final Cipher f3172a;

        /* renamed from: a  reason: collision with other field name */
        public final Mac f3173a;

        public c(Signature signature) {
            this.a = signature;
            this.f3172a = null;
            this.f3173a = null;
        }

        public c(Cipher cipher) {
            this.f3172a = cipher;
            this.a = null;
            this.f3173a = null;
        }

        public c(Mac mac) {
            this.f3173a = mac;
            this.f3172a = null;
            this.a = null;
        }
    }
}
