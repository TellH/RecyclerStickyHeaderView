package tellh.com.recyclerstickyheaderview;

import android.support.v4.util.SparseArrayCompat;

public abstract class DataBean implements IViewBinderProvider, LayoutItemType {
    private IViewBinder viewBinder;

    @Override
    public final IViewBinder provideViewBinder(StickyHeaderViewAdapter adapter, SparseArrayCompat<? extends IViewBinder> viewBinderPool, int position) {
        if (viewBinder == null) {
            viewBinder = viewBinderPool.get(getItemLayoutId(adapter));
        }
        return viewBinder;
    }

    protected boolean shouldSticky() {
        return false;
    }
}