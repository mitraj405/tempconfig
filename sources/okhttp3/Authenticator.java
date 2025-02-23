package okhttp3;

import java.io.IOException;

public interface Authenticator {
    public static final Authenticator NONE = new JA();

    /* access modifiers changed from: private */
    static /* synthetic */ Request lambda$static$0(Route route, Response response) throws IOException {
        return null;
    }

    Request authenticate(Route route, Response response) throws IOException;
}
