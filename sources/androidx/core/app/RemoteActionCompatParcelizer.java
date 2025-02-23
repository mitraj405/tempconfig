package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;

public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(C0177eC eCVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        Object obj = remoteActionCompat.f1755a;
        if (eCVar.h(1)) {
            obj = eCVar.n();
        }
        remoteActionCompat.f1755a = (IconCompat) obj;
        CharSequence charSequence = remoteActionCompat.f1756a;
        if (eCVar.h(2)) {
            charSequence = eCVar.g();
        }
        remoteActionCompat.f1756a = charSequence;
        CharSequence charSequence2 = remoteActionCompat.b;
        if (eCVar.h(3)) {
            charSequence2 = eCVar.g();
        }
        remoteActionCompat.b = charSequence2;
        remoteActionCompat.a = (PendingIntent) eCVar.l(remoteActionCompat.a, 4);
        boolean z = remoteActionCompat.f1757a;
        if (eCVar.h(5)) {
            z = eCVar.e();
        }
        remoteActionCompat.f1757a = z;
        boolean z2 = remoteActionCompat.f1758b;
        if (eCVar.h(6)) {
            z2 = eCVar.e();
        }
        remoteActionCompat.f1758b = z2;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, C0177eC eCVar) {
        eCVar.getClass();
        IconCompat iconCompat = remoteActionCompat.f1755a;
        eCVar.o(1);
        eCVar.w(iconCompat);
        CharSequence charSequence = remoteActionCompat.f1756a;
        eCVar.o(2);
        eCVar.r(charSequence);
        CharSequence charSequence2 = remoteActionCompat.b;
        eCVar.o(3);
        eCVar.r(charSequence2);
        PendingIntent pendingIntent = remoteActionCompat.a;
        eCVar.o(4);
        eCVar.u(pendingIntent);
        boolean z = remoteActionCompat.f1757a;
        eCVar.o(5);
        eCVar.p(z);
        boolean z2 = remoteActionCompat.f1758b;
        eCVar.o(6);
        eCVar.p(z2);
    }
}
