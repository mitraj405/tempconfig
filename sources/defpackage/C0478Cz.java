package defpackage;

import cris.org.in.ima.fragment.TdrHistoryFragment;
import cris.prs.webservices.dto.BookingResponseDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;

/* renamed from: Cz  reason: default package and case insensitive filesystem */
/* compiled from: TdrHistoryFragment */
public final class C0478Cz implements Comparator<BookingResponseDTO> {
    public final int compare(Object obj, Object obj2) {
        BookingResponseDTO bookingResponseDTO = (BookingResponseDTO) obj;
        BookingResponseDTO bookingResponseDTO2 = (BookingResponseDTO) obj2;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
        try {
            return simpleDateFormat.parse(bookingResponseDTO.getTdrFilingDate().replace("HRS", "")).compareTo(simpleDateFormat.parse(bookingResponseDTO2.getTdrFilingDate().replace("HRS", "")));
        } catch (ParseException e) {
            int i = TdrHistoryFragment.c;
            e.getMessage();
            return 0;
        }
    }
}
