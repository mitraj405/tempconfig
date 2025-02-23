package com.cyberfend.cyfsecurity;

import com.cyberfend.cyfsecurity.CCADialogActivity;

public final class a implements Runnable {
    public final /* synthetic */ float a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ CCADialogActivity.a f2787a;

    public a(CCADialogActivity.a aVar, float f) {
        this.f2787a = aVar;
        this.a = f;
    }

    public final void run() {
        CCADialogActivity.this.f2781a.setProgress(this.a);
    }
}
