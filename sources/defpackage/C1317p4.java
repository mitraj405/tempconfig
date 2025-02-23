package defpackage;

import cris.prs.webservices.dto.BookingResponseDTO;
import java.util.Comparator;

/* renamed from: p4  reason: default package and case insensitive filesystem */
/* compiled from: CancelTktFragment */
public final class C1317p4 implements Comparator<BookingResponseDTO> {
    public final int compare(Object obj, Object obj2) {
        return ((BookingResponseDTO) obj).getBookingDate().compareTo(((BookingResponseDTO) obj2).getBookingDate());
    }
}
