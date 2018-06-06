package com.gbgj.gbgj.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gbgj.gbgj.R;

import java.util.ArrayList;

import vinos.mathjaxwebview.view.MathJaxWebView;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.ViewHolder>  {
    private static final String TAG = "AnswerAdapter";

    private ArrayList<String> mDataSet = new ArrayList<>();
    static private onAnswerListener onAnswerListener;

    public AnswerAdapter() {
    }

    public AnswerAdapter(ArrayList<String> mDataSet) {
        this.mDataSet = mDataSet;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView_number;
        private final MathJaxWebView mathjaxwebview_adapter_answer;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onAnswerListener.onClickAnswerItem(v, getAdapterPosition());
                }
            });
            textView_number = (TextView) v.findViewById(R.id.textview_adapter_answer_number);
            mathjaxwebview_adapter_answer = (MathJaxWebView) v.findViewById(R.id.mathjaxwebview_adapter_answer);
        }

        public TextView getTextView_number() {
            return textView_number;
        }

        public MathJaxWebView getMathJaxWebView_answer() {
            return mathjaxwebview_adapter_answer;
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
        holder.getMathJaxWebView_answer().setText(mDataSet.get(position));

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

    public interface onAnswerListener{
        void onClickAnswerItem(View v, int position);
    }

    public void setOnAnswerListener(AnswerAdapter.onAnswerListener onAnswerListener) {
        this.onAnswerListener = onAnswerListener;
    }

    public void setmDataSet(ArrayList<String> mDataSet) {
        this.mDataSet = mDataSet;
        notifyDataSetChanged();
    }
}
