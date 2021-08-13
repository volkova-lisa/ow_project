package quizapp.volkova.ow_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    //todo
    //считать массив ном стр с сайта http://demo3005513.mockable.io/api/v1/entities/getAllIds
    //
    //тут про разные типы https://overcoder.net/q/350474/gson-parse-json-%D1%81-%D0%BC%D0%B0%D1%81%D1%81%D0%B8%D0%B2%D0%BE%D0%BC-%D1%81-%D1%80%D0%B0%D0%B7%D0%BB%D0%B8%D1%87%D0%BD%D1%8B%D0%BC%D0%B8-%D1%82%D0%B8%D0%BF%D0%B0%D0%BC%D0%B8-%D0%BE%D0%B1%D1%8A%D0%B5%D0%BA%D1%82%D0%BE%D0%B2


    private JsonPlaceholderApi jsonPlaceholderApi;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txt);

        //для считки номеров страничек
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://demo3005513.mockable.io/api/v1/entities/getAllIds")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceholderApi = retrofit.create(JsonPlaceholderApi.class);


    }

    private void getData() {
        Call<String> call = jsonPlaceholderApi.getData();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (!response.isSuccessful()) {
                    textView.setText("Code: " + response.code());
                    return;
                }

                String data = response.body();
                String content = " ";

                //textView.append(data);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                textView.setText(t.getMessage());
            }
        });
    }
}