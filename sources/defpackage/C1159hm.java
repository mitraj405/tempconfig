package defpackage;

import defpackage.C1180im;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* renamed from: hm  reason: default package and case insensitive filesystem */
/* compiled from: Mutex.kt */
public final class C1159hm extends C0595Mh implements Function1<Throwable, Unit> {
    public final /* synthetic */ C1180im.a a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1180im f5479a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1159hm(C1180im imVar, C1180im.a aVar) {
        super(1);
        this.f5479a = imVar;
        this.a = aVar;
    }

    public final Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C1180im.c;
        C1180im.a aVar = this.a;
        Object obj2 = aVar.f5489a;
        C1180im imVar = this.f5479a;
        atomicReferenceFieldUpdater.set(imVar, obj2);
        imVar.b(aVar.f5489a);
        return Unit.a;
    }
}
