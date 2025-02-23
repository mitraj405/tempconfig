package com.momagic;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.momagic.g  reason: case insensitive filesystem */
/* compiled from: AdvertisingIdClient */
public final class C0834g {
    public static final /* synthetic */ int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public Handler f4043a;

    /* renamed from: a  reason: collision with other field name */
    public e f4044a;

    /* renamed from: com.momagic.g$a */
    /* compiled from: AdvertisingIdClient */
    public class a implements Runnable {
        public a(Exception exc) {
        }

        public final void run() {
            if (C0834g.this.f4044a != null) {
                Context context = C0835h.f4046a;
                new Handler(Looper.getMainLooper()).post(new P7(new Exception("DATB - Error: context null")));
            }
        }
    }

    /* renamed from: com.momagic.g$b */
    /* compiled from: AdvertisingIdClient */
    public class b {
        public final String a;

        public b(String str) {
            this.a = str;
        }
    }

    /* renamed from: com.momagic.g$d */
    /* compiled from: AdvertisingIdClient */
    public class d implements IInterface {
        public final IBinder a;

        public d(IBinder iBinder) {
            this.a = iBinder;
        }

        public final IBinder asBinder() {
            return this.a;
        }

        public final String b() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final boolean c() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z = true;
                obtain.writeInt(1);
                this.a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                return z;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    /* renamed from: com.momagic.g$e */
    /* compiled from: AdvertisingIdClient */
    public interface e {
    }

    public final void a(Exception exc) {
        Objects.toString(exc);
        this.f4043a.post(new a(exc));
    }

    public final void b(Context context, l lVar) {
        this.f4043a = new Handler(Looper.getMainLooper());
        this.f4044a = lVar;
        if (context == null) {
            a(new Exception("g".concat(" - Error: context null")));
        } else {
            new Thread(new C0832e(this, context)).start();
        }
    }

    /* renamed from: com.momagic.g$c */
    /* compiled from: AdvertisingIdClient */
    public class c implements ServiceConnection {
        public final LinkedBlockingQueue<IBinder> a = new LinkedBlockingQueue<>(1);

        /* renamed from: a  reason: collision with other field name */
        public boolean f4045a = false;

        public final IBinder a() throws InterruptedException {
            if (!this.f4045a) {
                this.f4045a = true;
                return this.a.take();
            }
            throw new IllegalStateException();
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.a.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }
}
