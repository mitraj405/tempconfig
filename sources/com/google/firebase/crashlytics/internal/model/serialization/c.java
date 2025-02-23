package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class c implements CrashlyticsReportJsonTransform.ObjectParser {
    public final /* synthetic */ int a;

    public /* synthetic */ c(int i) {
        this.a = i;
    }

    public final Object parse(JsonReader jsonReader) {
        switch (this.a) {
            case 0:
                return CrashlyticsReportJsonTransform.parseEventThread(jsonReader);
            case 1:
                return CrashlyticsReportJsonTransform.parseEventRolloutsAssignment(jsonReader);
            default:
                return CrashlyticsReportJsonTransform.parseBuildIdMappingForArch(jsonReader);
        }
    }
}
