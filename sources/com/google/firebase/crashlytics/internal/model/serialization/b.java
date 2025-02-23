package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class b implements CrashlyticsReportJsonTransform.ObjectParser {
    public final /* synthetic */ int a;

    public /* synthetic */ b(int i) {
        this.a = i;
    }

    public final Object parse(JsonReader jsonReader) {
        switch (this.a) {
            case 0:
                return CrashlyticsReportJsonTransform.parseEvent(jsonReader);
            case 1:
                return CrashlyticsReportJsonTransform.parseEventFrame(jsonReader);
            default:
                return CrashlyticsReportJsonTransform.parseProcessDetails(jsonReader);
        }
    }
}
