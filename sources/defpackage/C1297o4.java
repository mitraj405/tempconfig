package defpackage;

import cris.prs.webservices.dto.BookingResponseDTO;
import java.util.Comparator;

/* renamed from: o4  reason: default package and case insensitive filesystem */
/* compiled from: CancelTktFragment */
public final class C1297o4 implements Comparator<BookingResponseDTO> {
    public final int compare(Object obj, Object obj2) {
        return ((BookingResponseDTO) obj).getJourneyDate().compareTo(((BookingResponseDTO) obj2).getJourneyDate());
    }
}
