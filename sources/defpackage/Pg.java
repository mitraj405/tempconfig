package defpackage;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.google.firebase.encoders.proto.ProtobufEncoder;

/* renamed from: Pg  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Pg implements ObjectEncoder {
    public final /* synthetic */ int a;

    public /* synthetic */ Pg(int i) {
        this.a = i;
    }

    public final void encode(Object obj, Object obj2) {
        switch (this.a) {
            case 0:
                JsonDataEncoderBuilder.lambda$static$0(obj, (ObjectEncoderContext) obj2);
                return;
            default:
                ProtobufEncoder.Builder.lambda$static$0(obj, (ObjectEncoderContext) obj2);
                return;
        }
    }
}
