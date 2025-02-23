package defpackage;

import cris.prs.webservices.dto.PassengerDetailDTO;
import defpackage.C0613Ns;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/* renamed from: Os  reason: default package and case insensitive filesystem */
/* compiled from: RefundHistoryDTO */
public final class C0629Os implements Serializable {
    private static final String TAG = C1354qp.R(C0629Os.class);
    private ArrayList<C0613Ns.a> allJourney = new ArrayList<>();
    private ArrayList<C0613Ns.a> pastJourney = new ArrayList<>();
    private ArrayList<C0613Ns.a> upcomingJourney = new ArrayList<>();
    private boolean webConnection;

    public ArrayList<C0613Ns.a> getAllJourney() {
        return this.allJourney;
    }

    public ArrayList<C0613Ns.a> getPastJourney() {
        return this.pastJourney;
    }

    public ArrayList<C0613Ns.a> getUpcomingJourney() {
        return this.upcomingJourney;
    }

    public void pastAndUpcomingJourney(ArrayList<C0613Ns.a> arrayList) {
        try {
            this.allJourney.clear();
            this.upcomingJourney.clear();
            this.pastJourney.clear();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
            Iterator<C0613Ns.a> it = arrayList.iterator();
            while (it.hasNext()) {
                C0613Ns.a next = it.next();
                next.setPsgnDtlList((ArrayList<PassengerDetailDTO>) null);
                this.allJourney.add(next);
                if (next.getTransactionDate().before(parse)) {
                    this.pastJourney.add(next);
                } else {
                    this.upcomingJourney.add(next);
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void setAllJourney(ArrayList<C0613Ns.a> arrayList) {
        this.allJourney = arrayList;
    }

    public void setPastJourney(ArrayList<C0613Ns.a> arrayList) {
        this.pastJourney = arrayList;
    }

    public void setUpcomingJourney(ArrayList<C0613Ns.a> arrayList) {
        this.upcomingJourney = arrayList;
    }
}
