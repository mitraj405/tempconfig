package defpackage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

/* renamed from: C5  reason: default package */
/* compiled from: CommonMethodUtility */
public final class C5 {
    static {
        C1354qp.R(C5.class);
    }

    public static boolean a(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
        try {
            long time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(simpleDateFormat.format(new Date())).getTime() - simpleDateFormat.parse(simpleDateFormat.format(date)).getTime();
            long j = (time / 1000) % 60;
            long j2 = (time / 60000) % 60;
            long j3 = (time / 3600000) % 24;
            if (j2 > 10) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    public static String b(ArrayList arrayList) {
        if (arrayList != null && arrayList.size() > 0) {
            try {
                if (!((Do) arrayList.get(0)).getKey().equalsIgnoreCase("SEGREGATE_BOOKING_ENQUIRY")) {
                    return null;
                }
                ((Do) arrayList.get(0)).getKey();
                ((Do) arrayList.get(0)).getValue();
                return ((Do) arrayList.get(0)).getValue();
            } catch (Exception e) {
                e.getMessage();
            }
        }
        return null;
    }
}
