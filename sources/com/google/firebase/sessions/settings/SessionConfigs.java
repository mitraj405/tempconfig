package com.google.firebase.sessions.settings;

/* compiled from: SettingsCache.kt */
public final class SessionConfigs {
    private final Integer cacheDuration;
    private final Long cacheUpdatedTime;
    private final Boolean sessionEnabled;
    private final Integer sessionRestartTimeout;
    private final Double sessionSamplingRate;

    public SessionConfigs(Boolean bool, Double d, Integer num, Integer num2, Long l) {
        this.sessionEnabled = bool;
        this.sessionSamplingRate = d;
        this.sessionRestartTimeout = num;
        this.cacheDuration = num2;
        this.cacheUpdatedTime = l;
    }

    public static /* synthetic */ SessionConfigs copy$default(SessionConfigs sessionConfigs, Boolean bool, Double d, Integer num, Integer num2, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = sessionConfigs.sessionEnabled;
        }
        if ((i & 2) != 0) {
            d = sessionConfigs.sessionSamplingRate;
        }
        Double d2 = d;
        if ((i & 4) != 0) {
            num = sessionConfigs.sessionRestartTimeout;
        }
        Integer num3 = num;
        if ((i & 8) != 0) {
            num2 = sessionConfigs.cacheDuration;
        }
        Integer num4 = num2;
        if ((i & 16) != 0) {
            l = sessionConfigs.cacheUpdatedTime;
        }
        return sessionConfigs.copy(bool, d2, num3, num4, l);
    }

    public final Boolean component1() {
        return this.sessionEnabled;
    }

    public final Double component2() {
        return this.sessionSamplingRate;
    }

    public final Integer component3() {
        return this.sessionRestartTimeout;
    }

    public final Integer component4() {
        return this.cacheDuration;
    }

    public final Long component5() {
        return this.cacheUpdatedTime;
    }

    public final SessionConfigs copy(Boolean bool, Double d, Integer num, Integer num2, Long l) {
        return new SessionConfigs(bool, d, num, num2, l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionConfigs)) {
            return false;
        }
        SessionConfigs sessionConfigs = (SessionConfigs) obj;
        if (C1177ig.a(this.sessionEnabled, sessionConfigs.sessionEnabled) && C1177ig.a(this.sessionSamplingRate, sessionConfigs.sessionSamplingRate) && C1177ig.a(this.sessionRestartTimeout, sessionConfigs.sessionRestartTimeout) && C1177ig.a(this.cacheDuration, sessionConfigs.cacheDuration) && C1177ig.a(this.cacheUpdatedTime, sessionConfigs.cacheUpdatedTime)) {
            return true;
        }
        return false;
    }

    public final Integer getCacheDuration() {
        return this.cacheDuration;
    }

    public final Long getCacheUpdatedTime() {
        return this.cacheUpdatedTime;
    }

    public final Boolean getSessionEnabled() {
        return this.sessionEnabled;
    }

    public final Integer getSessionRestartTimeout() {
        return this.sessionRestartTimeout;
    }

    public final Double getSessionSamplingRate() {
        return this.sessionSamplingRate;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        Boolean bool = this.sessionEnabled;
        int i5 = 0;
        if (bool == null) {
            i = 0;
        } else {
            i = bool.hashCode();
        }
        int i6 = i * 31;
        Double d = this.sessionSamplingRate;
        if (d == null) {
            i2 = 0;
        } else {
            i2 = d.hashCode();
        }
        int i7 = (i6 + i2) * 31;
        Integer num = this.sessionRestartTimeout;
        if (num == null) {
            i3 = 0;
        } else {
            i3 = num.hashCode();
        }
        int i8 = (i7 + i3) * 31;
        Integer num2 = this.cacheDuration;
        if (num2 == null) {
            i4 = 0;
        } else {
            i4 = num2.hashCode();
        }
        int i9 = (i8 + i4) * 31;
        Long l = this.cacheUpdatedTime;
        if (l != null) {
            i5 = l.hashCode();
        }
        return i9 + i5;
    }

    public String toString() {
        return "SessionConfigs(sessionEnabled=" + this.sessionEnabled + ", sessionSamplingRate=" + this.sessionSamplingRate + ", sessionRestartTimeout=" + this.sessionRestartTimeout + ", cacheDuration=" + this.cacheDuration + ", cacheUpdatedTime=" + this.cacheUpdatedTime + ')';
    }
}
