package defpackage;

import cris.prs.webservices.dto.BookingResponseDTO;
import java.util.Comparator;

/* renamed from: Nb  reason: default package and case insensitive filesystem */
/* compiled from: FailedTxnHistoryFragment */
public final class C0606Nb implements Comparator<BookingResponseDTO> {
    public final int compare(Object obj, Object obj2) {
        return -((BookingResponseDTO) obj).getTransactionDate().compareTo(((BookingResponseDTO) obj2).getTransactionDate());
    }
}
