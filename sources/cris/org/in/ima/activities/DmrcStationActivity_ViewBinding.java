package cris.org.in.ima.activities;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class DmrcStationActivity_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public DmrcStationActivity f4162a;

    /* renamed from: a  reason: collision with other field name */
    public a f4163a;
    public View b;

    public class b extends DebouncingOnClickListener {
        public final /* synthetic */ DmrcStationActivity a;

        public b(DmrcStationActivity dmrcStationActivity) {
            this.a = dmrcStationActivity;
        }

        public final void doClick(View view) {
            this.a.backClick();
        }
    }

    public DmrcStationActivity_ViewBinding(DmrcStationActivity dmrcStationActivity, View view) {
        this.f4162a = dmrcStationActivity;
        dmrcStationActivity.dmrcstationList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_dmrc_station_list, "field 'dmrcstationList'", RecyclerView.class);
        Class cls = TextView.class;
        dmrcStationActivity.dmrctvRecentSearch = (TextView) Utils.findRequiredViewAsType(view, R.id.dmrc_tv_recent_search, "field 'dmrctvRecentSearch'", cls);
        View findRequiredView = Utils.findRequiredView(view, R.id.tv_dmrc_search_text, "field 'tvDmrcsearchtext' and method 'dmrcStationSearchClick'");
        dmrcStationActivity.tvDmrcsearchtext = (EditText) Utils.castView(findRequiredView, R.id.tv_dmrc_search_text, "field 'tvDmrcsearchtext'", EditText.class);
        this.a = findRequiredView;
        a aVar = new a(dmrcStationActivity);
        this.f4163a = aVar;
        ((TextView) findRequiredView).addTextChangedListener(aVar);
        dmrcStationActivity.tv_from_distance = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_from_distance, "field 'tv_from_distance'", cls);
        View findRequiredView2 = Utils.findRequiredView(view, R.id.back, "method 'backClick'");
        this.b = findRequiredView2;
        findRequiredView2.setOnClickListener(new b(dmrcStationActivity));
    }

    public final void unbind() {
        DmrcStationActivity dmrcStationActivity = this.f4162a;
        if (dmrcStationActivity != null) {
            this.f4162a = null;
            dmrcStationActivity.dmrcstationList = null;
            dmrcStationActivity.dmrctvRecentSearch = null;
            dmrcStationActivity.tvDmrcsearchtext = null;
            dmrcStationActivity.tv_from_distance = null;
            ((TextView) this.a).removeTextChangedListener(this.f4163a);
            this.f4163a = null;
            this.a = null;
            this.b.setOnClickListener((View.OnClickListener) null);
            this.b = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }

    public class a implements TextWatcher {
        public final /* synthetic */ DmrcStationActivity a;

        public a(DmrcStationActivity dmrcStationActivity) {
            this.a = dmrcStationActivity;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.a.dmrcStationSearchClick(charSequence);
        }

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }
}
