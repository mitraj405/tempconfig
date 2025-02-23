package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TintTypedArray;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: Iy  reason: default package */
/* compiled from: SupportMenuInflater */
public final class Iy extends MenuInflater {
    public static final Class<?>[] a;
    public static final Class<?>[] b;

    /* renamed from: a  reason: collision with other field name */
    public final Context f267a;

    /* renamed from: a  reason: collision with other field name */
    public Object f268a;

    /* renamed from: a  reason: collision with other field name */
    public final Object[] f269a;

    /* renamed from: b  reason: collision with other field name */
    public final Object[] f270b;

    /* renamed from: Iy$a */
    /* compiled from: SupportMenuInflater */
    public static class a implements MenuItem.OnMenuItemClickListener {
        public static final Class<?>[] a = {MenuItem.class};

        /* renamed from: a  reason: collision with other field name */
        public final Object f271a;

        /* renamed from: a  reason: collision with other field name */
        public final Method f272a;

        public a(Object obj, String str) {
            this.f271a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f272a = cls.getMethod(str, a);
            } catch (Exception e) {
                StringBuilder K = xx.K("Couldn't resolve menu item onClick handler ", str, " in class ");
                K.append(cls.getName());
                InflateException inflateException = new InflateException(K.toString());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            Method method = this.f272a;
            try {
                Class<?> returnType = method.getReturnType();
                Class<?> cls = Boolean.TYPE;
                Object obj = this.f271a;
                if (returnType == cls) {
                    return ((Boolean) method.invoke(obj, new Object[]{menuItem})).booleanValue();
                }
                method.invoke(obj, new Object[]{menuItem});
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: Iy$b */
    /* compiled from: SupportMenuInflater */
    public class b {
        public char a;

        /* renamed from: a  reason: collision with other field name */
        public int f273a;

        /* renamed from: a  reason: collision with other field name */
        public G f274a;

        /* renamed from: a  reason: collision with other field name */
        public ColorStateList f276a = null;

        /* renamed from: a  reason: collision with other field name */
        public PorterDuff.Mode f277a = null;

        /* renamed from: a  reason: collision with other field name */
        public final Menu f278a;

        /* renamed from: a  reason: collision with other field name */
        public CharSequence f279a;

        /* renamed from: a  reason: collision with other field name */
        public String f280a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f281a;
        public char b;

        /* renamed from: b  reason: collision with other field name */
        public int f282b;

        /* renamed from: b  reason: collision with other field name */
        public CharSequence f283b;

        /* renamed from: b  reason: collision with other field name */
        public String f284b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f285b;
        public int c;

        /* renamed from: c  reason: collision with other field name */
        public CharSequence f286c;

        /* renamed from: c  reason: collision with other field name */
        public boolean f287c;
        public int d;

        /* renamed from: d  reason: collision with other field name */
        public CharSequence f288d;

        /* renamed from: d  reason: collision with other field name */
        public boolean f289d;
        public int e;

        /* renamed from: e  reason: collision with other field name */
        public boolean f290e;
        public int f;

        /* renamed from: f  reason: collision with other field name */
        public boolean f291f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;

        public b(Menu menu) {
            this.f278a = menu;
            this.f273a = 0;
            this.f282b = 0;
            this.c = 0;
            this.d = 0;
            this.f281a = true;
            this.f285b = true;
        }

        public final void a(MenuItem menuItem) {
            boolean z;
            Object obj;
            MenuItem enabled = menuItem.setChecked(this.f289d).setVisible(this.f290e).setEnabled(this.f291f);
            boolean z2 = false;
            if (this.j >= 1) {
                z = true;
            } else {
                z = false;
            }
            enabled.setCheckable(z).setTitleCondensed(this.f283b).setIcon(this.g);
            int i2 = this.k;
            if (i2 >= 0) {
                menuItem.setShowAsAction(i2);
            }
            String str = this.f284b;
            Iy iy = Iy.this;
            if (str != null) {
                if (!iy.f267a.isRestricted()) {
                    if (iy.f268a == null) {
                        iy.f268a = Iy.a(iy.f267a);
                    }
                    menuItem.setOnMenuItemClickListener(new a(iy.f268a, this.f284b));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.j >= 2) {
                if (menuItem instanceof MenuItemImpl) {
                    ((MenuItemImpl) menuItem).h(true);
                } else if (menuItem instanceof al) {
                    al alVar = (al) menuItem;
                    try {
                        Method method = alVar.f800a;
                        Jy jy = alVar.a;
                        if (method == null) {
                            alVar.f800a = jy.getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
                        }
                        alVar.f800a.invoke(jy, new Object[]{Boolean.TRUE});
                    } catch (Exception unused) {
                    }
                }
            }
            String str2 = this.f280a;
            if (str2 != null) {
                Class<?>[] clsArr = Iy.a;
                Object[] objArr = iy.f269a;
                try {
                    Constructor<?> constructor = Class.forName(str2, false, iy.f267a.getClassLoader()).getConstructor(clsArr);
                    constructor.setAccessible(true);
                    obj = constructor.newInstance(objArr);
                } catch (Exception unused2) {
                    obj = null;
                }
                menuItem.setActionView((View) obj);
                z2 = true;
            }
            int i3 = this.l;
            if (i3 > 0 && !z2) {
                menuItem.setActionView(i3);
            }
            G g2 = this.f274a;
            if (g2 != null && (menuItem instanceof Jy)) {
                ((Jy) menuItem).c(g2);
            }
            CharSequence charSequence = this.f286c;
            boolean z3 = menuItem instanceof Jy;
            if (z3) {
                ((Jy) menuItem).d(charSequence);
            } else {
                Yk.h(menuItem, charSequence);
            }
            CharSequence charSequence2 = this.f288d;
            if (z3) {
                ((Jy) menuItem).a(charSequence2);
            } else {
                Yk.m(menuItem, charSequence2);
            }
            char c2 = this.a;
            int i4 = this.h;
            if (z3) {
                ((Jy) menuItem).setAlphabeticShortcut(c2, i4);
            } else {
                Yk.g(menuItem, c2, i4);
            }
            char c3 = this.b;
            int i5 = this.i;
            if (z3) {
                ((Jy) menuItem).setNumericShortcut(c3, i5);
            } else {
                Yk.k(menuItem, c3, i5);
            }
            PorterDuff.Mode mode = this.f277a;
            if (mode != null) {
                if (z3) {
                    ((Jy) menuItem).setIconTintMode(mode);
                } else {
                    Yk.j(menuItem, mode);
                }
            }
            ColorStateList colorStateList = this.f276a;
            if (colorStateList == null) {
                return;
            }
            if (z3) {
                ((Jy) menuItem).setIconTintList(colorStateList);
            } else {
                Yk.i(menuItem, colorStateList);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 1
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r0[r1] = r2
            a = r0
            b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Iy.<clinit>():void");
    }

    public Iy(Context context) {
        super(context);
        this.f267a = context;
        Object[] objArr = {context};
        this.f269a = objArr;
        this.f270b = objArr;
    }

    public static Object a(Context context) {
        if (!(context instanceof Activity) && (context instanceof ContextWrapper)) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return context;
    }

    public final void b(XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        int i;
        char c;
        char c2;
        boolean z;
        Object obj;
        AttributeSet attributeSet2 = attributeSet;
        b bVar = new b(menu);
        int eventType = xmlResourceParser.getEventType();
        while (true) {
            i = 2;
            if (eventType == 2) {
                String name = xmlResourceParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlResourceParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got ".concat(name));
                }
            } else {
                eventType = xmlResourceParser.next();
                if (eventType == 1) {
                    break;
                }
                XmlResourceParser xmlResourceParser2 = xmlResourceParser;
            }
        }
        String str = null;
        boolean z2 = false;
        boolean z3 = false;
        while (!z2) {
            if (eventType != 1) {
                Menu menu2 = bVar.f278a;
                if (eventType != i) {
                    if (eventType == 3) {
                        String name2 = xmlResourceParser.getName();
                        if (z3 && name2.equals(str)) {
                            XmlResourceParser xmlResourceParser3 = xmlResourceParser;
                            str = null;
                            z3 = false;
                            eventType = xmlResourceParser.next();
                            i = 2;
                        } else if (name2.equals("group")) {
                            bVar.f273a = 0;
                            bVar.f282b = 0;
                            bVar.c = 0;
                            bVar.d = 0;
                            bVar.f281a = true;
                            bVar.f285b = true;
                        } else if (name2.equals("item")) {
                            if (!bVar.f287c) {
                                G g = bVar.f274a;
                                if (g == null || !g.a()) {
                                    bVar.f287c = true;
                                    bVar.a(menu2.add(bVar.f273a, bVar.e, bVar.f, bVar.f279a));
                                } else {
                                    bVar.f287c = true;
                                    bVar.a(menu2.addSubMenu(bVar.f273a, bVar.e, bVar.f, bVar.f279a).getItem());
                                }
                            }
                        } else if (name2.equals("menu")) {
                            XmlResourceParser xmlResourceParser4 = xmlResourceParser;
                            z2 = true;
                            eventType = xmlResourceParser.next();
                            i = 2;
                        }
                    }
                } else if (!z3) {
                    String name3 = xmlResourceParser.getName();
                    boolean equals = name3.equals("group");
                    Iy iy = Iy.this;
                    if (equals) {
                        TypedArray obtainStyledAttributes = iy.f267a.obtainStyledAttributes(attributeSet2, ps.MenuGroup);
                        bVar.f273a = obtainStyledAttributes.getResourceId(ps.MenuGroup_android_id, 0);
                        bVar.f282b = obtainStyledAttributes.getInt(ps.MenuGroup_android_menuCategory, 0);
                        bVar.c = obtainStyledAttributes.getInt(ps.MenuGroup_android_orderInCategory, 0);
                        bVar.d = obtainStyledAttributes.getInt(ps.MenuGroup_android_checkableBehavior, 0);
                        bVar.f281a = obtainStyledAttributes.getBoolean(ps.MenuGroup_android_visible, true);
                        bVar.f285b = obtainStyledAttributes.getBoolean(ps.MenuGroup_android_enabled, true);
                        obtainStyledAttributes.recycle();
                    } else if (name3.equals("item")) {
                        Context context = iy.f267a;
                        TintTypedArray tintTypedArray = new TintTypedArray(context, context.obtainStyledAttributes(attributeSet2, ps.MenuItem));
                        bVar.e = tintTypedArray.i(ps.MenuItem_android_id, 0);
                        bVar.f = (tintTypedArray.h(ps.MenuItem_android_menuCategory, bVar.f282b) & -65536) | (tintTypedArray.h(ps.MenuItem_android_orderInCategory, bVar.c) & 65535);
                        bVar.f279a = tintTypedArray.k(ps.MenuItem_android_title);
                        bVar.f283b = tintTypedArray.k(ps.MenuItem_android_titleCondensed);
                        bVar.g = tintTypedArray.i(ps.MenuItem_android_icon, 0);
                        String j = tintTypedArray.j(ps.MenuItem_android_alphabeticShortcut);
                        if (j == null) {
                            c = 0;
                        } else {
                            c = j.charAt(0);
                        }
                        bVar.a = c;
                        bVar.h = tintTypedArray.h(ps.MenuItem_alphabeticModifiers, 4096);
                        String j2 = tintTypedArray.j(ps.MenuItem_android_numericShortcut);
                        if (j2 == null) {
                            c2 = 0;
                        } else {
                            c2 = j2.charAt(0);
                        }
                        bVar.b = c2;
                        bVar.i = tintTypedArray.h(ps.MenuItem_numericModifiers, 4096);
                        int i2 = ps.MenuItem_android_checkable;
                        if (tintTypedArray.l(i2)) {
                            bVar.j = tintTypedArray.a(i2, false) ? 1 : 0;
                        } else {
                            bVar.j = bVar.d;
                        }
                        bVar.f289d = tintTypedArray.a(ps.MenuItem_android_checked, false);
                        bVar.f290e = tintTypedArray.a(ps.MenuItem_android_visible, bVar.f281a);
                        bVar.f291f = tintTypedArray.a(ps.MenuItem_android_enabled, bVar.f285b);
                        bVar.k = tintTypedArray.h(ps.MenuItem_showAsAction, -1);
                        bVar.f284b = tintTypedArray.j(ps.MenuItem_android_onClick);
                        bVar.l = tintTypedArray.i(ps.MenuItem_actionLayout, 0);
                        bVar.f280a = tintTypedArray.j(ps.MenuItem_actionViewClass);
                        String j3 = tintTypedArray.j(ps.MenuItem_actionProviderClass);
                        if (j3 != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z && bVar.l == 0 && bVar.f280a == null) {
                            Class<?>[] clsArr = b;
                            Object[] objArr = iy.f270b;
                            try {
                                Constructor constructor = Class.forName(j3, false, iy.f267a.getClassLoader()).getConstructor(clsArr);
                                constructor.setAccessible(true);
                                obj = constructor.newInstance(objArr);
                            } catch (Exception unused) {
                                obj = null;
                            }
                            bVar.f274a = (G) obj;
                        } else {
                            bVar.f274a = null;
                        }
                        bVar.f286c = tintTypedArray.k(ps.MenuItem_contentDescription);
                        bVar.f288d = tintTypedArray.k(ps.MenuItem_tooltipText);
                        int i3 = ps.MenuItem_iconTintMode;
                        if (tintTypedArray.l(i3)) {
                            bVar.f277a = w9.c(tintTypedArray.h(i3, -1), bVar.f277a);
                        } else {
                            bVar.f277a = null;
                        }
                        int i4 = ps.MenuItem_iconTint;
                        if (tintTypedArray.l(i4)) {
                            bVar.f276a = tintTypedArray.b(i4);
                        } else {
                            bVar.f276a = null;
                        }
                        tintTypedArray.n();
                        bVar.f287c = false;
                    } else {
                        if (name3.equals("menu")) {
                            bVar.f287c = true;
                            SubMenu addSubMenu = menu2.addSubMenu(bVar.f273a, bVar.e, bVar.f, bVar.f279a);
                            bVar.a(addSubMenu.getItem());
                            b(xmlResourceParser, attributeSet2, addSubMenu);
                        } else {
                            XmlResourceParser xmlResourceParser5 = xmlResourceParser;
                            str = name3;
                            z3 = true;
                        }
                        eventType = xmlResourceParser.next();
                        i = 2;
                    }
                }
                XmlResourceParser xmlResourceParser6 = xmlResourceParser;
                eventType = xmlResourceParser.next();
                i = 2;
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    public final void inflate(int i, Menu menu) {
        if (!(menu instanceof Hy)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.f267a.getResources().getLayout(i);
            b(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            xmlResourceParser.close();
        } catch (XmlPullParserException e) {
            throw new InflateException("Error inflating menu XML", e);
        } catch (IOException e2) {
            throw new InflateException("Error inflating menu XML", e2);
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
