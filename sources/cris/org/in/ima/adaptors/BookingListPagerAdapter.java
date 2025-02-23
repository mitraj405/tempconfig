package cris.org.in.ima.adaptors;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import cris.org.in.ima.fragment.BookingHistoryFragment;
import cris.org.in.ima.utils.TicketHistoryUtil;
import cris.prs.webservices.dto.BookingResponseDTO;
import java.util.ArrayList;

public class BookingListPagerAdapter extends C0318rd {
    private static final int ALL_JOURNEY_TABS = 0;
    private static final int NUMBER_OF_TABS = 3;
    private static final int PAST_JOURNEY_TAB = 2;
    private static final String TAG = C1354qp.R(BookingListPagerAdapter.class);
    private static final int UPCOMING_JOURNEY_TABS = 1;
    private TicketHistoryUtil.SortFor sortFor;
    ArrayList<BookingResponseDTO> ticketList;

    public BookingListPagerAdapter(FragmentManager fragmentManager, TicketHistoryUtil.SortFor sortFor2) {
        super(fragmentManager);
        this.sortFor = sortFor2;
    }

    public int getCount() {
        return 3;
    }

    public Fragment getItem(int i) {
        Bundle bundle = new Bundle();
        TicketHistoryUtil.SortFor sortFor2 = TicketHistoryUtil.SortFor.EWALLET_TXN;
        TicketHistoryUtil.SortFor sortFor3 = TicketHistoryUtil.SortFor.CANCELLATION;
        TicketHistoryUtil.SortFor sortFor4 = TicketHistoryUtil.SortFor.BOOKINGS;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    if (this.sortFor.equals(sortFor4)) {
                        this.ticketList = TicketHistoryUtil.f5369a.getPastJourney();
                    } else if (this.sortFor.equals(sortFor3)) {
                        this.ticketList = TicketHistoryUtil.f5372b.getPastJourney();
                    } else if (this.sortFor.equals(sortFor2)) {
                        this.ticketList = TicketHistoryUtil.c.getPastJourney();
                    }
                }
            } else if (this.sortFor.equals(sortFor4)) {
                this.ticketList = TicketHistoryUtil.f5369a.getUpcomingJourney();
            } else if (this.sortFor.equals(sortFor3)) {
                this.ticketList = TicketHistoryUtil.f5372b.getUpcomingJourney();
            } else if (this.sortFor.equals(sortFor2)) {
                this.ticketList = TicketHistoryUtil.c.getUpcomingJourney();
            }
        } else if (this.sortFor.equals(sortFor4)) {
            this.ticketList = TicketHistoryUtil.f5369a.getAllJourney();
        } else if (this.sortFor.equals(sortFor3)) {
            this.ticketList = TicketHistoryUtil.f5372b.getAllJourney();
        } else if (this.sortFor.equals(sortFor2)) {
            this.ticketList = TicketHistoryUtil.c.getAllJourney();
        }
        bundle.putSerializable("ticket", this.ticketList);
        this.ticketList.toString();
        BookingHistoryFragment bookingHistoryFragment = new BookingHistoryFragment();
        bookingHistoryFragment.setArguments(bundle);
        return bookingHistoryFragment;
    }
}
