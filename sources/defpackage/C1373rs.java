package defpackage;

import android.widget.TextView;

/* renamed from: rs  reason: default package and case insensitive filesystem */
/* compiled from: RadioHelper */
public final class C1373rs implements Runnable {
    public final /* synthetic */ C1355qs a;

    public C1373rs(C1355qs qsVar) {
        this.a = qsVar;
    }

    public final void run() {
        C1355qs qsVar = this.a;
        qsVar.f6926a.e(C0501Er.radioHelper, Boolean.TRUE);
        ((TextView) qsVar.a.findViewById(C0501Er.radio_button1)).setText(qsVar.f6927a.get("option1"));
        ((TextView) qsVar.a.findViewById(C0501Er.radio_button2)).setText(qsVar.f6927a.get("option2"));
    }
}
