package com.islamsaeed.quran.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.islamsaeed.quran.R;

import java.util.ArrayList;



public class SuraContentRecyclerAdapter extends RecyclerView.Adapter<SuraContentRecyclerAdapter.ViewHolder>  {
    ArrayList<String>verses;

    public SuraContentRecyclerAdapter(ArrayList<String> verses) {
        this.verses = verses;
    }

    @NonNull
    @Override
    public SuraContentRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_verse, viewGroup, false);
        return new SuraContentRecyclerAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull SuraContentRecyclerAdapter.ViewHolder viewHolder, final int position) {
        final String aya = verses.get(position);
        viewHolder.suraVerse.setText(aya + "{"+(position+1)+"}" );

        if (onItemClickListener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(position ,aya);
                }
            });
        }
    }






    @Override
    public int getItemCount() {
        return verses.size();
    }







    public interface OnItemClickListener {
        void onItemClick(int pos , String aya);
    }

    SuraContentRecyclerAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(SuraContentRecyclerAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }




    class ViewHolder extends RecyclerView.ViewHolder {

        TextView suraVerse;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            suraVerse = itemView.findViewById(R.id.suraVerseTv);
        }
    }

}


