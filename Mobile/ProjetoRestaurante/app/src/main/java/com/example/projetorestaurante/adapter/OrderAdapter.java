package com.example.projetorestaurante.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetorestaurante.R;
import com.example.projetorestaurante.models.Order;
import com.example.projetorestaurante.models.OrderDatabase;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {

    LayoutInflater inflater;
    OnItemClickListener listener;

    public OrderAdapter(Context context, OnItemClickListener listener) {
        inflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemList = inflater.inflate(R.layout.order_item_layout, parent, false);
        return new MyViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Order order = OrderDatabase.myDataset.get(position);
        holder.itemCode.setText(String.valueOf(order.getCode()));
        holder.itemWaiter.setText(order.getWaiter());
    }

    @Override
    public int getItemCount() {
        return OrderDatabase.myDataset.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView itemCode;
        public TextView itemWaiter;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemCode = itemView.findViewById(R.id.addItems_code_value_textView);
            itemWaiter = itemView.findViewById(R.id.addItems_description_value_textView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
