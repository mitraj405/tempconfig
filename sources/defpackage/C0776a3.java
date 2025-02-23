package defpackage;

import cris.prs.webservices.dto.PassengerDetailDTO;
import java.util.Comparator;

/* renamed from: a3  reason: default package and case insensitive filesystem */
/* compiled from: BookMealFragment */
public final class C0776a3 implements Comparator<PassengerDetailDTO> {
    public final int compare(Object obj, Object obj2) {
        if (((PassengerDetailDTO) obj).getPassengerSerialNumber().shortValue() >= ((PassengerDetailDTO) obj2).getPassengerSerialNumber().shortValue()) {
            return 1;
        }
        return -1;
    }
}
