package com.paytm.pgsdk.sdknative.modal;

import com.google.gson.annotations.SerializedName;

public class ResponseGenerateOTP extends BaseResponseModal {
    @SerializedName("message")
    public String ServersuccessStatus;
    @SerializedName("STATUS")
    public String errorStatus;
    public String responseCode;
    @SerializedName("ErrorCode")
    public String serverErrorCode;
    @SerializedName("ErrorMsg")
    public String serverErrorMessage;
    @SerializedName("state")
    public String state;
    @SerializedName("status")
    public String successStatus;
}
