package defpackage;

import cris.prs.webservices.dto.BookingResponseDTO;
import java.util.Comparator;

/* renamed from: v4  reason: default package and case insensitive filesystem */
/* compiled from: CancellationHistoryFragment */
public final class C1435v4 implements Comparator<BookingResponseDTO> {
    public final int compare(Object obj, Object obj2) {
        return ((BookingResponseDTO) obj).getJourneyDate().compareTo(((BookingResponseDTO) obj2).getJourneyDate());
    }
}
