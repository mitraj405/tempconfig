package cris.org.in.ima.adaptors;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import cris.org.in.ima.fragment.FailedTxnHistoryFragment;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.prs.webservices.dto.BookingResponseDTO;
import java.util.ArrayList;

public class CancellationPagerAdapter extends C0318rd {
    private static final int ALL_JOURNEY_TABS = 0;
    private static final int NUMBER_OF_TABS = 3;
    private static final int PAST_JOURNEY_TAB = 2;
    private static final String TAG = C1354qp.R(CancellationPagerAdapter.class);
    private static final int UPCOMING_JOURNEY_TABS = 1;
    private TicketHistoryUtil.SortFor sortFor;
    ArrayList<BookingResponseDTO> ticketList;

    public CancellationPagerAdapter(FragmentManager fragmentManager, TicketHistoryUtil.SortFor sortFor2) {
        super(fragmentManager);
        this.sortFor = sortFor2;
    }

    public int getCount() {
        return 3;
    }

    public Fragment getItem(int i) {
        Bundle bundle = new Bundle();
        if (i == 0) {
            this.ticketList = TicketHistoryUtil.f5372b.getAllJourney();
        } else if (i == 1) {
            this.ticketList = TicketHistoryUtil.f5372b.getUpcomingJourney();
        } else if (i == 2) {
            this.ticketList = TicketHistoryUtil.f5372b.getPastJourney();
        }
        bundle.putSerializable("ticket", this.ticketList);
        this.ticketList.toString();
        FailedTxnHistoryFragment failedTxnHistoryFragment = new FailedTxnHistoryFragment();
        failedTxnHistoryFragment.setArguments(bundle);
        return failedTxnHistoryFragment;
    }
}
