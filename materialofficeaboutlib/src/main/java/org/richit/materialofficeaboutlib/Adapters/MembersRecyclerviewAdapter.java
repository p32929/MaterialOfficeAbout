package org.richit.materialofficeaboutlib.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.richit.materialofficeaboutlib.Models.Member;
import org.richit.materialofficeaboutlib.R;

import java.util.ArrayList;

public class MembersRecyclerviewAdapter extends RecyclerView.Adapter<MembersRecyclerviewAdapter.ViewHolder> {

    Context context;
    ArrayList<Member> members;

    public MembersRecyclerviewAdapter(Context context, ArrayList<Member> members) {
        this.context = context;
        this.members = members;
    }

    @NonNull
    @Override

    public MembersRecyclerviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.office_member, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MembersRecyclerviewAdapter.ViewHolder holder, int position) {
        final Member member = members.get(position);
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
