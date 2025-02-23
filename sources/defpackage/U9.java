package defpackage;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import cris.org.in.ima.adaptors.StationListAdapter;
import cris.org.in.ima.adaptors.VikalpTrainListAdapter;
import cris.org.in.ima.fragment.StationFragment;
import java.util.ArrayList;
import java.util.List;

/* renamed from: U9  reason: default package */
/* compiled from: EasyRecyclerAdapter */
public final class U9<T> extends C1360r2<T> {
    public List<T> a;

    public U9(Context context, ArrayList arrayList, VikalpTrainListAdapter.VikalpTrainListListener vikalpTrainListListener) {
        super(context, VikalpTrainListAdapter.class, vikalpTrainListListener);
        this.a = arrayList;
        notifyDataSetChanged();
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public U9(FragmentActivity fragmentActivity, StationFragment.b bVar) {
        super(fragmentActivity, StationListAdapter.class, bVar);
        this.a = new ArrayList();
    }

    public U9(Context context, ArrayList arrayList) {
        super(context);
        this.a = arrayList;
        notifyDataSetChanged();
    }
}
