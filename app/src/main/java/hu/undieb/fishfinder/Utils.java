package hu.undieb.fishfinder;
import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    private static Utils instance;
    private ArrayList<Fish> allFish;
    private DatabaseReference database=FirebaseDatabase.getInstance().getReference("Fishes");
    private Utils(){
        if(null==allFish){
            allFish= new ArrayList<>();
            initData();
        }

    }
    private void initData(){
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Fish fish=dataSnapshot.getValue((Fish.class));
                    allFish.add(fish);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public static Utils getInstance() {
        if(null!=instance){
            return instance;
        }
        else{
            instance=new Utils();
            return instance;
        }

    }
    public ArrayList<Fish> getAllFish() {
        return allFish;
    }

    public Fish getFishById(int id){
        for(Fish b: allFish){
            if(b.getId()==id){
                return b;
            }
        }

        return null;
    }

}
