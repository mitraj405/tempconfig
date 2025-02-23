package defpackage;

import android.annotation.SuppressLint;
import android.text.Editable;

/* renamed from: ka  reason: default package and case insensitive filesystem */
/* compiled from: EmojiEditableFactory */
public final class C0247ka extends Editable.Factory {
    public static Class<?> a;

    /* renamed from: a  reason: collision with other field name */
    public static final Object f3051a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public static volatile C0247ka f3052a;

    @SuppressLint({"PrivateApi"})
    public C0247ka() {
        try {
            a = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, C0247ka.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public final Editable newEditable(CharSequence charSequence) {
        Class<?> cls = a;
        if (cls != null) {
            return new Cx(cls, charSequence);
        }
        return super.newEditable(charSequence);
    }
}
