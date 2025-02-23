package defpackage;

import com.airbnb.lottie.LottieAnimationView;
import defpackage.UB;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import javax.net.ssl.SSLException;

/* renamed from: cj  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0159cj implements Hj {
    public final void onResult(Object obj) {
        boolean z;
        Throwable th = (Throwable) obj;
        C0159cj cjVar = LottieAnimationView.a;
        UB.a aVar = UB.f567a;
        if ((th instanceof SocketException) || (th instanceof ClosedChannelException) || (th instanceof InterruptedIOException) || (th instanceof ProtocolException) || (th instanceof SSLException) || (th instanceof UnknownHostException) || (th instanceof UnknownServiceException)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            Ai.c("Unable to load composition.", th);
            return;
        }
        throw new IllegalStateException("Unable to parse composition", th);
    }
}
