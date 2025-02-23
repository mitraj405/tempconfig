package defpackage;

import com.google.common.base.Predicate;
import com.google.common.reflect.ClassPath;

/* renamed from: o5  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class o5 implements Predicate {
    public final boolean apply(Object obj) {
        return ((ClassPath.ClassInfo) obj).isTopLevel();
    }
}
