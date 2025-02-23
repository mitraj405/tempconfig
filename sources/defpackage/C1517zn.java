package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* renamed from: zn  reason: default package and case insensitive filesystem */
/* compiled from: Okio */
public final class C1517zn {
    public static final Logger a = Logger.getLogger(C1517zn.class.getName());

    public static Sink a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getOutputStream() != null) {
            C1500yn ynVar = new C1500yn(socket);
            OutputStream outputStream = socket.getOutputStream();
            if (outputStream != null) {
                return ynVar.sink(new C1445vn(outputStream, ynVar));
            }
            throw new IllegalArgumentException("out == null");
        } else {
            throw new IOException("socket's output stream == null");
        }
    }

    public static C1463wn b(InputStream inputStream) {
        Timeout timeout = new Timeout();
        if (inputStream != null) {
            return new C1463wn(inputStream, timeout);
        }
        throw new IllegalArgumentException("in == null");
    }

    public static Source c(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getInputStream() != null) {
            C1500yn ynVar = new C1500yn(socket);
            InputStream inputStream = socket.getInputStream();
            if (inputStream != null) {
                return ynVar.source(new C1463wn(inputStream, ynVar));
            }
            throw new IllegalArgumentException("in == null");
        } else {
            throw new IOException("socket's input stream == null");
        }
    }
}
