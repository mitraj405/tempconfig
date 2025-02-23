package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* compiled from: SupportActionModeWrapper */
public final class b extends ActionMode {
    public final Context a;

    /* renamed from: a  reason: collision with other field name */
    public final ActionMode f991a;

    /* compiled from: SupportActionModeWrapper */
    public static class a implements ActionMode.Callback {
        public final Context a;

        /* renamed from: a  reason: collision with other field name */
        public final ActionMode.Callback f992a;

        /* renamed from: a  reason: collision with other field name */
        public final SimpleArrayMap<Menu, Menu> f993a = new SimpleArrayMap<>();

        /* renamed from: a  reason: collision with other field name */
        public final ArrayList<b> f994a = new ArrayList<>();

        public a(Context context, ActionMode.Callback callback) {
            this.a = context;
            this.f992a = callback;
        }

        public final void a(ActionMode actionMode) {
            this.f992a.onDestroyActionMode(e(actionMode));
        }

        public final boolean b(ActionMode actionMode, MenuItem menuItem) {
            return this.f992a.onActionItemClicked(e(actionMode), new al(this.a, (Jy) menuItem));
        }

        public final boolean c(ActionMode actionMode, MenuBuilder menuBuilder) {
            b e = e(actionMode);
            SimpleArrayMap<Menu, Menu> simpleArrayMap = this.f993a;
            Menu orDefault = simpleArrayMap.getOrDefault(menuBuilder, null);
            if (orDefault == null) {
                orDefault = new cl(this.a, menuBuilder);
                simpleArrayMap.put(menuBuilder, orDefault);
            }
            return this.f992a.onPrepareActionMode(e, orDefault);
        }

        public final boolean d(ActionMode actionMode, MenuBuilder menuBuilder) {
            b e = e(actionMode);
            SimpleArrayMap<Menu, Menu> simpleArrayMap = this.f993a;
            Menu orDefault = simpleArrayMap.getOrDefault(menuBuilder, null);
            if (orDefault == null) {
                orDefault = new cl(this.a, menuBuilder);
                simpleArrayMap.put(menuBuilder, orDefault);
            }
            return this.f992a.onCreateActionMode(e, orDefault);
        }

        public final b e(ActionMode actionMode) {
            ArrayList<b> arrayList = this.f994a;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                b bVar = arrayList.get(i);
                if (bVar != null && bVar.f991a == actionMode) {
                    return bVar;
                }
            }
            b bVar2 = new b(this.a, actionMode);
            arrayList.add(bVar2);
            return bVar2;
        }
    }

    public b(Context context, ActionMode actionMode) {
        this.a = context;
        this.f991a = actionMode;
    }

    public final void finish() {
        this.f991a.a();
    }

    public final View getCustomView() {
        return this.f991a.b();
    }

    public final Menu getMenu() {
        return new cl(this.a, this.f991a.c());
    }

    public final MenuInflater getMenuInflater() {
        return this.f991a.d();
    }

    public final CharSequence getSubtitle() {
        return this.f991a.e();
    }

    public final Object getTag() {
        return this.f991a.a;
    }

    public final CharSequence getTitle() {
        return this.f991a.f();
    }

    public final boolean getTitleOptionalHint() {
        return this.f991a.f986a;
    }

    public final void invalidate() {
        this.f991a.g();
    }

    public final boolean isTitleOptional() {
        return this.f991a.h();
    }

    public final void setCustomView(View view) {
        this.f991a.i(view);
    }

    public final void setSubtitle(CharSequence charSequence) {
        this.f991a.k(charSequence);
    }

    public final void setTag(Object obj) {
        this.f991a.a = obj;
    }

    public final void setTitle(CharSequence charSequence) {
        this.f991a.m(charSequence);
    }

    public final void setTitleOptionalHint(boolean z) {
        this.f991a.n(z);
    }

    public final void setSubtitle(int i) {
        this.f991a.j(i);
    }

    public final void setTitle(int i) {
        this.f991a.l(i);
    }
}
