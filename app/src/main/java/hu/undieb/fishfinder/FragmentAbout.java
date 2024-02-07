package hu.undieb.fishfinder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class FragmentAbout extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstances){
        getActivity().setTitle("Info");
        return inflater.inflate(R.layout.fragment_about,container,false);
    }
}
