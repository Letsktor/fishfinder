package hu.undieb.fishfinder;

import static android.content.ContentValues.TAG;

import static hu.undieb.fishfinder.FishView.FISH_ID_KEY;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FishRecViewAdapter extends RecyclerView.Adapter<FishRecViewAdapter.ViewHolder> {
    private ArrayList<Fish> fishes= new ArrayList<>();
    private Context mContext;

    public FishRecViewAdapter(Context mContext){
        this.mContext=mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_fish,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG,"onBindViewHolder:called");
        holder.txtName.setText(fishes.get(position).getName());
        String img= fishes.get(position).getUrls().get(0);
        Glide.with(mContext).asBitmap().load(img).into(holder.imgFish);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(mContext,FishView.class);
                intent.putExtra(FISH_ID_KEY,fishes.get(position).getId());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return fishes.size();
    }

    public void setFishes(ArrayList<Fish> fishes) {
        this.fishes = fishes;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView parent;
        private ImageView imgFish;
        private TextView txtName;
        public ViewHolder(@NonNull View itemView){
         super(itemView);
            parent=itemView.findViewById(R.id.parent);
            imgFish=itemView.findViewById(R.id.imgFish);
            txtName=itemView.findViewById(R.id.FishName);
        }
    }
}
