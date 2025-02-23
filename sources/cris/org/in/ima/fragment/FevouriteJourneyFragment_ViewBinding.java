package cris.org.in.ima.fragment;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import cris.org.in.prs.ima.R;

public class FevouriteJourneyFragment_ViewBinding implements Unbinder {
    public FevouriteJourneyFragment a;

    public FevouriteJourneyFragment_ViewBinding(FevouriteJourneyFragment fevouriteJourneyFragment, View view) {
        this.a = fevouriteJourneyFragment;
        fevouriteJourneyFragment.rv_fevjourney = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_fev_journey_list, "field 'rv_fevjourney'", RecyclerView.class);
        fevouriteJourneyFragment.no_fevourite_jrny = (TextView) Utils.findRequiredViewAsType(view, R.id.no_fevourite_jrny, "field 'no_fevourite_jrny'", TextView.class);
    }

    public final void unbind() {
        FevouriteJourneyFragment fevouriteJourneyFragment = this.a;
        if (fevouriteJourneyFragment != null) {
            this.a = null;
            fevouriteJourneyFragment.rv_fevjourney = null;
            fevouriteJourneyFragment.no_fevourite_jrny = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
