package com.airbnb.lottie;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import defpackage.UB;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class LottieAnimationView extends AppCompatImageView {
    public static final C0159cj a = new C0159cj();

    /* renamed from: a  reason: collision with other field name */
    public final Ej f2761a = new Ej();

    /* renamed from: a  reason: collision with other field name */
    public final Hj<C0181ej> f2762a = new C0148bj(this);

    /* renamed from: a  reason: collision with other field name */
    public Mj<C0181ej> f2763a;

    /* renamed from: a  reason: collision with other field name */
    public final a f2764a = new a();

    /* renamed from: a  reason: collision with other field name */
    public C0181ej f2765a;

    /* renamed from: a  reason: collision with other field name */
    public final HashSet f2766a = new HashSet();

    /* renamed from: a  reason: collision with other field name */
    public boolean f2767a = false;
    public Hj<Throwable> b;

    /* renamed from: b  reason: collision with other field name */
    public final HashSet f2768b = new HashSet();

    /* renamed from: b  reason: collision with other field name */
    public boolean f2769b = false;
    public int c = 0;

    /* renamed from: c  reason: collision with other field name */
    public String f2770c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f2771c = true;
    public int d;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public float a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f2772a;
        public int c;

        /* renamed from: c  reason: collision with other field name */
        public String f2773c;
        public int d;

        /* renamed from: d  reason: collision with other field name */
        public String f2774d;
        public int e;

        public class a implements Parcelable.Creator<SavedState> {
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final Object[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f2773c);
            parcel.writeFloat(this.a);
            parcel.writeInt(this.f2772a ? 1 : 0);
            parcel.writeString(this.f2774d);
            parcel.writeInt(this.d);
            parcel.writeInt(this.e);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f2773c = parcel.readString();
            this.a = parcel.readFloat();
            this.f2772a = parcel.readInt() != 1 ? false : true;
            this.f2774d = parcel.readString();
            this.d = parcel.readInt();
            this.e = parcel.readInt();
        }
    }

    public class a implements Hj<Throwable> {
        public a() {
        }

        public final void onResult(Object obj) {
            Throwable th = (Throwable) obj;
            LottieAnimationView lottieAnimationView = LottieAnimationView.this;
            int i = lottieAnimationView.c;
            if (i != 0) {
                lottieAnimationView.setImageResource(i);
            }
            Hj hj = lottieAnimationView.b;
            if (hj == null) {
                hj = LottieAnimationView.a;
            }
            hj.onResult(th);
        }
    }

    public enum b {
        SET_ANIMATION,
        SET_PROGRESS,
        SET_REPEAT_MODE,
        SET_REPEAT_COUNT,
        SET_IMAGE_ASSETS,
        PLAY_OPTION
    }

    public LottieAnimationView(Context context) {
        super(context);
        d((AttributeSet) null, C0207gr.lottieAnimationViewStyle);
    }

    private void setCompositionTask(Mj<C0181ej> mj) {
        Throwable th;
        this.f2766a.add(b.SET_ANIMATION);
        this.f2765a = null;
        this.f2761a.d();
        c();
        mj.a(this.f2762a);
        a aVar = this.f2764a;
        synchronized (mj) {
            Lj<T> lj = mj.f407a;
            if (!(lj == null || (th = lj.f387a) == null)) {
                aVar.onResult(th);
            }
            mj.b.add(aVar);
        }
        this.f2763a = mj;
    }

    public final void c() {
        Mj<C0181ej> mj = this.f2763a;
        if (mj != null) {
            Hj<C0181ej> hj = this.f2762a;
            synchronized (mj) {
                mj.f409a.remove(hj);
            }
            Mj<C0181ej> mj2 = this.f2763a;
            a aVar = this.f2764a;
            synchronized (mj2) {
                mj2.b.remove(aVar);
            }
        }
    }

    public final void d(AttributeSet attributeSet, int i) {
        String string;
        boolean z = false;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, os.LottieAnimationView, i, 0);
        this.f2771c = obtainStyledAttributes.getBoolean(os.LottieAnimationView_lottie_cacheComposition, true);
        int i2 = os.LottieAnimationView_lottie_rawRes;
        boolean hasValue = obtainStyledAttributes.hasValue(i2);
        int i3 = os.LottieAnimationView_lottie_fileName;
        boolean hasValue2 = obtainStyledAttributes.hasValue(i3);
        int i4 = os.LottieAnimationView_lottie_url;
        boolean hasValue3 = obtainStyledAttributes.hasValue(i4);
        if (!hasValue || !hasValue2) {
            if (hasValue) {
                int resourceId = obtainStyledAttributes.getResourceId(i2, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (hasValue2) {
                String string2 = obtainStyledAttributes.getString(i3);
                if (string2 != null) {
                    setAnimation(string2);
                }
            } else if (hasValue3 && (string = obtainStyledAttributes.getString(i4)) != null) {
                setAnimationFromUrl(string);
            }
            setFallbackResource(obtainStyledAttributes.getResourceId(os.LottieAnimationView_lottie_fallbackRes, 0));
            if (obtainStyledAttributes.getBoolean(os.LottieAnimationView_lottie_autoPlay, false)) {
                this.f2769b = true;
            }
            boolean z2 = obtainStyledAttributes.getBoolean(os.LottieAnimationView_lottie_loop, false);
            Ej ej = this.f2761a;
            if (z2) {
                ej.f138a.setRepeatCount(-1);
            }
            int i5 = os.LottieAnimationView_lottie_repeatMode;
            if (obtainStyledAttributes.hasValue(i5)) {
                setRepeatMode(obtainStyledAttributes.getInt(i5, 1));
            }
            int i6 = os.LottieAnimationView_lottie_repeatCount;
            if (obtainStyledAttributes.hasValue(i6)) {
                setRepeatCount(obtainStyledAttributes.getInt(i6, -1));
            }
            int i7 = os.LottieAnimationView_lottie_speed;
            if (obtainStyledAttributes.hasValue(i7)) {
                setSpeed(obtainStyledAttributes.getFloat(i7, 1.0f));
            }
            int i8 = os.LottieAnimationView_lottie_clipToCompositionBounds;
            if (obtainStyledAttributes.hasValue(i8)) {
                setClipToCompositionBounds(obtainStyledAttributes.getBoolean(i8, true));
            }
            setImageAssetsFolder(obtainStyledAttributes.getString(os.LottieAnimationView_lottie_imageAssetsFolder));
            setProgress(obtainStyledAttributes.getFloat(os.LottieAnimationView_lottie_progress, 0.0f));
            boolean z3 = obtainStyledAttributes.getBoolean(os.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false);
            if (ej.f159d != z3) {
                ej.f159d = z3;
                if (ej.f145a != null) {
                    ej.c();
                }
            }
            int i9 = os.LottieAnimationView_lottie_colorFilter;
            if (obtainStyledAttributes.hasValue(i9)) {
                ej.a(new uh("**"), Kj.f351a, new C0344tk(new Ow(d7.c(getContext(), obtainStyledAttributes.getResourceId(i9, -1)).getDefaultColor())));
            }
            int i10 = os.LottieAnimationView_lottie_renderMode;
            if (obtainStyledAttributes.hasValue(i10)) {
                int i11 = obtainStyledAttributes.getInt(i10, 0);
                if (i11 >= st.values().length) {
                    i11 = 0;
                }
                setRenderMode(st.values()[i11]);
            }
            setIgnoreDisabledSystemAnimations(obtainStyledAttributes.getBoolean(os.LottieAnimationView_lottie_ignoreDisabledSystemAnimations, false));
            obtainStyledAttributes.recycle();
            Context context = getContext();
            UB.a aVar = UB.f567a;
            if (Settings.Global.getFloat(context.getContentResolver(), "animator_duration_scale", 1.0f) != 0.0f) {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            ej.getClass();
            ej.f150a = valueOf.booleanValue();
            return;
        }
        throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
    }

    public boolean getClipToCompositionBounds() {
        return this.f2761a.f;
    }

    public C0181ej getComposition() {
        return this.f2765a;
    }

    public long getDuration() {
        C0181ej ejVar = this.f2765a;
        if (ejVar != null) {
            return (long) ejVar.b();
        }
        return 0;
    }

    public int getFrame() {
        return (int) this.f2761a.f138a.b;
    }

    public String getImageAssetsFolder() {
        return this.f2761a.f157c;
    }

    public boolean getMaintainOriginalImageBounds() {
        return this.f2761a.e;
    }

    public float getMaxFrame() {
        return this.f2761a.f138a.c();
    }

    public float getMinFrame() {
        return this.f2761a.f138a.d();
    }

    public C0357up getPerformanceTracker() {
        C0181ej ejVar = this.f2761a.f145a;
        if (ejVar != null) {
            return ejVar.f2905a;
        }
        return null;
    }

    public float getProgress() {
        Nj nj = this.f2761a.f138a;
        C0181ej ejVar = nj.f449a;
        if (ejVar == null) {
            return 0.0f;
        }
        float f = nj.b;
        float f2 = ejVar.a;
        return (f - f2) / (ejVar.b - f2);
    }

    public st getRenderMode() {
        if (this.f2761a.j) {
            return st.SOFTWARE;
        }
        return st.HARDWARE;
    }

    public int getRepeatCount() {
        return this.f2761a.f138a.getRepeatCount();
    }

    public int getRepeatMode() {
        return this.f2761a.f138a.getRepeatMode();
    }

    public float getSpeed() {
        return this.f2761a.f138a.a;
    }

    public final void invalidate() {
        st stVar;
        super.invalidate();
        Drawable drawable = getDrawable();
        if (drawable instanceof Ej) {
            boolean z = ((Ej) drawable).j;
            st stVar2 = st.SOFTWARE;
            if (z) {
                stVar = stVar2;
            } else {
                stVar = st.HARDWARE;
            }
            if (stVar == stVar2) {
                this.f2761a.invalidateSelf();
            }
        }
    }

    public final void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        Ej ej = this.f2761a;
        if (drawable2 == ej) {
            super.invalidateDrawable(ej);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode() && this.f2769b) {
            this.f2761a.i();
        }
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f2770c = savedState.f2773c;
        b bVar = b.SET_ANIMATION;
        HashSet hashSet = this.f2766a;
        if (!hashSet.contains(bVar) && !TextUtils.isEmpty(this.f2770c)) {
            setAnimation(this.f2770c);
        }
        this.d = savedState.c;
        if (!hashSet.contains(bVar) && (i = this.d) != 0) {
            setAnimation(i);
        }
        if (!hashSet.contains(b.SET_PROGRESS)) {
            setProgress(savedState.a);
        }
        b bVar2 = b.PLAY_OPTION;
        if (!hashSet.contains(bVar2) && savedState.f2772a) {
            hashSet.add(bVar2);
            this.f2761a.i();
        }
        if (!hashSet.contains(b.SET_IMAGE_ASSETS)) {
            setImageAssetsFolder(savedState.f2774d);
        }
        if (!hashSet.contains(b.SET_REPEAT_MODE)) {
            setRepeatMode(savedState.d);
        }
        if (!hashSet.contains(b.SET_REPEAT_COUNT)) {
            setRepeatCount(savedState.e);
        }
    }

    public final Parcelable onSaveInstanceState() {
        float f;
        boolean z;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2773c = this.f2770c;
        savedState.c = this.d;
        Ej ej = this.f2761a;
        Nj nj = ej.f138a;
        C0181ej ejVar = nj.f449a;
        if (ejVar == null) {
            f = 0.0f;
        } else {
            float f2 = nj.b;
            float f3 = ejVar.a;
            f = (f2 - f3) / (ejVar.b - f3);
        }
        savedState.a = f;
        boolean isVisible = ej.isVisible();
        Nj nj2 = ej.f138a;
        if (isVisible) {
            z = nj2.f451b;
        } else {
            int i = ej.c;
            if (i == 2 || i == 3) {
                z = true;
            } else {
                z = false;
            }
        }
        savedState.f2772a = z;
        savedState.f2774d = ej.f157c;
        savedState.d = nj2.getRepeatMode();
        savedState.e = nj2.getRepeatCount();
        return savedState;
    }

    public void setAnimation(InputStream inputStream, String str) {
        setCompositionTask(C0281nj.a(str, new C0217hj(0, inputStream, str)));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, (String) null);
    }

    public void setAnimationFromUrl(String str) {
        Mj<C0181ej> mj;
        if (this.f2771c) {
            Context context = getContext();
            HashMap hashMap = C0281nj.a;
            String i = C0709Uj.i("url_", str);
            mj = C0281nj.a(i, new C0205gj(context, str, i));
        } else {
            mj = C0281nj.a((String) null, new C0205gj(getContext(), str, (String) null));
        }
        setCompositionTask(mj);
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.f2761a.i = z;
    }

    public void setCacheComposition(boolean z) {
        this.f2771c = z;
    }

    public void setClipToCompositionBounds(boolean z) {
        Ej ej = this.f2761a;
        if (z != ej.f) {
            ej.f = z;
            l6 l6Var = ej.f147a;
            if (l6Var != null) {
                l6Var.c = z;
            }
            ej.invalidateSelf();
        }
    }

    public void setComposition(C0181ej ejVar) {
        Ej ej = this.f2761a;
        ej.setCallback(this);
        this.f2765a = ejVar;
        this.f2767a = true;
        boolean l = ej.l(ejVar);
        boolean z = false;
        this.f2767a = false;
        if (getDrawable() != ej || l) {
            if (!l) {
                Nj nj = ej.f138a;
                if (nj != null) {
                    z = nj.f451b;
                }
                setImageDrawable((Drawable) null);
                setImageDrawable(ej);
                if (z) {
                    ej.k();
                }
            }
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            Iterator it = this.f2768b.iterator();
            while (it.hasNext()) {
                ((Jj) it.next()).a();
            }
        }
    }

    public void setFailureListener(Hj<Throwable> hj) {
        this.b = hj;
    }

    public void setFallbackResource(int i) {
        this.c = i;
    }

    public void setFontAssetDelegate(C0100Rc rc) {
        Sc sc = this.f2761a.f139a;
    }

    public void setFrame(int i) {
        this.f2761a.m(i);
    }

    public void setIgnoreDisabledSystemAnimations(boolean z) {
        this.f2761a.f153b = z;
    }

    public void setImageAssetDelegate(C0330sf sfVar) {
        C0343tf tfVar = this.f2761a.f149a;
    }

    public void setImageAssetsFolder(String str) {
        this.f2761a.f157c = str;
    }

    public void setImageBitmap(Bitmap bitmap) {
        c();
        super.setImageBitmap(bitmap);
    }

    public void setImageDrawable(Drawable drawable) {
        c();
        super.setImageDrawable(drawable);
    }

    public void setImageResource(int i) {
        c();
        super.setImageResource(i);
    }

    public void setMaintainOriginalImageBounds(boolean z) {
        this.f2761a.e = z;
    }

    public void setMaxFrame(int i) {
        this.f2761a.n(i);
    }

    public void setMaxProgress(float f) {
        this.f2761a.p(f);
    }

    public void setMinAndMaxFrame(String str) {
        this.f2761a.r(str);
    }

    public void setMinAndMaxProgress(float f, float f2) {
        this.f2761a.t(f, f2);
    }

    public void setMinFrame(int i) {
        this.f2761a.u(i);
    }

    public void setMinProgress(float f) {
        this.f2761a.w(f);
    }

    public void setOutlineMasksAndMattes(boolean z) {
        Ej ej = this.f2761a;
        if (ej.h != z) {
            ej.h = z;
            l6 l6Var = ej.f147a;
            if (l6Var != null) {
                l6Var.s(z);
            }
        }
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        Ej ej = this.f2761a;
        ej.g = z;
        C0181ej ejVar = ej.f145a;
        if (ejVar != null) {
            ejVar.f2905a.f3327a = z;
        }
    }

    public void setProgress(float f) {
        this.f2766a.add(b.SET_PROGRESS);
        this.f2761a.x(f);
    }

    public void setRenderMode(st stVar) {
        Ej ej = this.f2761a;
        ej.f148a = stVar;
        ej.e();
    }

    public void setRepeatCount(int i) {
        this.f2766a.add(b.SET_REPEAT_COUNT);
        this.f2761a.f138a.setRepeatCount(i);
    }

    public void setRepeatMode(int i) {
        this.f2766a.add(b.SET_REPEAT_MODE);
        this.f2761a.f138a.setRepeatMode(i);
    }

    public void setSafeMode(boolean z) {
        this.f2761a.f158c = z;
    }

    public void setSpeed(float f) {
        this.f2761a.f138a.a = f;
    }

    public void setTextDelegate(Gz gz) {
        this.f2761a.getClass();
    }

    public final void unscheduleDrawable(Drawable drawable) {
        Ej ej;
        boolean z;
        boolean z2 = this.f2767a;
        boolean z3 = false;
        if (!z2 && drawable == (ej = this.f2761a)) {
            Nj nj = ej.f138a;
            if (nj == null) {
                z = false;
            } else {
                z = nj.f451b;
            }
            if (z) {
                this.f2769b = false;
                ej.h();
                super.unscheduleDrawable(drawable);
            }
        }
        if (!z2 && (drawable instanceof Ej)) {
            Ej ej2 = (Ej) drawable;
            Nj nj2 = ej2.f138a;
            if (nj2 != null) {
                z3 = nj2.f451b;
            }
            if (z3) {
                ej2.h();
            }
        }
        super.unscheduleDrawable(drawable);
    }

    public void setAnimationFromJson(String str, String str2) {
        setAnimation(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void setMaxFrame(String str) {
        this.f2761a.o(str);
    }

    public void setMinAndMaxFrame(String str, String str2, boolean z) {
        this.f2761a.s(str, str2, z);
    }

    public void setMinFrame(String str) {
        this.f2761a.v(str);
    }

    public void setAnimation(int i) {
        Mj<C0181ej> mj;
        Mj<C0181ej> mj2;
        this.d = i;
        this.f2770c = null;
        if (isInEditMode()) {
            mj = new Mj<>(new C0122aj(this, i), true);
        } else {
            if (this.f2771c) {
                Context context = getContext();
                String h = C0281nj.h(context, i);
                mj2 = C0281nj.a(h, new C0273mj(new WeakReference(context), context.getApplicationContext(), i, h));
            } else {
                Context context2 = getContext();
                HashMap hashMap = C0281nj.a;
                mj2 = C0281nj.a((String) null, new C0273mj(new WeakReference(context2), context2.getApplicationContext(), i, (String) null));
            }
            mj = mj2;
        }
        setCompositionTask(mj);
    }

    public void setMinAndMaxFrame(int i, int i2) {
        this.f2761a.q(i, i2);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d(attributeSet, C0207gr.lottieAnimationViewStyle);
    }

    public void setAnimationFromUrl(String str, String str2) {
        setCompositionTask(C0281nj.a(str2, new C0205gj(getContext(), str, str2)));
    }

    public void setAnimation(String str) {
        Mj<C0181ej> mj;
        Mj<C0181ej> mj2;
        this.f2770c = str;
        this.d = 0;
        if (isInEditMode()) {
            mj = new Mj<>(new C0170dj(this, str), true);
        } else {
            if (this.f2771c) {
                Context context = getContext();
                HashMap hashMap = C0281nj.a;
                String i = C0709Uj.i("asset_", str);
                mj2 = C0281nj.a(i, new C0261lj(context.getApplicationContext(), str, i));
            } else {
                Context context2 = getContext();
                HashMap hashMap2 = C0281nj.a;
                mj2 = C0281nj.a((String) null, new C0261lj(context2.getApplicationContext(), str, (String) null));
            }
            mj = mj2;
        }
        setCompositionTask(mj);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d(attributeSet, i);
    }
}
