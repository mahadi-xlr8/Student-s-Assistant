package com.example.studentsassistant;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentsassistant.Colors;
import com.example.studentsassistant.R;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    List<String>versityNames;
    List<Integer>versityImages;
    LayoutInflater inflater;
    onVersityClick versityClick;
    public HomeAdapter(Context context,List<String> names,List<Integer>images,onVersityClick click){
        versityImages=images;
        versityNames=names;
        versityClick=click;
        inflater=LayoutInflater.from(context);

    }


    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.home_card_view,parent,false);
        return new ViewHolder(view,versityClick);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, final int position) {
        holder.cardView.setCardBackgroundColor(Color.parseColor(Colors.getVersityColor()));
        holder.image.setImageResource(versityImages.get(position));
        holder.name.setText(versityNames.get(position));



    }

    @Override
    public int getItemCount() {
        return versityNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView image;
        TextView name;
        Button info;
        CardView cardView;
        onVersityClick versityClick;
        public ViewHolder(@NonNull View itemView,final onVersityClick click) {
            super(itemView);
            image=itemView.findViewById(R.id.versityImage);
            name=itemView.findViewById(R.id.versityName);
            info=itemView.findViewById(R.id.info);
            cardView=itemView.findViewById(R.id.homeCard);
            versityClick=click;
            itemView.setOnClickListener(this);
            info.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (click!=null){
                        int postion=getAdapterPosition();
                        if (postion!=RecyclerView.NO_POSITION){
                            click.onInfoClick(postion);
                        }
                    }
                }
            });


        }

        @Override
        public void onClick(View v) {
            versityClick.onClick(getAdapterPosition());

        }
    }
    public interface onVersityClick{
        public void onClick(int position);
        public void onInfoClick(int positon);
    }



}
