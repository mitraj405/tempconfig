package defpackage;

/* renamed from: Ms  reason: default package and case insensitive filesystem */
/* compiled from: ReflectionFactory */
public final class C0599Ms {
    public static String a(C0801be beVar) {
        String obj = beVar.getClass().getGenericInterfaces()[0].toString();
        if (obj.startsWith("kotlin.jvm.functions.")) {
            return obj.substring(21);
        }
        return obj;
    }
}
