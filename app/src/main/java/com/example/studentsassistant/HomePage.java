package com.example.studentsassistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.studentsassistant.adapters.HomeAdapter;
import com.example.studentsassistant.diu.DiuDepartments;
import com.example.studentsassistant.diu.DiuInfo;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity implements HomeAdapter.onVersityClick{

    RecyclerView resycle;
    List<String>names;
    List<Integer> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        names= new ArrayList<>();
        images=new ArrayList<>();
        names.add("Bangladesh University of Engineering and Technology");
        names.add("Daffodil International University");
        names.add("BRAC University");
        names.add("North South University");
        names.add("American International University-Bangladesh");
        names.add("Ahsanullah University of Science and Technology");

        images.add(R.drawable.buet_icon);
        images.add(R.drawable.diu_icon);
        images.add(R.drawable.brac_icon);
        images.add(R.drawable.nsu_icon);
        images.add(R.drawable.aiub_icon);
        images.add(R.drawable.aust_icon);

        HomeAdapter adapter=new HomeAdapter(this,names,images,this);
        GridLayoutManager layoutManager=new GridLayoutManager(this,1,GridLayoutManager.VERTICAL,false);
        resycle=findViewById(R.id.homeResycle);
        resycle.setLayoutManager(layoutManager);
        resycle.setAdapter(adapter);

    }

    @Override
    public void onClick(int position) {
        if (position==0)startActivity(new Intent(HomePage.this, BuetDepartments.class));
        if (position==1)startActivity(new Intent(HomePage.this, DiuDepartments.class));

        if (position==2)startActivity(new Intent(HomePage.this, BracDepartments.class));
        if (position==3)startActivity(new Intent(HomePage.this, NsuDepartments.class));


        if (position==4)startActivity(new Intent(HomePage.this, AiubDepartments.class));
        if (position==5)startActivity(new Intent(HomePage.this, AustDepartments.class));


    }

    @Override
    public void onInfoClick(int positon) {
        if (positon==0){
            startActivity(new Intent(HomePage.this, BuetInfo.class));
        }
        if (positon==1)startActivity(new Intent(HomePage.this, DiuInfo.class));
        if (positon==2)startActivity(new Intent(HomePage.this, BracInfo.class));
        if (positon==3)startActivity(new Intent(HomePage.this, NsuInfo.class));
        if (positon==4)startActivity(new Intent(HomePage.this, AiubInfo.class));
        if (positon==5)startActivity(new Intent(HomePage.this, AustInfo.class));

    }
}