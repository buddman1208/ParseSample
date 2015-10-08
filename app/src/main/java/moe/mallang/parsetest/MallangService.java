package moe.mallang.parsetest;


import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by Junseok on 2015-10-07.
 */
public interface MallangService {
    @FormUrlEncoded
    @POST("/test")
    void sendRequest(@Field("name") String name, @Field("user_id") String id,
            @Field("user_password") String password, Callback<TestData> callback);
}
