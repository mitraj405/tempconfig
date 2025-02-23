package defpackage;

/* renamed from: zp  reason: default package and case insensitive filesystem */
/* compiled from: PlatformDependent */
public final class C1518zp {
    public static final int a;

    /* renamed from: a  reason: collision with other field name */
    public static final boolean f7108a;

    static {
        int i;
        boolean z = false;
        try {
            i = ((Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get((Object) null)).intValue();
        } catch (Exception unused) {
            i = 0;
        }
        a = i;
        if (i != 0) {
            z = true;
        }
        f7108a = z;
    }
}
