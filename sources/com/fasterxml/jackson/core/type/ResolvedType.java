package com.fasterxml.jackson.core.type;

public abstract class ResolvedType {
    public abstract ResolvedType getReferencedType();

    public boolean isReferenceType() {
        if (getReferencedType() != null) {
            return true;
        }
        return false;
    }

    public abstract String toCanonical();
}
