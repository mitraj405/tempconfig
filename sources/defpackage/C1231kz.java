package defpackage;

import cris.prs.webservices.dto.BookingResponseDTO;
import java.util.Comparator;

/* renamed from: kz  reason: default package and case insensitive filesystem */
/* compiled from: TDRTicketFragment */
public final class C1231kz implements Comparator<BookingResponseDTO> {
    public final int compare(Object obj, Object obj2) {
        return ((BookingResponseDTO) obj).getBookingDate().compareTo(((BookingResponseDTO) obj2).getBookingDate());
    }
}
