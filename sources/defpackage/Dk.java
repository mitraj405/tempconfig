package defpackage;

import com.google.android.material.color.utilities.DynamicScheme;
import com.google.android.material.color.utilities.Hct;
import com.google.android.material.color.utilities.MaterialDynamicColors;
import java.util.function.Function;

/* renamed from: Dk  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Dk implements Function {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f3497a;

    public /* synthetic */ Dk(Object obj, int i) {
        this.a = i;
        this.f3497a = obj;
    }

    public final Object apply(Object obj) {
        int i = this.a;
        Object obj2 = this.f3497a;
        switch (i) {
            case 0:
                return ((MaterialDynamicColors) obj2).lambda$primaryContainer$60((DynamicScheme) obj);
            case 1:
                return ((MaterialDynamicColors) obj2).highestSurface((DynamicScheme) obj);
            case 2:
                return ((MaterialDynamicColors) obj2).highestSurface((DynamicScheme) obj);
            case 3:
                return ((MaterialDynamicColors) obj2).highestSurface((DynamicScheme) obj);
            case 4:
                return ((MaterialDynamicColors) obj2).highestSurface((DynamicScheme) obj);
            case 5:
                return ((MaterialDynamicColors) obj2).lambda$onPrimary$57((DynamicScheme) obj);
            case 6:
                return ((MaterialDynamicColors) obj2).lambda$onPrimaryFixed$112((DynamicScheme) obj);
            case 7:
                return ((MaterialDynamicColors) obj2).lambda$onSecondary$72((DynamicScheme) obj);
            case 8:
                return ((MaterialDynamicColors) obj2).lambda$onTertiaryFixed$140((DynamicScheme) obj);
            case 9:
                return ((MaterialDynamicColors) obj2).lambda$onTertiaryContainer$89((DynamicScheme) obj);
            case 10:
                return ((MaterialDynamicColors) obj2).highestSurface((DynamicScheme) obj);
            case 11:
                return ((MaterialDynamicColors) obj2).highestSurface((DynamicScheme) obj);
            case 12:
                return ((MaterialDynamicColors) obj2).lambda$onSecondaryContainer$78((DynamicScheme) obj);
            default:
                return Double.valueOf(((Hct) obj2).getTone());
        }
    }
}
