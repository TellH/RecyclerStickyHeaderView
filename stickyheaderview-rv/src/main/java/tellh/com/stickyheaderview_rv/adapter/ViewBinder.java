package tellh.com.stickyheaderview_rv.adapter;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class ViewBinder<T extends IViewBinderProvider, VH extends RecyclerView.ViewHolder> implements IViewBinder<T, VH> {
    public abstract VH provideViewHolder(View itemView);

    public abstract void bindView(StickyHeaderViewAdapter adapter, VH holder, int position, T entity);

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View rootView) {
            super(rootView);
        }

        protected <T extends View> T findViewById(@IdRes int id) {
            return (T) itemView.findViewById(id);
        }
    }

}