package defpackage;

import android.content.Context;
import android.view.View;
import java.lang.reflect.Field;

/* renamed from: vC  reason: default package and case insensitive filesystem */
/* compiled from: ViewHolder */
public abstract class C1439vC {
    private View mView;

    public C1439vC(View view) {
        this.mView = view;
        for (Field field : getClass().getDeclaredFields()) {
            Class cls = C1456wC.class;
            if (field.isAnnotationPresent(cls)) {
                field.setAccessible(true);
                try {
                    field.set(this, field.getType().cast(view.findViewById(((C1456wC) field.getAnnotation(cls)).value())));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Context getContext() {
        return this.mView.getContext();
    }

    public View getView() {
        return this.mView;
    }
}
