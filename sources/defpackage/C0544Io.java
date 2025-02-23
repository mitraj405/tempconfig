package defpackage;

import cris.prs.webservices.dto.MealItemDetails;
import java.util.Comparator;

/* renamed from: Io  reason: default package and case insensitive filesystem */
/* compiled from: PassengerDetailFragment */
public final class C0544Io implements Comparator<MealItemDetails> {
    public final int compare(Object obj, Object obj2) {
        MealItemDetails mealItemDetails = (MealItemDetails) obj;
        MealItemDetails mealItemDetails2 = (MealItemDetails) obj2;
        if (mealItemDetails.getMealTypeId() > mealItemDetails2.getMealTypeId()) {
            return 1;
        }
        if (mealItemDetails.getMealTypeId() < mealItemDetails2.getMealTypeId()) {
            return -1;
        }
        return 0;
    }
}
