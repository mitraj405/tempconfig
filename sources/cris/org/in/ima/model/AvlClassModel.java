package cris.org.in.ima.model;

import java.io.Serializable;

public final class AvlClassModel implements Serializable {
    public Boolean a;
    public final String c;

    public AvlClassModel(String str) {
        Boolean bool = Boolean.FALSE;
        this.c = str;
        this.a = bool;
    }

    public final String toString() {
        return "AvlClassModel{avlClass='" + this.c + "', selected=" + this.a + '}';
    }
}
