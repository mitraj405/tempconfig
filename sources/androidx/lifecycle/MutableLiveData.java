package androidx.lifecycle;

public class MutableLiveData<T> extends LiveData<T> {
    public void i(T t) {
        super.i(t);
    }

    public final void j(T t) {
        boolean z;
        synchronized (this.f2188a) {
            if (this.c == LiveData.d) {
                z = true;
            } else {
                z = false;
            }
            this.c = t;
        }
        if (z) {
            G1.d().e(this.f2187a);
        }
    }
}
