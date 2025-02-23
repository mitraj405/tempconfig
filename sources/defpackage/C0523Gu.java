package defpackage;

import java.io.PrintStream;
import rx.Subscription;

/* renamed from: Gu  reason: default package and case insensitive filesystem */
/* compiled from: RxRingBuffer */
public final class C0523Gu implements Subscription {
    public static final int c;

    static {
        int i;
        if (C1518zp.f7108a) {
            i = 16;
        } else {
            i = 128;
        }
        String property = System.getProperty("rx.ring-buffer.size");
        if (property != null) {
            try {
                i = Integer.parseInt(property);
            } catch (NumberFormatException e) {
                PrintStream printStream = System.err;
                StringBuilder K = xx.K("Failed to set 'rx.buffer.size' with value ", property, " => ");
                K.append(e.getMessage());
                printStream.println(K.toString());
            }
        }
        c = i;
    }
}
