package defpackage;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: si  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1388si implements FilenameFilter {
    public final /* synthetic */ String a;

    public /* synthetic */ C1388si(String str) {
        this.a = str;
    }

    public final boolean accept(File file, String str) {
        return str.contains(this.a);
    }
}
