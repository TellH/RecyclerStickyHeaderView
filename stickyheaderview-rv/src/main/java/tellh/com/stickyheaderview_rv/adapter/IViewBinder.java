package tellh.com.stickyheaderview_rv.adapter;

import android.view.View;

public interface IViewBinder<T, VH> extends LayoutItemType {
    VH provideViewHolder(View itemView);

    void bindView(StickyHeaderViewAdapter adapter, VH holder, int position, T entity);
}