package defpackage;

import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;

/* renamed from: Rg  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Rg implements ValueEncoder {
    public final void encode(Object obj, Object obj2) {
        ((ValueEncoderContext) obj2).add(((Boolean) obj).booleanValue());
    }
}
