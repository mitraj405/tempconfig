package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;

/* renamed from: f7  reason: default package and case insensitive filesystem */
/* compiled from: ContextThemeWrapper */
public final class C0190f7 extends ContextWrapper {
    public static Configuration b;
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public Configuration f2923a;

    /* renamed from: a  reason: collision with other field name */
    public Resources.Theme f2924a;

    /* renamed from: a  reason: collision with other field name */
    public Resources f2925a;

    /* renamed from: a  reason: collision with other field name */
    public LayoutInflater f2926a;

    /* renamed from: f7$a */
    /* compiled from: ContextThemeWrapper */
    public static class a {
        public static Context a(C0190f7 f7Var, Configuration configuration) {
            return f7Var.createConfigurationContext(configuration);
        }
    }

    public C0190f7() {
        super((Context) null);
    }

    public final void a(Configuration configuration) {
        if (this.f2925a != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        } else if (this.f2923a == null) {
            this.f2923a = new Configuration(configuration);
        } else {
            throw new IllegalStateException("Override configuration has already been set");
        }
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void b() {
        boolean z;
        if (this.f2924a == null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.f2924a = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f2924a.setTo(theme);
            }
        }
        this.f2924a.applyStyle(this.a, true);
    }

    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    public final Resources getResources() {
        if (this.f2925a == null) {
            Configuration configuration = this.f2923a;
            if (configuration != null) {
                if (b == null) {
                    Configuration configuration2 = new Configuration();
                    configuration2.fontScale = 0.0f;
                    b = configuration2;
                }
                if (!configuration.equals(b)) {
                    this.f2925a = a.a(this, this.f2923a).getResources();
                }
            }
            this.f2925a = super.getResources();
        }
        return this.f2925a;
    }

    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f2926a == null) {
            this.f2926a = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f2926a;
    }

    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.f2924a;
        if (theme != null) {
            return theme;
        }
        if (this.a == 0) {
            this.a = C0185es.Theme_AppCompat_Light;
        }
        b();
        return this.f2924a;
    }

    public final void setTheme(int i) {
        if (this.a != i) {
            this.a = i;
            b();
        }
    }

    public C0190f7(Context context, int i) {
        super(context);
        this.a = i;
    }
}
