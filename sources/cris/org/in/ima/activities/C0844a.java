package cris.org.in.ima.activities;

import android.content.DialogInterface;
import android.content.Intent;
import cris.org.in.ima.activities.FavouriteJourneyActivity;

/* renamed from: cris.org.in.ima.activities.a  reason: case insensitive filesystem */
/* compiled from: FavouriteJourneyActivity */
public final class C0844a implements DialogInterface.OnClickListener {
    public final /* synthetic */ FavouriteJourneyActivity.d a;

    public C0844a(FavouriteJourneyActivity.d dVar) {
        this.a = dVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        FavouriteJourneyActivity.d dVar = this.a;
        FavouriteJourneyActivity.this.setResult(0, intent);
        FavouriteJourneyActivity.this.finish();
    }
}
