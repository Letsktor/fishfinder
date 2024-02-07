package hu.undieb.fishfinder;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class HomeFragment extends Fragment {
    private FishRecViewAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
{
    View outView=inflater.inflate(R.layout.fragment_home,container,false);
    getActivity().setTitle("Home");
    CardView cardView;
    CardView cardView2;
    ImageView imageViewBetta;
    ImageView imageViewHumu;
    ImageView imageViewCamera;
    cardView=outView.findViewById(R.id.cardView);
    cardView2=outView.findViewById(R.id.cardView2);
    imageViewCamera=outView.findViewById(R.id.imgPicButton);
    imageViewBetta=outView.findViewById(R.id.imgButtonBetta);
    imageViewHumu=outView.findViewById(R.id.imgButtonHumuHumu);
    SearchView searchView;
    searchView=outView.findViewById(R.id.searchView);
    RecyclerView recyclerView;
    recyclerView=outView.findViewById(R.id.Recview);
    adapter=new FishRecViewAdapter(outView.getContext());
    recyclerView.setAdapter(adapter);
    recyclerView.setLayoutManager(new LinearLayoutManager(outView.getContext()));
    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            if(newText.isEmpty() || newText.length()==0){
                recyclerView.setVisibility(View.GONE);
                cardView.setVisibility(View.VISIBLE);
                cardView2.setVisibility(View.VISIBLE);
            }
            else{
                recyclerView.setVisibility(View.VISIBLE);
                cardView.setVisibility(View.GONE);
                cardView2.setVisibility(View.GONE);
            }
            fishFilteredByName(newText);
            return true;
        }
    });
    adapter.setFishes(Utils.getInstance().getAllFish());
    imageViewCamera.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    });
    Glide.with(this).asBitmap().load(R.drawable.betta).into(imageViewBetta);
    imageViewBetta.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(getActivity(),FreshWater.class);
            startActivity(intent);
        }
    });
    Glide.with(this).asBitmap().load(R.drawable.humuhumunukunukuapua).into(imageViewHumu);
    imageViewHumu.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(getActivity(),SaltWater.class);
            startActivity(intent);
        }
    });
    return outView;

}
    private void fishFilteredByName(String name) {
        ArrayList<Fish> temp=new ArrayList<>();
        for(Fish b: Utils.getInstance().getAllFish()){
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
