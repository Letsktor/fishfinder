package hu.undieb.fishfinder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class YourFishes extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            getActivity().setTitle("Your Fishes");
            return inflater.inflate(R.layout.fragment_your_fishes,container,false);
        }
}
