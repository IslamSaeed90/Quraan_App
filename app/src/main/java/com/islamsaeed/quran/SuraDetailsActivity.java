package com.islamsaeed.quran;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import com.islamsaeed.quran.Adapters.SuraContentRecyclerAdapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SuraDetailsActivity extends AppCompatActivity {

    static int position;
    static String suraName;


    /*هاستقبل بقي البراميترز اللي جيالي من ال Intent*/

    String intentSuraName;
    int intentSuraPosition;

    ArrayList<String> suraContent;


    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManage;
    SuraContentRecyclerAdapter adapter ;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sura_details);

        recyclerView = findViewById(R.id.recyclerView);

             /*هنا الأكتيفتي عندها ميثود اسمها getIntent
        لازم اعملها مع الاتنين فاريابلز بتوعي اللي فوق
        ,ولازم اكتب في البراميترز بتوع getStringExtra وال getIntExtra نفس ال value بتاعت الkey   اللي انا باعته هناك بالظبط
        لازم بنفس الإسم بالمللي*/
        intentSuraName = getIntent().getStringExtra("suraName");
        intentSuraPosition = getIntent().getIntExtra("position", -1);
        readSuraFromFile((position + 1) + ".txt");



        layoutManage = new LinearLayoutManager(this);
        adapter = new SuraContentRecyclerAdapter(suraContent);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManage);



    }

  public   void readSuraFromFile(String fileName) {

        BufferedReader reader;

        try {
            suraContent = new ArrayList<>();
            final InputStream file = getAssets().open(fileName);
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();
            while (line != null) {
                suraContent.add(line); /*لازم هنا اضيف لاين الأول للأراي ليست وبعد كده اعرف اللاين في االسطر اللي بعديه
                عشان مايقطعش اول اية في كل سورة */
                line = reader.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }
}
