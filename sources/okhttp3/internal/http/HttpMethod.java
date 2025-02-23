package okhttp3.internal.http;

import com.google.firebase.perf.FirebasePerformance;

public final class HttpMethod {
    private HttpMethod() {
    }

    public static boolean invalidatesCache(String str) {
        if (str.equals(FirebasePerformance.HttpMethod.POST) || str.equals(FirebasePerformance.HttpMethod.PATCH) || str.equals(FirebasePerformance.HttpMethod.PUT) || str.equals(FirebasePerformance.HttpMethod.DELETE) || str.equals("MOVE")) {
            return true;
        }
        return false;
    }

    public static boolean permitsRequestBody(String str) {
        if (str.equals(FirebasePerformance.HttpMethod.GET) || str.equals(FirebasePerformance.HttpMethod.HEAD)) {
            return false;
        }
        return true;
    }

    public static boolean redirectsToGet(String str) {
        return !str.equals("PROPFIND");
    }

    public static boolean redirectsWithBody(String str) {
        return str.equals("PROPFIND");
    }

    public static boolean requiresRequestBody(String str) {
        if (str.equals(FirebasePerformance.HttpMethod.POST) || str.equals(FirebasePerformance.HttpMethod.PUT) || str.equals(FirebasePerformance.HttpMethod.PATCH) || str.equals("PROPPATCH") || str.equals("REPORT")) {
            return true;
        }
        return false;
    }
}
