package cris.org.in.ima.utils;

import cris.prs.webservices.dto.BookingResponseDTO;
import cris.prs.webservices.dto.PassengerDetailDTO;
import defpackage.C0613Ns;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public final class TicketHistoryUtil {
    public static C0629Os a = new C0629Os();

    /* renamed from: a  reason: collision with other field name */
    public static C0707Ue f5368a;

    /* renamed from: a  reason: collision with other field name */
    public static C0813c3 f5369a = new C0813c3();

    /* renamed from: a  reason: collision with other field name */
    public static SortFor f5370a;

    /* renamed from: a  reason: collision with other field name */
    public static C1279nb f5371a;
    public static C0707Ue b;

    /* renamed from: b  reason: collision with other field name */
    public static C0813c3 f5372b = new C0813c3();
    public static C0813c3 c = new C0813c3();
    public static C0813c3 d = new C0813c3();
    public static C0813c3 e = new C0813c3();
    public static C0813c3 f = new C0813c3();

    public enum SortFor {
        BOOKINGS("Bookings"),
        CANCELLATION("Cancellation"),
        FAILED_TICKETS("Failed"),
        CANCELLATION_HISTORY("CancelHistory"),
        TDR_HISTORY("TdrHistory"),
        EWALLET_TXN("eWalletTxn"),
        LAST_TXN("LastTxn"),
        UPCOMPING("UPCOMPING");
        

        /* renamed from: c  reason: collision with other field name */
        public final String f5374c;

        /* access modifiers changed from: public */
        SortFor(String str) {
            this.f5374c = str;
        }

        public final String toString() {
            return this.f5374c;
        }
    }

    static {
        C1354qp.R(TicketHistoryUtil.class);
    }

    public static void a(ArrayList<BookingResponseDTO> arrayList, SortFor sortFor) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
            SortFor sortFor2 = SortFor.BOOKINGS;
            SortFor sortFor3 = SortFor.CANCELLATION;
            if (sortFor == sortFor2) {
                if (f5369a == null) {
                    f5369a = new C0813c3();
                }
                f5369a.getAllJourney().clear();
                f5369a.getPastJourney().clear();
                f5369a.getUpcomingJourney().clear();
            } else if (sortFor == sortFor3) {
                if (f5372b == null) {
                    f5372b = new C0813c3();
                }
                f5372b.getAllJourney().clear();
                f5372b.getPastJourney().clear();
                f5372b.getUpcomingJourney().clear();
            }
            SortFor sortFor4 = SortFor.EWALLET_TXN;
            SortFor sortFor5 = SortFor.CANCELLATION_HISTORY;
            SortFor sortFor6 = SortFor.TDR_HISTORY;
            SortFor sortFor7 = SortFor.FAILED_TICKETS;
            if (sortFor == sortFor4) {
                if (c == null) {
                    c = new C0813c3();
                }
                c.getAllJourney().clear();
                c.getPastJourney().clear();
                c.getUpcomingJourney().clear();
            } else if (sortFor.equals(sortFor7)) {
                if (d == null) {
                    d = new C0813c3();
                }
                d.getAllJourney().clear();
                d.getPastJourney().clear();
                d.getUpcomingJourney().clear();
            } else if (sortFor.equals(sortFor6)) {
                if (f == null) {
                    f = new C0813c3();
                }
                f.getAllJourney().clear();
                f.getPastJourney().clear();
                f.getUpcomingJourney().clear();
            } else if (sortFor.equals(sortFor5)) {
                if (e == null) {
                    e = new C0813c3();
                }
                e.getAllJourney().clear();
                e.getPastJourney().clear();
                e.getUpcomingJourney().clear();
            }
            Iterator<BookingResponseDTO> it = arrayList.iterator();
            while (it.hasNext()) {
                BookingResponseDTO next = it.next();
                next.setPsgnDtlList((ArrayList<PassengerDetailDTO>) null);
                next.setRetryBooking(Boolean.FALSE);
                if (sortFor == sortFor2) {
                    f5369a.getAllJourney().add(next);
                    if (next.getJourneyDate().before(parse)) {
                        f5369a.getPastJourney().add(next);
                    } else {
                        f5369a.getUpcomingJourney().add(next);
                    }
                } else if (sortFor == sortFor3) {
                    f5372b.getAllJourney().add(next);
                    if (next.getJourneyDate().before(parse)) {
                        f5372b.getPastJourney().add(next);
                    } else {
                        f5372b.getUpcomingJourney().add(next);
                    }
                } else if (sortFor == sortFor4) {
                    c.getAllJourney().add(next);
                    if (next.getJourneyDate().before(parse)) {
                        c.getPastJourney().add(next);
                    } else {
                        c.getUpcomingJourney().add(next);
                    }
                } else if (sortFor.equals(sortFor7)) {
                    d.getAllJourney().add(next);
                    if (next.getJourneyDate().before(parse)) {
                        d.getPastJourney().add(next);
                    } else {
                        d.getUpcomingJourney().add(next);
                    }
                } else if (sortFor.equals(sortFor6)) {
                    f.getAllJourney().add(next);
                } else if (sortFor.equals(sortFor5)) {
                    e.getAllJourney().add(next);
                    if (next.getJourneyDate().before(parse)) {
                        e.getPastJourney().add(next);
                    } else {
                        e.getUpcomingJourney().add(next);
                    }
                }
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public static void b(ArrayList<C0613Ns.a> arrayList) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = simpleDateFormat.parse(simpleDateFormat.format(new Date()));
            if (a == null) {
                a = new C0629Os();
            }
            a.getAllJourney().clear();
            a.getPastJourney().clear();
            a.getUpcomingJourney().clear();
            Iterator<C0613Ns.a> it = arrayList.iterator();
            while (it.hasNext()) {
                C0613Ns.a next = it.next();
                a.getAllJourney().add(next);
                if (next.getJourneyDate().before(parse)) {
                    a.getPastJourney().add(next);
                } else {
                    a.getUpcomingJourney().add(next);
                }
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public static void c() {
        if (b != null) {
            b = null;
        }
        C0813c3 c3Var = f5369a;
        if (c3Var != null) {
            c3Var.getAllJourney().clear();
            f5369a.getPastJourney().clear();
            f5369a.getUpcomingJourney().clear();
        } else {
            f5369a = new C0813c3();
        }
        C0813c3 c3Var2 = f5372b;
        if (c3Var2 != null) {
            c3Var2.getAllJourney().clear();
            f5372b.getPastJourney().clear();
            f5372b.getUpcomingJourney().clear();
        } else {
            f5372b = new C0813c3();
        }
        C0813c3 c3Var3 = c;
        if (c3Var3 != null) {
            c3Var3.getAllJourney().clear();
            c.getPastJourney().clear();
            c.getUpcomingJourney().clear();
        } else {
            c = new C0813c3();
        }
        C0813c3 c3Var4 = d;
        if (c3Var4 != null) {
            c3Var4.getAllJourney().clear();
            d.getPastJourney().clear();
            d.getUpcomingJourney().clear();
        } else {
            d = new C0813c3();
        }
        C0813c3 c3Var5 = e;
        if (c3Var5 != null) {
            c3Var5.getAllJourney().clear();
            e.getPastJourney().clear();
            e.getUpcomingJourney().clear();
        } else {
            e = new C0813c3();
        }
        C0813c3 c3Var6 = f;
        if (c3Var6 != null) {
            c3Var6.getAllJourney().clear();
        } else {
            f = new C0813c3();
        }
        C0629Os os = a;
        if (os != null) {
            os.getAllJourney().clear();
            a.getPastJourney().clear();
            a.getUpcomingJourney().clear();
        } else {
            a = new C0629Os();
        }
        f5368a = null;
    }
}
