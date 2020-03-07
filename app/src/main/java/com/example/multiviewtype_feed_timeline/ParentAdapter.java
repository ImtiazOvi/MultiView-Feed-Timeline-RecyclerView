package com.example.multiviewtype_feed_timeline;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ParentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private LayoutInflater inflater;
    private ArrayList<Model> arrayList = new ArrayList<>();
    ArrayList<Model> listArrayList = new ArrayList<>();
    private NewlyAdapter newlyAdapter;

    public static int TEXT_TYPE = 0;
    public static int LIST_TYPE = 1;


    public ParentAdapter(Context mContext, ArrayList<Model> arrayList, ArrayList<Model> listArrayList) {
        Log.d("list", String.valueOf(arrayList.size()));
        this.mContext = mContext;
        this.arrayList = arrayList;
        this.listArrayList = listArrayList;

       // inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TEXT_TYPE){
            //return new TxtTypeHolder(inflater.inflate(R.layout.row_txt_type, parent, false));
            //return new TxtTypeHolder(inflater.inflate(R.layout.row_txt_type, parent, false));
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_txt_type, parent, false);
            return new TxtTypeHolder(itemView);
        } else if (viewType == LIST_TYPE){
//            return new ListTypeHolder(inflater.inflate(R.layout.row_list, parent, parentfalse));
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list_type, parent, false);
            return new ListTypeHolder(itemView);
        }else {
            return null;
        }
    }

    @Override
    public int getItemViewType(int position) {
        //return super.getItemViewType(position);
        if (TEXT_TYPE == position) {
            return TEXT_TYPE;
        } else {
            return LIST_TYPE;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position) == TEXT_TYPE) {
            // ((WriteSomethingTypeHolder) holder).setContent(feedModelArrayList.get(position));
            Model model = arrayList.get(position);
            ((TxtTypeHolder) holder).setContent(arrayList.get(position));
        }else if (getItemViewType(position) == LIST_TYPE) {
            //((TopNavTypeHolder) holder).setContent(feedModelArrayList.get(position));
            newlyAdapter = new NewlyAdapter(mContext, listArrayList);
            LinearLayoutManager layoutManager
                    = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
            ((ListTypeHolder) holder).recyclerView.setLayoutManager(layoutManager);
            ((ListTypeHolder) holder).recyclerView.setAdapter(newlyAdapter);
           newlyAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }


    //////////////==================TxtType view holder===================////////////////////////
    class TxtTypeHolder extends RecyclerView.ViewHolder {

        TextView textView;
        public TxtTypeHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }

        void setContent(Model feedModel) {
            // TODO : will fix validation of image from model is empty or null

            textView.setText(feedModel.getTxt());
        }
    }



    //////////////==================ListType view holder===================////////////////////////
    class ListTypeHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;
        public ListTypeHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recyclerview);

        }

//        void setContent(Model feedModel) {
//            // TODO : will fix validation of image from model is empty or null
//        }
    }

}
