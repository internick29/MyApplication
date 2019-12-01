package com.galosoft.myapplication.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.galosoft.myapplication.R;


class MyViewHolder extends RecyclerView.ViewHolder {

    TextView cart_item_name, cart_item_price;
    ImageView cart_item_img;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        cart_item_img = itemView.findViewById(R.id.card_image);
        cart_item_name = itemView.findViewById(R.id.cart_item_name);
        cart_item_price =  itemView.findViewById(R.id.cart_item_price);
    }
}
