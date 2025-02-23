package defpackage;

import java.io.Serializable;

/* renamed from: Df  reason: default package */
/* compiled from: InfantDTO */
public final class Df implements Serializable {
    private static final long serialVersionUID = 1;
    private Byte age;
    private String gender;
    private Short infantSerialNumber;
    private String name;

    public Byte getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    public Short getInfantSerialNumber() {
        return this.infantSerialNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(Byte b) {
        this.age = b;
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public void setInfantSerialNumber(Short sh) {
        this.infantSerialNumber = sh;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "InfantDTO [infantSerialNumber=" + this.infantSerialNumber + ", name=" + this.name + ", gender=" + this.gender + ", age=" + this.age + "]";
    }
}
