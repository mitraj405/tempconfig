package defpackage;

import android.view.View;
import uk.co.ribot.easyadapter.PositionInfo;

/* renamed from: ug  reason: default package and case insensitive filesystem */
/* compiled from: ItemViewHolder */
public abstract class C1424ug<T> extends C1439vC {
    private T mItem;
    private Object mListener;

    public C1424ug(View view) {
        super(view);
    }

    public T getItem() {
        return this.mItem;
    }

    public Object getListener() {
        return this.mListener;
    }

    public abstract void onSetValues(T t, PositionInfo positionInfo);

    public void setItem(T t) {
        this.mItem = t;
    }

    public void setListener(Object obj) {
        this.mListener = obj;
    }

    public C1424ug(View view, T t) {
        super(view);
        setItem(t);
    }

    public <P> P getListener(Class<P> cls) {
        Object obj = this.mListener;
        if (obj != null) {
            return cls.cast(obj);
        }
        return null;
    }

    public void onSetListeners() {
    }
}
