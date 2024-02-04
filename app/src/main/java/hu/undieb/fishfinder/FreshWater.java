package hu.undieb.fishfinder;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class FreshWater extends AppCompatActivity {
    private RecyclerView fishesRecView;
    private FishRecViewAdapter adapter;
    private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresh_water);
        fishesRecView=findViewById(R.id.fishesRecView);
        searchView=findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                freshWaterFishListFilteredByName(newText);
                return true;
            }
        });
        searchView.clearFocus();
        adapter=new FishRecViewAdapter(this);
        fishesRecView.setAdapter(adapter);
        fishesRecView.setLayoutManager(new LinearLayoutManager(this));


        adapter.setFishes((ArrayList<Fish>) Utils.getInstance().getAllFish().stream().filter(c->c.getWaterType()==WaterType.FRESHWATER).collect(Collectors.toList()));
    }

    private void freshWaterFishListFilteredByName(String name) {
            ArrayList<Fish> temp=new ArrayList<>();
            for(Fish b: Utils.getInstance().getAllFish().stream().filter(c->c.getWaterType()==WaterType.FRESHWATER).collect(Collectors.toList())){
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