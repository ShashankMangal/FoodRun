package com.example.foodrun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.foodrun.Adapters.MainAdapter;
import com.example.foodrun.Models.MainModel;
import com.example.foodrun.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.burger,"Burger","5","Chicken Burger with extra Cheese"));
        list.add(new MainModel(R.drawable.pizza,"Pizza","10","Chrispy and cheese paneer Pizza"));
        list.add(new MainModel(R.drawable.poc,"Portobella Mushroom","8","Burger with Portobella Mushroom and loaded cheese"));
        list.add(new MainModel(R.drawable.boc,"Pizza Burger","12","Burger having pizza slice with loaded cheese"));
        list.add(new MainModel(R.drawable.chowmein,"Chowmein","12","Tasty Chowmein with spicy sauces"));
        list.add(new MainModel(R.drawable.frenchfries,"French Fries","10","Chrispy Fried Potatoes with salted flavour"));
        list.add(new MainModel(R.drawable.coke,"Coke","3","Coke is carbonated water"));

        MainAdapter adapter = new MainAdapter(list,this);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this,OrderActivity.class));
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
        }
        return super.onOptionsItemSelected(item);
    }
}