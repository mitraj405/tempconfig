package defpackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.search.SearchView;

/* renamed from: Iv  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Iv implements OnApplyWindowInsetsListener {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ViewGroup.MarginLayoutParams f3503a;
    public final /* synthetic */ int b;

    public /* synthetic */ Iv(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2) {
        this.f3503a = marginLayoutParams;
        this.a = i;
        this.b = i2;
    }

    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return SearchView.lambda$setUpDividerInsetListener$6(this.f3503a, this.a, this.b, view, windowInsetsCompat);
    }
}
