package tellh.com.stickyheaderview_rv.adapter;

import android.support.v4.util.SparseArrayCompat;

public interface IViewBinderProvider {
    IViewBinder provideViewBinder(StickyHeaderViewAdapter adapter, SparseArrayCompat<? extends IViewBinder> viewBinderPool, int position);
}