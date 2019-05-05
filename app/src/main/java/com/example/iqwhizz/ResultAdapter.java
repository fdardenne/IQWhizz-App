package com.example.iqwhizz;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.iqwhizz.DAO.QuestionDAO;
import com.example.iqwhizz.Objects.Answer;
import com.example.iqwhizz.Objects.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.MyViewHolder> {

    private Answer[] to_display;

    public ResultAdapter(Answer[] answers){
        super();
        this.to_display = answers;
    }

    @Override
    public int getItemCount() {
        return to_display.length;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_result, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Answer elem = to_display[position];
        holder.display(elem);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView selectedAnswer;
        private final TextView question;
        private final TextView rightAnswer;

        private Answer current;

        public MyViewHolder(final View itemView) {
            super(itemView);

            selectedAnswer = ((TextView) itemView.findViewById(R.id.answer_cell));
            question = ((TextView) itemView.findViewById(R.id.question_cell));
            rightAnswer = ((TextView) itemView.findViewById(R.id.right_answer_cell));

        }

        public void display(Answer elem) {
            current = elem;

            Question q = QuestionDAO.getQuestionFromAnswer(elem.getAnswerID());
            question.setText(q.getText());

            selectedAnswer.setText(current.getText());
            if(current.isRight()){
                selectedAnswer.setTextColor(Color.GREEN);
            }else{
                selectedAnswer.setTextColor(Color.RED);
                rightAnswer.setText(q.getRightAnswer().getText());
                rightAnswer.setTextColor(Color.GREEN);
            }


        }
    }

}