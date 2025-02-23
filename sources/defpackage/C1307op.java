package defpackage;

import android.content.DialogInterface;
import android.os.Bundle;
import com.paytm.pgsdk.PaytmPaymentTransactionCallback;
import cris.org.in.ima.fragment.MakePaymentNewFragment;
import cris.org.in.prs.ima.R;
import java.util.ArrayList;

/* renamed from: op  reason: default package and case insensitive filesystem */
/* compiled from: PaytmService */
public final class C1307op implements PaytmPaymentTransactionCallback {
    public final /* synthetic */ C1332pp a;

    public C1307op(C1332pp ppVar) {
        this.a = ppVar;
    }

    public final void clientAuthenticationFailed(String str) {
        int i = C1332pp.c;
        C1332pp ppVar = this.a;
        C0535I5.m(ppVar.a.getContext(), false, "Authentication failed", ppVar.a.getContext().getString(R.string.error), "OK", (DialogInterface.OnClickListener) null).show();
    }

    public final void networkNotAvailable() {
        int i = C1332pp.c;
        C1332pp ppVar = this.a;
        C0535I5.m(ppVar.a.getContext(), false, ppVar.a.getContext().getString(R.string.data_connection_error_message), ppVar.a.getContext().getString(R.string.error), "OK", (DialogInterface.OnClickListener) null).show();
    }

    public final void onBackPressedCancelTransaction() {
        int i = C1332pp.c;
        C0535I5.u0(this.a.a.getActivity());
    }

    public final void onErrorLoadingWebPage(int i, String str, String str2) {
        int i2 = C1332pp.c;
        C1332pp ppVar = this.a;
        C0535I5.m(ppVar.a.getContext(), false, "Error loading web page", ppVar.a.getContext().getString(R.string.error), "OK", (DialogInterface.OnClickListener) null).show();
    }

    public final void onPaytmTransactionTimeout(String str, int i) {
        int i2 = C1332pp.c;
        C1332pp ppVar = this.a;
        C0535I5.m(ppVar.a.getContext(), false, "Transaction timed out", ppVar.a.getContext().getString(R.string.error), "OK", (DialogInterface.OnClickListener) null).show();
    }

    public final void onTransactionFailure(String str, Bundle bundle) {
        int i = C1332pp.c;
        C1332pp ppVar = this.a;
        C0535I5.m(ppVar.a.getContext(), false, bundle.getString("RESPMSG"), ppVar.a.getContext().getString(R.string.error), "OK", (DialogInterface.OnClickListener) null).show();
    }

    public final void onTransactionSuccess(Bundle bundle) {
        int i = C1332pp.c;
        bundle.getString("STATUS");
        C0657Qt.h();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Do("STATUS", bundle.getString("STATUS")));
        arrayList.add(new Do("BANKNAME", bundle.getString("BANKNAME")));
        arrayList.add(new Do("ORDERID", bundle.getString("ORDERID")));
        arrayList.add(new Do("TXNAMOUNT", bundle.getString("TXNAMOUNT")));
        arrayList.add(new Do("TXNDATE", bundle.getString("TXNDATE")));
        arrayList.add(new Do("MID", bundle.getString("MID")));
        arrayList.add(new Do("TXNID", bundle.getString("TXNID")));
        arrayList.add(new Do("RESPCODE", bundle.getString("RESPCODE")));
        arrayList.add(new Do("PAYMENTMODE", bundle.getString("PAYMENTMODE")));
        arrayList.add(new Do("BANKTXNID", bundle.getString("BANKTXNID")));
        arrayList.add(new Do("CURRENCY", bundle.getString("CURRENCY")));
        arrayList.add(new Do("GATEWAYNAME", bundle.getString("GATEWAYNAME")));
        arrayList.add(new Do("IS_CHECKSUM_VALID", bundle.getString("IS_CHECKSUM_VALID")));
        arrayList.add(new Do("RESPMSG", bundle.getString("RESPMSG")));
        C1480xl.f7038a.c((MakePaymentNewFragment) this.a.a, arrayList);
    }

    public final void someUIErrorOccurred(String str) {
        int i = C1332pp.c;
        C1332pp ppVar = this.a;
        C0535I5.m(ppVar.a.getContext(), false, "Some UI error occurred", ppVar.a.getContext().getString(R.string.error), "OK", (DialogInterface.OnClickListener) null).show();
    }
}
