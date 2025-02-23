package defpackage;

import android.content.Context;
import android.graphics.RectF;
import android.os.Build;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: u1  reason: default package */
/* compiled from: AppCompatTextViewAutoSizeHelper */
public final class u1 {
    public float a = -1.0f;

    /* renamed from: a  reason: collision with other field name */
    public int f3309a = 0;

    /* renamed from: a  reason: collision with other field name */
    public final Context f3310a;

    /* renamed from: a  reason: collision with other field name */
    public final TextView f3311a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3312a = false;

    /* renamed from: a  reason: collision with other field name */
    public int[] f3313a = new int[0];
    public float b = -1.0f;

    /* renamed from: b  reason: collision with other field name */
    public boolean f3314b = false;
    public float c = -1.0f;

    /* renamed from: u1$a */
    /* compiled from: AppCompatTextViewAutoSizeHelper */
    public static class a extends c {
    }

    /* renamed from: u1$b */
    /* compiled from: AppCompatTextViewAutoSizeHelper */
    public static class b extends a {
    }

    /* renamed from: u1$c */
    /* compiled from: AppCompatTextViewAutoSizeHelper */
    public static class c {
    }

    static {
        new RectF();
        new ConcurrentHashMap();
        new ConcurrentHashMap();
    }

    public u1(TextView textView) {
        this.f3311a = textView;
        this.f3310a = textView.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            new b();
        } else {
            new a();
        }
    }

    public static int[] a(int[] iArr) {
        if (r0 == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (i > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i)) < 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        if (r0 == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr2[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        return iArr2;
    }

    public final boolean b() {
        if (!d() || this.f3309a != 1) {
            this.f3312a = false;
        } else {
            if (!this.f3314b || this.f3313a.length == 0) {
                int floor = ((int) Math.floor((double) ((this.c - this.b) / this.a))) + 1;
                int[] iArr = new int[floor];
                for (int i = 0; i < floor; i++) {
                    iArr[i] = Math.round((((float) i) * this.a) + this.b);
                }
                this.f3313a = a(iArr);
            }
            this.f3312a = true;
        }
        return this.f3312a;
    }

    public final boolean c() {
        boolean z;
        int[] iArr = this.f3313a;
        int length = iArr.length;
        if (length > 0) {
            z = true;
        } else {
            z = false;
        }
        this.f3314b = z;
        if (z) {
            this.f3309a = 1;
            this.b = (float) iArr[0];
            this.c = (float) iArr[length - 1];
            this.a = -1.0f;
        }
        return z;
    }

    public final boolean d() {
        return !(this.f3311a instanceof AppCompatEditText);
    }

    public final void e(float f, float f2, float f3) throws IllegalArgumentException {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f + "px) is less or equal to (0px)");
        } else if (f2 <= f) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f2 + "px) is less or equal to minimum auto-size text size (" + f + "px)");
        } else if (f3 > 0.0f) {
            this.f3309a = 1;
            this.b = f;
            this.c = f2;
            this.a = f3;
            this.f3314b = false;
        } else {
            throw new IllegalArgumentException("The auto-size step granularity (" + f3 + "px) is less or equal to (0px)");
        }
    }
}
