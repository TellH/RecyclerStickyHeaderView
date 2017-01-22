package tellh.com.recyclerstickyheaderview;

import android.view.View;

public interface IViewBinder<T, VH> extends LayoutItemType {
    VH provideViewHolder(View itemView);

    void bindView(StickyHeaderViewAdapter adapter, VH holder, int position, T entity);
}