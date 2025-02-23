package cris.org.in.ima.fragment;

import cris.prs.webservices.dto.PassengerDetailDTO;
import java.util.Comparator;

/* renamed from: cris.org.in.ima.fragment.r0  reason: case insensitive filesystem */
/* compiled from: TDRTicketDetailsFragment */
public final class C1045r0 implements Comparator<PassengerDetailDTO> {
    public final int compare(Object obj, Object obj2) {
        if (((PassengerDetailDTO) obj).getPassengerSerialNumber().shortValue() >= ((PassengerDetailDTO) obj2).getPassengerSerialNumber().shortValue()) {
            return 1;
        }
        return -1;
    }
}
