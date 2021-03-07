package com.the_akshay.dove.addapter;

import android.content.Context;
import android.service.autofill.AutofillService;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.the_akshay.dove.R;
import com.the_akshay.dove.models.User;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Layer;
import androidx.recyclerview.widget.RecyclerView;

public class UserAddapter extends RecyclerView.Adapter<UserAddapter.ViewHolder> {

    ArrayList<User> list;
    Context context;


    public UserAddapter(ArrayList<User> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_show_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = list.get(position);
        Picasso.get().load(user.getProfilepic()).placeholder(R.drawable.ic_img).into(holder.image);
        holder.userName.setText(user.getuName());

    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView userName, lastMsg;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.SmshwImgProf);
            userName = itemView.findViewById(R.id.SmshwLblUname);
            lastMsg = itemView.findViewById(R.id.SmshwLblLstmsg);

        }
    }


}


