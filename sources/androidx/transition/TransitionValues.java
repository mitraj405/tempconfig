package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;

public final class TransitionValues {
    @SuppressLint({"UnknownNullness"})
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<Transition> f2516a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public final HashMap f2517a = new HashMap();

    @Deprecated
    public TransitionValues() {
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof TransitionValues)) {
            return false;
        }
        TransitionValues transitionValues = (TransitionValues) obj;
        if (this.a != transitionValues.a || !this.f2517a.equals(transitionValues.f2517a)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f2517a.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder n = lf.n("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n", "    view = ");
        n.append(this.a);
        n.append("\n");
        String z = C1058d.z(n.toString(), "    values:");
        HashMap hashMap = this.f2517a;
        for (String str : hashMap.keySet()) {
            z = z + "    " + str + ": " + hashMap.get(str) + "\n";
        }
        return z;
    }

    public TransitionValues(View view) {
        this.a = view;
    }
}
