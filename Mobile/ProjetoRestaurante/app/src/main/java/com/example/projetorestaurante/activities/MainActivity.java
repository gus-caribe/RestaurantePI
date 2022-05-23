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

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private OrderAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

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
}