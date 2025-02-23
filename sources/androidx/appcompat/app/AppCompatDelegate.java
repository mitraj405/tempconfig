package androidx.appcompat.app;

import android.app.LocaleManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.LocaleList;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppLocalesMetadataHolderService;
import androidx.appcompat.app.g;
import androidx.collection.ArraySet;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public abstract class AppCompatDelegate {
    public static final g.a a = new g.a(new g.b());

    /* renamed from: a  reason: collision with other field name */
    public static final ArraySet<WeakReference<AppCompatDelegate>> f893a = new ArraySet<>();

    /* renamed from: a  reason: collision with other field name */
    public static Boolean f894a = null;

    /* renamed from: a  reason: collision with other field name */
    public static final Object f895a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public static ki f896a = null;

    /* renamed from: a  reason: collision with other field name */
    public static boolean f897a = false;
    public static final Object b = new Object();

    /* renamed from: b  reason: collision with other field name */
    public static ki f898b = null;
    public static final int c = -100;

    public static class a {
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }
    }

    public static class b {
        public static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        public static void b(Object obj, LocaleList localeList) {
            ((LocaleManager) obj).setApplicationLocales(localeList);
        }
    }

    public static boolean j(Context context) {
        if (f894a == null) {
            try {
                int i = AppLocalesMetadataHolderService.c;
                Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(context, AppLocalesMetadataHolderService.class), AppLocalesMetadataHolderService.a.a() | 128).metaData;
                if (bundle != null) {
                    f894a = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                f894a = Boolean.FALSE;
            }
        }
        return f894a.booleanValue();
    }

    public static void q(AppCompatDelegate appCompatDelegate) {
        synchronized (f895a) {
            Iterator<WeakReference<AppCompatDelegate>> it = f893a.iterator();
            while (it.hasNext()) {
                AppCompatDelegate appCompatDelegate2 = (AppCompatDelegate) it.next().get();
                if (appCompatDelegate2 == appCompatDelegate || appCompatDelegate2 == null) {
                    it.remove();
                }
            }
        }
    }

    public abstract void a(View view, ViewGroup.LayoutParams layoutParams);

    public abstract <T extends View> T c(int i);

    public Context d() {
        return null;
    }

    public int e() {
        return -100;
    }

    public abstract MenuInflater f();

    public abstract h g();

    public abstract void h();

    public abstract void i();

    public abstract void k();

    public abstract void l();

    public abstract void m();

    public abstract void n();

    public abstract void o();

    public abstract void p();

    public abstract boolean r(int i);

    public abstract void s(int i);

    public abstract void t(View view);

    public abstract void u(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void w(CharSequence charSequence);

    public Context b(Context context) {
        return context;
    }

    public void v(int i) {
    }
}
