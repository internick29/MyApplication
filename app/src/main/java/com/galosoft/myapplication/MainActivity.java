package com.galosoft.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.galosoft.myapplication.Adapter.MyAdapter;
import com.galosoft.myapplication.Helper.MyButtonClickListener;
import com.galosoft.myapplication.Helper.MySwipeHelper;
import com.galosoft.myapplication.Model.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter adapter;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_test);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MySwipeHelper mySwipeHelper = new MySwipeHelper(this, recyclerView, 200) {
            @Override
            public void instantiateMyButton(RecyclerView.ViewHolder viewHolder, List<MySwipeHelper.MyButton> buffer) {
                buffer.add(new MyButton(MainActivity.this, "Delete", 30, 0, Color.parseColor("#FF3c30"),
                        new MyButtonClickListener(){
                            @Override
                            public void onclick(int position) {
                                Toast.makeText(MainActivity.this, "Delete", Toast.LENGTH_SHORT).show();
                            }
                        }));

                buffer.add(new MyButton(MainActivity.this, "Update", 30, R.drawable.ic_edit_white_24dp, Color.parseColor("#FF9503"),
                        new MyButtonClickListener(){
                            @Override
                            public void onclick(int position) {
                                Toast.makeText(MainActivity.this, "Update", Toast.LENGTH_SHORT).show();
                            }
                        }));
            }
        };

        generatedItem();
    }

    private void generatedItem() {
        List<Item> itemList = new ArrayList<>();
        for(int i=0; i<50; i++){
            itemList.add(new Item("Pie 0" + (++i), "$100,00", "http://www.galosoft.com/tierra.png"));
        }
        adapter = new MyAdapter(this,itemList);
        recyclerView.setAdapter(adapter);
    }
}
