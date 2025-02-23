package defpackage;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* renamed from: Te  reason: default package */
/* compiled from: HelperWidget */
public class Te extends ConstraintWidget implements Re {
    public int B = 0;
    public ConstraintWidget[] c = new ConstraintWidget[4];

    public final void U(int i, BD bd, ArrayList arrayList) {
        for (int i2 = 0; i2 < this.B; i2++) {
            ConstraintWidget constraintWidget = this.c[i2];
            ArrayList<ConstraintWidget> arrayList2 = bd.f46a;
            if (!arrayList2.contains(constraintWidget)) {
                arrayList2.add(constraintWidget);
            }
        }
        for (int i3 = 0; i3 < this.B; i3++) {
            C0096He.a(this.c[i3], i, arrayList, bd);
        }
    }

    public final void a() {
        this.B = 0;
        Arrays.fill(this.c, (Object) null);
    }

    public final void c(ConstraintWidget constraintWidget) {
        if (constraintWidget != this && constraintWidget != null) {
            int i = this.B + 1;
            ConstraintWidget[] constraintWidgetArr = this.c;
            if (i > constraintWidgetArr.length) {
                this.c = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
            }
            ConstraintWidget[] constraintWidgetArr2 = this.c;
            int i2 = this.B;
            constraintWidgetArr2[i2] = constraintWidget;
            this.B = i2 + 1;
        }
    }

    public void j(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.j(constraintWidget, hashMap);
        Te te = (Te) constraintWidget;
        this.B = 0;
        int i = te.B;
        for (int i2 = 0; i2 < i; i2++) {
            c(hashMap.get(te.c[i2]));
        }
    }

    public void b() {
    }
}
