package com.paytm.pgsdk.sdknative.modal;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class ResponseConvinenceFee extends BaseResponseModal {
    @SerializedName("ErrorCode")
    public String ErrorCode;
    @SerializedName("ErrorMsg")
    public String ErrorMsg;
    @SerializedName("STATUS")
    public String STATUS;
    @SerializedName("jsonObject")
    public String jsonObject;
    @SerializedName("paymentCharges")
    public ArrayList<PaytmCharges> paymentCharges;

    public class DefaultFee {
        @SerializedName("baseAmount")
        public String baseAmount;
        @SerializedName("fee")
        public String fee;
        @SerializedName("text")
        public String text;
        @SerializedName("txnAmount")
        public String txnAmount;

        public DefaultFee() {
        }
    }

    public class NBNA {
        @SerializedName("baseAmount")
        public String baseAmount;
        @SerializedName("fee")
        public String fee;
        @SerializedName("text")
        public String text;
        @SerializedName("txnAmount")
        public String txnAmount;

        public NBNA() {
        }
    }

    public class PPI {
        @SerializedName("baseAmount")
        public String baseAmount;
        @SerializedName("fee")
        public String fee;
        @SerializedName("feeDisplay")
        public String feeDisplay;
        @SerializedName("text")
        public String text;
        @SerializedName("txnAmount")
        public String txnAmount;

        public PPI() {
        }
    }

    public class PaytmCharges {
        @SerializedName("DefaultFee")
        public ArrayList<PPI> DefaultFee;
        @SerializedName("NBNA")
        public ArrayList<PPI> NBNA;
        @SerializedName("PPI")
        public ArrayList<PPI> PPI;

        public PaytmCharges() {
        }
    }
}
