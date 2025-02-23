package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import cris.org.in.prs.ima.R;

public class MasterPassengerListNewFragment_ViewBinding implements Unbinder {
    public View a;

    /* renamed from: a  reason: collision with other field name */
    public MasterPassengerListNewFragment f4814a;

    public class a extends DebouncingOnClickListener {
        public final /* synthetic */ MasterPassengerListNewFragment a;

        public a(MasterPassengerListNewFragment masterPassengerListNewFragment) {
            this.a = masterPassengerListNewFragment;
        }

        public final void doClick(View view) {
            this.a.setTv_pending_check(view);
        }
    }

    public MasterPassengerListNewFragment_ViewBinding(MasterPassengerListNewFragment masterPassengerListNewFragment, View view) {
        this.f4814a = masterPassengerListNewFragment;
        masterPassengerListNewFragment.passengetList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.master_passenger_list, "field 'passengetList'", RecyclerView.class);
        masterPassengerListNewFragment.editPsgnLayout = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.editPassenger_ll, "field 'editPsgnLayout'", RelativeLayout.class);
        Class cls = TextView.class;
        masterPassengerListNewFragment.errorMsg = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_error_msg, "field 'errorMsg'", cls);
        Class cls2 = LinearLayout.class;
        masterPassengerListNewFragment.ll_pending_check = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_pending_check, "field 'll_pending_check'", cls2);
        View findRequiredView = Utils.findRequiredView(view, R.id.tv_pending_check, "field 'tv_pending_check' and method 'setTv_pending_check'");
        masterPassengerListNewFragment.tv_pending_check = (TextView) Utils.castView(findRequiredView, R.id.tv_pending_check, "field 'tv_pending_check'", cls);
        this.a = findRequiredView;
        findRequiredView.setOnClickListener(new a(masterPassengerListNewFragment));
        masterPassengerListNewFragment.tv_msg_max_tickets = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_msg_max_tickets, "field 'tv_msg_max_tickets'", cls);
        masterPassengerListNewFragment.ll_legend = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_legend, "field 'll_legend'", cls2);
        masterPassengerListNewFragment.masterlist = (AdManagerAdView) Utils.findRequiredViewAsType(view, R.id.master_list, "field 'masterlist'", AdManagerAdView.class);
    }

    public final void unbind() {
        MasterPassengerListNewFragment masterPassengerListNewFragment = this.f4814a;
        if (masterPassengerListNewFragment != null) {
            this.f4814a = null;
            masterPassengerListNewFragment.passengetList = null;
            masterPassengerListNewFragment.editPsgnLayout = null;
            masterPassengerListNewFragment.errorMsg = null;
            masterPassengerListNewFragment.ll_pending_check = null;
            masterPassengerListNewFragment.tv_pending_check = null;
            masterPassengerListNewFragment.tv_msg_max_tickets = null;
            masterPassengerListNewFragment.ll_legend = null;
            masterPassengerListNewFragment.masterlist = null;
            this.a.setOnClickListener((View.OnClickListener) null);
            this.a = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
