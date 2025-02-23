package defpackage;

import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers;
import com.fasterxml.jackson.databind.introspect.AnnotatedAndMetadata;
import java.util.function.Predicate;

/* renamed from: Yx  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Yx implements Predicate {
    public final boolean test(Object obj) {
        return StdKeyDeserializers.lambda$findStringBasedKeyDeserializer$0((AnnotatedAndMetadata) obj);
    }
}
