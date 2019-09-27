package org.richit.materialofficeaboutlib.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.richit.materialofficeaboutlib.Models.Link;
import org.richit.materialofficeaboutlib.Models.Member;
import org.richit.materialofficeaboutlib.R;

import java.util.ArrayList;

public class LinksRecyclerviewAdapter extends RecyclerView.Adapter<LinksRecyclerviewAdapter.ViewHolder> {

    Context context;
    ArrayList<Link> linkArrayList;

    public LinksRecyclerviewAdapter(Context context, ArrayList<Link> linkArrayList) {
        this.context = context;
        this.linkArrayList = linkArrayList;
    }

    @NonNull
    @Override

    public LinksRecyclerviewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.office_member, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LinksRecyclerviewAdapter.ViewHolder holder, int position) {
        final Link link= linkArrayList.get(position);

    }

    @Override
    public int getItemCount() {
        return linkArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
