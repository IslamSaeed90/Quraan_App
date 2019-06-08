package com.islamsaeed.quran;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.islamsaeed.quran.Adapters.SurasRecyclerAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class SurasFragment extends android.support.v4.app.Fragment {

    public SurasFragment() {

    }


    SurasRecyclerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_suras, container, false);
        recyclerView = view.findViewById(R.id.recyclerSurasActivity);


        adapter = new SurasRecyclerAdapter(Constants.ArSuras);

        /* لازم اعمل سيت لل onItemClickListener
        ساعتها اما حد يدوس عال item جوه , الأكتيفيتي هاتعرف علي طول
         ده هو ال callBack  بتاعي
         ماينفعش اعمل الكليك بتاعتي في الأدابتر  , لازم اعملها في الأكتيفيتي */
        adapter.setOnItemClickListener(new SurasRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, String suraName) {
                Intent intent = new Intent(getActivity(), SuraDetailsActivity.class);

                /*الطريقة الأولي عشان أخلي ال intent ينادي علي اسم السورة واسم الفايل اللي هاتفتحه
                أما يتم الضغط عليهم في ال SuraDetails
                وعرفت اعمل كده عشان الاتنين فاريابل دول ستاتيك يعني تبع الكلاس
                */
                SuraDetailsActivity.position = pos;
                SuraDetailsActivity.suraName = suraName;

                /*  الطريقة التانية اني ابعت الباراميترز دول جوه ال intent
                 * ال intent يقدر يشيل باراميترز */
                /*بعد ماعملتهم هاروح استقبلهم بقي في الأكتيفتي بتاعت ال details*/
                intent.putExtra("position", pos);
                intent.putExtra("suraName", suraName);

                startActivity(intent);
            }
        });

//        SnapHelper snapHelper =new PagerSnapHelper();
//        snapHelper.attachToRecyclerView(recyclerView);
        layoutManager = new GridLayoutManager(getActivity(), 5, LinearLayoutManager.HORIZONTAL, false);


        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

}
