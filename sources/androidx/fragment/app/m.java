package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: FragmentLayoutInflaterFactory */
public final class m implements LayoutInflater.Factory2 {
    public final FragmentManager a;

    public m(FragmentManager fragmentManager) {
        this.a = fragmentManager;
    }

    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        p pVar;
        boolean equals = FragmentContainerView.class.getName().equals(str);
        FragmentManager fragmentManager = this.a;
        if (equals) {
            return new FragmentContainerView(context, attributeSet, fragmentManager);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue((String) null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ls.Fragment);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(ls.Fragment_android_name);
        }
        int resourceId = obtainStyledAttributes.getResourceId(ls.Fragment_android_id, -1);
        String string = obtainStyledAttributes.getString(ls.Fragment_android_tag);
        obtainStyledAttributes.recycle();
        if (attributeValue != null) {
            int i = 0;
            try {
                z = Fragment.class.isAssignableFrom(l.a(context.getClassLoader(), attributeValue));
            } catch (ClassNotFoundException unused) {
                z = false;
            }
            if (z) {
                if (view != null) {
                    i = view.getId();
                }
                if (i == -1 && resourceId == -1 && string == null) {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                }
                Fragment B = resourceId != -1 ? fragmentManager.B(resourceId) : null;
                if (B == null && string != null) {
                    B = fragmentManager.C(string);
                }
                if (B == null && i != -1) {
                    B = fragmentManager.B(i);
                }
                if (B == null) {
                    l H = fragmentManager.H();
                    context.getClassLoader();
                    B = Fragment.instantiate(FragmentManager.this.f2073a.f2066a, attributeValue, (Bundle) null);
                    B.mFromLayout = true;
                    B.mFragmentId = resourceId != 0 ? resourceId : i;
                    B.mContainerId = i;
                    B.mTag = string;
                    B.mInLayout = true;
                    B.mFragmentManager = fragmentManager;
                    FragmentHostCallback<?> fragmentHostCallback = fragmentManager.f2073a;
                    B.mHost = fragmentHostCallback;
                    B.onInflate(fragmentHostCallback.f2066a, attributeSet, B.mSavedFragmentState);
                    pVar = fragmentManager.a(B);
                    if (FragmentManager.K(2)) {
                        B.toString();
                        Integer.toHexString(resourceId);
                    }
                } else if (!B.mInLayout) {
                    B.mInLayout = true;
                    B.mFragmentManager = fragmentManager;
                    FragmentHostCallback<?> fragmentHostCallback2 = fragmentManager.f2073a;
                    B.mHost = fragmentHostCallback2;
                    B.onInflate(fragmentHostCallback2.f2066a, attributeSet, B.mSavedFragmentState);
                    pVar = fragmentManager.f(B);
                    if (FragmentManager.K(2)) {
                        B.toString();
                        Integer.toHexString(resourceId);
                    }
                } else {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(i) + " with another fragment for " + attributeValue);
                }
                B.mContainer = (ViewGroup) view;
                pVar.j();
                pVar.i();
                View view2 = B.mView;
                if (view2 != null) {
                    if (resourceId != 0) {
                        view2.setId(resourceId);
                    }
                    if (B.mView.getTag() == null) {
                        B.mView.setTag(string);
                    }
                    B.mView.addOnAttachStateChangeListener(new a(pVar));
                    return B.mView;
                }
                throw new IllegalStateException(lf.j("Fragment ", attributeValue, " did not create a view."));
            }
        }
        return null;
    }

    /* compiled from: FragmentLayoutInflaterFactory */
    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ p f2152a;

        public a(p pVar) {
            this.f2152a = pVar;
        }

        public final void onViewAttachedToWindow(View view) {
            p pVar = this.f2152a;
            Fragment fragment = pVar.f2158a;
            pVar.j();
            s.g((ViewGroup) fragment.mView.getParent(), m.this.a).e();
        }

        public final void onViewDetachedFromWindow(View view) {
        }
    }
}
