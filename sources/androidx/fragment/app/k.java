package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

/* compiled from: FragmentAnim */
public final class k {
    public static a a(Context context, Fragment fragment, boolean z, boolean z2) {
        int i;
        int i2;
        int nextTransition = fragment.getNextTransition();
        if (z2) {
            if (z) {
                i = fragment.getPopEnterAnim();
            } else {
                i = fragment.getPopExitAnim();
            }
        } else if (z) {
            i = fragment.getEnterAnim();
        } else {
            i = fragment.getExitAnim();
        }
        boolean z3 = false;
        fragment.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            int i3 = Lr.visible_removing_fragment_view_tag;
            if (viewGroup.getTag(i3) != null) {
                fragment.mContainer.setTag(i3, (Object) null);
            }
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z, i);
        if (onCreateAnimation != null) {
            return new a(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z, i);
        if (onCreateAnimator != null) {
            return new a(onCreateAnimator);
        }
        if (i == 0 && nextTransition != 0) {
            if (nextTransition != 4097) {
                if (nextTransition != 4099) {
                    if (nextTransition != 8194) {
                        i2 = -1;
                    } else if (z) {
                        i2 = Xq.fragment_close_enter;
                    } else {
                        i2 = Xq.fragment_close_exit;
                    }
                } else if (z) {
                    i2 = Xq.fragment_fade_enter;
                } else {
                    i2 = Xq.fragment_fade_exit;
                }
            } else if (z) {
                i2 = Xq.fragment_open_enter;
            } else {
                i2 = Xq.fragment_open_exit;
            }
            i = i2;
        }
        if (i != 0) {
            boolean equals = "anim".equals(context.getResources().getResourceTypeName(i));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(context, i);
                    if (loadAnimation != null) {
                        return new a(loadAnimation);
                    }
                    z3 = true;
                } catch (Resources.NotFoundException e) {
                    throw e;
                } catch (RuntimeException unused) {
                }
            }
            if (!z3) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(context, i);
                    if (loadAnimator != null) {
                        return new a(loadAnimator);
                    }
                } catch (RuntimeException e2) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, i);
                        if (loadAnimation2 != null) {
                            return new a(loadAnimation2);
                        }
                    } else {
                        throw e2;
                    }
                }
            }
        }
        return null;
    }

    /* compiled from: FragmentAnim */
    public static class a {
        public final Animator a;

        /* renamed from: a  reason: collision with other field name */
        public final Animation f2149a;

        public a(Animation animation) {
            this.f2149a = animation;
            this.a = null;
        }

        public a(Animator animator) {
            this.f2149a = null;
            this.a = animator;
        }
    }

    /* compiled from: FragmentAnim */
    public static class b extends AnimationSet implements Runnable {
        public final View a;

        /* renamed from: a  reason: collision with other field name */
        public final ViewGroup f2150a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f2151a;
        public boolean b;
        public boolean c = true;

        public b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f2150a = viewGroup;
            this.a = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        public final boolean getTransformation(long j, Transformation transformation) {
            this.c = true;
            if (this.f2151a) {
                return !this.b;
            }
            if (!super.getTransformation(j, transformation)) {
                this.f2151a = true;
                C0184eo.a(this.f2150a, this);
            }
            return true;
        }

        public final void run() {
            boolean z = this.f2151a;
            ViewGroup viewGroup = this.f2150a;
            if (z || !this.c) {
                viewGroup.endViewTransition(this.a);
                this.b = true;
                return;
            }
            this.c = false;
            viewGroup.post(this);
        }

        public final boolean getTransformation(long j, Transformation transformation, float f) {
            this.c = true;
            if (this.f2151a) {
                return !this.b;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.f2151a = true;
                C0184eo.a(this.f2150a, this);
            }
            return true;
        }
    }
}
