package defpackage;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

/* renamed from: f1  reason: default package and case insensitive filesystem */
/* compiled from: AppCompatActivity */
public final class C0188f1 implements On {
    public final /* synthetic */ AppCompatActivity a;

    public C0188f1(AppCompatActivity appCompatActivity) {
        this.a = appCompatActivity;
    }

    public final void a(Context context) {
        AppCompatActivity appCompatActivity = this.a;
        AppCompatDelegate j = appCompatActivity.j();
        j.h();
        appCompatActivity.getSavedStateRegistry().a("androidx:appcompat");
        j.l();
    }
}
