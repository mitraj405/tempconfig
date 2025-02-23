package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import defpackage.Dt;

/* renamed from: o1  reason: default package */
/* compiled from: AppCompatDrawableManager */
public final class o1 {
    public static final PorterDuff.Mode a = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with other field name */
    public static o1 f3134a;

    /* renamed from: a  reason: collision with other field name */
    public Dt f3135a;

    /* renamed from: o1$a */
    /* compiled from: AppCompatDrawableManager */
    public class a implements Dt.b {
        public final int[] a = {zr.abc_textfield_search_default_mtrl_alpha, zr.abc_textfield_default_mtrl_alpha, zr.abc_ab_share_pack_mtrl_alpha};
        public final int[] b = {zr.abc_ic_commit_search_api_mtrl_alpha, zr.abc_seekbar_tick_mark_material, zr.abc_ic_menu_share_mtrl_alpha, zr.abc_ic_menu_copy_mtrl_am_alpha, zr.abc_ic_menu_cut_mtrl_alpha, zr.abc_ic_menu_selectall_mtrl_alpha, zr.abc_ic_menu_paste_mtrl_am_alpha};
        public final int[] c = {zr.abc_textfield_activated_mtrl_alpha, zr.abc_textfield_search_activated_mtrl_alpha, zr.abc_cab_background_top_mtrl_alpha, zr.abc_text_cursor_material, zr.abc_text_select_handle_left_mtrl, zr.abc_text_select_handle_middle_mtrl, zr.abc_text_select_handle_right_mtrl};
        public final int[] d = {zr.abc_popup_background_mtrl_mult, zr.abc_cab_background_internal_bg, zr.abc_menu_hardkey_panel_mtrl_mult};
        public final int[] e = {zr.abc_tab_indicator_material, zr.abc_textfield_search_material};
        public final int[] f = {zr.abc_btn_check_material, zr.abc_btn_radio_material, zr.abc_btn_check_material_anim, zr.abc_btn_radio_material_anim};

        public static boolean a(int i, int[] iArr) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        public static ColorStateList b(Context context, int i) {
            int c2 = Oz.c(context, C0220hr.colorControlHighlight);
            int b2 = Oz.b(context, C0220hr.colorButtonNormal);
            return new ColorStateList(new int[][]{Oz.f473a, Oz.c, Oz.b, Oz.e}, new int[]{b2, A5.c(c2, i), A5.c(c2, i), i});
        }

