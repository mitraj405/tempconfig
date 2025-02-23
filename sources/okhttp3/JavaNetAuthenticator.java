package okhttp3;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.util.List;
import okhttp3.Request;
import okhttp3.internal.annotations.EverythingIsNonNull;

@EverythingIsNonNull
public final class JavaNetAuthenticator implements Authenticator {
    private InetAddress getConnectToInetAddress(Proxy proxy, HttpUrl httpUrl) throws IOException {
        if (proxy == null || proxy.type() == Proxy.Type.DIRECT) {
            return InetAddress.getByName(httpUrl.host());
        }
        return ((InetSocketAddress) proxy.address()).getAddress();
    }

    public Request authenticate(Route route, Response response) throws IOException {
        boolean z;
        PasswordAuthentication passwordAuthentication;
        String str;
        List<Challenge> challenges = response.challenges();
        Request request = response.request();
        HttpUrl url = request.url();
        if (response.code() == 407) {
            z = true;
        } else {
            z = false;
        }
        Proxy proxy = route.proxy();
        int size = challenges.size();
        for (int i = 0; i < size; i++) {
            Challenge challenge = challenges.get(i);
            if ("Basic".equalsIgnoreCase(challenge.scheme())) {
                if (z) {
                    InetSocketAddress inetSocketAddress = (InetSocketAddress) proxy.address();
                    passwordAuthentication = Authenticator.requestPasswordAuthentication(inetSocketAddress.getHostName(), getConnectToInetAddress(proxy, url), inetSocketAddress.getPort(), url.scheme(), challenge.realm(), challenge.scheme(), url.url(), Authenticator.RequestorType.PROXY);
                } else {
                    passwordAuthentication = Authenticator.requestPasswordAuthentication(url.host(), getConnectToInetAddress(proxy, url), url.port(), url.scheme(), challenge.realm(), challenge.scheme(), url.url(), Authenticator.RequestorType.SERVER);
                }
                if (passwordAuthentication != null) {
                    String basic = Credentials.basic(passwordAuthentication.getUserName(), new String(passwordAuthentication.getPassword()), challenge.charset());
                    Request.Builder newBuilder = request.newBuilder();
                    if (z) {
                        str = HttpHeaders.PROXY_AUTHORIZATION;
                    } else {
                        str = HttpHeaders.AUTHORIZATION;
                    }
                    return newBuilder.header(str, basic).build();
                }
            }
        }
        return null;
    }
}
