package cris.prs.webservices.dto;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public final class MealDetails implements Serializable {
    private static final long serialVersionUID = 1;
    private ArrayList<MealItemDetails> mealDetailList = new ArrayList<>();
    private String mealType;
    private String servingTiming;

    public ArrayList<MealItemDetails> getMealDetailList() {
        return this.mealDetailList;
    }

    public String getMealType() {
        return this.mealType;
    }

    public String getServingTiming() {
        return this.servingTiming;
    }

    public void setMealDetailList(ArrayList<MealItemDetails> arrayList) {
        this.mealDetailList = arrayList;
    }

    public void setMealType(String str) {
        this.mealType = str;
    }

    public void setServingTiming(String str) {
        this.servingTiming = str;
    }

    public String toString() {
        return "MealDetails [mealType=" + this.mealType + ", servingTiming=" + this.servingTiming + ", mealDetailList=" + this.mealDetailList + "]";
    }
}
