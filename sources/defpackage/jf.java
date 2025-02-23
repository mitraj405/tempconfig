package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.MultiInstanceInvalidationService;

/* renamed from: jf  reason: default package */
/* compiled from: IMultiInstanceInvalidationService */
public abstract class jf extends Binder implements IInterface {
    public jf() {
        attachInterface(this, "androidx.room.IMultiInstanceInvalidationService");
    }

    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        Cif ifVar = null;
        if (i == 1) {
            parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
                if (queryLocalInterface == null || !(queryLocalInterface instanceof Cif)) {
                    ifVar = new hf(readStrongBinder);
                } else {
                    ifVar = (Cif) queryLocalInterface;
                }
            }
            int c = ((MultiInstanceInvalidationService.b) this).c(ifVar, parcel.readString());
            parcel2.writeNoException();
            parcel2.writeInt(c);
            return true;
        } else if (i == 2) {
            parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
            IBinder readStrongBinder2 = parcel.readStrongBinder();
            if (readStrongBinder2 != null) {
                IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
                if (queryLocalInterface2 == null || !(queryLocalInterface2 instanceof Cif)) {
                    ifVar = new hf(readStrongBinder2);
                } else {
                    ifVar = (Cif) queryLocalInterface2;
                }
            }
            int readInt = parcel.readInt();
            MultiInstanceInvalidationService.b bVar = (MultiInstanceInvalidationService.b) this;
            synchronized (MultiInstanceInvalidationService.this.a) {
                MultiInstanceInvalidationService.this.a.unregister(ifVar);
                MultiInstanceInvalidationService.this.f2409a.remove(Integer.valueOf(readInt));
            }
            parcel2.writeNoException();
            return true;
        } else if (i == 3) {
            parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
            MultiInstanceInvalidationService.b bVar2 = (MultiInstanceInvalidationService.b) this;
            bVar2.b(parcel.createStringArray(), parcel.readInt());
            return true;
        } else if (i != 1598968902) {
            return super.onTransact(i, parcel, parcel2, i2);
        } else {
            parcel2.writeString("androidx.room.IMultiInstanceInvalidationService");
            return true;
        }
    }

    public final IBinder asBinder() {
        return this;
    }
}
