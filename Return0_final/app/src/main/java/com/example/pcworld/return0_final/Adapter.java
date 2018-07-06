package com.example.pcworld.return0_final;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class Adapter extends RecyclerView.Adapter<Adapter.MyHolder> {


    private final ArrayList<model> models;

    public Adapter(ArrayList<model> models){
        this.models=models;
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,null);
        MyHolder myHolder=new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        model model= models.get(position);
        holder.title.setText(model.getTitle());
        holder.description.setText(model.getDescription());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }


    public class MyHolder extends RecyclerView.ViewHolder{
        TextView title,description;
        public MyHolder(View itemView) {
            super(itemView);
            title= (TextView) itemView.findViewById(R.id.textView_title);
            description= (TextView) itemView.findViewById(R.id.textViewDescription);
        }
    }
}
