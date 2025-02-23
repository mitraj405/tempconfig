package defpackage;

import com.google.common.base.Function;
import com.google.common.escape.Escaper;

/* renamed from: Ya  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0108Ya implements Function {
    public final /* synthetic */ Escaper a;

    public /* synthetic */ C0108Ya(Escaper escaper) {
        this.a = escaper;
    }

    public final Object apply(Object obj) {
        return this.a.escape((String) obj);
    }
}
