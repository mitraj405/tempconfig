package org.spongycastle.util.io.pem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PemObject implements PemObjectGenerator {
    public static final List b = Collections.unmodifiableList(new ArrayList());
    public final String a = "CERTIFICATE";

    /* renamed from: a  reason: collision with other field name */
    public final List f6859a = Collections.unmodifiableList(b);

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6860a;

    public PemObject(byte[] bArr) {
        this.f6860a = bArr;
    }
}
