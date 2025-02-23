package defpackage;

import java.io.File;
import java.io.FileFilter;

/* renamed from: bm  reason: default package and case insensitive filesystem */
/* compiled from: MultiDexExtractor */
public final class C0149bm implements FileFilter {
    public final boolean accept(File file) {
        return !file.getName().equals("MultiDex.lock");
    }
}
