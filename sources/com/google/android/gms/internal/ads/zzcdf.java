package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcdf extends SSLSocketFactory {
    final SSLSocketFactory zza = ((SSLSocketFactory) SSLSocketFactory.getDefault());
    final /* synthetic */ zzcdg zzb;

    public zzcdf(zzcdg zzcdg) {
        this.zzb = zzcdg;
    }

    private final Socket zza(Socket socket) throws SocketException {
        zzcdg zzcdg = this.zzb;
        if (zzcdg.zzq > 0) {
            socket.setReceiveBufferSize(zzcdg.zzq);
        }
        this.zzb.zzr.add(socket);
        return socket;
    }

    public final Socket createSocket(String str, int i) throws IOException {
        Socket createSocket = this.zza.createSocket(str, i);
        zza(createSocket);
        return createSocket;
    }

    public final String[] getDefaultCipherSuites() {
        return this.zza.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.zza.getSupportedCipherSuites();
    }

    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        Socket createSocket = this.zza.createSocket(str, i, inetAddress, i2);
        zza(createSocket);
        return createSocket;
    }

    public final Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        Socket createSocket = this.zza.createSocket(inetAddress, i);
        zza(createSocket);
        return createSocket;
    }

    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        Socket createSocket = this.zza.createSocket(inetAddress, i, inetAddress2, i2);
        zza(createSocket);
        return createSocket;
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        Socket createSocket = this.zza.createSocket(socket, str, i, z);
        zza(createSocket);
        return createSocket;
    }
}
