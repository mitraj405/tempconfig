package in.juspay.hypersmshandler;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ SmsConsentHandler a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ SmsReceiver f5514a;

    public /* synthetic */ e(SmsReceiver smsReceiver, SmsConsentHandler smsConsentHandler) {
        this.f5514a = smsReceiver;
        this.a = smsConsentHandler;
    }

    public final void run() {
        this.f5514a.a(this.a);
    }
}
