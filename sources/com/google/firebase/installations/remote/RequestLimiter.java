package com.google.firebase.installations.remote;

import com.google.firebase.installations.Utils;
import java.util.concurrent.TimeUnit;

class RequestLimiter {
    private static final long MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS = TimeUnit.HOURS.toMillis(24);
    private static final long MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS = TimeUnit.MINUTES.toMillis(30);
    private int attemptCount;
    private long nextRequestTime;
    private final Utils utils;

    public RequestLimiter(Utils utils2) {
        this.utils = utils2;
    }

    private synchronized long getBackoffDuration(int i) {
        if (!isRetryableError(i)) {
            return MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS;
        }
        return (long) Math.min(Math.pow(2.0d, (double) this.attemptCount) + ((double) this.utils.getRandomDelayForSyncPrevention()), (double) MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS);
    }

    private static boolean isRetryableError(int i) {
        if (i == 429 || (i >= 500 && i < 600)) {
            return true;
        }
        return false;
    }

    private static boolean isSuccessfulOrRequiresNewFidCreation(int i) {
        if ((i >= 200 && i < 300) || i == 401 || i == 404) {
            return true;
        }
        return false;
    }

    private synchronized void resetBackoffStrategy() {
        this.attemptCount = 0;
    }

    public synchronized boolean isRequestAllowed() {
        boolean z;
        if (this.attemptCount == 0 || this.utils.currentTimeInMillis() > this.nextRequestTime) {
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public synchronized void setNextRequestTime(int i) {
        if (isSuccessfulOrRequiresNewFidCreation(i)) {
            resetBackoffStrategy();
            return;
        }
        this.attemptCount++;
        this.nextRequestTime = this.utils.currentTimeInMillis() + getBackoffDuration(i);
    }

    public RequestLimiter() {
        this.utils = Utils.getInstance();
    }
}
