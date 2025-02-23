package defpackage;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
/* renamed from: pe  reason: default package and case insensitive filesystem */
/* compiled from: GhostViewHolder */
public final class C0298pe extends FrameLayout {
    public static final /* synthetic */ int c = 0;
    public final ViewGroup a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3174a = true;

    /* renamed from: pe$a */
    /* compiled from: GhostViewHolder */
    public static class a {
        public static float a(View view) {
            return view.getZ();
        }
    }

    public C0298pe(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        setClipChildren(false);
        this.a = viewGroup;
        viewGroup.setTag(Br.ghost_view_holder, this);
        viewGroup.getOverlay().add(this);
    }

    public static void a(View view, ArrayList<View> arrayList) {
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            a((View) parent, arrayList);
        }
        arrayList.add(view);
    }

    public final void onViewAdded(View view) {
        if (this.f3174a) {
            super.onViewAdded(view);
            return;
        }
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            int i = Br.ghost_view_holder;
            ViewGroup viewGroup = this.a;
            viewGroup.setTag(i, (Object) null);
            viewGroup.getOverlay().remove(this);
            this.f3174a = false;
        }
    }
}
