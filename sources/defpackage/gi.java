package defpackage;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.ListPopupWindow;

/* renamed from: gi  reason: default package */
/* compiled from: ListPopupWindow */
public final class gi implements AdapterView.OnItemSelectedListener {
    public final /* synthetic */ ListPopupWindow a;

    public gi(ListPopupWindow listPopupWindow) {
        this.a = listPopupWindow;
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        A9 a9;
        if (i != -1 && (a9 = this.a.f1196a) != null) {
            a9.setListSelectionHidden(false);
        }
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }
}
