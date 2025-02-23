package retrofit2;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: KotlinExtensions.kt */
public final class KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2 extends C0595Mh implements Function1<Throwable, Unit> {
    final /* synthetic */ Call $this_await$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2(Call call) {
        super(1);
        this.$this_await$inlined = call;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.a;
    }

    public final void invoke(Throwable th) {
        this.$this_await$inlined.cancel();
    }
}
