package defpackage;

import kotlin.jvm.functions.Function1;

/* renamed from: oy  reason: default package and case insensitive filesystem */
/* compiled from: Strings.kt */
public final class C1312oy extends C0595Mh implements Function1<C1112fg, String> {
    public final /* synthetic */ CharSequence a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1312oy(String str) {
        super(1);
        this.a = str;
    }

    public final Object invoke(Object obj) {
        C1112fg fgVar = (C1112fg) obj;
        C1177ig.f(fgVar, "it");
        CharSequence charSequence = this.a;
        C1177ig.f(charSequence, "<this>");
        return charSequence.subSequence(Integer.valueOf(fgVar.c).intValue(), Integer.valueOf(fgVar.d).intValue() + 1).toString();
    }
}
