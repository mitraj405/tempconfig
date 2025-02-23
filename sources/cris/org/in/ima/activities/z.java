package cris.org.in.ima.activities;

import android.content.DialogInterface;
import android.content.Intent;
import cris.org.in.ima.activities.MasterPassengerNewActivity;

/* compiled from: MasterPassengerNewActivity */
public final class z implements DialogInterface.OnClickListener {
    public final /* synthetic */ MasterPassengerNewActivity.h a;

    public z(MasterPassengerNewActivity.h hVar) {
        this.a = hVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        MasterPassengerNewActivity.h hVar = this.a;
        MasterPassengerNewActivity.this.setResult(0, intent);
        MasterPassengerNewActivity.this.finish();
    }
}
