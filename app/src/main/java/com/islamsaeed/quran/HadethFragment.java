package com.islamsaeed.quran;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.islamsaeed.quran.Adapters.HadethAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HadethFragment extends android.support.v4.app.Fragment {


    public HadethFragment() {
        // Required empty public constructor
    }

    List<Hadeth> allAhadeth;
    RecyclerView recyclerView;
    HadethAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_hadeth, container, false);

        readSuraFromFile();

        recyclerView = view.findViewById(R.id.recyclerSurasActivity);

        layoutManager = new LinearLayoutManager(getActivity());
        adapter = new HadethAdapter(allAhadeth);
        adapter.setOnItemClickListener(new HadethAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, Hadeth hadeth) {
                HadethDialogFragment dialogFragment = new HadethDialogFragment();
                dialogFragment.setHadeth(hadeth);
                dialogFragment.show(getChildFragmentManager(),"dialog");

            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }


    public void readSuraFromFile(){
        allAhadeth = new ArrayList<>();
        BufferedReader reader;

        try {
            final InputStream file = getActivity().getAssets().open("ahadeth.txt");
            reader = new BufferedReader(new InputStreamReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String title = line;
                String content = "";
                while ((line = reader.readLine()) != null) {
                    if (line.equals("#")) break;
                    content = content + "\n" + line;
                }
                Hadeth hadeth = new Hadeth(title, content);
                allAhadeth.add(hadeth);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


    }


}
