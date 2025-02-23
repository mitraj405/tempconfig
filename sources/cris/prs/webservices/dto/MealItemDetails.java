package cris.prs.webservices.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class MealItemDetails implements Serializable {
    private static final long serialVersionUID = 1;
    private String availableFromTime;
    private String availableToTime;
    private String mealCode;
    private String mealDetails;
    private int mealId;
    private String mealName;
    private float mealRate;
    private String mealType;
    private int mealTypeId;
    private int quantity;
    private String servingTiming;

    public String getAvailableFromTime() {
        return this.availableFromTime;
    }

    public String getAvailableToTime() {
        return this.availableToTime;
    }

    public String getMealCode() {
        return this.mealCode;
    }

    public String getMealDetails() {
        return this.mealDetails;
    }

    public int getMealId() {
        return this.mealId;
    }

    public String getMealName() {
        return this.mealName;
    }

    public float getMealRate() {
        return this.mealRate;
    }

    public String getMealType() {
        return this.mealType;
    }

    public int getMealTypeId() {
        return this.mealTypeId;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getServingTiming() {
        return this.servingTiming;
    }

    public void setAvailableFromTime(String str) {
        this.availableFromTime = str;
    }

    public void setAvailableToTime(String str) {
        this.availableToTime = str;
    }

    public void setMealCode(String str) {
        this.mealCode = str;
    }

    public void setMealDetails(String str) {
        this.mealDetails = str;
    }

    public void setMealId(int i) {
        this.mealId = i;
    }

    public void setMealName(String str) {
        this.mealName = str;
    }

    public void setMealRate(float f) {
        this.mealRate = f;
    }

    public void setMealType(String str) {
        this.mealType = str;
    }

    public void setMealTypeId(int i) {
        this.mealTypeId = i;
    }

    public void setQuantity(int i) {
        this.quantity = i;
    }

    public void setServingTiming(String str) {
        this.servingTiming = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MealItemDetails [mealId=");
        sb.append(this.mealId);
        sb.append(", mealCode=");
        sb.append(this.mealCode);
        sb.append(", mealName=");
        sb.append(this.mealName);
        sb.append(", mealType=");
        sb.append(this.mealType);
        sb.append(", quantity=");
        sb.append(this.quantity);
        sb.append(", mealTypeId=");
        sb.append(this.mealTypeId);
        sb.append(", servingTiming=");
        sb.append(this.servingTiming);
        sb.append(", mealRate=");
        sb.append(this.mealRate);
        sb.append(", availableFromTime=");
        sb.append(this.availableFromTime);
        sb.append(", availableToTime=");
        return C0709Uj.j(sb, this.availableToTime, "]");
    }
}
