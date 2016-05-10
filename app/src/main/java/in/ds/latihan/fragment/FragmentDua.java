package in.ds.latihan.fragment;

import android.app.*;
import android.os.*;
import android.preference.*;
import android.support.v4.app.*;
import android.support.v7.widget.*;
import android.view.*;
import in.ds.latihan.*;

import android.support.v4.app.Fragment;

public class FragmentDua extends Fragment
{
	private MainActivity mainActivity;

    public FragmentDua() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mainActivity = (MainActivity)activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_dua, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //mainActivity.setupDikiDrawer(toolbar);
    }

}
