package io.github.inflationx.calligraphy3;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import defpackage.C1156hg;

public class CalligraphyInterceptor implements C1156hg {
    private final Calligraphy calligraphy;

    public CalligraphyInterceptor(CalligraphyConfig calligraphyConfig) {
        this.calligraphy = new Calligraphy(calligraphyConfig);
    }

    public Ff intercept(C1156hg.a aVar) {
        Ff a = aVar.a(aVar.b());
        Calligraphy calligraphy2 = this.calligraphy;
        View view = a.f3584a;
        Context context = a.a;
        AttributeSet attributeSet = a.f3583a;
        View onViewCreated = calligraphy2.onViewCreated(view, context, attributeSet);
        String str = a.f3585a;
        if (str != null) {
            if (onViewCreated == null) {
                onViewCreated = null;
            } else if (!C1177ig.a(str, onViewCreated.getClass().getName())) {
                StringBuilder K = xx.K("name (", str, ") must be the view's fully qualified name (");
                K.append(onViewCreated.getClass().getName());
                K.append(')');
                throw new IllegalStateException(K.toString().toString());
            }
            if (context != null) {
                return new Ff(onViewCreated, str, context, attributeSet);
            }
            throw new IllegalStateException("context == null");
        }
        throw new IllegalStateException("name == null".toString());
    }
}
