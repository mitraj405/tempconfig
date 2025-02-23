package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.messaging.Constants;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
public class DataBufferSafeParcelable<T extends SafeParcelable> extends AbstractDataBuffer<T> {
    private static final String[] zaa = {Constants.ScionAnalytics.MessageType.DATA_MESSAGE};
    private final Parcelable.Creator<T> zab;

    @KeepForSdk
    public DataBufferSafeParcelable(DataHolder dataHolder, Parcelable.Creator<T> creator) {
        super(dataHolder);
        this.zab = creator;
    }

    @KeepForSdk
    public static <T extends SafeParcelable> void addValue(DataHolder.Builder builder, T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, obtain.marshall());
        builder.withRow(contentValues);
        obtain.recycle();
    }

    @KeepForSdk
    public static DataHolder.Builder buildDataHolder() {
        return DataHolder.builder(zaa);
    }

    @KeepForSdk
    public T get(int i) {
        DataHolder dataHolder = (DataHolder) Preconditions.checkNotNull(this.mDataHolder);
        byte[] byteArray = dataHolder.getByteArray(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, i, dataHolder.getWindowIndex(i));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(byteArray, 0, byteArray.length);
        obtain.setDataPosition(0);
        T t = (SafeParcelable) this.zab.createFromParcel(obtain);
        obtain.recycle();
        return t;
    }
}
