package in.ds.latihan.adapter;

import android.content.*;
import android.support.v7.widget.*;
import android.support.v7.widget.RecyclerView.*;
import android.view.*;
import android.view.animation.*;
import android.widget.*;
import in.ds.latihan.*;
import java.util.*;

import android.support.v7.widget.RecyclerView.Adapter;

public class CVAdapter extends Adapter
{
	
	private AccelerateDecelerateInterpolator mTimeInterpolator;
    private MainActivity mainActivity;
    Intent mainIntent = null;
    private ArrayList<HashMap<String, String>> postList;
    View viewRoot;
	
	public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        ImageView image;
        ImageView imgIcon;
        TextView textAddress;
        TextView textDirect;
        TextView textDistance;
        TextView textName;

        public ViewHolder(View view) {
            super(view);
            CVAdapter.this.viewRoot = view;
            this.imgIcon = (ImageView) view.findViewById(R.id.imgIcon);
            this.image = (ImageView) view.findViewById(R.id.imageCover);
            this.textName = (TextView) view.findViewById(R.id.textName);
            this.textAddress = (TextView) view.findViewById(R.id.textAddress);
            this.textDistance = (TextView) view.findViewById(R.id.textDistance);
            this.textDirect = (TextView) view.findViewById(R.id.textDirect);
        }
    }
	
	public CVAdapter(ArrayList<HashMap<String, String>> postList, MainActivity mainActivity) {
        this.postList = postList;
        this.mainActivity = mainActivity;
    }

	@Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cv_adapter, viewGroup, false));
    }

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder p1, int p2)
	{
		// TODO: Implement this method
	}
	
	private AccelerateDecelerateInterpolator getInterpolator() {
        if (this.mTimeInterpolator == null) {
            this.mTimeInterpolator = new AccelerateDecelerateInterpolator();
        }
        return this.mTimeInterpolator;
    }

	@Override
    public int getItemCount() {
        return this.postList.size();
    }

}
