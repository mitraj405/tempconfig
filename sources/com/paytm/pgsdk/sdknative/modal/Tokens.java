package com.paytm.pgsdk.sdknative.modal;

public class Tokens {
    private static ResponseValidateOTP validateOTP;

    public static ResponseValidateOTP getValidateResponse() {
        return validateOTP;
    }

    public static void setValidateResponse(ResponseValidateOTP responseValidateOTP) {
        validateOTP = responseValidateOTP;
    }
}
