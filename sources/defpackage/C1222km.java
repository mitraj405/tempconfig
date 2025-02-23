package defpackage;

import cris.prs.webservices.dto.BookingResponseDTO;
import java.util.Comparator;

/* renamed from: km  reason: default package and case insensitive filesystem */
/* compiled from: MyBookingFragment */
public final class C1222km implements Comparator<BookingResponseDTO> {
    public final int compare(Object obj, Object obj2) {
        return ((BookingResponseDTO) obj).getJourneyDate().compareTo(((BookingResponseDTO) obj2).getJourneyDate());
    }
}