        public static LayerDrawable c(Dt dt, Context context, int i) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
            Drawable e2 = dt.e(context, zr.abc_star_black_48dp);
            Drawable e3 = dt.e(context, zr.abc_star_half_black_48dp);
            if ((e2 instanceof BitmapDrawable) && e2.getIntrinsicWidth() == dimensionPixelSize && e2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable2 = (BitmapDrawable) e2;
                bitmapDrawable = new BitmapDrawable(bitmapDrawable2.getBitmap());
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                e2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                e2.draw(canvas);
                bitmapDrawable2 = new BitmapDrawable(createBitmap);
                bitmapDrawable = new BitmapDrawable(createBitmap);
            }
            bitmapDrawable.setTileModeX(Shader.TileMode.REPEAT);
            if ((e3 instanceof BitmapDrawable) && e3.getIntrinsicWidth() == dimensionPixelSize && e3.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) e3;
            } else {
                Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap2);
                e3.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                e3.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(createBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable2, bitmapDrawable3, bitmapDrawable});
            layerDrawable.setId(0, 16908288);
            layerDrawable.setId(1, 16908303);
            layerDrawable.setId(2, 16908301);
            return layerDrawable;
        }

        public static void e(Drawable drawable, int i, PorterDuff.Mode mode) {
            int[] iArr = w9.f3389a;
            Drawable mutate = drawable.mutate();
            if (mode == null) {
                mode = o1.a;
            }
            mutate.setColorFilter(o1.c(i, mode));
        }

        public final ColorStateList d(Context context, int i) {
            if (i == zr.abc_edit_text_material) {
                return d7.c(context, C0299pr.abc_tint_edittext);
            }
            if (i == zr.abc_switch_track_mtrl_alpha) {
                return d7.c(context, C0299pr.abc_tint_switch_track);
            }
            if (i == zr.abc_switch_thumb_material) {
                int[][] iArr = new int[3][];
                int[] iArr2 = new int[3];
                int i2 = C0220hr.colorSwitchThumbNormal;
                ColorStateList d2 = Oz.d(context, i2);
                if (d2 == null || !d2.isStateful()) {
                    iArr[0] = Oz.f473a;
                    iArr2[0] = Oz.b(context, i2);
                    iArr[1] = Oz.d;
                    iArr2[1] = Oz.c(context, C0220hr.colorControlActivated);
                    iArr[2] = Oz.e;
                    iArr2[2] = Oz.c(context, i2);
                } else {
                    int[] iArr3 = Oz.f473a;
                    iArr[0] = iArr3;
                    iArr2[0] = d2.getColorForState(iArr3, 0);
                    iArr[1] = Oz.d;
                    iArr2[1] = Oz.c(context, C0220hr.colorControlActivated);
                    iArr[2] = Oz.e;
                    iArr2[2] = d2.getDefaultColor();
                }
                return new ColorStateList(iArr, iArr2);
            } else if (i == zr.abc_btn_default_mtrl_shape) {
                return b(context, Oz.c(context, C0220hr.colorButtonNormal));
            } else {
                if (i == zr.abc_btn_borderless_material) {
                    return b(context, 0);
                }
                if (i == zr.abc_btn_colored_material) {
                    return b(context, Oz.c(context, C0220hr.colorAccent));
                }
                if (i == zr.abc_spinner_mtrl_am_alpha || i == zr.abc_spinner_textfield_background_material) {
                    return d7.c(context, C0299pr.abc_tint_spinner);
                }
                if (a(i, this.b)) {
                    return Oz.d(context, C0220hr.colorControlNormal);
                }
                if (a(i, this.e)) {
                    return d7.c(context, C0299pr.abc_tint_default);
                }
                if (a(i, this.f)) {
                    return d7.c(context, C0299pr.abc_tint_btn_checkable);
                }
                if (i == zr.abc_seekbar_thumb_material) {
                    return d7.c(context, C0299pr.abc_tint_seek_thumb);
                }
                return null;
            }
        }
    }

    public static synchronized o1 a() {
        o1 o1Var;
        synchronized (o1.class) {
            if (f3134a == null) {
                d();
            }
            o1Var = f3134a;
        }
        return o1Var;
    }

    public static synchronized PorterDuffColorFilter c(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter g;
        synchronized (o1.class) {
            g = Dt.g(i, mode);
        }
        return g;
    }

    public static synchronized void d() {
        synchronized (o1.class) {
            if (f3134a == null) {
                o1 o1Var = new o1();
                f3134a = o1Var;
                o1Var.f3135a = Dt.c();
                Dt dt = f3134a.f3135a;
                a aVar = new a();
                synchronized (dt) {
                    dt.f126a = aVar;
                }
            }
        }
    }

    public static void e(Drawable drawable, Zz zz, int[] iArr) {
        boolean z;
        ColorStateList colorStateList;
        PorterDuff.Mode mode;
        PorterDuff.Mode mode2 = Dt.f125a;
        int[] state = drawable.getState();
        int[] iArr2 = w9.f3389a;
        if (drawable.mutate() == drawable) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
                drawable.setState(new int[0]);
                drawable.setState(state);
            }
            boolean z2 = zz.b;
            if (z2 || zz.f787a) {
                PorterDuffColorFilter porterDuffColorFilter = null;
                if (z2) {
                    colorStateList = zz.a;
                } else {
                    colorStateList = null;
                }
                if (zz.f787a) {
                    mode = zz.f786a;
                } else {
                    mode = Dt.f125a;
                }
                if (!(colorStateList == null || mode == null)) {
                    porterDuffColorFilter = Dt.g(colorStateList.getColorForState(iArr, 0), mode);
                }
                drawable.setColorFilter(porterDuffColorFilter);
                return;
            }
            drawable.clearColorFilter();
        }
    }

    public final synchronized Drawable b(Context context, int i) {
        return this.f3135a.e(context, i);
    }
}
