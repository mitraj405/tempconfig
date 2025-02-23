package defpackage;

import cris.prs.webservices.dto.BookingResponseDTO;
import java.util.Comparator;

/* renamed from: w4  reason: default package and case insensitive filesystem */
/* compiled from: CancellationHistoryFragment */
public final class C1451w4 implements Comparator<BookingResponseDTO> {
    public final int compare(Object obj, Object obj2) {
        return ((BookingResponseDTO) obj).getCancellationDate().compareTo(((BookingResponseDTO) obj2).getCancellationDate());
    }
}
