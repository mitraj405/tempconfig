package defpackage;

import java.io.File;
import java.util.Comparator;

/* renamed from: Wc  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0105Wc implements Comparator {
    public final /* synthetic */ int c;

    public /* synthetic */ C0105Wc(int i) {
        this.c = i;
    }

    public final int compare(Object obj, Object obj2) {
        switch (this.c) {
            case 0:
                byte[] bArr = (byte[]) obj;
                byte[] bArr2 = (byte[]) obj2;
                if (bArr.length != bArr2.length) {
                    return bArr.length - bArr2.length;
                }
                for (int i = 0; i < bArr.length; i++) {
                    byte b = bArr[i];
                    byte b2 = bArr2[i];
                    if (b != b2) {
                        return b - b2;
                    }
                }
                return 0;
            default:
                return ((File) obj2).getName().compareTo(((File) obj).getName());
        }
    }
}
