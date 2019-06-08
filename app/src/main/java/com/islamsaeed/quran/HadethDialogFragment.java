package com.islamsaeed.quran;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HadethDialogFragment extends DialogFragment {
    public HadethDialogFragment() {
    }

Hadeth hadeth ;

    public void setHadeth(Hadeth hadeth) {
        this.hadeth = hadeth;
    }

    TextView title ;
    TextView content ;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.dialog_hadeth, container, false);

        title = view.findViewById(R.id.title);
        content = view.findViewById(R.id.content);

        title.setText(hadeth.getTitle());
        content.setText(hadeth.getContent());



        return view;
    }
}
