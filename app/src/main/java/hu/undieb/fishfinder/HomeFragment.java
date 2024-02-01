package hu.undieb.fishfinder;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

public class HomeFragment extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState)
{
    View outView=inflater.inflate(R.layout.fragment_home,container,false);
    ImageView imageViewBetta;
    ImageView imageViewHumu;
    ImageView imageViewCamera;
    imageViewCamera=outView.findViewById(R.id.imgPicButton);
    imageViewBetta=outView.findViewById(R.id.imgButtonBetta);
    imageViewHumu=outView.findViewById(R.id.imgButtonHumuHumu);
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

}
