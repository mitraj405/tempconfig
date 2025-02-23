package defpackage;

import cris.prs.webservices.dto.MealDetails;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
/* renamed from: Lk  reason: default package */
/* compiled from: MealDetailsDTO */
public final class Lk implements Serializable {
    private static final long serialVersionUID = 1;
    private List<MealDetails> mealDetailList = new ArrayList();
    private String trainNo;

    public List<MealDetails> getMealDetailList() {
        return this.mealDetailList;
    }

    public String getTrainNo() {
        return this.trainNo;
    }

    public void setMealDetailList(List<MealDetails> list) {
        this.mealDetailList = list;
    }

    public void setTrainNo(String str) {
        this.trainNo = str;
    }

    public String toString() {
        return "MealDetailsDTO [trainNo=" + this.trainNo + ", mealDetailList=" + this.mealDetailList + "]";
    }
}
