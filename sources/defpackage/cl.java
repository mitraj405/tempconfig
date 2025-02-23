package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.SimpleArrayMap;

/* renamed from: cl  reason: default package */
/* compiled from: MenuWrapperICS */
public class cl extends C0386x2 implements Menu {
    public final Hy a;

    public cl(Context context, Hy hy) {
        super(context);
        if (hy != null) {
            this.a = hy;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public final MenuItem add(CharSequence charSequence) {
        return e(this.a.add(charSequence));
    }

    public final int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2;
        MenuItem[] menuItemArr3 = menuItemArr;
        if (menuItemArr3 != null) {
            menuItemArr2 = new MenuItem[menuItemArr3.length];
        } else {
            menuItemArr2 = null;
        }
        int addIntentOptions = this.a.addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr3[i5] = e(menuItemArr2[i5]);
            }
        }
        return addIntentOptions;
    }

    public final SubMenu addSubMenu(CharSequence charSequence) {
        return f(this.a.addSubMenu(charSequence));
    }

    public final void clear() {
        SimpleArrayMap<Jy, MenuItem> simpleArrayMap = this.f3406a;
        if (simpleArrayMap != null) {
            simpleArrayMap.clear();
        }
        SimpleArrayMap<Ny, SubMenu> simpleArrayMap2 = this.b;
        if (simpleArrayMap2 != null) {
            simpleArrayMap2.clear();
        }
        this.a.clear();
    }

    public final void close() {
        this.a.close();
    }

    public final MenuItem findItem(int i) {
        return e(this.a.findItem(i));
    }

    public final MenuItem getItem(int i) {
        return e(this.a.getItem(i));
    }

    public final boolean hasVisibleItems() {
        return this.a.hasVisibleItems();
    }

    public final boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return this.a.isShortcutKey(i, keyEvent);
    }

    public final boolean performIdentifierAction(int i, int i2) {
        return this.a.performIdentifierAction(i, i2);
    }

    public final boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return this.a.performShortcut(i, keyEvent, i2);
    }

    public final void removeGroup(int i) {
        if (this.f3406a != null) {
            int i2 = 0;
            while (true) {
                SimpleArrayMap<Jy, MenuItem> simpleArrayMap = this.f3406a;
                if (i2 >= simpleArrayMap.f1328c) {
                    break;
                }
                if (simpleArrayMap.h(i2).getGroupId() == i) {
                    this.f3406a.i(i2);
                    i2--;
                }
                i2++;
            }
        }
        this.a.removeGroup(i);
    }

    public final void removeItem(int i) {
        if (this.f3406a != null) {
            int i2 = 0;
            while (true) {
                SimpleArrayMap<Jy, MenuItem> simpleArrayMap = this.f3406a;
                if (i2 >= simpleArrayMap.f1328c) {
                    break;
                } else if (simpleArrayMap.h(i2).getItemId() == i) {
                    this.f3406a.i(i2);
                    break;
                } else {
                    i2++;
                }
            }
        }
        this.a.removeItem(i);
    }

    public final void setGroupCheckable(int i, boolean z, boolean z2) {
        this.a.setGroupCheckable(i, z, z2);
    }

    public final void setGroupEnabled(int i, boolean z) {
        this.a.setGroupEnabled(i, z);
    }

    public final void setGroupVisible(int i, boolean z) {
        this.a.setGroupVisible(i, z);
    }

    public final void setQwertyMode(boolean z) {
        this.a.setQwertyMode(z);
    }

    public final int size() {
        return this.a.size();
    }

    public final MenuItem add(int i) {
        return e(this.a.add(i));
    }

    public final SubMenu addSubMenu(int i) {
        return f(this.a.addSubMenu(i));
    }

    public final MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return e(this.a.add(i, i2, i3, charSequence));
    }

    public final SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return f(this.a.addSubMenu(i, i2, i3, charSequence));
    }

    public final MenuItem add(int i, int i2, int i3, int i4) {
        return e(this.a.add(i, i2, i3, i4));
    }

    public final SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return f(this.a.addSubMenu(i, i2, i3, i4));
    }
}
