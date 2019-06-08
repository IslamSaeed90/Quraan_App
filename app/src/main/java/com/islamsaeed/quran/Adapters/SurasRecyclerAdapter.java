package com.islamsaeed.quran.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.islamsaeed.quran.R;

public class SurasRecyclerAdapter extends RecyclerView.Adapter<SurasRecyclerAdapter.ViewHolder> {

    String[] surasNames;

    public SurasRecyclerAdapter(String[] names) {
        this.surasNames = names;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sura_item_view, viewGroup, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull SurasRecyclerAdapter.ViewHolder viewHolder, final int position) {
        final String surasNamesArr = surasNames[position];
        viewHolder.suraName.setText(surasNamesArr);

        if (onItemClickListener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(position, surasNamesArr);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return surasNames.length;
    }






    public interface OnItemClickListener {
        void onItemClick(int pos, String suraName);
    }

    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }







    class ViewHolder extends RecyclerView.ViewHolder {

        TextView suraName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            suraName = itemView.findViewById(R.id.suraNameTv);
        }
    }
}
