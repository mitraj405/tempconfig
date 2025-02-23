package cris.org.in.ima.adaptors;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import cris.org.in.ima.fragment.RefundTxnHistoryFragment;
import cris.org.in.ima.utils.TicketHistoryUtil;
import defpackage.C0613Ns;
import java.util.ArrayList;

public class RefundHistoryPagerAdapter extends C0318rd {
    private static final int ALL_JOURNEY_TABS = 0;
    private static final int NUMBER_OF_TABS = 3;
    private static final int PAST_JOURNEY_TAB = 2;
    private static final String TAG = C1354qp.R(RefundHistoryPagerAdapter.class);
    private static final int UPCOMING_JOURNEY_TABS = 1;
    ArrayList<C0613Ns.a> ticketList;

    public RefundHistoryPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public int getCount() {
        return 3;
    }

    public Fragment getItem(int i) {
        Bundle bundle = new Bundle();
        if (i == 0) {
            this.ticketList = TicketHistoryUtil.a.getAllJourney();
        } else if (i == 1) {
            this.ticketList = TicketHistoryUtil.a.getUpcomingJourney();
        } else if (i == 2) {
            this.ticketList = TicketHistoryUtil.a.getPastJourney();
        }
        bundle.putSerializable("ticket", this.ticketList);
        this.ticketList.toString();
        RefundTxnHistoryFragment refundTxnHistoryFragment = new RefundTxnHistoryFragment();
        refundTxnHistoryFragment.setArguments(bundle);
        return refundTxnHistoryFragment;
    }
}
