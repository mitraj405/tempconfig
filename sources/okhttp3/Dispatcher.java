package okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.RealCall;
import okhttp3.internal.Util;

public final class Dispatcher {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private ExecutorService executorService;
    private Runnable idleCallback;
    private int maxRequests = 64;
    private int maxRequestsPerHost = 5;
    private final Deque<RealCall.AsyncCall> readyAsyncCalls = new ArrayDeque();
    private final Deque<RealCall.AsyncCall> runningAsyncCalls = new ArrayDeque();
    private final Deque<RealCall> runningSyncCalls = new ArrayDeque();

    public Dispatcher(ExecutorService executorService2) {
        this.executorService = executorService2;
    }

    private RealCall.AsyncCall findExistingCallWithHost(String str) {
        for (RealCall.AsyncCall next : this.runningAsyncCalls) {
            if (next.host().equals(str)) {
                return next;
            }
        }
        for (RealCall.AsyncCall next2 : this.readyAsyncCalls) {
            if (next2.host().equals(str)) {
                return next2;
            }
        }
        return null;
    }

    private boolean promoteAndExecute() {
        int i;
        boolean z;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<RealCall.AsyncCall> it = this.readyAsyncCalls.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                RealCall.AsyncCall next = it.next();
                if (this.runningAsyncCalls.size() >= this.maxRequests) {
                    break;
                } else if (next.callsPerHost().get() < this.maxRequestsPerHost) {
                    it.remove();
                    next.callsPerHost().incrementAndGet();
                    arrayList.add(next);
                    this.runningAsyncCalls.add(next);
                }
            }
            if (runningCallsCount() > 0) {
                z = true;
            } else {
                z = false;
            }
        }
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((RealCall.AsyncCall) arrayList.get(i)).executeOn(executorService());
        }
        return z;
    }

    public synchronized void cancelAll() {
        for (RealCall.AsyncCall asyncCall : this.readyAsyncCalls) {
            asyncCall.get().cancel();
        }
        for (RealCall.AsyncCall asyncCall2 : this.runningAsyncCalls) {
            asyncCall2.get().cancel();
        }
        for (RealCall cancel : this.runningSyncCalls) {
            cancel.cancel();
        }
    }

    public void enqueue(RealCall.AsyncCall asyncCall) {
        RealCall.AsyncCall findExistingCallWithHost;
        synchronized (this) {
            this.readyAsyncCalls.add(asyncCall);
            if (!asyncCall.get().forWebSocket && (findExistingCallWithHost = findExistingCallWithHost(asyncCall.host())) != null) {
                asyncCall.reuseCallsPerHostFrom(findExistingCallWithHost);
            }
        }
        promoteAndExecute();
    }

    public synchronized void executed(RealCall realCall) {
        this.runningSyncCalls.add(realCall);
    }

    public synchronized ExecutorService executorService() {
        if (this.executorService == null) {
            this.executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false));
        }
        return this.executorService;
    }

    public void finished(RealCall.AsyncCall asyncCall) {
        asyncCall.callsPerHost().decrementAndGet();
        finished(this.runningAsyncCalls, asyncCall);
    }

    public synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    public synchronized int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    public synchronized List<Call> queuedCalls() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (RealCall.AsyncCall asyncCall : this.readyAsyncCalls) {
            arrayList.add(asyncCall.get());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized int queuedCallsCount() {
        return this.readyAsyncCalls.size();
    }

    public synchronized List<Call> runningCalls() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.runningSyncCalls);
        for (RealCall.AsyncCall asyncCall : this.runningAsyncCalls) {
            arrayList.add(asyncCall.get());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized int runningCallsCount() {
        return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
    }

    public synchronized void setIdleCallback(Runnable runnable) {
        this.idleCallback = runnable;
    }

    public void setMaxRequests(int i) {
        if (i >= 1) {
            synchronized (this) {
                this.maxRequests = i;
            }
            promoteAndExecute();
            return;
        }
        throw new IllegalArgumentException(lf.h("max < 1: ", i));
    }

    public void setMaxRequestsPerHost(int i) {
        if (i >= 1) {
            synchronized (this) {
                this.maxRequestsPerHost = i;
            }
            promoteAndExecute();
            return;
        }
        throw new IllegalArgumentException(lf.h("max < 1: ", i));
    }

    public void finished(RealCall realCall) {
        finished(this.runningSyncCalls, realCall);
    }

    private <T> void finished(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t)) {
                runnable = this.idleCallback;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (!promoteAndExecute() && runnable != null) {
            runnable.run();
        }
    }

    public Dispatcher() {
    }
}
