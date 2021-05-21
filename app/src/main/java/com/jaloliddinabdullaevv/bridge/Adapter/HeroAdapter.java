package com.jaloliddinabdullaevv.bridge.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.jaloliddinabdullaevv.bridge.Common.Common;
import com.jaloliddinabdullaevv.bridge.Model.HeroObject;

import com.jaloliddinabdullaevv.bridge.R;

import java.util.List;

import static com.jaloliddinabdullaevv.bridge.Adapter.DesctiptionAdapter2.getResourceID;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.MyViewHolder> {
    Context context;
    List<HeroObject> objects;

    public HeroAdapter(Context context, List<HeroObject> objects) {
        this.context = context;
        this.objects = objects;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_hero, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint({"UseCompatLoadingForDrawables", "SetTextI18n"})
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(objects.get(position).getHeroName());
        holder.infoText.setText(objects.get(position).getHeroInfo()+"...");
        holder.imageView.setImageDrawable(
                context.getResources().getDrawable(getResourceID(Common.imageName, "drawable", context))
        );
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView, infoText;
        MaterialCardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            textView=itemView.findViewById(R.id.textView);
            infoText=itemView.findViewById(R.id.descriptionText);
            cardView=itemView.findViewById(R.id.cardView);

            cardView.setOnClickListener(v -> {

            });


        }
    }
}
