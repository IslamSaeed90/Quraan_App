package com.islamsaeed.quran;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class PraiseFragment extends android.support.v4.app.Fragment {


    int scoreDigit = 0;
    int sumPraises = 0;




    public PraiseFragment() {
        // Required empty public constructor
    }

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_praise, container, false);


        Spinner spinner = view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.azkar, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) getActivity());




            /* دي تاني ميثود عملتها عشان الكليك اللي هاتحصل عالتيكست فيوو بتاع التسبيحة
    * الأول عررفت فاريبال int  فوق جلوبال
    * وبعد كده استخدمته هنا
   وزودت عليه واحد كل مرة اللي هو العداد بقي بتاع التسبيح
     * وبعد كده ناديت عالميثود الأولانية اللي عملتها وحطيتلها الفاريابل ده*/

        /*اضافة
         * هنا زودت الميثود بتاعت اضافة الرقم للخانة بتاعت محموع التسبيحات بمجرد ضغطة واحدة علي صورة السبحة
         * فا عملت ميثود تحت اسمها displaySumPraises  وناديت عليها هنا
         * ماينفعش اعمل اتنين ميثود onClickListener  بنفس ال Id  بتاع الحاجة اللي هادوس عليها
         * هو Id واحد بس وبنادي جوه الأون كليك بتاعه علي اللي عايزه يظهر أما أ click  علي ال id ده*/
        ImageView praiseImg = view.findViewById(R.id.praisePhoto);
        praiseImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreDigit += 1;
                displayAddDigit(scoreDigit);
                sumPraises += 1;
                displaySumOfPraises(sumPraises);
            }
        });



        /*دي تالت ميثود عملتها عشان اعمل ريسيت للأرقام كلها , اصفر العداد بتاع الميثود رقم 2  addDigit*/
        /* اضافة
         * هنا زودت الميثود اللي تحت بتاعت مجموع عدد التسبيحات عشان اصفر الخانة بتاعت التسبيحة
         * والخانة بتاعت مجموع التسبيحات بضغطة واحدة علي زرار الريسيت*/
        ImageView resetClick = view.findViewById(R.id.resetIv);
        resetClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scoreDigit = 0;
                displayAddDigit(scoreDigit);
                sumPraises = 0;
                displaySumOfPraises(sumPraises);
            }
        });


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            TextView singlePraise = view.findViewById(R.id.singlePraiseTv);

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                scoreDigit =0 ;
                singlePraise.setText(R.string.zero);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }


    /*دي أول ميثود عملتها
     * عررفت فيها التيكست اللي هزود فيه التسبيحة كل مرة بالضغط عليه
     * وبعد كده عملتله سيت للتيكست اللي جواه واديته ال int  اللي انا عامله فوق فالميثود باراميتر*/
    private void displayAddDigit(int score) {
        TextView adding = view.findViewById(R.id.singlePraiseTv);
        adding.setText(String.valueOf(score));

    }

    /*دي رابع مثود اعملها ,
    الميثود دي عملتها عشان اظهر مجموع التسبيحات في التكيست فيوو الخاص بيها , زيها زي اللي فوقيها بالظبط*/
    private void displaySumOfPraises(int score) {
        TextView adding = view.findViewById(R.id.totalPraiseTv);
        adding.setText(String.valueOf(score));

    }


}
