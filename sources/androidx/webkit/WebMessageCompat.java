package androidx.webkit;

import java.util.Objects;

public final class WebMessageCompat {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final String f2634a;

    public WebMessageCompat(String str) {
        this.f2634a = str;
        this.a = 0;
    }

    public WebMessageCompat(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.f2634a = null;
        this.a = 1;
    }
}
