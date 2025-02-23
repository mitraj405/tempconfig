package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.collection.ArrayMap;
import defpackage.Et;
import defpackage.ZB;
import defpackage.v9;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class AnimatedVectorDrawableCompat extends YB implements Animatable {
    public U0 a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f2544a;

    /* renamed from: a  reason: collision with other field name */
    public final a f2545a;

    /* renamed from: a  reason: collision with other field name */
    public final b f2546a;

    /* renamed from: a  reason: collision with other field name */
    public ArrayList<Animatable2Compat$AnimationCallback> f2547a;

    public class a implements Drawable.Callback {
        public a() {
        }

        public final void invalidateDrawable(Drawable drawable) {
            AnimatedVectorDrawableCompat.this.invalidateSelf();
        }

        public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            AnimatedVectorDrawableCompat.this.scheduleSelf(runnable, j);
        }

        public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            AnimatedVectorDrawableCompat.this.unscheduleSelf(runnable);
        }
    }

    public static class b extends Drawable.ConstantState {
        public ZB a;

        /* renamed from: a  reason: collision with other field name */
        public AnimatorSet f2548a;

        /* renamed from: a  reason: collision with other field name */
        public ArrayMap<Animator, String> f2549a;

        /* renamed from: a  reason: collision with other field name */
        public ArrayList<Animator> f2550a;

        public b(a aVar) {
        }

        public final int getChangingConfigurations() {
            return 0;
        }

        public final Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public final Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    public AnimatedVectorDrawableCompat() {
        this((Context) null);
    }

    public final void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.a;
        if (drawable != null) {
            v9.a.a(drawable, theme);
        }
    }

    public final boolean canApplyTheme() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return v9.a.b(drawable);
        }
        return false;
    }

    public final void draw(Canvas canvas) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        b bVar = this.f2546a;
        bVar.a.draw(canvas);
        if (bVar.f2548a.isStarted()) {
            invalidateSelf();
        }
    }

    public final int getAlpha() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getAlpha();
        }
        return this.f2546a.a.getAlpha();
    }

    public final int getChangingConfigurations() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        int changingConfigurations = super.getChangingConfigurations();
        this.f2546a.getClass();
        return changingConfigurations | 0;
    }

    public final ColorFilter getColorFilter() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return v9.a.c(drawable);
        }
        return this.f2546a.a.getColorFilter();
    }

    public final Drawable.ConstantState getConstantState() {
        if (this.a != null) {
            return new c(this.a.getConstantState());
        }
        return null;
    }

    public final int getIntrinsicHeight() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.f2546a.a.getIntrinsicHeight();
    }

    public final int getIntrinsicWidth() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.f2546a.a.getIntrinsicWidth();
    }

    public final int getOpacity() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return this.f2546a.a.getOpacity();
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        b bVar;
        Drawable drawable = this.a;
        if (drawable != null) {
            v9.a.d(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            bVar = this.f2546a;
            if (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if ("animated-vector".equals(name)) {
                        TypedArray f = SA.f(resources, theme, attributeSet, D0.e);
                        int resourceId = f.getResourceId(0, 0);
                        if (resourceId != 0) {
                            ZB zb = new ZB();
                            ThreadLocal<TypedValue> threadLocal = Et.f161a;
                            zb.a = Et.a.a(resources, resourceId, theme);
                            new ZB.h(zb.a.getConstantState());
                            zb.b = false;
                            zb.setCallback(this.f2545a);
                            ZB zb2 = bVar.a;
                            if (zb2 != null) {
                                zb2.setCallback((Drawable.Callback) null);
                            }
                            bVar.a = zb;
                        }
                        f.recycle();
                    } else if ("target".equals(name)) {
                        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, D0.f);
                        String string = obtainAttributes.getString(0);
                        int resourceId2 = obtainAttributes.getResourceId(1, 0);
                        if (resourceId2 != 0) {
                            Context context = this.f2544a;
                            if (context != null) {
                                Animator loadAnimator = AnimatorInflater.loadAnimator(context, resourceId2);
                                loadAnimator.setTarget(bVar.a.f722a.f752a.f746a.getOrDefault(string, null));
                                if (bVar.f2550a == null) {
                                    bVar.f2550a = new ArrayList<>();
                                    bVar.f2549a = new ArrayMap<>();
                                }
                                bVar.f2550a.add(loadAnimator);
                                bVar.f2549a.put(loadAnimator, string);
                            } else {
                                obtainAttributes.recycle();
                                throw new IllegalStateException("Context can't be null when inflating animators");
                            }
                        }
                        obtainAttributes.recycle();
                    } else {
                        continue;
                    }
                }
                eventType = xmlPullParser.next();
            }
        }
        if (bVar.f2548a == null) {
            bVar.f2548a = new AnimatorSet();
        }
        bVar.f2548a.playTogether(bVar.f2550a);
    }

    public final boolean isAutoMirrored() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.isAutoMirrored();
        }
        return this.f2546a.a.isAutoMirrored();
    }

    public final boolean isRunning() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.f2546a.f2548a.isRunning();
    }

    public final boolean isStateful() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.f2546a.a.isStateful();
    }

    public final Drawable mutate() {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f2546a.a.setBounds(rect);
        }
    }

    public final boolean onLevelChange(int i) {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        return this.f2546a.a.setLevel(i);
    }

    public final boolean onStateChange(int[] iArr) {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.f2546a.a.setState(iArr);
    }

    public final void setAlpha(int i) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.f2546a.a.setAlpha(i);
        }
    }

    public final void setAutoMirrored(boolean z) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
        } else {
            this.f2546a.a.setAutoMirrored(z);
        }
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f2546a.a.setColorFilter(colorFilter);
        }
    }

    public final void setTint(int i) {
        Drawable drawable = this.a;
        if (drawable != null) {
            v9.a(drawable, i);
        } else {
            this.f2546a.a.setTint(i);
        }
    }

    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.a;
        if (drawable != null) {
            v9.b(drawable, colorStateList);
        } else {
            this.f2546a.a.setTintList(colorStateList);
        }
    }

    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.a;
        if (drawable != null) {
            v9.c(drawable, mode);
        } else {
            this.f2546a.a.setTintMode(mode);
        }
    }

    public final boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.f2546a.a.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public final void start() {
        Drawable drawable = this.a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
            return;
        }
        b bVar = this.f2546a;
        if (!bVar.f2548a.isStarted()) {
            bVar.f2548a.start();
            invalidateSelf();
        }
    }

    public final void stop() {
        Drawable drawable = this.a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f2546a.f2548a.end();
        }
    }

    public AnimatedVectorDrawableCompat(Context context) {
        this.a = null;
        this.f2547a = null;
        a aVar = new a();
        this.f2545a = aVar;
        this.f2544a = context;
        this.f2546a = new b(aVar);
    }

    public static class c extends Drawable.ConstantState {
        public final Drawable.ConstantState a;

        public c(Drawable.ConstantState constantState) {
            this.a = constantState;
        }

        public final boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        public final int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }

        public final Drawable newDrawable() {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            Drawable newDrawable = this.a.newDrawable();
            animatedVectorDrawableCompat.a = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.f2545a);
            return animatedVectorDrawableCompat;
        }

        public final Drawable newDrawable(Resources resources) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            Drawable newDrawable = this.a.newDrawable(resources);
            animatedVectorDrawableCompat.a = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.f2545a);
            return animatedVectorDrawableCompat;
        }

        public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            Drawable newDrawable = this.a.newDrawable(resources, theme);
            animatedVectorDrawableCompat.a = newDrawable;
            newDrawable.setCallback(animatedVectorDrawableCompat.f2545a);
            return animatedVectorDrawableCompat;
        }
    }

    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
    }
}
