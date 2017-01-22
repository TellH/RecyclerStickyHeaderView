package tellh.com.recyclerstickyheaderview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by tlh on 2017/1/21 :)
 */
public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {
    private List<User> items;

    public UserListAdapter(List<User> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User item = items.get(position);
        holder.tvId.setText(String.valueOf(item.getId()));
        holder.tvName.setText(item.getLogin());
        Picasso.with(holder.ivAvatar.getContext())
                .load(item.getAvatar_url())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.ivAvatar);
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvId;
        private ImageView ivAvatar;
        private TextView tvName;

        public ViewHolder(View rootView) {
            super(rootView);
            this.tvId = (TextView) rootView.findViewById(R.id.tv_id);
            this.ivAvatar = (ImageView) rootView.findViewById(R.id.iv_avatar);
            this.tvName = (TextView) rootView.findViewById(R.id.tv_name);
        }
    }
}