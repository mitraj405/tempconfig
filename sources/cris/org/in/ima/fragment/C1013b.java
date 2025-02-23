package cris.org.in.ima.fragment;

import cris.org.in.ima.fragment.AadhaarKYCFragment;

/* renamed from: cris.org.in.ima.fragment.b  reason: case insensitive filesystem */
/* compiled from: AadhaarKYCFragment */
public final class C1013b implements Runnable {
    public final /* synthetic */ AadhaarKYCFragment.e a;

    public C1013b(AadhaarKYCFragment.e eVar) {
        this.a = eVar;
    }

    public final void run() {
        AadhaarKYCFragment.this.resendOtp.setVisibility(0);
    }
}
