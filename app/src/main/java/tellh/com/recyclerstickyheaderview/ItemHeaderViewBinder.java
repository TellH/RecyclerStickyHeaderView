package tellh.com.recyclerstickyheaderview;

import android.view.View;
import android.widget.TextView;

import tellh.com.stickyheaderview_rv.adapter.StickyHeaderViewAdapter;
import tellh.com.stickyheaderview_rv.adapter.ViewBinder;

/**
 * Created by tlh on 2017/1/22 :)
 */

public class ItemHeaderViewBinder extends ViewBinder<ItemHeader, ItemHeaderViewBinder.ViewHolder> {
    private TextView tvPrefix;

    @Override
    public ViewHolder provideViewHolder(View itemView) {
        return new ViewHolder(itemView);
    }

    @Override
    public void bindView(StickyHeaderViewAdapter adapter, ViewHolder holder, int position, ItemHeader entity) {
        holder.tvPrefix.setText(entity.getPrefix());
    }

    @Override
    public int getItemLayoutId(StickyHeaderViewAdapter adapter) {
        return R.layout.header;
    }


    static class ViewHolder extends ViewBinder.ViewHolder {
        TextView tvPrefix;

        public ViewHolder(View rootView) {
            super(rootView);
            this.tvPrefix = (TextView) rootView.findViewById(R.id.tv_prefix);
        }

    }
}
