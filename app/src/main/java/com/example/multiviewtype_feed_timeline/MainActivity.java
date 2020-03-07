package com.example.multiviewtype_feed_timeline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private Context mContext;
    private View view;
    private LinearLayoutManager linearLayoutManager;
    private ParentAdapter parentAdapter;

    @BindView(R.id.recyclerview)
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        createList();
    }
    public void createList(){
        ArrayList<Model> arrayList = new ArrayList<>();
        ArrayList<Model> listArrayList = new ArrayList<>();

        Model model = new Model();

        model = new Model();
        model.setTxt("Bb");
        listArrayList.add(model);

        model = new Model();
        model.setTxt("Cc");
        listArrayList.add(model);

        model = new Model();
        model.setTxt("Dd");
        listArrayList.add(model);

        model = new Model();
        model.setTxt("Ee");
        listArrayList.add(model);

        model = new Model();
        model.setTxt("Ff");
        listArrayList.add(model);

        model = new Model();
        model.setTxt("Gg");
        listArrayList.add(model);

        model = new Model();
        model.setTxt("Hi");
        listArrayList.add(model);



        model = new Model();
        model.setTxt("B");
        arrayList.add(model);

        model = new Model();
        model.setTxt("C");
        arrayList.add(model);

        model = new Model();
        model.setTxt("D");
        arrayList.add(model);

        model = new Model();
        model.setTxt("E");
        arrayList.add(model);

        model = new Model();
        model.setTxt("F");
        arrayList.add(model);

        model = new Model();
        model.setTxt("G");
        arrayList.add(model);

        model = new Model();
        model.setTxt("H");
        arrayList.add(model);

        model = new Model();
        model.setTxt("I");
        arrayList.add(model);

        model = new Model();
        model.setTxt("K");
        arrayList.add(model);

        model = new Model();
        model.setTxt("L");
        arrayList.add(model);

        model = new Model();
        model.setTxt("M");
        arrayList.add(model);

        model = new Model();
        model.setTxt("N");
        arrayList.add(model);

        model = new Model();
        model.setTxt("O");
        arrayList.add(model);

        model = new Model();
        model.setTxt("P");
        arrayList.add(model);

        model = new Model();
        model.setTxt("Q");
        arrayList.add(model);

        model = new Model();
        model.setTxt("R");
        arrayList.add(model);

        model = new Model();
        model.setTxt("S");
        arrayList.add(model);

        model = new Model();
        model.setTxt("T");
        arrayList.add(model);

        linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        parentAdapter =new ParentAdapter(mContext, arrayList,listArrayList);
        recyclerView.setAdapter(parentAdapter);
        parentAdapter.notifyDataSetChanged();
    }


}
