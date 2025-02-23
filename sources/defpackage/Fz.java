package defpackage;

import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import java.io.File;
import java.util.Comparator;

/* renamed from: Fz  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Fz implements Comparator {
    public final /* synthetic */ int c;

    public /* synthetic */ Fz(int i) {
        this.c = i;
    }

    public final int compare(Object obj, Object obj2) {
        switch (this.c) {
            case 0:
                return ((Double) obj).compareTo((Double) obj2);
            default:
                return CrashlyticsReportPersistence.oldestEventFileFirst((File) obj, (File) obj2);
        }
    }
}
