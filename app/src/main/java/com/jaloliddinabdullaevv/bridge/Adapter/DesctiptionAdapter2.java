package com.jaloliddinabdullaevv.bridge.Adapter;

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

import com.jaloliddinabdullaevv.bridge.HeroListActivity;
import com.jaloliddinabdullaevv.bridge.Model.DescriptionObjects;
import com.jaloliddinabdullaevv.bridge.R;

import java.util.List;

public class DesctiptionAdapter2 extends RecyclerView.Adapter<DesctiptionAdapter2.MyViewHolder> {

    Context context;
    List<DescriptionObjects> objects;



    public DesctiptionAdapter2(Context context, List<DescriptionObjects> objects) {
        this.context = context;
        this.objects = objects;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.layout_description, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(objects.get(position).getDescription());
        holder.descriptionImg.setImageDrawable(
                context.getResources().getDrawable(getResourceID("do"+position, "drawable", context))
        );

        holder.descriptionImg.setTag("do"+position);

    }

    @Override
    public int getItemCount() {
        return objects.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        MaterialCardView cardView;
        ImageView descriptionImg;
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            cardView = itemView.findViewById(R.id.cardView);
            descriptionImg = itemView.findViewById(R.id.descriptionImg);
            cardView.setOnClickListener(v -> {
                Common.descriptionObjects = objects.get(getAdapterPosition());
                Common.imageName=String.valueOf(descriptionImg.getTag());
                Intent intent = new Intent(context, HeroListActivity.class);
                context.startActivity(intent);
            });
        }
    }
    protected final static int getResourceID(final String resName, final String resType, final Context ctx) {
        final int ResourceID = ctx.getResources().getIdentifier(resName, resType, ctx.getApplicationInfo().packageName);
        if (ResourceID == 0)
        {
            throw new IllegalArgumentException
                    (
                            "No resource string found with name " + resName
                    );
        }
        else
        {
            return ResourceID;
        }
    }
}
