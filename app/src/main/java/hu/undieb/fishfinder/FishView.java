package hu.undieb.fishfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FishView extends AppCompatActivity {
    public static final String FISH_ID_KEY="fishId";
    public TextView txtCommonName, txtScintificName,txtShortDesc;
    public ImageView imgFish,btnLeft,btnRight;
    public ProgressBar progressBar1,progressBar2,progressBar3;
    int imgcount=0;
    @SuppressLint({"ClickableViewAccessibility", "NewApi"})
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
                    progressBar1.setProgress(100);
                    progressBar1.setSecondaryProgress(100);
                    progressBar2.setSecondaryProgress(100);
                    progressBar3.setSecondaryProgress(100);
                    imgFish.setOnTouchListener(new View.OnTouchListener() {
                        float x1,x2;
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {

                            if(motionEvent.getAction()==MotionEvent.ACTION_DOWN)
                            {
                                x1=motionEvent.getX();
                            }
                            if(motionEvent.getAction()==MotionEvent.ACTION_UP)
                            {
                                x2=motionEvent.getX();
                                if(Math.abs(x2-x1)>50)
                                {
                                    if (x2>x1) {
                                        if (imgcount == 0) {

                                            Glide.with(FishView.this).asBitmap().load(incomingFish.getUrls().get(imgcount)).into(imgFish);
                                        } else {
                                            imgcount -= 1;

                                            Glide.with(FishView.this).asBitmap().load(incomingFish.getUrls().get(imgcount)).into(imgFish);
                                        }

                                    }
                                    if(x1>x2){
                                        if (imgcount >= (incomingFish.getUrls().size() - 1)) {

                                            Glide.with(FishView.this).asBitmap().load(incomingFish.getUrls().get(imgcount)).into(imgFish);
                                        } else {
                                            imgcount += 1;

                                            Glide.with(FishView.this).asBitmap().load(incomingFish.getUrls().get(imgcount)).into(imgFish);
                                        }
                                    }
                                    if(imgcount==0){
                                        progressBar1.setProgress(100);
                                        progressBar2.setProgress(0);
                                        progressBar3.setProgress(0);
                                    }else if(imgcount==1){
                                        progressBar1.setProgress(0);
                                        progressBar2.setProgress(100);
                                        progressBar3.setProgress(0);
                                    }else{
                                        progressBar1.setProgress(0);
                                        progressBar2.setProgress(0);
                                        progressBar3.setProgress(100);
                                    }
                                }

                            }

                            return true;
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
                            if(imgcount==0){
                                progressBar1.setProgress(100);
                                progressBar2.setProgress(0);
                                progressBar3.setProgress(0);
                            }else if(imgcount==1){
                                progressBar1.setProgress(0);
                                progressBar2.setProgress(100);
                                progressBar3.setProgress(0);
                            }else{
                                progressBar1.setProgress(0);
                                progressBar2.setProgress(0);
                                progressBar3.setProgress(100);
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
                            if(imgcount==0){
                                progressBar1.setProgress(100);
                                progressBar2.setProgress(0);
                                progressBar3.setProgress(0);
                            }else if(imgcount==1){
                                progressBar1.setProgress(0);
                                progressBar2.setProgress(100);
                                progressBar3.setProgress(0);
                            }else{
                                progressBar1.setProgress(0);
                                progressBar2.setProgress(0);
                                progressBar3.setProgress(100);
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
        progressBar1=findViewById(R.id.progressBar1);
        progressBar2=findViewById(R.id.progressBar2);
        progressBar3=findViewById(R.id.progressBar3);
        txtCommonName=findViewById(R.id.txtCommonName);
        txtScintificName=findViewById(R.id.txtScientificName);
        txtShortDesc=findViewById(R.id.txtShortDesc);
        imgFish=findViewById(R.id.imgFish);
        btnLeft=findViewById(R.id.imgButtonLeft);
        btnRight=findViewById(R.id.imgbuttonright);
    }

}