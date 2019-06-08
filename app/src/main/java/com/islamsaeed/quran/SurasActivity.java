package com.islamsaeed.quran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.islamsaeed.quran.Adapters.SurasRecyclerAdapter;

public class SurasActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    SurasRecyclerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suras);
        recyclerView = findViewById(R.id.recyclerSurasActivity);

        adapter = new SurasRecyclerAdapter(Constants.ArSuras);

        /* لازم اعمل سيت لل onItemClickListener
        ساعتها اما حد يدوس عال item جوه , الأكتيفيتي هاتعرف علي طول
         ده هو ال callBack  بتاعي
         ماينفعش اعمل الكليك بتاعتي في الأدابتر  , لازم اعملها في الأكتيفيتي */
        adapter.setOnItemClickListener(new SurasRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, String suraName) {
                Intent intent = new Intent(SurasActivity.this, SuraDetailsActivity.class);

                /*الطريقة الأولي عشان أخلي ال intent ينادي علي اسم السورة واسم الفايل اللي هاتفتحه
                أما يتم الضغط عليهم في ال SuraDetails
                وعرفت اعمل كده عشان الاتنين فاريابل دول ستاتيك يعني تبع الكلاس
                */
                SuraDetailsActivity.position = pos;
                SuraDetailsActivity.suraName = suraName;

                /*  الطريقة التانية اني ابعت الباراميترز دول جوه ال intent
                 * ال intent يقدر يشيل باراميترز */
                /*بعد ماعملتهم هاروح استقبلهم بقي في الأكتيفتي بتاعت ال details*/
                intent.putExtra("position" , pos);
                intent.putExtra("suraName" , suraName);

                startActivity(intent);
            }
        });

        layoutManager = new GridLayoutManager(this, 3, LinearLayoutManager.HORIZONTAL, false);



        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    }
}
