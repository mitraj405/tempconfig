package defpackage;

import cris.prs.webservices.dto.BookingResponseDTO;
import cris.prs.webservices.dto.PassengerDetailDTO;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/* renamed from: c3  reason: default package and case insensitive filesystem */
/* compiled from: BookingHistoryDTO */
public final class C0813c3 implements Serializable {
    private static final String TAG = C1354qp.R(C0813c3.class);
    private ArrayList<BookingResponseDTO> allJourney = new ArrayList<>();
    private ArrayList<BookingResponseDTO> pastJourney = new ArrayList<>();
    private ArrayList<BookingResponseDTO> upcomingJourney = new ArrayList<>();
    private boolean webConnection;

    public ArrayList<BookingResponseDTO> getAllJourney() {
        return this.allJourney;
    }

    public ArrayList<BookingResponseDTO> getPastJourney() {
        return this.pastJourney;
    }

    public ArrayList<BookingResponseDTO> getUpcomingJourney() {
        return this.upcomingJourney;
    }

    public boolean isWebConnection() {
        return this.webConnection;
    }

    public void pastAndUpcomingJourney(ArrayList<BookingResponseDTO> arrayList) {
        try {
            this.allJourney.clear();
            this.upcomingJourney.clear();
            this.pastJourney.clear();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
            Iterator<BookingResponseDTO> it = arrayList.iterator();
            while (it.hasNext()) {
                BookingResponseDTO next = it.next();
                next.setPsgnDtlList((ArrayList<PassengerDetailDTO>) null);
                this.allJourney.add(next);
                if (next.getJourneyDate().before(parse)) {
                    this.pastJourney.add(next);
                } else {
                    this.upcomingJourney.add(next);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void setAllJourney(ArrayList<BookingResponseDTO> arrayList) {
        this.allJourney = arrayList;
    }

    public void setPastJourney(ArrayList<BookingResponseDTO> arrayList) {
        this.pastJourney = arrayList;
    }

    public void setUpcomingJourney(ArrayList<BookingResponseDTO> arrayList) {
        this.upcomingJourney = arrayList;
    }

    public void setWebConnection(boolean z) {
        this.webConnection = z;
    }
}
