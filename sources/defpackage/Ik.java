package defpackage;

import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import java.util.function.Function;

/* renamed from: Ik  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Ik implements Function {
    public final /* synthetic */ int a;

    public /* synthetic */ Ik(int i) {
        this.a = i;
    }

    public final Object apply(Object obj) {
        switch (this.a) {
            case 0:
                return MaterialDynamicColors.lambda$onBackground$13((DynamicScheme) obj);
            default:
                return ((DynamicScheme) obj).neutralVariantPalette;
        }
    }
}
