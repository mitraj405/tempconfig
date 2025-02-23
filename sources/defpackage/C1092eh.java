package defpackage;

import in.juspay.hypersdk.core.JuspayServices;
import in.juspay.hypersdk.lifecycle.EventListener;
import in.juspay.hypersdk.lifecycle.FragmentEvent;

/* renamed from: eh  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C1092eh implements EventListener {
    public final /* synthetic */ JuspayServices a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ FragmentEvent f5453a;

    public /* synthetic */ C1092eh(JuspayServices juspayServices, FragmentEvent fragmentEvent) {
        this.a = juspayServices;
        this.f5453a = fragmentEvent;
    }

    public final void onEvent(String str) {
        this.a.lambda$addFragment$6(this.f5453a, str);
    }
}
