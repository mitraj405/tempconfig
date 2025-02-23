package defpackage;

import com.google.android.material.color.utilities.DynamicColor;
import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import com.google.android.material.color.utilities.TonalPalette;
import java.util.function.Function;

/* renamed from: Ck  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Ck implements Function {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f3496a;

    public /* synthetic */ Ck(Object obj, int i) {
        this.a = i;
        this.f3496a = obj;
    }

    public final Object apply(Object obj) {
        int i = this.a;
        Object obj2 = this.f3496a;
        switch (i) {
            case 0:
                return ((MaterialDynamicColors) obj2).highestSurface((DynamicScheme) obj);
            case 1:
                return ((MaterialDynamicColors) obj2).lambda$error$93((DynamicScheme) obj);
            case 2:
                return ((MaterialDynamicColors) obj2).highestSurface((DynamicScheme) obj);
            case 3:
                return ((MaterialDynamicColors) obj2).lambda$onPrimaryFixed$111((DynamicScheme) obj);
            case 4:
                return ((MaterialDynamicColors) obj2).highestSurface((DynamicScheme) obj);
            case 5:
                return ((MaterialDynamicColors) obj2).lambda$onTertiaryFixed$139((DynamicScheme) obj);
            case 6:
                return ((MaterialDynamicColors) obj2).lambda$onTertiary$84((DynamicScheme) obj);
            case 7:
                return ((MaterialDynamicColors) obj2).lambda$onSecondaryFixedVariant$130((DynamicScheme) obj);
            case 8:
                return ((MaterialDynamicColors) obj2).lambda$errorContainer$99((DynamicScheme) obj);
            case 9:
                return ((MaterialDynamicColors) obj2).lambda$onTertiaryFixedVariant$144((DynamicScheme) obj);
            case 10:
                return ((MaterialDynamicColors) obj2).lambda$onSecondaryContainer$77((DynamicScheme) obj);
            default:
                return DynamicColor.lambda$fromArgb$0((TonalPalette) obj2, (DynamicScheme) obj);
        }
    }
}
