package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.core.content.UnusedAppRestrictionsBackportService;

/* renamed from: qf  reason: default package */
/* compiled from: IUnusedAppRestrictionsBackportService */
public interface qf extends IInterface {
    public static final String b = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportService".replace('$', '.');

    /* renamed from: qf$a */
    /* compiled from: IUnusedAppRestrictionsBackportService */
    public static abstract class a extends Binder implements qf {
        public a() {
            attachInterface(this, qf.b);
        }

        public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            pf pfVar;
            String str = qf.b;
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i == 1598968902) {
                parcel2.writeString(str);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    pfVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface(pf.a);
                    if (queryLocalInterface == null || !(queryLocalInterface instanceof pf)) {
                        pfVar = new of(readStrongBinder);
                    } else {
                        pfVar = (pf) queryLocalInterface;
                    }
                }
                UnusedAppRestrictionsBackportService.a aVar = (UnusedAppRestrictionsBackportService.a) this;
                if (pfVar != null) {
                    UnusedAppRestrictionsBackportService.this.a();
                }
                return true;
            }
        }

        public final IBinder asBinder() {
            return this;
        }
    }
}
