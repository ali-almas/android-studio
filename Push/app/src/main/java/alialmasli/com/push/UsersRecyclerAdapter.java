package alialmasli.com.push;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UsersRecyclerAdapter extends RecyclerView.Adapter<UsersRecyclerAdapter.ViewHolder>
{

    private List<Users> usersList;
    private Context context;

    public UsersRecyclerAdapter(Context context , List<Users> usersList)
    {
        this.usersList = usersList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item , parent , false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.user_name_view.setText(usersList.get(position).getName());
        CircleImageView user_image_view = holder.user_image_view;
        Glide.with(context).load(usersList.get(position).getImage()).into(user_image_view);

    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        private View mView;

        private CircleImageView user_image_view;
        private TextView user_name_view;

        public ViewHolder(View itemView) {
            super(itemView);

            mView = itemView;

            user_image_view = mView.findViewById(R.id.user_list_image);
            user_name_view = mView.findViewById(R.id.user_list_name);
        }
    }

}
