package defpackage;

import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import java.io.File;
import java.io.FilenameFilter;

/* renamed from: B7  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class B7 implements FilenameFilter {
    public final boolean accept(File file, String str) {
        return str.startsWith(CrashlyticsReportPersistence.EVENT_FILE_NAME_PREFIX);
    }
}
