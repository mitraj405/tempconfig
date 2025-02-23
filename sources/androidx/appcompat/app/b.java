package androidx.appcompat.app;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import androidx.appcompat.app.AlertController;

/* compiled from: AlertController */
public final class b extends CursorAdapter {
    public final /* synthetic */ AlertController.AlertParams a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ AlertController.RecycleListView f950a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ AlertController f951a;
    public final int c;
    public final int d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(AlertController.AlertParams alertParams, Context context, Cursor cursor, AlertController.RecycleListView recycleListView, AlertController alertController) {
        super(context, cursor, false);
        this.a = alertParams;
        this.f950a = recycleListView;
        this.f951a = alertController;
        Cursor cursor2 = getCursor();
        this.c = cursor2.getColumnIndexOrThrow(alertParams.f874a);
        this.d = cursor2.getColumnIndexOrThrow(alertParams.f882b);
    }

    public final void bindView(View view, Context context, Cursor cursor) {
        ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.c));
        int position = cursor.getPosition();
        int i = cursor.getInt(this.d);
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        this.f950a.setItemChecked(position, z);
    }

    public final View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.a.f869a.inflate(this.f951a.k, viewGroup, false);
    }
}
