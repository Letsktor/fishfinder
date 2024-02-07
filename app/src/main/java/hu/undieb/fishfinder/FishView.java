package hu.undieb.fishfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.OnSwipe;

import android.content.Intent;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FishView extends AppCompatActivity {
    public static final String FISH_ID_KEY="fishId";
    public TextView txtCommonName, txtScintificName,txtShortDesc;
    public ImageView imgFish,btnLeft,btnRight;
    int imgcount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish_view);
        Intent intent=getIntent();
        initViews();
        getActionBar();
        if(null!=intent){
            int fishId=intent.getIntExtra(FISH_ID_KEY,-1);
            if(fishId!=-1){
                Fish incomingFish=Utils.getInstance().getFishById(fishId);
                if(null!=incomingFish){
                    setData(incomingFish);
                   imgFish.setOnTouchListener(new View.OnTouchListener() {
                       @Override
                       public boolean onTouch(View view, MotionEvent motionEvent) {
                           return false;
                       }
                   });
                    btnLeft.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(imgcount==0){
                                Glide.with(view.getContext()).asBitmap().load(incomingFish.getUrls().get(imgcount)).into(imgFish);
                            }else {
                                imgcount-=1;
                                Glide.with(view.getContext()).asBitmap().load(incomingFish.getUrls().get(imgcount)).into(imgFish);
                            }

                        }
                    });
                    btnRight.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(imgcount>=(incomingFish.getUrls().size()-1)){
                                Glide.with(view.getContext()).asBitmap().load(incomingFish.getUrls().get(imgcount)).into(imgFish);
                            }else {
                                imgcount+=1;
                                Glide.with(view.getContext()).asBitmap().load(incomingFish.getUrls().get(imgcount)).into(imgFish);
                            }
                        }
                    });
                }
            }
        }


    }
    private void setData(Fish fish){
        txtCommonName.setText(fish.getName());
        txtScintificName.setText(fish.getScientificName());
        txtShortDesc.setText(fish.getDescription());
        Glide.with(this).asBitmap().load(fish.getUrls().get(imgcount)).into(imgFish);
    }
    private void initViews(){
        txtCommonName=findViewById(R.id.txtCommonName);
        txtScintificName=findViewById(R.id.txtScientificName);
        txtShortDesc=findViewById(R.id.txtShortDesc);
        imgFish=findViewById(R.id.imgFish);
        btnLeft=findViewById(R.id.imgButtonLeft);
        btnRight=findViewById(R.id.imgbuttonright);
    }
}