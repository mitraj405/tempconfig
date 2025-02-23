package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class d implements CrashlyticsReportJsonTransform.ObjectParser {
    public final /* synthetic */ int a;

    public /* synthetic */ d(int i) {
        this.a = i;
    }

    public final Object parse(JsonReader jsonReader) {
        switch (this.a) {
            case 0:
                return CrashlyticsReportJsonTransform.parseEventBinaryImage(jsonReader);
            default:
                return CrashlyticsReportJsonTransform.parseCustomAttribute(jsonReader);
        }
    }
}
