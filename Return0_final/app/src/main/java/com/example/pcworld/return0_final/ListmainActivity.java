package com.example.pcworld.return0_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ListmainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listmain);
        RecyclerView list= (RecyclerView) findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager
                (this,LinearLayoutManager.VERTICAL,false));
     Adapter adapter = new Adapter(createData());
        list.setAdapter(adapter);
    }

    public ArrayList<model> createData(){

        model model=new model("ITem 1","THIS IS Item 1");
        model model1=new model("ITem 7","THIS IS Item 5");

        model model2=new model("ITem 6","THIS IS Item 4");

        model model3=new model("ITem 4","THIS IS Item 5");

        model model4=new model("ITem 3","THIS IS Item 6");
        ArrayList<model> models=new ArrayList<>();
        models.add(model);
        models.add(model1);
        models.add(model3);
        models.add(model2);

        models.add(model4);
        return models;



    }
}
