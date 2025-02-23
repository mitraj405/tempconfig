package cris.org.in.ima.model;

import defpackage.C1262mo;

public final class PaymentOptionModel {
    public C1262mo.a a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f5340a = false;

    public final C1262mo.a a() {
        return this.a;
    }

    public final void b() {
        this.f5340a = true;
    }

    public final void c(C1262mo.a aVar) {
        this.a = aVar;
    }

    public final String toString() {
        return "PaymentOptionModel{isChecked=" + this.f5340a + ", options=" + this.a + '}';
    }
}
