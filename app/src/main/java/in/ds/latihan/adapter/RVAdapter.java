package in.ds.latihan.adapter;

import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;
import in.ds.latihan.*;
import in.ds.latihan.model.*;
import java.util.*;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder>
{

    public List<CVModel> cardItems;

    public RVAdapter(List<CVModel> cardItems){
        this.cardItems = cardItems;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
		ImageView image;
        TextView content;
        public ViewHolder(View itemView) {
            super(itemView);
            this.title = (TextView)itemView.findViewById(R.id.card_title);
			this.image = (ImageView)itemView.findViewById(R.id.image_view);
            this.content = (TextView)itemView.findViewById(R.id.card_content);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(cardItems.get(position).title);
		holder.image.setImageResource(cardItems.get(position).photo);
        holder.content.setText(cardItems.get(position).content);
    }

    @Override
    public int getItemCount() {
        return cardItems.size();
    }
}
