package com.jaloliddinabdullaevv.bridge.Fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import com.jaloliddinabdullaevv.bridge.Adapter.AnswerSheetAdapter;
import com.jaloliddinabdullaevv.bridge.Common.Common;
import com.jaloliddinabdullaevv.bridge.Model.QuestionNumber;
import com.jaloliddinabdullaevv.bridge.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {

    TextView text_question_text;
    RadioButton ckbA, ckbB, ckbC, ckbD;
    QuestionNumber questionNumber;
    int questionIndex=-1;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView =  inflater.inflate(R.layout.fragment_blank, container, false);


        questionIndex=getArguments().getInt("index", -1);
        questionNumber = Common.questionNumbers.get(questionIndex);

        text_question_text = itemView.findViewById(R.id.savol);
        text_question_text.setText(questionNumber.getSavol());
        Log.i("text_question_text  ", " "+ questionNumber.getSavol());
        ckbA = itemView.findViewById(R.id.variantA);
        ckbA.setText(questionNumber.getJavobA());
        ckbA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Common.chosenAnswers.set(Common.currentQuestion, "A");
                AnswerSheetAdapter.colors.set(Common.currentQuestion, Color.parseColor("#2fff00"));


            }
        });

        ckbB = itemView.findViewById(R.id.variantB);
        ckbB.setText(questionNumber.getJavobB());
        ckbB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Common.chosenAnswers.set(Common.currentQuestion, "B");
                AnswerSheetAdapter.colors.set(Common.currentQuestion, Color.parseColor("#2fff00"));
            }
        });

        ckbC = itemView.findViewById(R.id.variantC);
        ckbC.setText(questionNumber.getJavobC());
        ckbC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Common.chosenAnswers.set(Common.currentQuestion, "C");
                AnswerSheetAdapter.colors.set(Common.currentQuestion, Color.parseColor("#2fff00"));
            }
        });

        return itemView;
    }
}