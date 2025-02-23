package com.paytm.pgsdk.sdknative.modal;

import com.google.gson.annotations.SerializedName;
import com.paytm.pgsdk.sdknative.LoginActivity;

public class RequestGenerateOTP {
    @SerializedName("CHECKSUM")
    public String checksum;
    @SerializedName("EMAIL")
    public String email;
    @SerializedName("MID")
    public String merchantID;
    @SerializedName("OTP_DELIVERY_METHOD")
    public String otpDeliveryMethod = LoginActivity.MOBILE_OTP_DELIVERY_METHOD_SMS;
    @SerializedName("PHONE")
    public String phone;
    @SerializedName("RESPONSE_TYPE")
    public String responseType;
    @SerializedName("SCOPE")
    public String scope;
    @SerializedName("USER_TYPE")
    public String userType;
}
