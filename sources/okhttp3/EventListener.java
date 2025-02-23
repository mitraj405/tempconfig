package okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

public abstract class EventListener {
    public static final EventListener NONE = new EventListener() {
    };

    public interface Factory {
        EventListener create(Call call);
    }

    public static Factory factory(EventListener eventListener) {
        return new L(eventListener, 10);
    }

    public void callEnd(Call call) {
    }

    public void callStart(Call call) {
    }

    public void requestBodyStart(Call call) {
    }

    public void requestHeadersStart(Call call) {
    }

    public void responseBodyStart(Call call) {
    }

    public void responseHeadersStart(Call call) {
    }

    public void secureConnectStart(Call call) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ EventListener lambda$factory$0(EventListener eventListener, Call call) {
        return eventListener;
    }

    public void callFailed(Call call, IOException iOException) {
    }

    public void connectionAcquired(Call call, Connection connection) {
    }

    public void connectionReleased(Call call, Connection connection) {
    }

    public void dnsStart(Call call, String str) {
    }

    public void requestBodyEnd(Call call, long j) {
    }

    public void requestFailed(Call call, IOException iOException) {
    }

    public void requestHeadersEnd(Call call, Request request) {
    }

    public void responseBodyEnd(Call call, long j) {
    }

    public void responseFailed(Call call, IOException iOException) {
    }

    public void responseHeadersEnd(Call call, Response response) {
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
    }
}
