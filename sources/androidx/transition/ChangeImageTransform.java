package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.transition.Transition;
import androidx.transition.f;
import defpackage.Kk;
import java.util.HashMap;

public class ChangeImageTransform extends Transition {
    public static final a a = new a();

    /* renamed from: a  reason: collision with other field name */
    public static final b f2476a = new b();

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f2477a = {"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};

    public class a implements TypeEvaluator<Matrix> {
        public final /* bridge */ /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
            Matrix matrix = (Matrix) obj;
            Matrix matrix2 = (Matrix) obj2;
            return null;
        }
    }

    public class b extends Property<ImageView, Matrix> {
        public b() {
            super(Matrix.class, "animatedTransform");
        }

        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            ImageView imageView = (ImageView) obj;
            return null;
        }

        public final void set(Object obj, Object obj2) {
            C0380wf.a((ImageView) obj, (Matrix) obj2);
        }
    }

    public static /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeImageTransform.c.<clinit>():void");
        }
    }

    public static class d extends AnimatorListenerAdapter implements Transition.TransitionListener {
        public final Matrix a;

        /* renamed from: a  reason: collision with other field name */
        public final ImageView f2478a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f2479a = true;
        public final Matrix b;

        public d(ImageView imageView, Matrix matrix, Matrix matrix2) {
            this.f2478a = imageView;
            this.a = matrix;
            this.b = matrix2;
        }

        public final void onAnimationEnd(Animator animator, boolean z) {
            this.f2479a = z;
        }

        public final void onAnimationPause(Animator animator) {
            int i = Br.transition_image_transform;
            ImageView imageView = this.f2478a;
            imageView.setTag(i, (Matrix) ((ObjectAnimator) animator).getAnimatedValue());
            C0380wf.a(imageView, this.b);
        }

        public final void onAnimationResume(Animator animator) {
            int i = Br.transition_image_transform;
            ImageView imageView = this.f2478a;
            Matrix matrix = (Matrix) imageView.getTag(i);
            if (matrix != null) {
                C0380wf.a(imageView, matrix);
                imageView.setTag(i, (Object) null);
            }
        }

        public final void onAnimationStart(Animator animator, boolean z) {
            this.f2479a = false;
        }

        public final void onTransitionPause(Transition transition) {
            if (this.f2479a) {
                int i = Br.transition_image_transform;
                ImageView imageView = this.f2478a;
                imageView.setTag(i, this.a);
                C0380wf.a(imageView, this.b);
            }
        }

        public final void onTransitionResume(Transition transition) {
            int i = Br.transition_image_transform;
            ImageView imageView = this.f2478a;
            Matrix matrix = (Matrix) imageView.getTag(i);
            if (matrix != null) {
                C0380wf.a(imageView, matrix);
                imageView.setTag(i, (Object) null);
            }
        }

        public final void onAnimationEnd(Animator animator) {
            this.f2479a = false;
        }

        public final void onAnimationStart(Animator animator) {
            this.f2479a = false;
        }

        public final void onTransitionCancel(Transition transition) {
        }

        public final void onTransitionEnd(Transition transition) {
        }

        public final void onTransitionStart(Transition transition) {
        }
    }

    public ChangeImageTransform() {
    }

    public final void a(TransitionValues transitionValues, boolean z) {
        Matrix matrix;
        Matrix matrix2;
        View view = transitionValues.a;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() != null) {
                HashMap hashMap = transitionValues.f2517a;
                hashMap.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                if (z) {
                    matrix = (Matrix) imageView.getTag(Br.transition_image_transform);
                } else {
                    matrix = null;
                }
                if (matrix == null) {
                    Drawable drawable = imageView.getDrawable();
                    if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
                        matrix = new Matrix(imageView.getImageMatrix());
                    } else {
                        int i = c.a[imageView.getScaleType().ordinal()];
                        if (i == 1) {
                            Drawable drawable2 = imageView.getDrawable();
                            matrix2 = new Matrix();
                            matrix2.postScale(((float) imageView.getWidth()) / ((float) drawable2.getIntrinsicWidth()), ((float) imageView.getHeight()) / ((float) drawable2.getIntrinsicHeight()));
                        } else if (i != 2) {
                            matrix = new Matrix(imageView.getImageMatrix());
                        } else {
                            Drawable drawable3 = imageView.getDrawable();
                            int intrinsicWidth = drawable3.getIntrinsicWidth();
                            float width = (float) imageView.getWidth();
                            float f = (float) intrinsicWidth;
                            int intrinsicHeight = drawable3.getIntrinsicHeight();
                            float height = (float) imageView.getHeight();
                            float f2 = (float) intrinsicHeight;
                            float max = Math.max(width / f, height / f2);
                            int round = Math.round((width - (f * max)) / 2.0f);
                            int round2 = Math.round((height - (f2 * max)) / 2.0f);
                            matrix2 = new Matrix();
                            matrix2.postScale(max, max);
                            matrix2.postTranslate((float) round, (float) round2);
                        }
                        matrix = matrix2;
                    }
                }
                hashMap.put("android:changeImageTransform:matrix", matrix);
            }
        }
    }

    public final void captureEndValues(TransitionValues transitionValues) {
        a(transitionValues, false);
    }

    public final void captureStartValues(TransitionValues transitionValues) {
        a(transitionValues, true);
    }

    public final Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        boolean z;
        if (!(transitionValues == null || transitionValues2 == null)) {
            HashMap hashMap = transitionValues.f2517a;
            Rect rect = (Rect) hashMap.get("android:changeImageTransform:bounds");
            HashMap hashMap2 = transitionValues2.f2517a;
            Rect rect2 = (Rect) hashMap2.get("android:changeImageTransform:bounds");
            if (!(rect == null || rect2 == null)) {
                Matrix matrix = (Matrix) hashMap.get("android:changeImageTransform:matrix");
                Matrix matrix2 = (Matrix) hashMap2.get("android:changeImageTransform:matrix");
                if (!(matrix == null && matrix2 == null) && (matrix == null || !matrix.equals(matrix2))) {
                    z = false;
                } else {
                    z = true;
                }
                if (rect.equals(rect2) && z) {
                    return null;
                }
                ImageView imageView = (ImageView) transitionValues2.a;
                Drawable drawable = imageView.getDrawable();
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                b bVar = f2476a;
                if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                    a aVar = a;
                    Kk.a aVar2 = Kk.a;
                    return ObjectAnimator.ofObject(imageView, bVar, aVar, new Matrix[]{aVar2, aVar2});
                }
                if (matrix == null) {
                    matrix = Kk.a;
                }
                if (matrix2 == null) {
                    matrix2 = Kk.a;
                }
                bVar.set(imageView, matrix);
                ObjectAnimator ofObject = ObjectAnimator.ofObject(imageView, bVar, new f.b(), new Matrix[]{matrix, matrix2});
                d dVar = new d(imageView, matrix, matrix2);
                ofObject.addListener(dVar);
                ofObject.addPauseListener(dVar);
                addListener(dVar);
                return ofObject;
            }
        }
        return null;
    }

    public final String[] getTransitionProperties() {
        return f2477a;
    }

    public final boolean isSeekingSupported() {
        return true;
    }

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
