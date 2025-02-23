package com.paytm.pgsdk.sdknative.modal;

import com.google.gson.annotations.SerializedName;

public class PostConvenienceModal {
    @SerializedName("baseAmount")
    private String baseAmount;
    @SerializedName("fee")
    private String fee;
    @SerializedName("key")
    private String key;
    @SerializedName("text")
    private String text;
    @SerializedName("txnAmount")
    private String txnAmount;

    public String getBaseAmount() {
        return this.baseAmount;
    }

    public String getFee() {
        return this.fee;
    }

    public String getKey() {
        return this.key;
    }

    public String getText() {
        return this.text;
    }

    public String getTxnAmount() {
        return this.txnAmount;
    }

    public void setBaseAmount(String str) {
        this.baseAmount = str;
    }

    public void setFee(String str) {
        this.fee = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTxnAmount(String str) {
        this.txnAmount = str;
    }
}
