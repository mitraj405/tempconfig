package defpackage;

import android.view.View;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* renamed from: Iw  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0433Iw implements AccessibilityViewCommand {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ SideSheetBehavior f3504a;

    public /* synthetic */ C0433Iw(SideSheetBehavior sideSheetBehavior, int i) {
        this.f3504a = sideSheetBehavior;
        this.a = i;
    }

    public final boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        return this.f3504a.lambda$createAccessibilityViewCommandForState$2(this.a, view, commandArguments);
    }
}
