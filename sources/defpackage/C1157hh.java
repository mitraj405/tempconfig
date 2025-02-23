package defpackage;

/* renamed from: hh  reason: default package and case insensitive filesystem */
/* compiled from: JwtClaims */
public final class C1157hh {
    public static C1201jn a(float f) {
        C1201jn jnVar = new C1201jn(System.currentTimeMillis() / 1000);
        long j = (long) (f * 60.0f);
        long j2 = jnVar.a;
        long j3 = j2 + j;
        if (0 <= ((j2 ^ j3) & (j ^ j3))) {
            jnVar.a = j3;
            return jnVar;
        }
        throw new ArithmeticException("long overflow adding: " + j2 + " + " + j + " = " + j3);
    }
}
