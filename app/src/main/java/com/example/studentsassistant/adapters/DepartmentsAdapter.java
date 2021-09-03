package com.example.studentsassistant.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentsassistant.Colors;
import com.example.studentsassistant.R;

import java.util.List;

public class DepartmentsAdapter extends RecyclerView.Adapter<DepartmentsAdapter.ViewHolder>{

    List<String>titles;
    List<Integer> images;
    LayoutInflater inflater;
    onCardClick clickListener;

    public DepartmentsAdapter(Context context, List<String> titles, List<Integer>images, onCardClick click){
        this.titles=titles;
        this.images=images;
        inflater=LayoutInflater.from(context);
        clickListener=click;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.gridview,parent,false);


        return new ViewHolder(view,clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.cardView.setCardBackgroundColor(Color.parseColor(Colors.getDepartmentColor()));
        holder.title.setText(titles.get(position));
        holder.image.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        ImageView image;
        onCardClick Interface;
        CardView cardView;

        public ViewHolder(@NonNull View itemView,onCardClick a) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            image=itemView.findViewById(R.id.image);
            cardView=itemView.findViewById(R.id.cardView);
            Interface=a;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Interface.onDepClick(getAdapterPosition());
        }
    }
    public interface onCardClick{

        void onDepClick(int position);

    }

}


