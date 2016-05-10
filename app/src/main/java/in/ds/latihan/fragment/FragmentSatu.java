package in.ds.latihan.fragment;

import android.app.*;
import android.os.*;
import android.support.v4.app.*;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;
import in.ds.latihan.*;
import java.util.*;
import org.json.*;

import android.support.v4.app.Fragment;
import in.ds.latihan.adapter.*;
import android.support.v7.widget.RecyclerView.*;
import in.ds.latihan.model.*;

public class FragmentSatu extends Fragment
{

	//private List<CVModel> cardItems = new ArrayList<>(30);
	private List<CVModel> cardItems;
    private RecyclerView recyclerView;
	private static MainActivity mainActivity;

    public static FragmentSatu newInstance(MainActivity activity) {
        FragmentSatu f = new FragmentSatu();
        mainActivity = activity;
        return f;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mainActivity = (MainActivity)activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_satu, container, false);
		
	
		//LinearLayoutManager llm = new LinearLayoutManager();
        //recyclerView.setLayoutManager(llm);
        //recyclerView.setHasFixedSize(true);
		
        recyclerView = (RecyclerView)rootView.findViewById(R.id.recycler_view);
        initializeData();
        initializeAdapter();
		
        return rootView;
    }

	private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(cardItems);
        recyclerView.setAdapter(adapter);
    }

	private void initializeData()
	{
		// TODO: Implement this method
		cardItems = new ArrayList<>();
        cardItems.add(new CVModel(R.string.bla, R.drawable.ble, R.string.blo));
        cardItems.add(new CVModel(R.string.bla, R.drawable.ble, R.string.blo));
		cardItems.add(new CVModel(R.string.bla, R.drawable.ble, R.string.blo));
		cardItems.add(new CVModel(R.string.bla, R.drawable.ble, R.string.blo));
		
	}

	

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //mainActivity.setupDikiDrawer(toolbar);
    }
	
}
