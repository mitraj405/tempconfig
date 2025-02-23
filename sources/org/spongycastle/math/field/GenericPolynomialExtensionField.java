package org.spongycastle.math.field;

import java.math.BigInteger;

class GenericPolynomialExtensionField implements PolynomialExtensionField {
    public final FiniteField a;

    /* renamed from: a  reason: collision with other field name */
    public final Polynomial f6641a;

    public GenericPolynomialExtensionField(FiniteField finiteField, Polynomial polynomial) {
        this.a = finiteField;
        this.f6641a = polynomial;
    }

    public final int a() {
        return this.f6641a.b() * this.a.a();
    }

    public final BigInteger b() {
        return this.a.b();
    }

    public final Polynomial c() {
        return this.f6641a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GenericPolynomialExtensionField)) {
            return false;
        }
        GenericPolynomialExtensionField genericPolynomialExtensionField = (GenericPolynomialExtensionField) obj;
        if (!this.a.equals(genericPolynomialExtensionField.a) || !this.f6641a.equals(genericPolynomialExtensionField.f6641a)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode() ^ Integer.rotateLeft(this.f6641a.hashCode(), 16);
    }
}
