package defpackage;

import android.content.Context;
import android.content.SharedPreferences;

/* renamed from: gq  reason: default package and case insensitive filesystem */
/* compiled from: PreferenceUtil */
public final class C1139gq {
    public static C1139gq a;

    /* renamed from: a  reason: collision with other field name */
    public final SharedPreferences f5471a;

    public C1139gq(Context context) {
        this.f5471a = context.getSharedPreferences("DATAB", 0);
    }

    public static C1139gq c(Context context) {
        if (a == null) {
            a = new C1139gq(context);
        }
        return a;
    }

    public final boolean a(String str) {
        return this.f5471a.getBoolean(str, false);
    }

    public final String b() {
        return this.f5471a.getString("pid", "");
    }

    public final int d(String str) {
        return this.f5471a.getInt(str, 0);
    }

    public final String e(String str) {
        return this.f5471a.getString(str, "");
    }

    public final void f(String str, boolean z) {
        SharedPreferences.Editor edit = this.f5471a.edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public final void g(int i, String str) {
        SharedPreferences.Editor edit = this.f5471a.edit();
        edit.putInt(str, i);
        edit.commit();
    }

    public final void h(String str, String str2) {
        SharedPreferences.Editor edit = this.f5471a.edit();
        edit.putString(str, str2);
        edit.apply();
    }
}
