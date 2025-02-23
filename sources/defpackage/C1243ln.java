package defpackage;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/* renamed from: ln  reason: default package and case insensitive filesystem */
/* compiled from: OAuth2TokenRequestService */
public interface C1243ln {
    @FormUrlEncoded
    @POST("/authprovider/oauth/token")
    @Headers({"Accept: application/json"})
    Observable<C1223kn> a(@Field("grant_type") String str, @Field("username") String str2, @Field("password") String str3, @Field("otpLogin") String str4);

    @FormUrlEncoded
    @POST("/authprovider/webmtoken")
    @Headers({"Accept: application/json"})
    Observable<C1223kn> b(@Field("grant_type") String str, @Field("data") String str2, @Field("encodedPwd") String str3, @Field("captcha") String str4, @Field("uid") String str5, @Field("otpLogin") String str6, @Field("nlpIdendifier") String str7, @Field("nlpAnswer") String str8, @Field("nlpToken") String str9, @Field("lso") String str10);

    @FormUrlEncoded
    @POST("/authprovider/webmtoken")
    @Headers({"Accept: application/json"})
    Observable<C1223kn> c(@Field("grant_type") String str, @Field("data") String str2, @Field("encodedPwd") String str3, @Field("captcha") String str4, @Field("uid") String str5);
}
