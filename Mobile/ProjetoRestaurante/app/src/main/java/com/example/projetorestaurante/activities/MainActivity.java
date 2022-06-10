package com.example.projetorestaurante.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.projetorestaurante.R;
import com.example.projetorestaurante.adapter.OrderAdapter;
import com.example.projetorestaurante.models.Order;
import com.example.projetorestaurante.models.OrderDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.projetorestaurante.modelsParaCarregamento.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private OrderAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    //TRATAMENTO DAS LISTAGENS

    ObjectMapper objectMapper = new ObjectMapper();
    private static OkHttpClient client;

    public Pedido pedido;
    public Item item;
    public Produto produto;
    public List<Pedido> todosOsPedidos;
    public List<Item> todosOsItensDeUmPedido;
    public List<Produto> todosOsProdutos;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.order_recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new OrderAdapter(this, new OrderAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Order order = OrderDatabase.myDataset.get(position);
                Intent orderDetails_intent = new Intent(MainActivity.this, OrderDetailsActivity.class);
                startActivity(orderDetails_intent);

                Toast.makeText(MainActivity.this,
                        String.valueOf(order.getCode()),
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

        FloatingActionButton fab = findViewById(R.id.order_add_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addOrder_intent = new Intent(MainActivity.this, AddOrderActivity.class);
                startActivity(addOrder_intent);
            }
        });

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }







    //TRATAMENTO DAS LISTAGENS

    public Pedido buscarPedido (int idPedido) {
        return new Pedido();//mudar
    }

    public Item buscarItem (int idItem) {
        return new Item();//mudar
    }

    public Produto buscarProduto (int idProduto) {
        return new Produto();//mudar
    }

    public void listarTodosOsPedidos() {
        final Request requestPedidoListar = new Request.Builder().url("http://localhost:8081/pedido/listar").build();

        client.newCall(requestPedidoListar).enqueue(
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
                                            todosOsPedidos = objectMapper.readValue(
                                                    response.body().string(),
                                                    new TypeReference<List<Pedido>>() {}
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

    /*public List<Item> listarTodosOsItensDeUmPedido(int idPedido) {
        List<Item> listaItens;

        return listaItens;
    }

    public List<Produto> listarTodosOsProdutos() {
        List<Produto> listaProdutos;

        return listaProdutos;
    }*/
}