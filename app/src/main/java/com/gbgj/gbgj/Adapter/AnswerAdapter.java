package com.gbgj.gbgj.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gbgj.gbgj.R;

import java.util.ArrayList;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.ViewHolder>  {
    private static final String TAG = "AnswerAdapter";

    private ArrayList<String> mDataSet = new ArrayList<>();

    public AnswerAdapter(ArrayList<String> mDataSet) {
        this.mDataSet = mDataSet;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView_number;
        private final TextView textView_answer;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            textView_number = (TextView) v.findViewById(R.id.textview_adapter_answer_number);
            textView_answer = (TextView) v.findViewById(R.id.textview_adapter_answer);
        }

        public TextView getTextView_number() {
            return textView_number;
        }

        public TextView getTextView_answer() {
            return textView_answer;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_answer, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getTextView_answer().setText(mDataSet.get(position));

        switch (position){
            case 0:
                holder.getTextView_number().setText("①");
                break;
            case 1:
                holder.getTextView_number().setText("②");
                break;
            case 2:
                holder.getTextView_number().setText("③");
                break;
            case 3:
                holder.getTextView_number().setText("④");
                break;
            case 4:
                holder.getTextView_number().setText("⑤");
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

}
