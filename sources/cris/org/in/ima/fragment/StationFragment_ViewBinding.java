package cris.org.in.ima.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class StationFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public StationFragment f5121a;

    /* renamed from: a  reason: collision with other field name */
    public a f5122a;

    public StationFragment_ViewBinding(StationFragment stationFragment, View view) {
        this.f5121a = stationFragment;
        stationFragment.stationList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_station_list, "field 'stationList'", RecyclerView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.tv_search_text, "field 'stationSearch' and method 'stationSearchChange'");
        stationFragment.stationSearch = (EditText) Utils.castView(findRequiredView, R.id.tv_search_text, "field 'stationSearch'", EditText.class);
        this.a = findRequiredView;
        a aVar = new a(stationFragment);
        this.f5122a = aVar;
        ((TextView) findRequiredView).addTextChangedListener(aVar);
        stationFragment.recentStationSearch = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_recent_search, "field 'recentStationSearch'", TextView.class);
    }

    public final void unbind() {
        StationFragment stationFragment = this.f5121a;
        if (stationFragment != null) {
            this.f5121a = null;
            stationFragment.stationList = null;
            stationFragment.stationSearch = null;
            stationFragment.recentStationSearch = null;
            ((TextView) this.a).removeTextChangedListener(this.f5122a);
            this.f5122a = null;
            this.a = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }

    public class a implements TextWatcher {
        public final /* synthetic */ StationFragment a;

        public a(StationFragment stationFragment) {
            this.a = stationFragment;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.a.stationSearchChange(charSequence);
        }

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
