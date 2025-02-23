package defpackage;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* renamed from: oz  reason: default package and case insensitive filesystem */
/* compiled from: TLSSocketFactory */
public final class C1313oz extends SSLSocketFactory {
    public volatile SSLContext a = SSLContext.getInstance("TLS");

    /* renamed from: a  reason: collision with other field name */
    public final SSLSocketFactory f6881a;

    public C1313oz() throws KeyManagementException, NoSuchAlgorithmException {
        try {
            SSLContext sSLContext = this.a;
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            sSLContext.init((KeyManager[]) null, new TrustManager[]{new C1293nz((X509TrustManager) instance.getTrustManagers()[0])}, (SecureRandom) null);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f6881a = this.a.getSocketFactory();
    }

    public static void a(Socket socket) {
        if (socket != null && (socket instanceof SSLSocket)) {
            ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.2", "TLSv1.1"});
        }
    }

    public final Socket createSocket() throws IOException {
        Socket createSocket = this.f6881a.createSocket();
        a(createSocket);
        return createSocket;
    }

    public final String[] getDefaultCipherSuites() {
        return this.f6881a.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.f6881a.getSupportedCipherSuites();
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        Socket createSocket = this.f6881a.createSocket(socket, str, i, z);
        a(createSocket);
        return createSocket;
    }

    public final Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        Socket createSocket = this.f6881a.createSocket(str, i);
        a(createSocket);
        return createSocket;
    }

    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        Socket createSocket = this.f6881a.createSocket(str, i, inetAddress, i2);
        a(createSocket);
        return createSocket;
    }

    public final Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        Socket createSocket = this.f6881a.createSocket(inetAddress, i);
        a(createSocket);
        return createSocket;
    }

    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        Socket createSocket = this.f6881a.createSocket(inetAddress, i, inetAddress2, i2);
        a(createSocket);
        return createSocket;
    }
}
