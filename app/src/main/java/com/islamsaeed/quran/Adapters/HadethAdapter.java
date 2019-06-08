package com.islamsaeed.quran.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.islamsaeed.quran.Hadeth;
import com.islamsaeed.quran.R;

import java.util.ArrayList;
import java.util.List;

public class HadethAdapter extends RecyclerView.Adapter<ViewHolder> {

    List<Hadeth> allAhadeth;

    public HadethAdapter(List<Hadeth> allAhadeth) {
        this.allAhadeth = allAhadeth;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_verse, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        final Hadeth hadeth = allAhadeth.get(position);
        viewHolder.suraVerse.setText(hadeth.getTitle());

        if (onItemClickListener!=null){
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(position,hadeth);
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return allAhadeth.size();
    }














    public interface OnItemClickListener {
        void onItemClick(int pos , Hadeth hadeth);
    }

    HadethAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(HadethAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }




}




class ViewHolder extends RecyclerView.ViewHolder {

    TextView suraVerse;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        suraVerse = itemView.findViewById(R.id.suraVerseTv);
    }
}