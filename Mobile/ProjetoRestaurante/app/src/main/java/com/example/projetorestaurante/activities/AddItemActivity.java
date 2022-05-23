package com.example.projetorestaurante.activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetorestaurante.R;
import com.example.projetorestaurante.adapter.AddItemAdapter;
import com.example.projetorestaurante.models.Item;
import com.example.projetorestaurante.models.ItemDatabase;

public class AddItemActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AddItemAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_items);

        recyclerView = findViewById(R.id.order_recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new AddItemAdapter(this, new AddItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Item item = ItemDatabase.myDataset.get(position);
//                Intent intent = new Intent(AddItemActivity.this, .class);
//                startActivity(intent);

                Toast.makeText(AddItemActivity.this,
                        String.valueOf(item.getCode()),
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
