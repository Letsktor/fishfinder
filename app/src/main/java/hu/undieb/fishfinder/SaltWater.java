package hu.undieb.fishfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SaltWater extends AppCompatActivity {
    private RecyclerView fishesRecView;
    private FishRecViewAdapter adapter;
    private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salt_water);
        fishesRecView=findViewById(R.id.fishesRecView);
        adapter=new FishRecViewAdapter(this);
        fishesRecView.setAdapter(adapter);
        fishesRecView.setLayoutManager(new LinearLayoutManager(this));
        searchView=findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                saltWaterFishListFilteredByName(newText);
                return true;
            }
        });
        searchView.clearFocus();
        adapter.setFishes((ArrayList<Fish>) Utils.getInstance().getAllFish().stream().filter(c->c.getWaterType()==WaterType.SALTWATER).collect(Collectors.toList()));
    }
    private void saltWaterFishListFilteredByName(String name) {
        ArrayList<Fish> temp=new ArrayList<>();
        for(Fish b: Utils.getInstance().getAllFish().stream().filter(c->c.getWaterType()==WaterType.SALTWATER).collect(Collectors.toList())){
            if(b.getName().toLowerCase().contains(name.toLowerCase())){
                temp.add(b);
            }
        }
        if(temp.isEmpty()){
            adapter.setFishes(temp);
        }
        else{
            adapter.setFishes(temp);
        }

    }
}