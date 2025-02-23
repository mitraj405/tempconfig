package defpackage;

import cris.prs.webservices.dto.BookingResponseDTO;
import java.util.Comparator;

/* renamed from: Mb  reason: default package and case insensitive filesystem */
/* compiled from: FailedTxnHistoryFragment */
public final class C0590Mb implements Comparator<BookingResponseDTO> {
    public final int compare(Object obj, Object obj2) {
        return -((BookingResponseDTO) obj).getJourneyDate().compareTo(((BookingResponseDTO) obj2).getJourneyDate());
    }
}
