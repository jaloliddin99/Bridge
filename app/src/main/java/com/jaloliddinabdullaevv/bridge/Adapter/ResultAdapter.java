package com.jaloliddinabdullaevv.bridge.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.jaloliddinabdullaevv.bridge.Common.Common;
import com.jaloliddinabdullaevv.bridge.Model.QuestionNumber;
import com.jaloliddinabdullaevv.bridge.R;

import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.MyViewHolder> {

        Context context;
        List<QuestionNumber> questionNumberList;

public ResultAdapter(Context context, List<QuestionNumber> questionNumberList) {
        this.context = context;
        this.questionNumberList = questionNumberList;
        }

@NonNull
@Override
public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_result_card, parent, false);
        return new MyViewHolder(itemView);
        }

@Override
public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.savolNomer.setText(String.valueOf(position+1) + "-savol");
        holder.text_togri_javob.setText(questionNumberList.get(position).getSavol());
        holder.answerA.setText(questionNumberList.get(position).getJavobA());
        holder.answerB.setText(questionNumberList.get(position).getJavobB());
        holder.answerC.setText(questionNumberList.get(position).getJavobC());

        holder.answerA.setChecked(false);
        holder.answerB.setChecked(false);
        holder.answerC.setChecked(false);

        holder.answerA.setTextColor(Color.BLACK);
        holder.answerB.setTextColor(Color.BLACK);
        holder.answerC.setTextColor(Color.BLACK);

        if (Common.chosenAnswers.get(position).equals(Common.correctAnswersFromDb.get(position))) {

        holder.togri_javobni_korish.setText("Sizning javobingiz to'g'ri");
        holder.togri_javobni_korish2.setText("To'g'ri javob "+Common.correctAnswersFromDb.get(position));
        String togriJavob=Common.correctAnswersFromDb.get(position);
        switch (togriJavob){
        case "A":
        holder.answerA.setChecked(true);
        holder.answerA.setTextColor(Color.GREEN);
        break;
        case "B":
        holder.answerB.setChecked(true);
        holder.answerB.setTextColor(Color.GREEN);
        break;
        case "C":
        holder.answerC.setChecked(true);
        holder.answerC.setTextColor(Color.GREEN);
        break;
        }
        } else {
        if (Common.chosenAnswers.get(position).equals("E")){
        holder.togri_javobni_korish.setText("Sizning hech qandey javob belgilamagansiz");
        holder.togri_javobni_korish.setTextColor(Color.RED);
        holder.togri_javobni_korish2.setText("To'g'ri javob "+Common.correctAnswersFromDb.get(position));

        }else {

        holder.togri_javobni_korish.setText("Sizning javobingiz xato");
        holder.togri_javobni_korish2.setText("To'g'ri javob "+Common.correctAnswersFromDb.get(position));
        }

        String togriJavob=Common.chosenAnswers.get(position);
        switch (togriJavob){
        case "A":
        holder.answerA.setChecked(true);
        holder.answerA.setTextColor(Color.RED);
        break;
        case "B":
        holder.answerB.setChecked(true);
        holder.answerB.setTextColor(Color.RED);
        break;
        case "C":
        holder.answerC.setChecked(true);
        holder.answerC.setTextColor(Color.RED);

        break;
        }
        }

        holder.answerA.setEnabled(false);
        holder.answerB.setEnabled(false);
        holder.answerC.setEnabled(false);


        Animation animation = AnimationUtils.loadAnimation(context, R.anim.animation_from_right);
        holder.itemView.startAnimation(animation);

        }

@Override
public int getItemCount() {
        return questionNumberList.size();
        }

public class MyViewHolder extends RecyclerView.ViewHolder {
    MaterialCardView card_togri_javob;
    TextView text_togri_javob, togri_javobni_korish, togri_javobni_korish2, savolNomer;
    RadioButton answerA, answerB, answerC;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        card_togri_javob = itemView.findViewById(R.id.card_togri_javoblar);
        savolNomer = itemView.findViewById(R.id.savolNomeri);
        text_togri_javob = itemView.findViewById(R.id.togriJavobText);
        answerA = itemView.findViewById(R.id.buttonA);
        answerB = itemView.findViewById(R.id.buttonB);
        answerC = itemView.findViewById(R.id.buttonC);

        togri_javobni_korish = itemView.findViewById(R.id.togriJavobKorsatish);
        togri_javobni_korish2 = itemView.findViewById(R.id.togriJavobKorsatish2);
    }
}
}
