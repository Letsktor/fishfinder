package hu.undieb.fishfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class FreshWater extends AppCompatActivity {
    private RecyclerView fishesRecView;
    private FishRecViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresh_water);
        fishesRecView=findViewById(R.id.fishesRecView);
        adapter=new FishRecViewAdapter(this,"FreshWater");
        fishesRecView.setAdapter(adapter);
        fishesRecView.setLayoutManager(new LinearLayoutManager(this));


        adapter.setFishes((ArrayList<Fish>) Utils.getInstance().getAllFish().stream().filter(c->c.getWaterType()==WaterType.FRESHWATER).collect(Collectors.toList()));
    }
}