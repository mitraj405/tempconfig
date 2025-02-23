package defpackage;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.a;

/* renamed from: Uf  reason: default package */
/* compiled from: InitializerViewModelFactory.kt */
public final class Uf implements ViewModelProvider.Factory {
    public final C0421zC<?>[] a;

    public Uf(C0421zC<?>... zCVarArr) {
        C1177ig.f(zCVarArr, "initializers");
        this.a = zCVarArr;
    }

    public final C0404yC a(Class cls, a aVar) {
        C0404yC yCVar = null;
        for (C0421zC<?> zCVar : this.a) {
            if (C1177ig.a(zCVar.a, cls)) {
                T invoke = zCVar.f3456a.invoke(aVar);
                if (invoke instanceof C0404yC) {
                    yCVar = (C0404yC) invoke;
                } else {
                    yCVar = null;
                }
            }
        }
        if (yCVar != null) {
            return yCVar;
        }
        throw new IllegalArgumentException("No initializer set for given class ".concat(cls.getName()));
    }
}
