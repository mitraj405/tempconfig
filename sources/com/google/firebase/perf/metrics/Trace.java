package com.google.firebase.perf.metrics;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.google.firebase.perf.FirebasePerformanceAttributable;
import com.google.firebase.perf.application.AppStateMonitor;
import com.google.firebase.perf.application.AppStateUpdateHandler;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.metrics.validator.PerfMetricValidator;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.session.SessionAwareObject;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Clock;
import com.google.firebase.perf.util.Timer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Trace extends AppStateUpdateHandler implements Parcelable, FirebasePerformanceAttributable, SessionAwareObject {
    @Keep
    public static final Parcelable.Creator<Trace> CREATOR = new Parcelable.Creator<Trace>() {
        public Trace createFromParcel(Parcel parcel) {
            return new Trace(parcel, false);
        }

        public Trace[] newArray(int i) {
            return new Trace[i];
        }
    };
    static final Parcelable.Creator<Trace> CREATOR_DATAONLY = new Parcelable.Creator<Trace>() {
        public Trace createFromParcel(Parcel parcel) {
            return new Trace(parcel, true);
        }

        public Trace[] newArray(int i) {
            return new Trace[i];
        }
    };
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private static final Map<String, Trace> traceNameToTraceMap = new ConcurrentHashMap();
    private final Clock clock;
    private final Map<String, Counter> counterNameToCounterMap;
    private final Map<String, String> customAttributesMap;
    private Timer endTime;
    private final GaugeManager gaugeManager;
    private final String name;
    private final Trace parent;
    private final WeakReference<SessionAwareObject> sessionAwareObject;
    private final List<PerfSession> sessions;
    private Timer startTime;
    private final List<Trace> subtraces;
    private final TransportManager transportManager;

    private void checkAttribute(String str, String str2) {
        if (isStopped()) {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Trace '%s' has been stopped", new Object[]{this.name}));
        } else if (this.customAttributesMap.containsKey(str) || this.customAttributesMap.size() < 5) {
            PerfMetricValidator.validateAttribute(str, str2);
        } else {
            throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Exceeds max limit of number of attributes - %d", new Object[]{5}));
        }
    }

    public static Trace create(String str) {
        return new Trace(str);
    }

    public static synchronized Trace getTrace(String str) {
        Trace trace;
        synchronized (Trace.class) {
            Map<String, Trace> map = traceNameToTraceMap;
            trace = map.get(str);
            if (trace == null) {
                trace = new Trace(str);
                map.put(str, trace);
            }
        }
        return trace;
    }

    private Counter obtainOrCreateCounterByName(String str) {
        Counter counter = this.counterNameToCounterMap.get(str);
        if (counter != null) {
            return counter;
        }
        Counter counter2 = new Counter(str);
        this.counterNameToCounterMap.put(str, counter2);
        return counter2;
    }

    private void setEndTimeOfLastStage(Timer timer) {
        if (!this.subtraces.isEmpty()) {
            Trace trace = this.subtraces.get(this.subtraces.size() - 1);
            if (trace.endTime == null) {
                trace.endTime = timer;
            }
        }
    }

    public static Trace startTrace(String str) {
        Trace trace = traceNameToTraceMap.get(str);
        if (trace != null) {
            trace.start();
        }
        return trace;
    }

    public static Trace stopTrace(String str) {
        Map<String, Trace> map = traceNameToTraceMap;
        Trace trace = map.get(str);
        if (trace != null) {
            trace.stop();
            map.remove(str);
        }
        return trace;
    }

    @Keep
    public int describeContents() {
        return 0;
    }

    public void finalize() throws Throwable {
        try {
            if (isActive()) {
                logger.warn("Trace '%s' is started but not stopped when it is destructed!", this.name);
                incrementTsnsCount(1);
            }
        } finally {
            super.finalize();
        }
    }

    @Keep
    public String getAttribute(String str) {
        return this.customAttributesMap.get(str);
    }

    @Keep
    public Map<String, String> getAttributes() {
        return new HashMap(this.customAttributesMap);
    }

    public Map<String, Counter> getCounters() {
        return this.counterNameToCounterMap;
    }

    public Timer getEndTime() {
        return this.endTime;
    }

    @Keep
    public long getLongMetric(String str) {
        Counter counter;
        if (str != null) {
            counter = this.counterNameToCounterMap.get(str.trim());
        } else {
            counter = null;
        }
        if (counter == null) {
            return 0;
        }
        return counter.getCount();
    }

    public String getName() {
        return this.name;
    }

    public List<PerfSession> getSessions() {
        List<PerfSession> unmodifiableList;
        synchronized (this.sessions) {
            ArrayList arrayList = new ArrayList();
            for (PerfSession next : this.sessions) {
                if (next != null) {
                    arrayList.add(next);
                }
            }
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return unmodifiableList;
    }

    public Timer getStartTime() {
        return this.startTime;
    }

    public List<Trace> getSubtraces() {
        return this.subtraces;
    }

    public boolean hasStarted() {
        if (this.startTime != null) {
            return true;
        }
        return false;
    }

    @Keep
    public void incrementMetric(String str, long j) {
        String validateMetricName = PerfMetricValidator.validateMetricName(str);
        if (validateMetricName != null) {
            logger.error("Cannot increment metric '%s'. Metric name is invalid.(%s)", str, validateMetricName);
        } else if (!hasStarted()) {
            logger.warn("Cannot increment metric '%s' for trace '%s' because it's not started", str, this.name);
        } else if (isStopped()) {
            logger.warn("Cannot increment metric '%s' for trace '%s' because it's been stopped", str, this.name);
        } else {
            Counter obtainOrCreateCounterByName = obtainOrCreateCounterByName(str.trim());
            obtainOrCreateCounterByName.increment(j);
            logger.debug("Incrementing metric '%s' to %d on trace '%s'", str, Long.valueOf(obtainOrCreateCounterByName.getCount()), this.name);
        }
    }

    public boolean isActive() {
        if (!hasStarted() || isStopped()) {
            return false;
        }
        return true;
    }

    public boolean isStopped() {
        if (this.endTime != null) {
            return true;
        }
        return false;
    }

    @Keep
    public void putAttribute(String str, String str2) {
        boolean z = false;
        try {
            str = str.trim();
            str2 = str2.trim();
            checkAttribute(str, str2);
            logger.debug("Setting attribute '%s' to '%s' on trace '%s'", str, str2, this.name);
            z = true;
        } catch (Exception e) {
            logger.error("Can not set attribute '%s' with value '%s' (%s)", str, str2, e.getMessage());
        }
        if (z) {
            this.customAttributesMap.put(str, str2);
        }
    }

    @Keep
    public void putMetric(String str, long j) {
        String validateMetricName = PerfMetricValidator.validateMetricName(str);
        if (validateMetricName != null) {
            logger.error("Cannot set value for metric '%s'. Metric name is invalid.(%s)", str, validateMetricName);
        } else if (!hasStarted()) {
            logger.warn("Cannot set value for metric '%s' for trace '%s' because it's not started", str, this.name);
        } else if (isStopped()) {
            logger.warn("Cannot set value for metric '%s' for trace '%s' because it's been stopped", str, this.name);
        } else {
            obtainOrCreateCounterByName(str.trim()).setCount(j);
            logger.debug("Setting metric '%s' to '%s' on trace '%s'", str, Long.valueOf(j), this.name);
        }
    }

    @Keep
    public void removeAttribute(String str) {
        if (isStopped()) {
            logger.error("Can't remove a attribute from a Trace that's stopped.");
        } else {
            this.customAttributesMap.remove(str);
        }
    }

    @Keep
    public void start() {
        if (!ConfigResolver.getInstance().isPerformanceMonitoringEnabled()) {
            logger.debug("Trace feature is disabled.");
            return;
        }
        String validateTraceName = PerfMetricValidator.validateTraceName(this.name);
        if (validateTraceName != null) {
            logger.error("Cannot start trace '%s'. Trace name is invalid.(%s)", this.name, validateTraceName);
        } else if (this.startTime != null) {
            logger.error("Trace '%s' has already started, should not start again!", this.name);
        } else {
            this.startTime = this.clock.getTime();
            registerForAppState();
            PerfSession perfSession = SessionManager.getInstance().perfSession();
            SessionManager.getInstance().registerForSessionUpdates(this.sessionAwareObject);
            updateSession(perfSession);
            if (perfSession.isGaugeAndEventCollectionEnabled()) {
                this.gaugeManager.collectGaugeMetricOnce(perfSession.getTimer());
            }
        }
    }

    public void startStage(String str) {
        Timer time = this.clock.getTime();
        setEndTimeOfLastStage(time);
        this.subtraces.add(new Trace(this, str, time, (Timer) null, (List<Trace>) null, (Map<String, Counter>) null, (Map<String, String>) null));
    }

    @Keep
    public void stop() {
        if (!hasStarted()) {
            logger.error("Trace '%s' has not been started so unable to stop!", this.name);
        } else if (isStopped()) {
            logger.error("Trace '%s' has already stopped, should not stop again!", this.name);
        } else {
            SessionManager.getInstance().unregisterForSessionUpdates(this.sessionAwareObject);
            unregisterForAppState();
            Timer time = this.clock.getTime();
            this.endTime = time;
            if (this.parent == null) {
                setEndTimeOfLastStage(time);
                if (!this.name.isEmpty()) {
                    this.transportManager.log(new TraceMetricBuilder(this).build(), getAppState());
                    if (SessionManager.getInstance().perfSession().isGaugeAndEventCollectionEnabled()) {
                        this.gaugeManager.collectGaugeMetricOnce(SessionManager.getInstance().perfSession().getTimer());
                        return;
                    }
                    return;
                }
                logger.error("Trace name is empty, no log is sent to server");
            }
        }
    }

    public void stopStage() {
        setEndTimeOfLastStage(this.clock.getTime());
    }

    public void updateSession(PerfSession perfSession) {
        if (perfSession == null) {
            logger.warn("Unable to add new SessionId to the Trace. Continuing without it.");
        } else if (hasStarted() && !isStopped()) {
            this.sessions.add(perfSession);
        }
    }

    @Keep
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.parent, 0);
        parcel.writeString(this.name);
        parcel.writeList(this.subtraces);
        parcel.writeMap(this.counterNameToCounterMap);
        parcel.writeParcelable(this.startTime, 0);
        parcel.writeParcelable(this.endTime, 0);
        synchronized (this.sessions) {
            parcel.writeList(this.sessions);
        }
    }

    private Trace(String str) {
        this(str, TransportManager.getInstance(), new Clock(), AppStateMonitor.getInstance(), GaugeManager.getInstance());
    }

    public static synchronized Trace getTrace(String str, TransportManager transportManager2, Clock clock2, AppStateMonitor appStateMonitor) {
        Trace trace;
        synchronized (Trace.class) {
            Map<String, Trace> map = traceNameToTraceMap;
            trace = map.get(str);
            if (trace == null) {
                trace = new Trace(str, transportManager2, clock2, appStateMonitor, GaugeManager.getInstance());
                map.put(str, trace);
            }
        }
        return trace;
    }

    private Trace(Trace trace, String str, Timer timer, Timer timer2, List<Trace> list, Map<String, Counter> map, Map<String, String> map2) {
        this.sessionAwareObject = new WeakReference<>(this);
        this.parent = trace;
        this.name = str.trim();
        this.startTime = timer;
        this.endTime = timer2;
        this.subtraces = list == null ? new ArrayList<>() : list;
        this.counterNameToCounterMap = map == null ? new ConcurrentHashMap<>() : map;
        this.customAttributesMap = map2 == null ? new ConcurrentHashMap<>() : map2;
        this.clock = trace.clock;
        this.transportManager = trace.transportManager;
        this.sessions = Collections.synchronizedList(new ArrayList());
        this.gaugeManager = trace.gaugeManager;
    }

    public Trace(String str, TransportManager transportManager2, Clock clock2, AppStateMonitor appStateMonitor) {
        this(str, transportManager2, clock2, appStateMonitor, GaugeManager.getInstance());
    }

    public Trace(String str, TransportManager transportManager2, Clock clock2, AppStateMonitor appStateMonitor, GaugeManager gaugeManager2) {
        super(appStateMonitor);
        this.sessionAwareObject = new WeakReference<>(this);
        this.parent = null;
        this.name = str.trim();
        this.subtraces = new ArrayList();
        this.counterNameToCounterMap = new ConcurrentHashMap();
        this.customAttributesMap = new ConcurrentHashMap();
        this.clock = clock2;
        this.transportManager = transportManager2;
        this.sessions = Collections.synchronizedList(new ArrayList());
        this.gaugeManager = gaugeManager2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private Trace(Parcel parcel, boolean z) {
        super(z ? null : AppStateMonitor.getInstance());
        this.sessionAwareObject = new WeakReference<>(this);
        Class<Trace> cls = Trace.class;
        this.parent = (Trace) parcel.readParcelable(cls.getClassLoader());
        this.name = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.subtraces = arrayList;
        parcel.readList(arrayList, cls.getClassLoader());
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.counterNameToCounterMap = concurrentHashMap;
        this.customAttributesMap = new ConcurrentHashMap();
        parcel.readMap(concurrentHashMap, Counter.class.getClassLoader());
        Class<Timer> cls2 = Timer.class;
        this.startTime = (Timer) parcel.readParcelable(cls2.getClassLoader());
        this.endTime = (Timer) parcel.readParcelable(cls2.getClassLoader());
        List<PerfSession> synchronizedList = Collections.synchronizedList(new ArrayList());
        this.sessions = synchronizedList;
        parcel.readList(synchronizedList, PerfSession.class.getClassLoader());
        if (z) {
            this.transportManager = null;
            this.clock = null;
            this.gaugeManager = null;
            return;
        }
        this.transportManager = TransportManager.getInstance();
        this.clock = new Clock();
        this.gaugeManager = GaugeManager.getInstance();
    }
}
