package defpackage;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* renamed from: AD  reason: default package */
/* compiled from: WidgetContainer */
public class AD extends ConstraintWidget {
    public ArrayList<ConstraintWidget> b = new ArrayList<>();

    public void G() {
        this.b.clear();
        super.G();
    }

    public final void J(y3 y3Var) {
        super.J(y3Var);
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            this.b.get(i).J(y3Var);
        }
    }

    public void U() {
        ArrayList<ConstraintWidget> arrayList = this.b;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ConstraintWidget constraintWidget = this.b.get(i);
                if (constraintWidget instanceof AD) {
                    ((AD) constraintWidget).U();
                }
            }
        }
    }
}
