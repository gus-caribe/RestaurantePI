package com.example.projetorestaurante.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetorestaurante.R;
import com.example.projetorestaurante.adapter.OrderAdapter;
import com.example.projetorestaurante.adapter.OrderDetailsAdapter;
import com.example.projetorestaurante.models.Item;
import com.example.projetorestaurante.models.ItemDatabase;
import com.example.projetorestaurante.models.Order;
import com.example.projetorestaurante.models.OrderDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class OrderDetailsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private OrderDetailsAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_details);

        recyclerView = findViewById(R.id.orderDetails_recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new OrderDetailsAdapter(this, new OrderDetailsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Item item = ItemDatabase.myDataset.get(position);

                Intent itemDetails_intent = new Intent(OrderDetailsActivity.this, ItemDetailsActivity.class);
                startActivity(itemDetails_intent);

                Toast.makeText(OrderDetailsActivity.this,
                        String.valueOf(item.getCode()),
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

        FloatingActionButton fab = findViewById(R.id.order_add_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addItem_intent = new Intent(OrderDetailsActivity.this, AddItemActivity.class);
                startActivity(addItem_intent);
            }
        });

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
