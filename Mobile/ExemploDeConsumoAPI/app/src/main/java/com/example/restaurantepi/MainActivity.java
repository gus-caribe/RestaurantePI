package com.example.restaurantepi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.restaurantepi.model.Produto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    ObjectMapper objectMapper = new ObjectMapper();
    private static OkHttpClient client;
    List<Produto> produto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.client = new OkHttpClient();



        getWebservice();
    }

    private void getWebservice() {
        final Request requestProdutoListar = new Request.Builder().url("http://localhost:8081/produto/listar").build();

        client.newCall(requestProdutoListar).enqueue(
            new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    runOnUiThread(
                        new Runnable() {
                            @Override
                            public void run() {
                                //erro;
                            }
                        }
                    );
                }

                @Override
                public void onResponse(Call call, final Response response) {
                    runOnUiThread(
                        new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    produto = objectMapper.readValue(
                                        response.body().string(),
                                        new TypeReference<List<Produto>>() {}
                                    );
                                }
                                catch (IOException ioe) {
                                    //erro;
                                }
                            }
                        }
                    );
                }
            }
        );
    }
}