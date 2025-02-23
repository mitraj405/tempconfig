package org.spongycastle.crypto.util;

import com.google.android.gms.ads.AdRequest;
import org.spongycastle.crypto.digests.SHA3Digest;

public final class DigestFactory {
    public static SHA3Digest a() {
        return new SHA3Digest(224);
    }

    public static SHA3Digest b() {
        return new SHA3Digest(256);
    }

    public static SHA3Digest c() {
        return new SHA3Digest(384);
    }

    public static SHA3Digest d() {
        return new SHA3Digest((int) AdRequest.MAX_CONTENT_URL_LENGTH);
    }
}
