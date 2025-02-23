package in.juspay.hypersdk.security;

import android.annotation.SuppressLint;
import android.net.http.X509TrustManagerExtensions;
import androidx.annotation.Keep;
import in.juspay.hypersdk.core.PaymentUtils;
import in.juspay.hypersdk.utils.network.JuspaySSLSocketFactory;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Set;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class HyperSSLSocketFactory extends JuspaySSLSocketFactory {
    private final SSLSocketFactory sslSocketFactory;

    public static class CustomX509TrustManager implements X509TrustManager {
        private final Set<String> acceptedCerts;
        private final X509TrustManager defaultTrust;
        private final X509TrustManagerExtensions defaultTrustExtension;

        public CustomX509TrustManager(X509TrustManager x509TrustManager, X509TrustManagerExtensions x509TrustManagerExtensions, Set<String> set) {
            this.defaultTrust = x509TrustManager;
            this.acceptedCerts = set;
            this.defaultTrustExtension = x509TrustManagerExtensions;
        }

        @SuppressLint({"TrustAllX509TrustManager"})
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            this.defaultTrust.checkClientTrusted(x509CertificateArr, str);
        }

        @SuppressLint({"TrustAllX509TrustManager"})
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            this.defaultTrust.checkServerTrusted(x509CertificateArr, str);
            if (PaymentUtils.validatePinning(x509CertificateArr, this.acceptedCerts)) {
                throw new CertificateException("SSL Pinning failed");
            }
        }

        public X509Certificate[] getAcceptedIssuers() {
            return this.defaultTrust.getAcceptedIssuers();
        }

        @Keep
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, String str2) {
            this.defaultTrustExtension.checkServerTrusted(x509CertificateArr, str, str2);
            if (PaymentUtils.validatePinning(x509CertificateArr, this.acceptedCerts)) {
                throw new CertificateException("SSL Pinning failed");
            }
        }
    }

    public HyperSSLSocketFactory(Set<String> set) {
        SSLContext instance = SSLContext.getInstance("SSL");
        TrustManagerFactory instance2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance2.init((KeyStore) null);
        X509TrustManager x509TrustManager = (X509TrustManager) instance2.getTrustManagers()[0];
        instance.init((KeyManager[]) null, new TrustManager[]{new CustomX509TrustManager(x509TrustManager, new X509TrustManagerExtensions(x509TrustManager), set)}, new SecureRandom());
        this.sslSocketFactory = instance.getSocketFactory();
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }
}
