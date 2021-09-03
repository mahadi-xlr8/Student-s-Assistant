package com.example.studentsassistant.diu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.studentsassistant.R;
import com.example.studentsassistant.adapters.DepartmentsAdapter;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class DiuDepartments extends AppCompatActivity implements DepartmentsAdapter.onCardClick{

    RecyclerView datalist;
    List<String>titles;
    List<Integer>images;
    DepartmentsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diu_departments);
        setTitle("DIU Department");

        datalist =findViewById(R.id.diuEeeRecycle);
        titles=new ArrayList<>();
        images=new ArrayList<>();
        titles.add("CSE");
        titles.add("EEE");
        titles.add("Textile");
        titles.add("Pharmacy");
        images.add(R.drawable.cse_icon);
        images.add(R.drawable.eee_icon);
        images.add(R.drawable.text_icon);
        images.add(R.drawable.pharmacy_icon);
        adapter=new DepartmentsAdapter(this,titles,images,this);
        GridLayoutManager grid=new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        datalist.setLayoutManager(grid);
        datalist.setAdapter(adapter);


    }

    @Override
    public void onDepClick(int position) {


        if (position==0)startActivity(new Intent(DiuDepartments.this, DiuCse.class));
        if (position==1)startActivity(new Intent(DiuDepartments.this, DiuEee.class));
        if (position==2)startActivity(new Intent(DiuDepartments.this, DiuTextile.class));
        if (position==3)startActivity(new Intent(DiuDepartments.this, DiuPhermacy.class));


    }

}