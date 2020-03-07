package com.example.multiviewtype_feed_timeline;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewlyAdapter extends RecyclerView.Adapter<NewlyAdapter.NewlyViewHolder> {
    private Context mContext;
    private ArrayList<Model> arrayList;
    private LayoutInflater inflater;

    public NewlyAdapter(Context mContext, ArrayList<Model> arrayList){
        Log.d("list2","Size is"+arrayList.size());
        this.mContext = mContext;
        this.arrayList = arrayList;


    }


    @NonNull
    @Override
    public NewlyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list, parent, false);
        return new NewlyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewlyViewHolder holder, int position) {
        Model model = arrayList.get(position);
        holder.textView.setText(model.getTxt());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class NewlyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public NewlyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txt_view);
        }
    }
}
