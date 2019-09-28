package org.richit.materialofficeaboutlib.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.richit.materialofficeaboutlib.Models.Member;
import org.richit.materialofficeaboutlib.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

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

        Picasso.get().load(member.getImageUrl()).into(holder.circleImageView);
        holder.textViewName.setText("" + member.getName());
        holder.textViewDesignation.setText("" + member.getDesignation());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (member.getContactInfo().isEmpty()) {
                    Toast.makeText(context, "" + member.getName() + " has no contact info...", Toast.LENGTH_SHORT).show();
                } else {
                    openLink(member.getContactInfo());
                }
            }
        });
    }

    private void openLink(String urlStr) {
        Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(urlStr));
        context.startActivity(browse);
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView circleImageView;
        TextView textViewName, textViewDesignation;
        RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            circleImageView = itemView.findViewById(R.id.faceImage);
            textViewName = itemView.findViewById(R.id.nameTv);
            textViewDesignation = itemView.findViewById(R.id.descTv);
            relativeLayout = itemView.findViewById(R.id.parentItemLayout);
        }
    }
}
