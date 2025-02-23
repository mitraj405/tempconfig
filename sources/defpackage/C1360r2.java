package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import cris.org.in.ima.adaptors.ItemCnfListHolder;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import uk.co.ribot.easyadapter.PositionInfo;

/* renamed from: r2  reason: default package and case insensitive filesystem */
/* compiled from: BaseEasyRecyclerAdapter */
public abstract class C1360r2<T> extends RecyclerView.Adapter<a> {
    public LayoutInflater a;

    /* renamed from: a  reason: collision with other field name */
    public Class f6936a;

    /* renamed from: a  reason: collision with other field name */
    public Integer f6937a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f6938a;

    /* renamed from: r2$a */
    /* compiled from: BaseEasyRecyclerAdapter */
    public static class a extends RecyclerView.ViewHolder {
        public final C1424ug a;

        public a(C1424ug ugVar) {
            super(ugVar.getView());
            this.a = ugVar;
        }
    }

    public C1360r2(Context context) {
        a(context, ItemCnfListHolder.class);
    }

    public final void a(Context context, Class<? extends C1424ug> cls) {
        Integer num;
        this.f6936a = cls;
        this.a = (LayoutInflater) context.getSystemService("layout_inflater");
        Annotation annotation = cls.getAnnotation(C0708Uh.class);
        if (annotation instanceof C0708Uh) {
            num = Integer.valueOf(((C0708Uh) annotation).value());
        } else {
            num = null;
        }
        if (num != null) {
            this.f6937a = num;
            return;
        }
        throw new Qx();
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        T t = ((U9) this).a.get(i);
        C1424ug ugVar = ((a) viewHolder).a;
        getItemCount();
        PositionInfo positionInfo = new PositionInfo(0);
        ugVar.setItem(t);
        ugVar.onSetValues(t, positionInfo);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = this.a.inflate(this.f6937a.intValue(), viewGroup, false);
        Class cls = this.f6936a;
        try {
            C1424ug ugVar = (C1424ug) cls.getConstructor(new Class[]{View.class}).newInstance(new Object[]{inflate});
            ugVar.setListener(this.f6938a);
            ugVar.onSetListeners();
            return new a(ugVar);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException("Unable to find a public constructor that takes an argument View in ".concat(cls.getSimpleName()), e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3.getTargetException());
        } catch (InstantiationException e4) {
            throw new RuntimeException("Unable to instantiate ".concat(cls.getSimpleName()), e4);
        }
    }

    public C1360r2(Context context, Class<? extends C1424ug> cls, Object obj) {
        a(context, cls);
        this.f6938a = obj;
    }
}
