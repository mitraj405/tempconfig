package com.google.android.datatransport.cct;

import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.runtime.retries.Function;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class a implements Function {
    public final /* synthetic */ CctTransportBackend a;

    public /* synthetic */ a(CctTransportBackend cctTransportBackend) {
        this.a = cctTransportBackend;
    }

    public final Object apply(Object obj) {
        return this.a.doSend((CctTransportBackend.HttpRequest) obj);
    }
}
