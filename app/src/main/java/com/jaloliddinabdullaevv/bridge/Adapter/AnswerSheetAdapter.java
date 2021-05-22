package com.jaloliddinabdullaevv.bridge.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jaloliddinabdullaevv.bridge.Model.CurrentQuestion;
import com.jaloliddinabdullaevv.bridge.R;

import java.util.ArrayList;
import java.util.List;

public class AnswerSheetAdapter extends RecyclerView.Adapter<AnswerSheetAdapter.MyViewHolder> {



    Context context;
    List<CurrentQuestion> currentQuestionList;

    public static ArrayList<Integer> colors=new ArrayList<>();

    public AnswerSheetAdapter(Context context, List<CurrentQuestion> currentQuestionList) {
        this.context = context;
        this.currentQuestionList = currentQuestionList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(context).inflate(R.layout.layout_grid_answer_sheet_item, parent, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MyViewHolder.question_item.setBackgroundColor(colors.get(position));
    }

    @Override
    public int getItemCount() {
        return currentQuestionList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        @SuppressLint("StaticFieldLeak")
        public static View question_item;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            question_item=itemView.findViewById(R.id.question_item);
        }
    }
}
