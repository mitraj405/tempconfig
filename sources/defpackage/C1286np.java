package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.paytm.pgsdk.PaytmClientCertificate;
import com.paytm.pgsdk.PaytmMerchant;
import com.paytm.pgsdk.PaytmPGActivity;
import com.paytm.pgsdk.PaytmPaymentTransactionCallback;
import java.util.Map;

/* renamed from: np  reason: default package and case insensitive filesystem */
/* compiled from: PaytmPGService */
public final class C1286np {
    public static volatile C1286np a;

    /* renamed from: a  reason: collision with other field name */
    public volatile PaytmClientCertificate f5601a;

    /* renamed from: a  reason: collision with other field name */
    public volatile PaytmMerchant f5602a;

    /* renamed from: a  reason: collision with other field name */
    public volatile PaytmPaymentTransactionCallback f5603a;

    /* renamed from: a  reason: collision with other field name */
    public volatile String f5604a;

    /* renamed from: a  reason: collision with other field name */
    public volatile nh f5605a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f5606a;
    public volatile String b;

    public static synchronized C1286np a() {
        C1286np npVar;
        synchronized (C1286np.class) {
            try {
                if (a == null) {
                    synchronized (C1354qp.class) {
                    }
                    a = new C1286np();
                    synchronized (C1354qp.class) {
                    }
                }
            } catch (Exception e) {
                C1354qp.i0(e);
            }
            npVar = a;
        }
        return npVar;
    }

    public final synchronized void b(Context context, boolean z, boolean z2, boolean z3, PaytmPaymentTransactionCallback paytmPaymentTransactionCallback) {
        try {
            if (!C1354qp.a0(context)) {
                c();
                paytmPaymentTransactionCallback.networkNotAvailable();
            } else if (!this.f5606a) {
                Bundle bundle = new Bundle();
                if (this.f5605a != null) {
                    for (Map.Entry entry : ((Map) this.f5605a.a).entrySet()) {
                        String str = (String) entry.getKey();
                        String str2 = (String) entry.getValue();
                        synchronized (C1354qp.class) {
                        }
                        bundle.putString((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                if (!(this.f5602a == null || this.f5602a.mChecksumGenerationURL == null || this.f5602a.mChecksumGenerationURL.length() <= 0)) {
                    this.f5604a = this.f5602a.mChecksumGenerationURL;
                }
                synchronized (C1354qp.class) {
                }
                Intent intent = new Intent(context, PaytmPGActivity.class);
                intent.putExtra("Parameters", bundle);
                intent.putExtra("HIDE_HEADER", z);
                intent.putExtra("HIDE_ARROW", z2);
                intent.putExtra("SEND_ALL_CHECKSUM_RESPONSE_PARAMETERS_TO_PG_SERVER", z3);
                this.f5606a = true;
                this.f5603a = paytmPaymentTransactionCallback;
                ((Activity) context).startActivity(intent);
                synchronized (C1354qp.class) {
                }
            }
        } catch (Exception e) {
            c();
            C1354qp.i0(e);
        }
        return;
    }

    public final synchronized void c() {
        a = null;
        synchronized (C1354qp.class) {
        }
    }
}
