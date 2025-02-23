package defpackage;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: hc  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0215hc implements FilenameFilter {
    public final /* synthetic */ String a;

    public /* synthetic */ C0215hc(String str) {
        this.a = str;
    }

    public final boolean accept(File file, String str) {
        return str.startsWith(this.a);
    }
}
