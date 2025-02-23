package defpackage;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import defpackage.G7;

/* renamed from: F7  reason: default package */
/* compiled from: CursorAdapter */
public abstract class F7 extends BaseAdapter implements Filterable, G7.a {
    public a a;

    /* renamed from: a  reason: collision with other field name */
    public b f191a;

    /* renamed from: a  reason: collision with other field name */
    public G7 f192a;

    /* renamed from: a  reason: collision with other field name */
    public Context f193a;

    /* renamed from: a  reason: collision with other field name */
    public Cursor f194a = null;

    /* renamed from: a  reason: collision with other field name */
    public boolean f195a = false;
    public boolean b = true;
    public int c;

    /* renamed from: F7$a */
    /* compiled from: CursorAdapter */
    public class a extends ContentObserver {
        public a() {
            super(new Handler());
        }

        public final boolean deliverSelfNotifications() {
            return true;
        }

        public final void onChange(boolean z) {
            Cursor cursor;
            F7 f7 = F7.this;
            if (f7.b && (cursor = f7.f194a) != null && !cursor.isClosed()) {
                f7.f195a = f7.f194a.requery();
            }
        }
    }

    /* renamed from: F7$b */
    /* compiled from: CursorAdapter */
    public class b extends DataSetObserver {
        public b() {
        }

        public final void onChanged() {
            F7 f7 = F7.this;
            f7.f195a = true;
            f7.notifyDataSetChanged();
        }

        public final void onInvalidated() {
            F7 f7 = F7.this;
            f7.f195a = false;
            f7.notifyDataSetInvalidated();
        }
    }

    public F7(Context context) {
        this.f193a = context;
        this.c = -1;
        this.a = new a();
        this.f191a = new b();
    }

    public abstract void b(View view, Cursor cursor);

    public void c(Cursor cursor) {
        Cursor cursor2 = this.f194a;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                a aVar = this.a;
                if (aVar != null) {
                    cursor2.unregisterContentObserver(aVar);
                }
                b bVar = this.f191a;
                if (bVar != null) {
                    cursor2.unregisterDataSetObserver(bVar);
                }
            }
            this.f194a = cursor;
            if (cursor != null) {
                a aVar2 = this.a;
                if (aVar2 != null) {
                    cursor.registerContentObserver(aVar2);
                }
                b bVar2 = this.f191a;
                if (bVar2 != null) {
                    cursor.registerDataSetObserver(bVar2);
                }
                this.c = cursor.getColumnIndexOrThrow("_id");
                this.f195a = true;
                notifyDataSetChanged();
            } else {
                this.c = -1;
                this.f195a = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public abstract String d(Cursor cursor);

    public abstract View e(ViewGroup viewGroup);

    public final int getCount() {
        Cursor cursor;
        if (!this.f195a || (cursor = this.f194a) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f195a) {
            return null;
        }
        this.f194a.moveToPosition(i);
        if (view == null) {
            Ct ct = (Ct) this;
            view = ct.a.inflate(ct.e, viewGroup, false);
        }
        b(view, this.f194a);
        return view;
    }

    public final Filter getFilter() {
        if (this.f192a == null) {
            this.f192a = new G7(this);
        }
        return this.f192a;
    }

    public final Object getItem(int i) {
        Cursor cursor;
        if (!this.f195a || (cursor = this.f194a) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.f194a;
    }

    public final long getItemId(int i) {
        Cursor cursor;
        if (!this.f195a || (cursor = this.f194a) == null || !cursor.moveToPosition(i)) {
            return 0;
        }
        return this.f194a.getLong(this.c);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f195a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f194a.moveToPosition(i)) {
            if (view == null) {
                view = e(viewGroup);
            }
            b(view, this.f194a);
            return view;
        } else {
            throw new IllegalStateException(lf.h("couldn't move cursor to position ", i));
        }
    }
}
