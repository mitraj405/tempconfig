package defpackage;

import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import java.io.File;
import java.io.FilenameFilter;

/* renamed from: A7  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class A7 implements FilenameFilter {
    public final boolean accept(File file, String str) {
        return CrashlyticsReportPersistence.isNormalPriorityEventFile(file, str);
    }
}
