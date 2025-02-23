package defpackage;

import java.util.Comparator;
import okhttp3.CipherSuite;

/* renamed from: f5  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1103f5 implements Comparator {
    public final /* synthetic */ int c;

    public /* synthetic */ C1103f5(int i) {
        this.c = i;
    }

    public final int compare(Object obj, Object obj2) {
        switch (this.c) {
            case 0:
                return CipherSuite.lambda$static$0((String) obj, (String) obj2);
            default:
                return ((String) obj).compareTo((String) obj2);
        }
    }
}
