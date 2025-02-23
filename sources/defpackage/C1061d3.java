package defpackage;

import cris.prs.webservices.dto.BookingResponseDTO;
import java.util.Comparator;

/* renamed from: d3  reason: default package and case insensitive filesystem */
/* compiled from: BookingHistoryFragment */
public final class C1061d3 implements Comparator<BookingResponseDTO> {
    public final int compare(Object obj, Object obj2) {
        return -((BookingResponseDTO) obj).getJourneyDate().compareTo(((BookingResponseDTO) obj2).getJourneyDate());
    }
}
