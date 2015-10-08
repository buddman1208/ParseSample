package moe.mallang.parsetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {
    MallangService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRetrofit();
        service.sendRequest("Junseok Oh", "kotohana5706", "asdf", new Callback<TestData>() {
            @Override
            public void success(TestData testData, Response response) {
                Toast.makeText(getApplicationContext(), testData.respond, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void setRetrofit() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://bamtoll.moe")
                .build();
        service = restAdapter.create(MallangService.class);
    }
}
