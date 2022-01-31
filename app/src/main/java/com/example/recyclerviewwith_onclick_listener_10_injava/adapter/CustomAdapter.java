package com.example.recyclerviewwith_onclick_listener_10_injava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewwith_onclick_listener_10_injava.R;
import com.example.recyclerviewwith_onclick_listener_10_injava.activity.MainActivity;
import com.example.recyclerviewwith_onclick_listener_10_injava.model.Member;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private MainActivity activity;
    private List<Member> members;
    public CustomAdapter(MainActivity activity,List<Member> members){
        this.activity = activity;
        this.members = members;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_custom_layout,viewGroup,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        final Member member = members.get(position);

        if (holder instanceof CustomViewHolder) {
            LinearLayout lay_click = ((CustomViewHolder)holder).lay_click;
            TextView first_name = ((CustomViewHolder) holder).first_name;
            TextView last_name = ((CustomViewHolder) holder).last_name;

            first_name.setText(member.getFirstName());
            last_name.setText(member.getLastName());

            lay_click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.openItemDetails(member);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        public View view;
        private LinearLayout lay_click;
        public TextView first_name,last_name;

        public CustomViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            lay_click = view.findViewById(R.id.lay_click);
            first_name = view.findViewById(R.id.first_name);
            last_name = view.findViewById(R.id.last_name);
        }
    }
}
